package clase4.tt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Evento {
    private final List<Invitado> invitados;
    private final List<Explotable> explotables;

    public Evento(List<Invitado> invitados, List<Explotable> explotables) {
        this.invitados = invitados;
        this.explotables = explotables;
    }

    public Evento() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    public List<Invitado> getInvitados() {
        return invitados;
    }

    public List<Explotable> getExplotablesDisponibles() {
        return explotables.stream().filter(Explotable::estaDisponible).collect(Collectors.toList());
    }

    public void addInvitado(Invitado ... invitados) {
        this.invitados.addAll(Arrays.asList(invitados));
    }

    public void addExplotable(Explotable ... explotables) {
        this.explotables.addAll(Arrays.asList(explotables));
    }

    public void apagarVelas() {
        getExplotablesDisponibles().forEach(Explotable::explotar);
        invitados.forEach(Invitado::comerTorta);
    }
}
