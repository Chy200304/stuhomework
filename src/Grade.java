import java.io.Serializable;

public class Grade implements Serializable
{
    public String subject;
    public double score;
    public Grade()
    {
        subject = "0";
        score = 0;
    }
    public Grade(String sub,double score)
    {
        this.subject = sub;
        this.score = score;
    }
};
