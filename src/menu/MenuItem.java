package menu;

public interface MenuItem {
    default void execute() {}
    String getDescription();
    boolean isFinalAction();

    static MenuItem create(String description, Runnable execution, boolean isFinalAction) {
        return new MenuItem() {
            @Override
            public void execute() {
                execution.run();
            }

            @Override
            public String getDescription() {
                return description;
            }

            @Override
            public boolean isFinalAction() {
                return isFinalAction;
            }
        };
    }
}
