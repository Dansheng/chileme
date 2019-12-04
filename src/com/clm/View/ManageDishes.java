package com.clm.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.clm.Controller.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
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
import javax.swing.JComboBox;

public class ManageDishes extends JFrame {

	private JPanel contentPane;
	private JTextField textDishName;
	private JTextField textPrice;
	private JTextField textAvaNumber;
	private JLabel labSeeImage;
	private JTextArea textDiscribe;
	private JTextArea textImagePath;
	
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
		setBounds(100, 100, 450, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		

		textDiscribe = new JTextArea();
		textDiscribe.setBounds(177, 322, 149, 130);
		//		scrollPane.add(textDiscribe);
				textDiscribe.setLineWrap(true);
				
				JScrollPane jspDirscribe = new JScrollPane(textDiscribe);
				jspDirscribe.setBounds(177, 322, 140, 135);
				contentPane.add(jspDirscribe);
		
		
		textImagePath = new JTextArea();
		textImagePath.setBounds(177, 268, 161, 26);
		//		panel_1.add(textImagePath);
				textImagePath.setBackground(Color.WHITE);
				textImagePath.setLineWrap(true);
				
				JScrollPane jspImagePath = new JScrollPane(textImagePath);
				jspImagePath.setBounds(177, 268, 168, 40);
				contentPane.add(jspImagePath);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
	    
		
		JLabel label = new JLabel("菜单管理");
		label.setBounds(196, 6, 52, 16);
		panel_1.add(label);
		
		JLabel labDishName = new JLabel("菜品名称");
		labDishName.setBounds(101, 34, 52, 16);
		panel_1.add(labDishName);
		
		textDishName = new JTextField();
		textDishName.setBounds(177, 29, 130, 26);
		panel_1.add(textDishName);
		textDishName.setColumns(10);
		
		JLabel labPrice = new JLabel("菜品单价");
		labPrice.setBounds(101, 69, 52, 16);
		panel_1.add(labPrice);
		
		textPrice = new JTextField();
		textPrice.setBounds(177, 64, 130, 26);
		panel_1.add(textPrice);
		textPrice.setColumns(10);
		
		JLabel labAvaNumber = new JLabel("菜品数量");
		labAvaNumber.setBounds(101, 105, 52, 16);
		panel_1.add(labAvaNumber);
		
		textAvaNumber = new JTextField();
		textAvaNumber.setBounds(177, 102, 130, 26);
		panel_1.add(textAvaNumber);
		textAvaNumber.setColumns(10);
		
		JLabel labDiscribe = new JLabel("菜品描述");
		labDiscribe.setBounds(101, 316, 52, 16);
		panel_1.add(labDiscribe);
		
		JLabel labImage = new JLabel("菜品图片");
		labImage.setBounds(101, 167, 52, 16);
		panel_1.add(labImage);
		
		JButton btnImage = new JButton("选择图片");
		btnImage.setBounds(173, 164, 95, 26);
		panel_1.add(btnImage);
		

		JLabel labImagePath = new JLabel("图片路径");
		labImagePath.setBounds(101, 263, 61, 16);
		panel_1.add(labImagePath);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				if (chooser.showOpenDialog(btnImage)==JFileChooser.APPROVE_OPTION) {//
                    File file = chooser.getSelectedFile();
                    textImagePath.setText(file.getAbsolutePath().toString());
                    setImageUrl(file.getAbsolutePath().toString());
                };
			}
		});
		
		ImageIcon image = new ImageIcon("./assets/img/logo.png");
		image.setImage(image.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
		labSeeImage = new JLabel(image);
		labSeeImage.setBounds(177, 191, 112, 65);
		panel_1.add(labSeeImage);
		
		JLabel labType = new JLabel("菜品类别");
		labType.setBounds(101, 136, 52, 16);
		panel_1.add(labType);
		
		JComboBox<String> textType = new JComboBox<String>();
		textType.addItem("川湘菜");
		textType.addItem("西北菜");
		textType.addItem("江浙菜");
		textType.addItem("新疆菜");
		textType.addItem("东北菜");
		textType.addItem("粤菜");
		textType.addItem("西餐");
		textType.addItem("日本料理");
		textType.addItem("韩式简餐");
		textType.addItem("小吃夜宵");
		textType.addItem("甜品饮品");
		textType.setBounds(177, 132, 130, 26);
		panel_1.add(textType);
		
		JButton btnAdd = new JButton("添加");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller controller = Controller.getInstance();
				int a = Verification();
				if(a==5) {
					boolean a1 = controller.uploadDish(textDishName.getText(), Double.parseDouble(textPrice.getText()), Integer.parseInt(textAvaNumber.getText()), textImagePath.getText(), textDiscribe.getText(),textType.getSelectedItem().toString());
					if(a1) {
						JOptionPane.showMessageDialog(btnAdd,"添加成功啦","提示",JOptionPane.PLAIN_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(btnAdd,"哎呀，再试一次吧","提示",JOptionPane.PLAIN_MESSAGE);
					}
					
				}
				
				
			}
		});
		btnAdd.setBounds(173, 461, 117, 29);
		panel_1.add(btnAdd);
		
		
		
	}
	
	public void setImageUrl(String img_url) {
		ImageIcon image = new ImageIcon(img_url);
		image.setImage(image.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
		this.labSeeImage.setIcon(image);
	}
	
	//表单验证
	public int Verification() {
		int sum = 0;
		//菜品名称
		if (textDishName.getText().isEmpty()) {
			JOptionPane.showMessageDialog(textDishName,"菜品不能没有名称哦","提示",JOptionPane.PLAIN_MESSAGE);
			return sum;
		}else {
			sum++;
		}
		//单价
		if(textPrice.getText().isEmpty()) {
			JOptionPane.showMessageDialog(textPrice,"菜品不能没有单价哦","提示",JOptionPane.PLAIN_MESSAGE);
			return sum;
		}else {
			sum++;
		}
		//数量
		if(textAvaNumber.getText().isEmpty()) {
			JOptionPane.showMessageDialog(textAvaNumber,"菜品不能没有数量哦","提示",JOptionPane.PLAIN_MESSAGE);
			return sum;
		}else {
			sum++;
		}
		//描述
		if(textDiscribe.getText().isEmpty()) {
			JOptionPane.showMessageDialog(textDiscribe,"菜品不能没有描述哦","提示",JOptionPane.PLAIN_MESSAGE);
			return sum;
		}else {
			sum++;
		}
		
		//图片
		if(textImagePath.getText().isEmpty()) {
			JOptionPane.showMessageDialog(textImagePath,"菜品不能没有图片哦","提示",JOptionPane.PLAIN_MESSAGE);
			return sum;
		}else {
			sum++;
		}
		return sum;
	}
}





















