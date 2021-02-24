package com.managment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;
import java.sql.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import java.awt.Frame;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

public class donorReceiver extends JFrame implements ActionListener,WindowListener {
    private Connection con;
    private PreparedStatement ps,ps1,ps2,ps3,ps4;
    private ResultSet rs2,rs3,rs4;
	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtage;
	private JTextField txtphone;
	private JTextField txtemail;
	private JTextArea txtaddress;
	private JComboBox<String> comboBox;
	private JDateChooser dc;
	
	private ButtonGroup gender;
	private JRadioButton rdMale;
	private JRadioButton rdFemale;
	
	private ButtonGroup type;
	private JRadioButton rdDonor;
	private JRadioButton rdReceiptant;
	private JTextField txtbag;
	private JLabel lblDate;
	String g;
	int agee;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					donorReceiver frame = new donorReceiver();
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
	public donorReceiver() {
		con=CrudOperation.createConnection();
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setResizable(false);
		createGui();
	}
	
	public void fillcombo() {
		String[] bloodGroup= {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
		int n =bloodGroup.length;
		for(int i=0;i<n;i++)
		{
			comboBox.addItem(bloodGroup[i]);
		}
	}
	
public void createGui() {
	setTitle("CREATE NEW ACCOUNT");
	setIconImage(Toolkit.getDefaultToolkit().getImage(donorReceiver.class.getResource("/com/images/blood-156063__340.png")));
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 1437, 1147);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(240, 248, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	

	JLabel lblBloodBankAnd = new JLabel("Blood Bank and \r\nManagment System ");
	lblBloodBankAnd.setForeground(Color.RED);
	lblBloodBankAnd.setFont(new Font("Tahoma", Font.BOLD, 50));
	lblBloodBankAnd.setBounds(152, -16, 922, 98);
	contentPane.add(lblBloodBankAnd);
	
	JLabel lblName = new JLabel("NAME");
	lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	lblName.setBounds(82, 188, 125, 34);
	contentPane.add(lblName);
	
	txtname = new JTextField();
	txtname.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	txtname.setBounds(231, 188, 211, 34);
	contentPane.add(txtname);
	txtname.setColumns(10);
	
	JLabel lblAge = new JLabel("AGE");
	lblAge.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	lblAge.setBounds(528, 187, 80, 34);
	contentPane.add(lblAge);
	
	txtage = new JTextField();
	txtage.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
	txtage.setBounds(690, 186, 211, 34);
	contentPane.add(txtage);
	txtage.setColumns(10);
	
	rdMale = new JRadioButton("MALE");
	rdMale.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	rdMale.setBounds(152, 355, 105, 34);
	contentPane.add(rdMale);
	
	 rdFemale = new JRadioButton("FEMALE");
	rdFemale.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	rdFemale.setBounds(279, 355, 163, 44);
	contentPane.add(rdFemale);
	
	JLabel lblPhoneNo = new JLabel("PHONE NO");
	lblPhoneNo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	lblPhoneNo.setBounds(82, 274, 125, 34);
	contentPane.add(lblPhoneNo);
	
	txtphone = new JTextField();
	txtphone.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	txtphone.setBounds(231, 274, 211, 34);
	contentPane.add(txtphone);
	txtphone.setColumns(10);
	
	JLabel lblEmail = new JLabel("E-MAIL");
	lblEmail.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	lblEmail.setBounds(501, 277, 107, 28);
	contentPane.add(lblEmail);
	
	txtemail = new JTextField();
	txtemail.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
	txtemail.setBounds(690, 279, 211, 34);
	contentPane.add(txtemail);
	txtemail.setColumns(10);
	
	 comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT GROUP"}));
	comboBox.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	comboBox.setBounds(690, 360, 211, 34);
	fillcombo();
	contentPane.add(comboBox);
	
	JLabel lblAdress = new JLabel("ADRESS");
	lblAdress.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	lblAdress.setBounds(82, 514, 173, 44);
	contentPane.add(lblAdress);
	
	txtaddress = new JTextArea();
	txtaddress.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
	txtaddress.setBounds(231, 521, 669, 66);
	contentPane.add(txtaddress);
	txtaddress.setColumns(10);
	
	JLabel lblBloodGroup = new JLabel("BLOOD GROUP");
	lblBloodGroup.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	lblBloodGroup.setBounds(501, 355, 155, 44);
	contentPane.add(lblBloodGroup);
	
	rdDonor = new JRadioButton("DONOR");
	rdDonor.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
	rdDonor.setBounds(300, 100, 204, 45);
	contentPane.add(rdDonor);
	
	rdReceiptant = new JRadioButton("RECEIPTANT");
	rdReceiptant.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
	rdReceiptant.setBounds(528, 100, 252, 44);
	contentPane.add(rdReceiptant);
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon(donorReceiver.class.getResource("/com/images/SAVE_LIFE1.jpg")));
	label.setBounds(972, 80, 436, 705);
	contentPane.add(label);
	
	JLabel label_1 = new JLabel("");
	label_1.setIcon(new ImageIcon(donorReceiver.class.getResource("/com/images/quatation.png")));
	label_1.setBounds(103, 697, 768, 131);
	contentPane.add(label_1);
	
	JButton btnSubmit = new JButton("SUBMIT");
	btnSubmit.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
	btnSubmit.setBounds(388, 597, 252, 73);
	btnSubmit.addActionListener(this);
	contentPane.add(btnSubmit);
	
	gender=new ButtonGroup();
	gender.add(rdMale);//add rdmale to buttongroup
	gender.add(rdFemale);
	
	type=new ButtonGroup();
	type.add(rdDonor);//add rdDonor to buttongroup
	type.add(rdReceiptant);
	
	JLabel lblBloodBags = new JLabel("BLOOD BAGS");
	lblBloodBags.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	lblBloodBags.setBounds(501, 440, 149, 34);
	contentPane.add(lblBloodBags);
	
	txtbag = new JTextField();
	txtbag.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
	txtbag.setBounds(690, 440, 211, 34);
	contentPane.add(txtbag);
	txtbag.setColumns(10);
	
	lblDate = new JLabel("DATE");
	lblDate.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	lblDate.setBounds(83, 443, 105, 28);
	contentPane.add(lblDate);
	
	 dc = new JDateChooser();
	dc.getCalendarButton().setFont(new Font("Comic Sans MS", Font.BOLD, 14));
	dc.getCalendarButton().setText("Select");
	dc.setBounds(231, 440, 211, 34);
	dc.setDateFormatString("yyyy-MM-dd");
	contentPane.add(dc);
	
	
}

@Override
public void actionPerformed(ActionEvent e) {
	
	java.util.Date d= dc.getDate();
	long t=d.getTime();
	java.sql.Date sd=new java.sql.Date(t);
	System.out.println(sd);
	
	
	String name=txtname.getText().trim();
	String age=txtage.getText().trim();
	agee=Integer.parseInt(age);
	String phone=txtphone.getText().trim();
	String email=txtemail.getText().trim();
	String adress=txtaddress.getText().trim();
	String bag=txtbag.getText().trim();
	String gen=null;
	String Type=null;
	String group=null;

	if(rdMale.isSelected())
		gen=rdMale.getText();
	if(rdFemale.isSelected())
		gen=rdFemale.getText();
	if(rdDonor.isSelected())
		Type=rdDonor.getText();
	if(rdReceiptant.isSelected())
	    Type=rdReceiptant.getText();
	group=(String)comboBox.getSelectedItem();
	if(name.isEmpty()||age.isEmpty()||phone.isEmpty()||gen.isEmpty()||adress.isEmpty()||Type.isEmpty()||group.isEmpty()||bag.isEmpty())
		JOptionPane.showMessageDialog(this, "Data Needed");
	else {
		
		if(Type=="DONOR"&&agee>=18&&agee<=60)
		
		{
			try {
				String strinsert="insert into donor_receiverdetails values(?,?,?,?,?,?,?,?)";
				String strinsert1="insert into blooddonatedetails(PhoneNo,Date,NoOfBags,BloodGroup) values(?,?,?,?)";
				
				String strupdate1="update bloodbags set NoOfBags=? where BloodGroup=? ";
				String getstr="select * from bloodbags where BloodGroup=?";
				
				ps4=con.prepareStatement(getstr);
				ps4.setString(1, group);
				rs4=ps4.executeQuery();
				
				
				ps=con.prepareStatement(strinsert);
				ps1=con.prepareStatement(strinsert1);
				ps.setString(1, phone);
				ps.setString(2, name);
				ps.setString(3, email);
				ps.setString(4, adress);
				ps.setString(5, age);
				ps.setString(6, gen);
				ps.setString(7, group);
				ps.setString(8, Type);
				
				ps1.setString(1, phone);
				ps1.setDate(2,sd);
				ps1.setString(3, bag);
				ps1.setString(4, group);
				
				if(rs4.next())
				{
				String q=rs4.getString("NoOfBags");
				int w=Integer.parseInt(q);
				int a=Integer.parseInt(bag);
				a=w+a;
				g=String.valueOf(a);
				
				}
				ps3=con.prepareStatement(strupdate1);
				
				ps3.setString(1,g);
				ps3.setString(2, group);
				
				int row=ps.executeUpdate();
				int row2=ps1.executeUpdate();
				int row1=ps3.executeUpdate();
				if(row>0&&row2>0&&row1>0)
				{
					 JOptionPane.showMessageDialog(this, "record added succesfully");
					  txtname.setText("");
					  txtemail.setText("");
					  txtage.setText("");
					  txtphone.setText("");
					  txtaddress.setText("");
					  gender.setSelected(gender.getSelection(), false);
					  type.setSelected(type.getSelection(), false);
					  comboBox=null;
					  txtbag.setText("");
					  dc.setDate(null);
				}
				
				
				
			}catch(SQLException se)
			{
				System.out.println(se);
			}
			
		}
	
		else if(Type=="RECEIPTANT")
		{
			

			{
				try {
					String strinsert="insert into donor_receiverdetails values(?,?,?,?,?,?,?,?)";
					String strinsert1="insert into bloodrequestdetails(PhoneNo,NoOfBags,BloodGroup,Date) values(?,?,?,?)";
					ps=con.prepareStatement(strinsert);
					ps1=con.prepareStatement(strinsert1);
					ps.setString(1, phone);
					ps.setString(2, name);
					ps.setString(3, email);
					ps.setString(4, adress);
					ps.setString(5, age);
					ps.setString(6, gen);
					ps.setString(7, group);
					ps.setString(8, Type);
					
					ps1.setString(1, phone);
					ps1.setDate(4,sd);
					ps1.setString(2, bag);
					ps1.setString(3, group);
					
					
					
					String strupdate1="update bloodbags set NoOfBags=? where BloodGroup=? ";
					String getstr="select * from bloodbags where BloodGroup=?";
					
					ps4=con.prepareStatement(getstr);
					ps4.setString(1, group);
					rs4=ps4.executeQuery();
					if(rs4.next())
					{
					String q=rs4.getString("NoOfBags");
					int w=Integer.parseInt(q);
					int b=Integer.parseInt(bag);
					b=w-b;
					g=String.valueOf(b);
					
					}
					ps3=con.prepareStatement(strupdate1);
					
					ps3.setString(1,g);
					ps3.setString(2, group);
					
					
					
					
					int a=0;
						String strget="select * from bloodbags where BloodGroup=?";
						ps2=con.prepareStatement(strget);
						ps2.setString(1, group);
						rs2=ps2.executeQuery();
						if(rs2.next())
						{
							String nobags=rs2.getString("NoOfBags");
							 a=Integer.parseInt(nobags);
							 int b=Integer.parseInt(bag);
							 a=a-b;
							System.out.println(a);
						}
						if(a>=0) {
							
							int row=ps.executeUpdate();
							int row2=ps1.executeUpdate();
							int row1=ps3.executeUpdate();
							if(row>0&&row2>0&&row1>0)
							{
								 JOptionPane.showMessageDialog(this, "record added succesfully");
								  txtname.setText("");
								  txtemail.setText("");
								  txtage.setText("");
								  txtphone.setText("");
								  txtaddress.setText("");
								  gender.setSelected(gender.getSelection(), false);
								  type=null;
								  comboBox=null;
								  txtbag.setText("");
								  dc.setDate(null);
							}
						}
						else {
							JOptionPane.showMessageDialog(this, "SORRY NOT ENOUGH BLOOD BAGS");
						
					}
				}catch(SQLException se)
				{
					System.out.println(se);
				}
			
		}
		
	}
		else if(agee<18)
			JOptionPane.showMessageDialog(this, "UNDERAGE FOR BLOOD DONATION");
		else if(agee>60)
			JOptionPane.showMessageDialog(this, "OVERAGE FOR BLOOD DONATION");
	}
}

@Override
public void windowOpened(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosing(WindowEvent e) {
	try {
		if(con!=null)
		{
			con.close();
		}
	}catch(SQLException se)
	{
		System.out.println(se);
	}
	
}

@Override
public void windowClosed(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowIconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeiconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowActivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeactivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
}
