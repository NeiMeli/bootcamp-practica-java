package menu;

import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Supplier;

import static common.IOUtil.ensureIntInput;
import static common.IOUtil.print;

public class Menu implements MenuItem {
    private final Supplier<String> description;
    private final Map<Integer, MenuItem> items;

    public Menu (String description) {
        this(description, null);
    }

    public Menu (Supplier<String> description) {
        this(description, null);
    }

    public Menu (String description, @Nullable Menu parentMenu) {
        this (() -> description, parentMenu);
    }

    public Menu (Supplier<String> description, @Nullable Menu parentMenu) {
        this.description = description;
        items = new TreeMap<>(Comparator.comparingInt(i -> i));
        if (parentMenu != null) addItem(DEFAULT_END_KEY, BACK_ITEM.apply(parentMenu));
        else addItem(DEFAULT_END_KEY, DEFAULT_END_ITEM.get());
    }

    public void addItem(int key, MenuItem item) {
        items.put(key, item);
    }

    public void addItem(MenuItem item) {
        int key = items.size();
        addItem(key, item);
    }

    public void addItem(String description, Runnable execution) {
        addItem(description, execution, false);
    }

    public void addItem(String description, Runnable execution, boolean isFinalAction) {
        addItem(MenuItem.create(description, execution, isFinalAction));
    }

    @Override
    public void execute() {
        int option;
        do {
            print(ANSI_BLUE);
            print(String.format("%s. %s:", getDescription(), "Seleccione una opción"));
            items.forEach((k, i) -> print(String.format("%s - %s", k, i.getDescription())));
            option = ensureIntInput(i -> i >= DEFAULT_END_KEY && i < items.size());
            print(ANSI_RESET);
            items.get(option).execute();
        } while (!(items.get(option).isFinalAction()));
    }

    @Override
    public String getDescription() {
        return description.get();
    }

    @Override
    public boolean isFinalAction() {
        return true;
    }

    private static final Supplier<MenuItem> DEFAULT_END_ITEM = () -> MenuItem.create("--- SALIR ---", () -> print("Finalizado"), true);
    private static final Function<MenuItem, MenuItem> BACK_ITEM = m -> MenuItem.create("--- VOLVER ---", m::execute, true);
    private static final int DEFAULT_END_KEY = 0;
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
}
