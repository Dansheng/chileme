package com.clm.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textWorkId;
	private JTextField textWorkName;
	private JTextField textWorkPosition;
	private JTextField textWorkTel;
	private JTextField textWorkEmail;
	private JTextField textWorkPassword;
	private JTextField textWorkConfirmPassword;

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
		setBounds(100, 100, 350, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textWorkId = new JTextField();
		textWorkId.setBounds(170, 6, 130, 26);
		panel.add(textWorkId);
		textWorkId.setColumns(10);
		
		textWorkName = new JTextField();
		textWorkName.setBounds(170, 58, 130, 26);
		panel.add(textWorkName);
		textWorkName.setColumns(10);
		
		textWorkPosition = new JTextField();
		textWorkPosition.setBounds(170, 91, 130, 26);
		panel.add(textWorkPosition);
		textWorkPosition.setColumns(10);
		
		textWorkTel = new JTextField();
		textWorkTel.setBounds(170, 137, 130, 26);
		panel.add(textWorkTel);
		textWorkTel.setColumns(10);
		
		textWorkEmail = new JTextField();
		textWorkEmail.setBounds(170, 165, 130, 26);
		panel.add(textWorkEmail);
		textWorkEmail.setColumns(10);
		
		textWorkPassword = new JTextField();
		textWorkPassword.setBounds(170, 231, 130, 26);
		panel.add(textWorkPassword);
		textWorkPassword.setColumns(10);
		
		textWorkConfirmPassword = new JTextField();
		textWorkConfirmPassword.setBounds(170, 275, 130, 26);
		panel.add(textWorkConfirmPassword);
		textWorkConfirmPassword.setColumns(10);
		
		JLabel labelWorkId = new JLabel("员工编号");
		labelWorkId.setBounds(74, 11, 61, 16);
		panel.add(labelWorkId);
		
		JLabel labelWorkName = new JLabel("姓名");
		labelWorkName.setBounds(74, 63, 61, 16);
		panel.add(labelWorkName);
		
		JLabel labelWorkPosition = new JLabel("职位");
		labelWorkPosition.setBounds(74, 96, 61, 16);
		panel.add(labelWorkPosition);
		
		JLabel labelWorkTel = new JLabel("电话");
		labelWorkTel.setBounds(74, 142, 61, 16);
		panel.add(labelWorkTel);
		
		JLabel labelWorkEmail = new JLabel("邮箱");
		labelWorkEmail.setBounds(74, 170, 61, 16);
		panel.add(labelWorkEmail);
		
		JLabel labelWorkPassword = new JLabel("密码");
		labelWorkPassword.setBounds(74, 236, 61, 16);
		panel.add(labelWorkPassword);
		
		JLabel labelWorkConfirmPassword = new JLabel("确认密码");
		labelWorkConfirmPassword.setBounds(74, 280, 61, 16);
		panel.add(labelWorkConfirmPassword);
		
		
		
		JButton buttonSignUp = new JButton("注册");
		buttonSignUp.setBounds(103, 357, 117, 29);
		panel.add(buttonSignUp);
	}

}
