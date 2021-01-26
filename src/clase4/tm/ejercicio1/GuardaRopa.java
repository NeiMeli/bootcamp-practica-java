package clase4.tm.ejercicio1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static common.IOUtil.print;

public class GuardaRopa {
    private final Map<Integer, List<Prenda>> prendas;
    private int contador;

    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public int getContador() {
        return contador;
    }

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas (List<Prenda> listaDePrendas) {
        if (listaDePrendas.isEmpty()) throw new GuardaRopaException("Lista de prendas vacía");
        contador ++;
        prendas.put(contador, listaDePrendas);
        return contador;
    }

    public List<Prenda> devolverPrendas (Integer numero) {
        if (prendas.containsKey(numero)) {
            return prendas.remove(numero);
        } else {
            throw new GuardaRopaException("Número inválido");
        }
    }

    public void mostrarPrendas() {
        prendas.forEach((k, v) -> print(String.format("Identificador %s. Prendas: %s", k,
                v.stream().map(Prenda::toString).collect(Collectors.joining(", ")))));
    }

    public static class GuardaRopaException extends RuntimeException {
        public GuardaRopaException(String message) {
            super(message);
        }
    }
}
