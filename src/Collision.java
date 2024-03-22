public class Collision {

    Calc calc = new Calc();
    public Boolean isCollidingTiles(Vector2D Pos1, Vector2D hitBox, TileMap TileMap){
        for(Tile tile : TileMap.getCollisionMap()){
            Vector2D Distance = calc.absolutValue(  calc.subVec2D(  calc.addVec2D(Pos1,calc.divVec2D(new Vector2D(16,16), 2)), calc.addVec2D(tile.getPosition(),calc.divVec2D(tile.getProperties().getSize(), 2)  )  )  );
            if(Distance.getX() < tile.getProperties().getSize().getX()/2 + hitBox.getX()/2 && Distance.getY() < tile.getProperties().getSize().getY()/2 + hitBox.getY()/2){
                return true;
            }
        }
        return false;

    }
    public Boolean isCollidingP2P(Vector2D Pos1, Vector2D Pos2, Vector2D hitBox1,Vector2D hitBox2, TileMap TileMap){
        for(Tile tile : TileMap.getCollisionMap()){
            Vector2D Distance = calc.absolutValue(  calc.subVec2D(  calc.addVec2D(Pos1,calc.divVec2D(new Vector2D(16,16), 2)), calc.addVec2D(Pos2,calc.divVec2D(hitBox2, 2)  )  )  );
            if(Distance.getX() < hitBox1.getX()/2 + hitBox2.getX()/2 && Distance.getY() < hitBox1.getY()/2 + hitBox2.getY()/2){
                return true;
            }
        }
        return false;

    }
}
