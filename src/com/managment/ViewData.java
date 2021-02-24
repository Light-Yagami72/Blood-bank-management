package com.managment;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.*;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
public class ViewData extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewData frame = new ViewData();
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
	public ViewData() {
		setTitle("VIEW REPORTS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewData.class.getResource("/com/images/blood-156063__340.png")));
		createGui();
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1286, 793);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewDetails = new JButton("BLOODBAGS");
		btnViewDetails.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		btnViewDetails.setBounds(34, 378, 488, 82);
		btnViewDetails.addActionListener(this);
		contentPane.add(btnViewDetails);
		
		JButton btnDonorReceivers = new JButton("ALL DONOR & RECEIVERS");
		btnDonorReceivers.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		btnDonorReceivers.setBounds(34, 261, 488, 82);
		btnDonorReceivers.addActionListener(this);
		contentPane.add(btnDonorReceivers);
		
		JButton btnDonorReceiverDetails = new JButton("DONOR RECEIVER DETAILS (sorted)");
		btnDonorReceiverDetails.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		btnDonorReceiverDetails.setBounds(34, 145, 488, 82);
		btnDonorReceiverDetails.addActionListener(this);
		contentPane.add(btnDonorReceiverDetails);
		
		JLabel lblViewDetails = new JLabel("BLOOD BANK MANAGMENT SYSTEM");
		lblViewDetails.setForeground(Color.RED);
		lblViewDetails.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		lblViewDetails.setBounds(109, 27, 1063, 71);
		contentPane.add(lblViewDetails);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewData.class.getResource("/com/images/bloodreport1.jpg")));
		label.setBounds(554, 148, 696, 490);
		contentPane.add(label);
		
		JButton btnSpecificDonor = new JButton("SPECIFIC DONOR");
		btnSpecificDonor.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		btnSpecificDonor.setBounds(34, 494, 488, 82);
		btnSpecificDonor.addActionListener(this);
		contentPane.add(btnSpecificDonor);
		
		JButton btnSpecificReceiver = new JButton("SPECIFIC RECEIVER");
		btnSpecificReceiver.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		btnSpecificReceiver.setBounds(34, 611, 488, 82);
		btnSpecificReceiver.addActionListener(this);
		contentPane.add(btnSpecificReceiver);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String caption=e.getActionCommand();
		if(caption.equals("BLOODBAGS"))
			{ViewBloodBags blood=new ViewBloodBags();
			blood.setVisible(true);
			}
			
		else if(caption.equals("ALL DONOR & RECEIVERS"))
			{ViewDonrec blood=new ViewDonrec();
		blood.setVisible(true);
			}
		else if(caption.equals("DONOR RECEIVER DETAILS (sorted)"))
		{ViewDetailsbd blood=new ViewDetailsbd();
	blood.setVisible(true);
		}
		else if(caption.equals("SPECIFIC DONOR"))
		{ViewBDD blood=new ViewBDD();
	blood.setVisible(true);
		}
		else if(caption.equals("SPECIFIC RECEIVER"))
		{ViewBRD blood=new ViewBRD();
	blood.setVisible(true);
		}
		
	}
	}

