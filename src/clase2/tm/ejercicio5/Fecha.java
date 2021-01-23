package clase2.tm.ejercicio5;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {
    private Date fecha;

    public Fecha() {
        setFecha(GregorianCalendar.getInstance().getTime());
    }

    public Fecha(Date fecha) {
        setFecha(fecha);
    }

    public Date getFecha() {
        return fecha;
    }

    public void sumarDia() {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        setFecha(cal.getTime());
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public static boolean esCorrecta(int año, int mes, int dia) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setLenient(false);
        cal.set(año, mes, dia);
        try {
            new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime());
            return true;
        } catch (final Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return fecha.toString();
    }
}
