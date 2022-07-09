package javadoor;
import java.awt.EventQueue;
import java.sql.*;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class Register {

	public JFrame frame;
	private JTextField email_txt;
	private JTextField otp_txt;
	private JLabel lblNewLabel_1;
	private JButton otp_btn;
	private JButton otp_btn1;
	Connection con = null;
	public String global_otp;
	Statement statement=null;
	final Statement statement_temp=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	ResultSet resultSettemp=null;
	public String global_email;
	public String global_password;
	ResultSetMetaData rsmd;
	 int columnsNumber;

	String columnValue="uafh";
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() throws ClassNotFoundException {
				//connect();
				initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 */
	public void initialize() throws ClassNotFoundException {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 841, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(291, 22, 151, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("Email");
		lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel1.setBounds(71, 124, 104, 30);
		frame.getContentPane().add(lblNewLabel1);
		
		email_txt = new JTextField();
		email_txt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		email_txt.setBounds(185, 133, 230, 20);
		frame.getContentPane().add(email_txt);
		email_txt.setColumns(10);
		
		otp_txt = new JTextField();
		otp_txt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		otp_txt.setBounds(185, 133, 230, 20);
		//frame.getContentPane().add(email_txt);
		otp_txt.setColumns(10);

		
		
		
		lblNewLabel_1 = new JLabel("Email should be of \"@iiita.ac.in\" domain");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(185, 164, 247, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		
//	      String SQL = "INSERT INTO door.users(email,authentication_key,isAdmin)"
//	    		  +"VALUES ('iit2020024@iiita.ac.in','a12s3',0)";
//	      statement.executeUpdate(SQL);
	      
		otp_btn = new JButton("send otp");
		
		
		
		
		otp_btn.setFont(new Font("Tahoma", Font.BOLD, 16));
		otp_btn.setBounds(495, 132, 127, 23);
		frame.getContentPane().add(otp_btn);
		
		
		
		otp_btn1 = new JButton("enter_otp");
		otp_btn1.setFont(new Font("Tahoma", Font.BOLD, 16));
		otp_btn1.setBounds(495, 132, 127, 23);
		
		//frame.getContentPane().add(otp_btn);
		
		
		JButton home_btn = new JButton("Home");
		home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home_page window = new home_page();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		home_btn.setFont(new Font("Tahoma", Font.BOLD, 18));
		home_btn.setBounds(495, 410, 142, 31);
		frame.getContentPane().add(home_btn);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(185, 214, 230, 129);
		//frame.getContentPane().add(textPane);
  	  	
  	  	
  	  

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
	      
	      
	      otp_btn.addActionListener(new ActionListener() {
				@SuppressWarnings("null")
				public void actionPerformed(ActionEvent e) {
					String temp=email_txt.getText();
					String em_str=email_txt.getText();
//					System.out.println(temp);
					String key=auth_key();
					
					String domain=temp.substring(temp.length()-12,temp.length());
					System.out.println(domain);
					
					if(domain.equals("@iiita.ac.in"))
					{
						String SQL1 = "SELECT * FROM door.users WHERE email = '"+em_str+"'" ;
						////
						try {
							resultSet=statement.executeQuery(SQL1);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try {
							rsmd = resultSet.getMetaData();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					   
						try {
							columnsNumber = rsmd.getColumnCount();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try {
							if(resultSet.next()) {
								already_exist.main(null);
								frame.dispose();
								
								
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
//						ResultSet resultSet = statement.executeQuery();

//						statement.executeUpdate(SQL);
//					    getUser(SQL);
					    
//					    try {
//							checkUser(resultSet,em_str,key);
//						} catch (SQLException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
						
						///
						String ottp=otp();
						global_otp=ottp;
						System.out.println(ottp);
						Email_test otp_object=new Email_test(em_str,ottp);
						otp_btn.setVisible(false);
						frame.getContentPane().add(otp_btn1);
						email_txt.setVisible(false);
						lblNewLabel_1.setText("enter otp sent on " + em_str);
						
						lblNewLabel1.setText("Enter otp");
						frame.getContentPane().add(otp_txt);
						global_email=em_str;
						global_password=key;
						
//						System.out.println(temp);
						
					}
				}
			});
	      
	      
	      
	      
	      otp_btn1.addActionListener(new ActionListener() {
				@SuppressWarnings("null")
				public void actionPerformed(ActionEvent e) {
					String user_otp_en=otp_txt.getText();
					if(global_otp.equals(user_otp_en)) {
						email_1 e_temp=new email_1(global_email,global_password);
						
						String SQL = "INSERT INTO door.users(email,authentication_key,isAdmin)"
					    		  +"VALUES ('"+ global_email +"','"+ global_password +"',0)";
						//System.out.println("asdfaf successfully : ");
//						statement.executeUpdate(SQL);
					    insertt(SQL);
					    home_page.main(null);
					    frame.dispose();
					    
					}
					else {
						lblNewLabel_1.setText("Your otp is wrong Try again");
						otp_btn1.setVisible(false);
						otp_txt.setVisible(false);
						lblNewLabel1.setVisible(false);
						
						
						
					}
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
	              //System.out.print(columnValue + " " + rsmd.getColumnName(i));
	              textPane.setText(columnValue);
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
	
	void insertt(String SQL) {
		System.out.println("called successfully : ");
		try {
			int m=statement.executeUpdate(SQL);
			if (m==1)
			    System.out.println("inserted successfully : ");
			else
			    System.out.println("insertion failed");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/*
	public void connect() throws ClassNotFoundException {
		Connection con = null;
		Statement statement=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;

	    String url = "jdbc:mysql://localhost:3306/door";
	    String username = "root";
	    String password = "Ekam@2019";

	    try { 
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      con = DriverManager.getConnection(url, username, password);
	      System.out.println("Connected!");
	      statement=con.createStatement();
	      resultSet=statement.executeQuery("select * from door.users");
	      ResultSetMetaData rsmd = resultSet.getMetaData();
	      int columnsNumber = rsmd.getColumnCount();

	      while (resultSet.next()) {
	          for (int i = 1; i <= columnsNumber; i++) {



	              if (i > 1) System.out.print(",  ");
	              String columnValue = resultSet.getString(i);
	              System.out.print(columnValue + " " + rsmd.getColumnName(i));
	          }
	          System.out.println("");
	      }
	    } catch (SQLException ex) {
	        throw new Error("Error ", ex);
	    } finally {
	      try {
	        if (con != null) {
	            con.close();
	        }
	      } catch (SQLException ex) {
	          System.out.println(ex.getMessage());
	      }
	    }
	}
	*/
	
	String auth_key() {
		 String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		    String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		    String numbers = "0123456789";

		    // combine all strings
		    String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

		    // create random string builder
		    StringBuilder sb = new StringBuilder();

		    // create an object of Random class
		    Random random = new Random();

		    // specify length of random string
		    int length = 5;

		    for(int i = 0; i < length; i++) {

		      // generate random index number
		      int index = random.nextInt(alphaNumeric.length());

		      // get character specified by index
		      // from the string
		      char randomChar = alphaNumeric.charAt(index);

		      // append the character to string builder
		      sb.append(randomChar);
		    }

		    String randomString = sb.toString();
		    return randomString;
	}
	
	String otp() {
		 String upperAlphabet = "0123456789";
		    String lowerAlphabet = "0123456789";
		    String numbers = "0123456789";

		    // combine all strings
		    String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

		    // create random string builder
		    StringBuilder sb = new StringBuilder();

		    // create an object of Random class
		    Random random = new Random();

		    // specify length of random string
		    int length = 5;

		    for(int i = 0; i < length; i++) {

		      // generate random index number
		      int index = random.nextInt(alphaNumeric.length());

		      // get character specified by index
		      // from the string
		      char randomChar = alphaNumeric.charAt(index);

		      // append the character to string builder
		      sb.append(randomChar);
		    }

		    String randomString = sb.toString();
		    return randomString;
	}
	
}
