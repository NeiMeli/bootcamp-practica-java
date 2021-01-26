package clase4.tt;

import common.ConsoleOutputTest;
import org.junit.jupiter.api.Test;

public class InvitadoTest extends ConsoleOutputTest {
    @Test
    void testInvitado() {
        Invitado invitado1 = new Invitado("Invitado-1");
        Invitado invitado2 = new Invitado("Invitado-2");
        invitado1.comerTorta();
        invitado2.comerTorta();
        assertConsoleOutput("Invitado-1", "Invitado-2");
    }

    @Test
    void testInvitadoMeli() {
        Invitado invitado1 = new InvitadoMeli("Invitado-Meli-1");
        invitado1.comerTorta();
        assertConsoleOutput("Invitado-Meli-1", "Viva la Chiqui!!");
    }
}
