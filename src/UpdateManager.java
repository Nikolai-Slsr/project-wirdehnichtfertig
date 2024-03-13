import java.awt.*;

public class UpdateManager {

    //Attributes:
    private Player Player1;
    private Cam Camera1;

    private Graphics2D g2d;

    //Constructor:
    public UpdateManager() {
        Player1 = new Player(new Vector2D(0,0), 0.1f);
        Camera1 = new Cam(new Vector2D(0,0) , 1);
    }


    public void update(Graphics2D g2d){
        this.g2d = g2d;

        updatePlayer();

    }

    public void updatePlayer(){
        if(Player1.isPosUpdateNeeded()) {
            Player1.updatePosition();
        }
        Vector2D PlayerPos = Player1.getPosition();
        g2d.setColor(Color.BLUE);
        g2d.fillRect((int)PlayerPos.getX(), -(int)PlayerPos.getY(),20,20);

    }
    public void wPressed(){
        Player1.moveUp();
    }
    public void sPressed(){
        Player1.moveDown();
    }
    public void aPressed(){
        Player1.moveLeft();
    }
    public void dPressed(){
        Player1.moveRight();
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
