import java.awt.*;
import java.util.*;
public class Cam {
    private Vector2D Position; // Global Position of Player Index 0 = x Index 1 = y
    private Vector2D Acceleration; // Acceleration of the Cam Index 0 = x Index 1 = y
    private Vector2D Speed; // Speed of the Cam Index 0 = x Index 1 = y
    private float mass = 1; // mass of the Cam -- How sluggish/quick  - The Bigger Mass the heavier the Camera Movement feels

    public Cam( Vector2D position, float mass) { // Constructor
        this.Position = position;
        this.mass = mass;
    }

    /*public void update(int[] PlayerPos){ // Update Physics
        int[] Force = new int[]{PlayerPos[0]-Position.x,PlayerPos´´.y -Position.y}; // Calculate Distance to Player and convert to a Force pointing to the player
        Acceleration.x = Math.pow(Force[0],2) * mass; // Update Acceleration
        Acceleration.x = Math.pow(Force[1],2) * mass;
        Speed.x = Speed.getX() + (int)Acceleration.getX() * 0.01; // Update Speed this is dependent on the delta Time 0,01 s == 10 ms
        Speed.y = (int)(Speed.getY() + Acceleration.getY() * 0.01);
        Position.x = (int)Position.getX() + (int)Speed.getX(); // Update Position
        Position.y = (int)Position.getY() + (int)Speed.getY();
    }
    */
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
}
