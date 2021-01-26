package clase4.tm.ejercicio2;

public abstract class Vehiculo {
    private final double velocidad;
    private final double aceleracion;
    private final double anguloDeGiro;
    private final String patente;
    private final double peso;
    private final int ruedas;


    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public boolean tienePatente(String unaPatente) {
        return this.patente.equals(unaPatente);
    }

    public double getResult() {
        return velocidad * (aceleracion / 0.5) / (anguloDeGiro * (peso - ruedas * 100));
    }

    public String getPatente() {
        return patente;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vehiculo)) return false;
        Vehiculo vehiculo = (Vehiculo) obj;
        return this.tienePatente(vehiculo.patente);
    }
}
