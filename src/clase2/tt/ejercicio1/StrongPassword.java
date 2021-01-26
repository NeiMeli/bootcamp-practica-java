package clase2.tt.ejercicio1;

public class StrongPassword extends Password {
    public StrongPassword() {
        super("^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8,}$");
    }

    @Override
    public String getPasswordRules() {
        return "Debe cotener al menos tres letra en minúscula, dos en mayúscula, dos números, un caracter especial, y una longitud mínima de 8 caracteres.";
    }
}
