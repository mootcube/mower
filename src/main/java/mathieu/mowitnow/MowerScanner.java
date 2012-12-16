package mathieu.mowitnow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

/**
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 */
public class MowerScanner {
    private static Logger l= LoggerFactory.getLogger(MowerScanner.class);
    private MowerScanner(){
    }

    private static enum ScannerState{LAWN_X,LAWN_Y,POSITION_X,POSITION_Y,ORIENTATION,ACTIONS};

    private static int getLawnX(Scanner scanner) throws LawnIOException {
        try {
            int x = scanner.nextInt();
            if(x<=0)throw new LawnIOException("Lawn should have positive dimensions");
            return x;
        } catch (InputMismatchException e) {
            l.error("ScannerError during parsing lawn x, got '{}' instead.",scanner.next());
        }catch (NoSuchElementException e){
            l.error("ScannerError during parsing lawn x, scanner is empty.");
        }catch (IllegalStateException e){
            l.error("ScannerError during parsing lawn x, scanner is closed.");
        }
        throw new LawnIOException("Something went wrong");
    }

    private static int getLawnY(Scanner scanner) throws LawnIOException {
        try {
            int y = scanner.nextInt();
            if(y<=0)throw new LawnIOException("Lawn should have positive dimensions");
            return y;
        } catch (InputMismatchException e) {
            l.error("ScannerError during parsing lawn y, got '{}' instead.",scanner.next());
        }catch (NoSuchElementException e){
            l.error("ScannerError during parsing lawn y, scanner is empty.");
        }catch (IllegalStateException e){
            l.error("ScannerError during parsing lawn y, scanner is closed.");
        }
        throw new LawnIOException("Something went wrong");
    }

    private static int getPositionX(Scanner scanner) throws MowerIOException {
        try {
            int x = scanner.nextInt();
            if(x<=0)throw new MowerIOException("Mower should have positive dimensions");
            return x;
        } catch (InputMismatchException e) {
            l.error("ScannerError during parsing position x got '{}' instead.",scanner.next());
        }catch (NoSuchElementException e){
            l.error("ScannerError during parsing position x, scanner is empty.");
        }catch (IllegalStateException e){
            l.error("ScannerError during parsing position x, scanner is closed.");
        }
        throw new MowerIOException("Something went wrong");
    }

    private static int getPositionY(Scanner scanner) throws MowerIOException {
        try {
            int y = scanner.nextInt();
            if(y<=0)throw new MowerIOException("Mower should have positive dimensions");
            return y;
        } catch (InputMismatchException e) {
            l.error("ScannerError during parsing position y, got '{}' instead.",scanner.next());
        }catch (NoSuchElementException e){
            l.error("ScannerError during parsing position y, scanner is empty.");
        }catch (IllegalStateException e){
            l.error("ScannerError during parsing position y, scanner is closed.");
        }
        throw new MowerIOException("Something went wrong");
    }

    private static Orientation getOrientation(Scanner scanner) throws MowerIOException {
        String orientation="";
        try {
            orientation = scanner.next();
            Orientation o=Orientation.valueOf(orientation);
            return o;
        } catch (IllegalArgumentException e) {
            l.error("ScannerError during parsing orientation, got '{}' instead.",orientation);
        }catch (NoSuchElementException e){
            l.error("ScannerError during parsing orientation, scanner is empty.");
        }catch (IllegalStateException e){
            l.error("ScannerError during parsing orientation, scanner is closed.");
        }
        throw new MowerIOException("Something went wrong");
    }

    private static List<Action> getActions(Scanner scanner) throws MowerIOException {
        ArrayList<Action> actions=new ArrayList<Action>();
        String actionsInput="";
        char currentAction=' ';
        try {
            actionsInput = scanner.next();
            for(char i:actionsInput.toUpperCase().toCharArray()){
                currentAction=i;
                Action theAction=Action.valueOf(String.valueOf(i));
                actions.add(theAction);
            }
            return actions;
        } catch (IllegalArgumentException e) {
            l.error("ScannerError during parsing orientation, got '{}' instead.",currentAction);
        }catch (NoSuchElementException e){
            l.error("ScannerError during parsing orientation, scanner is empty.");
        }catch (IllegalStateException e){
            l.error("ScannerError during parsing orientation, scanner is closed.");
        }
        throw new MowerIOException("Something went wrong");
    }

    public static Lawn processInput(InputStream inputStream)throws MowerIOException,LawnIOException {
        Scanner scanner=new Scanner(inputStream);
        int x,y;
        x=getLawnX(scanner);
        y=getLawnY(scanner);
        Lawn lawn = new Lawn(x+1,y+1);
        ArrayList<Mower> mowers = new ArrayList<Mower>();
        do{
            int p_x=getPositionX(scanner);
            int p_y=getPositionY(scanner);
            Lawn.Position position= lawn.new Position(p_x,p_y);
            Orientation m_orientation=getOrientation(scanner);
            Mower m=new Mower(position,m_orientation);
            for(Action action:getActions(scanner)){
                m.carryAction(action);
            }
            lawn.putMower(m);
        }while(scanner.hasNext());
        return lawn;
    }


}
