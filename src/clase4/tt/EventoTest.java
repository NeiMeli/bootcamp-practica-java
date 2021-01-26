package clase4.tt;

import common.ConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventoTest extends ConsoleOutputTest {
    @Test
    void testEventoCompleteTest() {
        Supplier<FuegoArtificial> fa1 = () -> new FuegoArtificial("Ruido-1");
        Supplier<FuegoArtificial> fa2 = () -> new FuegoArtificial("Ruido-2");
        Supplier<FuegoArtificial> fa3 = () -> new FuegoArtificial("Ruido-3");
        FuegoArtificial fa4 = new FuegoArtificial("Ruido-3");

        Supplier<PackFuegosArtificiales> pfa1 = () -> new PackFuegosArtificiales(Arrays.asList(fa1.get(), fa2.get()));
        PackFuegosArtificiales pfa2 = new PackFuegosArtificiales(Arrays.asList(pfa1.get(), fa3.get()));

        Invitado invitado1 = new Invitado("Invitado-1");
        Invitado invitado2 = new Invitado("Invitado-2");
        Invitado invitadoMeli1 = new InvitadoMeli("Invitado-Meli-1");

        Evento evento = new Evento();
        assertEquals(0, evento.getExplotablesDisponibles().size());
        assertEquals(0, evento.getExplotablesDisponibles().size());
        evento.addExplotable(fa1.get(), pfa1.get(), pfa2);
        assertEquals(3, evento.getExplotablesDisponibles().size());
        evento.addInvitado(invitado1, invitado2, invitadoMeli1);
        assertEquals(3, evento.getInvitados().size());

        // reviento el fa4, después lo agrego al evento, no debería estar disponible como explotable
        fa4.explotar();
        evento.addExplotable(fa4);
        assertEquals(3, evento.getExplotablesDisponibles().size());
        clearConsole();

        evento.apagarVelas();
        assertConsoleOutput("Ruido-1", "Ruido-2", "Ruido-3");
        assertConsoleOutput("Invitado-1", "Invitado-2", "Invitado-Meli-1", "Viva la Chiqui!!");
        assertConsoleDidNotOutput("Ruido-4");
        assertEquals(0, evento.getExplotablesDisponibles().size());
    }
}
