import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// This will store Texture, Material, and Color
public class Material {
    // Attributes
    private final BufferedImage texture;
    private Color color = null;

    public Material(Color color, BufferedImage texture) { // Constructor
        this.color = color;
        this.texture = texture;

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
}
