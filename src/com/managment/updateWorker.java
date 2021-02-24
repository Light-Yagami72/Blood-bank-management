package com.managment;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.*;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
 
public class updateWorker extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Connection con;
	private PreparedStatement pssearch,psupdate;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtphone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateWorker frame = new updateWorker();
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
	public updateWorker() {
		setBackground(Color.RED);
		setForeground(Color.WHITE);
		con=CrudOperation.createConnection();
		setIconImage(Toolkit.getDefaultToolkit().getImage(updateWorker.class.getResource("/com/images/blood-156063__340.png")));
		createGui();
		
	}
    public void createGui()
  {
	setTitle("UPDATE WORKER DETAILS");
	
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 1170, 786);
	contentPane = new JPanel();
	contentPane.setForeground(new Color(255, 0, 0));
	contentPane.setBackground(new Color(240, 255, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblBloodBankAnd = new JLabel("Blood Bank and \r\nManagment System ");
	lblBloodBankAnd.setBackground(new Color(255, 0, 0));
	lblBloodBankAnd.setForeground(new Color(255, 0, 0));
	lblBloodBankAnd.setFont(new Font("Tahoma", Font.BOLD, 50));
	lblBloodBankAnd.setBounds(83, 0, 1031, 83);
	contentPane.add(lblBloodBankAnd);	
	
	JLabel lblWorkerId = new JLabel("WORKER ID");
	lblWorkerId.setForeground(new Color(0, 0, 0));
	lblWorkerId.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
	lblWorkerId.setBounds(69, 111, 160, 43);
	contentPane.add(lblWorkerId);
	
	txtid = new JTextField();
	txtid.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	txtid.setBackground(new Color(248, 248, 255));
	txtid.setForeground(new Color(0, 0, 0));
	txtid.setBounds(258, 116, 172, 43);
	contentPane.add(txtid);
	txtid.setColumns(10);
	
	JLabel lblName = new JLabel("NAME");
	lblName.setForeground(new Color(0, 0, 0));
	lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
	lblName.setBounds(69, 255, 111, 43);
	contentPane.add(lblName);
	
	txtname = new JTextField();
	txtname.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
	txtname.setBackground(new Color(248, 248, 255));
	txtname.setBounds(258, 259, 172, 46);
	contentPane.add(txtname);
	txtname.setColumns(10);
	
	JLabel lblPhoneNo = new JLabel("PHONE NO.");
	lblPhoneNo.setForeground(new Color(0, 0, 0));
	lblPhoneNo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	lblPhoneNo.setBounds(63, 336, 143, 33);
	contentPane.add(lblPhoneNo);
	
	JButton btnupdate = new JButton("UPDATE");
	btnupdate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnupdate.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
	btnupdate.setBounds(109, 400, 219, 53);
	btnupdate.addActionListener(this);
	contentPane.add(btnupdate);
	
	txtphone = new JTextField();
	txtphone.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
	txtphone.setBackground(new Color(248, 248, 255));
	txtphone.setBounds(253, 334, 177, 46);
	contentPane.add(txtphone);
	txtphone.setColumns(10);
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon(updateWorker.class.getResource("/com/images/SAMPLE - Copy1.jpg")));
	label.setBounds(464, 115, 682, 592);
	contentPane.add(label);
	
	JButton btnCheckRecord = new JButton("CHECK RECORD");
	btnCheckRecord.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnCheckRecord.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
	btnCheckRecord.setBounds(69, 175, 351, 59);
	btnCheckRecord.addActionListener(this);
	contentPane.add(btnCheckRecord);
	
	JLabel label_1 = new JLabel("");
	label_1.setIcon(new ImageIcon(updateWorker.class.getResource("/com/images/AB-1.png")));
	label_1.setBounds(138, 448, 219, 222);
	contentPane.add(label_1);
}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String caption=e.getActionCommand();
		String id=txtid.getText();
		
		if(caption.equals("CHECK RECORD"))
		{
			if(id.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Enter ID Sir!!!");
			}
				else
			{
				String strsql="select  * from workerdetails where WorkerId=?";
				try{
					pssearch=con.prepareStatement(strsql);
					pssearch.setString(1, id);
					ResultSet rs=pssearch.executeQuery();
						if(rs.next())//record exists
						{
							String ename=rs.getString("Name");
							String ephone=rs.getString("PhoneNo");
							txtphone.setText(ephone);
							txtname.setText(ename);
				        }
						else
						{
			JOptionPane.showMessageDialog(this, "No Such ID");
						}
				}
						catch(SQLException se)
						{
						System.out.println(se);	
						}
		            }
		  }
			if(caption.equals("UPDATE"))
			{
			String phone=txtphone.getText();
			String name=txtname.getText();
			
			try
			{
				String strupdate="update workerdetails set name=?,PhoneNo=? where WorkerId=?";
				psupdate=con.prepareStatement(strupdate);
				
				psupdate.setString(1,name);
			
				psupdate.setString(2, phone);
				psupdate.setString(3, id);
				int row=psupdate.executeUpdate();
				if(row>0)
				{
					JOptionPane.showMessageDialog(this, "REcord updated", "updation", JOptionPane.WARNING_MESSAGE);
				}
				txtid.setText("");
				txtname.setText("");
				txtphone.setText("");
			}catch(SQLException se)
			{
				System.out.println(se);
			}
			
			}
			}
}
