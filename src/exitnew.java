import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.Date;
import java.sql.*;

public class exitnew extends JFrame implements ActionListener
{
ImageIcon i;
JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9;
JComboBox c2;
JTextField t3,t4,t5,t6,t7,t8,t9;
JButton b1,b2;
long diff,hrs,mins;
SimpleDateFormat sdf1;
	public exitnew()
	{
		setLayout(new FlowLayout());
		i=new ImageIcon(this.getClass().getResource("z18.jpg"));
		l=new JLabel(i);
		setContentPane(l);

		setLayout(null);
		Font f=new Font("Times New Roman",Font.BOLD,45);

		l1=new JLabel("EXIT PARKING");
		l1.setBounds(500,25,400,50);
		l1.setFont(f);
		l1.setForeground(Color.red);
		add(l1);

		Font f1=new Font("Times New Roman",Font.BOLD,30);

		l2=new JLabel("Vehicle Id:");	
		l2.setBounds(400,100,300,50);
		l2.setFont(f1);
		l2.setForeground(Color.blue);
		add(l2);
		
		c2=new JComboBox();
		c2.setBounds(650,100,300,40);
		c2.setFont(f1);
		getvehicleid();
		add(c2);

		c2.addFocusListener(new FocusAdapter()
			{
			public void focusLost(FocusEvent fe)
			{
				showdetails();
			}
			});	

		l3=new JLabel("Vehicle no.:");
		l3.setBounds(400,150,300,50);
		l3.setFont(f1);
		l3.setForeground(Color.blue);
		add(l3);

		t3=new JTextField(10);
		t3.setBounds(650,150,300,40);
		t3.setFont(f1);
		t3.setBackground(Color.yellow);
		t3.setForeground(Color.red);
		t3.setEditable(false);
		add(t3);

		l4=new JLabel("Type:");
		l4.setBounds(400,200,300,50);
		l4.setFont(f1);
		l4.setForeground(Color.blue);
		add(l4);

		t4=new JTextField(10);
		t4.setBounds(650,200,300,40);
		t4.setFont(f1);
		t4.setBackground(Color.yellow);
		t4.setForeground(Color.red);
		t4.setEditable(false);
		add(t4);

		
		l5=new JLabel("Rate/hr:");
		l5.setBounds(400,250,300,50);
		l5.setFont(f1);
		l5.setForeground(Color.blue);
		add(l5);

		t5=new JTextField(10);
		t5.setBounds(650,250,300,40);
		t5.setFont(f1);
		t5.setEditable(false);
		t5.setBackground(Color.yellow);
		t5.setForeground(Color.red);
		add(t5);

		l6=new JLabel("Entry Time:");
		l6.setBounds(400,300,300,50);
		l6.setFont(f1);
		l6.setForeground(Color.blue);
		add(l6);

		
		t6=new JTextField(15);
		t6.setBounds(650,300,300,40);
		t6.setEditable(false);
		t6.setFont(f1);
		t6.setBackground(Color.yellow);
		t6.setForeground(Color.red);
		add(t6);

		l8=new JLabel("Exit Time:");
		l8.setBounds(400,350,300,50);
		l8.setForeground(Color.blue);
		l8.setFont(f1);
		add(l8);

		Date d = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String s1=sdf.format(d); 

		t8=new JTextField(s1);
		t8.setBounds(650,350,300,40);
		t8.setFont(f1);
		t8.setBackground(Color.yellow);
		t8.setForeground(Color.red);
		add(t8);

		l7=new JLabel("Slot Assigned:");
		l7.setBounds(400,400,300,50);
		l7.setFont(f1);
		l7.setForeground(Color.blue);
		add(l7);

		t7=new JTextField(20);
		t7.setBounds(650,400,300,40);
		t7.setFont(f1);
		t7.setEditable(false);
		t7.setBackground(Color.yellow);
		t7.setForeground(Color.red);
		add(t7);
	
		l9=new JLabel("Total Amount:");
		l9.setBounds(400,450,300,50);
		l9.setFont(f1);
		l9.setForeground(Color.blue);
		add(l9);

		t9=new JTextField(20);
		t9.setBounds(650,450,300,40);
		t9.setFont(f1);
		t9.setEditable(true);
		t9.setBackground(Color.yellow);
		t9.setForeground(Color.red);
		add(t9);	

		b1=new JButton("Exit");
		b1.setBounds(400,600,200,40);
		b1.setFont(f1);
		b1.addActionListener(this);
		b1.setForeground(Color.blue);
		add(b1);

		b2=new JButton("Clear");
		b2.setBounds(650,600,200,40);
		b2.setFont(f1);
		b2.addActionListener(this);
		b2.setForeground(Color.blue);
		add(b2);
	}

	void getvehicleid()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
			Statement stmt=con.createStatement();
			String query="select vehicle_id from vehicletbl where exit_time is NULL";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				c2.addItem(rs.getInt("vehicle_id"));
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("error:"+e);
		}
	}

	void getAmount()
	{
		String s1=t6.getText();
		String s2=t8.getText();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try
		{
			Date d1=sdf.parse(s1);
			Date d2=sdf.parse(s2);
			long diff = d2.getTime() - d1.getTime();
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			long totalhrs = (diffDays*24)+diffHours;
			long amt =totalhrs*(Integer.parseInt(t5.getText()));
			System.out.println("days: "+diffDays);
			System.out.println("hours: "+diffHours);
			System.out.println("total hours: "+totalhrs);
			System.out.println("Amount: "+amt);
			t9.setText(""+amt);
		}
		catch(Exception e)
		{
			System.out.println("Exception caught:"+e);	
		}	
	}

	void showdetails()
	{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
		Statement stmt=con.createStatement();
		String query="select * from vehicletbl where vehicle_id="+c2.getSelectedItem().toString();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
		{
			t3.setText(rs.getString("vehicle_no"));
			t4.setText(rs.getString("type"));
			t5.setText(""+rs.getInt("rate_per_hr"));
			t6.setText(rs.getString("entry_time"));
			t7.setText(""+rs.getInt("slot_no"));
		}
		getAmount();
		con.close();
		
	}
	catch(Exception e)
	 { 
		JOptionPane.showMessageDialog(null,"Exception"+e); 
	}  
	
	}

	public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==b2)
	{
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
		t7.setText("");
		t8.setText("");
		t9.setText("");
	}

	else if(ae.getSource()==b1)
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
		Statement stmt=con.createStatement();
		String query="update vehicletbl set exit_time= ' "+t8.getText()+" ',amount ='"+t9.getText()+"' where vehicle_id="+c2.getSelectedItem().toString();
		int x=stmt.executeUpdate(query);
		con.close();
		}
		catch(Exception e)
       		{
        		 	JOptionPane.showMessageDialog(null,"Exception" +e);
       		}
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
			Statement stmt=con.createStatement();
			String query1="update slottbl1 set status= 'vacant',vehicle_id ='0'where slot_no="+t7.getText();
			int x=stmt.executeUpdate(query1);
			con.close();
		}
		catch(Exception e)
       		{
        		 	JOptionPane.showMessageDialog(null,"Exception" +e);
       		}
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
			Statement stmt=con.createStatement();
			String query2="update slottbl2 set status= 'vacant',vehicle_id ='0',type='' where slot_no="+t7.getText();
			int x=stmt.executeUpdate(query2);
			JOptionPane.showMessageDialog(null,"Exit Successfully! Have a nice day");
			con.close();
		}
		catch(Exception e)
       		{
        		 	JOptionPane.showMessageDialog(null,"Exception" +e);
       		}
	}
	}
	public static void main(String args[])
	{
		exitnew e=new exitnew();
		e.setExtendedState(JFrame.MAXIMIZED_BOTH);
		e.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		e.setVisible(true);
		e.setTitle("VEHICLE EXIT");
	}
}