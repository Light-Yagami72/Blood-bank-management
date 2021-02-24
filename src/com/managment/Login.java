package com.managment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Toolkit;
import com.dbutils.CrudOperation;
import java.sql.*;
public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPasswordField txtpassword;
	private JTextField txtid;
	private Connection con;
	private ResultSet rs;
	private  PreparedStatement ps;
/**
	 * Launch the application.
	 */
	 public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		
		con=CrudOperation.createConnection();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/images/blood-156063__340.png")));
		createGui();
	}
	
	public void createGui()
	{
		setTitle("LOGIN\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1550, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserId = new JLabel("USER ID");
		lblUserId.setForeground(Color.WHITE);
		lblUserId.setBackground(Color.LIGHT_GRAY);
		lblUserId.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblUserId.setBounds(49, 177, 119, 44);
		contentPane.add(lblUserId);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBackground(Color.RED);
		lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblPassword.setBounds(49, 258, 126, 35);
		contentPane.add(lblPassword);
		
		txtpassword = new JPasswordField();
		txtpassword.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		txtpassword.setBounds(199, 256, 166, 44);
		contentPane.add(txtpassword);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		txtid.setBounds(199, 177, 166, 43);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblBloodBankAnd = new JLabel("Blood Bank and \r\nManagment System \r\nSign In");
		lblBloodBankAnd.setForeground(Color.WHITE);
		lblBloodBankAnd.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblBloodBankAnd.setBounds(242, 10, 1130, 98);
		contentPane.add(lblBloodBankAnd);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		btnSubmit.setBounds(92, 332, 216, 70);
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/com/images/10101010.jpg")));
		label.setBounds(0, 0, 1536, 811);
		contentPane.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String userid=txtid.getText().trim();
		
		char[] pass=txtpassword.getPassword();
		String userpass=new String(pass);
		if(userid.isEmpty()||userpass.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Data Needed");
		}
		else
		{try {
			
			String strsql="select * from login where UserId=? and Userpass=?";
			
			ps=con.prepareStatement(strsql);//create connection
			ps.setString(1, userid);
			ps.setString(2, userpass);
			rs=ps.executeQuery();//querry execution
			if(rs.next())
			{
				String utype=rs.getString("Usertype");
				if(utype.equals("owner"))
				{
					JOptionPane.showMessageDialog(this, "welcome SIR");
					txtid.setText("");
					txtpassword.setText("");
					owner a=new owner();
					a.setVisible(true);
					
					
				}
				if(utype.equals("worker"))
				{
					JOptionPane.showMessageDialog(this, "welcome to work");
					txtid.setText("");
					txtpassword.setText("");
					worker B=new worker();
					B.setVisible(true);
					
					
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "No Match Found for above Data");
				txtid.setText("");
				txtpassword.setText("");
				
			}
		}
		catch(SQLException se)
		{
		  System.out.println(se);	
		}
		}
		
	}
}
