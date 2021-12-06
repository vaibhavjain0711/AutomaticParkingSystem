import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import javax.swing.JOptionPane;

public class ratelist extends JFrame 
{
	JLabel heading,note;	
	JScrollPane jsp1;
	JPanel jp,jp1,jp2,jp3;
	JTable jt1;
	int i,j;
	
	DefaultTableModel tm=new DefaultTableModel(1,3);
	String head[ ]={"Car","Scooter/Motorcycle","Bicycle"};
	
	
	Statement statement;
	ResultSet rs;
	public ratelist()
 	{
		heading=new JLabel("Rate List ");
		heading.setFont(new Font("Times New Roman",Font.PLAIN,45));
		heading.setForeground(Color.blue);
		note=new JLabel("Note-All Charges are Applicable On Per Hour Basis ");
		note.setFont(new Font("Times New Roman",Font.PLAIN,30));
		note.setForeground(Color.blue);
		
		jp=new JPanel();
		jp.setLayout(new BorderLayout());

		jp2=new JPanel();
		jp2.setLayout(new FlowLayout());
		jp2.add(heading);
		jp.add(jp2,BorderLayout.NORTH);

		jp3=new JPanel();
		jp3.setLayout(new FlowLayout());
		jp3.add(note);
		jp.add(jp3,BorderLayout.SOUTH);
		

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		jp1=new JPanel();
		jp1.setLayout(new FlowLayout());

		jt1=new JTable();
		jt1.setRowHeight(50);
		jt1.setFont(new Font("Times New Roman",Font.PLAIN,20));
		jt1.setModel(tm);
		jt1.setForeground(Color.red);
		for(j=0;j<3;j++)
		{
			tm.setValueAt(head[j],0,j);
			jt1.getColumnModel().getColumn(j).setPreferredWidth(200);
			jt1.getColumnModel().getColumn(j).setCellRenderer(rightRenderer);
		}
		jp1.add(jt1);
		jp.add(jp1,BorderLayout.CENTER);
	
		int v,h;
		v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		jsp1=new JScrollPane(jp,v,h);
		Container c=getContentPane();
		c.add(jsp1);
	getfields();	
	}
	
	public void getfields()
  	{ 
  	       try
  	       {
  	    	 Class.forName("com.mysql.jdbc.Driver");
  			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingdatabase","root","root");
  	          	 statement=con.createStatement();
  	          	 String query="select * from setrate";
  	          	 rs=statement.executeQuery(query);

		while(rs.next())
		{
			String [] r={String.valueOf(rs.getInt(1)),String.valueOf(rs.getInt(2)),String.valueOf(rs.getInt(3))};
			tm.addRow(r);
		}
			 con.close();
  	          }
  	          catch(Exception e)
  	          {
  	                 JOptionPane.showMessageDialog(null,"Exception" +e);
  	          }
  	   }
 
	public static void main(String args[])
          	{
		ratelist r=new ratelist();
		r.setExtendedState(JFrame.MAXIMIZED_BOTH);
  		r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  		r.setTitle("Rate List");
  		r.setVisible(true);
        	}
}

		