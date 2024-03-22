// This will store like Collision and Damage
public class Properties {
    private Vector2D Size;  // Size of an Object


    private Boolean Collision;

    public Properties(Vector2D size, boolean collision) {     // Constructor
        Size = size;
        this.Collision = collision;
    }

    // Getter and Setter Methods
    public Vector2D getSize() {
        return Size;
    }

    public void setSize(Vector2D size) {
        Size = size;
    }
    public Boolean getCollision() {return Collision;}

}
