package clase2.tt;

import menu.MenuItem;

import static common.IOUtil.print;

public class Clase2TTMain {
    public static MenuItem buildMenu() {
        return MenuItem.create("Turno tarde", () -> print("En desarrollo :)"), false);
    }
}
