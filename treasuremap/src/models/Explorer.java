package treasuremap.src.models;

/**
 * Modèle aventurier
 */

public class Explorer {

    private String name; // Nom de l'aventurier
    private Position position; // Position de l'aventurier
    private String orientation; // Direction de l'aventurier
    private String sequence; // Séquence des mouvements
    private int explorersTreasure = 0; // Nombre de trésors de l'aventurier

    public Explorer() {
    }

    public Explorer(String name, Position position, String orientation, String sequence) {
        this.name = name;
        this.position = position;
        this.orientation = orientation;
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public int getExplorersTreasure() {
        return explorersTreasure;
    }

    public void setExplorersTreasure(int explorersTreasure) {
        this.explorersTreasure = explorersTreasure;
    }

    public void pickUp(Treasure treasure) { // Ramasser trésor
        this.explorersTreasure++;
    }

    @Override
    public String toString() {
        return "Explorer [nombre de trésors=" + explorersTreasure + ", nom=" + name + ", orientation=" + orientation
                + ", position X=" + position.getX() + ", position Y=" + position.getY() + ", sequence=" + sequence
                + "]";
    }

}
