public class Particle extends Object2D{
    private Vector2D size;
    private Vector2D velocity;
    public Particle(Vector2D position, Vector2D size, Material material, Properties properties){
        super(position,material,properties);
        this.size = size;
    }

    public Vector2D getSize() {
        return size;
    }

    public void setSize(Vector2D size) {
        this.size = size;
    }
}
