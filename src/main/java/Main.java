import java.util.*;
import java.util.function.Function;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Human human1 = new Human("Ivanov", "Ivan", "Ivanovich", 23);
        Human human2 = new Human("Ivanov", "Dmitrii", "Dmitrievich", 16);
        Human human3 = new Human("Artemova", "Angelina", "Dmitrievna", 25);

        Student student1 = new Student("Dmitriev", "Dmitrii", "Vladimirovich", 19, "omsu", "mathematics", "applied mathematics");
        Student student2 = new Student("Dmitriev", "Andrei", "Ivanov", 20, "omsu", "mathematics", "applied mathematics");

        System.out.println(human1);
        System.out.println(student1);
        System.out.println(student1.getFaculty());

        String str = "cat is black";

        int length = LambdaDemo.length.apply(str);

        System.out.println(length);

        char symbol = LambdaDemo.firstSymbol.apply(str);

        System.out.println(symbol);

        boolean checkSpace = LambdaDemo.checkSpace.apply(str);

        System.out.println(checkSpace);

        int getWords = LambdaDemo.getWords.apply(str);

        System.out.println(getWords);

        int age = LambdaDemo.getAge.apply(student1);

        System.out.println(age);

        boolean checkSurname = LambdaDemo.checkSurname.apply(student1, student2);

        System.out.println(checkSurname);

        String getFIO = LambdaDemo.getFIO.apply(student1);

        System.out.println(getFIO);

        Human newHuman = LambdaDemo.upAge.apply(human2);

        System.out.println(newHuman);

        boolean maxCheck = LambdaDemo.lessMaxAge.apply(human1, human2, human3, 25);

        System.out.println(maxCheck);

        LongPredicate<Human, Human, Human, Integer> function = (obj1, obj2, obj3, maxAge) -> obj1.getAge() < maxAge && obj2.getAge() < maxAge && obj3.getAge() < maxAge;

        System.out.println(LambdaRunner.getOperation(function, human1, human2, human3, 60));

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, null, 7, null));

        Set<Integer> set = new HashSet<>(Arrays.asList(1, -7, 2, -4, 3, 4, 5, -4, null, 6));

        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 2, 4, 4, 7, 6, 9));

        Integer[] arr = new Integer[]{ 1, 2, 2, 4, 4, 7, 6, 9 };

        List<String> list3 = new ArrayList<>(Arrays.asList("A", "E", "C", "", "", "B"));

        Set<String> set2 = new HashSet<>(Arrays.asList("A", "E", "C", "B"));

        Set<Integer> set3 = new HashSet<>(Arrays.asList(2, 4, 6));

        List<Human> list4 = new ArrayList<>(Arrays.asList(human1, human2, human3));
        System.out.println(list);

        List<?> l = StreamApiDemo.noNull.apply(list);
        System.out.println(l);
        System.out.println(StreamApiDemo.positiveElem.apply(set));
        System.out.println(Arrays.toString(StreamApiDemo.threeEnd.apply(list2)));
        System.out.println(StreamApiDemo.evenNumber.apply(list2));
        System.out.println(StreamApiDemo.sqrtNumbers.apply(arr));
        System.out.println(StreamApiDemo.notEmptyStr.apply(list3));
        System.out.println(StreamApiDemo.convertList.apply(set2));
        System.out.println(StreamApiDemo.sqrtSum.apply(set3));
        System.out.println(StreamApiDemo.getMaxAge.apply(list4));

        Human humang1 = new Human("Ivanov", "Ivan", "Ivanovich", 23, "MALE");
        Human humang2 = new Human("Ivanov", "Dmitrii", "Dmitrievich", 16, "MALE");
        Human humang3 = new Human("Artemova", "Angelina", "Dmitrievna", 25, "FEMALE");
        Human humang4 = new Human("Andreev", "Andrei", "Andreevich", 20, "MALE");
        Human humang5 = new Human("Ivanova", "Elizaveta", "Artemovna", 18, "FEMALE");
        Human humang6 = new Human("Igorev", "Igor", "Igorevich", 26, "MALE");

        List<Human> list5 = new ArrayList<>(Arrays.asList(humang1, humang2, humang3, humang4, humang5, humang6));

        System.out.println(StreamApiDemo.sortCollection.apply(list5));
    }
}
