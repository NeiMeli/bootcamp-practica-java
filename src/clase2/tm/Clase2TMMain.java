package clase2.tm;

import clase2.tm.ejercicio1.CuentaCorriente;
import clase2.tm.ejercicio2.Contador;
import menu.Menu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
        menu.addItem("Ejercicio 3 - Libro", Clase2TMMain::exercise3);
        menu.addItem("Ejercicio 4 - Fraccion", Clase2TMMain::exercise4);
        menu.addItem("Ejercicio 5 - Fecha", Clase2TMMain::exercise5);
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
            print("Ingrese el valor inicial del monto. Debe ser positivo.");
            double input = ensureDoubleInput(d -> d > 0);
            cuentaCorrienteHolder.set(new CuentaCorriente(input));
        }, true);
        creationMenu.addItem("Copiar cuenta de Meli", () -> cuentaCorrienteHolder.set(meliAccountSupplier.get()), true);
        creationMenu.execute();

        CuentaCorriente cuentaCorriente = cuentaCorrienteHolder.get();
        if (cuentaCorriente == null) return;

        Menu menu = new Menu(() -> String.format("Cuenta corriente - Saldo %s", cuentaCorriente.getSaldo()), parent);
        menu.addItem("Ingreso", () -> {
            print("Ingrese un monto positivo. Se añadirá a la cuenta corriente");
            double ingreso = ensureDoubleInput(d -> d > 0);
            cuentaCorriente.ingreso(ingreso);
        });
        menu.addItem("Egreso", () -> {
            print("Ingrese un monto positivo. Se retirará de la cuenta corriente");
            double egreso = ensureDoubleInput(d -> d > 0);
            cuentaCorriente.egreso(egreso);
        });
        menu.addItem("Transferencia", () -> {
            print("Ingrese un monto positivo. Se transferirá a la cuenta de Meli");
            double ingreso = ensureDoubleInput(d -> d > 0);
            CuentaCorriente meli = meliAccountSupplier.get();
            cuentaCorriente.transferencia(meli, ingreso);
            print("Transferencia realizada con éxito. Ahora Meli tiene $" + meli.getSaldo());
        });
        menu.addItem("Reintegro", () -> {
            print("Ingrese un monto positivo. Se reintegrará a la cuenta corriente");
            double ingreso = ensureDoubleInput(d -> d > 0);
            cuentaCorriente.reintegro(ingreso);
        });
        menu.execute();
    }

    private static void exercise2(@NotNull Menu parent) {
        Menu creationMenu = new Menu("Creemos un contador");
        AtomicReference<Contador> contadorHolder = new AtomicReference<>();
        creationMenu.addItem("Default (0)", () -> contadorHolder.set(new Contador()), true);
        creationMenu.addItem("Valor incial", () -> {
            print("Ingrese el valor entero inicial del contador");
            int i = ensureIntInput();
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

    private static void exercise3() {

    }

    private static void exercise4() {

    }

    private static void exercise5() {

    }

    private static void exercise6() {

    }
}
