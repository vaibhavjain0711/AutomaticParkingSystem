import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class admin extends JFrame implements ActionListener,ItemListener
{
JLabel l,l1,l2,l3,l4,l5;
ImageIcon i;
JTextField t1;
JPasswordField p1,p2;
int flag=0;
JButton create,clear,b1,b2,b3,b4,b5,b6;
JCheckBox ch1,ch2;

public admin()
{
	setLayout(new BorderLayout());
	i=new ImageIcon(this.getClass().getResource("z01.jpg"));
	l=new JLabel(i);
	setContentPane(l);
	
	setLayout(null);
	Font f=new Font("Times New Roman",Font.BOLD,60);
	l1=new JLabel("Welcome Admin");
	l1.setFont(f);
	l1.setBounds(200,200,500,60);
	l1.setForeground(Color.yellow);
	add(l1);

	l2=new JLabel("Create User");
	Font f1=new Font("Times New Roman",Font.BOLD,40);
	l2.setBounds(950,100,400,100);
	l2.setFont(f1);
	l2.setForeground(Color.red);
	add(l2);

	Font f2= new Font("Times New Roman",Font.BOLD,30);
	l3=new JLabel("Username:");
	l3.setBounds(780,200,400,40);
	l3.setFont(f2);
	l3.setBackground(Color.yellow);
	l3.setForeground(Color.green);
 	add(l3);
 
	t1=new JTextField(10);
	t1.setBounds(1030,210,180,30);
	t1.setFont(f2);
	t1.setBackground(Color.yellow);
	t1.setForeground(Color.red);
	add(t1);

	l4=new JLabel("Password:");
	l4.setBounds(780,260,400,40);
	l4.setFont(f2);
	l4.setBackground(Color.yellow);
	l4.setForeground(Color.green);
	add(l4);
	
	p1=new JPasswordField(10);
	p1.setEchoChar('*');
	p1.setBounds(1030,270,180,30);
	p1.setFont(f2);
	p1.setBackground(Color.yellow);
	p1.setForeground(Color.red);
	add(p1);
	
	ch1=new JCheckBox("SHOW PASSWORD");
  	ch1.setBounds(1230,270,300,40);
  	ch1.setFont(f2);
  	ch1.addItemListener(this);
	ch1.setForeground(Color.red);
	ch1.setBackground(Color.yellow);
 	add(ch1);

	l5=new JLabel("Retype Password:");
	l5.setBounds(780,330,400,40);
	l5.setFont(f2);
	l5.setBackground(Color.yellow);
	l5.setForeground(Color.green);
	add(l5);

	p2=new JPasswordField(10);
	p2.setEchoChar('*');
	p2.setBounds(1030,340,180,30);
	p2.setFont(f2);
	p2.setBackground(Color.yellow);
	p2.setForeground(Color.red);
	add(p2);

	ch2=new JCheckBox("SHOW PASSWORD");
  	ch2.setBounds(1230,340,300,30);
  	ch2.setFont(f2);
  	ch2.addItemListener(this);
	ch2.setForeground(Color.red);
	ch2.setBackground(Color.yellow);
 	add(ch2);

	Font f3= new Font("Times New Roman",Font.BOLD,30);

	create=new JButton("Create");
	create.setBounds(850,400,150,40);
	create.addActionListener(this);
	//create.setContentAreaFilled(false);
	create.setForeground(Color.blue);
	create.setFont(f3);
	add(create);

	clear=new JButton("Clear");
	clear.setBounds(1050,400,150,40);
	clear.addActionListener(this);
	//clear.setContentAreaFilled(false);
	clear.setForeground(Color.blue);
	clear.setFont(f3);
	add(clear);

	b1=new JButton("User Screen");
	b1.setBounds(10,10,200,40);
 	b1.addActionListener(this);
	//b1.setContentAreaFilled(false);
	b1.setForeground(Color.blue);
	b1.setFont(f3);
  	add(b1);

	b2=new JButton("View Parking");
	b2.setBounds(230,10,220,40);
	b2.addActionListener(this);
	//b2.setContentAreaFilled(false);
	b2.setForeground(Color.blue);
	b2.setFont(f3);
	add(b2);

	b3=new JButton("Set Rate");
	b3.setBounds(470,10,200,40);
	b3.addActionListener(this);
	//b3.setContentAreaFilled(false);
	b3.setForeground(Color.blue);
	b3.setFont(f3);
	add(b3);

	b4=new JButton("Renew Pass");
	b4.setBounds(690,10,200,40);
	b4.addActionListener(this);
	//b4.setContentAreaFilled(false);
	b4.setForeground(Color.blue);
	b4.setFont(f3);
	add(b4);

	b5=new JButton("Create Pass");
	b5.setBounds(910,10,200,40);
	b5.addActionListener(this);
	//b5.setContentAreaFilled(false);
	b5.setForeground(Color.blue);
	b5.setFont(f3);
	add(b5);

	b6=new JButton("Logout");
	b6.setBounds(1130,10,200,40);
	b6.addActionListener(this);
	//b6.setContentAreaFilled(false);
	b6.setForeground(Color.blue);
	b6.setFont(f3);
	add(b6);
}

public void actionPerformed(ActionEvent ae)
{
	 if(ae.getSource()==create)
	{
		String u=t1.getText();
		String p=p1.getText();
		String c=p2.getText();
		if(u.equals("") && p.equals(""))
		{
			flag=1;
			JOptionPane.showMessageDialog(null,"enter username and password");
		}	
		else if(c.equals(""))
		{
			flag=1;
			JOptionPane.showMessageDialog(null,"retype your password");
		}
		else 
    		{ 
			try
   			 {

				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
      				Statement stmt=con.createStatement();	
				String query="select * from userlogin where username =' "+t1.getText()+" ' ";
				ResultSet rs=stmt.executeQuery(query);
				int ctr=0;
				while(rs.next())
				{
				ctr=ctr+1;
				}
				if(ctr==0)
				{
      				String query1 ="insert into userlogin(username,password)values('"+t1.getText()+"','"+p1.getText()+"')";
      				int x=stmt.executeUpdate(query1);
      				JOptionPane.showMessageDialog(null,"USER CREATED SUCCESSFULLY");
				}
				else
				{
				JOptionPane.showMessageDialog(null,"USER ALREADY EXIST");
      				}
      				con.close();
    			}
   			 catch(Exception e)
    			{
     				JOptionPane.showMessageDialog(null,"Exception" +e);
    			}
   		} 
	}
 	else if(ae.getSource()==clear)
	{
		t1.setText("");
		p1.setText("");
		p2.setText("");
			
	}
	else if(ae.getSource()==b1)
	{
	 	user u= new user();
		u.setExtendedState(JFrame.MAXIMIZED_BOTH);
		u.setVisible(true);
		u.setTitle("WELCOME TO PARKING SYSTEM");
		u.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}
	
	else if(ae.getSource()==b2)
	{
		ViewParking s= new ViewParking();
		s.setExtendedState(JFrame.MAXIMIZED_BOTH);
		s.setVisible(true);
		s.setTitle("VIEW PARKING");
		s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	else if(ae.getSource()==b3)
	{
		setrate s=new setrate();
		s.setExtendedState(JFrame.MAXIMIZED_BOTH);
		s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		s.setVisible(true);
		s.setTitle("SET RATE");		
	}
	else if(ae.getSource()==b4)
	{
		renew r=new renew();
		r.setExtendedState(JFrame.MAXIMIZED_BOTH);
		r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		r.setVisible(true);
		r.setTitle("RENEW PASS");	
	}
	else if(ae.getSource()==b5)
	{
		pass p=new pass();
		p.setExtendedState(JFrame.MAXIMIZED_BOTH);
		p.setVisible(true);
		p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		p.setTitle("CREATE PASS");
		
	}
	else if(ae.getSource()==b6)
	{
	  	Login s= new Login();
	  	s.setExtendedState(JFrame.MAXIMIZED_BOTH);
	  	s.setVisible(true);
	  	s.setTitle("LOGIN PAGE");
	 	s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
}

public void itemStateChanged(ItemEvent ie)
     {
  	boolean b1,b2;
  	b1=ch1.isSelected();
	{
		if(b1==true)
 		{ 
    			p1.setEchoChar((char)0);
  		}	
  		else if(b1==false)
  		{
  			p1.setEchoChar('*');
  		}
	}
	b2=ch2.isSelected();
	{	
		if(b2==true)
 		{ 
    			p2.setEchoChar((char)0);
  		}	
  		else if(b2==false)
  		{
  			p2.setEchoChar('*');
  		}
	}
      }

public static void main(String args[])
{
	admin s= new admin();
	s.setExtendedState(JFrame.MAXIMIZED_BOTH);
	s.setVisible(true);
	s.setTitle("ADMIN PAaNEL");
	s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
}
