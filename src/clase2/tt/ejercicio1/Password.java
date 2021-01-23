package clase2.tt.ejercicio1;

import com.sun.istack.internal.NotNull;

public abstract class Password {
    private final String regex;
    private String value;

    protected Password(@NotNull final String regex) {
        this.regex = regex;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if (isValid(value)) {
            this.value = value;
        } else {
            throw new PasswordException("Contraseña inválida. " + getPasswordRules());
        }
    }

    protected abstract String getPasswordRules();

    public boolean isValid(String value) {
        return value.matches(regex);
    }

    public static class PasswordException extends RuntimeException {
        public PasswordException(String message) {
            super(message);
        }
    }
}
