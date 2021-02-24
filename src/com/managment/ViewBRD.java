package com.managment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dbutils.CrudOperation;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.*;

import java.sql.*;
import javax.swing.JScrollPane;
import java.awt.Frame;
import java.awt.Toolkit;
public class ViewBRD extends JFrame  implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private PreparedStatement pscount,psdata;
	private ResultSet rscount,rsdata;
	private JTable table;
	private Connection con;
	private String phone;
	
	String[] colname= {"SerialNo","PhoneNo","Date","Blood Group","No. of Bags"};
	String [][]data;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBRD frame = new ViewBRD();
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
	public ViewBRD() {
		setTitle("BLOOD REQUEST DETAILS\r\n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewBRD.class.getResource("/com/images/blood-156063__340.png")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		con=CrudOperation.createConnection();
		createGui();
		
	}
	public void  populateArray()
	{
		try {
			int rowcnt=0;
			String strcount="select count(*) from bloodrequestdetails";
			pscount=con.prepareStatement(strcount);
			rscount=pscount.executeQuery();
			if(rscount.next())
			{
				rowcnt=rscount.getInt(1);
				System.out.println(rowcnt);
				
				data=new String[rowcnt][8];//double dmesion array create
				
			}
			
			
			
			
		String strsql="select * from bloodrequestdetails where PhoneNo=? ";
		psdata=con.prepareStatement(strsql);
		psdata.setString(1, phone);	
		int row=0;
			rsdata=psdata.executeQuery();
			while(rsdata.next())
			{
				String phonen=rsdata.getString("PhoneNo");
				String serial=rsdata.getString("SerialNo");
				String bags=rsdata.getString("NoOfBags");
				String date=rsdata.getString("Date");
				String bg=rsdata.getString("BloodGroup");
				
				
				data[row][0]=serial;
				data[row][1]=phonen;
				data[row][2]=date;
				data[row][3]=bg;
				data[row][4]=bags;

				row++;
				
			
				
			}
	
			
					
		}
		catch(SQLException se)
		{
			
			System.out.println(se);
		}
		
		
	}

public void createGui()
{
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 1536,850);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(240, 255, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	getContentPane().setLayout(null);
	contentPane.setLayout(null);
	
	JLabel lblBloodBankAnd = new JLabel("Blood Bank and \r\nManagment System ");
	lblBloodBankAnd.setForeground(Color.RED);
	lblBloodBankAnd.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
	lblBloodBankAnd.setBounds(302, -1, 922, 98);
	contentPane.add(lblBloodBankAnd);
	
	textField = new JTextField();
	textField.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
	textField.setBounds(601, 108, 211, 36);
	getContentPane().add(textField);
	textField.setColumns(10);
	
	JLabel lblPhoneNo = new JLabel("PHONE NO");
	lblPhoneNo.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
	lblPhoneNo.setBounds(373, 107, 149, 36);
	getContentPane().add(lblPhoneNo);
	
	JButton btnSearch = new JButton("SEARCH");
	btnSearch.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
	btnSearch.setBounds(944, 94, 225, 63);
	btnSearch.addActionListener(this);
	getContentPane().add(btnSearch);
	
	scrollPane = new JScrollPane();
	scrollPane.setBounds(67, 183, 778, 600);
	getContentPane().add(scrollPane);
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon(ViewBDD.class.getResource("/com/images/brain.jpg")));
	label.setBounds(924, 199, 508, 600);
	contentPane.add(label);
	
	table = new JTable();
	table = new JTable();
	table.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
	table.setForeground(Color.black);
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	phone =textField.getText().trim();
		if(phone.isEmpty())
		{
			
			JOptionPane.showMessageDialog(this, "pls enter phone no");
		}
		
		
		 populateArray();//data populate
	    table.setModel(new DefaultTableModel(data,colname)  );
	     
	    scrollPane.setViewportView(table);
	
}
}
