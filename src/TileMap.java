import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class TileMap {
    // This will Store all Tiles and the Map
    private Vector2D mapSize;
    private ArrayList<ArrayList<Tile>> tileList = new ArrayList<>(); //Array that saves the whole tilemap with all it's tiles. tileList[Line][Collum]

    public TileMap(Vector2D mapSize) {
        this.mapSize = mapSize;
        generateDefaultMap();
    }

    public void generateDefaultMap(){
        for(int Line = 0; Line <= mapSize.getY(); Line++){
            tileList.add(new ArrayList<Tile>());
            for(int Collum = 0; Collum <= mapSize.getX(); Collum++){
                tileList.getLast().add(new Tile(new Vector2D(Line * 16, Collum * 16), new Material(Color.GRAY), new Properties(new Vector2D(16,16))));
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
