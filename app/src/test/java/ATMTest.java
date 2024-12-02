import org.junit.jupiter.api.Test;

import com.app.ATM;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    @Test
    void testProcessAmount() {
        ATM atm = new ATM();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        atm.process(3205);

        String expectedOutput = "Please receive 1 x 5\n" +
                                "Please receive 0 x 50\n" +
                                "Please receive 32 x 100\n";

        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }

    @Test
    void testProcessAmountWithInvalidAmount() {
        ATM atm = new ATM();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        try {
            atm.process(7);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("The amount cannot be issued", e.getMessage());
        }

        System.setOut(System.out);
    }

    @Test
    void testEdgeCase() {
        ATM atm = new ATM();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        atm.process(1000);

        String expectedOutput = "Please receive 0 x 5\n" +
                                "Please receive 0 x 50\n" +
                                "Please receive 10 x 100\n";
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }

    @Test
    void testExactAmount() {
        ATM atm = new ATM();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        atm.process(100);

        String expectedOutput = "Please receive 0 x 5\n" +
                                "Please receive 0 x 50\n" +
                                "Please receive 1 x 100\n";
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }
}
