import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    //final List circularList = new ArrayList();
    private CircularList list;
    @BeforeEach
    void beforeEach(){
        list = new CircularListImpl();
    }

    @Test public void testAddElement(){
        list.add(5);
        assertEquals(1, list.size());
    }

    @Test public void testMultipleAddElement(){
        for (int i = 0; i <5 ; i++){
            list.add(i);
        }

        assertEquals(5, list.size());
    }

    @Test public void testEmpty(){
       assertEquals(true, list.isEmpty());
    }

    @Test public void testNotEmpty(){
        list.add(5);
        assertEquals(false, list.isEmpty());
    }

    @Test public void testNextElement(){
        for (int i = 0; i <3 ; i++){
            list.add(i);
        }
        assertEquals(Optional.of(0), list.next());
    }

    @Test public void testDoubleNextElement(){
        for (int i = 0; i <3 ; i++){
            list.add(i);
        }
        list.next();
        assertEquals(Optional.of(1), list.next());
    }

    @Test public void testCircularNextElement(){
        for (int i = 0; i <3 ; i++){
            list.add(i);
        }
        list.next();
        list.next();
        list.next();
        assertEquals(Optional.of(0), list.next());
    }

    @Test public void testEmptyNextElement(){
        assertEquals(Optional.empty(), list.next());
    }

    @Test public void testNextPreviousElement(){
        for (int i = 0; i <3 ; i++){
            list.add(i);
        }
        list.next();
        assertEquals(Optional.of(0), list.previous());
    }

    @Test public void testPreviousCircularElement(){
        for (int i = 0; i <3 ; i++){
            list.add(i);
        }
        assertEquals(Optional.of(2), list.previous());
    }

    @Test public void testPreviousNextElement(){
        for (int i = 0; i <3 ; i++){
            list.add(i);
        }
        list.previous();
        assertEquals(Optional.of(2), list.next());
    }

    @Test public void testResetElement(){
        for (int i = 0; i <3 ; i++){
            list.add(i);
        }
        list.next();
        list.next();
        list.reset();
        assertEquals(Optional.of(0), list.next());
    }

}
