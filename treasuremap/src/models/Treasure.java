package treasuremap.src.models;

public class Treasure {
    private Position position;
    private int treasuresNumbers;
    private int treasuresLeft;

    public Treasure(){}


    public Treasure(Position position, int treasuresNumbers) {
        this.position = position;
        this.treasuresNumbers = treasuresNumbers;
    }


    

    public Position getPosition() {
        return position;
    }


    public void setPosition(Position position) {
        this.position = position;
    }


    public int getTreasuresNumbers() {
        return treasuresNumbers;
    }

    public void setTreasuresNumbers(int treasuresNumbers) {
        this.treasuresNumbers = treasuresNumbers;
    }

    public int getTreasuresLeft() {
        return treasuresLeft;
    }

    public void setTreasuresLeft(int treasuresLeft) {
        this.treasuresLeft = treasuresLeft;
    }


    @Override
    public String toString() {
        return "Trésor [position X =" + position.getX() + "position Y =" + position.getY() + ", Trésors restants=" + treasuresLeft + ", nombre de trésors="
                + treasuresNumbers + "]";
    }

    
}
