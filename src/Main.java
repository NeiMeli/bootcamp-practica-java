import clase1.tm.Clase1TMMain;
import clase1.tt.Clase1TTMain;
import clase2.tm.Clase2TMMain;
import clase2.tt.Clase2TTMain;
import menu.Menu;
import menu.MenuItem;

public class Main {
    private static final Menu mainMenu = new Menu("Práctica JAVA Bootcamp");
    public static void main(String[] args) {
        mainMenu.addItem(buildClase1Menu());
        mainMenu.addItem(buildClase2Menu());
        mainMenu.execute();
    }

    private static MenuItem buildClase1Menu() {
        Menu menu = new Menu("Clase 1", mainMenu);
        menu.addItem(Clase1TMMain.buildMenu(menu));
        menu.addItem(Clase1TTMain.buildMenu());
        return menu;
    }

    private static MenuItem buildClase2Menu() {
        Menu menu = new Menu("Clase 2", mainMenu);
        menu.addItem(Clase2TMMain.buildMenu(menu));
        menu.addItem(Clase2TTMain.buildMenu(menu));
        return menu;
    }
}
