package com.managment;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.ImageIcon;

public class welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcome frame = new welcome();
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
	public welcome() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		createGui();
		loadFrame();
	}
	
	public void loadFrame() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(2500);
					Login login=new Login(); 
					login.setVisible(true);
					welcome.this.dispose();
					
					}catch(InterruptedException e)
					{
						e.printStackTrace();;
					}
			
			
		}
		}).start();
	}
	
public void createGui() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1550, 875);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(128, 0, 0));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblWelcomeToSwing = new JLabel("WELCOME TO \r\nBLOOD BANK MANAGMENT SYSTEM");
	lblWelcomeToSwing.setBackground(new Color(176, 224, 230));
	lblWelcomeToSwing.setForeground(new Color(176, 224, 230));
	lblWelcomeToSwing.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 44));
	lblWelcomeToSwing.setBounds(154, 10, 1294, 97);
	contentPane.add(lblWelcomeToSwing);
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon(welcome.class.getResource("/com/images/og.jpg")));
	
	label.setBounds(-14, 106, 1550, 700);
	contentPane.add(label);
}
}
