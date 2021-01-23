package clase2.tt.ejercicio2;

import common.MathUtil;

public class Circulo extends FiguraGeometrica {

    private final double radio;

    public Circulo(double radio) {
        validatePossitive(radio);
        this.radio = radio;
    }

    @Override
    public double area() {
        return MathUtil.roundOneDecimal(Math.PI * Math.pow(radio, 2));
    }
}
