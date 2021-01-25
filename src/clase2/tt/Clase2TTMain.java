package clase2.tt;

import menu.Menu;
import menu.MenuItem;
import org.jetbrains.annotations.Nullable;

public class Clase2TTMain {
    public static MenuItem buildMenu(@Nullable Menu menu) {
        return MenuItem.create("Turno tarde", () -> {}, false);
    }
}
