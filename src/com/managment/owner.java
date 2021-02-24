package com.managment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class owner extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					owner frame = new owner();
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
	public owner() {
		setExtendedState(Frame.NORMAL);
		
		 createGui();
	}
public void createGui()
{
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setIconImage(Toolkit.getDefaultToolkit().getImage(owner.class.getResource("/com/images/blood-156063__340.png")));
	setTitle("OWNER\r\n");
	setBounds(100, 100, 1124, 737);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblBloodBankAnd = new JLabel("Blood Bank and \r\nManagment System ");
	lblBloodBankAnd.setForeground(Color.RED);
	lblBloodBankAnd.setFont(new Font("Tahoma", Font.BOLD, 50));
	lblBloodBankAnd.setBounds(49, 32, 1031, 119);
	contentPane.add(lblBloodBankAnd);
	
	JButton btnUpdateDetails = new JButton("UPDATE DETAILS");
	btnUpdateDetails.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnUpdateDetails.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	btnUpdateDetails.setBounds(402, 161, 233, 84);
	btnUpdateDetails.addActionListener(this);
	contentPane.add(btnUpdateDetails);
	
	JButton btnCreateAccount = new JButton("CREATE ACCOUNT");
	btnCreateAccount.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	btnCreateAccount.setBounds(98, 161, 233, 84);
	btnCreateAccount.addActionListener(this);
	contentPane.add(btnCreateAccount);
	
	JButton btnDeleteAccount = new JButton("DELETE ACCOUNT");
	btnDeleteAccount.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	btnDeleteAccount.setBounds(98, 284, 233, 84);
	btnDeleteAccount.addActionListener(this);
	contentPane.add(btnDeleteAccount);
	
	JButton btnReport = new JButton("REPORT");
	btnReport.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	btnReport.setBounds(402, 284, 233, 84);
	btnReport.addActionListener(this);
	contentPane.add(btnReport);
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon(owner.class.getResource("/com/images/Screenshot (4).png")));
	label.setBounds(673, 171, 364, 499);
	contentPane.add(label);
	
	JLabel label_1 = new JLabel("");
	label_1.setIcon(new ImageIcon(owner.class.getResource("/com/images/2.jpg")));
	label_1.setBounds(98, 400, 537, 288);
	contentPane.add(label_1);
	
	}

@Override
public void actionPerformed(ActionEvent ae) {
	
	String caption=ae.getActionCommand();
	
	if(caption.equals("CREATE ACCOUNT"))
	{
	 newWorker emp=new newWorker();
		emp.setVisible(true);
		
	}
	
	else if(caption.equals("UPDATE DETAILS"))
	{
	 updateWorker emp=new updateWorker();
		emp.setVisible(true);
	}
	else if(caption.equals("DELETE ACCOUNT"))
		{
		 delWorker emp=new delWorker();
			emp.setVisible(true);
		
	}
	else if(caption.equals("REPORT"))
	{
		ViewData a=new ViewData();
		a.setVisible(true);
	}
	
}
}
