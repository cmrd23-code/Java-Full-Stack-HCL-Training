package lambdas;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaExpressions {
    public static void main(String[] args) {
        demonstrateFunction();
        demonstrateBiFunction();
        demonstratePredicate();
        demonstrateBiPredicate();
        demonstrateConsumer();
        demonstrateBiConsumer();
        demonstrateSupplier();
        demonstrateUnaryOperator();
        demonstrateBinaryOperator();
    }

    private static void demonstrateFunction() {
        Function<String, Integer> lambda = text -> text.length();
        Function<String, Integer> anonymous = new Function<String, Integer>() {
            @Override
            public Integer apply(String text) {
                return text.length();
            }
        };
        printComparison("Function (String -> length)", lambda.apply("Java"), anonymous.apply("Java"));
    }

    private static void demonstrateBiFunction() {
        BiFunction<String, String, String> lambda = (first, last) -> first + " " + last;
        BiFunction<String, String, String> anonymous = new BiFunction<String, String, String>() {
            @Override
            public String apply(String first, String last) {
                return first + " " + last;
            }
        };
        printComparison("BiFunction (combine names)", lambda.apply("Ada", "Lovelace"),
                anonymous.apply("Ada", "Lovelace"));
    }

    private static void demonstratePredicate() {
        Predicate<Integer> lambda = number -> number > 0;
        Predicate<Integer> anonymous = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number > 0;
            }
        };
        printComparison("Predicate (is positive)", lambda.test(5), anonymous.test(5));
    }

    private static void demonstrateBiPredicate() {
        BiPredicate<String, String> lambda = (text, prefix) -> text.startsWith(prefix);
        BiPredicate<String, String> anonymous = new BiPredicate<String, String>() {
            @Override
            public boolean test(String text, String prefix) {
                return text.startsWith(prefix);
            }
        };
        printComparison("BiPredicate (starts with)", lambda.test("Java", "Ja"),
                anonymous.test("Java", "Ja"));
    }

    private static void demonstrateConsumer() {
        Consumer<String> lambda = text -> System.out.println("  lambda: " + text);
        Consumer<String> anonymous = new Consumer<String>() {
            @Override
            public void accept(String text) {
                System.out.println("  anonymous: " + text);
            }
        };
        System.out.println("Consumer (print a value)");
        lambda.accept("Hello, Java");
        anonymous.accept("Hello, Java");
    }

    private static void demonstrateBiConsumer() {
        BiConsumer<String, Integer> lambda =
                (name, age) -> System.out.println("  lambda: " + name + " is " + age);
        BiConsumer<String, Integer> anonymous = new BiConsumer<String, Integer>() {
            @Override
            public void accept(String name, Integer age) {
                System.out.println("  anonymous: " + name + " is " + age);
            }
        };
        System.out.println("BiConsumer (print two values)");
        lambda.accept("Ada", 36);
        anonymous.accept("Ada", 36);
    }

    private static void demonstrateSupplier() {
        Supplier<String> lambda = () -> "value supplied";
        Supplier<String> anonymous = new Supplier<String>() {
            @Override
            public String get() {
                return "value supplied";
            }
        };
        printComparison("Supplier (provide a value)", lambda.get(), anonymous.get());
    }

    private static void demonstrateUnaryOperator() {
        UnaryOperator<Integer> lambda = number -> number * 2;
        UnaryOperator<Integer> anonymous = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer number) {
                return number * 2;
            }
        };
        printComparison("UnaryOperator (double a number)", lambda.apply(4), anonymous.apply(4));
    }

    private static void demonstrateBinaryOperator() {
        BinaryOperator<Integer> lambda = (first, second) -> first + second;
        BinaryOperator<Integer> anonymous = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer first, Integer second) {
                return first + second;
            }
        };
        printComparison("BinaryOperator (add two numbers)", lambda.apply(4, 6),
                anonymous.apply(4, 6));
    }

    private static void printComparison(String example, Object lambdaResult, Object anonymousResult) {
        System.out.println(example);
        System.out.println("  lambda: " + lambdaResult);
        System.out.println("  anonymous: " + anonymousResult);
    }
}
