package mathieu.mowitnow;

/**
 * User: <a href="mailto:mathieu.chataigner@gmail.com">Mathieu Chataigner</a>
 */
public enum Orientation{
    N,E,S,W;
    private static final int length=Orientation.values().length;
    public Orientation next(){
        int idx=0;
        for(int i=0;i<Orientation.values().length;i++)
        {
            if(Orientation.values()[i]==this){
                idx=i;
                break;
            }
        }
        return Orientation.values()[(idx+1)%length];
    }
    public Orientation previous(){
        int idx=0;
        for(int i=0;i<Orientation.values().length;i++)
        {
            if(Orientation.values()[i]==this){
                idx=i;
                break;
            }
        }
        return Orientation.values()[(idx+length-1)%length];
    }
}
