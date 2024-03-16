import java.util.ArrayList;

public class ParticleGenerator {
        //<editor-fold desc="Attributes">
        private ArrayList<Particle> particles = new ArrayList<>();
        private boolean running;

        private Vector2D position;
        private int particleNumber; //How many particles may life at a time;
        private Vector2D spread; //randomly chooses to spawn a particle a bit off from it's origin by this Spread in x and y.


        //TIMINGS
        private float liveTime;
        private float rndmLifeTimeDifference;
        private float SpawnTime;
        private float rndmSpawnTimeDifference;


        //VELOCITIES:
        private Vector2D velocity;
        private Vector2D rndmVelocity;

        //ACCELERATION:
        private Vector2D acceleration;
        private Vector2D rndmAccelerationDifference;

        //ROTATION:
        private float rotation;
        private float rndmRotationDifference;

        //SIZE:
        private Vector2D startSize;
        private Vector2D rndmStartSizeDifference;

        private Vector2D endSize;
        private Vector2D rndmEndSizeDifference;

        //ZONES:
        private Vector2D allowedRectangle = null; //Area defined by an rectangle around the center in which the particle won't despawn. (Null = none existant)
        private float topLimit = -1; //How far an particle can go above the generators position until it's killed.
        private float bottomLimit = -1; //How far an particle can go below the generators position until it's killed.
        private float rightLimit = -1; //How far an particle can go right the generators position until it's killed.
        private float leftLimit = -1; //How far an particle can go left the generators position until it's killed.
        //</editor-fold>

    public ParticleGenerator(Vector2D position, int particleNumber, boolean running){
        this.position = position;
        this.particleNumber = particleNumber;
        this.running = running;

    }
}
