package moot.mowitnow;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created with IntelliJ IDEA.
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 * Date: 12/9/12
 * Time: 11:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class MowerTest {

    private Plateau plateau;
    @Before
    public void setup(){
        plateau=new Plateau(5,6);
    }

    @Test
    public void testGetPosition() throws Exception {
        Plateau.Position position=plateau.new Position(3,4);
        Mower mower=new Mower(position,Orientation.N);
        assertEquals(plateau.new Position(3,4),mower.getPosition());
    }

    @Test
    public void testGetOrientation() throws Exception {
        Plateau.Position position=plateau.new Position(3,4);
        Mower mower=new Mower(position,Orientation.N);
        assertEquals(Orientation.N,mower.getOrientation());
    }

    @Test
    public void testCarryAction() throws Exception {
        Plateau.Position position=plateau.new Position(3,4);
        Mower mower=new Mower(position,Orientation.N);
        mower.carryAction(Action.D);
        assertEquals("A mower orientated on North that process Action.D should be orientated East.",Orientation.E,mower.getOrientation());
        mower.carryAction(Action.G);
        assertEquals("A mower orientated on East that process Action.G should be orientated East.",Orientation.N,mower.getOrientation());
        mower.carryAction(Action.A);
        assertEquals("A mower located at (3,4) and facing North, which Advances should be at (3,5).",plateau.new Position(3,5),mower.getPosition());
        mower.carryAction(Action.A);
        assertEquals("A mower located at (3,5) and facing North, which Advances should not move.",plateau.new Position(3,5),mower.getPosition());
    }
}
