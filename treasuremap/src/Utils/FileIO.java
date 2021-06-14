package treasuremap.src.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import treasuremap.src.models.Explorer;
import treasuremap.src.models.Map;
import treasuremap.src.models.Mount;
import treasuremap.src.models.Position;
import treasuremap.src.models.Treasure;

/**
 * Gestion de la lecture et de l'écriture du fichier
 */

public class FileIO {

    /**
     * Lecture du fichier d'entrée
     */
    public void readFileForMap() {

        try {
            // Le fichier d'entrée
            File file = new File("\\TreasureMap\\treasuremap\\src\\resources\\simulationIN.txt");
            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line = "";
            String trim = "";
            String[] trimExplorer;
            while ((line = br.readLine()) != null) {
                trim = line.replaceAll("\s", "");
                trimExplorer = trim.split("-");
                trim = trim.replaceAll("-", "");
                Position position = new Position();

                if (line.charAt(0) != '#') {
                    String letter = Character.toString(Character.toUpperCase(line.charAt(0)));
                    switch (letter) {
                        case "C":
                            position.setX(Integer.parseInt(Character.toString(trim.charAt(1))));
                            position.setY(Integer.parseInt(Character.toString(trim.charAt(2))));

                            Map.perimeter = position;

                            break;
                        case "M":

                            Mount mount = new Mount();

                            position.setX(Integer.parseInt(Character.toString(trim.charAt(1))));
                            position.setY(Integer.parseInt(Character.toString(trim.charAt(2))));

                            mount.setPosition(position);
                            Map.mountsList.add(mount);
                            break;
                        case "T":

                            Treasure treasure = new Treasure();

                            position.setX(Integer.parseInt(Character.toString(trim.charAt(1))));
                            position.setY(Integer.parseInt(Character.toString(trim.charAt(2))));

                            treasure.setTreasuresNumbers(Integer.parseInt(Character.toString(trim.charAt(3))));
                            treasure.setTreasuresLeft(Integer.parseInt(Character.toString(trim.charAt(3))));

                            treasure.setPosition(position);
                            Map.treasuresList.add(treasure);
                            break;
                        case "A":

                            Explorer explorer = new Explorer();

                            explorer.setName(trimExplorer[1]);

                            position.setX(Integer.parseInt(trimExplorer[2]));
                            position.setY(Integer.parseInt(trimExplorer[3]));
                            explorer.setPosition(position);
                            explorer.setOrientation(trimExplorer[4]);
                            explorer.setSequence(trimExplorer[5]);

                            Map.explorersList.add(explorer);
                            break;
                        default:
                            System.out.println(
                                    "La lettre indiqué sur la ligne ne correspond pas aux lettres attendues. C, M; T ou A est attendue !");
                            break;
                    }
                }

                // ajoute la ligne au buffer
                sb.append(trim);
                sb.append("\n");

            }

            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ecriture du fichier de sortie
     */
    public void writeFileForMap() {

        try {
            FileWriter myWriter = new FileWriter("\\TreasureMap\\treasuremap\\src\\resources\\simulationOUT.txt");
            myWriter.write("C - " + Map.perimeter.x + " - " + Map.perimeter.y + "\n");

            myWriter.write("# {M comme Montagne} - {Axe horizontal} - {Axe vertical}" + "\n");

            for (Mount mount : Map.mountsList) {
                myWriter.write("M - " + mount.getPosition().getX() + " - " + mount.getPosition().getY() + "\n");
            }

            myWriter.write("# {T comme Trésor} - {Axe horizontal} - {Axe vertical} - {Trésors restants}\n");
            for (Treasure treasure : Map.treasuresList) {
                if(treasure.getTreasuresLeft() >  0 )
                myWriter.write("T - " + treasure.getPosition().getX() + " - " + treasure.getPosition().getY() + " - "
                        + (treasure.getTreasuresLeft()) + "\n");
            }

            myWriter.write(
                    "# {A comme Aventurier} - {Nom de l’aventurier} - {Axe horizontal} - {Axe vertical} - {Orientation} - {Nb. trésors ramassés}\n");

            for (Explorer explorer : Map.explorersList) {
                myWriter.write("A - " + explorer.getName() + " - " + explorer.getPosition().getX() + " - "
                        + explorer.getPosition().getY() + " - " + explorer.getOrientation() +  " - " + explorer.getExplorersTreasure() + "\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
