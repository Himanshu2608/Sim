package javadoor;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ban_user {

	private JFrame frame;
	
	private JTextField email_txt;
	
	Connection con = null;
	Statement statement=null;
	final Statement statement_temp=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	ResultSet resultSettemp=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ban_user window = new Ban_user();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 */
	public Ban_user() throws ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws ClassNotFoundException {
		frame = new JFrame();
		frame.setBounds(100, 100, 841, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(71, 124, 104, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEnter = new JLabel("Ban/Unban");
		lblEnter.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEnter.setBounds(255, 37, 161, 30);
		frame.getContentPane().add(lblEnter);
		
		email_txt = new JTextField();
		email_txt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		email_txt.setBounds(186, 131, 230, 20);
		frame.getContentPane().add(email_txt);
		email_txt.setColumns(10);
		
		JButton ban_btn = new JButton("Ban");
		ban_btn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		ban_btn.setBounds(186, 181, 89, 23);
		frame.getContentPane().add(ban_btn);
		
		JButton home_btn = new JButton("Home");
		home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminhome.main(null);
				
				frame.dispose();
			}
		});
		home_btn.setFont(new Font("Tahoma", Font.BOLD, 18));
		home_btn.setBounds(71, 378, 149, 53);
		frame.getContentPane().add(home_btn);
		
		
		
		JButton unban_btn = new JButton("Unban");
		
		unban_btn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		unban_btn.setBounds(304, 181, 89, 23);
		frame.getContentPane().add(unban_btn);
		
		JLabel lblNewLabel_1 = new JLabel("User banned");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(82, 260, 581, 59);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setText("");
		
		JLabel lblNewLabel_1_1 = new JLabel("User Unbanned");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(454, 260, 131, 59);
		//frame.getContentPane().add(lblNewLabel_1_1);
		
		String url = "jdbc:mysql://localhost:3306/door";
	    String username = "root";
	    String password = "Ekam@2019";

	    try { 
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      con = DriverManager.getConnection(url, username, password);
	      System.out.println("Connected!");
	      statement=con.createStatement();
//	      statement_temp=con.createStatement();
//	      
//	      String SQL = "INSERT INTO door.users(email,authentication_key,isAdmin) "
//	                + "VALUES(iit2020024@iita.ac.in,123abc,1)";
//	      statement.executeUpdate(SQL);
	      
	      
	      unban_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String em_str=email_txt.getText();
					
					
						try {
							String statement122 = "UPDATE users SET isban = 0  WHERE email = '"+em_str+"'";
							statement.executeUpdate(statement122);
							lblNewLabel_1.setText(em_str +" unbanned");
							
							
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}    
						
					

//						
					
					
				}
			});
	      
	      
	      
	      
	      ban_btn.addActionListener(new ActionListener() {
				@SuppressWarnings("null")
				public void actionPerformed(ActionEvent e) {
					String em_str=email_txt.getText();
					
						
						try {
							String statement122 = "UPDATE users SET isban = 1  WHERE email = '"+em_str+"'";
							statement.executeUpdate(statement122);
							lblNewLabel_1.setText(em_str +" banned");
							
						} catch (SQLException e2) {
							
							e2.printStackTrace();
						} 
						 
//						
				}
			});
	      
	      
	      resultSet=statement.executeQuery("select * from door.users");
//	      printtable(resultSet);
	      ResultSetMetaData rsmd = resultSet.getMetaData();
	      int columnsNumber = rsmd.getColumnCount();
	      
	      
	      while (resultSet.next()) {
	          for (int i = 1; i <= columnsNumber; i++) {

	              if (i > 1) System.out.print(",  ");
	              String columnValue = resultSet.getString(i);
	              System.out.print(columnValue + " " + rsmd.getColumnName(i));
//	              textPane.setText(columnValue);
	          }
	          System.out.println("");
	      }
	    } catch (SQLException ex) {
	        throw new Error("Error ", ex);
	    } finally {
	      try {
	        if (con == null) {
	            con.close();
	        }
	      } catch (SQLException ex) {
	          System.out.println(ex.getMessage());
	      }
	    }
	}

}
