package com.managment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Frame;
import com.toedter.calendar.JDateChooser;



public class updateRD extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtphone;
	private JTextField txtname;
	private JTextField txtage;
	private JTextField txtemail;
	private JTextField txtadress;
    private Connection con;
    private PreparedStatement ps,pu,ps1,ps2,ps3,ps4;
    private ResultSet rs2,rs4;
    private JTextField txtbag;
    
    String g;
    String group="";
	String Type="";
    private JDateChooser dc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateRD frame = new updateRD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public updateRD() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		con=CrudOperation.createConnection();
		createGui();
	}
public void createGui() {
	setTitle("UPDATE DONOR_RECEIPTANT");
	setIconImage(Toolkit.getDefaultToolkit().getImage(updateRD.class.getResource("/com/images/blood-156063__340.png")));
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 1430, 777);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(139, 0, 0));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblBloodBankAnd = new JLabel("Blood Bank and \r\nManagment System ");
	lblBloodBankAnd.setBackground(new Color(255, 235, 205));
	lblBloodBankAnd.setForeground(new Color(255, 235, 205));
	lblBloodBankAnd.setFont(new Font("Tahoma", Font.BOLD, 50));
	lblBloodBankAnd.setBounds(152, -16, 922, 98);
	contentPane.add(lblBloodBankAnd);
	
	JLabel lblPhoneNo = new JLabel("PHONE NO.");
	lblPhoneNo.setForeground(new Color(0, 0, 0));
	lblPhoneNo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	lblPhoneNo.setBounds(30, 146, 143, 33);
	contentPane.add(lblPhoneNo);
	
	txtphone = new JTextField();
	txtphone.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	txtphone.setBounds(192, 143, 227, 41);
	contentPane.add(txtphone);
	txtphone.setColumns(10);
	
	JButton btnCheckPhone = new JButton("CHECK RECORD");
	btnCheckPhone.setBackground(new Color(255, 255, 255));
	btnCheckPhone.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	btnCheckPhone.setBounds(466, 139, 227, 46);
	btnCheckPhone.addActionListener(this);
	contentPane.add(btnCheckPhone);
	
	JLabel lblName = new JLabel("NAME");
	lblName.setForeground(new Color(0, 0, 0));
	lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	lblName.setBounds(30, 224, 143, 33);
	contentPane.add(lblName);
	
	txtname = new JTextField();
	txtname.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	txtname.setBounds(192, 220, 501, 41);
	contentPane.add(txtname);
	txtname.setColumns(10);
	
	JLabel lblAge = new JLabel("AGE");
	lblAge.setForeground(new Color(0, 0, 0));
	lblAge.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
	lblAge.setBounds(466, 296, 69, 38);
	contentPane.add(lblAge);
	
	txtage = new JTextField();
	txtage.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
	txtage.setBounds(617, 296, 76, 37);
	contentPane.add(txtage);
	txtage.setColumns(10);
	
	JLabel lblEmail = new JLabel("EMAIL");
	lblEmail.setForeground(new Color(0, 0, 0));
	lblEmail.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	lblEmail.setBounds(30, 300, 143, 33);
	contentPane.add(lblEmail);
	
	txtemail = new JTextField();
	txtemail.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	txtemail.setBounds(192, 297, 227, 41);
	contentPane.add(txtemail);
	txtemail.setColumns(10);
	
	JLabel lblAdress = new JLabel("ADDRESS");
	lblAdress.setForeground(new Color(0, 0, 0));
	lblAdress.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	lblAdress.setBounds(30, 490, 143, 41);
	contentPane.add(lblAdress);
	
	txtadress = new JTextField();
	txtadress.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	txtadress.setBounds(192, 490, 501, 41);
	contentPane.add(txtadress);
	txtadress.setColumns(10);
	
	JButton btnUpdateRecord = new JButton("UPDATE RECORD");
	btnUpdateRecord.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
	btnUpdateRecord.setBounds(238, 583, 286, 84);
	btnUpdateRecord.addActionListener(this);
	contentPane.add(btnUpdateRecord);
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon(updateRD.class.getResource("/com/images/db.jpg")));
	label.setBounds(800, 118, 606, 638);
	contentPane.add(label);
	
	JLabel lblDate = new JLabel("DATE");
	lblDate.setForeground(Color.BLACK);
	lblDate.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	lblDate.setBounds(30, 394, 69, 33);
	contentPane.add(lblDate);
	
	dc = new JDateChooser();
	dc.setBounds(192, 386, 227, 41);
	dc.setDateFormatString("yyyy-MM-dd");
	contentPane.add(dc);
	
	JLabel lblBloodBags = new JLabel(" BLOOD BAGS");
	lblBloodBags.setForeground(Color.BLACK);
	lblBloodBags.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	lblBloodBags.setBounds(450, 394, 143, 33);
	contentPane.add(lblBloodBags);
	
	txtbag = new JTextField();
	txtbag.setBounds(617, 396, 76, 38);
	contentPane.add(txtbag);
	txtbag.setColumns(10);
	
}

@Override
public void actionPerformed(ActionEvent e) {
	
	
	java.util.Date d;
	 
	
	
	String caption=e.getActionCommand();
	String id=txtphone.getText();
	if(caption.equals("CHECK RECORD"))
	{	
	   if(id.isEmpty())
	  {
		  JOptionPane.showMessageDialog(this, "DATA NEEDED");
	  }
	   else
	   {
		  String strsql="select  * from donor_receiverdetails where PhoneNo=?";
		   try {
			
			ps=con.prepareStatement(strsql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				
				String ename=rs.getString("Name");
				String eage=rs.getString("Age");
				String mail=rs.getString("Email");
				String eadd=rs.getString("Address");
				
				group=rs.getString("BloodGroup");
			    Type=rs.getString("Type");
				txtadress.setText(eadd);
				txtage.setText(eage);
				txtphone.setText(id);
				txtemail.setText(mail);
				txtname.setText(ename);
				txtbag.setText("0");
				
				
                			
				}
			else {
				JOptionPane.showMessageDialog(this, "No Such Phone Number");
			}
			 }catch(SQLException se)
		   {
			   System.out.println(se);
		   }
	  }
    }
	
	if(caption.equals("UPDATE RECORD"))
	{
		
		d=dc.getDate();	
		
		
		
		java.sql.Date sd=new java.sql.Date((long)d.getTime());
		
		
		String name=txtname.getText();
		String email=txtemail.getText();
		String address=txtadress.getText();
		String age=txtage.getText();
		String bags=txtbag.getText();
		System.out.println(bags);
		if(Type.equals("DONOR"))
			
		{
			
			
			
			try {
				String strupdate="update donor_receiverdetails set Name=?,Email=?,Address=?, Age=? where PhoneNo=?";
				String strinsert="insert into blooddonatedetails(PhoneNo,Date,NoofBags,BloodGroup) values(?,?,?,?)";
				
				String strupdate1="update bloodbags set NoOfBags=? where BloodGroup=? ";
				String getstr="select * from bloodbags where BloodGroup=?";
				
				ps4=con.prepareStatement(getstr);
				ps4.setString(1, group);
				rs4=ps4.executeQuery();
				if(rs4.next())
				{
				String q=rs4.getString("NoOfBags");
				int w=Integer.parseInt(q);
				int a=Integer.parseInt(bags);
				a=w+a;
				g=String.valueOf(a);
				
				}
				ps3=con.prepareStatement(strupdate1);
				
				ps3.setString(1,g);
				ps3.setString(2, group);
				
				
				
				
				pu=con.prepareStatement(strupdate);
				ps1=con.prepareStatement(strinsert);
			
				pu.setString(1, name);
				pu.setString(2, email);
				pu.setString(3, address);
				pu.setString(4, age);
				pu.setString(5, id);
				
				
				
				ps1.setString(1, id);
				ps1.setDate(2,sd );
				ps1.setString(3, bags);
				ps1.setString(4, group);
				
				
				
				
				int row=pu.executeUpdate();
				int row1=ps1.executeUpdate();
				int row2=ps3.executeUpdate();
				if(row>0&&row1>0&&row2>0)
				{
					JOptionPane.showMessageDialog(this, "RECORD UPADTED", "updation", JOptionPane.WARNING_MESSAGE);
				}
				txtphone.setText("");
				txtadress.setText("");
				txtage.setText("");
				txtemail.setText("");
				txtname.setText("");
				txtbag.setText("");
				
				
			}catch(SQLException se)
			{
				System.out.println(se);
			}
		}
			if(Type.equals("RECEIPTANT"))
			{
				int a=0;
				try {
					
					String strupdate="update donor_receiverdetails set Name=?,Email=?,Address=?, Age=? where PhoneNo=?";
					String strinsert="insert into bloodrequestdetails(PhoneNo,NoofBags,BloodGroup,Date) values(?,?,?,?)";
					
					pu=con.prepareStatement(strupdate);
					ps1=con.prepareStatement(strinsert);
					
					
					String strupdate1="update bloodbags set NoOfBags=? where BloodGroup=? ";
					String getstr="select * from bloodbags where BloodGroup=?";
					
					ps4=con.prepareStatement(getstr);
					ps4.setString(1, group);
					rs4=ps4.executeQuery();
					if(rs4.next())
					{
					String q=rs4.getString("NoOfBags");
					int w=Integer.parseInt(q);
					int b=Integer.parseInt(bags);
					b=w-b;
					g=String.valueOf(b);
					
					}
					ps3=con.prepareStatement(strupdate1);
					
					ps3.setString(1,g);
					ps3.setString(2, group);
					
					
					
					
					pu.setString(1, name);
					pu.setString(2, email);
					pu.setString(3, address);
					pu.setString(4, age);
					pu.setString(5, id);
					
					ps1.setString(1, id);
					ps1.setString(2, bags);
					ps1.setString(3, group);
					ps1.setDate(4, sd);
					String strget="select * from bloodbags where BloodGroup=?";
					ps2=con.prepareStatement(strget);
					ps2.setString(1, group);
					rs2=ps2.executeQuery();
					if(rs2.next())
					{
						String nobags=rs2.getString("NoOfBags");
						 a=Integer.parseInt(nobags);
						 int b=Integer.parseInt(bags);
						 a=a-b;
						
					}
					if(a>=0)
					{
					
					
					int row=pu.executeUpdate();
					int row1=ps1.executeUpdate();
					int row2=ps3.executeUpdate();
					if(row>0&&row1>0&&row2>0)
					{
						JOptionPane.showMessageDialog(this, "RECORD UPADTED", "updation", JOptionPane.WARNING_MESSAGE);
					}
					txtphone.setText("");
					txtadress.setText("");
					txtage.setText("");
					txtemail.setText("");
					txtname.setText("");
					txtbag.setText("");
					}
					else {
						JOptionPane.showMessageDialog(this, "SORRY NOT ENOUGH BLOOD BAGS");}
					
				}catch(SQLException se)
				{
					System.out.println(se);
				}
				
				}
				}
				
			}
		}
			
		
		
		
	
	
	


