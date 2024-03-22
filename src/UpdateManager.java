import java.awt.*;

public class UpdateManager {

    //Attributes:
    private Player Player1;
    private Cam Camera1;
    private TileMap tileMap1;
    private Graphics2D g2d;
    private Vector2D Windowsize = new Vector2D(1280,720);
    private final GraphicPanel GP;

    private long deltaTime = 1;
    private long lastTime = System.nanoTime();


    //Constructor:
    public UpdateManager(GraphicPanel GP) {

        Camera1 = new Cam(new Vector2D(100,100) , 100, 0.2f);
        tileMap1 = new TileMap(new Vector2D(50, 50));
        Player1 = new Player(new Vector2D(100,100), 0.075f, 10, 300, tileMap1);
        this.GP = GP;
        Windowsize.setXY(GP.getWidth(),GP.getHeigth());

    }



    // Main Update Method:
    // This is called every Frame:
    public void update(Graphics2D g2d){
        deltaTime = dT();
        this.g2d = g2d;
        Windowsize.setXY(GP.getWidth(),GP.getHeigth());

        if (Player1.isPosUpdateNeeded())
        {
            Player1.updatePosition(deltaTime);
        }
        Camera1.update(Player1.getPosition(), deltaTime);
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
    public void spacePressed(){ Player1.dash();}







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
    public long dT()
    {
        deltaTime = System.nanoTime() - lastTime;
        lastTime = System.nanoTime();
        return deltaTime / 1000000;
    }
}
