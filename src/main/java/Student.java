public class Student extends Human
{
    private String university;
    private String faculty;
    private String specialization;

    public Student(String surname, String name, String patronymic, int age, String university, String faculty, String specialization) throws Exception
    {
        super(surname, name, patronymic, age);

        if ("".equals(university) || university == null)
        {
            throw new Exception("Wrong university!");
        }
        else if ("".equals(faculty) || faculty == null)
        {
            throw new Exception("Wrong faculty!");
        }
        else if ("".equals(specialization) || specialization == null)
        {
            throw new Exception("Wrong specialization!");
        }

        this.university = university;
        this.faculty = faculty;
        this.specialization = specialization;
    }

    public String getFaculty()
    {
        return faculty;
    }

    public void setFaculty(String faculty) throws Exception
    {
        if ("".equals(faculty) || faculty == null)
        {
            throw new Exception("Wrong faculty!");
        }

        this.faculty = faculty;
    }

    public String getUniversity()
    {
        return university;
    }

    public void setUniversity(String university) throws Exception
    {
        if ("".equals(faculty) || faculty == null)
        {
            throw new Exception("Wrong university!");
        }

        this.university = university;
    }

    public String getSpecialization()
    {
        return specialization;
    }

    public void setSpecialization(String specialization) throws Exception
    {
        if ("".equals(faculty) || faculty == null)
        {
            throw new Exception("Wrong specialization!");
        }

        this.specialization = specialization;
    }


    @Override
    public String toString()
    {
        return "Student {" + " surname = " + super.surname + ", name = " + super.name + ", patronymic = " + super.patronymic + ", age = " + super.age + ", university = " + university + ", faculty = " + faculty  + ", specialization = " + specialization + " }";
    }
}
