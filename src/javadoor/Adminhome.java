package javadoor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;



import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import java.awt.Font;

public class Adminhome {
	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminhome window = new Adminhome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Adminhome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 573, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 75, 528, 284);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton_2 = new JButton("User's Inside");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(47, 81, 133, 34);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				try {
					frame.dispose();
					UserInside window = new UserInside();
					window.frame.setVisible(true);
				} catch (Exception ee) {
					ee.printStackTrace();
				}
				*/
				UserInside.main(null);
				frame.dispose();
				
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("User's Info");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(210, 81, 118, 34);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsersList.main(null);
				frame.dispose();
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("User's History");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(354, 81, 133, 34);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsersHistory.main(null);
				frame.dispose();
				
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_2_1 = new JButton("Home");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home_page.main(null);
				frame.dispose();
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_1.setBounds(47, 227, 133, 34);
		panel.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("ban/unban");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ban_user.main(null);
				frame.dispose();
			}
		});
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_1_1.setBounds(195, 146, 133, 34);
		panel.add(btnNewButton_2_1_1);
		
		JLabel lblNewLabel = new JLabel("Welcome Admin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(199, 11, 177, 43);
		frame.getContentPane().add(lblNewLabel);
	}
}
