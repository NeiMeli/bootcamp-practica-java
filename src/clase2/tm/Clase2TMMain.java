package clase2.tm;

import clase2.tm.ejercicio1.CuentaCorriente;
import clase2.tm.ejercicio2.Contador;
import clase2.tm.ejercicio3.Libro;
import clase2.tm.ejercicio4.Fraccion;
import clase2.tm.ejercicio5.Fecha;
import menu.Menu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

import static common.IOUtil.*;

public class Clase2TMMain {
    public static void main(String[] args) {
        buildMenu(null).execute();
    }
    
    public static Menu buildMenu(@Nullable Menu parent) {
        final Menu menu = new Menu("Turno Mañana", parent);
        menu.addItem("Ejercicio 1 - Cuenta corriente", () -> Clase2TMMain.exercise1(menu));
        menu.addItem("Ejercicio 2 - Contador", () -> Clase2TMMain.exercise2(menu));
        menu.addItem("Ejercicio 3 - Libro", () -> Clase2TMMain.exercise3(menu));
        menu.addItem("Ejercicio 4 - Fraccion", () -> Clase2TMMain.exercise4(menu));
        menu.addItem("Ejercicio 5 - Fecha", () -> Clase2TMMain.exercise5(menu));
        menu.addItem("Ejercicio 6 - StringUtil 2.0", Clase2TMMain::exercise6);
        return menu;
    }

    private static void exercise1(@NotNull Menu parent) {
        Menu creationMenu = new Menu("Creemos una cuenta corriente", parent);
        AtomicReference<CuentaCorriente> meliAccount = new AtomicReference<>();
        Supplier<CuentaCorriente> meliAccountSupplier = () -> {
            if (meliAccount.get() == null) {
                meliAccount.set(new CuentaCorriente(500000));
            }
            return meliAccount.get();
        };
        AtomicReference<CuentaCorriente> cuentaCorrienteHolder = new AtomicReference<>();
        creationMenu.addItem("Default (monto 0)", () -> cuentaCorrienteHolder.set(new CuentaCorriente()), true);
        creationMenu.addItem("Monto incial", () -> {
            double input = ensureDoubleInput("Ingrese el valor inicial del monto. Debe ser positivo.", d -> d > 0);
            cuentaCorrienteHolder.set(new CuentaCorriente(input));
        }, true);
        creationMenu.addItem("Copiar cuenta de Meli", () -> cuentaCorrienteHolder.set(meliAccountSupplier.get()), true);
        creationMenu.execute();

        CuentaCorriente cuentaCorriente = cuentaCorrienteHolder.get();
        if (cuentaCorriente == null) return;

        Menu menu = new Menu(() -> String.format("Cuenta corriente - Saldo %s", cuentaCorriente.getSaldo()), parent);
        menu.addItem("Ingreso", () -> {
            double ingreso = ensureDoubleInput("Ingrese un monto positivo. Se añadirá a la cuenta corriente", d -> d > 0);
            cuentaCorriente.ingreso(ingreso);
        });
        menu.addItem("Egreso", () -> {
            double egreso = ensureDoubleInput("Ingrese un monto positivo. Se retirará de la cuenta corriente", d -> d > 0);
            cuentaCorriente.egreso(egreso);
        });
        menu.addItem("Transferencia", () -> {
            double ingreso = ensureDoubleInput("Ingrese un monto positivo. Se transferirá a la cuenta de Meli", d -> d > 0);
            CuentaCorriente meli = meliAccountSupplier.get();
            cuentaCorriente.transferencia(meli, ingreso);
            print("Transferencia realizada con éxito. Ahora Meli tiene $" + meli.getSaldo());
        });
        menu.addItem("Reintegro", () -> {
            double ingreso = ensureDoubleInput("Ingrese un monto positivo. Se reintegrará a la cuenta corriente", d -> d > 0);
            cuentaCorriente.reintegro(ingreso);
        });
        menu.execute();
    }

    private static void exercise2(@NotNull Menu parent) {
        Menu creationMenu = new Menu("Creemos un contador");
        AtomicReference<Contador> contadorHolder = new AtomicReference<>();
        creationMenu.addItem("Default (0)", () -> contadorHolder.set(new Contador()), true);
        creationMenu.addItem("Valor incial", () -> {
            int i = ensureIntInput("Ingrese el valor entero inicial del contador");
            contadorHolder.set(new Contador(i));
        }, true);
        creationMenu.addItem("Copiar contador de Meli", () -> {
            Random rand = new Random();
            int posRandInt = rand.nextInt(400) + 1;
            Contador meli = new Contador(posRandInt);
            contadorHolder.set(new Contador(meli));
        }, true);
        creationMenu.execute();
        final Contador contador = contadorHolder.get();
        if (contador == null) return; // el usuario decidió salir sin crear el contador
        Menu menu = new Menu(() -> String.format("El valor actual del contador es %s", contador.getValor()), parent);
        menu.addItem("Incrementar", contador::incrementar);
        menu.addItem("Decrementar", contador::decrementar);
        menu.execute();
    }

    private static void exercise3(@NotNull Menu parent) {
        Menu creationMenu = new Menu("Creemos un Libro");
        AtomicReference<Libro> libroHolder = new AtomicReference<>();
        creationMenu.addItem("Default (sin titulo, sin autor, isbn = 0)", () -> libroHolder.set(new Libro()), true);
        creationMenu.addItem("Ingresar valores", () -> {
            String titulo = ensureNotEmptyStringInput("Ingrese el título del libro");
            String autor = ensureNotEmptyStringInput("Ingrese el autor del libro");

            int isbn = ensureIntInput("Ingrese el isbn del libro", i -> i > 0);
            libroHolder.set(new Libro(titulo, isbn, autor));
        }, true);
        creationMenu.execute();

        final Libro libro = libroHolder.get();
        if (libro == null) return;
        Menu menu = new Menu(() -> String.format("Qué hacemos con el libro %s? El mismo está %s", libro.getTitulo(), libro.getDisponibleAsString()), parent);
        menu.addItem("Pedir prestado", () -> {
            try {
                libro.prestamo();
            } catch (final Libro.LibroException e) {
                print(e.getMessage());
            }
        });
        menu.addItem("Devolver", () -> {
            try {
                libro.devolucion();
            } catch (final Libro.LibroException e) {
                print(e.getMessage());
            }
        });
        menu.execute();
    }

    private static void exercise4 (@NotNull Menu parent) {
        print("Ingrese dos fracciones n y m");
        float n = (float) ensureDoubleInput("Ingrese n");
        float m = (float) ensureDoubleInput("Ingrese m");
        Menu menu = new Menu("Qué hacemos con las fracciones?", parent);
        menu.addItem("Sumar", () -> print(Fraccion.sumar(n, m)), true);
        menu.addItem("Restar", () -> print(Fraccion.restar(n, m)), true);
        menu.addItem("Dividir", () -> {
            try {
                print(Fraccion.dividir(n, m));
            } catch (final Fraccion.FraccionException e) {
                print(e.getMessage());
            }
        }, true);
        menu.addItem("Multiplicar", () -> print(Fraccion.multiplicar(n, m)), true);
        menu.execute();
    }

    private static void exercise5(@NotNull Menu parent) {
        Menu creationMenu = new Menu("Creemos una fecha", parent);
        AtomicReference<Fecha> fechaHolder = new AtomicReference<>();
        creationMenu.addItem("Default (fecha actual)", () -> fechaHolder.set(new Fecha()), true);
        creationMenu.addItem("Ingresar valores", () -> {
            int dia = ensureIntInput("Ingrese el número de día");
            int mes = ensureIntInput("Ingrese el número de mes") - 1;
            int anio = ensureIntInput("Ingrese el año");
            if (Fecha.esCorrecta(anio, mes, dia)) {
                fechaHolder.set(new Fecha(new GregorianCalendar(anio, mes, dia).getTime()));
            } else {
                print("Valores incorrectos");
            }
        }, true);
        creationMenu.execute();
        Fecha fecha = fechaHolder.get();
        if (fecha == null) return;
        Menu menu = new Menu(() -> String.format("La fecha es %s. Qué hacemos?", fecha.toString()), parent);
        menu.addItem("Sumar día", fecha::sumarDia);
        menu.execute();
    }

    private static void exercise6() {

    }
}
