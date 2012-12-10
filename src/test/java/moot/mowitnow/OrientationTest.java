package moot.mowitnow;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 * Date: 12/9/12
 * Time: 11:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class OrientationTest {
    @Test
    public void testNext() throws Exception {
        assertEquals("The next orientation of W should be N.",Orientation.N,Orientation.W.next());
        assertEquals("The next orientation of N should be E.",Orientation.E,Orientation.N.next());
        assertEquals("The next orientation of E should be S.",Orientation.S,Orientation.E.next());
        assertEquals("The next orientation of S should be W.",Orientation.W,Orientation.S.next());
    }

    @Test
    public void testPrevious() throws Exception {
        assertEquals("The previous orientation of E should be N.",Orientation.N,Orientation.E.previous());
        assertEquals("The previous orientation of S should be E.",Orientation.E,Orientation.S.previous());
        assertEquals("The previous orientation of W should be S.",Orientation.S,Orientation.W.previous());
        assertEquals("The previous orientation of N should be W.",Orientation.W,Orientation.N.previous());
    }
}
