package clase4.tm.ejercicio1;

public class Prenda {
    private final String marca;
    private final String modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", marca, modelo);
    }
}
