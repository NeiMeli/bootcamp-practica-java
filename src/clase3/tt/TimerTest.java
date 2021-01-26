package clase3.tt;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TimerTest {
    @Test
    void testTimer () throws InterruptedException {
        Timer timer = new Timer();
        Runnable assertStartIsZero = () -> assertEquals(0L, timer.getStart());
        Runnable assertStopIsZero = () -> assertEquals(0L, timer.getStop());
        Runnable assertElapsedTimeIsZero = () -> assertEquals(0L, timer.elapsedTime());

        Runnable assertReset = () -> {
            assertStartIsZero.run();
            assertStopIsZero.run();
            assertElapsedTimeIsZero.run();
        };

        // init values
        assertReset.run();

        // elapsed time
        timer.start();
        assertStopIsZero.run();
        TimeUnit.MILLISECONDS.sleep(60);
        timer.stop();
        assertTrue(timer.elapsedTime() >= 60L);

        // reset
        timer.reset();
        assertReset.run();

        // elapsed time sin stop, debería frenarlo automáticamente
        timer.start();
        assertStopIsZero.run();
        TimeUnit.MILLISECONDS.sleep(80);
        assertTrue(timer.elapsedTime() >= 80L);
        timer.reset();

        // stop sin start, debería quedar en 0
        timer.stop();
        assertStopIsZero.run();
    }
}