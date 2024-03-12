import javax.swing.text.Position;

public class Player {
    private int[] Position = new int[2];
    private double[] Speed = new double[2];

    public Player() {
    }

    public void updatePosition(){
        Position[0] += (int)Speed[0];
        Position[1] += (int)Speed[1];
    }

    public int[] getPosition() {
        return Position;
    }

    public void setPosition(int[] position) {
        Position = position;
    }

    public double[] getSpeed() {
        return Speed;
    }

    public void setSpeed(double[] speed) {
        Speed = speed;
    }
}
