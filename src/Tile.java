import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tile extends Object2D {
    private final Calc calc = new Calc();
    public Tile(Vector2D position, Material material, Properties properties) {
        super(position, material, properties);
    }
    public void draw(Graphics2D g2d, Vector2D camPos, float CamDist, Vector2D WindowSize){
        Vector2D distanceVec = calc.subVec2D(super.getPosition(),camPos);
        Vector2D localPos = calc.divVec2D(distanceVec, CamDist);
        g2d.drawImage(super.getMaterial().getGrass(), (int)(localPos.getX()+(WindowSize.getX()/2)), (int)(localPos.getY()+(WindowSize.getY()/2)), (int)((getProperties().getSize().getX()) / CamDist ),(int)((super.getProperties().getSize().getY() / CamDist)),null);
        //g2d.drawRect((int)(localPos.getX()+(WindowSize.getX()/2)), (int)(localPos.getY()+(WindowSize.getY()/2)), (int)((getProperties().getSize().getX()) / CamDist ),(int)((super.getProperties().getSize().getY() / CamDist)));
    }
}
