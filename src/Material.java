import java.awt.*;

// This will store Texture, Material, and Color
public class Material {
    private Color color;

    public Material(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
