package clase4.tt;

import java.util.ArrayList;
import java.util.List;

import static common.IOUtil.print;

public class PackFuegosArtificiales implements Explotable {
    private final List<Explotable> explotables;

    public PackFuegosArtificiales(List<Explotable> explotables) {
        this.explotables = explotables;
    }

    public PackFuegosArtificiales() {
        this(new ArrayList<>());
    }

    public List<Explotable> getExplotables() {
        return explotables;
    }

    public void addExplotable(Explotable e) {
        explotables.add(e);
    }

    @Override
    public void explotar() {
        if (estaDisponible()) {
            explotables.forEach(Explotable::explotar);
        } else {
            print(NO_DISPONIBLE_MSG);
        }
    }

    @Override
    public boolean estaDisponible() {
        return explotables.stream().allMatch(Explotable::estaDisponible);
    }
}
