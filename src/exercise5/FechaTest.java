package exercise5;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class FechaTest {

    @Test
    void defaultConstructor() {
        Fecha fecha = new Fecha();
        assertEquals(GregorianCalendar.getInstance().getTime(), fecha.getFecha());
    }

    @Test
    void parametrizedConstructor() {
        Date date = new GregorianCalendar(1992, Calendar.SEPTEMBER, 22).getTime();
        Fecha fecha = new Fecha(date);
        assertEquals(date, fecha.getFecha());
    }

    @Test
    void sumarDia() {
        Date date = new GregorianCalendar(1992, Calendar.SEPTEMBER, 22).getTime();
        Fecha fecha = new Fecha(date);
        Date datePlusOneDay = new GregorianCalendar(1992, Calendar.SEPTEMBER, 23).getTime();
        fecha.sumarDia();
        assertEquals(datePlusOneDay, fecha.getFecha());
    }

    @Test
    void esCorrecta() {
        assertFalse(Fecha.esCorrecta(-800, 30, 200));
        assertFalse(Fecha.esCorrecta(-800, 30, 200));
        assertFalse(Fecha.esCorrecta(1900, 10, 200));
        assertTrue(Fecha.esCorrecta(1900, 10, 2));
    }
}