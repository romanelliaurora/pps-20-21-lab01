import lab01.tdd.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private CircularList list;
    private static AbstractFactory factory;
    int i;

    @BeforeAll
    static void  beforeAll(){factory = new StrategyFactory();}

    @BeforeEach
    void beforeEach(){
        list = new CircularListImpl();
    }

    @Test public void testAddElement(){
        list.add(5);
        assertEquals(1, list.size());
    }

    @Test public void testMultipleAddElement(){
        createCircularList(5);
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
        createCircularList(3);
        assertEquals(Optional.of(0), list.next());
    }

    @Test public void testDoubleNextElement(){
        createCircularList(3);
        list.next();
        assertEquals(Optional.of(1), list.next());
    }

    @Test public void testCircularNextElement(){
        createCircularList(3);
        list.next();
        list.next();
        list.next();
        assertEquals(Optional.of(0), list.next());
    }

    @Test public void testEmptyNextElement(){
        assertEquals(Optional.empty(), list.next());
    }

    @Test public void testNextPreviousElement(){
        createCircularList(3);
        list.next();
        list.next();
        assertEquals(Optional.of(0), list.previous());
    }

    @Test public void testPreviousCircularElement(){
        createCircularList(3);
        assertEquals(Optional.of(2), list.previous());
    }

    @Test public void testPreviousNextElement(){
        createCircularList(3);
        list.previous();
        assertEquals(Optional.of(0), list.next());
    }

    @Test public void testResetElement(){
        createCircularList(3);
        list.next();
        list.next();
        list.reset();
        assertEquals(Optional.of(0), list.next());
    }
    @Test public void testEvenStrategy(){
        createCircularList(3);
        list.next();
        assertEquals(Optional.of(2),list.next(factory.getEvens()));
    }

    @Test public void testEvenStrategyWithNoEven(){
        for (i = 0; i <3 ; i++){
            list.add(3);
        }
        assertEquals(Optional.empty(),list.next(factory.getEvens()));
    }

    @Test public void testMultipleOfStrategy(){
        createCircularList(4);
        list.next();
        assertEquals(Optional.of(3),list.next(factory.getMultiple(3)));
    }

    @Test public void testMultipleOfStrategyWithNoMultiple(){
        createCircularList(3);
        list.next();
        assertEquals(Optional.of(0),list.next(factory.getMultiple(5)));
    }

    @Test public void testMultipleOfStrategyWithZero(){
        createCircularList(3);
        list.next();
        assertEquals(Optional.of(0),list.next(factory.getMultiple(0)));
    }

    @Test public void testEqualsStrategy(){
        createCircularList(3);
        assertEquals(Optional.of(2),list.next(factory.getEquals(2)));
    }

    @Test public void testEqualsStrategyWithNoEqualElement(){
        createCircularList(3);
        assertEquals(Optional.empty(),list.next(factory.getEquals(3)));
    }

    private void createCircularList (int numElement){
        for (i = 0; i <numElement ; i++){
            list.add(i);
        }
    }
}
