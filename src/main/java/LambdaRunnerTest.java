import org.junit.Test;
import java.util.function.BiPredicate;
import java.util.function.Function;

import static org.junit.Assert.*;

public class LambdaRunnerTest
{
    @Test
    public void testGetOperation1()
    {
        Function<String, Integer> function = String::length;

        Integer ans = 12;

        assertEquals(ans, LambdaRunner.getOperation(function, "refrigerator"));
    }

    @Test
    public void testGetOperation2()
    {
        Function<String, Integer> function = String::length;

        Integer ans = 7;

        assertEquals(ans, LambdaRunner.getOperation(function, "panther"));
    }

    @Test
    public void testGetOperation3()
    {
        Function<String, Integer> function = String::length;

        Integer ans = 0;

        assertEquals(ans, LambdaRunner.getOperation(function, ""));
    }

    @Test
    public void testGetOperation4()
    {
        Function<String, Character> function = str -> { if ("".equals(str) || str == null) { return null; } else { return str.charAt(0); } };

        Character ans = 'c';

        assertEquals(ans, LambdaRunner.getOperation(function, "cat"));
    }

    @Test
    public void testGetOperation5()
    {
        Function<String, Character> function = str -> { if ("".equals(str) || str == null) { return null; } else { return str.charAt(0); } };

        Character ans = 'd';

        assertEquals(ans, LambdaRunner.getOperation(function, "dog"));
    }
    @Test
    public void testGetOperation6()
    {
        Function<String, Character> function = str -> { if ("".equals(str) || str == null) { return null; } else { return str.charAt(0); } };

        Character ans = null;

        assertEquals(ans, LambdaRunner.getOperation(function, ""));
    }

    @Test
    public void testGetOperation7()
    {
        Function<String, Boolean> function = str -> str.split(" ").length == 1;

        assertFalse(LambdaRunner.getOperation(function, "cat dog man woman"));
    }

    @Test
    public void testGetOperation8()
    {
        Function<String, Boolean> function = str -> str.split(" ").length == 1;

        assertTrue(LambdaRunner.getOperation(function, "woman"));
    }

    @Test
    public void testGetOperation9()
    {
        Function<String, Boolean> function = str -> str.split(" ").length == 1;

        assertTrue(LambdaRunner.getOperation(function, ""));
    }

    @Test
    public void testGetOperation10()
    {
        Function<String, Integer> function = str -> str.split(",").length;

        Integer ans = 4;

        assertEquals(ans, LambdaRunner.getOperation(function, "cat, dog, man, woman"));
    }

    @Test
    public void testGetOperation11()
    {
        Function<String, Integer> function = str -> str.split(",").length;

        Integer ans = 2;

        assertEquals(ans, LambdaRunner.getOperation(function, "cat, dog"));
    }

    @Test
    public void testGetOperation12()
    {
        Function<String, Integer> function = str -> str.split(",").length;

        Integer ans = 1;

        assertEquals(ans, LambdaRunner.getOperation(function, "cat"));
    }

    @Test
    public void testGetOperation13() throws Exception
    {
        Function<Human, Integer> function = Human::getAge;

        Human human = new Human("Ivanov", "Ivan", "Ivanovich", 23);

        Integer ans = 23;

        assertEquals(ans, LambdaRunner.getOperation(function, human));
    }

    @Test
    public void testGetOperation14() throws Exception
    {
        Function<Human, Integer> function = Human::getAge;

        Student student = new Student("Dmitriev", "Dmitrii", "Vladimirovich", 19, "omsu", "mathematics", "applied mathematics");

        Integer ans = 19;

        assertEquals(ans, LambdaRunner.getOperation(function, student));
    }

    @Test
    public void testGetOperation15() throws Exception
    {
        Function<Human, Integer> function = Human::getAge;

        Human human = new Human("Artemov", "Dmitrii", "Dmitrievich", 77);

        Integer ans = 77;

        assertEquals(ans, LambdaRunner.getOperation(function, human));
    }

    @Test
    public void testGetOperation16() throws Exception
    {
        Function<Human, String> function = hum -> hum.getSurname().concat(" " + hum.getName()).concat(" " + hum.getPatronymic());

        Human human = new Human("Artemov", "Dmitrii", "Dmitrievich", 77);

        assertEquals("Artemov Dmitrii Dmitrievich", LambdaRunner.getOperation(function, human));
    }

    @Test
    public void testGetOperation17() throws Exception
    {
        Function<Human, String> function = hum -> hum.getSurname().concat(" " + hum.getName()).concat(" " + hum.getPatronymic());

        Human human = new Human("Ivanov", "Ivan", "Ivanovich", 23);

        assertEquals("Ivanov Ivan Ivanovich", LambdaRunner.getOperation(function, human));
    }

    @Test
    public void testGetOperation18() throws Exception
    {
        Function<Human, String> function = human -> human.getSurname().concat(" " + human.getName()).concat(" " + human.getPatronymic());

        Student student = new Student("Andreev", "Andrei", "Ivanovich", 20, "omgtu", "psychology", "psychologist");

        assertEquals("Andreev Andrei Ivanovich", LambdaRunner.getOperation(function, student));
    }

    @Test
    public void testGetOperation19() throws Exception
    {
        Function<Human, Human> function = hum ->
        {
            try
            {
                return new Human(hum.getSurname(), hum.getName(), hum.getPatronymic(), hum.getAge() + 1);
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        };

        Human human = new Human("Ivanov", "Ivan", "Ivanovich", 23);

        assertEquals(new Human("Ivanov", "Ivan", "Ivanovich", 24), LambdaRunner.getOperation(function, human));
    }

    @Test
    public void testGetOperation20() throws Exception
    {
        Function<Human, Human> function = hum ->
        {
            try
            {
                return new Human(hum.getSurname(), hum.getName(), hum.getPatronymic(), hum.getAge() + 1);
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        };

        Human human = new Human("Artemov", "Dmitrii", "Dmitrievich", 77);

        assertEquals(new Human("Artemov", "Dmitrii", "Dmitrievich", 78), LambdaRunner.getOperation(function, human));
    }

    @Test
    public void testGetOperation21() throws Exception
    {
        BiPredicate<Human, Human> function = (obj1, obj2) -> obj1.getSurname().equals(obj2.getSurname());

        Human human1 = new Human("Ivanov", "Ivan", "Ivanovich", 23);
        Human human2 = new Human("Ivanov", "Dmitrii", "Dmitrievich", 77);

        assertTrue(LambdaRunner.getOperation(function, human1, human2));
    }

    @Test
    public void testGetOperation22() throws Exception
    {
        BiPredicate<Human, Human> function = (obj1, obj2) -> obj1.getSurname().equals(obj2.getSurname());

        Student student1 = new Student("Dmitriev", "Dmitrii", "Vladimirovich", 19, "omsu", "mathematics", "applied mathematics");
        Student student2 = new Student("Dmitriev", "Andrei", "Ivanovich", 20, "omgtu", "psychology", "psychologist");

        assertTrue(LambdaRunner.getOperation(function, student1, student2));
    }

    @Test
    public void testGetOperation23() throws Exception
    {
        BiPredicate<Human, Human> function = (obj1, obj2) -> obj1.getSurname().equals(obj2.getSurname());

        Human human = new Human("Andreev", "Ivan", "Ivanovich", 23);
        Student student = new Student("Andreev", "Andrei", "Artemovich", 20, "omgtu", "psychology", "psychologist");

        assertTrue(LambdaRunner.getOperation(function, human, student));
    }

    @Test
    public void testGetOperation24() throws Exception
    {
        LongPredicate<Human, Human, Human, Integer> function = (obj1, obj2, obj3, maxAge) -> obj1.getAge() < maxAge && obj2.getAge() < maxAge && obj3.getAge() < maxAge;

        Human human1 = new Human("Ivanov", "Ivan", "Ivanovich", 23);
        Human human2 = new Human("Andreev", "Dmitrii", "Dmitrievich", 54);
        Human human3 = new Human("Artemov", "Artem", "Vladimirovich", 42);

        assertTrue(LambdaRunner.getOperation(function, human1, human2, human3, 60));
    }

    @Test
    public void testGetOperation25() throws Exception
    {
        LongPredicate<Human, Human, Human, Integer> function = (obj1, obj2, obj3, maxAge) -> obj1.getAge() < maxAge && obj2.getAge() < maxAge && obj3.getAge() < maxAge;

        Human human1 = new Human("Ivanov", "Ivan", "Ivanovich", 23);
        Human human2 = new Human("Andreev", "Dmitrii", "Dmitrievich", 54);
        Human human3 = new Human("Artemov", "Artem", "Vladimirovich", 42);

        assertFalse(LambdaRunner.getOperation(function, human1, human2, human3, 50));
    }
}