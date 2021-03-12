import lab01.tdd.*;

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
    int i;

    @BeforeEach
    void beforeEach(){
        list = new CircularListImpl();
    }

    @Test public void testAddElement(){
        list.add(5);
        assertEquals(1, list.size());
    }

    @Test public void testMultipleAddElement(){
        for (i = 0; i <5 ; i++){
            list.add(i);
        }

        assertEquals(5, list.size());
    }

    @Test public void testEmpty(){
        assertTrue(list.isEmpty());
    }

    @Test public void testNotEmpty(){
        list.add(5);
        assertFalse(list.isEmpty());
    }

    @Test public void testNextElement(){
        for (i = 0; i <3 ; i++){
            list.add(i);
        }
        assertEquals(Optional.of(0), list.next());
    }

    @Test public void testDoubleNextElement(){
        for (i = 0; i <3 ; i++){
            list.add(i);
        }
        list.next();
        assertEquals(Optional.of(1), list.next());
    }

    @Test public void testCircularNextElement(){
        for (i = 0; i <3 ; i++){
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
        for (i = 0; i <3 ; i++){
            list.add(i);
        }
        list.next();
        list.next();
        assertEquals(Optional.of(0), list.previous());
    }

    @Test public void testPreviousCircularElement(){
        for (i = 0; i <3 ; i++){
            list.add(i);
        }
        assertEquals(Optional.of(2), list.previous());
    }

    @Test public void testPreviousNextElement(){
        for (i = 0; i <3 ; i++){
            list.add(i);
        }
        list.previous();
        assertEquals(Optional.of(0), list.next());
    }

    @Test public void testResetElement(){
        for (i = 0; i <3 ; i++){
            list.add(i);
        }
        list.next();
        list.next();
        list.reset();
        assertEquals(Optional.of(0), list.next());
    }
    @Test public void testEvenStrategy(){
        for (i = 0; i <3 ; i++){
            list.add(i);
        }
        list.next();
        assertEquals(Optional.of(2),list.next(new evenStrategy()));
    }

    @Test public void testEvenStrategyWithNoEven(){
        for (i = 0; i <3 ; i++){
            list.add(3);
        }
        assertEquals(Optional.empty(),list.next(new evenStrategy()));
    }

    @Test public void testMultipleOfStrategy(){
        for (i = 0; i <4 ; i++){
            list.add(i);
        }
        list.next();
        assertEquals(Optional.of(3),list.next(new multipleOfStrategy(3)));
    }

    @Test public void testMultipleOfStrategyWithNoMultiple(){
        for (i = 0; i <3 ; i++){
            list.add(i);
        }
        list.next();
        assertEquals(Optional.of(0),list.next(new multipleOfStrategy(5)));
    }

    @Test public void testMultipleOfStrategyWithZero(){
        for (i = 0; i <3 ; i++){
            list.add(i);
        }
        list.next();
        assertEquals(Optional.of(0),list.next(new multipleOfStrategy(0)));
    }

    @Test public void testEqualsStrategy(){
        for (i = 0; i <3 ; i++){
            list.add(i);
        }
        assertEquals(Optional.of(2),list.next(new equalsStrategy(2)));
    }

    @Test public void testEqualsStrategyWithNoEqualElement(){
        for (i = 0; i <3 ; i++){
            list.add(i);
        }
        assertEquals(Optional.empty(),list.next(new equalsStrategy(3)));
    }

}
