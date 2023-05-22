import java.io.Serializable;

public class student implements Serializable
{
    public String name;
    public String number;
    public Grade[] g;
    public int sumsubject;
    public student()
    {
        this.name = "0";
        this.number = "0";
        this.g = new Grade[20];
        this.sumsubject = 0;
    }
    public student(String name,String number)
    {
        this.name = name;
        this.number = number;
        this.g = new Grade[20];
        this.sumsubject = 0;
    }
};