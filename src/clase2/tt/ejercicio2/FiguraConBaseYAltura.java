package clase2.tt.ejercicio2;

public abstract class FiguraConBaseYAltura extends FiguraGeometrica {
    protected final double base;
    protected final double altura;

    public FiguraConBaseYAltura(double base, double altura) {
        validatePossitive(base, altura);
        this.base = base;
        this.altura = altura;
    }
}
