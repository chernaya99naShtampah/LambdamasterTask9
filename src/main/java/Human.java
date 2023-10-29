import java.util.Objects;

public class Human
{
    protected String surname;
    protected String name;
    protected String patronymic;

    protected int age;
    protected Gender gender;
    public enum Gender
    {
        MALE, FEMALE
    };

    public Human()
    {

    }
    public Human(String surname, String name, String patronymic, int age) throws Exception
    {
        if ("".equals(surname) || surname == null || "".equals(name) || name == null || "".equals(patronymic) || patronymic == null)
        {
            throw new Exception("Wrong FIO!");
        }
        else if (age < 0)
        {
            throw new Exception("Wrong age!");
        }

        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;

        this.age = age;
    }

    public Human(String surname, String name, String patronymic, int age, String gender) throws Exception
    {
        if ("".equals(surname) || surname == null || "".equals(name) || name == null || "".equals(patronymic) || patronymic == null)
        {
            throw new Exception("Wrong FIO!");
        }
        else if (age < 0)
        {
            throw new Exception("Wrong age!");
        }
        else if (!Gender.MALE.name().equals(gender) && !Gender.FEMALE.name().equals(gender))
        {
            throw new Exception("Wrong gender!");
        }

        this.gender = Gender.valueOf(gender);

        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;

        this.age = age;
    }

    public String getGender()
    {
        return gender.name();
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname) throws Exception
    {
        if ("".equals(surname) || surname == null)
        {
            throw new Exception("Wrong surname!");
        }

        this.surname = surname;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) throws Exception
    {
        if ("".equals(name) || name == null)
        {
            throw new Exception("Wrong name!");
        }

        this.name = name;
    }

    public String getPatronymic()
    {
        return patronymic;
    }

    public void setPatronymic(String patronymic) throws Exception
    {
        if ("".equals(patronymic) || patronymic == null)
        {
            throw new Exception("Wrong patronymic!");
        }

        this.patronymic = patronymic;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age) throws Exception
    {
        if (age < 0)
        {
            throw new Exception("Wrong age!");
        }

        this.age = age;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Human human = (Human) o;

        return age == human.age && Objects.equals(surname, human.surname) && Objects.equals(name, human.name) && Objects.equals(patronymic, human.patronymic);
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public String toString()
    {
        return "Human {" + " surname = " + surname + ", name = " + name + ", patronymic = " + patronymic + ", age = " + age + " }";
    }
}