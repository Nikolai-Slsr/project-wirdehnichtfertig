public class Collision {

    Calc calc = new Calc();
    public Boolean isColliding(Vector2D Pos1, Vector2D hitbox, TileMap TileMap){
        for(Tile tile : TileMap.getCollisionMap()){
            Vector2D Distance = calc.absolutValue(  calc.subVec2D(  calc.addVec2D(Pos1,calc.divVec2D(new Vector2D(16,16), 2)), calc.addVec2D(tile.getPosition(),calc.divVec2D(tile.getProperties().getSize(), 2)  )  )  );
            if(Distance.getX() < tile.getProperties().getSize().getX()/2 + hitbox.getX()/2 && Distance.getY() < tile.getProperties().getSize().getY()/2 + hitbox.getY()/2){
                return true;
            }
        }
        return false;

    }
}
