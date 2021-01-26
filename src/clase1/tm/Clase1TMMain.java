package clase1.tm;

import common.IOUtil;
import menu.Menu;
import menu.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static common.IOUtil.ensureIntInput;
import static common.IOUtil.print;

public class Clase1TMMain {
    public static void main(String[] args) {
        buildMenu(null).execute();
    }

    private static void exercise1() {
        print("Ejercicio 1");
        int counter = ensureIntInput("Ingrese un número entero n. Mostraremos los primeros n números pares");
        IntStream.range(1, Integer.MAX_VALUE).filter(Clase1TMMain::isEven).limit(counter).forEach(IOUtil::print);
    }

    public static boolean isEven(int i) {
        return areEvenDivisible(i, 2);
    }

    public static boolean areEvenDivisible(int n, int m) {
        return n % m == 0;
    }

    private static void exercise2() {
        print("Ejercicio 2");
        print("Ingrese dos números n y m. Mostraremos los primeros n múltiplos de m");
        int n = ensureIntInput("Ingrese n");
        int m = ensureIntInput("Ingrese m");
        IntStream.range(1, m).filter(candidate -> areEvenDivisible(m, candidate)).limit(n).forEach(IOUtil::print);
    }
    
    private static void exercise3() {
        print("Ejercicio 3");
        int n = ensureIntInput("Ingrese un número. Mostraremos si es primo");
        print(isPrime(n) ? "Es primo" : "No es primo");
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        boolean isPrime = true; // de por si todos los enteros se pueden dividir por 1 y por si mismos
        int candidate = 2;
        while (candidate < n && isPrime) {
            if (areEvenDivisible(n, candidate)) isPrime = false;
            candidate ++;
        }
        return isPrime;
    }

    private static void exercise4() {
        print("Ejercicio 4");
        int n = ensureIntInput("Ingrese un número. Mostraremos todos los números primos en ese rango");
        IntStream.range(1, n).filter(Clase1TMMain::isPrime).forEach(IOUtil::print);
    }

    private static void exercise5() {
        print("Ejercicio 5");
        print("Ingrese tres números n, m y d. Mostraremos los primeros n números naturales que tienen al menos m digitios d");
        int n = ensureIntInput("Ingrese n");
        int m = ensureIntInput("Ingrese m");
        int d = ensureIntInput("Ingrese d");
        getFirstNIntegersThatHaveMTimesD(n, m, d).forEach(IOUtil::print);
    }

    public static List<Integer> getFirstNIntegersThatHaveMTimesD(int n, int m, int d) {
        final List<Integer> result = new ArrayList<>();
        int counter = 0;
        int candidate = 1;
        final String dString = String.valueOf(d);

        while (counter < n) {
            String stringCandidate = String.valueOf(candidate);
            int allDigitLength = stringCandidate.length();
            int lengthAvoidingD = stringCandidate.replace(dString, "").length();
            int dOcurrences = allDigitLength - lengthAvoidingD;
            if (dOcurrences >= m) {
                result.add(candidate);
                counter ++;
            }
            candidate ++; // todo esto seguro se puede mejorar si se suma más inteligentemente que de a uno
        }
        return result;
    }

    public static MenuItem buildMenu(Menu parentMenu) {
        final Menu menu = new Menu("Turno Mañana", parentMenu);
        menu.addItem("Ejercicio 1 - Primeros n numeros pares", Clase1TMMain::exercise1);
        menu.addItem("Ejercicio 2 - Primeros n multiplos de m", Clase1TMMain::exercise2);
        menu.addItem("Ejercicio 3 - Número primo", Clase1TMMain::exercise3);
        menu.addItem("Ejercicio 4 - Números primos hasta n", Clase1TMMain::exercise4);
        menu.addItem("Ejercicio 5 - Primeros n naturales con m digitos d", Clase1TMMain::exercise5);
        return menu;
    }
}
