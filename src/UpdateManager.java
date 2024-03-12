import java.awt.*;

public class UpdateManager {

    //Attributes:
    private Player Player1;
    private Cam Camera1;

    private Graphics2D g2d;

    //Constructor:
    public UpdateManager() {
        Player1 = new Player();
        //Camera1 = new Cam(new Point(0,0) , 1);
    }


    public void update(Graphics2D g2d){
        this.g2d = g2d;
        updatePlayer();


    }
    public void updatePlayer(){
        Player1.updatePosition();
        int [] PlayerPos = Player1.getPosition();
        g2d.setColor(Color.BLUE);
        g2d.fillRect(PlayerPos[0],PlayerPos[1],20,20);

    }
    public void wPressed(){
        double[] currentSpeed = Player1.getSpeed();
        double[] Speed = new double[]{1,currentSpeed[1]};
        Player1.setSpeed(Speed);

    }
    public void sPressed(){
        double[] currentSpeed = Player1.getSpeed();
        double[] Speed = new double[]{-1,currentSpeed[1]};
        Player1.setSpeed(Speed);
        System.out.println("Update Speed");
    }
    public void aPressed(){
        double[] currentSpeed = Player1.getSpeed();
        double[] Speed = new double[]{currentSpeed[0],-1};
        Player1.setSpeed(Speed);

    }
    public void dPressed(){
        double[] currentSpeed = Player1.getSpeed();
        double[] Speed = new double[]{currentSpeed[0],1};
        Player1.setSpeed(Speed);

    }


    public Player getPlayer1() {
        return Player1;
    }

    public void setPlayer1(Player player1) {
        Player1 = player1;
    }

    public Cam getCamera1() {
        return Camera1;
    }

    public void setCamera1(Cam camera1) {
        Camera1 = camera1;
    }

    public void setG2d(Graphics2D g2d) {
        this.g2d = g2d;
    }
}
