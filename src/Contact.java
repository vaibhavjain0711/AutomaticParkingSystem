import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Contact extends JFrame
{
	ImageIcon i;
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;

	public Contact()
	{
		Font f= new Font("Times New Roman",Font.BOLD|Font.ITALIC,55);
		Font f1= new Font("Times New Roman",Font.BOLD|Font.ITALIC,45);

 		setLayout(new FlowLayout());
		i=new ImageIcon(this.getClass().getResource("z16.jpg"));
		l=new JLabel(i);
		setContentPane(l);

		setLayout(null);
		l1=new JLabel("YOU CAN CATCH US ON:");
		l1.setFont(f);
		l1.setBounds(50,50,800,100);
		add(l1);
		
		l2=new JLabel("Admin 1:- Vaibhav Jain");
		l2.setBounds(350,200,800,100);
		l2.setForeground(Color.red);
		l2.setFont(f1);
		add(l2);

		l3=new JLabel("Email Id :- vaibhavjain602@gmail.com");
		l3.setFont(f1);
		l3.setForeground(Color.red);
		l3.setBounds(350,250,1000,100);
		add(l3);

		l4=new JLabel("Contact No. :- 7206097051");
		l4.setFont(f1);
		l4.setForeground(Color.red);
		l4.setBounds(350,300,800,100);
		add(l4);

		l5=new JLabel("Admin 2 :- Paras Sharma");
		l5.setBounds(350,400,800,100);
		l5.setForeground(Color.yellow);
		l5.setFont(f1);
		add(l5);

		l6=new JLabel("Email Id :- parassharma0906@gmail.com");
		l6.setFont(f1);
		l6.setForeground(Color.yellow);
		l6.setBounds(350,450,1000,100);
		add(l6);

		l7=new JLabel("Contact No. :- 7015831364");
		l7.setFont(f1);
		l7.setForeground(Color.yellow);
		l7.setBounds(350,500,800,100);
		add(l7);

		

	}
	public static void main(String args[])
	{
		Contact s1= new Contact();
		s1.setExtendedState(JFrame.MAXIMIZED_BOTH);
		s1.setVisible(true);
		s1.setTitle("CONTACT US");
		s1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}