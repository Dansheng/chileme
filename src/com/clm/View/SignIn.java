package com.clm.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.clm.Controller.Controller;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class SignIn extends JFrame{

	private JPanel contentPane;
	private JTextField textWorkId;
	private JTextField textPassword;

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
		
		textWorkId = new JTextField();
		textWorkId.setBounds(185, 54, 130, 26);
		panel.add(textWorkId);
		textWorkId.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(185, 112, 130, 26);
		panel.add(textPassword);
		textPassword.setColumns(10);
		
		JLabel labelWordId = new JLabel("员工编号");
		labelWordId.setBounds(121, 59, 52, 16);
		panel.add(labelWordId);
		
		JLabel labelPassword = new JLabel("密码");
		labelPassword.setBounds(121, 117, 33, 16);
		panel.add(labelPassword);
		
		
		JLabel labType = new JLabel("登录身份");
		labType.setBounds(121, 166, 61, 16);
		panel.add(labType);
		
		JComboBox<String> textType = new JComboBox<String>();
		textType.setBounds(185, 162, 130, 26);
		panel.add(textType);
		textType.addItem("普通员工");
		textType.addItem("餐厅员工");
		textType.addItem("管理员");
		
		JButton buttonSignIn = new JButton("登录");
		buttonSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller controller = Controller.getInstance();
				HashMap<String,Integer> result = controller.login(Integer.parseInt(textWorkId.getText()),textPassword.getText(),textType.getSelectedItem().toString());	
				int a = result.get("data");
				System.out.println(a);
				if(a == -1) {//用户不存在
					JOptionPane.showMessageDialog(buttonSignIn,"请先注册","提示",JOptionPane.PLAIN_MESSAGE);
					clickSignUpBtn();
				}
				else if(a == 0) {//密码错误
					JOptionPane.showMessageDialog(buttonSignIn,"密码错误","提示",JOptionPane.PLAIN_MESSAGE);
				}
				else if(a == 1) {//普通员工
					clickSignInBtn1();
				}
				else if(a == 2) {//餐厅员工
					clickSignInBtn2();
				}
				else if(a ==3) {//管理员
					clickSignInBtn3();
				}
				else if(a ==4) {//身份不符
					JOptionPane.showMessageDialog(buttonSignIn,"身份不符，请重新选择身份","提示",JOptionPane.PLAIN_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(buttonSignIn,"哦哦，出现不明错误","提示",JOptionPane.PLAIN_MESSAGE);
				}
				
			}
		});
				
		buttonSignIn.setBounds(138, 216, 117, 29);
		panel.add(buttonSignIn);
		
		JButton buttonSignUp = new JButton("注册");
		buttonSignUp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				clickSignUpBtn();
			}
		});
		
		buttonSignUp.setBounds(254, 216, 61, 26);
		panel.add(buttonSignUp);

	}

	public void clickSignInBtn1() {//登录普通员工
		new SelectDishes().setVisible(true);
		this.dispose();
	}
	public void clickSignInBtn2() {//餐厅员工登录
		
	}
	public void clickSignInBtn3() {//管理员登录
		new ManageDishes().setVisible(true);
		this.dispose();
	}
	public void clickSignUpBtn() {//注册
		new SignUp().setVisible(true);
		this.dispose();
	}
	
}
