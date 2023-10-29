import org.junit.Test;

import static org.junit.Assert.*;

public class LambdaDemoTest
{
    @Test
    public void testLength1()
    {
        assertEquals(12, LambdaDemo.length.apply("refrigerator"));
    }

    @Test
    public void testLength2()
    {
        assertEquals(14, LambdaDemo.length.apply("transformation"));
    }

    @Test
    public void testLength3()
    {
        assertEquals(7, LambdaDemo.length.apply("panther"));
    }

    @Test
    public void testFirstSymbol1()
    {
        assertEquals('c', LambdaDemo.firstSymbol.apply("cat").charValue());
    }

    @Test
    public void testFirstSymbol2()
    {
        assertEquals('d', LambdaDemo.firstSymbol.apply("dog").charValue());
    }

    @Test
    public void testFirstSymbol3() 
    {
        assertNull(LambdaDemo.firstSymbol.apply(""));
    }

    @Test
    public void testCheckSpace1()
    {
        assertFalse(LambdaDemo.checkSpace.apply("cat is black"));
    }

    @Test
    public void testCheckSpace2()
    {
        assertTrue(LambdaDemo.checkSpace.apply("black"));
    }

    @Test
    public void testCheckSpace3()
    {
        assertTrue(LambdaDemo.checkSpace.apply(""));
    }

    @Test
    public void testWords1()
    {
        assertEquals(5, LambdaDemo.getWords.apply("cat, dog, human, girl, lion"));
    }

    @Test
    public void testWords2()
    {
        assertEquals(3, LambdaDemo.getWords.apply("pencil, pen, notebook"));
    }

    @Test
    public void testWords3()
    {
        assertEquals(1, LambdaDemo.getWords.apply("panther"));
    }

    @Test
    public void testGetAge1() throws Exception
    {
        Human human = new Human("Ivanov", "Ivan", "Ivanovich", 23);

        assertEquals(23, LambdaDemo.getAge.apply(human));
    }

    @Test
    public void testGetAge2() throws Exception
    {
        Student student = new Student("Dmitriev", "Dmitrii", "Vladimirovich", 19, "omsu", "mathematics", "applied mathematics");

        assertEquals(19, LambdaDemo.getAge.apply(student));
    }

    @Test
    public void testGetAge3() throws Exception
    {
        Human human = new Human("Artemov", "Dmitrii", "Dmitrievich", 77);

        assertEquals(77, LambdaDemo.getAge.apply(human));
    }

    @Test
    public void testCheckSurname1() throws Exception
    {
        Human human1 = new Human("Ivanov", "Ivan", "Ivanovich", 23);
        Human human2 = new Human("Ivanov", "Dmitrii", "Dmitrievich", 77);

        assertTrue(LambdaDemo.checkSurname.apply(human1, human2));
    }

    @Test
    public void testCheckSurname2() throws Exception
    {
        Human human1 = new Human("Ivanov", "Ivan", "Ivanovich", 23);
        Human human2 = new Human("Artemov", "Dmitrii", "Dmitrievich", 77);

        assertFalse(LambdaDemo.checkSurname.apply(human1, human2));
    }

    @Test
    public void testCheckSurname3() throws Exception
    {
        Student student1 = new Student("Dmitriev", "Dmitrii", "Vladimirovich", 19, "omsu", "mathematics", "applied mathematics");
        Student student2 = new Student("Dmitriev", "Andrei", "Ivanovich", 20, "omgtu", "psychology", "psychologist");

        assertTrue(LambdaDemo.checkSurname.apply(student1, student2));
    }

    @Test
    public void testCheckSurname4() throws Exception
    {
        Student student1 = new Student("Dmitriev", "Dmitrii", "Vladimirovich", 19, "omsu", "mathematics", "applied mathematics");
        Student student2 = new Student("Andreev", "Andrei", "Ivanovich", 20, "omgtu", "psychology", "psychologist");

        assertFalse(LambdaDemo.checkSurname.apply(student1, student2));
    }

    @Test
    public void testCheckSurname5() throws Exception
    {
        Human human = new Human("Andreev", "Ivan", "Ivanovich", 23);
        Student student = new Student("Andreev", "Andrei", "Artemovich", 20, "omgtu", "psychology", "psychologist");

        assertTrue(LambdaDemo.checkSurname.apply(human, student));
    }

    @Test
    public void testGetFIO1() throws Exception
    {
        Human human = new Human("Ivanov", "Ivan", "Ivanovich", 23);

        assertEquals("Ivanov Ivan Ivanovich", LambdaDemo.getFIO.apply(human));
    }

    @Test
    public void testGetFIO2() throws Exception
    {
        Student student = new Student("Dmitriev", "Dmitrii", "Vladimirovich", 19, "omsu", "mathematics", "applied mathematics");

        assertEquals("Dmitriev Dmitrii Vladimirovich", LambdaDemo.getFIO.apply(student));
    }

    @Test
    public void testGetFIO3() throws Exception
    {
        Student student = new Student("Andreev", "Andrei", "Ivanovich", 20, "omgtu", "psychology", "psychologist");

        assertEquals("Andreev Andrei Ivanovich", LambdaDemo.getFIO.apply(student));
    }

    @Test
    public void testUpAge1() throws Exception
    {
        Human human = new Human("Artemov", "Dmitrii", "Dmitrievich", 77);

        assertEquals(new Human("Artemov", "Dmitrii", "Dmitrievich", 78), LambdaDemo.upAge.apply(human));
    }

    @Test
    public void testUpAge2() throws Exception
    {
        Human human = new Human("Ivanov", "Ivan", "Ivanovich", 23);

        assertEquals(new Human("Ivanov", "Ivan", "Ivanovich", 24), LambdaDemo.upAge.apply(human));
    }

    @Test
    public void testLessMaxAge1() throws Exception
    {
        Human human1 = new Human("Ivanov", "Ivan", "Ivanovich", 23);
        Human human2 = new Human("Andreev", "Dmitrii", "Dmitrievich", 54);
        Human human3 = new Human("Artemov", "Artem", "Vladimirovich", 42);

        assertTrue(LambdaDemo.lessMaxAge.apply(human1, human2, human3, 60));
    }

    @Test
    public void testLessMaxAge2() throws Exception
    {
        Human human1 = new Human("Ivanov", "Ivan", "Ivanovich", 23);
        Human human2 = new Human("Andreev", "Dmitrii", "Dmitrievich", 54);
        Human human3 = new Human("Artemov", "Artem", "Vladimirovich", 42);

        assertFalse(LambdaDemo.lessMaxAge.apply(human1, human2, human3, 50));
    }
}