import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    //TODO: test implementation

    @BeforeEach
    void beforeEach(){

        CircularList list = new CircularListImpl();
    }


    @Disabled
    @Test public void testTodo(){
        Assertions.fail();
    }

}
