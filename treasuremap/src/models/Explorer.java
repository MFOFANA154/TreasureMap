package treasuremap.src.models;


public class Explorer {
    private String name;
    private Position position;
    private String orientation;
    private String sequence;
    private int explorersTreasure = 0;

    public Explorer(){}

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

    public void pickUp(Treasure treasure){
        this.explorersTreasure++;
    }

    @Override
    public String toString() {
        return "Explorer [nombre de trésors=" + explorersTreasure + ", nom=" + name + ", orientation=" + orientation
                + ", position X=" + position.getX() + ", position Y=" + position.getY() + ", sequence=" + sequence + "]";
    }

    

}
