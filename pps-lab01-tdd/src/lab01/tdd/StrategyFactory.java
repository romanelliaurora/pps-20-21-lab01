package lab01.tdd;

public class StrategyFactory implements AbstractFactory{
    @Override
    public SelectStrategy getEquals(int element) {
        return new equalsStrategy(element);
    }

    @Override
    public SelectStrategy getMultiple(int multiplier) {
        return new multipleOfStrategy(multiplier);
    }

    @Override
    public SelectStrategy getEvens() {
        return new evenStrategy();
    }

}
