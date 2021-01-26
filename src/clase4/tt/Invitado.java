package clase4.tt;

import static common.IOUtil.print;

public class Invitado {

    private final String name;

    public Invitado (String name) {
        this.name = name;
    }

    public void comerTorta() {
        print( String.format("%s ... comiendo torta ... ", name));
    }
}
