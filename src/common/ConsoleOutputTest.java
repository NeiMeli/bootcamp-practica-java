package common;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsoleOutputTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    protected void assertConsoleOutput(String ... expectedOutputs) {
        String sysout = outputStreamCaptor.toString();
        for (String expectedOutput : expectedOutputs) {
            assertTrue(sysout.contains(expectedOutput));
        }
    }

    protected void assertConsoleDidNotOutput(String ... expectedOutputs) {
        String sysout = outputStreamCaptor.toString();
        for (String expectedOutput : expectedOutputs) {
            assertFalse(sysout.contains(expectedOutput));
        }
    }

    protected void clearConsole() {
        outputStreamCaptor.reset();
    }
}
