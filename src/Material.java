import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// This will store Texture, Material, and Color
public class Material {

    private final BufferedImage grass;

    {
        try {
            grass = ImageIO.read(new File("Textures/Tiles/Grass.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private Color color = null;

    public Material(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public BufferedImage getGrass() {
        return grass;
    }
}
