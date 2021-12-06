import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.Date;
import java.util.*;
import java.sql.*;

public class newentry extends JFrame implements ActionListener,ItemListener
{
ImageIcon i;
JLabel l,l1,l2,l3,l4,l5,l6,l7;
JTextField t2,t3,t5,t6,t7;
JComboBox c4;
JButton b1,b2,b3;
String sl;
int dbs_no=0;
	public newentry()
	{
		setLayout(new FlowLayout());
		i=new ImageIcon(this.getClass().getResource("z18.jpg"));
		l=new JLabel(i);
		setContentPane(l);

		setLayout(null);
		Font f=new Font("Times New Roman",Font.BOLD,45);

		l1=new JLabel("NEW ENTRY");
		l1.setBounds(500,35,400,50);
		l1.setFont(f);
		l1.setForeground(Color.red);
		add(l1);

		Font f1=new Font("Times New Roman",Font.BOLD,35);

		l2=new JLabel("Vehicle Id:");	
		l2.setBounds(400,150,300,50);
		l2.setFont(f1);
		l2.setForeground(Color.blue);
		add(l2);
		
		t2=new JTextField(10);
		t2.setBounds(650,150,400,40);
		t2.setFont(f1);
		t2.setBackground(Color.yellow);
		t2.setForeground(Color.red);
		add(t2);

		l3=new JLabel("Vehicle no.:");
		l3.setBounds(400,200,300,50);
		l3.setFont(f1);
		l3.setForeground(Color.blue);
		add(l3);

		t3=new JTextField(10);
		t3.setBounds(650,200,400,40);
		t3.setFont(f1);
		t3.setBackground(Color.yellow);
		t3.setForeground(Color.red);
		add(t3);

		l4=new JLabel("Type:");
		l4.setBounds(400,250,300,50);
		l4.setFont(f1);
		l4.setForeground(Color.blue);
		add(l4);

		String s[ ]={"-select type-","car","scooter_motorcycle","bicycle"};
		c4=new JComboBox(s);
		c4.setBounds(650,250,400,40);
		c4.setFont(f1);
		c4.addItemListener(this);
		add(c4);

		l5=new JLabel("Rate/hr:");
		l5.setBounds(400,300,300,50);
		l5.setFont(f1);
		l5.setForeground(Color.blue);
		add(l5);
		
		t5=new JTextField(10);
		t5.setBounds(650,300,400,40);
		t5.setFont(f1);
		t5.setEditable(false);
		t5.setBackground(Color.yellow);
		t5.setForeground(Color.red);
		add(t5);

		l6=new JLabel("Entry Time:");
		l6.setBounds(400,350,300,50);
		l6.setFont(f1);
		l6.setForeground(Color.blue);
		add(l6);

		Date d = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String s1=sdf.format(d); 

		t6=new JTextField(s1);
		t6.setBounds(650,350,400,40);
		t6.setEditable(false);
		t6.setFont(f1);
		t6.setBackground(Color.yellow);
		t6.setForeground(Color.red);
		add(t6);
		

		l7=new JLabel("Slot Assigned:");
		l7.setBounds(400,400,300,50);
		l7.setFont(f1);
		l7.setForeground(Color.blue);
		add(l7);

		t7=new JTextField(20);
		t7.setBounds(650,400,400,40);
		t7.setFont(f1);
		t7.setEditable(false);
		t7.setBackground(Color.yellow);
		t7.setForeground(Color.red);
		add(t7);

		b1=new JButton("Insert");
		b1.setBounds(500,600,200,50);
		b1.addActionListener(this);
		b1.setFont(f1);
		b1.setForeground(Color.blue);
		add(b1);

		b2=new JButton("Clear");
		b2.setBounds(750,600,200,50);
		b2.setFont(f1);
		b2.addActionListener(this);
		b2.setForeground(Color.blue);
		add(b2);

		b3=new JButton("View slot");
		b3.setBounds(1000,600,200,50);
		b3.setFont(f1);
		b3.addActionListener(this);
		b3.setForeground(Color.blue);
		add(b3);

		getvehicleid();

	}
	
	void getvehicleid()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
			Statement stmt=con.createStatement();
			String query="select vehicle_id from vehicletbl";
			ResultSet rs=stmt.executeQuery(query);
			int id=0;
			while(rs.next())
			{
				id=rs.getInt("vehicle_id");
			}
			if(id==0)
			{
				t2.setText("1001");
			}
			else
			{
				id=id+1;
				t2.setText(""+id);
			}
			con.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Exception" +e);
		}
	}

	public void itemStateChanged(ItemEvent ie)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
			Statement stmt=con.createStatement();
			String query1="select * from setrate";
			ResultSet rs=stmt.executeQuery(query1);
			rs.next();
			if(c4.getSelectedItem().toString().equals("car"))
			{
				t5.setText(""+rs.getInt(1));
				getslotno();
			}
			else if(c4.getSelectedItem().toString().equals("scooter_motorcycle"))
			{
				t5.setText(""+rs.getInt(2));
				getslotno2();

			}
			else if(c4.getSelectedItem().toString().equals("bicycle"))
			{
				t5.setText(""+rs.getInt(3));
				getslotno2();

			}
			else
			{
				t5.setText("");
			}
			con.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Exception" +e);
		}

	}

	void getslotno()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
		Statement stmt=con.createStatement();
		String query2="select * from slottbl1";
		ResultSet rs=stmt.executeQuery(query2);
		int sno=0,found=0;
		String sstatus="";
		while(rs.next())
		{
			sno=rs.getInt("slot_no");
			sstatus=rs.getString("status");
			if(sstatus.equals("vacant"))
			{
				found=1;
				break;
			}
		}
		if(found==0)
		{
			JOptionPane.showMessageDialog(null,"Parking Full");
		}
		else
		{
			t7.setText(""+sno);
			dbs_no=sno;
		}
		con.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Exception" +e);
		}
	}

	void getslotno2()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
		Statement stmt=con.createStatement();
		String query3="select * from slottbl2";
		ResultSet rs=stmt.executeQuery(query3);
		int sno=0,found=0;
		String sstatus="";
		while(rs.next())
		{
			sno=rs.getInt("slot_no");
			sstatus=rs.getString("status");
			if(sstatus.equals("vacant"))
			{	
				found=1;
				break;
			}
		}
		if(found==0)
		{
			JOptionPane.showMessageDialog(null,"Parking Full");
		}
		else
		{
			t7.setText(""+sno);
			dbs_no=sno;
		}
		con.close();
		}
		catch(Exception e)
		{
		JOptionPane.showMessageDialog(null,"Exception" +e);
		}
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String s3=t3.getText();
			String s4=c4.getSelectedItem().toString();
			String s5=t5.getText();
			String s7=t7.getText();
			int flag=0;
			if(s3.equals("") || s4.equals("-select type-") || s5.equals("")||s7.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Fill all details");
				flag=1;
			}
			else if(flag==0)
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
					Statement stmt=con.createStatement();
					if(c4.getSelectedItem().toString().equals("car"))
					{
						int chk=0;
						String query4="select vehicle_id from slottbl1";
						ResultSet r=stmt.executeQuery(query4);
						while(r.next())
						{
							if(t2.getText().equals(""+r.getInt("vehicle_id")))
							{
								chk=1;
								JOptionPane.showMessageDialog(null,"Vehicle id already exist,please Clear first!");
								break;
							}
						}
						if(chk==0)
						{
							String query5="insert into vehicletbl(vehicle_id,vehicle_no,type,rate_per_hr,entry_time,slot_no) values (' "+t2.getText()+" ',' "+t3.getText()+" ',' "+c4.getSelectedItem()+" ',' "+t5.getText()+" ',' "+t6.getText()+" ',' "+t7.getText()+" ')";
							int x=stmt.executeUpdate(query5);
							String query6="update slottbl1 set status='occupied',vehicle_id='"+t2.getText()+"' where slot_no="+dbs_no;
							int y=stmt.executeUpdate(query6);
							JOptionPane.showMessageDialog(null,"Data Updated");
						}
					}
					else if(c4.getSelectedItem().toString().equals("scooter_motorcycle") || c4.getSelectedItem().toString().equals("bicycle"))
					{
						int chk=0;
						String query7="select vehicle_id from slottbl2";
						ResultSet r=stmt.executeQuery(query7);
						while(r.next())
						{
							if(t2.getText().equals(""+r.getInt("vehicle_id")))
							{
								chk=1;
								JOptionPane.showMessageDialog(null,"Vehicle id already exist,please Clear first!");
								break;
							}
						}
						if(chk==0)
						{
							String query8="Insert into vehicletbl(vehicle_id,vehicle_no,type,rate_per_hr,entry_time,slot_no) values (' "+t2.getText()+" ',' "+t3.getText()+" ',' "+c4.getSelectedItem()+" ',' "+t5.getText()+" ',' "+t6.getText()+" ',' "+t7.getText()+" ')";
							int x=stmt.executeUpdate(query8);
							String query9="update slottbl2 set status='occupied',type='"+c4.getSelectedItem()+"',vehicle_id='"+t2.getText()+"' where slot_no="+dbs_no;
							int y=stmt.executeUpdate(query9);
							JOptionPane.showMessageDialog(null,"Data Updated");
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(null,"Select vehicle type");
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
			t2.setText("");
			t3.setText("");
			c4.setSelectedItem("Select type");
			t5.setText("");
			t7.setText("");
			
		}
		else if(ae.getSource()==b3)
		{
			
			viewslot s= new viewslot(t7.getText());
			s.setExtendedState(JFrame.MAXIMIZED_BOTH);
			s.setVisible(true);
			s.setTitle("VIEW SLOT");
			s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}

	public static void main(String args[])
	{
		newentry n=new newentry();
		n.setExtendedState(JFrame.MAXIMIZED_BOTH);
		n.setVisible(true);
		n.setTitle("NEW ENTRY");
		n.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}