package com.clm.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;

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
		setBounds(100, 100, 800, 400);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel labName1 = new JLabel("name");
		labName1.setBounds(67, 140, 34, 16);
		panel.add(labName1);
		
		JLabel labPicture1 = new JLabel("picture");
		labPicture1.setBounds(57, 56, 44, 16);
		panel.add(labPicture1);
		
		JLabel labName7 = new JLabel("name");
		labName7.setBounds(67, 309, 34, 16);
		panel.add(labName7);
		
		JLabel labPicture7 = new JLabel("picture");
		labPicture7.setBounds(57, 225, 44, 16);
		panel.add(labPicture7);
		
		JLabel labPicture2 = new JLabel("picture");
		labPicture2.setBounds(169, 56, 44, 16);
		panel.add(labPicture2);
		
		JLabel labName2 = new JLabel("name");
		labName2.setBounds(179, 140, 34, 16);
		panel.add(labName2);
		
		JLabel labPicture3 = new JLabel("picture");
		labPicture3.setBounds(295, 56, 44, 16);
		panel.add(labPicture3);
		
		JLabel labName3 = new JLabel("name");
		labName3.setBounds(305, 140, 34, 16);
		panel.add(labName3);
		
		JLabel labPicture4 = new JLabel("picture");
		labPicture4.setBounds(420, 56, 44, 16);
		panel.add(labPicture4);
		
		JLabel labName4 = new JLabel("name");
		labName4.setBounds(430, 140, 34, 16);
		panel.add(labName4);
		
		JLabel labPicture5 = new JLabel("picture");
		labPicture5.setBounds(555, 56, 44, 16);
		panel.add(labPicture5);
		
		JLabel labName5 = new JLabel("name");
		labName5.setBounds(565, 140, 34, 16);
		panel.add(labName5);
		
		JLabel labPicture6 = new JLabel("picture");
		labPicture6.setBounds(684, 56, 44, 16);
		panel.add(labPicture6);
		
		JLabel labName6 = new JLabel("name");
		labName6.setBounds(694, 140, 34, 16);
		panel.add(labName6);
		
		JLabel labPicture8 = new JLabel("picture");
		labPicture8.setBounds(169, 225, 44, 16);
		panel.add(labPicture8);
		
		JLabel labName8 = new JLabel("name");
		labName8.setBounds(179, 309, 34, 16);
		panel.add(labName8);
		
		JLabel labPicture9 = new JLabel("picture");
		labPicture9.setBounds(295, 225, 44, 16);
		panel.add(labPicture9);
		
		JLabel labName9 = new JLabel("name");
		labName9.setBounds(305, 309, 34, 16);
		panel.add(labName9);
		
		JLabel labPicture10 = new JLabel("picture");
		labPicture10.setBounds(420, 225, 44, 16);
		panel.add(labPicture10);
		
		JLabel labName10 = new JLabel("name");
		labName10.setBounds(430, 309, 34, 16);
		panel.add(labName10);
		
		JLabel labPicture11 = new JLabel("picture");
		labPicture11.setBounds(555, 225, 44, 16);
		panel.add(labPicture11);
		
		JLabel labName11 = new JLabel("name");
		labName11.setBounds(565, 309, 34, 16);
		panel.add(labName11);
		
		JLabel labPicture12 = new JLabel("picture");
		labPicture12.setBounds(698, 225, 44, 16);
		panel.add(labPicture12);
		
		JLabel labName12 = new JLabel("name");
		labName12.setBounds(708, 309, 34, 16);
		panel.add(labName12);
		
		JButton butExchage = new JButton("换一换");
		butExchage.setBounds(677, 337, 117, 29);
		panel.add(butExchage);
		
		JLabel labHello = new JLabel("欢迎选餐");
		labHello.setBounds(389, 6, 61, 16);
		panel.add(labHello);

	}
}
