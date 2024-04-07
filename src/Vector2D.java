// Vector2D implements the mathematical Vector class in a two dimensional system.
// Uses class "Calc" for simple vector calculations.

public class Vector2D {
    //Attributes
    private float x;
    private float y;

    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    //get & set methods

    /** returns the X value of a Vector2D. */
    public float getX() {
        return x;
    }
    /** returns the Y value of a Vector2D. */
    public float getY() {
        return y;
    }

    /** Sets the X value of a Vector2D to some float value.*/
    public void setX(float x) {
        this.x = x;
    }
    /** Sets the Y value of a Vector2D to some float value.*/
    public void setY(float y) {
        this.y = y;
    }
    /** Sets both the X and Y value of a Vector2D to some float values.*/
    public void setXY(float x, float y) {this.x = x; this.y = y;}
    /** Sets both the X and Y value of a Vector2D to those of another vector.*/
    public void setXY(Vector2D vector2d) {this.x = vector2d.getX(); this.y = vector2d.getY();}

    /** Compares this with another vector2D*/
    public boolean is(Vector2D vector2D) {
        return (this.x == vector2D.getX() && this.y == vector2D.getY());
    }
}
