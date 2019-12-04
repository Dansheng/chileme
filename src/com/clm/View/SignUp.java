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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.util.regex.*;
public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textWorkId;
	private JTextField textName;
	private JTextField textPhoneNumber;
	private JTextField textEmail;
	private JTextField textPassword;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textWorkId = new JTextField();
		textWorkId.setBounds(152, 36, 130, 26);
		panel.add(textWorkId);
		textWorkId.setColumns(10);
		
		textName = new JTextField();
		textName.setBounds(152, 79, 130, 26);
		panel.add(textName);
		textName.setColumns(10);
		
		textPhoneNumber = new JTextField();
		textPhoneNumber.setBounds(152, 165, 130, 26);
		panel.add(textPhoneNumber);
		textPhoneNumber.setColumns(10);

		
		textEmail = new JTextField();
		textEmail.setBounds(152, 208, 130, 26);
		panel.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel labelWorkId = new JLabel("员工编号");
		labelWorkId.setBounds(51, 41, 52, 16);
		panel.add(labelWorkId);
		
		JLabel labelName = new JLabel("姓名");
		labelName.setBounds(78, 84, 26, 16);
		panel.add(labelName);
		
		JLabel labelPosition = new JLabel("职位");
		labelPosition.setBounds(77, 127, 26, 16);
		panel.add(labelPosition);
		
		JLabel labelPhoneNumber = new JLabel("电话");
		labelPhoneNumber.setBounds(77, 170, 26, 16);
		panel.add(labelPhoneNumber);
		
		JLabel labelEmail = new JLabel("邮箱");
		labelEmail.setBounds(77, 213, 26, 16);
		panel.add(labelEmail);
		
		JLabel labelPassword = new JLabel("密码");
		labelPassword.setBounds(77, 256, 26, 16);
		panel.add(labelPassword);
		
		JComboBox<String> textPosition = new JComboBox<String>();
		textPosition.setBounds(152, 122, 136, 27);
		panel.add(textPosition);
		textPosition.addItem("普通员工");
		textPosition.addItem("餐厅员工");
		textPosition.addItem("管理员");
		
		JButton buttonSignUp = new JButton("注册");
		buttonSignUp.addActionListener(new ActionListener() {
			int sum = 0;
			public void actionPerformed(ActionEvent e) {
				Controller controller = Controller.getInstance();
				int a = Verification();
				if(a==5) {
					controller.register(Integer.parseInt(textWorkId.getText()), textName.getText(), textPosition.getSelectedItem().toString(), textPhoneNumber.getText(), textEmail.getText(), textPassword.getText());
					clickSignUpBtn();
				}
				
			}
			
		});
	
		buttonSignUp.setBounds(104, 309, 117, 29);
		panel.add(buttonSignUp);
		
		textPassword = new JTextField();
		textPassword.setBounds(152, 251, 130, 26);
		panel.add(textPassword);
		textPassword.setColumns(10);

	}

	public void clickSignUpBtn() {
		this.setVisible(false);
		new SignIn().setVisible(true);
	}
	
	
	//表单验证
	public int Verification(){
		int sum = 0;
		//员工编号
		if(textWorkId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(textWorkId,"员工编号不可为空","提示",JOptionPane.PLAIN_MESSAGE);
			return sum;
		}
		else {
			int j = 0;
			for(int i = 0; i < textWorkId.getText().length(); i++) {
				if (!Character.isDigit(textWorkId.getText().charAt(i))){
					JOptionPane.showMessageDialog(textWorkId,"员工编号必须为数字","提示",JOptionPane.PLAIN_MESSAGE);
					return sum;
				}
				else {
					j++;
				}
			}
			if(j == textWorkId.getText().length()) {
				sum++;
			}
		}
		//员工姓名
		if(textName.getText().isEmpty()) {
			JOptionPane.showMessageDialog(textName,"员工姓名不可为空","提示",JOptionPane.PLAIN_MESSAGE);
			return sum;
		}
		else {
			sum++;
		}

		//电话号码
		if(textPhoneNumber.getText().length() != 11) {
			JOptionPane.showMessageDialog(textPhoneNumber,"电话号码有误，请重新输入","提示",JOptionPane.PLAIN_MESSAGE);
			return sum;
		}
		else {
			sum++;
		}
		
		//邮件
		if(textEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(textEmail,"邮件地址不可为空","提示",JOptionPane.PLAIN_MESSAGE);
			return sum;
		}
		else if(!textEmail.getText().isEmpty()){
			String pattern = ".*@.*";
			boolean isMatch = Pattern.matches(pattern,textEmail.getText());
			if(!isMatch) {
				JOptionPane.showMessageDialog(textEmail,"邮件地址有误","提示",JOptionPane.PLAIN_MESSAGE);
				return sum;
			}
			else {
				sum++;
			}
		}
		
		
		//密码
		if(textPassword.getText().isEmpty()) {
			JOptionPane.showMessageDialog(textPassword,"密码不可为空","提示",JOptionPane.PLAIN_MESSAGE);
			return sum;
		}
		else {
			sum++;
		}
		
		return sum;
		
	}
	
	
}
