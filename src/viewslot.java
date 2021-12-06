import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.Date;
import java.sql.*;

public class viewslot extends JFrame
{
ImageIcon i1,cycle,bike,car;
JLabel l1,l2,l3,l4,l5;
JPanel pc,p1,p2,p3,p4,p5,p6,p7;
JPanel pb,p8,p9,p10,p11,p12,p13,p14;
JButton b[] = new JButton[92];
String sn,ssn,st,ty;
int i,pp,x;

 public viewslot()
{
	 setLayout(new BorderLayout());
	
 	setLayout(null);
 	Font f1= new Font("Times New Roman",Font.BOLD,26);

 	l1=new JLabel("Car Parking Area");
	l1.setFont(f1);
	l1.setForeground(Color.red);
	l1.setBounds(200,50,700,40);
	add(l1);

 	l2=new JLabel("Scooter/Motorcycle/Bicycle Parking Area");
	l2.setBounds(1000,50,700,40);
 	l2.setFont(f1);
	l2.setForeground(Color.red);
	add(l2);
 
	   pc=new JPanel();
		 pc.setBounds(40,100,725,680);
		 pc.setBackground(Color.green);
		 pc.setLayout(null);
	 	 add(pc);

	 	p1=new JPanel(new GridLayout(8,0));
	 	p1.setBounds(30,25,100,640);
	 	p1.setBackground(Color.blue);
	 	pc.add(p1);
	 
		p2=new JPanel(new GridLayout(8,0));
	 	p2.setBounds(150,25,100,640);
	 	p2.setBackground(Color.blue);
	 	pc.add(p2);
	 
	 	 p3=new JPanel(new GridLayout(0,6));
		 p3.setBounds(270,25,420,95);
		 p3.setBackground(Color.blue);
		 pc.add(p3);
	 
		 p4=new JPanel(new GridLayout(0,6));
	 	 p4.setBounds(270,155,420,95);
		 p4.setBackground(Color.blue);
		 pc.add(p4);
	 
		 p5=new JPanel(new GridLayout(0,6));
		 p5.setBounds(270,285,420,95);
		 p5.setBackground(Color.blue);
		 pc.add(p5);
	 
	 	p6=new JPanel(new GridLayout(0,6));
	 	p6.setBounds(270,415,420,95);
	 	p6.setBackground(Color.blue);
	 	pc.add(p6);
	 
		 p7=new JPanel(new GridLayout(0,6));
		 p7.setBounds(270,545,420,95);
		 p7.setBackground(Color.blue);
		 pc.add(p7);

		pb=new JPanel();
		 pb.setBounds(790,100,730,680);
		 pb.setBackground(Color.green);
	 	 pb.setLayout(null);
		 add(pb);
	 
	 	p8=new JPanel(new GridLayout(0,8));
	 	p8.setBounds(30,25,680,80);
	 	p8.setBackground(Color.blue);
	 	pb.add(p8);
	 
	 	p9=new JPanel(new GridLayout(0,8));
	 	p9.setBounds(30,150,680,80);
	 	p9.setBackground(Color.blue);
		pb.add(p9);
	 
		p10=new JPanel(new GridLayout(6,0));
	 	p10.setBounds(40,265,90,410);
	 	p10.setBackground(Color.blue);
		pb.add(p10);
	 
	 	p11=new JPanel(new GridLayout(6,0));
		p11.setBounds(180,265,90,410);
	 	p11.setBackground(Color.blue);
	 	pb.add(p11);
	 
	 	p12=new JPanel(new GridLayout(6,0));
	 	p12.setBounds(320,265,90,410);
	 	p12.setBackground(Color.blue);
	 	pb.add(p12);
	 
		p13=new JPanel(new GridLayout(6,0));
		p13.setBounds(460,265,90,410);
		p13.setBackground(Color.blue);
		pb.add(p13);
	 
		 p14=new JPanel(new GridLayout(6,0));
		 p14.setBounds(600,265,90,410);
		 p14.setBackground(Color.blue);
		 pb.add(p14);
		
	
 	for(i = 0; i <8; i++) 
	{
          		  b[i] = new JButton(String.valueOf(i+1));
		p1.add(b[i]);
	}

	
 	for(i = 8; i <16; i++) 
	{
          		  b[i] = new JButton(String.valueOf(i+1));
		
		p2.add(b[i]);
	}


 	for(i = 16; i <22 ; i++) 
	{
          		  b[i] = new JButton(String.valueOf(i+1));
          		p3.add(b[i]);
	}

	
 	for(i = 22; i <28; i++) 
	{
          		  b[i] = new JButton(String.valueOf(i+1));
          		p4.add(b[i]);
	}


 	for(i = 28; i <34; i++) 
	{
          		  b[i] = new JButton(String.valueOf(i+1));
          		p5.add(b[i]);
	}

 	for(i = 34; i <40; i++) 
	{
          		  b[i] = new JButton(String.valueOf(i+1));
          		p6.add(b[i]);
	}

	
 	for(i = 40; i <46; i++) 
	{
          		  b[i] = new JButton(String.valueOf(i+1));
          		p7.add(b[i]);
	}

	for(i = 46; i <54;i++) 
	{
          		  b[i] = new JButton(String.valueOf(i+1));
		
		p8.add(b[i]);
	}

	
 	for(i = 54; i <62; i++) 
	{
          		  b[i] = new JButton(String.valueOf(i+1));
		
		p9.add(b[i]);
	}


 	for(i = 62; i <68; i++) 
	{
          		  b[i] = new JButton(String.valueOf(i+1));
          		p10.add(b[i]);
	}

	
 	for(i = 68; i <74; i++) 
	{
          		  b[i] = new JButton(String.valueOf(i+1));
          		p11.add(b[i]);
	}


 	for(i = 74; i <80; i++) 
	{
          		  b[i] = new JButton(String.valueOf(i+1));
          		p12.add(b[i]);
	}

 	for(i = 80; i <86; i++) 
	{
          		  b[i] = new JButton(String.valueOf(i+1));
          		p13.add(b[i]);
	}

	
 	for(i = 86; i <92; i++) 
	{
          		  b[i] = new JButton(String.valueOf(i+1));
          		p14.add(b[i]);
	}
}

public viewslot(String sn)
{
this();
this.sn=sn;	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
		Statement stmt=con.createStatement();
		String query="select * from slottbl1 order by  slot_no";
		ResultSet rs=stmt.executeQuery(query);	
		while(true)
		{
			
			for(i=0;i<23;i++)
			{
				rs.next();
				ssn=String.valueOf(rs.getInt("slot_no"));
				st=rs.getString("status");
				
				if(ssn.equals(sn)&&st.equals("vacant"))
				{
	 				i1=new ImageIcon(this.getClass().getResource("cool.gif"));
					b[i].setIcon(i1); 	
					b[i].setBackground(Color.blue);
						
				}
				else if(st.equals("vacant"))
				{
					b[i].setBackground(Color.red);
				}
				else if(st.equals("occupied"))
				{
					b[i].setBackground(Color.blue);
					car=new ImageIcon(this.getClass().getResource("z19.jpg"));
					b[i].setIcon(car); 	
	 			}
			}
		con.close();
		}
	}
	catch(Exception e) { }

	try
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
		Statement stmt=con.createStatement();
		String query1="select * from passslottbl1";
		ResultSet rs=stmt.executeQuery(query1);
		while(true)
		{	
		for(i=23;i<46;i++)
		{
			rs.next();
			ssn=String.valueOf(rs.getInt("slot_no"));
			st=rs.getString("status");
			
			if(ssn.equals(sn)&&st.equals("vacant"))
			{
	 			i1=new ImageIcon(this.getClass().getResource("cool.gif"));
				b[i].setIcon(i1); 	
				b[i].setBackground(Color.blue);			
			}
			else if(st.equals("vacant"))
			{
				b[i].setBackground(Color.red);
			}
			else if(st.equals("occupied"))
			{
				b[i].setBackground(Color.blue);
				car=new ImageIcon(this.getClass().getResource("z19.jpg"));
				b[i].setIcon(car); 	
	 		}
		}	
		con.close();
		}
	}
	catch(Exception e) {	}

	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
		Statement stmt=con.createStatement();
		String query2="select * from slottbl2 order by  slot_no";
		ResultSet rs=stmt.executeQuery(query2);
		while(true)
		{
			for(i=46;i<69;i++)
			{
				rs.next();
				ssn=String.valueOf(rs.getInt("slot_no"));
				st=rs.getString("status");
				ty=rs.getString("type");
				if(ssn.equals(sn)&&st.equals("vacant"))
				{
	 				i1=new ImageIcon(this.getClass().getResource("cool.gif"));
					b[i].setIcon(i1); 	
					b[i].setBackground(Color.blue);
				}
				else if(st.equals("vacant"))
				{
					b[i].setBackground(Color.yellow);
				}
				else if(st.equals("occupied"))
				{
					if(ty.equals("scooter_motorcycle"))
					{
						b[i].setBackground(Color.blue);
						 bike=new ImageIcon(this.getClass().getResource("z20.png"));
						b[i].setIcon(bike); 	
					}
					else
					{
						b[i].setBackground(Color.blue);
						cycle=new ImageIcon(this.getClass().getResource("z21.png"));
						b[i].setIcon(cycle); 	
					}	
	 			}
			}
		con.close();
		}
	}
	catch(Exception e) { }
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
		Statement stmt=con.createStatement();
		String query3="select * from passslottbl2";
		ResultSet rs=stmt.executeQuery(query3);
		while(true)
		{	
			for(i=69;i<93;i++)
			{
				rs.next();
				ssn=String.valueOf(rs.getInt("slot_no"));
				st=rs.getString("status");
				ty=rs.getString("type");
				if(ssn.equals(sn)&&st.equals("vacant"))
				{
	 				i1=new ImageIcon(this.getClass().getResource("cool.gif"));
					b[i].setIcon(i1); 	
					b[i].setBackground(Color.blue);
				}
				else if(st.equals("vacant"))
				{
					b[i].setBackground(Color.yellow);
				}
				else if(st.equals("occupied"))
				{
					if(ty.equals("scooter_motorcycle"))
					{
						b[i].setBackground(Color.blue);
						 bike=new ImageIcon(this.getClass().getResource("z20.png"));
						b[i].setIcon(bike); 	
					}
					else
					{
						b[i].setBackground(Color.blue);
						cycle=new ImageIcon(this.getClass().getResource("z21.png"));
						b[i].setIcon(cycle); 	
					}	
	 			}
			}	
		con.close();
		}	
	}
	catch(Exception e) {	}
}	
	


public static void main(String args[])
{
	viewslot s= new viewslot();
	s.setExtendedState(JFrame.MAXIMIZED_BOTH);
	s.setVisible(true);
	s.setTitle("VIEW SLOT");
	s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
}