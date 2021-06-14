package treasuremap.src.models;

/**
 * Modèle Position
 */
public class Position  {
    public int x; // Horizontal
    public int y; // Vertical

    public Position() {
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Position other = (Position) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    // @Override
	// public int compareTo(Object other) {
	// 	if(other instanceof Position){
	// 		if(this.x > ((Position)other).getX()
	// 				|| this.y > ((Position)other).getY()) {
	// 			return 1;
	// 		}else if (this.x == ((Position)other).getX() 
	// 				&& this.y == ((Position)other).getY()){
	// 			return 0;
	// 		}
	// 	}
	// 	return -1;
	// }

    // public boolean isGreaterThan(Position otherPosition){
	// 	return this.compareTo(otherPosition) > 0;
	// }

	// public boolean isLesserThan(Position otherPosition){
	// 	return this.compareTo(otherPosition) < 0;
	// }
    

}