package clase2.tt.ejercicio2;

import java.util.Arrays;

public abstract class FiguraGeometrica {
    public abstract double area();

    // las clases hijas que no sobreescriban toString() van a usar este algoritmo
    @Override
    public String toString() {
        return "El área es " + area();
    }

    public static class FiguraGeometricaException extends RuntimeException {
        public FiguraGeometricaException(String message) {
            super(message);
        }
    }

    protected void validatePossitive(double ... values) {
        if (Arrays.stream(values).anyMatch(value -> value <= 0)) {
            throw new FiguraGeometricaException("Valor inválido. Sólo se admiten positivos");
        }
    }
}
