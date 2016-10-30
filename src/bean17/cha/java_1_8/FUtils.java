package bean17.cha.java_1_8;

import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * Function Utils
 */
public class FUtils {
    public static void printLog(Supplier<?> function) {
        long start = System.currentTimeMillis();
        System.out.println("result = " + function.get());
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms.");
    }

    public static int sum(IntStream stream, IntPredicate predicate) {
        return stream.parallel().filter(predicate).sum();
    }
}
