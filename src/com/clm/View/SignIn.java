package com.clm.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.clm.Controller.Controller;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
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
	public SignIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setText("请输入账号");
		textField.setBounds(185, 54, 130, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("请输入密码");
		textField_1.setBounds(185, 112, 130, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("员工编号");
		label.setBounds(121, 59, 52, 16);
		panel.add(label);
		
		JLabel lblMiMa = new JLabel("密码");
		lblMiMa.setBounds(121, 117, 33, 16);
		panel.add(lblMiMa);
		
		JButton buttonSignIn = new JButton("登录");
		buttonSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller controller = Controller.getInstance();
				controller.login(Integer.parseInt(textField.getText()),textField_1.getText());
			}
		});
		buttonSignIn.setBounds(137, 171, 117, 29);
		panel.add(buttonSignIn);
		
		JButton buttonSignUp = new JButton("注册");
		buttonSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonSignUp.setBounds(253, 171, 61, 26);
		panel.add(buttonSignUp);
	}

}
