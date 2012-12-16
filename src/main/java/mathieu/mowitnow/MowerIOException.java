package mathieu.mowitnow;

import java.io.IOException;

/**
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 */
public class MowerIOException extends IOException {
    public MowerIOException(){}
    public MowerIOException(String message){
        super(message);
    }
}
