package clase2.tt.ejercicio2;

import common.MathUtil;

public class Rectangulo extends FiguraConBaseYAltura {
    public Rectangulo(double base, double altura) {
        super(base, altura);
    }

    @Override
    public double area() {
        return MathUtil.roundOneDecimal(base * altura);
    }
}
