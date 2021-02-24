package com.managment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class donorIntro extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					donorIntro frame = new donorIntro();
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
	public donorIntro() {
		createGui();
	}
  public void createGui() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(donorIntro.class.getResource("/com/images/blood-156063__340.png")));
		
		setTitle("DONOR_RECEIVER");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1168, 651);
		
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBox.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBloodBankAnd = new JLabel("Blood Bank and \r\nManagment System ");
		lblBloodBankAnd.setForeground(Color.RED);
		lblBloodBankAnd.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblBloodBankAnd.setBounds(152, -16, 922, 98);
		contentPane.add(lblBloodBankAnd);
		
		JButton btnCreateAccount = new JButton("CREATE ACCOUNT");
		btnCreateAccount.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnCreateAccount.setBounds(136, 99, 247, 84);
		btnCreateAccount.addActionListener(this);
		contentPane.add(btnCreateAccount);
		
		JButton btnUpdateDetails = new JButton("UPDATE DETAILS");
		btnUpdateDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdateDetails.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnUpdateDetails.setBounds(462, 99, 247, 84);
		btnUpdateDetails.addActionListener(this);
		contentPane.add(btnUpdateDetails);
		
		JButton btnDeleteAccount = new JButton("DELETE ACCOUNT");
		btnDeleteAccount.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnDeleteAccount.setBounds(787, 99, 247, 84);
		btnDeleteAccount.addActionListener(this);
		
		contentPane.add(btnDeleteAccount);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(donorIntro.class.getResource("/com/images/DONOR_RECEIVER.png")));
		label.setBounds(10, 208, 1144, 406);
		contentPane.add(label);
}

@Override
public void actionPerformed(ActionEvent e) {
	String caption=e.getActionCommand();
	if(caption.equals("CREATE ACCOUNT"))
	{
		donorReceiver a=new donorReceiver();
		a.setVisible(true);
		
	}
	else if(caption.equals("UPDATE DETAILS"))
	{
		updateRD rd=new updateRD();
		rd.setVisible(true);
	}
	else
	{
		deleteRd rd= new deleteRd();
		rd.setVisible(true);
	}
}
}
