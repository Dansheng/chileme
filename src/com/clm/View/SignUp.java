package com.clm.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
		setSize(800,200);
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
		textField.setBounds(170, 6, 130, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(170, 44, 130, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("员工编号");
		label.setBounds(112, 11, 61, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("姓名");
		label_1.setBounds(112, 49, 61, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("职位");
		label_2.setBounds(112, 82, 61, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("电话");
		label_3.setBounds(112, 110, 61, 16);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("邮箱");
		label_4.setBounds(112, 138, 61, 16);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("工资卡号");
		label_5.setBounds(112, 166, 61, 16);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("密码");
		label_6.setBounds(112, 194, 61, 16);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("确认密码");
		label_7.setBounds(112, 222, 61, 16);
		panel.add(label_7);
		
		textField_2 = new JTextField();
		textField_2.setBounds(170, 77, 130, 26);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(170, 110, 130, 26);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(170, 138, 130, 26);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(170, 161, 130, 26);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(170, 189, 130, 26);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(170, 222, 130, 26);
		panel.add(textField_7);
		textField_7.setColumns(10);
	}

}
