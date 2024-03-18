// This will store like Collision and Damage
public class Properties {
    private Vector2D Size;  // Size of an Object

    public Properties(Vector2D size) {
        Size = size;
    } // Constructor

    // Getter and Setter Methods
    public Vector2D getSize() {
        return Size;
    }

    public void setSize(Vector2D size) {
        Size = size;
    }
}
