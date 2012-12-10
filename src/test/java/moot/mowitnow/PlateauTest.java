package moot.mowitnow;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created with IntelliJ IDEA.
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 * Date: 12/9/12
 * Time: 11:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlateauTest {
    @Test
    public void testGetHeight() throws Exception {
        Plateau p=new Plateau(5,6);
        assertEquals("The height of a Plateau(5,6) should be 6.",6,p.getHeight());
    }

    @Test
    public void testGetLength() throws Exception {
        Plateau p=new Plateau(5,6);
        assertEquals("The length of a Plateau(5,6) should be 5.",5,p.getLength());
    }
}
