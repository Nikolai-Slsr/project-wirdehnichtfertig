import java.awt.*;

public abstract class Object2D {
    protected Vector2D position;

    protected Material Material;

    protected Properties Properties;

    public Object2D(Vector2D position, Material material, Properties properties) {
        this.position = position;
        Material = material;
        Properties = properties;
    }


    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public void draw(Graphics2D g2d, Vector2D camPos, float CamDist, Vector2D WindowSize){



    }

    public Material getMaterial() {
        return Material;
    }

    public void setMaterial(Material material) {
        Material = material;
    }

    public Properties getProperties() {
        return Properties;
    }

    public void setProperties(Properties properties) {
        Properties = properties;
    }
}
