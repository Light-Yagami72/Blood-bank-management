package com.managment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dbutils.CrudOperation;

import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.sql.*;
import java.awt.event.*;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
public class ViewBloodBags extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private Connection con;
	private PreparedStatement pscount,psdata;
	private ResultSet rscount,rsdata;
	private String bdtype;

	
	String[]colNames= {"BloodGroup","No_of_bags"};
	String [][]data;//? null
	private JScrollPane scrollPane;
	private JComboBox comboBox;
	private JLabel label;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBloodBags frame = new ViewBloodBags();
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
	public ViewBloodBags() {
		setTitle("BLOOD_BAG_COUNT");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewBloodBags.class.getResource("/com/images/blood-156063__340.png")));
		con=CrudOperation.createConnection();
		createGui();
		
	}
	
	public void  populateArray()
	{
		try {
			int rowcnt=0;
			String strcount="select count(*) from bloodbags";
			pscount=con.prepareStatement(strcount);
			rscount=pscount.executeQuery();
			if(rscount.next())
			{
				rowcnt=rscount.getInt(1);
				System.out.println(rowcnt);
				
				data=new String[rowcnt][2];//double dmesion array create
				
			}
			
		String strsql="select * from bloodbags where BloodGroup=?";
		psdata=con.prepareStatement(strsql);
		psdata.setString(1, bdtype);
			int row=0;
			rsdata=psdata.executeQuery();
			while(rsdata.next())
			{
				
				String bd=rsdata.getString("BloodGroup");
				String no=rsdata.getString("NoOfBags");
				
				
				data[row][0]=bd;
				data[row][1]=no;

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
		setBounds(100, 100, 1014, 614);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 257, 648, 295);
		contentPane.add(scrollPane);
		
		table = new JTable();
		

		JLabel lblViewDetails = new JLabel("BLOOD BANK MANAGMENT SYSTEM");
		lblViewDetails.setForeground(Color.RED);
		lblViewDetails.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		lblViewDetails.setBounds(31, 31, 1063, 71);
		contentPane.add(lblViewDetails);
		
		JButton btnShow = new JButton("show");
		btnShow.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 21));
		btnShow.setBounds(381, 129, 238, 71);
		btnShow.addActionListener(this);
		contentPane.add(btnShow);
		
		comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.inactiveCaptionBorder);
		comboBox.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Blood Group", "A+", "B+", "AB+", "O+", "A-", "B-", "AB-", "O-"}));
		comboBox.setBounds(102, 136, 238, 57);
		contentPane.add(comboBox);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(ViewBloodBags.class.getResource("/com/images/bag23.jpg")));
		label.setBounds(668, 112, 322, 465);
		contentPane.add(label);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

		 bdtype =(String)comboBox.getSelectedItem();
		if(bdtype.equals("Blood Group"))
		{
			
			JOptionPane.showMessageDialog(this, "pls select valid blood group");
		}
		
		 populateArray();//data populate
	    table.setModel(new DefaultTableModel(data,colNames)  );
	     
	     
		scrollPane.setViewportView(table);
	}
}
