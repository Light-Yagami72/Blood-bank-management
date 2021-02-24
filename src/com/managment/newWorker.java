package com.managment;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class newWorker extends JFrame implements ActionListener,WindowListener{

	private JPanel contentPane;
	private JTextField txtworkerid;
	private JTextField txtname;
	private JTextField txtphone;
	private ButtonGroup gender;
	private JRadioButton rdmale;
	private JRadioButton rdfemale;
	private Connection con;
	private PreparedStatement psworkerdetails,ps;
	private JTextField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newWorker frame = new newWorker();
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
	public newWorker()
	
	{
		setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
		setIconImage(Toolkit.getDefaultToolkit().getImage(newWorker.class.getResource("/com/images/blood-156063__340.png")));
		this.addWindowListener(this);
		con=CrudOperation.createConnection();
		createGui();
		
	}
	public void createGui()
	{
		setTitle("CREATE WORKER ACCOUNT\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1155, 818);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBloodBankAnd = new JLabel("Blood Bank and \r\nManagment System ");
		lblBloodBankAnd.setForeground(Color.RED);
		lblBloodBankAnd.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblBloodBankAnd.setBounds(46, 0, 1031, 83);
		contentPane.add(lblBloodBankAnd);
		
		JLabel lblWorkerId = new JLabel("WORKER ID");
		lblWorkerId.setForeground(Color.BLACK);
		lblWorkerId.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblWorkerId.setBounds(114, 138, 214, 74);
		contentPane.add(lblWorkerId);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblName.setBounds(114, 231, 177, 67);
		contentPane.add(lblName);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO.");
		lblPhoneNo.setForeground(Color.BLACK);
		lblPhoneNo.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblPhoneNo.setBounds(114, 308, 177, 64);
		contentPane.add(lblPhoneNo);
		
		txtworkerid = new JTextField();
		txtworkerid.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		txtworkerid.setBounds(301, 161, 222, 42);
		contentPane.add(txtworkerid);
		txtworkerid.setColumns(10);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		txtname.setBounds(301, 243, 222, 42);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtphone = new JTextField();
		txtphone.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		txtphone.setBounds(301, 325, 222, 42);
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		
		 rdmale = new JRadioButton("MALE");
		 rdmale.setForeground(Color.BLACK);
		 rdmale.setBackground(SystemColor.activeCaption);
		rdmale.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		rdmale.setBounds(142, 487, 110, 53);
		contentPane.add(rdmale);
		
		 rdfemale = new JRadioButton("FEMALE");
		 rdfemale.setForeground(Color.BLACK);
		 rdfemale.setBackground(SystemColor.activeCaption);
		rdfemale.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		rdfemale.setBounds(351, 487, 124, 53);
		contentPane.add(rdfemale);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.setBackground(new Color(135, 206, 235));
		btnSubmit.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		btnSubmit.setBounds(218, 565, 200, 67);
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);
	
		gender=new ButtonGroup();
		gender.add(rdmale);
		gender.add(rdfemale);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(newWorker.class.getResource("/com/images/TREE - CopyCOPY.png")));
		label.setBounds(546, 48, 542, 677);
		contentPane.add(label);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblPassword.setBounds(114, 415, 177, 24);
		contentPane.add(lblPassword);
		
		txtpass = new JTextField();
		txtpass.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		txtpass.setBounds(301, 408, 222, 42);
		contentPane.add(txtpass);
		txtpass.setColumns(10);
	}
	public void actionPerformed(ActionEvent w)
	{
		
		String userid =txtworkerid.getText().trim();
		String username=txtname.getText().trim();
		String userphone=txtphone.getText().trim();
		String pass=txtpass.getText().trim();
		String gen=null;
		
		if(rdmale.isSelected())
			gen=rdmale.getText();
		
		if(rdfemale.isSelected())
			gen=rdfemale.getText()	;
	

		if(userid.isEmpty()||username.isEmpty()||username.isEmpty()||userphone.isEmpty()||gen.isEmpty()||pass.isEmpty())
{
			JOptionPane.showMessageDialog(this, "input data");
	
}	
		else
   {
			try 

    {
	
	String strinsert="insert into workerdetails values(?,?,?,?)";//no of columns in table =no of '?'
	String strlog="insert into login values(?,?,?)";
	ps=con.prepareStatement(strlog);
	ps.setString(1, userid);
	ps.setString(2, pass);
	ps.setString(3, "worker");
	psworkerdetails=con.prepareStatement(strinsert);//dbms compile
	psworkerdetails.setString(1, userid);
	psworkerdetails.setString(2, username);
	psworkerdetails.setString(3, userphone);
	psworkerdetails.setString(4, gen);
	
	int row=psworkerdetails.executeUpdate();
	int row2=ps.executeUpdate();
	if(row>0&&row2>0)
	{
		JOptionPane.showMessageDialog(this, "record added succesfully");
		txtworkerid.setText("");
		txtname.setText("");
		txtphone.setText("");
		txtpass.setText("");
	}
	}
catch(SQLException sw)
{
	System.out.println(sw);
}
			finally {
				
				if(psworkerdetails!=null)
					try {
					psworkerdetails.close();//it raises exception hence placed in try catch block
					}
				catch(SQLException sw)
				{
					System.out.println(sw);
				}
			}

    }
}
	public void windowOpened(WindowEvent w) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing(WindowEvent w) {
		// TODO Auto-generated method stub
		
		try {
			
			if(con!=null)
				con.close();//it will close the connection from the database
		}
		catch(SQLException sw)
		{
			System.out.println(sw);
		}
	}
	@Override
	public void windowClosed(WindowEvent w) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent w) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent w) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent w) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent w) {
		// TODO Auto-generated method stub
		
	}	
}


			

 