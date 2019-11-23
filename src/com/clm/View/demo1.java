package com.clm.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class demo1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo1 frame = new demo1();
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
	public demo1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblAhudhasudh = new JLabel("ahudhasudh");
		contentPane.add(lblAhudhasudh, BorderLayout.NORTH);
		
		JButton btnSkipToDemo = new JButton("skip to demo2");
		btnSkipToDemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(this.getClass());
			}
		});
		contentPane.add(btnSkipToDemo, BorderLayout.CENTER);
		
		
//		btnSkipToDemo.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				//销毁当前页面
//				closeThis();
//				//打开一个新的页面
//				new demo2().demo2();
//			}
//		});

	}
	public void hiddenThis() {
		this.hiddenThis();
	}
	public void showThis() {
		this.showThis();
	}

}

