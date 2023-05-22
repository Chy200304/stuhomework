public  class studentclass
{
    public student[]stu = new student[100];
    public int sumstudent;

    public studentclass() {
        sumstudent = 0;
    }

    public void addscore(student stud,double score,String subject)
    {
        int i;
        for(i=0;i<sumstudent;i++)
        {
            if(stu[i].name.equals(stud.name)&&stu[i].number.equals(stud.number))
            {
                Grade grade = new Grade(subject,score);
                stu[i].g[stu[i].sumsubject++] = grade;
                System.out.println("添加学生成绩成功");
                break;
            }
        }
        if(i==sumstudent) System.out.println("添加学生成绩失败");
    }
    public void deletescore(student stud,String subject)
    {
        int i,j,k;
        for(i=0;i<sumstudent;i++)
        {
            if(stu[i].name.equals(stud.name)&&stu[i].number.equals(stud.number))
            {
                for(j=0;j<stu[i].sumsubject;j++)
                {
                    if(stu[i].g[j].subject.equals(subject))
                    {
                        for(k=j;k<stu[i].sumsubject-1;k++)
                        {
                            stu[i].g[k] = stu[i].g[k+1];
                        }
                        stu[i].sumsubject--;
                        System.out.println("删除学生成绩成功");
                        break;
                    }
                }
                if(j==(stu[i].sumsubject-1))  System.out.println("未找到该学科，删除学生成绩失败");
                break;
            }
        }
        if(i==sumstudent) System.out.println("未找到该学生，删除学生成绩失败");

    }
    public void addStudent(int i,student stud)
    {
        stu[i] = stud;
        this.sumstudent++;
        System.out.println("添加学生成功");
    }
    public void deleteStudent(student stud)
    {
        int i,j;
        int sum =sumstudent;
        for(i=0;i<sumstudent;i++)
        {
            if(stu[i].name.equals(stud.name)&&stu[i].number.equals(stud.number))
            {
                for(j=i;j<sumstudent-1;j++)
                {
                    stu[j]=stu[j+1];
                }
                System.out.println("删除学生成功");
                sumstudent--;
                break;
            }
        }
        if(i==sum) System.out.println("删除学生失败");
    }

    public void printStuScore(student stud)
    {
        for(int i=0;i<stud.sumsubject;i++)
        {
            System.out.println("科目:"+stud.g[i].subject +" 成绩:"+stud.g[i].score);
        }

    }
    public void queryscore(String a)
    {
        for(int i = 0;i<sumstudent;i++)
        {
            if(stu[i].name.equals(a)||stu[i].number.equals(a))
            {
                printStuScore(stu[i]);
            }
        }
    }
    public void changeScore(student stud,String subject,double Score)
    {
        int i,j;
        for(i = 0;i<sumstudent;i++)
        {
            if(stu[i].name.equals(stud.name)&&stu[i].number.equals(stud.number))
            {
                for(j = 0;j<stu[i].sumsubject;j++)
                {
                    if(stu[i].g[j].subject.equals(subject))
                    {
                        stu[i].g[j].score = Score;
                    }
                }
            }
        }

    }
    public void printAllStudentScore()
    {
        for(int i = 0;i<this.sumstudent;i++)
        {
            System.out.println(stu[i].name);
            System.out.println(stu[i].number);
            printStuScore(stu[i]);

        }
    }
}