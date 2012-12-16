package mathieu.mowitnow;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.*;
/**
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 */
public class MowerTest {

    private Lawn lawn;
    @Before
    public void setup(){
        lawn =new Lawn(5,6);
    }

    @Test
    public void given_a_mower_on_3_4_then_it_should_be_on_position_3_4() throws Exception {
        Lawn.Position position= lawn.new Position(3,4);
        Mower mower=new Mower(position,Orientation.N);
        assertThat(mower.getPosition()).isEqualTo(lawn.new Position(3,4));
    }

    @Test
    public void given_a_mower_on_north_then_it_should_be_orientated_north() throws Exception {
        Lawn.Position position= lawn.new Position(3,4);
        Mower mower=new Mower(position,Orientation.N);
        assertThat(mower.getOrientation()).isEqualTo(Orientation.N);
    }

    //Actions

    @Test
    public void given_a_mower_at_3_4_N_when_carrying_action_D_then_should_be_oriented_E(){
        Lawn.Position position= lawn.new Position(3,4);
        Mower mower=new Mower(position,Orientation.N);
        mower.carryAction(Action.D);
        assertThat(mower.getOrientation()).isEqualTo(Orientation.E);
    }

    @Test
    public void given_a_mower_at_3_4_N_when_carrying_action_G_then_should_be_oriented_E(){
        Lawn.Position position= lawn.new Position(3,4);
        Mower mower=new Mower(position,Orientation.N);
        mower.carryAction(Action.G);
        assertThat(mower.getOrientation()).isEqualTo(Orientation.W);
    }

    @Test
    public void given_a_mower_at_3_4_N_when_carrying_action_A_then_should_be_at_3_5_N(){
        Lawn.Position position= lawn.new Position(3,4);
        Mower mower=new Mower(position,Orientation.N);
        mower.carryAction(Action.A);
        assertThat(mower.getPosition()).isEqualTo(lawn.new Position(3,5));
    }

    @Test
    public void given_a_mower_at_3_0_S_when_carrying_action_A_then_should_be_at_3_0_S(){
        Lawn.Position position= lawn.new Position(3,0);
        Mower mower=new Mower(position,Orientation.S);
        mower.carryAction(Action.A);
        assertThat(mower.getPosition()).isEqualTo(lawn.new Position(3,0));
    }
}
