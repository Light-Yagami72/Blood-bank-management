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
import java.awt.Frame;
public class ViewDonrec extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JTable emptable;
	private Connection con;
	private PreparedStatement pscount,psdata;
	private ResultSet rscount,rsdata;

	
	String[]colNames= {"Name","Type"};
	String [][]data;//? null
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDonrec frame = new ViewDonrec();
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
	public ViewDonrec() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("DONOR_&_RECEIVER\r\n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewDonrec.class.getResource("/com/images/blood-156063__340.png")));
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
				
				data=new String[rowcnt][2];//double dmesion array create
				
			}
			
		String strsql="select Name,Type from donor_receiverdetails";
		psdata=con.prepareStatement(strsql);
			int row=0;
			rsdata=psdata.executeQuery();
			while(rsdata.next())
			{
				
				String name=rsdata.getString("Name");
				String type=rsdata.getString("Type");
				
				
				data[row][0]=name;
				data[row][1]=type;

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
		setBounds(100, 100, 1392, 882);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(105, 212, 1309, 574);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		
		JLabel lblBloodBankAnd = new JLabel("Blood Bank and \r\nManagment System ");
		lblBloodBankAnd.setForeground(Color.RED);
		lblBloodBankAnd.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblBloodBankAnd.setBounds(308, 0, 922, 98);
		contentPane.add(lblBloodBankAnd);
		
		 table = new JTable();
			table.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
			table.setForeground(Color.black);
		
		JTableHeader header =table.getTableHeader();
	      header.setBackground(Color.white);
	      header.setForeground(Color.black);
	      header.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 25));
		
	     
	      
		JButton btnShow = new JButton("SHOW");
		btnShow.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
		btnShow.setBounds(563, 108, 296, 84);
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
