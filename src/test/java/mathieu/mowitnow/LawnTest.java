package mathieu.mowitnow;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;

/**
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 */
public class LawnTest {
    @Test
    public void testGetHeight() throws Exception {
        Lawn lawn=new Lawn(5,6);
        assertThat(lawn.getHeight()).isEqualTo(6);
    }

    @Test
    public void testGetLength() throws Exception {
        Lawn lawn=new Lawn(5,6);
        assertThat(lawn.getLength()).isEqualTo(5);
    }

    @Test
    public void given_a_negative_size_when_creating_a_lawn_it_should_throw_an_IllegalArgumentException(){
        try{
            Lawn lawn=new Lawn(-1,2);
            fail("a negative size should throw an IllegalArgumentException");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void given_a_0_size_when_creating_a_lawn_it_should_throw_an_IllegalArgumentException(){
        try{
            Lawn lawn=new Lawn(0,2);
            fail("a negative size should throw an IllegalArgumentException");
        } catch (IllegalArgumentException e) {

        }
    }
}
