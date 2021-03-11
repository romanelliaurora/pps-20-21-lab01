import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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





}
