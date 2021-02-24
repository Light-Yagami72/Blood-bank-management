package com.managment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.dbutils.CrudOperation;

import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.sql.*;
import java.awt.event.*;
import javax.swing.JTable;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Frame;
public class viewRd extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private Connection con;
	private PreparedStatement pscount,psdata;
	private ResultSet rscount,rsdata;

	
	String[]colNames= {"BloodGroup","Name","Email","Address","Age","Gender","PhoneNo","Type"};
	String [][]data;//? null
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewRd frame = new viewRd();
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
	public viewRd() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("DONOR_&_RECEIVER_DETAILS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(viewRd.class.getResource("/com/images/blood-156063__340.png")));
		con=CrudOperation.createConnection();
		createGui();
		
	}
	
	public void  populateArray()
	{
		try {
			int rowcnt=0;
			String strcount="select count(*) from donor_receiverdetails";
			pscount=con.prepareStatement(strcount);
			rscount=pscount.executeQuery();
			if(rscount.next())
			{
				rowcnt=rscount.getInt(1);
				System.out.println(rowcnt);
				
				data=new String[rowcnt][8];//double dmesion array create
				
			}
			
			
			
			
		String strsql="select * from donor_receiverdetails order by BloodGroup ";
		psdata=con.prepareStatement(strsql);
			int row=0;
			rsdata=psdata.executeQuery();
			while(rsdata.next())
			{
				String phone=rsdata.getString("Phoneno");
				String name=rsdata.getString("Name");
				String email=rsdata.getString("Email");
				String add=rsdata.getString("Address");
				String age=rsdata.getString("Age");
				String gen=rsdata.getString("Gender");
				String bg=rsdata.getString("BloodGroup");
				String type=rsdata.getString("Type");
				
				
				data[row][0]=bg;
				data[row][1]=name;
				data[row][2]=email;
				data[row][3]=add;
				data[row][4]=age;
				data[row][5]=gen;
				data[row][6]=phone;
				data[row][7]=type;

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
		setBounds(100, 100, 1550, 856);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 228, 1420, 565);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table = new JTable();
		table.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
		table.setForeground(Color.black);
		
		JLabel lblBloodBankAnd = new JLabel("Blood Bank and \r\nManagment System ");
		lblBloodBankAnd.setForeground(Color.RED);
		lblBloodBankAnd.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblBloodBankAnd.setBounds(202, 0, 922, 98);
		contentPane.add(lblBloodBankAnd);
		
		JTableHeader header =table.getTableHeader();
	      header.setBackground(Color.white);
	      header.setForeground(Color.black);
	      header.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 20));
		
		
		
		JButton btnShow = new JButton("SHOW");
		btnShow.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
		btnShow.setBounds(542, 108, 287, 76);
		btnShow.addActionListener(this);
		contentPane.add(btnShow);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 populateArray();//data populate
	    table.setModel(new DefaultTableModel(data,colNames)  );
	     
	     
		scrollPane.setViewportView(table);
	}
}
