package mathieu.mowitnow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 */
public final class Main {
    private static Logger l=LoggerFactory.getLogger(Main.class);
    private Main(){}

    public static void printUsage(){
        System.out.println("Usage:\n" +
                "-h          : print usage\n" +
                "            : read from standart input and write to standart output\n" +
                "file        : read from file and write to standart output\n" +
                "file1 file2 : read from file1 and write to file2");
    }

    public static void fromSystemIn()throws IOException{
        System.out.println(
                "Start by coordinates of upper right corner format: x y\n" +
                "then each mower format:                            x y orientation\n" +
                "and actions, sample:                               GAGAA\n" +
                "When you entered all mower press Ctrl-D (or Ctrl-Z Enter) to process.");
        Lawn l=MowerScanner.processInput(System.in);
        System.out.print(l.toString());
    }

    public static void fromFileToSystemOut(String filename)throws IOException{
        FileInputStream infile = new FileInputStream(filename);
        Lawn l=MowerScanner.processInput(infile);
        System.out.print(l.toString());
        infile.close();
    }

    public static void fromFileToAnotherFile(String srcFilename, String dstFilename)throws IOException{
        FileInputStream infile = new FileInputStream(srcFilename);
        BufferedWriter outfile = new BufferedWriter(new FileWriter(dstFilename));
        Lawn l=MowerScanner.processInput(infile);
        outfile.write(l.toString());
        infile.close();
        outfile.close();
    }

    public static void main(String[] args)throws IOException{
        Logger l= LoggerFactory.getILoggerFactory().getLogger("default");
        l.debug("test");
        switch (args.length){
            case 0:fromSystemIn();break;
            case 1:{
                if(args[0].equals("-h"))
                    printUsage();
                else
                    fromFileToSystemOut(args[0]);
                break;
            }
            case 2:fromFileToAnotherFile(args[0],args[1]);break;
            default:printUsage();break;
        }
    }

}
