package clase2.tt.ejercicio2;

import common.MathUtil;

public class Triangulo extends FiguraConBaseYAltura {
    public Triangulo(double base, double altura) {
        super(base, altura);
    }

    @Override
    public double area() {
        return MathUtil.roundOneDecimal((base * altura) / 2);
    }
}
