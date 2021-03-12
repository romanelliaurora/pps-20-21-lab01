package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {
    final List<Integer> list = new ArrayList<Integer>();
    int pointer = -1;

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
        pointer++;
        if(pointer==list.size()){
            pointer = 0;
        }
        if (list.isEmpty()){
            return Optional.empty();
        }
        else{
            return Optional.of(list.get(pointer));
        }
    }

    @Override
    public Optional<Integer> previous() {
        if(pointer==0 || pointer==-1){
            pointer = list.size()-1;
        }
        else {
            pointer--;
        }
        return Optional.of(list.get(pointer));
    }

    @Override
    public void reset() {
        pointer = -1;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        int finishPointer = pointer==-1? list.size()-1:pointer;
        do {
            next();
            if (strategy.apply(list.get(pointer))){
                return Optional.of(list.get(pointer));
            }
        }
            while(finishPointer!=pointer);
        return Optional.empty();

    }
}
