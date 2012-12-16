package mathieu.mowitnow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 */
public class Lawn {
    private static Logger logger= LoggerFactory.getLogger(Lawn.class);
    private ArrayList<Mower> mowers=new ArrayList<Mower>();
    private final int length,height;
    public Lawn(int length, int height)throws IllegalArgumentException{
        if(length<=0 || height<=0){
            logger.error("Invalid size ({},{}) for a lawn.",length,height);
            throw new IllegalArgumentException("Invalid size ("+length+","+height+") for a lawn.");
        }
        logger.debug("initialize a new Lawn: length "+length+" height "+height);
        this.height = height;
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }



    public void putMower(Mower mower){
        mowers.add(mower);
    }

    public List<Mower> getMowers(){
        return mowers;
    }

    @Override
    public String toString(){
        StringBuilder builder=new StringBuilder();
        for(Mower m:mowers){
            builder.append(m.toString());
            builder.append("\n");
        }
        return builder.toString();
    }

    public final class Position {
        private final int x,y;

        public Position(int x, int y) throws IndexOutOfBoundsException{
            if(x<0||x> Lawn.this.getLength()||y<0||y> Lawn.this.getHeight()){
                logger.error("invalid Position ("+x+","+y+") is outside the Lawn [(0:"+Lawn.this.getLength()+");(0:"+Lawn.this.getHeight()+")]");
                throw new IndexOutOfBoundsException("("+x+","+y+") out of {(0,0),("+Lawn.this.getLength()+","+Lawn.this.getHeight()+")");
            }
            this.x=x;
            this.y=y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o){
            if(o==this)return true;
            if(!(o instanceof Position)) return false;
            Position p=(Position)o;
            return this.x==p.x && this.y==p.y;
        }

        @Override
        public int hashCode(){
            return (17+x)*31+y;
        }

        @Override
        public String toString(){
            return "(x:"+x+",y:"+y+")";
        }

        public Position getNearPosition(Orientation orientation){
            switch (orientation){
                case N:
                    if(y==Lawn.this.getHeight()){
                        return this;
                    }
                    else{
                        return new Position(x,y+1);
                    }
                case E:
                    if(x==Lawn.this.getLength()){
                        return this;
                    }
                    else{
                        return new Position(x+1,y);
                    }
                case S:
                    if(y==0){
                        return this;
                    }
                    else{
                        return new Position(x,y-1);
                    }
                case W:
                    if(x==0){
                        return this;
                    }
                    else{
                        return new Position(x-1,y);
                    }
            }
            throw new NullPointerException();
        }
    }

}
