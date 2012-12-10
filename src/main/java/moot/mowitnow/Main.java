package moot.mowitnow;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 * Date: 12/10/12
 * Time: 1:01 AM
 */
public final class Main {
    private Main(){}

    public static void printUsage(){
        System.out.println("");
    }

    public static void fromSystemIn(){
        MowerScanner scn=new MowerScanner(System.in);
        try{
            scn.writeOutput(System.out,scn.processInput());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void fromFileToSystemOut(String filename){
        try{
            FileInputStream infile = new FileInputStream(filename);
            MowerScanner scn=new MowerScanner(infile);
            infile.close();
            scn.writeOutput(System.out,scn.processInput());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void fromFileToAnotherFile(String srcFilename, String dstFilename){
        try{
            FileInputStream infile = new FileInputStream(srcFilename);
            MowerScanner scn=new MowerScanner(infile);
            infile.close();
            FileOutputStream outfile = new FileOutputStream(dstFilename);
            scn.writeOutput(outfile,scn.processInput());
            outfile.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        switch (args.length){
            case 0:fromSystemIn();break;
            case 1:fromFileToSystemOut(args[0]);break;
            case 2:fromFileToAnotherFile(args[0],args[1]);break;
            default:printUsage();break;
        }
    }

}
