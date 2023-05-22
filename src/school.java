import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class school {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        studentclass classroom  = new studentclass();
        int sumnumstudent = 0;
        Scanner sc = new Scanner(new FileReader("C:/Users/Asus/Desktop/studentnum.txt"));
        try {
            sumnumstudent = sc.nextInt();
        }catch(Exception e) {
            System.out.println(e.getMessage() + "错误!");
        }
        System.out.println(sumnumstudent);
        File file = new File("C:/Users/Asus/Desktop/student.txt");
        student stuaddress ;
        FileInputStream fin;
        fin = new FileInputStream(file);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fin);
        }catch (Exception e) {
            System.out.println(e.getMessage() + "错误!");
        }
        finally{
                for(int i=0;i<sumnumstudent;i++)
                {
                    stuaddress = (student) ois.readObject();
                    classroom.addStudent(i,stuaddress);
                }
                if(ois!=null)
                    ois.close();
            }
        int x = -1;
        Scanner scanner = new Scanner(System.in);
        while(x!=0)
        {
            System.out.println("成绩管理系统功能如下");
            System.out.println("1：添加一个学生");
            System.out.println("2：删除一个学生");
            System.out.println("3：添加一门学科的成绩");
            System.out.println("4：删除一门学科的成绩");
            System.out.println("5：根据学生的姓名或学号查找成绩");
            System.out.println("6：修改学生的一门成绩");
            System.out.println("7：输出所有学生的成绩");
            System.out.println("0：退出");
            System.out.println("请输入你想使用的功能序号：");
            x = scanner.nextInt();
            switch (x) {
                case 1:
                {
                    System.out.println("请添加学生名单和成绩");
                    System.out.println("请输入你想添加的学生个数:");
                    int n = scanner.nextInt();
                    int flag= classroom.sumstudent;
                    for(int i=flag;i<flag+n;i++)
                    {
                        System.out.println("请输入第"+ ++i+"个学生的名字");
                        String name = scanner.next();
                        System.out.println("请输入第"+i+"个学生的学号");
                        String num = scanner.next();
                        i--;
                        student stud = new student(name,num);
                        classroom.addStudent(i,stud);
                    }
                    break;
                }
                case 2:
                {
                    System.out.println("请输入你想删除的学生姓名:");
                    String name = scanner.next();
                    System.out.println("请输入你想删除的学生学号:");
                    String num = scanner.next();
                    student stud = new student(name,num);
                    classroom.deleteStudent(stud);
                    break;

                }

                case 3:
                {
                    System.out.println("请输入你想添加成绩的学生姓名:");
                    String name = scanner.next();
                    System.out.println("请输入你想添加成绩的学生学号:");
                    String num = scanner.next();
                    student stud = new student(name,num);
                    System.out.println("请输入你想添加的科目:");
                    String subject = scanner.next();
                    System.out.println("请输入你想添加的科目成绩:");
                    double score = scanner.nextDouble();
                    classroom.addscore(stud,score,subject);
                    break;
                }
                case 4:
                {
                    System.out.println("请输入你想删除成绩的学生姓名:");
                    String name = scanner.next();
                    System.out.println("请输入你想删除成绩的学生学号:");
                    String num = scanner.next();
                    student stud = new student(name,num);
                    System.out.println("请输入你想删除的科目:");
                    String subject = scanner.next();
                    classroom.deletescore(stud,subject);
                    break;
                }
                case 5:
                {
                    System.out.println("请输入你想查找成绩的学生姓名或学号:");
                    String a = scanner.next();
                    classroom.queryscore(a);
                    break;
                }
                case 6:
                {
                    System.out.println("请输入你想修改成绩的学生姓名:");
                    String name = scanner.next();
                    System.out.println("请输入你想修改成绩的学生学号:");
                    String num = scanner.next();
                    student stud = new student(name,num);
                    System.out.println("请输入你想修改成绩的科目:");
                    String subject = scanner.next();
                    System.out.println("请输入修改后的成绩:");
                    double score = scanner.nextDouble();
                    classroom.changeScore(stud,subject,score);
                    break;
                }
                case 7:
                {
                    System.out.println("所有学生的信息如下：");
                    System.out.println("总共有学生："+classroom.sumstudent+"人");
                    classroom.printAllStudentScore();
                    break;
                }
                case 0:
                {

                    FileOutputStream fos = new FileOutputStream("C:/Users/Asus/Desktop/student.txt");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    for(int i=0;i< classroom.sumstudent;i++) {
                        oos.writeObject(classroom.stu[i]);
                    }
                    oos.close();
                    FileOutputStream fos1 = new FileOutputStream("C:/Users/Asus/Desktop/studentnum.txt");
                    PrintWriter pwr = new PrintWriter(fos1);
                    pwr.println(classroom.sumstudent);
                    pwr.close();
                    fos1.close();
                    System.out.println("文件信息保存完毕");
                    break;
                }
                default:
                    System.out.println("你输入的编号错误，请输入0-7");
                    break;
            }

        }





    }

}
