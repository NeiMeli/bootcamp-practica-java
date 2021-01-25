package clase2.tt.ejercicio1;

public class MediumPassword extends Password {
    // Al menos una letra y un número. Mínimo 4 caracteres
    public MediumPassword() {
        super("^(?=.*[A-Za-z].*)(?=.*[0-9].*)[A-Za-z0-9]{4,}$");
    }

    @Override
    protected String getPasswordRules() {
        return "Debe contener letras y números y una longitud minima de cuatro caracteres. No se admiten caracteres especiales";
    }
}
