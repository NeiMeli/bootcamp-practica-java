package clase2.tt.ejercicio1;

public class SimplePassword extends Password {
    // Solo letras, longitud mínima de 1 caracter
    public SimplePassword() {
        super("^[a-zA-Z]+$");
    }

    @Override
    public String getPasswordRules() {
        return "Debe contener únicamente letras";
    }
}
