import java.util.function.*;

public class LambdaRunner
{
    public static <T, R> R getOperation(Function<T, R> function, T arg)
    {
        return function.apply(arg);
    }

    public static <T, U> boolean getOperation(BiPredicate<T, U> function, T arg1, U arg2)
    {
        return function.test(arg1, arg2);
    }

    public static <T, U, R> boolean getOperation(LongPredicate<T, U, R, Integer> function, T arg1, U arg2, R arg3, int maxAge)
    {
        return function.apply(arg1, arg2, arg3, maxAge);
    }
}
