package moot.mowitnow;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 * Date: 12/10/12
 * Time: 12:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class MowerScanner {
    private Scanner scanner;

    public List<Mower> getMowers() {
        return mowers;
    }

    private ArrayList<Mower> mowers;

    public Plateau getPlateau() {
        return plateau;
    }

    private Plateau plateau;


    public MowerScanner(InputStream inputStream){
        scanner=new Scanner(inputStream);
    }

    public List<Mower> processInput()throws IOException{
        int x=scanner.nextInt();
        int y=scanner.nextInt();
        plateau = new Plateau(x+1,y+1);
        mowers = new ArrayList<Mower>();
        do{
            try{
                Mower m=new Mower(plateau.new Position(scanner.nextInt(),scanner.nextInt()),Orientation.valueOf(scanner.next()));
                String actions=scanner.next();
                for(char c:actions.toCharArray()){
                    m.carryAction(Action.valueOf(String.valueOf(c)));
                }
                mowers.add(m);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }while(scanner.hasNext());
        return mowers;
    }

    public void writeOutput(OutputStream out, List<Mower>mowers)throws IOException{
        BufferedWriter buf=new BufferedWriter(new OutputStreamWriter(out));
        for(Mower m:mowers){
            buf.write(m.toString());
            buf.newLine();
        }
        buf.flush();
        scanner.close();

    }
}
