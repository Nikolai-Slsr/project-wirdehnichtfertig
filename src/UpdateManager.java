import java.awt.*;

public class UpdateManager {

    //Attributes:
    private Player Player1;
    private Cam Camera1;
    private TileMap tileMap1;
    private Graphics2D g2d;
    private Vector2D Windowsize = new Vector2D(1280,720);
    private GraphicPanel GP;

    //Constructor:
    public UpdateManager(GraphicPanel GP) {

        Player1 = new Player(new Vector2D(0,0), 0.1f);
        Camera1 = new Cam(new Vector2D(0,0) , 1, 0.3f);
        tileMap1 = new TileMap(new Vector2D(40, 40));
        this.GP = GP;
        Windowsize.setXY(GP.getWidth(),GP.getHeigth());
        System.out.println(Windowsize.getX());

    }



    // Main Update Method:
    // This is called every Frame:
    public void update(Graphics2D g2d){
        this.g2d = g2d;
        Windowsize.setXY(GP.getWidth(),GP.getHeigth());
        if (Player1.isPosUpdateNeeded())
        {
            Player1.updatePosition();
        }
        Camera1.update(Player1.getPosition());
        tileMap1.drawTiles(g2d,Camera1.getPosition(), Camera1.getCamDist(),Windowsize);
        Player1.draw(g2d , Camera1.getPosition(), Camera1.getCamDist(),Windowsize);
    }


    // Implement Key Presses from Graphics Panel
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






    // Getter and Setter Methods
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

    public Vector2D getWindowsize() {
        return Windowsize;
    }

    public void setWindowsize(Vector2D windowsize) {
        Windowsize = windowsize;
    }
}
