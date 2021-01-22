package exercise1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaCorrienteTest {
    @Test
    void ingreso() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente();
        assertThrows(CuentaCorriente.CuentaCorrienteException.class, () -> cuentaCorriente.ingreso(-200));
        double saldoInicial = cuentaCorriente.getSaldo();
        cuentaCorriente.ingreso(200);
        assertEquals(saldoInicial + 200, cuentaCorriente.getSaldo());
    }

    @Test
    void reintegro() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente();
        assertThrows(CuentaCorriente.CuentaCorrienteException.class, () -> cuentaCorriente.reintegro(-200));
        double saldoInicial = cuentaCorriente.getSaldo();
        cuentaCorriente.reintegro(200);
        assertEquals(saldoInicial + 200, cuentaCorriente.getSaldo());
    }

    @Test
    void egreso() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente();
        assertThrows(CuentaCorriente.CuentaCorrienteException.class, () -> cuentaCorriente.egreso(-200));
        double saldoInicial = cuentaCorriente.getSaldo();
        cuentaCorriente.egreso(200);
        assertEquals(saldoInicial - 200, cuentaCorriente.getSaldo());
    }

    @Test
    void transferencia() {
        CuentaCorriente cuentaCorrienteA = new CuentaCorriente();
        CuentaCorriente cuentaCorrienteB = new CuentaCorriente();
        double saldoInicialA = cuentaCorrienteA.getSaldo();
        double saldoInicialB = cuentaCorrienteB.getSaldo();

        assertThrows(CuentaCorriente.CuentaCorrienteException.class, () -> cuentaCorrienteA.transferencia(cuentaCorrienteB, -200));
        cuentaCorrienteA.transferencia(cuentaCorrienteB, 200);

        assertEquals(saldoInicialA - 200, cuentaCorrienteA.getSaldo());
        assertEquals(saldoInicialB + 200, cuentaCorrienteB.getSaldo());
    }

    @Test
    void defaultConstructor() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente();
        assertEquals(0, cuentaCorriente.getSaldo());
    }

    @Test
    void parametrizedConstructor() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(500);
        assertEquals(500, cuentaCorriente.getSaldo());
    }

    @Test
    void cloneConstructor() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(500);
        CuentaCorriente cuentaCorriente2 = new CuentaCorriente(cuentaCorriente);
        assertEquals(cuentaCorriente.getSaldo(), cuentaCorriente2.getSaldo());
    }
}