import java.awt.*;

public class Tile extends Object2D {
    private final Calc calc = new Calc();
    public Tile(Vector2D position, Material material, Properties properties) {
        super(position, material, properties);
    }
    public void draw(Graphics2D g2d, Vector2D camPos, float CamDist, Vector2D WindowSize){
        Vector2D distanceVec = calc.subVec2D(super.getPosition(),camPos);
        Vector2D localPos = calc.divVec2D(distanceVec, CamDist);
        g2d.drawRect((int)(localPos.getX()+(WindowSize.getY()/2)), (int)(localPos.getY()+(WindowSize.getY()/2)), (int)(getProperties().getSize().getX()) ,(int)(super.getProperties().getSize().getY()));
    }
}
