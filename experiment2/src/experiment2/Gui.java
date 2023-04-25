package experiment2;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Gui extends WindowAdapter implements ActionListener{
	
	Frame frame;
    Label la,lb,lc;
    TextField ta,tb,tc;
    Button submit,reset;
    public void SetGui()
    {
    	 frame = new JFrame();
         frame.setVisible(true);
         frame.setBounds(150, 150, 1000, 800);
         frame.addWindowListener(this);
         frame.setLocationRelativeTo(null);
         la=new Label("a = ");
         la.setBounds(200, 200, 60, 30);
         lb=new Label("b = ");
         lb.setBounds(200, 300, 60, 30);
         lc=new Label("c = ");
         lc.setBounds(200, 400, 60, 30);
         ta=new TextField(30);
         ta.setBounds(400, 200, 100, 30);
         tb=new TextField(30);
         tb.setBounds(400, 300, 100, 30);
         tc=new TextField(30);
         tc.setBounds(400, 400, 100, 30);
         submit=new Button("submit");
         reset=new Button("reset");
         submit.setBounds(200, 600, 100, 30);
         reset.setBounds(200, 650, 100, 30);
         frame.setLayout(null);
         frame.add(la);frame.add(lb);frame.add(lc);
         frame.add(ta);frame.add(tb);frame.add(tc);
         frame.add(submit);
         frame.add(reset);
         submit.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e)
             {
            	 double a,b,c;
            	 a=Double.parseDouble(ta.getText());
            	 b=Double.parseDouble(tb.getText());
            	 c=Double.parseDouble(tc.getText());
            	 Solver solver=new Solver(a,b,c);
            	 solver.SolvingEquation();
            	 Result result=solver.getResult();
            	 JOptionPane.showMessageDialog(frame,
                         "x1="+ Double.toString(result.getX1())+"   "+"x2="+Double.toString(result.getX2()),
                         "结果",
                         1);
             }

         });
         reset.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e)
             {
            	 ta.setText("");
            	 tb.setText("");
            	 tc.setText("");
            	 JOptionPane.showMessageDialog(frame,
                         "数据已重置",
                         "结果",
                         1);
             }

         });
         
    }
	
	
	
	
	public void actionPerformed(ActionEvent arg0) {

    }

	public static void main(String[] args) {
        // TODO code application logic here
        Gui gui=new Gui();
        gui.SetGui();
        gui.frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

    }
}
