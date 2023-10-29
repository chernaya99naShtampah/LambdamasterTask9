@FunctionalInterface
public interface LongPredicate<T, U, R, Integer>
{
    boolean apply(T arg1, U arg2, R arg3, Integer number);
}
