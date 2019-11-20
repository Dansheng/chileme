package com.clm.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField workIdInput;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		workIdInput = new JTextField();
		workIdInput.setBounds(161, 39, 120, 30);
		workIdInput.setText("ID");
		panel.add(workIdInput);
		workIdInput.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("password");
		txtPassword.setBounds(159, 91, 120, 30);
		panel.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton button = new JButton("注册");
		button.setBounds(155, 211, 105, 25);
		panel.add(button);
		
		JLabel label = new JLabel("员工号");
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(81, 46, 70, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(81, 98, 70, 15);
		panel.add(label_1);
	}
}
