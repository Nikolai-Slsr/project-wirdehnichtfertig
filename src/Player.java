import javax.swing.text.Position;
import java.awt.*;

public class Player {
    private Vector2D Position;
    private Vector2D DeltaPosition = new Vector2D(0,0);  //Vector used for movement. As player moves per frame, vectors for each input get added together and normalized.
    private float Speed;     // Speed while player is moving

    private final Calc calc = new Calc();

    //constructor
    public Player(Vector2D Position, float Speed) {
        this.Position = Position;
        this.Speed = Speed;
    }

    //
    public void updatePosition(){
        Position.setXY(calc.addVec2D(Position , calc.multVec2D (calc.normalize(DeltaPosition), Speed))); //Adds DeltaPosition to Position to let player gain movement.
        DeltaPosition.setXY(0,0);    //resets DeltaPosition.
    }

    /** This method determines if an update of the position is even needed. True upon DeltaPos being not (0,0) */
    public boolean isPosUpdateNeeded(){
        return DeltaPosition.is(new Vector2D(0,0));
    }

    public void draw(Graphics2D g2d, Vector2D camPos, float CamDist, Vector2D WindowSize){
        Vector2D distanceVec = calc.subVec2D(Position,camPos);
        Vector2D localPos = calc.divVec2D(distanceVec, CamDist);
        g2d.setColor(Color.BLUE);
        g2d.fillRect((int)(localPos.getX()+(WindowSize.getX()/2) - (10 / CamDist)) , (int)(localPos.getY()+(WindowSize.getY()/2) - (15/ CamDist)), (int)(20 / CamDist) ,(int)(30 / CamDist));
    }

    //Move methods:

    public void moveRight(){DeltaPosition = calc.addVec2D(DeltaPosition, new Vector2D(1,0));}
    public void moveLeft(){DeltaPosition = calc.addVec2D(DeltaPosition, new Vector2D(-1,0));}
    public void moveUp(){DeltaPosition = calc.addVec2D(DeltaPosition, new Vector2D(0,-1));}
    public void moveDown(){DeltaPosition = calc.addVec2D(DeltaPosition, new Vector2D(0,1));}


    public Vector2D getPosition() {
        return Position;
    }

    public void setPosition(float x, float y) {
        Position.setXY(x,y);
    }

    public float getSpeed() {
        return Speed;
    }

    public void setSpeed(float speed) {
        Speed = speed;
    }
}
