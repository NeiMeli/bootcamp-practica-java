package clase2.tt.ejercicio1;

public class MediumPassword extends Password {
    // Solo letras y números
    public MediumPassword() {
        super("([0-9]+[a-z]|[a-z]+[0-9])[a-z0-9]*");
    }

    @Override
    protected String getPasswordRules() {
        return "Debe contener letras y números. No se admiten caracteres especiales";
    }
}
