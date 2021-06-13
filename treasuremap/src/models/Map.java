package treasuremap.src.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import treasuremap.exceptions.MapException;

public class Map {
	public static Position perimeter;
	public static List<Mount> mountsList = new ArrayList<>();
	public static List<Treasure> treasuresList = new ArrayList<>();
	public static List<Explorer> explorersList = new ArrayList<>();
	HashMap<Position, Box> mapCase;
	public static Position oldPosition = new Position();

	public static void createMap() throws MapException {

		System.out.println("Carte actuelle");
		boolean found;
		for (int i = 0; i < perimeter.y; i++) {
			for (int j = 0; j < perimeter.x; j++) {
				found = false;
				for (Explorer explorer : explorersList) {
					Position explorerPosition = new Position();
					explorerPosition.setX(explorer.getPosition().getX());
					explorerPosition.setY(explorer.getPosition().getY());
					// if(getBox(explorerPosition));
					if (explorer.getPosition().getX() == j && explorer.getPosition().getY() == i) {
						for (Mount mount : mountsList) {
							if (mount.getPosition().getX() == explorer.getPosition().getX()
									&& mount.getPosition().getY() == explorer.getPosition().getY()) {
								throw new MapException("\t L'aventurier ne peut pas commencer sur une montagne");
							}
						}
						System.out.print("A(" + explorer.getName() + ")\t");
						found = true;
					}
				}
				for (Mount mount : mountsList) {
					if (mount.getPosition().getX() == j && mount.getPosition().getY() == i) {
						System.out.print("M\t");
						found = true;
					}
				}
				for (Treasure treasure : treasuresList) {
					if (treasure.getPosition().getX() == j && treasure.getPosition().getY() == i) {
						System.out.print("T(" + treasure.getTreasuresNumbers() + ")\t");
						found = true;
					}
				}
				if (found == false) {
					System.out.print(".\t");
				}
			}
			System.out.println("");
		}

	}

	public static void simulateMovement() {
		for (Explorer explorer : explorersList) {
			for (int i = 0; i < explorer.getSequence().length(); i++) {
				move(explorer, Character.toString(explorer.getSequence().charAt(i)));
			}
		}
	}

	public static void move(Explorer explorer, String direction) {
		switch (explorer.getOrientation()) {
			// Orientation NORD
			case "N":
				switch (direction) {
					// Avancer
					case "A":
						nForward(explorer);
						break;
					// Droite
					case "D":
						nRight(explorer);
						break;
					// Gauche
					case "G":
						nLeft(explorer);
						break;
					default:
						break;
				}
				break;
			case "S":
				switch (direction) {
					// Avancer
					case "A":
						sForward(explorer);
						break;
					// Droite
					case "D":
						sRight(explorer);
						break;
					// Gauche
					case "G":
						sLeft(explorer);
						break;
					default:
						break;
				}
				break;
			// Orientation EST
			case "E":
				switch (direction) {
					// Avancer
					case "A":
						eForward(explorer);
						break;
					// Droite
					case "D":
						eRight(explorer);
						break;
					// Gauche
					case "G":
						eLeft(explorer);
						break;
					default:
						break;
				}
				break;
			// Orientation OUEST
			case "O":
				switch (direction) {
					// Avancer
					case "A":
						wForward(explorer);
						break;
					// Droite
					case "D":
						wRight(explorer);
						break;
					// Gauche
					case "G":
						wLeft(explorer);
						break;
					default:
						break;
				}
				break;
			default:
				break;

		}
	}

	// SOUTH
	private static void sForward(Explorer explorer) {
		boolean mountFound = false;
		if (explorer.getPosition().getY() + 1 < perimeter.y) {
			for (Mount mount : mountsList) {
				if (mount.getPosition().getX() == explorer.getPosition().getX()
						&& mount.getPosition().getY() == explorer.getPosition().getY() + 1) {
					mountFound(mount);
					mountFound = true;
				}
			}
			if (mountFound == false && oldPosition != explorer.getPosition())
				explore(explorer.getPosition().getY() + 1, explorer.getPosition().getX(), explorer);
			oldPosition.setX(explorer.getPosition().getX());
			oldPosition.setY(explorer.getPosition().getY());
		}
	}

	private static void sRight(Explorer explorer) {
		boolean mountFound = false;
		if (explorer.getPosition().getX() + 1 < perimeter.x) {
			for (Mount mount : mountsList) {
				if (mount.getPosition().getX() == explorer.getPosition().getX() + 1
						&& mount.getPosition().getY() == explorer.getPosition().getY()) {
					mountFound(mount);
					mountFound = true;
				}
			}
			if (mountFound == false && oldPosition != explorer.getPosition())
				explore(explorer.getPosition().getY(), explorer.getPosition().getX() + 1, explorer);

			oldPosition.setX(explorer.getPosition().getX());
			oldPosition.setY(explorer.getPosition().getY());
		}
	}

	private static void sLeft(Explorer explorer) {
		boolean mountFound = false;
		if (explorer.getPosition().getX() - 1 >= 0) {
			for (Mount mount : mountsList) {
				if (mount.getPosition().getX() == explorer.getPosition().getX() - 1
						&& mount.getPosition().getY() == explorer.getPosition().getY()) {
					mountFound(mount);
					mountFound = true;
				}
			}
			if (mountFound == false && oldPosition != explorer.getPosition())
				explore(explorer.getPosition().getY(), explorer.getPosition().getX() - 1, explorer);
			oldPosition.setX(explorer.getPosition().getX());
			oldPosition.setY(explorer.getPosition().getY());
		}
	}

	// NORTH
	private static void nForward(Explorer explorer) {
		boolean mountFound = false;
		if (explorer.getPosition().getY() - 1 >= 0) {
			for (Mount mount : mountsList) {
				if (mount.getPosition().getX() == explorer.getPosition().getX()
						&& mount.getPosition().getY() == explorer.getPosition().getY() - 1) {
					mountFound(mount);
					mountFound = true;
				}
			}
			if (mountFound == false && oldPosition != explorer.getPosition())
				explore(explorer.getPosition().getY() - 1, explorer.getPosition().getX(), explorer);
				oldPosition.setX(explorer.getPosition().getX());
				oldPosition.setY(explorer.getPosition().getY());
		}
	}

	private static void nRight(Explorer explorer) {
		boolean mountFound = false;
		if (explorer.getPosition().getX() + 1 < perimeter.x) {
			for (Mount mount : mountsList) {
				if (mount.getPosition().getX() == explorer.getPosition().getX() + 1
						&& mount.getPosition().getY() == explorer.getPosition().getY()) {
					mountFound(mount);
					mountFound = true;

				}
			}
			if (mountFound == false && oldPosition != explorer.getPosition())
				explore(explorer.getPosition().getY(), explorer.getPosition().getX() + 1, explorer);
				oldPosition.setX(explorer.getPosition().getX());
				oldPosition.setY(explorer.getPosition().getY());
		}
	}

	private static void nLeft(Explorer explorer) {
		boolean mountFound = false;
		if (explorer.getPosition().getX() - 1 >= 0) {
			for (Mount mount : mountsList) {
				if (mount.getPosition().getX() == explorer.getPosition().getX() - 1
						&& mount.getPosition().getY() == explorer.getPosition().getY()) {
					mountFound(mount);
					mountFound = true;
				}
			}
			if (mountFound == false && oldPosition != explorer.getPosition())
				explore(explorer.getPosition().getY() , explorer.getPosition().getX() - 1 , explorer);
				oldPosition.setX(explorer.getPosition().getX());
				oldPosition.setY(explorer.getPosition().getY());
		}
	}

	// WEST
	private static void wForward(Explorer explorer) {
		boolean mountFound = false;
		if (explorer.getPosition().getX() - 1 >= 0) {
			for (Mount mount : mountsList) {
				if (mount.getPosition().getX() == explorer.getPosition().getX() - 1
						&& mount.getPosition().getY() == explorer.getPosition().getY()) {
					mountFound = true;
					mountFound(mount);
				}
			}
			if (mountFound == false && oldPosition != explorer.getPosition())
				explore(explorer.getPosition().getY(), explorer.getPosition().getX() - 1, explorer);
				oldPosition.setX(explorer.getPosition().getX());
				oldPosition.setY(explorer.getPosition().getY());
		}
	}

	private static void wRight(Explorer explorer) {
		boolean mountFound = false;
		if (explorer.getPosition().getY() - 1 >= 0) {
			for (Mount mount : mountsList) {
				if (mount.getPosition().getX() == explorer.getPosition().getX()
						&& mount.getPosition().getY() == explorer.getPosition().getY() - 1) {
					mountFound = true;
					mountFound(mount);
				}
			}
			if (mountFound == false && oldPosition != explorer.getPosition())
				explore(explorer.getPosition().getY() - 1, explorer.getPosition().getX(), explorer);
				oldPosition.setX(explorer.getPosition().getX());
				oldPosition.setY(explorer.getPosition().getY());
		}
	}

	private static void wLeft(Explorer explorer) {
		boolean mountFound = false;
		if (explorer.getPosition().getY() + 1 < perimeter.y) {
			for (Mount mount : mountsList) {
				if (mount.getPosition().getX() == explorer.getPosition().getX()
						&& mount.getPosition().getY() == explorer.getPosition().getY() + 1) {
					mountFound = true;
					mountFound(mount);
				}
			}
			if (mountFound == false && oldPosition != explorer.getPosition())
				explore(explorer.getPosition().getY() + 1, explorer.getPosition().getX(), explorer);
				oldPosition.setX(explorer.getPosition().getX());
				oldPosition.setY(explorer.getPosition().getY());
		}

	}

	// EAST
	private static void eForward(Explorer explorer) {
		boolean mountFound = false;
		if (explorer.getPosition().getX() + 1 < perimeter.x) {
			for (Mount mount : mountsList) {
				if (mount.getPosition().getX() == explorer.getPosition().getX() + 1
						&& mount.getPosition().getY() == explorer.getPosition().getY()) {
					mountFound(mount);
					mountFound = true;
				}
			}
			if (mountFound == false && oldPosition != explorer.getPosition())
				explore(explorer.getPosition().getY(), explorer.getPosition().getX() + 1, explorer);
				oldPosition.setX(explorer.getPosition().getX());
				oldPosition.setY(explorer.getPosition().getY());
		}
	}

	private static void eRight(Explorer explorer) {
		boolean mountFound = false;
		if (explorer.getPosition().getY() + 1 >= 0) {
			for (Mount mount : mountsList) {
				if (mount.getPosition().getX() == explorer.getPosition().getX()
						&& mount.getPosition().getY() == explorer.getPosition().getY() + 1) {
					mountFound(mount);
					mountFound = true;
				}
			}
			if (mountFound == false && oldPosition != explorer.getPosition())
				explore(explorer.getPosition().getY() + 1, explorer.getPosition().getX(), explorer);
				oldPosition.setX(explorer.getPosition().getX());
				oldPosition.setY(explorer.getPosition().getY());
		}
	}

	private static void eLeft(Explorer explorer) {
		boolean mountFound = false;
		if (explorer.getPosition().getY() - 1 >= 0) {
			for (Mount mount : mountsList) {
				if (mount.getPosition().getX() == explorer.getPosition().getX()
						&& mount.getPosition().getY() == explorer.getPosition().getY() - 1) {
					mountFound(mount);
					mountFound = true;
				}
			}
			if (mountFound == false && oldPosition != explorer.getPosition())
				explore(explorer.getPosition().getY() - 1, explorer.getPosition().getX(), explorer);
				oldPosition.setX(explorer.getPosition().getX());
				oldPosition.setY(explorer.getPosition().getY());
		}
	}

	private static void explore(int y, int x, Explorer explorer) {
		Position position = new Position();

		for (Treasure treasure : treasuresList) {

			if (treasure.getPosition().getY() == y && treasure.getPosition().getX() == x
					&& treasure.getTreasuresLeft() > 0) {

				treasure.setTreasuresLeft(treasure.getTreasuresLeft() - 1);

				explorer.pickUp(treasure);

			}
		}
		position.setX(x);
		position.setY(y);

		explorer.setPosition(position);

	}

	public static void majMap() {

		System.out.println("Carte mise à jour");
		boolean found;
		for (int i = 0; i < perimeter.y; i++) {
			for (int j = 0; j < perimeter.x; j++) {
				found = false;
				for (Explorer explorer : explorersList) {
					if (explorer.getPosition().getX() == j && explorer.getPosition().getY() == i) {
						System.out.print("A(" + explorer.getName() + ")\t");
						found = true;
					}
				}
				for (Mount mount : mountsList) {
					if (mount.getPosition().getX() == j && mount.getPosition().getY() == i) {
						System.out.print("M\t");
						found = true;
					}
				}
				for (Treasure treasure : treasuresList) {
					if (treasure.getPosition().getX() == j && treasure.getPosition().getY() == i) {
						for (Explorer explorer : explorersList) {
							if (treasure.getPosition().getX() == explorer.getPosition().getX()
									&& treasure.getPosition().getY() == explorer.getPosition().getY()) {

							} else {
								System.out.print(
									"T(" + ( treasure.getTreasuresLeft()) + ")\t");
							}
						}
						found = true;
					}
				}
				if (found == false) {
					System.out.print(".\t");
				}
			}
			System.out.println("");
		}

	}

	// public static boolean getBox(Position position) throws MapException {
	// Position limitPos = new Position(0, 0);
	// if (position.isGreaterThan(limitPos) || position.isLesserThan(limitPos)) {
	// throw new MapException("La position est hors limite !");
	// }
	// return true;
	// }

	public static void mountFound(Mount mount) {
		System.out.println(
				"MONTAGNE LOCALISEE : " + " M - " + mount.getPosition().getX() + " - " + mount.getPosition().getY());
	}

}
