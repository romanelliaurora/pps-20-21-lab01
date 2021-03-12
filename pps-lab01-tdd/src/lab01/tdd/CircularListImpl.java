package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {
    final List<Integer> list = new ArrayList<Integer>();
    int pointer = 0;

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public Optional<Integer> next() {
        Optional<Integer> currentElement;
        if (list.isEmpty()){
            currentElement = Optional.empty();
        }
        else{
            currentElement = Optional.of(list.get(pointer));
        }
        pointer++;
        if(list.size()==pointer){
            pointer = 0;
        }
        return currentElement;
    }

    @Override
    public Optional<Integer> previous() {
        Optional<Integer> currentElement;
        if(pointer==0){
            pointer = list.size()-1;
        }
        else {
            pointer--;
        }
        currentElement = Optional.of(list.get(pointer));
        return currentElement;
    }

    @Override
    public void reset() {
        pointer = list.get(0);
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        int finishPointer = (pointer==0 ? list.size() :pointer)-1;
        while (!strategy.apply(list.get(pointer)) && finishPointer!=pointer){
            next();
        }
        return finishPointer == pointer ? Optional.empty() :Optional.of(list.get(pointer));
    }
}
