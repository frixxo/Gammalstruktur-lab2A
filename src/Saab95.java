import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represent a Saab95
 */
public class Saab95 extends Car{

    private boolean turboOn;

    //region constructors
    public Saab95(Point position, Point2D direction){
        super(position,direction);
        initialize(4,Color.red,125,"Saab95");
        setTurboOn(false);
    }
    public Saab95(){
        super();
       initialize(4,Color.red,125,"Saab95");
       setTurboOn(false);
    }
    //endregion

    public void setTurboOn(boolean TrueOrFalse){
	    turboOn = TrueOrFalse;
    }
    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
