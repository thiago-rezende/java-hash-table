package horus.hash_table;

import org.junit.Test;
import static org.junit.Assert.*;

public class ApplicationTest {
    @Test public void testApplicationHasAGreeting() {
        Application classUnderTest = new Application();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}
