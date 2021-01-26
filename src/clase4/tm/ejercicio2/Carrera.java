package clase4.tm.ejercicio2;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class Carrera {
    private final double distancia;
    private final double premioEnDolares;
    private final String nombre;
    private final int cantidadDeVehiculosPermitidos;
    private final SocorristaAuto socorristaAuto;
    private final SocorristaMoto socorristaMoto;

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    private final List<Vehiculo> listaDeVehiculos;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
        this.listaDeVehiculos = new ArrayList<>();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        darDeAltaVehiculo(() -> new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        darDeAltaVehiculo(() -> new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    private void darDeAltaVehiculo(Supplier<Vehiculo> vehiculoSupplier) {
        validarCupos();
        listaDeVehiculos.add(vehiculoSupplier.get());
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
       listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        Optional<Vehiculo> optionalVehiculo = findVehiculo(unaPatente);
        optionalVehiculo.ifPresent(this::eliminarVehiculo);
    }

    @NotNull
    private Optional<Vehiculo> findVehiculo(String unaPatente) {
        return listaDeVehiculos.stream().filter(v -> v.tienePatente(unaPatente)).findFirst();
    }

    private void validarCupos() {
        if (listaDeVehiculos.size() == cantidadDeVehiculosPermitidos)
            throw new CarreraException("No hay más cupos");
    }

    public static class CarreraException extends RuntimeException {
        public CarreraException(String msg) {
            super(msg);
        }
    }

    public Vehiculo getGanador() {
        if (listaDeVehiculos.isEmpty()) throw new CarreraException ("No hay vehículos registrados");
        Comparator<Vehiculo> comparator = (o1, o2) -> (int) (o1.getResult() - o2.getResult());
        return listaDeVehiculos.stream().max(comparator).get();
    }

    public void socorrerAuto(String patente) {
        Optional<Vehiculo> optionalVehiculo = findVehiculo(patente);
        if (optionalVehiculo.isPresent() && optionalVehiculo.get() instanceof Auto) {
            socorristaAuto.socorrer((Auto) optionalVehiculo.get());
        } else {
            throw new CarreraException("No hay un auto con esa patente");
        }
    }

    public void socorrerMoto(String patente) {
        Optional<Vehiculo> optionalVehiculo = findVehiculo(patente);
        if (optionalVehiculo.isPresent() && optionalVehiculo.get() instanceof Moto) {
            socorristaMoto.socorrer((Moto) optionalVehiculo.get());
        } else {
            throw new CarreraException("No hay una moto con esa patente");
        }
    }

}
