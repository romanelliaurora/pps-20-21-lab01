package lab01.tdd;

public class equalsStrategy implements SelectStrategy {
    private final int element2;

    public equalsStrategy(int element2) {
        this.element2 = element2;
    }

    @Override
    public boolean apply(int element1) {
        return element1 == element2;
    }
}
