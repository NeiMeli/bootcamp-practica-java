package exercise1;

public class CuentaCorriente {
    private double saldo;

    public CuentaCorriente (double saldo) {
        checkearNegativoCero(saldo);
        this.saldo = saldo;
    }

    public CuentaCorriente () {
        setSaldo(0);
    }

    public CuentaCorriente (CuentaCorriente other) {
        this.saldo = other.saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo (double saldo) {
        this.saldo = saldo;
    }

    public void ingreso (double monto) {
        checkearNegativoCero(monto);
        sumarSaldo(monto);
    }

    public void reintegro (double monto) {
        checkearNegativoCero(monto);
        sumarSaldo(monto);
    }

    private void checkearNegativoCero(double monto) {
        if (monto <= 0) {
            throw new CuentaCorrienteException("El monto debe ser mayor a 0");
        }
    }

    public void egreso (double monto) {
        checkearNegativoCero(monto);
        restarSaldo(monto);
    }

    public void transferencia (CuentaCorriente destinatario, double monto) {
        checkearNegativoCero(monto);
        this.egreso(monto);
        destinatario.ingreso(monto);
    }

    private void sumarSaldo(double monto) {
        setSaldo(saldo + monto);
    }

    private void restarSaldo(double monto) {
        setSaldo(saldo - monto);
    }

    public static class CuentaCorrienteException extends RuntimeException {
        public CuentaCorrienteException(String message) {
            super(message);
        }
    }

}
