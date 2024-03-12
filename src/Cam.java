import java.util.*;
public class Cam {
    private Player Player1;
    private int[] Position = new int[2];
    private double[] Accerleration = new double[2];
    private double[] Speed = new double[2];
    int mass = 1;

    public Cam(Player player1, int[] position, int mass) {
        Player1 = player1;
        Position = position;
        this.mass = mass;
    }

    public void update(int[] PlayerPos){
        int[] Force = new int[]{PlayerPos[0]-Position[0],PlayerPos[1]-Position[1]};
        Accerleration[0] = Math.pow(Force[0],2) * mass;
        Accerleration[1] = Math.pow(Force[1],2) * mass;
        Position[0] = (int)Accerleration[0] * 10;
        Position[1] = (int)Accerleration[1] * 10;
    }
}
