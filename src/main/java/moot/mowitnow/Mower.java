package moot.mowitnow;

/**
 * Created with IntelliJ IDEA.
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 * Date: 12/7/12
 * Time: 8:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Mower implements Vehicle, Movable{
    private Plateau.Position position;
    private Orientation orientation;


    public Mower(Plateau.Position position,Orientation orientation){
        this.position =position;
        this.orientation =orientation;
    }

    public Plateau.Position getPosition() {
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








