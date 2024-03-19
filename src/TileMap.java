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
    }

    public void generateDefaultMap(){
        for(int Line = 0; Line < mapSize.getY(); Line++){
            tileList.add(new ArrayList<Tile>());
            for(int Collum = 0; Collum < mapSize.getX(); Collum++){
                if (Collum == 0 || Line == 0){tileList.getLast().add(new Tile(new Vector2D(Line * 16, Collum * 16), new Material(Color.GRAY, dirt), new Properties(new Vector2D(16, 16))));}
                else {
                    tileList.getLast().add(new Tile(new Vector2D(Line * 16, Collum * 16), new Material(Color.GRAY, grass), new Properties(new Vector2D(16, 16))));
                }
            }
        }

    }
    public void drawTiles(Graphics2D g2d, Vector2D camPos, float camDist, Vector2D WindowSize){
        for(ArrayList<Tile> Line: tileList){
            for(Tile tile : Line){
                tile.draw(g2d, camPos, camDist,WindowSize);
            }
        }

    }
}
