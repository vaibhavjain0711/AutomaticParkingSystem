import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SplashScreen extends JFrame
{
ImageIcon i1,i2,i3;
JLabel l1,l2,l3,l4,l5,l6,l7;

public SplashScreen()
{
	setLayout(new FlowLayout());
	i1=new ImageIcon(this.getClass().getResource("p1.jpg"));
	l1=new JLabel(i1);
	setContentPane(l1);

	setLayout(null);
	i2=new ImageIcon(this.getClass().getResource("p2.gif"));
	l2=new JLabel(i2);
	l2.setBounds(30,30,1200,60);
	add(l2);

	Font f= new Font("Times New Roman",Font.BOLD|Font.ITALIC,50);

	l3=new JLabel("Designed by :");
	l3.setFont(f);
	l3.setBounds(100,600,500,120);
	l3.setForeground(Color.magenta);
	l3.setBackground(Color.blue);
	l3.setOpaque(true);
	add(l3);

	l4=new JLabel("Vaibhav Jain");
	l4.setFont(f);
	l4.setBounds(600,600,500,60);
	l4.setForeground(Color.magenta);
	l4.setBackground(Color.blue);
	l4.setOpaque(true);
	add(l4);

	l5=new JLabel("Paras Sharma");
	l5.setFont(f);
	l5.setBounds(600,660,500,60);
	l5.setForeground(Color.magenta);
	l5.setBackground(Color.blue);
	l5.setOpaque(true);
	add(l5);


}

public static void main(String args[])
{
	SplashScreen s1= new SplashScreen();
	s1.setExtendedState(JFrame.MAXIMIZED_BOTH);
	s1.setVisible(true);
	s1.setTitle("Welcome to Parking System");
	s1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	try
	{
		Thread.sleep(5000);
		Login s= new Login();
		s.setExtendedState(JFrame.MAXIMIZED_BOTH);
		s.setVisible(true);
		s.setTitle("LOGIN PAGE");
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	catch(Exception e)
	{ }
}
}