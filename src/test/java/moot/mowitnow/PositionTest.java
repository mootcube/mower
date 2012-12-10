package moot.mowitnow;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created with IntelliJ IDEA.
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 * Date: 12/9/12
 * Time: 11:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class PositionTest {

    private Plateau p;

    @Before
    public void setup(){
        p = new Plateau(5,6);
    }

    @Test
    public void a_Position_out_of_bounds_throw_IndexOutOfBoundsException(){
        try{
            Plateau.Position position= p.new Position(-1,0);
            fail("A position should have positive coordinates.");
        }catch(IndexOutOfBoundsException e){
        }catch (Throwable t){
            fail("An invalid Position should throw an IndexOutOfBoundException.");
        }
        try{
            Plateau.Position position= p.new Position(0,-1);
            fail("A position should have positive coordinates.");
        }catch(IndexOutOfBoundsException e){
        }catch (Throwable t){
            fail("An invalid Position should throw an IndexOutOfBoundException.");
        }
        try{
            Plateau.Position position= p.new Position(7,5);
            fail("The Position's coordinates should be less than height/length of the Plateau.");
        }catch(IndexOutOfBoundsException e){
        }catch (Throwable t){
            fail("An invalid Position should throw an IndexOutOfBoundException.");
        }
        try{
            Plateau.Position position= p.new Position(4,6);
            fail("The Position's coordinates should be less than height/length of the Plateau.");
        }catch(IndexOutOfBoundsException e){
        }catch (Throwable t){
            fail("An invalid Position should throw an IndexOutOfBoundException.");
        }
    }

    @Test
    public void the_getNearestPosition_of_a_Position_in_a_given_direction_return_closest_Position(){
        Plateau.Position position=p.new Position(3,4);
        assertEquals("The North of (3,4) should be (3,5).",p.new Position(3,5),position.getNearPosition(Orientation.N));
        assertEquals("The East of (3,4) should be (4,4).",p.new Position(4,4),position.getNearPosition(Orientation.E));
        assertEquals("The South of (3,4) should be (3,3).",p.new Position(3,3),position.getNearPosition(Orientation.S));
        assertEquals("The West of (3,4) should be (2,4).",p.new Position(2,4),position.getNearPosition(Orientation.W));
    }

    @Test
    public void the_getNereastPosition_of_a_Position_in_the_border_return_itself(){
        Plateau.Position position=p.new Position(4,5);
        assertEquals("The following Position in North direction in the top border should return itself.",position,position.getNearPosition(Orientation.N));
        assertEquals("The following Position in East direction in the top right should return itself.",position,position.getNearPosition(Orientation.E));
        Plateau.Position origin=p.new Position(0,0);
        assertEquals("The following Position in South direction in the bottom border should return itself.",origin,origin.getNearPosition(Orientation.S));
        assertEquals("The following Position in West direction in the left border should return itself.",origin,origin.getNearPosition(Orientation.W));
    }
}
