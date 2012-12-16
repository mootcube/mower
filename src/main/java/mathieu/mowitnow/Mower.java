package mathieu.mowitnow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 */
public class Mower implements Vehicle, Movable{
    private Lawn.Position position;
    private Orientation orientation;
    private static Logger logger = LoggerFactory.getLogger(Mower.class);

    public Mower(Lawn.Position position,Orientation orientation){
        logger.debug("initialize new Mower at Position ("+position.getX()+","+position.getY()+") and orientated "+orientation);
        this.position =position;
        this.orientation =orientation;
    }

    public Lawn.Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public void carryAction(Action action){
        switch (action){
            case D:
                orientation=orientation.next();
                break;
            case G:
                orientation=orientation.previous();
                break;
            case A:{
                position=position.getNearPosition(orientation);
            }
        }
    }

    @Override
    public String toString(){
        return position.getX()+" "+position.getY()+" "+orientation;
    }
}








