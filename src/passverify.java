import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.Date;
import java.sql.*;
import java.util.concurrent.TimeUnit;

public class passverify extends JFrame implements ActionListener
{
ImageIcon i;
JTextField t3,t4,t5,t6,t7,t8,td;
JComboBox c2;
JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
JButton b1,b2,b3;
int dbs_no=0;
SimpleDateFormat sdf1;
long diff,hrs,mins;
	public passverify()
	{
		setLayout(new FlowLayout());
		i=new ImageIcon(this.getClass().getResource("z18.jpg"));
		l=new JLabel(i);
		setContentPane(l);

		Font f=new Font("Times New Roman",Font.BOLD,40);
		l1=new JLabel("PASS VERIFICATION");
		l1.setBounds(500,35,800,50);
		l1.setFont(f);
		l1.setForeground(Color.red);
		add(l1);
 		
		Font f1=new Font("Times New Roman",Font.BOLD,30);
		
		l2=new JLabel("Pass Id:");	
		l2.setBounds(400,150,300,50);
		l2.setFont(f1);
		l2.setForeground(Color.blue);
		add(l2);
		
		c2=new JComboBox();
		c2.setBounds(650,150,300,40);
		c2.setFont(f1);
		getpassid();
		add(c2);

		c2.addFocusListener(new FocusAdapter()
			{
			public void focusLost(FocusEvent fe)
			{
				showdetails();
			}
			});	

		l3=new JLabel("Vehicle no.:");
		l3.setBounds(400,200,300,50);
		l3.setFont(f1);
		l3.setForeground(Color.blue);
		add(l3);

		t3=new JTextField(10);
		t3.setBounds(650,200,300,40);
		t3.setFont(f1);
		t3.setBackground(Color.yellow);
		t3.setForeground(Color.red);
		t3.setEditable(false);
		add(t3);

		l4=new JLabel("Type:");
		l4.setBounds(400,250,300,50);
		l4.setFont(f1);
		l4.setForeground(Color.blue);
		add(l4);

		t4=new JTextField(20);
		t4.setBounds(650,250,300,40);
		t4.setFont(f1);
		t4.setBackground(Color.yellow);
		t4.setForeground(Color.red);
		t4.setEditable(false);
		add(t4);

		l5=new JLabel("Valid From:");
		l5.setBounds(400,300,300,50);
		l5.setFont(f1);
		l5.setForeground(Color.blue);
		add(l5);
		
		t5=new JTextField(20);
		t5.setBounds(650,300,300,40);
		t5.setFont(f1);
		t5.setBackground(Color.yellow);
		t5.setForeground(Color.red);
		t5.setEditable(false);
		add(t5);

		l6=new JLabel("Valid Upto");
		l6.setBounds(400,350,300,50);
		l6.setFont(f1);
		l6.setForeground(Color.blue);
		add(l6);

		t6=new JTextField(10);
		t6.setBounds(650,350,300,40);
		t6.setEditable(false);
		t6.setFont(f1);
		t6.setBackground(Color.yellow);
		t6.setForeground(Color.red);
		add(t6);

		l7=new JLabel("Amount Paid:");
		l7.setBounds(400,400,300,50);
		l7.setForeground(Color.blue);
		l7.setFont(f1);
		add(l7);
		
		t7=new JTextField(10);
		t7.setBounds(650,400,300,40);
		t7.setEditable(false);
		t7.setFont(f1);
		t7.setBackground(Color.yellow);
		t7.setForeground(Color.red);
		add(t7);

		l8=new JLabel("Slot Assigned:");
		l8.setBounds(400,450,300,50);
		l8.setFont(f1);
		l8.setForeground(Color.blue);
		add(l8);

		t8=new JTextField(20);
		t8.setBounds(650,450,300,40);
		t8.setFont(f1);
		t8.setEditable(false);
		t8.setBackground(Color.yellow);
		t8.setForeground(Color.red);
		add(t8);

		b1=new JButton("Verify");
		b1.setBounds(500,600,200,50);
		b1.addActionListener(this);
		b1.setFont(f1);
		b1.setForeground(Color.blue);
		add(b1);

		b2=new JButton("Back");
		b2.setBounds(750,600,200,50);
		b2.setFont(f1);
		b2.setForeground(Color.blue);
		b2.addActionListener(this);
		add(b2);
		
		b3=new JButton("View Slot");
		b3.setBounds(1000,600,200,50);
		b3.setFont(f1);
		b3.setForeground(Color.blue);
		b3.addActionListener(this);
		add(b3);
		

		Date d =new Date();
		sdf1=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dt1=sdf1.format(d); 
		td=new JTextField(dt1);


	}

	void getpassid()
	{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
		Statement stmt=con.createStatement();
		String query="select pass_id from createpass";
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
		{
			c2.addItem(rs.getInt("pass_id"));
		}
		con.close();
	}
	catch(Exception e)
	{
		System.out.println("error:"+e);
	}
	}

	void showdetails()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
			Statement stmt=con.createStatement();
			String query="select * from createpass where pass_id="+c2.getSelectedItem().toString();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				t3.setText(rs.getString("vehicle_no"));
				t4.setText(rs.getString("type"));
				t5.setText(rs.getString("valid_from"));
				t6.setText(rs.getString("valid_upto"));
				t7.setText(""+rs.getInt("amount"));
				t8.setText(""+rs.getInt("slot_assigned"));
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("error:"+e);
		}
		b1.requestFocus();
	}



	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b2)
		{
			user u= new user();
			u.setExtendedState(JFrame.MAXIMIZED_BOTH);
			u.setVisible(true);
			u.setTitle("WELCOME TO PARKING SYSTEM");
			u.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}

		else if(ae.getSource()==b1)
		{
			try
			{
				Date d =new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Date passdt=sdf.parse(t6.getText());
				Date curdt=sdf.parse(sdf.format(d));
				if(curdt.compareTo(passdt)<0)
				{
					JOptionPane.showMessageDialog(null,"Pass Valid");
				}
					
				else if(curdt.compareTo(passdt)>0)
				{
					int ans=JOptionPane.showConfirmDialog(null,"Your Pass has been expired. If you want to Renew Pass then click YES else NO");
					if(ans== JOptionPane.YES_OPTION)
					{
						renew r=new renew();
						r.setExtendedState(JFrame.MAXIMIZED_BOTH);
						r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						r.setVisible(true);
						r.setTitle("RENEW PASS");
	
					}
					else if(ans== JOptionPane.NO_OPTION)
					{
						try
						{	
							Date olddate=sdf1.parse(t6.getText());
							Date newdate=sdf1.parse(td.getText());
							diff=newdate.getTime()-olddate.getTime();
							Long g=TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
							Long p= 200*g;
							JOptionPane.showMessageDialog(null,"Amount to be pay: "+p);
							update();
		
						}
	
						catch(Exception e)
						{  System.out.println("error:"+e); }
	
					}
				}
				
					
			}
			catch(Exception e)
			{
				System.out.println("Error:"+e);
			}
		}

		else if(ae.getSource()==b3)
		{
			viewslot s= new viewslot(t8.getText());
			s.setExtendedState(JFrame.MAXIMIZED_BOTH);
			s.setVisible(true);
			s.setTitle("VIEW SLOT");
			s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		}

	}

	void update()
	{
	String id=c2.getSelectedItem().toString();
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
		Statement stmt=con.createStatement();
		String query="delete from createpass where pass_id="+c2.getSelectedItem().toString();
		int x=stmt.executeUpdate(query);

		String q="select pass_id from passslottbl1";
		ResultSet rs=stmt.executeQuery(q);
		while(rs.next())
		{
			if(rs.getInt("pass_id")==(Integer.parseInt(id)))
			{
				String qu="update passslottbl1 set status='vacant', pass_id=null";
				int x1=stmt.executeUpdate(qu);
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
				c2.removeAllItems();
				getpassid();
				JOptionPane.showMessageDialog(null,"Done! Have a nice day");
				dispose();
			}
		}
		String q1="select pass_id from passslottbl2";
		ResultSet rs1=stmt.executeQuery(q1);
		JOptionPane.showMessageDialog(null,"Pass deleted");
		while(rs1.next())
		{
			if(rs1.getInt("pass_id")==(Integer.parseInt(id)))
			{
				String qu1="update passslottbl2 set status='vacant', pass_id=null,type=null";
				int x2=stmt.executeUpdate(qu1);
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
				c2.removeAllItems();
				getpassid();
				JOptionPane.showMessageDialog(null,"Done! Have a nice day");
				dispose();
			}
		}
	      
	       }
	      catch(Exception e)
	     {
		System.out.println("error:"+e);
	     }
	
	}
	public static void main(String args[])
	{
		passverify n=new passverify();
		n.setExtendedState(JFrame.MAXIMIZED_BOTH);
		n.setVisible(true);
		n.setTitle("VERIFY PASS");
		n.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}