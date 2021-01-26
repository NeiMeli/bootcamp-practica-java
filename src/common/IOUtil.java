package common;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class IOUtil {
    private static final Scanner input = new Scanner(System.in);

    public static void print(@NotNull final Object o) {
        System.out.println(o);
    }

    public static int ensureIntInput(@NotNull String promptMessage) {
        return ensureIntInput(promptMessage, i -> true);
    }

    public static int ensureIntInput(@NotNull String promptMessage, @NotNull Predicate<Integer> condition) {
        return new SafeInput<Integer>(promptMessage, condition, () -> Integer.parseInt(input.nextLine())).ensureInput();
    }

    public static String ensureNotEmptyStringInput(@NotNull String promptMessage) {
        return ensureStringInput(promptMessage, s -> !s.trim().isEmpty());
    }

    public static String ensureStringInput(String promptMessage, Predicate<String> condition) {
        return new SafeInput<String>(promptMessage, condition, input::nextLine).ensureInput();
    }

    public static double ensureDoubleInput(@NotNull String promptMessage) {
        return ensureDoubleInput(promptMessage, d -> true);
    }

    public static double ensureDoubleInput(@NotNull String promptMessage, @NotNull Predicate<Double> condition) {
        return new SafeInput<Double>(promptMessage, condition, () -> Double.parseDouble(input.nextLine())).ensureInput();
    }


    private static class SafeInput<T> {
        @NotNull Predicate<T> condition;
        @NotNull Supplier<T> supplier;
        @NotNull String promptMessage;
        private static final String INVALID_INPUT = "Ingreso inválido. Reinténtelo";

        public SafeInput(@NotNull String promptMessage, @NotNull Predicate<T> condition, @NotNull Supplier<T> supplier) {
            this.condition = condition;
            this.supplier = supplier;
            this.promptMessage = promptMessage;
        }

        private T ensureInput() {
            Optional<T> input = Optional.empty();
            while(input.isEmpty()) {
                print(promptMessage);
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
