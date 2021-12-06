import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.text.*;
import java.util.Date;
import java.util.*;

public class renew extends JFrame implements ActionListener
{
ImageIcon i;
JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
JTextField t3,t4,t5,t6,t7,t8;
JComboBox c2;
JButton b1,b2;
	public renew()
	{
		setLayout(new FlowLayout());
		i=new ImageIcon(this.getClass().getResource("z24.jpg"));
		l=new JLabel(i);
		setContentPane(l);

		setLayout( null);
		Font f=new Font("Times New Roman",Font.BOLD,65);
		l1=new JLabel("Pass Renew");
		l1.setBounds(555,35,500,50);
		l1.setFont(f);
		l1.setForeground(Color.red);
		add(l1);

		Font f1=new Font("Times New Roman",Font.BOLD,35);
		l2=new JLabel("Pass Id:");	
		l2.setBounds(400,200,300,50);
		l2.setFont(f1);
		l2.setForeground(Color.yellow);
		add(l2);
		
		c2=new JComboBox();
		c2.setBounds(650,200,400,40);
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
		l3.setBounds(400,250,300,50);
		l3.setFont(f1);
		l3.setForeground(Color.yellow);
		add(l3);

		t3=new JTextField(10);
		t3.setBounds(650,250,400,40);
		t3.setFont(f1);
		t3.setBackground(Color.yellow);
		t3.setForeground(Color.red);
		t3.setEditable(false);
		add(t3);

		l4=new JLabel("Type:");
		l4.setBounds(400,300,300,50);
		l4.setFont(f1);
		l4.setForeground(Color.yellow);
		add(l4);

		t4=new JTextField(20);
		t4.setBounds(650,300,400,40);
		t4.setFont(f1);
		t4.setBackground(Color.yellow);
		t4.setForeground(Color.red);
		t4.setEditable(false);
		add(t4);

		l5=new JLabel("Valid From:");
		l5.setBounds(400,350,300,50);
		l5.setFont(f1);
		l5.setForeground(Color.yellow);
		add(l5);
		
		Date d = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String s1=sdf.format(d); 

		t5=new JTextField(s1);
		t5.setBounds(650,350,400,40);
		t5.setFont(f1);
		t5.setBackground(Color.yellow);
		t5.setForeground(Color.red);
		t5.setEditable(false);
		add(t5);

		l6=new JLabel("Valid Upto");
		l6.setBounds(400,400,300,50);
		l6.setFont(f1);
		l6.setForeground(Color.yellow);
		add(l6);

		t6=new JTextField(10);
		t6.setBounds(650,400,400,40);
		t6.setEditable(true);
		t6.setFont(f1);
		t6.setBackground(Color.yellow);
		t6.setForeground(Color.red);
		add(t6);

		l7=new JLabel("Amount Paid:");
		l7.setBounds(400,450,300,50);
		l7.setForeground(Color.yellow);
		l7.setFont(f1);
		add(l7);
		
		t7=new JTextField(10);
		t7.setBounds(650,450,400,40);
		t7.setEditable(true);
		t7.setBackground(Color.yellow);
		t7.setForeground(Color.red);
		t7.setFont(f1);
		add(t7);

		l8=new JLabel("Slot Assigned:");
		l8.setBounds(400,500,300,50);
		l8.setFont(f1);
		l8.setForeground(Color.yellow);
		add(l8);

		t8=new JTextField(20);
		t8.setBounds(650,500,400,40);
		t8.setFont(f1);
		t8.setBackground(Color.yellow);
		t8.setForeground(Color.red);
		t8.setEditable(false);
		add(t8);

		b1=new JButton("Renew");
		b1.setBounds(500,600,200,50);
		b1.addActionListener(this);
		b1.setFont(f1);
		b1.setForeground(Color.blue);
		add(b1);

		b2=new JButton("Back");
		b2.setBounds(750,600,200,50);
		b2.setFont(f1);
		b2.addActionListener(this);
		b2.setForeground(Color.blue);
		add(b2);
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
				t8.setText(""+rs.getInt("amount"));
				t7.setText(""+rs.getInt("slot_assigned"));
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
			admin s= new admin();
			s.setExtendedState(JFrame.MAXIMIZED_BOTH);
			s.setVisible(true);
			s.setTitle("ADMIN PANNEL");
			s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		}
		else if(ae.getSource()==b1)
		{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
			Statement stmt=con.createStatement();
			String query1="update createpass set valid_from='"+t5.getText()+"',valid_upto='"+t6.getText()+"' where pass_id="+c2.getSelectedItem().toString();
			int y=stmt.executeUpdate(query1);
			JOptionPane.showMessageDialog(null,"Data Updated");
		}
		catch(Exception e)
		{
			System.out.println("Error:"+e);
		}
		}
	}

	public static void main(String args[])
	{
		renew r=new renew();
		r.setExtendedState(JFrame.MAXIMIZED_BOTH);
		r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		r.setVisible(true);
		r.setTitle("RENEW PASS");
	}
         }