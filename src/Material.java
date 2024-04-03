import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// This will store Texture, Material, and Color
public class Material {

    // Attributes
    private String ID;
    private BufferedImage texture = null;
    private String imagePath = null;
    private Color color = null;

    public Material(String ID, Color color) { // Constructor
        this.ID = ID;
        this.color = color;
    } // Constructor
    public Material(String ID, BufferedImage texture, String imagePath) { // Constructor
        this.ID = ID;
        this.texture = texture;
        this.imagePath = imagePath;
    } // Constructor


    // Getter and Setter Methods
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

}
