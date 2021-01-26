package clase2.tt;

import clase2.tt.ejercicio1.MediumPassword;
import clase2.tt.ejercicio1.Password;
import clase2.tt.ejercicio1.SimplePassword;
import clase2.tt.ejercicio1.StrongPassword;
import clase2.tt.ejercicio2.Circulo;
import clase2.tt.ejercicio2.Rectangulo;
import clase2.tt.ejercicio2.Triangulo;
import menu.Menu;
import menu.MenuItem;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.atomic.AtomicReference;

import static common.IOUtil.*;

public class Clase2TTMain {
    public static void main(String[] args) {
        buildMenu(null).execute();
    }
    public static MenuItem buildMenu(@Nullable Menu parent) {
        final Menu menu = new Menu("Turno tarde", parent);
        menu.addItem("Ejercicio 1 - Contraseñas", () -> Clase2TTMain.exercise1(menu), true);
        menu.addItem("Ejercicio 2 - Figuras geométricas", () -> Clase2TTMain.exercise2(menu), true);
        return menu;
    }

    private static void exercise1(Menu parent) {
        Menu typeMenu = new Menu("Creemos una contraseña", parent);
        AtomicReference<Password> passwordHolder = new AtomicReference<>();
        typeMenu.addItem("Débil", () -> passwordHolder.set(new SimplePassword()), true);
        typeMenu.addItem("Media", () -> passwordHolder.set(new MediumPassword()), true);
        typeMenu.addItem("Fuerte", () -> passwordHolder.set(new StrongPassword()), true);
        typeMenu.execute();
        if (passwordHolder.get() == null) return;
        Menu menu = new Menu("Nueva contraseña creada", parent);
        menu.addItem("Cambiar valor", () -> {
            String value = ensureStringInput( "Ingrese la nueva contraseña. " + passwordHolder.get().getPasswordRules(), passwordHolder.get()::isValid);
            passwordHolder.get().setValue(value);
            print("Contraseña actualizada");
        });
        menu.addItem("Verificar contraseña", () -> {
            if (passwordHolder.get().getValue() != null) {
                String value = ensureStringInput( "Ingrese su contraseña");
                if (value.equals(passwordHolder.get().getValue()))
                    print("Contraseña verificada");
                else
                    print("Contraseña inválida");
            } else {
                print("La contraseña aún no tiene valor");
            }
        });
        menu.addItem("Modificar tipo", () -> {
            passwordHolder.set(null);
            typeMenu.execute();
        }, true);
        menu.execute();
    }

    private static void exercise2(Menu parent) {
        Menu menu = new Menu("Creemos una figura geométrica. Luego mostraremos el área", parent);
        menu.addItem("Círculo", () -> {
            double radio = ensureDoubleInput("Ingrese el valor del radio", d -> d > 0);
            Circulo circulo = new Circulo(radio);
            print("El área del círculo es " + circulo.area());
        });
        menu.addItem("Triángulo", () -> {
            double base = ensureDoubleInput("Ingrese el valor de la base", d -> d > 0);
            double altura = ensureDoubleInput("Ingrese el valor de la altura", d -> d > 0);
            Triangulo triangulo = new Triangulo(base, altura);
            print("El área del triángulo es " + triangulo.area());
        });
        menu.addItem("Rectángulo", () -> {
            double base = ensureDoubleInput("Ingrese el valor de la base", d -> d > 0);
            double altura = ensureDoubleInput("Ingrese el valor de la altura", d -> d > 0);
            Rectangulo rectangulo = new Rectangulo(base, altura);
            print("El área del rectángulo es " + rectangulo.area());
        });
        menu.execute();
    }
}
