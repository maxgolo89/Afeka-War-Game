package GraphicsContent.GraphicsEntities;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;


public class MissileInstance extends GameObject {
    private static Image icon = new Image("GraphicsContent/Resources/missile.png");
    private Point2D velocity;
    public MissileInstance(String id, Point2D coordinates, Point2D targetCoordinates, int flyTime) {
        super(id, coordinates,icon);

        getView().setScaleX(0.4);
        getView().setScaleY(0.4);

        double distance = Math.sqrt((targetCoordinates.getY()-coordinates.getY())*(targetCoordinates.getY()-coordinates.getY()) + (targetCoordinates.getX()-coordinates.getX())*(targetCoordinates.getX()-coordinates.getX()) );
        double speed = distance / flyTime;

        speed/=60;                             // To be on same scale with framerate ( 60 fps ).

        double angle = Math.atan2(targetCoordinates.getY() - coordinates.getY(), targetCoordinates.getX() - coordinates.getX());

        velocity = new Point2D(Math.cos(angle) * speed, Math.sin(angle) * speed);
    }

    @Override
    public Point2D getVelocity(){
        return velocity;
    }

    @Override
    public void update(){
        this.getView().setTranslateX(this.getView().getTranslateX() + velocity.getX());
        this.getView().setTranslateY(this.getView().getTranslateY() + velocity.getY());
        this.getName().setTranslateX(this.getName().getTranslateX() + velocity.getX());
        this.getName().setTranslateY(this.getName().getTranslateY() + velocity.getY());
    }
}