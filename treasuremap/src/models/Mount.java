package treasuremap.src.models;

public class Mount {
    private Position position;
    
    public Mount() {

    }

    public Mount(Position position) {
        this.position = position;
    }

    

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Montagne [position X=" + position.getX() +  ", position Y=" + position.getY()+ "]";
    }

    
}
