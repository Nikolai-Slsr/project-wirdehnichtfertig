import java.awt.*;
import java.awt.image.BufferedImage;

// This will store Texture, Material, and Color
public class Material {

    private BufferedImage image = null;
    private Color color = null;

    public Material(Color color) {
        this.color = color;
    }

    public Material(BufferedImage image) {
        this.image = image;
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public BufferedImage getImage() {
        return image;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
