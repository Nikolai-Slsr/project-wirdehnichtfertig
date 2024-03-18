import java.awt.*;

public class Tile extends Object2D {
    private final Calc calc = new Calc();
    public Tile(Vector2D position, Material material, Properties properties) {    // Constructor
        super(position, material, properties);
    }
    public void draw(Graphics2D g2d, Vector2D camPos, float CamDist, Vector2D WindowSize){     // Implements draw from Object2D
        Vector2D distanceVec = calc.subVec2D(super.getPosition(),camPos);
        Vector2D localPos = calc.divVec2D(distanceVec, CamDist);
        if((int)(localPos.getX()+(WindowSize.getX()/2))>=-100 && (int)(localPos.getX()+(WindowSize.getX()/2)) <= WindowSize.getX()+super.getProperties().getSize().getX() && (int)(localPos.getY()+(WindowSize.getY()/2))>=-100 && (int)(localPos.getY()+(WindowSize.getY()/2)) <= WindowSize.getY()+super.getProperties().getSize().getY()){
        g2d.drawImage(super.getMaterial().getTexture(), (int)(localPos.getX()+(WindowSize.getX()/2)), (int)(localPos.getY()+(WindowSize.getY()/2)), (int)((getProperties().getSize().getX()) / CamDist ),(int)((super.getProperties().getSize().getY() / CamDist)),null);}
        //g2d.drawRect((int)(localPos.getX()+(WindowSize.getX()/2)), (int)(localPos.getY()+(WindowSize.getY()/2)), (int)((getProperties().getSize().getX()) / CamDist ),(int)((super.getProperties().getSize().getY() / CamDist)));
    }
}
