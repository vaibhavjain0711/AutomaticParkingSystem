import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.text.*;
import java.util.*;

public class pass extends JFrame implements ItemListener,ActionListener
{
ImageIcon i1;
JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
JTextField t1,t2,t3,t5,t6,t7,t8;
JComboBox c4;
JButton b1,b2;
int dbs_no=0;


	public pass()
	{	
		setLayout(new FlowLayout());
		i1=new ImageIcon(this.getClass().getResource("z18.jpg"));
	 	l1=new JLabel(i1);
		setContentPane(l1);

		Font f=new Font("Times New Roman",Font.BOLD,40);
                  	Font f1=new Font("Times New Roman",Font.BOLD,30);
		
		l=new JLabel("PASS CREATION SCREEN");
		l.setBounds(500,35,700,50);
		l.setFont(f);
		l.setForeground(Color.red);
		add(l);


		l2=new JLabel("Pass Id:");	
		l2.setBounds(400,150,300,50);
		l2.setFont(f1);
		l2.setForeground(Color.blue);
		add(l2);
		
		t2=new JTextField(10);
		t2.setBounds(650,150,300,40);
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
		t3.setBounds(650,200,300,40);
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
		c4.setBounds(650,250,300,40);
		c4.setFont(f1);
		c4.addItemListener(this);
		add(c4);

		l5=new JLabel("Valid From:");
		l5.setBounds(400,300,300,50);
		l5.setFont(f1);
		l5.setForeground(Color.blue);
		add(l5);
		
		Date d = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String s1=sdf.format(d); 
		t5=new JTextField(s1);
		t5.setBounds(650,300,300,40);
		t5.setFont(f1);
		t5.setEditable(false);
		t5.setBackground(Color.yellow);
		t5.setForeground(Color.red);
		add(t5);

		l6=new JLabel("Valid Upto");
		l6.setBounds(400,350,300,50);
		l6.setFont(f1);
		l6.setForeground(Color.blue);
		add(l6);

		t6=new JTextField(10);
		t6.setBounds(650,350,300,40);
		t6.setFont(f1);
		t6.setBackground(Color.yellow);
		t6.setForeground(Color.red);
		add(t6);

		l7=new JLabel("Total amount:");
		l7.setBounds(400,400,300,50);
		l7.setForeground(Color.blue);
		l7.setFont(f1);
		add(l7);
		
		t7=new JTextField(10);
		t7.setBounds(650,400,300,40);
		t7.setFont(f1);
		t7.setEditable(false);
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
		t8.setBackground(Color.yellow);
		t8.setForeground(Color.red);
		add(t8);

		b1=new JButton("Create Pass");
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

		getpassid();

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
			int id=0;
			while(rs.next())
			{
				id=rs.getInt("pass_id");
			}
			if(id==0)
			{
				t2.setText("101");
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
			String query="select * from setrate";
			ResultSet rs=stmt.executeQuery(query);
			rs.next();
			if(c4.getSelectedItem().toString().equals("car"))
			{
				int amount=3000;
				t7.setText(""+amount);
				getslotno();
			}
			else if(c4.getSelectedItem().toString().equals("scooter_motorcycle"))
			{
				int amount=2000;
				t7.setText(""+amount);
				getslotno2();	
			}
			else if(c4.getSelectedItem().toString().equals("bicycle"))
			{
				int amount=1000;
				t7.setText(""+amount);
				getslotno2();
			}
			else
			{
				t7.setText("");
			}
		
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
		String query1="select * from passslottbl1";
		ResultSet rs=stmt.executeQuery(query1);
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
			t8.setText(""+sno);
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
		String query2="select * from passslottbl2";
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
			t8.setText(""+sno);
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
	 if(ae.getSource()==b2)
	{
		t2.setText("");
		t3.setText("");
		c4.setSelectedItem("-Select type-");
		t5.setText("");
		t6.setText("");
		t7.setText("");
		t8.setText("");
	}

	else if(ae.getSource()==b1)
		{
			String s2=t2.getText();
			String s3=t3.getText();
			String s4=c4.getSelectedItem().toString();
			String s5=t5.getText();
			String s6=t6.getText();
			String s7=t7.getText();
			String s8=t8.getText();
			int flag=0;
			if(s2.equals("") || s3.equals("") || s4.equals("-Select type-") || s5.equals("") || s6.equals("") || s7.equals("") || s8.equals(""))
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
						String query3="select pass_id from passslottbl1";
						ResultSet r=stmt.executeQuery(query3);
						while(r.next())
						{
							if(t2.getText().equals(""+r.getInt("pass_id")))
							{
								chk=1;
								JOptionPane.showMessageDialog(null,"pass id already exist,please Clear first!");
								break;
							}
						}
						if(chk==0)
						{
							String query4="insert into createpass(pass_id,vehicle_no,type,valid_from,valid_upto,amount,slot_assigned) values ('"+t2.getText()+"','"+t3.getText()+"','"+c4.getSelectedItem().toString()+"','"+t5.getText()+"','"+t6.getText()+"','"+t7.getText()+"','"+t8.getText()+"')";
							int x=stmt.executeUpdate(query4);
							String query5="update passslottbl1 set status='occupied',pass_id='"+t2.getText()+"' where slot_no="+dbs_no;
							int y=stmt.executeUpdate(query5);
							JOptionPane.showMessageDialog(null,"Data Updated");
						}
					}
					else if(c4.getSelectedItem().toString().equals("scooter_motorcycle") || c4.getSelectedItem().toString().equals("bicycle"))
					{
						int chk=0;
						String query6="select pass_id from passslottbl2";
						ResultSet r=stmt.executeQuery(query6);
						while(r.next())
						{
							if(t2.getText().equals(""+r.getInt("pass_id")))
							{
								chk=1;
								JOptionPane.showMessageDialog(null,"pass id already exist,please Clear first!");
								break;
							}
						}
						if(chk==0)
						{
							String query7="insert into createpass(pass_id,vehicle_no,type,valid_from,valid_upto,amount,slot_assigned) values ('"+t2.getText()+"','"+t3.getText()+"','"+c4.getSelectedItem().toString()+"','"+t5.getText()+"','"+t6.getText()+"','"+t7.getText()+"','"+t8.getText()+"')";
							int x=stmt.executeUpdate(query7);
							String query8="update passslottbl2 set status='occupied',type='"+c4.getSelectedItem()+"',pass_id='"+t2.getText()+"' where slot_no="+dbs_no;
							int y=stmt.executeUpdate(query8);
							JOptionPane.showMessageDialog(null,"Data Updated");
						}
					}
					else 
						JOptionPane.showMessageDialog(null,"Select vehicle type");

					con.close();
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Exception" +e);
				}
			}
		}
  }
public static void main(String args[])
{
	pass p=new pass();
	p.setExtendedState(JFrame.MAXIMIZED_BOTH);
	p.setVisible(true);
	p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	p.setTitle("CREATE PASS");
}
}