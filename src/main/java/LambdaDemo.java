public class LambdaDemo
{
    public static final IOperation length = String::length;
    public static final IOperationSecond firstSymbol = str -> { if ("".equals(str) || str == null) { return null; } else { return str.charAt(0); } };
    public static final IOperationThird checkSpace = str -> str.split(" ").length == 1;
    public static final IOperation getWords = str -> str.split(",").length;
    public static final IOperationFourth getAge = Human::getAge;
    public static final IOperationFifth checkSurname = (obj1, obj2) -> obj1.getSurname().equals(obj2.getSurname());
    public static final IOperationSixth getFIO = human -> human.getSurname().concat(" " + human.getName()).concat(" " + human.getPatronymic());
    public static final IOperationSeventh upAge = human -> new Human(human.getSurname(), human.getName(), human.getPatronymic(), human.getAge() + 1);
    public static final IOperationEighth lessMaxAge = (obj1, obj2, obj3, maxAge) -> obj1.getAge() < maxAge && obj2.getAge() < maxAge && obj3.getAge() < maxAge;
}
