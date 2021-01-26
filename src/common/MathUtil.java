package common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtil {
    public static float roundOneDecimal(float value) {
        return roundOneDecimal(Float.toString(value)).floatValue();
    }

    public static double roundOneDecimal(double value) {
        return roundOneDecimal(Double.toString(value)).doubleValue();
    }

    private static BigDecimal roundOneDecimal(String value) {
        BigDecimal bd = new BigDecimal(value);
        return bd.setScale(1, RoundingMode.HALF_UP);
    }
}
