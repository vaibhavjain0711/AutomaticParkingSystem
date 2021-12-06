import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class setrate extends JFrame implements ActionListener
{
ImageIcon i;
JLabel l,l1,l2,l3,l4,l5,l6,l7;
JTextField t1,t2,t3;
JButton b1;
	public setrate()
	 {
		setLayout(new FlowLayout());
		i=new ImageIcon(this.getClass().getResource("a1.jpg"));
		l=new JLabel(i);
		setContentPane(l);

		setLayout(null);
		Font f=new Font("Times New Roman",Font.BOLD,65);
		l1=new JLabel("SET RATE ");
		l1.setBounds(700,90,450,50);
		l1.setFont(f);
		l1.setForeground(Color.red);
		add(l1);

		Font f1=new Font("Times New Roman",Font.BOLD,40);

		l2=new JLabel("Car :");
		l2.setBounds(400,200,300,50);
		l2.setFont(f1);
		l2.setForeground(Color.green);
		add(l2);
		
		t1=new JTextField();
		t1.setBounds(650,200,300,50);
		t1.setFont(f1);
		add(t1);

		l3=new JLabel("Scooter/Motorcycle :");
		l3.setBounds(300,300,300,50);
		l3.setFont(f1);
		l3.setForeground(Color.green);
		add(l3);

		t2=new JTextField(20);
		t2.setBounds(650,300,300,50);
		t2.setFont(f1);
		add(t2);

		l4=new JLabel("Bicycle :");
		l4.setBounds(400,400,300,50);
		l4.setFont(f1);
		l4.setForeground(Color.green);
		add(l4);
		
		t3=new JTextField(20);
		t3.setBounds(650,400,300,50);
		t3.setFont(f1);
		add(t3);

		l5=new JLabel("Rs/hr");
		l5.setBounds(1000,200,300,50);
		l5.setFont(f1);
		l5.setForeground(Color.green);
		add(l5);

		l6=new JLabel("Rs/hr");
		l6.setBounds(1000,300,300,50);
		l6.setFont(f1);
		l6.setForeground(Color.green);
		add(l6);

		l7=new JLabel("Rs/hr");
		l7.setBounds(1000,400,300,50);
		l7.setFont(f1);
		l7.setForeground(Color.green);
		add(l7);

		b1=new JButton("Set Rate");
		b1.setBounds(570,500,200,40);
		b1.setFont(f1);
		b1.addActionListener(this);
		b1.setForeground(Color.blue);
		add(b1);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
				Statement stmt=con.createStatement();
				String query="insert into setrate(car,scooter_motorcycle,bicycle)values('"+t1.getText()+" ',' "+t2.getText()+" ',' "+t3.getText()+"')";
				int x=stmt.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Rate Set Successfully");
				t1.setText("");	
				t2.setText("");
				t3.setText("");
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Exception" +e);
			}
		}
	}

	public static void main(String args[])
	{
		setrate s=new setrate();
		s.setExtendedState(JFrame.MAXIMIZED_BOTH);
		s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		s.setVisible(true);
		s.setTitle("SET RATE");
	}
}