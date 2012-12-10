package moot.mowitnow;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 * Date: 12/10/12
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class MowerScannerTest {

    private MowerScanner scn;
    @Before
    public void setup(){

    }

    @Test
    public void readFromFile(){
        try{
            URL url=this.getClass().getResource("/sample.txt");
            FileInputStream infile = new FileInputStream(url.getFile());
            scn=new MowerScanner(infile);
            scn.processInput();
            infile.close();
            Plateau plateau=scn.getPlateau();
            List<Mower> mowers=scn.getMowers();
            assertEquals("'sample.txt' file contains 2 mowers",2,mowers.size());
            assertEquals("First mower should end at (1 3)",plateau.new Position(1,3),mowers.get(0).getPosition());
            assertEquals("First mower should face North",Orientation.N,mowers.get(0).getOrientation());
            assertEquals("Second mower should end at (5 1)",plateau.new Position(5,1),mowers.get(1).getPosition());
            assertEquals("Second mower should face East", Orientation.E, mowers.get(1).getOrientation());
        }catch(IOException e){
            e.printStackTrace();
            fail("IOException");
        }
    }

    @Test
    public void writeToFile(){
        try{
            URL url=this.getClass().getResource("/sample.txt");
            FileInputStream infile = new FileInputStream(url.getFile());
            scn=new MowerScanner(infile);
            scn.processInput();
            infile.close();
            List<Mower> mowers=scn.getMowers();
            FileOutputStream outfile=new FileOutputStream("output.txt");
            scn.writeOutput(outfile,mowers);
            outfile.close();
        }catch(IOException e){
            e.printStackTrace();
            fail("IOException");
        }
    }
}
