package treasuremap.src.models;

/**
 * Modèle montagne
 */
public class Mount {
    private Position position; // Position de la montagne
    
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
