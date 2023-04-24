package experiment;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Asus
 */
public class Experiment extends WindowAdapter implements ActionListener {

    Array arr=new Array(Array.generateTestData(10,0));
    JFrame frame ;
    JMenuBar mb;
    JMenu menu;
    JMenuItem op1,op2,op3,op4;
    JButton but1,but2,but3,but4;
    Label lBeA,lNowA;
    TextField BeA,NowA;

    public Experiment()
    {
        super();
    }
    public void setGui()
    {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(150, 150, 500, 310);
        frame.addWindowListener(this);
        frame.setLocationRelativeTo(null);
        mb = new JMenuBar();
        menu = new JMenu("Function");
        op1 = new JMenuItem("Sort");
        op2 = new JMenuItem("Insert");
        op3 = new JMenuItem("Delete");
        op4 = new JMenuItem("Reverse");
        op1.addActionListener(this);
        op2.addActionListener(this);
        op3.addActionListener(this);
        op4.addActionListener(this);
//        but1 = new Button("����");
//        but2 = new Button("����");
//        but3 = new Button("ɾ��");
//        but4 = new Button("����");
        lBeA = new Label("ԭ����");
        lNowA = new Label("������");
        menu.add(op1);menu.add(op2);menu.add(op3);menu.add(op4);
        mb.add(menu);
//        frame.add(lBeA);
//        frame.add(lNowA);
//        frame.add(BeA);
//        frame.add(NowA);
        frame.setJMenuBar(mb);
        frame.setVisible(true);

        //frame.add(but1);
        //frame.add(but2);
        //frame.add(but3);
        //frame.add(but4);
        op1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                arr=new Array(Array.generateTestData(10, 0));
                JOptionPane.showMessageDialog(frame,
                        "ԭ����:"+arr.arrayToString(arr.getData()),
                        "ԭ����",
                        1);
                arr.SortUp();
                JOptionPane.showMessageDialog(frame,
                        "������:"+arr.arrayToString(arr.getData()),
                        "������",
                        1);
            }

        });
        op2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                arr=new Array(Array.generateTestData(12,2));
                arr.SortUp();
                JOptionPane.showMessageDialog(frame,
                        "ԭ����:"+arr.arrayToString(arr.getData(),10),
                        "ԭ����",
                        1);
                String s=JOptionPane.showInputDialog(frame,
	                    "������������:","");
                int a = Integer.parseInt(s);
                arr.Insert(a);
                JOptionPane.showMessageDialog(frame,
                        "������:"+arr.arrayToString(arr.getData(),11),
                        "������",
                        1);
            }

        });
        op3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                arr=new Array(Array.generateTestData(10, 0));
                arr.SortUp();
                arr.Insert(11);
                JOptionPane.showMessageDialog(frame,
                        "ԭ����:"+arr.arrayToString(arr.getData()),
                        "ԭ����",
                        1);
                arr.Delete(11);
                JOptionPane.showMessageDialog(frame,
                        "������:"+arr.arrayToString(arr.getData(),10-arr.nDel),
                        "������",
                        1);
            }

        });
        op4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                arr=new Array(Array.generateTestData(10, 0));
                arr.SortUp();
                JOptionPane.showMessageDialog(frame,
                        "ԭ����:"+arr.arrayToString(arr.getData()),
                        "ԭ����",
                        1);
                arr.Reverse();
                JOptionPane.showMessageDialog(frame,
                        "������:"+arr.arrayToString(arr.getData()),
                        "������",
                        1);
            }

        });

    }
    public void actionPerformed(ActionEvent arg0) {

    }

    public static void main(String[] args) {
        // TODO code application logic here
        Experiment ep=new Experiment();
        ep.setGui();
        ep.frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

    }

}
