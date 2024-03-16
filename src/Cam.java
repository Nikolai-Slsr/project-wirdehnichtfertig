import java.awt.*;
import java.util.*;
public class Cam {
    private Vector2D Position; // Global Position of Player Index 0 = x Index 1 = y
    private Vector2D Acceleration = new Vector2D(0,0); // Acceleration of the Cam Index 0 = x Index 1 = y
    private Vector2D Speed = new Vector2D(0,0);// Speed of the Cam Index 0 = x Index 1 = y

    private final Calc calc = new Calc();

    private float CamDist;
    private float mass = 1; // mass of the Cam -- How sluggish/quick  - The Bigger Mass the heavier the Camera Movement feels

    public Cam( Vector2D position, float mass, float CamDist) { // Constructor
        this.Position = position;
        this.mass = mass;
        this.CamDist = CamDist;
    }

    public void update(Vector2D PlayerPos){ // Update Physics
        Vector2D Force = calc.subVec2D(Position,PlayerPos); // Calculate Distance to Player and convert to a Force pointing to the player
        Acceleration.setXY((float)Math.pow(PlayerPos.getX(),2) * mass,(float)Math.pow(PlayerPos.getY(), 2) * mass); // Update Acceleration

        Speed.setXY(Speed.getX() + Acceleration.getX() * 0.01f, Speed.getY() + Acceleration.getY() * 0.01f); // Update Speed this is dependent on the delta Time 0,01 s == 10 ms

        //Position.setXY(Position.getX() + Speed.getX(), Position.getY() + Speed.getY());// Update Position
        Position.setXY(PlayerPos);
    }
    public void reset(){  // Reset Momentum
        Acceleration.setXY(0,0);
        Speed.setXY(0,0);

    }
    // Getter and Setter Methods

    public float getMass() {
        return mass;
    }
    public void setMass(int mass) {
        this.mass = mass;
    }

    public Vector2D getPosition() {
        return Position;
    }
    public void setPosition(Vector2D position) {
        Position = position;
    }

    public Vector2D getSpeed() {
        return Speed;
    }
    public void setSpeed(Vector2D speed) {
        Speed = speed;
    }

    public Vector2D getAcceleration() {
        return Acceleration;
    }
    public void setAcceleration(Vector2D acceleration) {
        Acceleration = acceleration;
    }

    public float getCamDist() {
        return CamDist;
    }

    public void setCamDist(float camDist) {
        CamDist = camDist;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }
}
