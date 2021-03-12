package lab01.tdd;

public class evenStrategy implements SelectStrategy {
    @Override
    public boolean apply(int element) {
        if(element%2==0)
        return true;
        else return false;
    }
}
