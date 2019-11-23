package com.clm.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;

public class SelectDishes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectDishes frame = new SelectDishes();
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
	public SelectDishes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton butHomePage = new JButton("首页");
		butHomePage.setBounds(33, 19, 117, 29);
		panel.add(butHomePage);
		
		JButton butMyOrder = new JButton("我的订单");
		butMyOrder.setBounds(221, 19, 117, 29);
		panel.add(butMyOrder);
		
		JLabel label = new JLabel("美食分类");
		label.setBounds(6, 54, 61, 16);
		panel.add(label);
		
		JButton button = new JButton("今日特价");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(67, 49, 117, 29);
		panel.add(button);
		
		JButton button_1 = new JButton("特色快餐");
		button_1.setBounds(186, 49, 117, 29);
		panel.add(button_1);
		
		JButton btnNewButton = new JButton("甜品饮品");
		btnNewButton.setBounds(315, 49, 117, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("picture");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(16, 149, 73, 69);
		panel.add(btnNewButton_1);
		
		JLabel label_1 = new JLabel("鱼香肉丝");
		label_1.setBounds(28, 218, 61, 16);
		panel.add(label_1);
		
		JButton button_2 = new JButton("picture");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(121, 149, 73, 69);
		panel.add(button_2);
		
		JLabel label_2 = new JLabel("酸辣土豆丝");
		label_2.setBounds(121, 218, 73, 16);
		panel.add(label_2);
		
		JButton button_3 = new JButton("picture");
		button_3.setBounds(221, 149, 73, 69);
		panel.add(button_3);
		
		JLabel label_3 = new JLabel("麻辣牛肉");
		label_3.setBounds(230, 218, 61, 16);
		panel.add(label_3);
		
		JButton button_4 = new JButton("picture");
		button_4.setBounds(326, 149, 73, 69);
		panel.add(button_4);
		
		JLabel label_4 = new JLabel("炸鸡");
		label_4.setBounds(347, 218, 61, 16);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("为您推荐");
		label_5.setBounds(173, 107, 61, 16);
		panel.add(label_5);
	}
}
