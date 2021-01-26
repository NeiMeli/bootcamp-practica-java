package clase4.tt;

import common.ConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

public class ExplotableImplsTest extends ConsoleOutputTest {
    @Test
    void testFuegoArtificial() {
        FuegoArtificial fa1 = new FuegoArtificial("Ruido-1");
        FuegoArtificial fa2 = new FuegoArtificial("Ruido-2");
        assertTrue(fa1.estaDisponible());
        assertTrue(fa2.estaDisponible());

        fa1.explotar();
        assertConsoleOutput("Ruido-1");

        fa2.explotar();
        assertConsoleOutput("Ruido-2");

        assertFalse(fa1.estaDisponible());
        assertFalse(fa2.estaDisponible());
        clearConsole();

        fa1.explotar();
        assertConsoleOutput(Explotable.NO_DISPONIBLE_MSG);
        assertConsoleDidNotOutput("Ruido-1");
    }

    @Test
    void testPackFuegosArtificiales() {
        Supplier<FuegoArtificial> fa1 = () -> new FuegoArtificial("Ruido-1");
        Supplier<FuegoArtificial> fa2 = () -> new FuegoArtificial("Ruido-2");
        Supplier<FuegoArtificial> fa3 = () -> new FuegoArtificial("Ruido-3");

        Supplier<PackFuegosArtificiales> pfa1S = () -> new PackFuegosArtificiales(Arrays.asList(fa1.get(), fa2.get()));
        PackFuegosArtificiales pfa1 = pfa1S.get();
        assertTrue(pfa1.estaDisponible());
        pfa1.explotar();
        assertFalse(pfa1.estaDisponible());
        assertConsoleOutput("Ruido-1", "Ruido-2");
        clearConsole();

        PackFuegosArtificiales pfa2 = new PackFuegosArtificiales();
        assertEquals(0, pfa2.getExplotables().size());
        pfa2.addExplotable(pfa1); // le paso un pack reventado, no tiene que estar disponible
        pfa2.addExplotable(fa3.get());
        assertFalse(pfa2.estaDisponible());
        pfa2.explotar();
        assertConsoleOutput(Explotable.NO_DISPONIBLE_MSG);
        assertConsoleDidNotOutput("Ruido-1", "Ruido-2", "Ruido-3");

        PackFuegosArtificiales pfa3 = new PackFuegosArtificiales(Arrays.asList(pfa1S.get(), fa3.get()));
        assertEquals(2, pfa3.getExplotables().size());
        pfa3.explotar();
        assertConsoleOutput("Ruido-1", "Ruido-2", "Ruido-3");
    }
}
