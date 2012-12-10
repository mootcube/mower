package moot.mowitnow;

/**
 * Created with IntelliJ IDEA.
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 * Date: 12/9/12
 * Time: 10:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class Plateau{
    private final int length,height;
    public Plateau(int length,int height){
        this.height = height;
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public final class Position {
        private final int x,y;

        public Position(int x, int y) throws IndexOutOfBoundsException{
            if(x<0||x>=Plateau.this.getLength()||y<0||y>=Plateau.this.getHeight())throw new IndexOutOfBoundsException("("+x+","+y+") out of {(0,0),("+Plateau.this.getLength()+","+Plateau.this.getHeight()+")");
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
                    if(y==Plateau.this.getHeight()-1){
                        return this;
                    }
                    else{
                        return new Position(x,y+1);
                    }
                case E:
                    if(x==Plateau.this.getLength()-1){
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
