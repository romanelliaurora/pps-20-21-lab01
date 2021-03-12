package lab01.tdd;

public class multipleOfStrategy implements SelectStrategy {
    private final int multiplier;

    public multipleOfStrategy(int multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public boolean apply(int element) {
        if (multiplier == 0){
            return element == 0;
        }
        return element % multiplier == 0;
    }
}
