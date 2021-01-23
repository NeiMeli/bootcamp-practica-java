package clase2.tm.ejercicio2;

public class Contador {
    private int valor;

    public Contador() {
        this(0);
    }

    public Contador(Contador otro) {
        setValor(otro.getValor());
    }

    public Contador(int valor) {
        setValor(valor);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void incrementar() {
        setValor(valor + 1);
    }

    // admite negativos
    public void decrementar() {
        setValor(valor - 1);
    }
}
