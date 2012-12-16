package mathieu.mowitnow;

import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;

/**
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 */
public class MowerScannerTest {
    @Test
    public void given_file_with_2_mowers_when_processing_input_then_2_mowers_are_detected(){
        URL url=this.getClass().getResource("/sample.txt");
        Lawn lawn=null;
        try{
            FileInputStream infile = new FileInputStream(url.getFile());
            lawn =MowerScanner.processInput(infile);
            infile.close();
        }catch(IOException e){
            e.printStackTrace();
            fail("IOException");
        }
        List<Mower> mowers=lawn.getMowers();
        assertThat(mowers.size()).isEqualTo(2);
    }

    @Test
    public void given_file_with_2_mowers_when_processing_input_then_final_position_are_as_expected(){
        URL url=this.getClass().getResource("/sample.txt");
        Lawn lawn=null;
        try{
            FileInputStream infile = new FileInputStream(url.getFile());
            lawn =MowerScanner.processInput(infile);
            infile.close();
        }catch(IOException e){
            e.printStackTrace();
            fail("IOException");
        }
        List<Mower> mowers=lawn.getMowers();
        Lawn.Position position_1 = lawn.new Position(1, 3);
        Lawn.Position position_2 = lawn.new Position(5, 1);
        assertThat(mowers).onProperty("position").containsOnly(position_1, position_2);
    }

    @Test
    public void given_file_with_2_mowers_when_processing_input_then_final_orientation_are_as_expected(){
        URL url=this.getClass().getResource("/sample.txt");
        Lawn lawn=null;
        try{
            FileInputStream infile = new FileInputStream(url.getFile());
            lawn =MowerScanner.processInput(infile);
            infile.close();
        }catch(IOException e){
            e.printStackTrace();
            fail("IOException");
        }
        List<Mower> mowers=lawn.getMowers();
        Orientation orientation_2 = Orientation.E;
        Orientation orientation_1 = Orientation.N;
        assertThat(mowers).onProperty("orientation").containsOnly(orientation_1, orientation_2);
    }

    @Test
    public void given_file_with_2_mowers_when_writting_the_result_to_file_then_newfile_content_is_as_expected(){
        try{
            URL sample=this.getClass().getResource("/sample.txt");
            URL defaultOutput=this.getClass().getResource("/sampleoutput.txt");
            FileInputStream infile = new FileInputStream(sample.getFile());
            Lawn lawn =MowerScanner.processInput(infile);
            infile.close();
            List<Mower> mowers=lawn.getMowers();
            BufferedWriter outfile=new BufferedWriter(new FileWriter("output.txt"));
            outfile.write(lawn.toString());
            outfile.close();
            File expectedOutput = new File(defaultOutput.getFile());
            File actualOutput = new File("output.txt");
            assertThat(actualOutput).hasSameContentAs(expectedOutput);
        }catch(IOException e){
            e.printStackTrace();
            fail("IOException");
        }
    }

    @Test
    public void given_a_file_with_an_invalid_lawn_when_processing_input_then_it_should_throw_a_LawnIOException(){
        try{
            InputStream in = new ByteArrayInputStream("Invalid file".getBytes());
            Lawn lawn =MowerScanner.processInput(in);
            fail("Incorrect Lawn should throw a LawnIOException");
        }catch (LawnIOException e){
        }catch (MowerIOException e){
            fail("Incorrect Lawn should throw a LawnIOException");
        }
    }

    @Test
    public void given_a_file_with_an_invalid_mower_when_processing_input_then_it_should_throw_a_MowerIOException(){
        try{
            InputStream in = new ByteArrayInputStream("5 6\nTest".getBytes());
            Lawn lawn =MowerScanner.processInput(in);
            fail("Incorrect Mower should throw a MowerIOException");
        }catch (LawnIOException e){
        }catch (MowerIOException e){
        }
    }
}
