import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

class user extends JFrame implements ActionListener, Runnable
{
ImageIcon i,i1,ic;
JLabel l,l1,l2,l3;
JButton b1,b2,b3,b5,b6,b7,b8;
JComboBox enter,left;
String img[ ]={"z11.jpg","z12.jpg","z13.jpg","z14.jpg"};
JTextField t1,t2;

public user()
{
	setLayout(new FlowLayout());
	i=new ImageIcon(this.getClass().getResource("a2.jpg"));
	l=new JLabel(i);
	setContentPane(l);

	setLayout(null);
	i1=new ImageIcon(this.getClass().getResource("z10.png"));
	l1=new JLabel(i1);
	l1.setBounds(410,40,950,100);
	add(l1);

	Font f=new Font("Times New Roman",Font.BOLD,30);

	l2=new JLabel("Select Your Choice :");
	l2.setBounds(20,100,350,30);
	l2.setFont(f);
	l2.setForeground(Color.red);
	add(l2);

	enter=new JComboBox();
	enter.setFont(f);
	enter.addItem("Select Type");
	enter.addItem("Pass Holder");
	enter.addItem("New User");
	enter.setBounds(400,300,250,50);
	enter.setVisible(false);
	add(enter);
	t1=new JTextField();
	t1.setBounds(400,300,250,50);
	t1.setVisible(false);
	add(t1);

		
	
	left=new JComboBox();
	left.setFont(f);
	left.addItem("Select Type");
	left.addItem("Pass Holder");
	left.addItem("Daily User");
	left.setBounds(400,400,250,50);
	left.setVisible(false);
	add(left);
	t2=new JTextField();
	t2.setBounds(400,400,250,50);
	t2.setVisible(false);
	add(t2);


	b1=new JButton("Valet Parking");
	b1.setBounds(40,142,265,62);
	b1.setBackground(Color.blue);
	b1.setFont(f);
	b1.setForeground(Color.red);
	b1.addActionListener(this);
	add(b1);

	b2=new JButton("Exit Parking");
	b2.setBounds(40,214,265,62);
	b2.setBackground(Color.blue);
	b2.setFont(f);
	b2.setForeground(Color.red);
	b2.addActionListener(this);
	add(b2);

	b3=new JButton("Renew Pass");
	b3.setBounds(40,286,265,62);
	b3.setBackground(Color.blue);
	b3.setFont(f);
	b3.setForeground(Color.red);
	b3.addActionListener(this);
	add(b3);

	b5=new JButton("View Parking");
	b5.setBounds(40,362,265,62);
	b5.setBackground(Color.blue);
	b5.setFont(f);
	b5.setForeground(Color.red);
	b5.addActionListener(this);
	add(b5);

	b6=new JButton("Rate List");
	b6.setBounds(40,438,265,62);
	b6.setBackground(Color.blue);
	b6.setFont(f);
	b6.setForeground(Color.red);
	b6.addActionListener(this);
	add(b6);

	b7=new JButton("Contact Us");
	b7.setBounds(40,510,265,62);
	b7.setBackground(Color.blue);
	b7.setFont(f);
	b7.setForeground(Color.red);
	b7.addActionListener(this);
	add(b7);

	b8=new JButton("Back");
	b8.setBounds(40,585,265,62);
	b8.setBackground(Color.blue);
	b8.setFont(f);
	b8.setForeground(Color.red);
	b8.addActionListener(this);
	add(b8);

	l3=new JLabel(ic);
	l3.setBounds(600,150,850,600);
	add(l3);
	Thread t=new Thread(this);
	t.start();
}
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==b1)
	{
		
		enter.setVisible(true);
		enter.addFocusListener(new FocusAdapter()
			{
			public void focusLost(FocusEvent fe)
			{
				String s=enter.getSelectedItem().toString();
				if(s.equals("Pass Holder"))
				{
					JOptionPane.showMessageDialog(null,"hello Pass holder");
					passverify n=new passverify();
					n.setExtendedState(JFrame.MAXIMIZED_BOTH);
					n.setVisible(true);
					n.setTitle("VERIFY PASS");
					n.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
				else if(s.equals("New User"))
				{
					JOptionPane.showMessageDialog(null,"Welcome ");
					newentry n=new newentry();
					n.setExtendedState(JFrame.MAXIMIZED_BOTH);
					n.setVisible(true);
					n.setTitle("NEW ENTRY");
					n.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
			});
	}

	else if(ae.getSource()==b2)
	{
		left.setVisible(true);
		left.addFocusListener(new FocusAdapter()
			{
			public void focusLost(FocusEvent fe)
			{		
				String s=left.getSelectedItem().toString();
				if(s.equals("Pass Holder"))
				{
					JOptionPane.showMessageDialog(null,"Thanks for Coming ");
				 
				}
				else if(s.equals("Daily User"))
				{
						exitnew e=new exitnew();
						e.setExtendedState(JFrame.MAXIMIZED_BOTH);
						e.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						e.setVisible(true);
						e.setTitle("VEHICLE EXIT");
				}
			}
			});
	}
	

	else if(ae.getSource()==b3)
	{
		renew r=new renew();
		r.setExtendedState(JFrame.MAXIMIZED_BOTH);
		r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		r.setVisible(true);
		r.setTitle("RENEW PASS");
	}
	
	else if(ae.getSource()==b5)
	{
		ViewParking s= new ViewParking();
		s.setExtendedState(JFrame.MAXIMIZED_BOTH);
		s.setVisible(true);
		s.setTitle("VIEW PARKING");
		s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	else if(ae.getSource()==b6)
	{
		ratelist r=new ratelist();
		r.setExtendedState(JFrame.MAXIMIZED_BOTH);
  		r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  		r.setTitle("Rate List");
  		r.setVisible(true);
	}
   	else if(ae.getSource()==b7)
  	{
		Contact s1= new Contact();
		s1.setExtendedState(JFrame.MAXIMIZED_BOTH);
		s1.setVisible(true);
		s1.setTitle("CONTACT US");
		s1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}
	else if(ae.getSource()==b8)
	{
		Login s= new Login();
		s.setExtendedState(JFrame.MAXIMIZED_BOTH);
		s.setVisible(true);
		s.setTitle("LOGIN PAGE");
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
}
	
	public void run() 
	{
		while(true)
		{
			
			for(int i=0;i<4;i++)
			{
				ic=new ImageIcon(this.getClass().getResource(img[i]));
				l3.setIcon(ic);
				try
				{
				Thread.sleep(2000);
				}
				catch(Exception e)	
				{  }
			}
		}
	}


	public static void main(String args[ ])
	{
		user u= new user();
		u.setExtendedState(JFrame.MAXIMIZED_BOTH);
		u.setVisible(true);
		u.setTitle("WELCOME TO PARKING SYSTEM");
		u.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}