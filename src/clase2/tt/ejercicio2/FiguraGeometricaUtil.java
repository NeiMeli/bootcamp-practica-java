package clase2.tt.ejercicio2;

import common.MathUtil;

import java.util.Arrays;

public class FiguraGeometricaUtil {
    public static double areaPromedio(FiguraGeometrica[] arr) {
        return MathUtil.roundOneDecimal(Arrays.stream(arr).mapToDouble(FiguraGeometrica::area).average().orElse(0));
    }
}
