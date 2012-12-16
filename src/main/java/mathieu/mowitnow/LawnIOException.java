package mathieu.mowitnow;

import java.io.IOException;

/**
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 */
public class LawnIOException extends IOException {
    public LawnIOException(){}
    public LawnIOException(String message){
        super(message);
    }
}
