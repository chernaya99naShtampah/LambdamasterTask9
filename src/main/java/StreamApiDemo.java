import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamApiDemo extends LambdaDemo
{
    public static final UnaryOperator<List<?>> noNull = list -> list.stream().filter(Objects::nonNull).toList();
    public static final Function<Set<Integer>, Integer> positiveElem = set -> set.stream().filter(Objects::nonNull).filter(n -> n > 0).toList().size();
    public static final Function<List<?>, Object[]> threeEnd = list -> list.stream().filter(Objects::nonNull).skip(list.size() - 3).toArray();
    public static final Function<List<Integer>, Integer> evenNumber = list -> list.stream().filter(Objects::nonNull).filter(n -> n % 2 == 0).findFirst().orElse(null);
    public static final Function<Integer[], List<Integer>> sqrtNumbers = arr -> Arrays.stream(arr).filter(Objects::nonNull).map(n -> n * n).distinct().toList();
    public static final UnaryOperator<List<String>> notEmptyStr = list -> list.stream().filter(Objects::nonNull).filter(str -> !"".equals(str)).sorted().toList();
    public static final Function<Set<String>, List<String>> convertList = set -> set.stream().filter(Objects::nonNull).sorted(Comparator.reverseOrder()).toList();
    public static final Function<Set<Integer>, Integer> sqrtSum = set -> set.stream().filter(Objects::nonNull).map(n -> n * n).reduce(0, Integer::sum);
    public static final Function<Collection<Human>, Integer> getMaxAge = collection -> collection.stream().filter(Objects::nonNull).max(Comparator.comparingInt(Human::getAge)).get().getAge();
    public static final Function<Collection<Human>, List<Human>> sortCollection = collection -> Stream.concat(collection.stream()
                    .filter(Objects::nonNull)
                    .sorted(Comparator.comparing(Human::getGender))
                    .filter(n -> n.getGender().equals(Human.Gender.MALE.name()))
                    .sorted(Comparator.comparingInt(Human::getAge)), collection.stream()
            .filter(Objects::nonNull)
            .sorted(Comparator.comparing(Human::getGender))
            .filter(n -> n.getGender().equals(Human.Gender.FEMALE.name()))
            .sorted(Comparator.comparingInt(Human::getAge)))
            .toList();
}
