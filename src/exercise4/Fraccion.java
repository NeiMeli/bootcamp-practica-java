package exercise4;

import java.math.BigDecimal;

public class Fraccion {

    public static float sumar (int a, int b) {
        return sumar((float) a, (float) b);
    }

    public static float sumar (int a, float b) {
        return sumar((float) a, b);
    }

    public static float sumar (float a, int b) {
        return sumar(a, (float) b);
    }

    public static float sumar (float a, float b) {
        return roundOneDecimal(a + b);
    }

    public static float restar (int a, int b) {
        return restar((float) a, (float) b);
    }

    public static float restar (int a, float b) {
        return restar((float) a, b);
    }

    public static float restar (float a, int b) {
        return restar(a, (float) b);
    }

    public static float restar (float a, float b) {
        return roundOneDecimal(a - b);
    }

    public static float dividir (int a, int b) {
        return dividir((float) a, (float) b);
    }

    public static float dividir (int a, float b) {
        return dividir((float) a, b);
    }

    public static float dividir (float a, int b) {
        return dividir(a, (float) b);
    }

    public static float dividir (float a, float b) {
        return roundOneDecimal(a / b);
    }

    public static float multiplicar (int a, int b) {
        return multiplicar((float) a, (float) b);
    }

    public static float multiplicar (int a, float b) {
        return multiplicar((float) a, b);
    }

    public static float multiplicar (float a, int b) {
        return multiplicar(a, (float) b);
    }

    public static float multiplicar (float a, float b) {
        return roundOneDecimal(a * b);
    }

    public static float roundOneDecimal(float d) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(1, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}
