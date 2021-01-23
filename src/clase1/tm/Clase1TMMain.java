package clase1.tm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Clase1TMMain {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        exercise1();
        exercise2();
        exercise3();
        exercise4();
        exercise5();
    }

    private static void exercise1() {
        print("Ejercicio 1");
        print("Ingrese un número entero n. Mostraremos los primeros n números pares");
        int counter = ensureIntInput();
        IntStream.range(1, Integer.MAX_VALUE).filter(Clase1TMMain::isEven).limit(counter).forEach(Clase1TMMain::print);
    }

    public static boolean isEven(int i) {
        return areEvenDivisible(i, 2);
    }

    private static void print(Object i) {
        System.out.println(i);
    }

    public static boolean areEvenDivisible(int n, int m) {
        return n % m == 0;
    }

    private static void exercise2() {
        print("Ejercicio 2");
        print("Ingrese dos números n y m. Mostraremos los primeros n múltiplos de m");
        int n = ensureIntInput();
        int m = ensureIntInput();
        IntStream.range(1, m).filter(candidate -> areEvenDivisible(m, candidate)).limit(n).forEach(Clase1TMMain::print);
    }

    private static int ensureIntInput() {
        Optional<Integer> input = Optional.empty();
        while(!input.isPresent()) {
            try {
                input = Optional.of(Integer.parseInt(scanner.nextLine()));
            } catch (final Exception e) {
                print("Por favor ingrese un número entero válido");
            }
        }
        return input.get();
    }

    private static void exercise3() {
        print("Ejercicio 3");
        print("Ingrese un número. Mostraremos si es primo");
        int n = ensureIntInput();
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
        print("Ingrese un número. Mostraremos todos los números primos en ese rango");
        int n = ensureIntInput();
        IntStream.range(1, n).filter(Clase1TMMain::isPrime).forEach(Clase1TMMain::print);
    }

    private static void exercise5() {
        print("Ejercicio 5");
        print("Ingrese tres números n, m y d. Mostraremos los primeros n números naturales que tienen al menos m digitios d");
        int n = ensureIntInput();
        int m = ensureIntInput();
        int d = ensureIntInput();
        getFirstNIntegersThatHaveMTimesD(n, m, d).forEach(Clase1TMMain::print);
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
}
