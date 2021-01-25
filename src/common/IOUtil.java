package common;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class IOUtil {
    private static final Scanner input = new Scanner(System.in);


    public static void print(@NotNull final Object o) {
        System.out.println(o);
    }

    public static int ensureIntInput() {
        return ensureIntInput(i -> true);
    }

    public static int ensureIntInput(@NotNull Predicate<Integer> condition) {
        return new SafeInput<Integer>(condition, () -> Integer.parseInt(input.nextLine())).ensureInput();
    }

    public static double ensureDoubleInput() {
        return ensureDoubleInput(d -> true);
    }

    public static double ensureDoubleInput(@NotNull Predicate<Double> condition) {
        return new SafeInput<Double>(condition, () -> Double.parseDouble(input.nextLine())).ensureInput();
    }


    private static class SafeInput<T> {
        @NotNull Predicate<T> condition;
        @NotNull Supplier<T> supplier;
        private static final String INVALID_INPUT = "Ingreso inválido. Reinténtelo";

        public SafeInput(@NotNull Predicate<T> condition, @NotNull Supplier<T> supplier) {
            this.condition = condition;
            this.supplier = supplier;
        }

        private T ensureInput() {
            Optional<T> input = Optional.empty();
            while(input.isEmpty()) {
                try {
                    input = Optional.of(supplier.get());
                    if (!condition.test(input.get())) {
                        invalidateInput();
                        input = Optional.empty();
                    }
                } catch (final Exception e) {
                    invalidateInput();
                }
            }
            return input.get();
        }

        private void invalidateInput() {
            print(INVALID_INPUT);
        }

    }
}
