// This will store like Collision and Damage
public class Properties {
    private Vector2D Size;  // Size of an Object
    private Vector2D Hitbox = new Vector2D(16,16);

    private Boolean Collision;

    public Properties(Vector2D size, boolean collision) {     // Constructor
        Size = size;
        this.Collision = collision;
    }
    public Properties(Vector2D size,Vector2D Hitbox, boolean collision) {     // Constructor
        Size = size;
        this.Collision = collision;
        this.Hitbox = Hitbox;
    }

    // Getter and Setter Methods
    public Vector2D getSize() {
        return Size;
    }
    public void setSize(Vector2D size) {
        Size = size;
    }

    public Vector2D getHitbox() {
        return Hitbox;
    }
    public void setHitbox(Vector2D hitbox) {
        Hitbox = hitbox;
    }

    public Boolean getCollision() {return Collision;}
    public void setCollision(Boolean value) {
        Collision = value;
    }
}
