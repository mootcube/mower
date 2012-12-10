package moot.mowitnow;

/**
 * Created with IntelliJ IDEA.
 * User: moot
 * Date: 12/9/12
 * Time: 10:25 PM
 * To change this template use File | Settings | File Templates.
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
