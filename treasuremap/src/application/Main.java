package treasuremap.src.application;

import treasuremap.exceptions.MapException;
import treasuremap.src.Utils.FileIO;
import treasuremap.src.models.Map;

public class Main {
    
    public static void main(String[] args) throws MapException{

        FileIO fileIO = new FileIO();

        //Lecture du ficheir d'entrée
        fileIO.readFileForMap();

        //Création de la carte
        Map.createMap();

        //Simulation des mouvements
        Map.simulateMovement();

        // Ecriture du fichier de sortie
        fileIO.writeFileForMap();

        //Mise à jour de la carte
        Map.majMap();
    }
}