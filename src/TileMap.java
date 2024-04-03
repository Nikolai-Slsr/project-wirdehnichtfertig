import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;

public class TileMap {
    // This will Store all Tiles and the Map
    private Vector2D mapSize;
    Calc  calc = new Calc();


    private ArrayList<Tile> tileMap = new ArrayList<>();
    private final ArrayList<Tile> collisionMap = new ArrayList<>(); //Array that saves only Tiles that are relevant for Collision

    private String name = "unnamed";

    //Constructor
    public TileMap() { // Constructor
    }




    //Generators:
    /*
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
    */
    public void generateCollisionMap(){
        for(Tile tile : tileMap){
            if(tile.getProperties().getCollision()){collisionMap.add(tile);}
        }
        System.out.println(collisionMap.size());
    }


    //Methods:
    public void drawTiles(Graphics2D g2d, Vector2D camPos, float camDist, Vector2D WindowSize){
            for(Tile tile: tileMap){
                tile.draw(g2d, camPos, camDist,WindowSize);
            }
        }


    // Getter and Setter Methods
    public ArrayList<Tile> getCollisionMap() {
        return collisionMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTileMap(ArrayList<Tile> tileMap) {
        this.tileMap = tileMap;
    }

    public void addTile(Tile tile) {
        tileMap.add(tile);
    }
}
