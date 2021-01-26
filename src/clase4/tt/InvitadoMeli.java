package clase4.tt;

import static common.IOUtil.print;

public class InvitadoMeli extends Invitado {
    public InvitadoMeli(String name) {
        super(name);
    }

    @Override
    public void comerTorta() {
        super.comerTorta();
        print("Viva la Chiqui!!");
    }
}
