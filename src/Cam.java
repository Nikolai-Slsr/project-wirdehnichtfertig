import java.util.*;
public class Cam {
    private Player Player1; //reference to player
    private int[] Position = new int[2]; // Global Position of Player Index 0 = x Index 1 = y
    private double[] Acceleration = new double[2]; // Acceleration of the Cam Index 0 = x Index 1 = y
    private double[] Speed = new double[2]; // Speed of the Cam Index 0 = x Index 1 = y
    int mass = 1; // mass of the Cam How sluggish/quick  - The Bigger Mass the heavier the Camera Movement feels

    public Cam(Player player1, int[] position, int mass) { // Constructor
        Player1 = player1;
        Position = position;
        this.mass = mass;
    }

    public void update(int[] PlayerPos){ // Update Physics
        int[] Force = new int[]{PlayerPos[0]-Position[0],PlayerPos[1]-Position[1]}; // Calculate Distance to Player and convert to a Force pointing to the player
        Acceleration[0] = Math.pow(Force[0],2) * mass; // Update Acceleration
        Acceleration[1] = Math.pow(Force[1],2) * mass;
        Speed[0] = Speed[0] + (int)Acceleration[0] * 0.01; // Update Speed this is dependent on the delta Time 0,01 s == 10 ms
        Speed[1] = Speed[1] + (int)Acceleration[1] * 0.01;
        Position[0] = Position[0] + (int)Speed[0]; // Update Position
        Position[1] = Position[1] + (int)Speed[1];
    }
    public void reset(){  // Reset Momentum
        Acceleration[0] = 0;
        Acceleration[1] = 0;
        Speed[0] = 0;
        Speed[1] = 0;

    }
    // Getter and Setter Methods
    public int[] getPosition() {
        return Position;
    }

    public void setPosition(int[] position) {
        Position = position;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }
}
