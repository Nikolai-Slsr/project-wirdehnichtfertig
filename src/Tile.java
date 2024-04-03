import java.awt.*;

public class Tile extends Object2D {
    private final Calc calc = new Calc();
    public Tile(Vector2D position, Material material, Properties properties) {    // Constructor
        super(position, material, properties);
    }
    public void draw(Graphics2D g2d, Vector2D camPos, float CamDist, Vector2D WindowSize){     // Implements draw from Object2D
        if(isTileInFrame(camPos,CamDist,WindowSize)) {
            Vector2D localPos = tilePosInFramePos(camPos, CamDist, WindowSize);

            if (getMaterial().getColor() == null) {
                g2d.drawImage(super.getMaterial().getTexture(), (int) localPos.getX(), (int) localPos.getY(), (int) ((getProperties().getSize().getX()) / CamDist) + 1, (int) ((super.getProperties().getSize().getY() / CamDist) + 1), null);//}
            } else {
                g2d.setColor(super.getMaterial().getColor());
                g2d.fillRect((int) localPos.getX(), (int) localPos.getY(), (int) ((getProperties().getSize().getX()) / CamDist) + 1, (int) ((super.getProperties().getSize().getY() / CamDist) + 1));
            }
            if (getProperties().getCollision()) {
                g2d.setStroke(new BasicStroke(3));
                g2d.setColor(new Color(0, 94, 255));

                g2d.drawRect((int) localPos.getX(), (int)localPos.getY(), (int) ((getProperties().getSize().getX()) / CamDist) - 1, (int) ((super.getProperties().getSize().getY() / CamDist)) - 1);
            }
        }

    }
    public Vector2D tilePosInFramePos(Vector2D camPos, float CamDist, Vector2D WindowSize){
        return calc.addVec2D( calc.divVec2D(calc.subVec2D(super.getPosition(), camPos) , CamDist), (calc.divVec2D(WindowSize, 2)));

    }

    public boolean isTileInFrame(Vector2D camPos, float CamDist, Vector2D WindowSize){
        Vector2D currentTileFramePos = tilePosInFramePos(camPos,CamDist,WindowSize);
        return currentTileFramePos.getX() < WindowSize.getX()  &&
                currentTileFramePos.getY() < WindowSize.getY()  &&
                currentTileFramePos.getX() > -(super.Properties.getSize().getX() / CamDist)&&
                currentTileFramePos.getY() > -(super.Properties.getSize().getY() / CamDist);
    }
}
