package clase4.tt;

import static common.IOUtil.print;

public class FuegoArtificial implements Explotable {
    private final String ruidoAlExplotar;
    private boolean disponible;
    public FuegoArtificial(String ruidoAlExplotar) {
        this.ruidoAlExplotar = ruidoAlExplotar;
        this.disponible = true;
    }

    @Override
    public void explotar() {
        print (disponible ? ruidoAlExplotar : NO_DISPONIBLE_MSG);
        this.disponible = false;
    }

    @Override
    public boolean estaDisponible() {
        return disponible;
    }
}
