package clase4.tm.ejercicio2;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CarreraTest {
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

    @Test
    void testCarreraComplete() {
        final Carrera carrera = new Carrera(100, 950000, "Casi un palo", 4);
        assertEquals(0, carrera.getListaDeVehiculos().size());
        carrera.darDeAltaAuto(180, 7,5.7, "AUTO-1");
        carrera.darDeAltaAuto(220, 4,8.9, "AUTO-2");
        carrera.darDeAltaMoto(270, 10,12, "MOTO-1");
        carrera.darDeAltaAuto(200, 8,7.2, "MOTO-2");
        assertEquals(4, carrera.getListaDeVehiculos().size());

        // cupo completo, no debería poder sumar más vehículos
        assertThrows(Carrera.CarreraException.class, () -> carrera.darDeAltaAuto(160, 10,2.7, "AUTO-3"));

        // Socorrer
        assertThrows(Carrera.CarreraException.class, () -> carrera.socorrerAuto("MOTO-1"));
        assertThrows(Carrera.CarreraException.class, () -> carrera.socorrerMoto("MOTO-3"));
        carrera.socorrerAuto("AUTO-1");
        carrera.socorrerMoto("MOTO-1");

        String sysout = outputStreamCaptor.toString();
        assertTrue(sysout.contains("Socorriendo auto AUTO-1"));
        assertTrue(sysout.contains("Socorriendo moto MOTO-1"));

        // ganador
        assertTrue(carrera.getGanador().tienePatente("MOTO-1"));

        // eliminar vehículos
        final Vehiculo auto1 = new Auto(180, 7, 5.7, "AUTO-1");
        carrera.eliminarVehiculo(auto1);
        assertEquals(3, carrera.getListaDeVehiculos().size());
        assertTrue(carrera.getListaDeVehiculos().stream().noneMatch(v -> v.tienePatente("AUTO-1")));

        carrera.eliminarVehiculoConPatente("MOTO-2");
        assertEquals(2, carrera.getListaDeVehiculos().size());
        assertTrue(carrera.getListaDeVehiculos().stream().noneMatch(v -> v.tienePatente("MOTO-2")));

        // elimino vehiculo que no existe, no debería pasar nada
        carrera.eliminarVehiculoConPatente("AUTO-3");
        assertEquals(2, carrera.getListaDeVehiculos().size());
        carrera.eliminarVehiculo(auto1);
        assertEquals(2, carrera.getListaDeVehiculos().size());

        final Carrera carrera2 = new Carrera(100, 950000, "Casi un palo", 4);
        assertThrows(Carrera.CarreraException.class, carrera2::getGanador);
    }
}