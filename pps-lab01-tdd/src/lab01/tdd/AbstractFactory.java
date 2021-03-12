package lab01.tdd;

public interface AbstractFactory {
    public SelectStrategy getEquals(int element);
    public SelectStrategy getMultiple(int multiplier);
    public SelectStrategy getEvens();
}
