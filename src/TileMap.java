import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class TileMap {
    // This will Store all Tiles and the Map
    private Vector2D mapSize;

    private BufferedImage grass;
    private BufferedImage dirt;

    Calc  calc = new Calc();
    private ArrayList<ArrayList<Tile>> tileList = new ArrayList<>(); //Array that saves the whole tilemap with all it's tiles. tileList[Line][Collum]
    private ArrayList<Tile> collisionMap = new ArrayList<>(); //Array that saves only Tiles that are relevant for Collision


    //Constructor
    public TileMap(Vector2D mapSize) { // Constructor
        this.mapSize = mapSize;
        {
            try {
                dirt = ImageIO.read(new File("Textures/Tiles/Dirt.png"));  // Path to Texture
                grass = ImageIO.read(new File("Textures/Tiles/grass1.png"));  // Path to Texture
            } catch (IOException e) {
                throw new RuntimeException(e);  // Avoid Errors
            }
        }
        generateDefaultMap();
        generateCollisionMap();
    }




    //Generators:
    public void generateDefaultMap(){
        for(int Line = 0; Line < mapSize.getY(); Line++){
            tileList.add(new ArrayList<Tile>());
            for(int Collum = 0; Collum < mapSize.getX(); Collum++){
                if (Collum == 0 || Line == 0 || Collum == mapSize.getX() - 1 || Line == mapSize.getY() - 1){tileList.getLast().add(new Tile(new Vector2D(Line * 16, Collum * 16), new Material(Color.GRAY, dirt), new Properties(new Vector2D(16, 16),true)));}
                else {
                    tileList.getLast().add(new Tile(new Vector2D(Line * 16, Collum * 16), new Material(Color.GRAY, grass), new Properties(new Vector2D(16, 16), false)));
                }
            }
        }

    }
    public void generateCollisionMap(){
        for(ArrayList<Tile> Line: tileList){
            for(Tile tile : Line){
                if(tile.getProperties().getCollision()){collisionMap.add(tile);}
            }
        }
        System.out.println(collisionMap.size());

    }


    //Methods:
    public void drawTiles(Graphics2D g2d, Vector2D camPos, float camDist, Vector2D WindowSize){
            for(ArrayList<Tile> Line: tileList){
               for(Tile tile : Line){
                   tile.draw(g2d, camPos, camDist,WindowSize);
               }
            }
        }


    // Getter and Setter Methods
    public ArrayList<Tile> getCollisionMap() {
        return collisionMap;
    }

}
