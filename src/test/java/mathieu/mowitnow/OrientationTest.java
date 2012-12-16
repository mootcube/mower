package mathieu.mowitnow;

import org.junit.Test;

import static org.fest.assertions.Assertions.*;
/**
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 */
public class OrientationTest {

    @Test
    public void given_orientation_N_when_getting_next_orientation_it_should_return_E(){
        assertThat(Orientation.N.next()).isEqualTo(Orientation.E);
    }

    @Test
    public void given_orientation_E_when_getting_next_orientation_it_should_return_S(){
        assertThat(Orientation.E.next()).isEqualTo(Orientation.S);
    }

    @Test
    public void given_orientation_S_when_getting_next_orientation_it_should_return_W(){
        assertThat(Orientation.S.next()).isEqualTo(Orientation.W);
    }

    @Test
    public void given_orientation_W_when_getting_next_orientation_it_should_return_N(){
        assertThat(Orientation.W.next()).isEqualTo(Orientation.N);
    }


    @Test
    public void given_orientation_N_when_getting_previous_orientation_it_should_return_E(){
        assertThat(Orientation.N.previous()).isEqualTo(Orientation.W);
    }

    @Test
    public void given_orientation_E_when_getting_previous_orientation_it_should_return_S(){
        assertThat(Orientation.E.previous()).isEqualTo(Orientation.N);
    }

    @Test
    public void given_orientation_S_when_getting_previous_orientation_it_should_return_W(){
        assertThat(Orientation.S.previous()).isEqualTo(Orientation.E);
    }

    @Test
    public void given_orientation_W_when_getting_previous_orientation_it_should_return_N(){
        assertThat(Orientation.W.previous()).isEqualTo(Orientation.S);
    }
}
