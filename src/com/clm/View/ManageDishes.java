package com.clm.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Container;

public class ManageDishes extends JFrame {

	private JPanel contentPane;
	private JTextField textDishId;
	private JTextField textDishName;
	private JTextField textPrice;
	private JTextField textAvaNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageDishes frame = new ManageDishes();
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
	public ManageDishes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextArea textDiscribe = new JTextArea();
		textDiscribe.setBounds(177, 292, 149, 130);
		//		scrollPane.add(textDiscribe);
				textDiscribe.setLineWrap(true);
				
				JScrollPane jspDirscribe = new JScrollPane(textDiscribe);
				jspDirscribe.setBounds(177, 292, 140, 135);
				contentPane.add(jspDirscribe);
		
		
		JTextArea textImagePath = new JTextArea();
		textImagePath.setBounds(177, 238, 161, 26);
		//		panel_1.add(textImagePath);
				textImagePath.setBackground(Color.WHITE);
				textImagePath.setLineWrap(true);
				
				JScrollPane jspImagePath = new JScrollPane(textImagePath);
				jspImagePath.setBounds(177, 240, 168, 40);
				contentPane.add(jspImagePath);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
	    
		
		JLabel label = new JLabel("菜单管理");
		label.setBounds(192, 10, 52, 16);
		panel_1.add(label);
		
		textDishId = new JTextField();
		textDishId.setBounds(177, 38, 130, 26);
		panel_1.add(textDishId);
		textDishId.setColumns(10);
		
		JLabel labDishId = new JLabel("菜品编号");
		labDishId.setBounds(101, 41, 52, 16);
		panel_1.add(labDishId);
		
		JLabel labDishName = new JLabel("菜品名称");
		labDishName.setBounds(101, 81, 52, 16);
		panel_1.add(labDishName);
		
		textDishName = new JTextField();
		textDishName.setBounds(177, 76, 130, 26);
		panel_1.add(textDishName);
		textDishName.setColumns(10);
		
		JLabel labPrice = new JLabel("菜品单价");
		labPrice.setBounds(101, 125, 52, 16);
		panel_1.add(labPrice);
		
		textPrice = new JTextField();
		textPrice.setBounds(177, 120, 130, 26);
		panel_1.add(textPrice);
		textPrice.setColumns(10);
		
		JLabel labAvaNumber = new JLabel("菜品数量");
		labAvaNumber.setBounds(101, 166, 52, 16);
		panel_1.add(labAvaNumber);
		
		textAvaNumber = new JTextField();
		textAvaNumber.setBounds(177, 158, 130, 26);
		panel_1.add(textAvaNumber);
		textAvaNumber.setColumns(10);
		
		JLabel labDiscribe = new JLabel("菜品描述");
		labDiscribe.setBounds(101, 292, 52, 16);
		panel_1.add(labDiscribe);
		
		JLabel labImage = new JLabel("菜品图片");
		labImage.setBounds(101, 206, 52, 16);
		panel_1.add(labImage);
		
		JButton btnImage = new JButton("选择图片");
		btnImage.setBounds(177, 196, 95, 26);
		panel_1.add(btnImage);
		
		JLabel labImagePath = new JLabel("图片路径");
		labImagePath.setBounds(101, 238, 61, 16);
		panel_1.add(labImagePath);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				if (chooser.showOpenDialog(btnImage)==JFileChooser.APPROVE_OPTION) {//
                    File file = chooser.getSelectedFile();
                    textImagePath.setText(file.getPath());
                };
			}
		});
		
	}
}
