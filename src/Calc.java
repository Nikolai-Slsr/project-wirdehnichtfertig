public class Calc {

    /*adds Vector2D a and Vector2D b */
    public Vector2D addVec2D(Vector2D a, Vector2D b){
        return new Vector2D(a.getX() + b.getX(), a.getY() + b.getY());
    }

    /*substracts Vector2D a and Vector2D b */
    public Vector2D subVec2D(Vector2D a, Vector2D b){
        return new Vector2D(a.getX() - b.getX(), a.getY() - b.getY());
    }

    /*multiplies Vector2D a with float b */
    public Vector2D multVec2D( Vector2D a, float b){
        return new Vector2D(a.getX() * b, a.getY() * b);
    }

    public Vector2D multEachByEachVec2D( Vector2D a, Vector2D b){
        return new Vector2D(a.getX() * b.getX(), a.getY() * b.getY());
    }

    public Vector2D divVec2D( Vector2D a, float b){
        return new Vector2D(a.getX() / b, a.getY() / b);
    }

    public Vector2D divEachByEachVec2D( Vector2D a, Vector2D b){
        return new Vector2D(a.getX() / b.getX(), a.getY() / b.getY());
    }

    public float dot(Vector2D a, Vector2D b){
        return a.getX() * b.getX() + a.getY() * b.getY();
    }

    public Vector2D cross(Vector2D a, Vector2D b){
        return new Vector2D(
                a.getY() * b.getX() - a.getX() * b.getY() ,
                a.getX() * b.getY() - a.getY() * b.getX()

        );
    }

    public Vector2D normalize(Vector2D a){
        float len = (float)Math.sqrt(a.getX()*a.getX() + a.getY()*a.getY());
        return new Vector2D(
                a.getX() / len ,
                a.getY() / len

        );
    }
    public Vector2D round(Vector2D a){
        return new Vector2D(
                Math.round(a.getX()),
                Math.round(a.getY())

        );

    }
    public Vector2D absolutValue(Vector2D a){
        return new Vector2D(
                Math.abs(a.getX()),
                Math.abs(a.getY())
        );
    }
}
