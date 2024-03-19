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

    public void update(Vector2D PlayerPos, long dT){ // Update Physics
        Vector2D Force = calc.subVec2D(PlayerPos,Position);  // Calculate Force from the Cam to the Player
        if (Force.getX()<10 && Force.getX()>-10){Speed.setX(Speed.getX() / 2); Force.setX(1);}       // Dampen Speed near Player to avoid jittering
        if (Force.getY()<10 && Force.getY()>-10){Speed.setY(Speed.getY() / 2); Force.setY(1);}
        if (Speed.getX()<10 && Speed.getX()>(-10)){Speed.setX(0);}      // When Seed to slow set it to 0
        if (Speed.getY()<10 && Speed.getY()>(-10)){Speed.setY(0);}
        Force.setXY((float)(Math.pow(Force.getX(),3)*0.01 * dT),(float)(Math.pow(Force.getY(),3)*0.01 * dT));// Calculate Distance to Player and convert to a Force pointing to the player
        float a = 0.0001f;
        float b = 0.0001f;


        //Calc Accel by Force with following formular: a*(x/√(x^2)) * (b^-x^2 + 1)
        //Force.setXY((float)( a * (Force.getX() / Math.sqrt(Force.getX() * Force.getX())) * (Math.pow(b,- Math.pow(Force.getX(), 2) ) + 1) ), (float)( a * (Force.getY() / Math.sqrt(Force.getY() * Force.getY())) * (Math.pow(b,- Math.pow(Force.getY(), 2) ) + 1) ) );
        Acceleration.setXY((float)Force.getX() / mass,(float)Force.getY() / mass); // Update Acceleration
        Speed.setXY(Speed.getX() + Acceleration.getX() * 0.01f, Speed.getY() + Acceleration.getY() * 0.01f); // Update Speed this is dependent on the delta Time 0,01 s == 10 ms

        Position.setXY(Position.getX() + Speed.getX(), Position.getY() + Speed.getY());// Update Position
        //Position.setXY(PlayerPos);
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
