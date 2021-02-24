package com.managment;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class delWorker extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtphone;
	private Connection con;
	private PreparedStatement pssearch,ps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delWorker frame = new delWorker();
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
	public delWorker() {
		con=CrudOperation.createConnection();
		setResizable(false);
		createGui();
	}
	
	
	
public void createGui()
{
	setTitle("DELETE WORKER ACCOUNT");
	setIconImage(Toolkit.getDefaultToolkit().getImage(delWorker.class.getResource("/com/images/blood-156063__340.png")));
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 1145, 743);
	contentPane = new JPanel();
	contentPane.setBackground(SystemColor.inactiveCaption);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);	
	

	JLabel lblBloodBankAnd = new JLabel("Blood Bank and \r\nManagment System ");
	lblBloodBankAnd.setForeground(Color.RED);
	lblBloodBankAnd.setFont(new Font("Tahoma", Font.BOLD, 54));
	lblBloodBankAnd.setBounds(42, -12, 1031, 119);
	contentPane.add(lblBloodBankAnd);
	
	JLabel lblWorkerId = new JLabel("WORKER ID");
	lblWorkerId.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	lblWorkerId.setBounds(59, 117, 152, 65);
	contentPane.add(lblWorkerId);
	
	txtid = new JTextField();
	txtid.setFont(new Font("Tahoma", Font.BOLD, 18));
	txtid.setBounds(243, 131, 193, 38);
	contentPane.add(txtid);
	txtid.setColumns(10);
	
	JButton btnCheckId = new JButton("CHECK ID");
	btnCheckId.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	btnCheckId.setBounds(493, 125, 193, 49);
	btnCheckId.addActionListener(this);
	contentPane.add(btnCheckId);
	
	JButton btnDeleteAccount = new JButton("DELETE ACCOUNT");
	btnDeleteAccount.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
	btnDeleteAccount.setBounds(107, 330, 230, 49);
	btnDeleteAccount.addActionListener(this);
	contentPane.add(btnDeleteAccount);
	
	JLabel lblName = new JLabel("NAME");
	lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	lblName.setBounds(59, 197, 112, 38);
	contentPane.add(lblName);
	
	JLabel lblPhoneNo = new JLabel("PHONE NO.");
	lblPhoneNo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	lblPhoneNo.setBounds(59, 256, 172, 38);
	contentPane.add(lblPhoneNo);
	
	txtname = new JTextField();
	txtname.setEditable(false);
	txtname.setFont(new Font("Tahoma", Font.BOLD, 18));
	txtname.setBounds(243, 198, 193, 38);
	contentPane.add(txtname);
	txtname.setColumns(10);
	
	txtphone = new JTextField();
	txtphone.setEditable(false);
	txtphone.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	txtphone.setBounds(243, 262, 193, 35);
	contentPane.add(txtphone);
	txtphone.setColumns(10);
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon(delWorker.class.getResource("/com/images/WHITE1.png")));
	label.setBounds(458, 184, 673, 503);
	contentPane.add(label);
	
	JLabel label_1 = new JLabel("");
	label_1.setIcon(new ImageIcon(delWorker.class.getResource("/com/images/TEST1.jpg")));
	label_1.setBounds(10, 393, 438, 324);
	contentPane.add(label_1);
	
}

@Override
public void actionPerformed(ActionEvent e) {
	String caption=e.getActionCommand();
	String id=txtid.getText();
	
	if(caption.equals("CHECK ID"))
	{
		if(id.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Enter ID Sir!!!");
		}
			else
		{
			String strsql="select  * from workerdetails where WorkerId=?";
			String strsql1="select  * from login where UserId=?";
			try{
				pssearch=con.prepareStatement(strsql);
				ps=con.prepareStatement(strsql1);
				pssearch.setString(1, id);
				ps.setString(1, id);
				ResultSet rs=pssearch.executeQuery();
				ResultSet rs1=ps.executeQuery();
					if(rs.next()&&rs1.next())//record exists
					{
						String ename=rs.getString("Name");
						String ephone=rs.getString("PhoneNo");
						
						txtphone.setText(ephone);
						txtname.setText(ename);
			        }
					else
					{
		JOptionPane.showMessageDialog(this, "No Such ID");
		txtid.setText("");
		txtname.setText("");
		txtphone.setText("");
					}
			}
					catch(SQLException se)
					{
					System.out.println(se);	
					}
	            }
	  }
	
	if(caption.equals("DELETE ACCOUNT"))
	{
		int option=JOptionPane.showConfirmDialog(this, "Are u sure u wish to delete record");//returns 0 for yes , 1 for no and 2 for cancel
		System.out.println(option);
		if(option==0)//if the user confirms to delete record
		        {
			
			String strdelete="delete from workerdetails where WorkerId=?";
			String strdelete1="delete from login where UserId=?";//querry
		try {
			pssearch=con.prepareStatement(strdelete);
			ps=con.prepareStatement(strdelete1);
			pssearch.setString(1, id);
			ps.setString(1, id);
			
			int row=pssearch.executeUpdate();
			int row1=ps.executeUpdate();//executing querry
			if(row>0&&row1>0)
			{
				JOptionPane.showMessageDialog(this, "Record deleted successfully", "updation", JOptionPane.WARNING_MESSAGE);
			}
			txtid.setText("");
			txtname.setText("");
			txtphone.setText("");
		}
	           catch(SQLException se)

					{
						
						System.out.println(se);
					}
					
				}
		else//if user selects not to delete record 
		{
				
				txtid.setText("");
				txtname.setText("");
				txtphone.setText("");
				
			}
		        }
		        }
}

