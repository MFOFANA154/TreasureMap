package treasuremap.src.application;

import treasuremap.exceptions.MapException;
import treasuremap.src.Utils.FileIO;
import treasuremap.src.models.Map;

public class Main {
    
    public static void main(String[] args) throws MapException{

        FileIO fileIO = new FileIO();

        fileIO.readFileForMap();

        Map.createMap();

        Map.simulateMovement();

        fileIO.writeFileForMap();

        Map.majMap();
    }
}