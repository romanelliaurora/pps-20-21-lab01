package lab01.tdd;

public class multipleOfStrategy implements SelectStrategy {
    private final int multiplier;

    public multipleOfStrategy(int multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public boolean apply(int element) {
        return false;
    }
}
