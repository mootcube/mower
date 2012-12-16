package mathieu.mowitnow;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Fail.fail;
import static org.fest.assertions.Assertions.*;

/**
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 */
public class PositionTest {

    private Lawn lawn;

    @Before
    public void setup(){
        lawn = new Lawn(5,6);
    }

    @Test
    public void given_a_lawn_5_6_when_creating_a_position_with_negative_x_then_it_should_throw_an_IndexOutOfBoundException(){
        try{
            Lawn.Position position= lawn.new Position(-1,0);
            fail("A position should have positive coordinates.");
        }catch(IndexOutOfBoundsException e){

        }catch (Throwable t){
            fail("A Position with negative x should throw an IndexOutOfBoundException.");
        }
    }

    @Test
    public void given_a_lawn_5_6_when_creating_a_position_with_negative_y_then_it_should_throw_an_IndexOutOfBoundException(){
        try{
            Lawn.Position position= lawn.new Position(0,-1);
            fail("A position should have positive coordinates.");
        }catch(IndexOutOfBoundsException e){

        }catch (Throwable t){
            fail("A Position with negative y should throw an IndexOutOfBoundException.");
        }
    }

    @Test
    public void given_a_lawn_5_6_when_creating_a_position_7_5_then_it_should_throw_an_IndexOutOfBoundException(){
        try{
            Lawn.Position position= lawn.new Position(7,5);
            fail("The Position's x should be less than or equal to x of the Lawn.");
        }catch(IndexOutOfBoundsException e){

        }catch (Throwable t){
            fail("A Position with a greater x than the Lawn should throw an IndexOutOfBoundException.");
        }
    }

    @Test
    public void given_a_lawn_5_6_when_creating_a_position_5_7_then_it_should_throw_an_IndexOutOfBoundException(){
        try{
            Lawn.Position position= lawn.new Position(5,7);
            fail("The Position's y should be less than or equal to y of the Lawn.");
        }catch(IndexOutOfBoundsException e){

        }catch (Throwable t){
            fail("A Position with a greater y than the Lawn should throw an IndexOutOfBoundException.");
        }
    }

    @Test
    public void given_a_lawn_5_6_when_creating_a_position_5_6_then_it_should_be_valid(){
        try{
            Lawn.Position position= lawn.new Position(5,6);
        }catch(IndexOutOfBoundsException e){
            fail("The Position (5,6) should be valid for the Lawn (5,6).");
        }catch (Throwable t){
            fail("The Position (5,6) should be valid for the Lawn (5,6).");
        }
    }

    @Test
    public void given_a_position_3_4_when_getting_the_nearest_position_on_N_then_it_should_return_3_5(){
        Lawn.Position position= lawn.new Position(3,4);
        Lawn.Position expected= lawn.new Position(3,5);
        assertThat(position.getNearPosition(Orientation.N)).isEqualTo(expected);
    }

    @Test
    public void given_a_position_3_4_when_getting_the_nearest_position_on_E_then_it_should_return_4_4(){
        Lawn.Position position= lawn.new Position(3,4);
        Lawn.Position expected= lawn.new Position(4,4);
        assertThat(position.getNearPosition(Orientation.E)).isEqualTo(expected);
    }

    @Test
    public void given_a_position_3_4_when_getting_the_nearest_position_on_S_then_it_should_return_3_3(){
        Lawn.Position position= lawn.new Position(3,4);
        Lawn.Position expected= lawn.new Position(3,3);
        assertThat(position.getNearPosition(Orientation.S)).isEqualTo(expected);
    }

    @Test
    public void given_a_position_3_4_when_getting_the_nearest_position_on_W_then_it_should_return_2_4(){
        Lawn.Position position= lawn.new Position(3,4);
        Lawn.Position expected= lawn.new Position(2,4);
        assertThat(position.getNearPosition(Orientation.W)).isEqualTo(expected);
    }

    @Test
    public void given_a_lawn_5_6_and_a_position_5_6_when_getting_the_nearest_position_in_N_it_should_return_itself(){
        Lawn.Position position= lawn.new Position(5,6);
        assertThat(position.getNearPosition(Orientation.N)).isEqualTo(position);
    }

    @Test
    public void given_a_lawn_5_6_and_a_position_5_6_when_getting_the_nearest_position_in_E_it_should_return_itself(){
        Lawn.Position position= lawn.new Position(5,6);
        assertThat(position.getNearPosition(Orientation.E)).isEqualTo(position);
    }

    @Test
    public void given_a_lawn_5_6_and_a_position_4_5_when_getting_the_nearest_position_in_N_it_should_return_itself(){
        Lawn.Position position= lawn.new Position(4,5);
        Lawn.Position expected= lawn.new Position(4,6);
        assertThat(position.getNearPosition(Orientation.N)).isEqualTo(expected);
    }

    @Test
    public void given_a_lawn_5_6_and_a_position_4_5_when_getting_the_nearest_position_in_E_it_should_return_itself(){
        Lawn.Position position= lawn.new Position(4,5);
        Lawn.Position expected= lawn.new Position(5,5);
        assertThat(position.getNearPosition(Orientation.E)).isEqualTo(expected);
    }

    @Test
    public void given_a_lawn_5_6_and_a_position_0_0_when_getting_the_nearest_position_in_S_it_should_return_itself(){
        Lawn.Position position= lawn.new Position(0,0);
        assertThat(position.getNearPosition(Orientation.S)).isEqualTo(position);
    }

    @Test
    public void given_a_lawn_5_6_and_a_position_0_0_when_getting_the_nearest_position_in_W_it_should_return_itself(){
        Lawn.Position position= lawn.new Position(0,0);
        assertThat(position.getNearPosition(Orientation.W)).isEqualTo(position);
    }
}
