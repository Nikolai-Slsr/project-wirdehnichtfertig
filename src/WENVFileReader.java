import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.awt.*;

public class WENVFileReader {

    private File file;
    private ArrayList<Material> materials = new ArrayList<>();
    private TileMap tileMap = new TileMap();
    private Player player;
    private Scanner reader;
    public WENVFileReader(File file){
        this.file = file;
        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException e){
            System.out.println("File could not be found, try changing it's path.");
        }

    }
    public void read(){
        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException e){
            System.out.println("File could not be found, try changing it's path.");
        }
        while (reader.hasNextLine()){
            String line = reader.nextLine();

            //apply file info
            if (Objects.equals(line, "#info")) {
                System.out.println("at info");
                tileMap.setName(reader.nextLine());
            }

            //materials
            else if (Objects.equals(line, "#materials")) {
                System.out.println("at mats" + line);
                line = reader.nextLine();
                while(Objects.equals(line, ">")){
                    String ID = reader.nextLine();
                    line = reader.nextLine();
                    //if mat type is an image
                    if(Objects.equals(line, "img")){

                        try {
                            String imagePath = reader.nextLine();
                            BufferedImage image = null;
                            if(!Objects.equals(imagePath, "")){
                                image = ImageIO.read(new File(imagePath));  // Path to Texture
                            }
                            materials.add(new Material(ID, image, imagePath ));
                        } catch (IOException e) {
                            throw new RuntimeException(e);  // Avoid Errors
                        }
                    //if mat type is a color
                    } else {
                        materials.add(new Material(ID, new Color(

                                Integer.parseInt(reader.nextLine()),
                                Integer.parseInt(reader.nextLine()),
                                Integer.parseInt(reader.nextLine()),
                                Integer.parseInt(reader.nextLine())
                        )));
                    }
                    line = reader.nextLine();
                }
            }
            //player
            else if (Objects.equals(line, "#player")) {
                System.out.println("at player");
                player = new Player(
                        new Vector2D(
                                Float.parseFloat(reader.nextLine()),
                                Float.parseFloat(reader.nextLine())
                        ),
                        Float.parseFloat(reader.nextLine()),
                        Float.parseFloat(reader.nextLine()),
                        Long.parseLong(reader.nextLine()),
                        tileMap
                );
            }
            //Tilemap
            else if (Objects.equals(line, "#tilemap")) {
                System.out.println("at tilemap");
                line = reader.nextLine();

                while(Objects.equals(line, ">")){

                    tileMap.addTile(new Tile(
                            new Vector2D(
                                    Float.parseFloat(reader.nextLine()) * 16f,
                                    Float.parseFloat(reader.nextLine()) * 16f
                            ),
                            searchMatByID(reader.nextLine()),
                            new Properties(new Vector2D(16,16), Boolean.parseBoolean(reader.nextLine()))
                    ));
                    line = reader.nextLine();
                }
                //line = reader.nextLine();

            }
        }
    }

    public Material searchMatByID(String ID){
        for(Material material : materials){
            if (Objects.equals(material.getID(), ID)){
                return material;
            }
        }
        return null;
    }

    //get set

    public Player getPlayer() {
        return player;
    }

    public TileMap getTileMap() {
        return tileMap;
    }

    public File getFile() {
        return file;
    }

    public ArrayList<Material> getMaterials(){
        return materials;
    }
}
