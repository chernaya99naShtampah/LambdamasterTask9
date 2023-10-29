import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class StreamApiDemoTest
{
    @Test
    public void testNoNull1()
    {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, null, 5, null));

        assertEquals(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), StreamApiDemo.noNull.apply(list));
    }

    @Test
    public void testNoNull2()
    {
        List<Integer> list = new ArrayList<>(Arrays.asList(9, -1, 5, 0, 2));

        assertEquals(list, StreamApiDemo.noNull.apply(list));
    }

    @Test
    public void testNoNull3()
    {
        List<Integer> list = new ArrayList<>(Arrays.asList(null, null));

        assertEquals(new ArrayList<>(), StreamApiDemo.noNull.apply(list));
    }

    @Test
    public void testNoNull4()
    {
        List<Integer> list = new ArrayList<>();

        assertEquals(new ArrayList<>(), StreamApiDemo.noNull.apply(list));
    }

    @Test
    public void testPositiveElem1()
    {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, -4, 3, -5, 7, -8, -9));

        assertEquals((Integer) 4, StreamApiDemo.positiveElem.apply(set));
    }

    @Test
    public void testPositiveElem2()
    {
        Set<Integer> set = new HashSet<>(Arrays.asList(-89, -5, -1, -2));

        assertEquals((Integer) 0, StreamApiDemo.positiveElem.apply(set));
    }

    @Test
    public void testPositiveElem3()
    {
        Set<Integer> set = new HashSet<>(Arrays.asList(56, null, -4, 8, 23, 14, 27));

        assertEquals((Integer) 5, StreamApiDemo.positiveElem.apply(set));
    }

    @Test
    public void testPositiveElem4()
    {
        Set<Integer> set = new HashSet<>();

        assertEquals((Integer) 0, StreamApiDemo.positiveElem.apply(set));
    }

    @Test
    public void testThreeEnd1()
    {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        Integer[] arr = new Integer[]{ 6, 7, 8 };

        assertArrayEquals(arr, StreamApiDemo.threeEnd.apply(list));
    }

    @Test
    public void testThreeEnd2()
    {
        List<Integer> list = new ArrayList<>(Arrays.asList(45, 5, -6, null, 2));

        Integer[] arr = new Integer[]{ -6, 2 };

        assertArrayEquals(arr, StreamApiDemo.threeEnd.apply(list));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThreeEnd3()
    {
        List<Integer> list = new ArrayList<>();

        StreamApiDemo.threeEnd.apply(list);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testThreeEnd4()
    {
        List<Integer> list = new ArrayList<>(Arrays.asList(23, 5));

        StreamApiDemo.threeEnd.apply(list);
    }

    @Test
    public void testEvenNumber1()
    {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertEquals((Integer) 2, StreamApiDemo.evenNumber.apply(list));
    }

    @Test
    public void testEvenNumber2()
    {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, -4, null, 6));

        Integer number = -4;

        assertEquals(number, StreamApiDemo.evenNumber.apply(list));
    }

    @Test
    public void testEvenNumber3()
    {
        List<Integer> list = new ArrayList<>(Arrays.asList(9, 7, 1, 3));

        assertNull(StreamApiDemo.evenNumber.apply(list));
    }

    @Test
    public void testEvenNumber4()
    {
        List<Integer> list = new ArrayList<>();

        assertNull(StreamApiDemo.evenNumber.apply(list));
    }

    @Test
    public void testSqrtNumber1()
    {
        Integer[] arr = new Integer[]{ 1, 2, 3, 4, 5, 6 };

        assertEquals(new ArrayList<>(Arrays.asList(1, 4, 9, 16, 25, 36)), StreamApiDemo.sqrtNumbers.apply(arr));
    }

    @Test
    public void testSqrtNumber2()
    {
        Integer[] arr = new Integer[]{ -4, null, 2, 0 };

        assertEquals(new ArrayList<>(Arrays.asList(16, 4, 0)), StreamApiDemo.sqrtNumbers.apply(arr));
    }

    @Test
    public void testSqrtNumber3()
    {
        Integer[] arr = new Integer[0];

        assertEquals(new ArrayList<>(), StreamApiDemo.sqrtNumbers.apply(arr));
    }

    @Test
    public void testNoEmptyStr1()
    {
        List<String> list = new ArrayList<>(Arrays.asList("", "dog", "cat", "sheep", ""));

        assertEquals(new ArrayList<>(Arrays.asList("cat", "dog", "sheep")), StreamApiDemo.notEmptyStr.apply(list));
    }

    @Test
    public void testNoEmptyStr2()
    {
        List<String> list = new ArrayList<>(Arrays.asList("table", "chair", "car"));

        assertEquals(new ArrayList<>(Arrays.asList("car", "chair", "table")), StreamApiDemo.notEmptyStr.apply(list));
    }

    @Test
    public void testNoEmptyStr3()
    {
        List<String> list = new ArrayList<>(Arrays.asList("", "", "", null));

        assertEquals(new ArrayList<>(), StreamApiDemo.notEmptyStr.apply(list));
    }

    @Test
    public void testConvertList1()
    {
        Set<String> set = new HashSet<>(Arrays.asList("dog", "cat", "magazine", "newspaper"));

        assertEquals(new ArrayList<>(Arrays.asList("newspaper", "magazine", "dog", "cat")), StreamApiDemo.convertList.apply(set));
    }

    @Test
    public void testConvertList2()
    {
        Set<String> set = new HashSet<>(Arrays.asList(null, "table", "chair"));

        assertEquals(new ArrayList<>(Arrays.asList("table", "chair")), StreamApiDemo.convertList.apply(set));
    }

    @Test
    public void testConvertList3()
    {
        Set<String> set = new HashSet<>();

        assertEquals(new ArrayList<>(), StreamApiDemo.convertList.apply(set));
    }

    @Test
    public void testSqrtSum1()
    {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));

        assertEquals((Integer) 55, StreamApiDemo.sqrtSum.apply(set));
    }

    @Test
    public void testSqrtSum2()
    {
        Set<Integer> set = new HashSet<>(Arrays.asList(0, -7, 1, 3, null));

        assertEquals((Integer) 59, StreamApiDemo.sqrtSum.apply(set));
    }

    @Test
    public void testSqrtSum3()
    {
        Set<Integer> set = new HashSet<>();

        assertEquals((Integer) 0, StreamApiDemo.sqrtSum.apply(set));
    }

    @Test
    public void testGetMaxAge1() throws Exception
    {
        Human human1 = new Human("Ivanov", "Ivan", "Ivanovich", 23);
        Human human2 = new Human("Ivanov", "Dmitrii", "Dmitrievich", 16);
        Human human3 = new Human("Artemova", "Angelina", "Dmitrievna", 25);

        List<Human> list = new ArrayList<>(Arrays.asList(human1, human2, human3));

        assertEquals((Integer) 25, StreamApiDemo.getMaxAge.apply(list));
    }

    @Test
    public void testGetMaxAge2() throws Exception
    {
        Human human1 = new Human("Ivanov", "Ivan", "Ivanovich", 20);
        Human human2 = new Human("Ivanov", "Dmitrii", "Dmitrievich", 17);

        List<Human> list = new ArrayList<>(Arrays.asList(human1, human2));

        assertEquals((Integer) 20, StreamApiDemo.getMaxAge.apply(list));
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetMaxAge3()
    {
        List<Human> list = new ArrayList<>();

        StreamApiDemo.getMaxAge.apply(list);
    }

    @Test
    public void testSortCollection1() throws Exception
    {
        Human human1 = new Human("Ivanov", "Ivan", "Ivanovich", 23, "MALE");
        Human human2 = new Human("Ivanov", "Dmitrii", "Dmitrievich", 16, "MALE");
        Human human3 = new Human("Artemova", "Angelina", "Dmitrievna", 25, "FEMALE");
        Human human4 = new Human("Andreev", "Andrei", "Andreevich", 20, "MALE");
        Human human5 = new Human("Ivanova", "Elizaveta", "Artemovna", 18, "FEMALE");
        Human human6 = new Human("Igorev", "Igor", "Igorevich", 26, "MALE");

        List<Human> list = new ArrayList<>(Arrays.asList(human1, human2, human3, human4, human5, human6));

        assertEquals(new ArrayList<>(Arrays.asList(human2, human4, human1, human6, human5, human3)), StreamApiDemo.sortCollection.apply(list));
    }

    @Test
    public void testSortCollection2() throws Exception
    {
        Human human1 = new Human("Artemova", "Angelina", "Dmitrievna", 25, "FEMALE");
        Human human2 = new Human("Ivanova", "Elizaveta", "Artemovna", 18, "FEMALE");
        Human human3 = new Human("Igoreva", "Maria", "Igorevna", 23, "FEMALE");

        List<Human> list = new ArrayList<>(Arrays.asList(human1, human2, human3));

        assertEquals(new ArrayList<>(Arrays.asList(human2, human3, human1)), StreamApiDemo.sortCollection.apply(list));
    }

    @Test
    public void testSortCollection3() throws Exception
    {
        Human human1 = new Human("Ivanov", "Ivan", "Ivanovich", 23, "MALE");
        Human human2 = new Human("Ivanov", "Dmitrii", "Dmitrievich", 16, "MALE");
        Human human3 = new Human("Andreev", "Andrei", "Andreevich", 20, "MALE");
        Human human4 = new Human("Igorev", "Igor", "Igorevich", 26, "MALE");

        List<Human> list = new ArrayList<>(Arrays.asList(human1, human2, human3, human4));

        assertEquals(new ArrayList<>(Arrays.asList(human2, human3, human1, human4)), StreamApiDemo.sortCollection.apply(list));
    }

    @Test
    public void testSortCollection4()
    {
        List<Human> list = new ArrayList<>();

        assertEquals(new ArrayList<>(), StreamApiDemo.sortCollection.apply(list));
    }
}