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
        list = createCircularList(5);
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
        list = createCircularList(3);
        assertEquals(Optional.of(0), list.next());
    }

    @Test public void testDoubleNextElement(){
        list = createCircularList(3);
        list.next();
        assertEquals(Optional.of(1), list.next());
    }

    @Test public void testCircularNextElement(){
        list = createCircularList(3);
        list.next();
        list.next();
        list.next();
        assertEquals(Optional.of(0), list.next());
    }

    @Test public void testEmptyNextElement(){
        assertEquals(Optional.empty(), list.next());
    }

    @Test public void testNextPreviousElement(){
        list = createCircularList(3);
        list.next();
        list.next();
        assertEquals(Optional.of(0), list.previous());
    }

    @Test public void testPreviousCircularElement(){
        list = createCircularList(3);
        assertEquals(Optional.of(2), list.previous());
    }

    @Test public void testPreviousNextElement(){
        list = createCircularList(3);
        list.previous();
        assertEquals(Optional.of(0), list.next());
    }

    @Test public void testResetElement(){
        list = createCircularList(3);
        list.next();
        list.next();
        list.reset();
        assertEquals(Optional.of(0), list.next());
    }
    @Test public void testEvenStrategy(){
        list = createCircularList(3);
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
        list = createCircularList(4);
        list.next();
        assertEquals(Optional.of(3),list.next(new multipleOfStrategy(3)));
    }

    @Test public void testMultipleOfStrategyWithNoMultiple(){
        list = createCircularList(3);
        list.next();
        assertEquals(Optional.of(0),list.next(new multipleOfStrategy(5)));
    }

    @Test public void testMultipleOfStrategyWithZero(){
        list = createCircularList(3);
        list.next();
        assertEquals(Optional.of(0),list.next(new multipleOfStrategy(0)));
    }

    @Test public void testEqualsStrategy(){
        list = createCircularList(3);
        assertEquals(Optional.of(2),list.next(new equalsStrategy(2)));
    }

    @Test public void testEqualsStrategyWithNoEqualElement(){
        list = createCircularList(3);
        assertEquals(Optional.empty(),list.next(new equalsStrategy(3)));
    }

    private CircularList createCircularList (int numElement){
        for (i = 0; i <numElement ; i++){
            list.add(i);
        }
        return list;
    }
}
