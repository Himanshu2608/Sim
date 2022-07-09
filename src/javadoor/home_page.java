package javadoor;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home_page {

	public JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home_page window = new home_page();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public home_page() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 841, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home Page");
		lblNewLabel.setBounds(324, 26, 217, 42);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		frame.getContentPane().add(lblNewLabel);
		
		JButton exit_btn = new JButton("Exit");
		exit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exit_page window = new Exit_page();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		exit_btn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		exit_btn.setBounds(324, 274, 166, 61);
		frame.getContentPane().add(exit_btn);
		
		JButton reg_btn = new JButton("Registor");
		reg_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register window = null;
				try {
					window = new Register();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		reg_btn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		reg_btn.setBounds(587, 274, 166, 61);
		frame.getContentPane().add(reg_btn);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(0, 497, 100, 100);
		frame.getContentPane().add(canvas);
		
		JButton enter_btn = new JButton("Enter");
		enter_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//add new window to it 
				
				Enter_page window = null;
				try {
					window = new Enter_page();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		enter_btn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		enter_btn.setBounds(45, 274, 166, 61);
		frame.getContentPane().add(enter_btn);
	}
	
}
