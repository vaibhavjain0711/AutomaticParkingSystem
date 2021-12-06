import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener,ItemListener
{
 ImageIcon i1,i2,i3,i4,i5,i6;
 JLabel l,l1,l2,l3,l4,l5,l6,l7;
 JPasswordField p1;
 JTextField t1;
 JButton b1,b2,b3;
 JRadioButton r1,r2;
JCheckBox ch1;

    public Login()
    {
	setLayout(new FlowLayout());
	i1=new ImageIcon(this.getClass().getResource("p1.jpg"));
	l=new JLabel(i1);
                   setContentPane(l);
	i2=new ImageIcon(this.getClass().getResource("p4.png"));
	l2=new JLabel(i2);
	l2.setBounds(250,400,500,50);
	add(l2);
	i3=new ImageIcon(this.getClass().getResource("p5.png"));
	l3=new JLabel(i3);
	l3.setBounds(250,530,500,50);
	add(l3);
	i4=new ImageIcon(this.getClass().getResource("p6.png"));
	l4=new JLabel(i4);
	l4.setBounds(10,10,200,260);
	add(l4);
	i5=new ImageIcon(this.getClass().getResource("p7.png"));
	l5=new JLabel(i5);
	l5.setBounds(160,10,1500,50);
	add(l5);

	Font f=new Font("Times New Roman",Font.BOLD|Font.ITALIC,30);
	JLabel slogan=new JLabel("Your domain is a goldmine, park with us and your future might shine !");
	slogan.setBounds(600,30,1000,100);
	slogan.setFont(f);
	slogan.setForeground(Color.red);
	add(slogan);

	t1= new JTextField(10);
	t1.setBounds(670,400,350,40);
	t1.setFont(f);
	t1.setBackground(Color.yellow);
	t1.setForeground(Color.red);
	add(t1);

	p1= new JPasswordField(10);
	p1.setEchoChar('*');
	p1.setBounds(670,530,350,40);
	p1.setBackground(Color.yellow);
	p1.setForeground(Color.red);
	p1.setFont(f);
	add(p1);

	ch1=new JCheckBox("SHOW PASSWORD");
  	ch1.setBounds(1050,530,300,40);
  	ch1.setFont(f);
  	ch1.addItemListener(this);
	ch1.setForeground(Color.red);
	ch1.setBackground(Color.yellow);
 	add(ch1);

	b1= new JButton("Login");
	b1.addActionListener(this);
	b1.setBounds(500,700,150,50);
	b1.setForeground(Color.blue);
	b1.setFont(f);
	add(b1);

	b2=new JButton("Clear");
	b2.addActionListener(this);
	b2.setBounds(670,700,150,50);
	b2.setForeground(Color.blue);
	b2.setFont(f);
	add(b2);

	b3=new JButton("Exit");
	b3.addActionListener(this);
	b3.setBounds(850,700,150,50);
	b3.setForeground(Color.blue);
	b3.setFont(f);
	add(b3);
	
	i6=new ImageIcon(this.getClass().getResource("p8.gif"));
	l6=new JLabel(i6);
	l6.setBounds(40,230,450,130);
	add(l6);
	l7=new JLabel(i6);
	l7.setBounds(990,700,550,80);
	add(l7);

	r1=new JRadioButton("Admin");
	r1.setBounds(500,260,170,70);
	r1.setFont(f);
	r1.setBackground(Color.blue);
	r1.setForeground(Color.green);
	r1.addActionListener(this);
	add(r1);
	r2=new JRadioButton(" User");
	r2.setBounds(780,260,170,70);
	r2.setFont(f);
	r2.setBackground(Color.blue);
	r2.setForeground(Color.green);
	r2.addActionListener(this);
	add(r2);
      }
     public void actionPerformed(ActionEvent ae)
     {
	boolean x,y;
	x=r1.isSelected();
	y=r2.isSelected();
	
	if(ae.getSource()==b1)
	{
		if( (t1.getText().equals("")) && (p1.getText().equals("")) )
		 {
			 JOptionPane.showMessageDialog(null,"Please Enter both username and password");
		 }
		else if(x==true)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
				Statement stmt=con.createStatement();
				String query="Select * from adminlogin where username='"+t1.getText()+"' and password='"+p1.getText()+"'";
				ResultSet rs=stmt.executeQuery(query);
				int ctr=0;
				while(rs.next())
				{
					ctr=ctr+1;
				}
				if(ctr==0)
				{
					JOptionPane.showMessageDialog(null,"Invalid username or password");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Admin Login Successfull");
					admin s= new admin();
					s.setExtendedState(JFrame.MAXIMIZED_BOTH);
					s.setVisible(true);
					s.setTitle("ADMIN PANNEL");
					s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Exception" +e);
			}

		}
		else if(y==true)
		{
		  	try
			{
		  		Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
				Statement stmt=con.createStatement();
				String query1="Select * from userlogin where trim(username)='"+t1.getText()+"' and trim(password)='"+p1.getText()+"'";
				ResultSet rs=stmt.executeQuery(query1);
				int ctr=0;
				while(rs.next())
				{
					ctr=ctr+1;
				}
				if(ctr==0)
				{
					JOptionPane.showMessageDialog(null,"Invalid username or password");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"User Login Successfull");
					user u= new user();
					u.setExtendedState(JFrame.MAXIMIZED_BOTH);
					u.setVisible(true);
					u.setTitle("WELCOME TO PARKING SYSTEM");
					u.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
				con.close();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Exception" +e);
			}
		}  	
		
		
	}
	
	else if(ae.getSource()==b2)
	{
		p1.setText("");
		t1.setText("");
	}
	else if(ae.getSource()==b3)
	{
		System.exit(0);
	}
      }
      public void itemStateChanged(ItemEvent ie)
     {
  	boolean b1;
  	b1=ch1.isSelected();
  	if(b1==true)
 	{ 
    		p1.setEchoChar((char)0);
  	}	
  	else if(b1==false)
  	{
  		p1.setEchoChar('*');
  	}
      }
      public static void main(String args[])
      {
	Login s= new Login();
	s.setExtendedState(JFrame.MAXIMIZED_BOTH);
	s.setVisible(true);
	s.setTitle("LOGIN PAGE");
	s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}