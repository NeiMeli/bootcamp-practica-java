package clase2.tt.ejercicio1;

public class SimplePassword extends Password {
    // Solo letras
    public SimplePassword() {
        super("^[a-zA-Z]+$");
    }

    @Override
    protected String getPasswordRules() {
        return "Debe contener únicamente letras";
    }
}
