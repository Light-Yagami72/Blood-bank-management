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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SystemColor;

public class worker extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					worker frame = new worker();
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
	public worker() {
		
		
		setExtendedState(Frame.NORMAL);
		createGui();
	}
 public void createGui() {
	 
	 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(worker.class.getResource("/com/images/blood-156063__340.png")));
		setTitle("Worker\r\n");
		setBounds(100, 100, 999, 689);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(169, 169, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBloodBankAnd = new JLabel("Blood Bank and \r\nManagment System ");
		lblBloodBankAnd.setForeground(new Color(153, 0, 0));
		lblBloodBankAnd.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblBloodBankAnd.setBounds(17, 0, 958, 98);
		contentPane.add(lblBloodBankAnd);
		
		JButton btnReceiptants = new JButton("DONORS___RECEIPTANTS");
		btnReceiptants.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnReceiptants.setBounds(68, 100, 574, 84);
		btnReceiptants.addActionListener(this);
		contentPane.add(btnReceiptants);
		
		JButton btnBloodbags = new JButton("BLOODBAGS");
		btnBloodbags.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnBloodbags.setBounds(68, 225, 235, 77);
		btnBloodbags.addActionListener(this);
		contentPane.add(btnBloodbags);
		
		JButton btnReport = new JButton("REPORT");
		btnReport.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnReport.setBounds(382, 225, 260, 77);
		btnReport.addActionListener(this);
		contentPane.add(btnReport);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(worker.class.getResource("/com/images/3.jpg")));
		label.setBounds(697, 108, 227, 477);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(worker.class.getResource("/com/images/4354E54E54.png")));
		label_1.setBounds(35, 337, 629, 248);
		contentPane.add(label_1);
		
}

@Override
public void actionPerformed(ActionEvent e) {
	String caption=e.getActionCommand();
	if(caption.equals("DONORS___RECEIPTANTS"))
	{
		donorIntro a=new donorIntro();
		a.setVisible(true);
		
	}
	else if(caption.equals("REPORT"))
	{
		ViewData a=new ViewData();
		a.setVisible(true);
	}
	else if(caption.equals("BLOODBAGS"))
	{
		ViewBloodBags a=new ViewBloodBags();
		a.setVisible(true);
		
	}
}
}
