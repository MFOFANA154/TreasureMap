package treasuremap.src.models;

/**
 * Modèle Case
 */
public class Box {

    public final Position position; // Coordonnées de la case

    public Box(Position position){
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

}
