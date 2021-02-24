package com.managment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.sql.*;
import java.awt.Frame;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class deleteRd extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtphone;
	private JTextField txtname;
	private JTextField txtage;
	private JTextField txtgroup;
	private JTextField txttype;
	private JTextField txtaddress;

	private Connection con;
	private PreparedStatement ps;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteRd frame = new deleteRd();
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
	public deleteRd() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		con=CrudOperation.createConnection();
		createGui();
	}
	
	public void createGui() {
		setTitle("DELETE DONOR_RECEIPTANT");
		setIconImage(Toolkit.getDefaultToolkit().getImage(deleteRd.class.getResource("/com/images/blood-156063__340.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1430, 777);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBloodBankAnd = new JLabel("Blood Bank and \r\nManagment System ");
		lblBloodBankAnd.setForeground(Color.RED);
		lblBloodBankAnd.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblBloodBankAnd.setBounds(152, -16, 922, 98);
		contentPane.add(lblBloodBankAnd);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO.");
		lblPhoneNo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblPhoneNo.setBounds(41, 131, 133, 19);
		contentPane.add(lblPhoneNo);
		
		txtphone = new JTextField();
		txtphone.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtphone.setBounds(227, 125, 180, 39);
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		
		JButton btnCheckRecord = new JButton("CHECK RECORD");
		btnCheckRecord.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnCheckRecord.setBounds(456, 125, 252, 45);
		btnCheckRecord.addActionListener(this);
		contentPane.add(btnCheckRecord);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblName.setBounds(41, 205, 133, 39);
		contentPane.add(lblName);
		
		txtname = new JTextField();
		txtname.setEditable(false);
		txtname.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		txtname.setBounds(226, 212, 180, 39);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblAge.setBounds(456, 212, 73, 39);
		contentPane.add(lblAge);
		
		txtage = new JTextField();
		txtage.setEditable(false);
		txtage.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 21));
		txtage.setBounds(550, 212, 158, 40);
		contentPane.add(txtage);
		txtage.setColumns(10);
		
		JLabel lblBloodGroup = new JLabel("BLOOD GROUP");
		lblBloodGroup.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblBloodGroup.setBounds(41, 287, 155, 45);
		contentPane.add(lblBloodGroup);
		
		txtgroup = new JTextField();
		txtgroup.setEditable(false);
		txtgroup.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		txtgroup.setBounds(227, 287, 180, 36);
		contentPane.add(txtgroup);
		txtgroup.setColumns(10);
		
		JLabel lblType = new JLabel("TYPE");
		lblType.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblType.setBounds(456, 287, 73, 45);
		contentPane.add(lblType);
		
		txttype = new JTextField();
		txttype.setEditable(false);
		txttype.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		txttype.setBounds(528, 287, 180, 36);
		contentPane.add(txttype);
		txttype.setColumns(10);
		
		JButton btnDeleteFromRecord = new JButton("DELETE FROM RECORD");
		btnDeleteFromRecord.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
		btnDeleteFromRecord.setBounds(236, 454, 364, 82);
		btnDeleteFromRecord.addActionListener(this);
		contentPane.add(btnDeleteFromRecord);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblAddress.setBounds(41, 362, 207, 39);
		contentPane.add(lblAddress);
		
		txtaddress = new JTextField();
		txtaddress.setEditable(false);
		txtaddress.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		txtaddress.setBounds(227, 360, 481, 41);
		contentPane.add(txtaddress);
		txtaddress.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(deleteRd.class.getResource("/com/images/vector - Copy.jpg")));
		label.setBounds(749, 92, 650, 638);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(deleteRd.class.getResource("/com/images/Screenshot (18).png")));
		label_1.setBounds(41, 589, 667, 69);
		contentPane.add(label_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String caption=e.getActionCommand();
		String id=txtphone.getText();
		if(caption.equals("CHECK RECORD"))
		{
			if(id.isEmpty())
				JOptionPane.showMessageDialog(this, "Data Needed!");
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
						String eadd=rs.getString("Address");
						String egroup=rs.getString("BloodGroup");
						String etype=rs.getString("Type");
						txtaddress.setText(eadd);
						txtage.setText(eage);
						txtgroup.setText(egroup);
						txtname.setText(ename);
						txttype.setText(etype);
					}
					else {
						JOptionPane.showMessageDialog(this, "No Such Phone Number!");
						txtaddress.setText("");
						txtage.setText("");
						txtgroup.setText("");
						txtname.setText("");
						txtphone.setText("");
						txttype.setText("");
					}
				}
				catch(SQLException se)
				{
					System.out.println(se);
				}
			}
		}
		
		if(caption.equals("DELETE FROM RECORD"))
		{
			int option=JOptionPane.showConfirmDialog(this, "Are u sure u wish to delete record");
		    System.out.println(option);
		    if(option==0)
		    {
		      String strdelete="delete from donor_receiverdetails where PhoneNo=?";
		      try {
		    	  ps=con.prepareStatement(strdelete);
		    	  ps.setString(1, id);
		    	  int row=ps.executeUpdate();
		    	  if(row>0)
		    	  {
		    		  JOptionPane.showMessageDialog(this, "Record deleted successfully", "updation", JOptionPane.WARNING_MESSAGE);
		    	  }
		    	    txtaddress.setText("");
					txtage.setText("");
					txtgroup.setText("");
					txtname.setText("");
					txtphone.setText("");
					txttype.setText("");
		      }catch(SQLException se)
		      {
		    	  System.out.println(se);
		      }
		      
		    }
		}
		
	}
	
}
