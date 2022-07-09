package javadoor;

import java.awt.Color;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Exit_page {

	public JFrame frame;
	private JTextField email_txt;
	private JPasswordField pwd;
	Connection con = null;
	Statement statement=null;
	final Statement statement_temp=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	ResultSet resultSet1=null;
	JLabel ban_lbl;

	String columnValue="uafh";
	private JTextField auth_key;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exit_page window = new Exit_page();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Exit_page() {
		try {
			initialize();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private void initialize() throws ClassNotFoundException {
		frame = new JFrame();
		frame.setBounds(100, 100, 841, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(71, 124, 104, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEnter = new JLabel("Exit");
		lblEnter.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEnter.setBounds(255, 37, 104, 30);
		frame.getContentPane().add(lblEnter);
		
		ban_lbl = new JLabel("");
		ban_lbl.setForeground(Color.RED);
		ban_lbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ban_lbl.setBounds(218, 268, 149, 30);
		frame.getContentPane().add(ban_lbl);
		
		JLabel lblPassword = new JLabel("Authentication Key");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(71, 180, 104, 30);
		frame.getContentPane().add(lblPassword);
		
		email_txt = new JTextField();
		email_txt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		email_txt.setBounds(185, 133, 230, 20);
		frame.getContentPane().add(email_txt);
		email_txt.setColumns(10);
		
		auth_key = new JTextField();
		auth_key.setFont(new Font("Tahoma", Font.PLAIN, 16));
		auth_key.setColumns(10);
		auth_key.setBounds(185, 189, 230, 20);
		frame.getContentPane().add(auth_key);
		
		JButton exit_btn = new JButton("Exit");
		exit_btn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		exit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		exit_btn.setBounds(327, 234, 89, 23);
		frame.getContentPane().add(exit_btn);
		
		JButton home_btn = new JButton("Home");
		home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home_page window = new home_page();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		home_btn.setFont(new Font("Tahoma", Font.BOLD, 18));
		home_btn.setBounds(71, 378, 149, 53);
		frame.getContentPane().add(home_btn);
		
		
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
	      
	      
	      exit_btn.addActionListener(new ActionListener() {
				@SuppressWarnings("null")
				public void actionPerformed(ActionEvent e) {
					String em_str=email_txt.getText();
					String  key=auth_key.getText();
					
					
//					String domain=temp.substring(temp.length()-12,temp.length());
//					System.out.println(domain);
//					if(domain.equals("@iiita.ac.in"))
//					{
//						System.out.println(temp);
//						String SQL = "SELECT email,authentication_key,isAdmin from door.users WHERE email="+"\""+em_str +"\"\" AND authentication_key="+"\""+key+"\"";
//						String SQL= "SELECT email,authentication_key,isAdmin from users WHERE email=\""+iit2020023@iiita.ac.in+" \" AND authentication_key=\""a123"";
						PreparedStatement statement1=null;
						PreparedStatement statement2=null;
						try {
							statement1 = con.prepareStatement("SELECT * from users WHERE email = ? AND authentication_key = ?");
							statement2 = con.prepareStatement("Select * from users_inside WHERE email= ?");
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}    
						
						try {
							statement1.setString(1, em_str);
							
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}    
						try {
							statement1.setString(2, key);
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}  
						try {
							statement2.setString(1, em_str);
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}  
//						ResultSet resultSet = statement.executeQuery();

//						statement.executeUpdate(SQL);
//					    getUser(SQL);
						
						
					    try {
							resultSet=statement1.executeQuery();
							System.out.println("chll raha");
							
							if(resultSet==null) {
								ban_lbl.setText("Wrong Credentials");
							}
							
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					   
					    try {
							
							resultSet1=statement2.executeQuery();
							System.out.println("chll raha 1");
							
							if(resultSet1==null || resultSet==null) {
								ban_lbl.setText("Wrong Credentials");
							}
							else {
								try {
									checkUser(resultSet,em_str,key,resultSet1);
									System.out.println("chll raha  2");
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					    
					    
					    
					}
//				}
			});
	      
	      
	      resultSet=statement.executeQuery("select * from door.users");
	      ResultSetMetaData rsmd = resultSet.getMetaData();
	      int columnsNumber = rsmd.getColumnCount();
	      
	      
	      while (resultSet.next()) {
	          for (int i = 1; i <= columnsNumber; i++) {

	              if (i > 1) System.out.print(",  ");
	              String columnValue = resultSet.getString(i);
//	              System.out.print(columnValue + " " + rsmd.getColumnName(i));
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
	
		
//	}
void checkUser(ResultSet resultSet,String email,String authkey,ResultSet resultSet1) throws SQLException, ClassNotFoundException {
	String emailinside=null;
	System.out.println("chll raha 3");
	while(resultSet1.next())
	{
		emailinside=resultSet1.getString("email");
		System.out.println(emailinside+"asdfadfdg");
	}		
	while(resultSet.next())
	{
		
		String user=resultSet.getString("email");
		String pwd=resultSet.getString("authentication_key");
		String ban=resultSet.getString("isban");
		String isadmin=resultSet.getString(4);
		
//		if(user.equals(email) && pwd.equals(authkey))
//		{
		String url = "jdbc:mysql://localhost:3306/door";
	    String username = "root";
	    String password = "Ekam@2019";

	    try { 
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      con = DriverManager.getConnection(url, username, password);
	      System.out.println("Connected!!!");
	      statement=con.createStatement();
	    }
	    
	    catch (SQLException ex) {
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
	    
	    
			System.out.println("beforeloop");
			System.out.println(user+"and"+emailinside +" isban: "+ban+" isadmin: "+isadmin);
			if( isadmin.equals("1"))
			{
//				System.out.println("asdfaf successfully : ");
//				statement.executeUpdate(SQL);
//			    insertt(SQL);
				Adminhome window = new Adminhome();
				try {
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				window.frame.setVisible(true);
				frame.dispose();
				System.out.println("Admin welcome");
			}
	
			else if(isadmin.equals("0") && ban.equals("0") && user.equals(emailinside))
			{
				System.out.println("insideloop");
//				System.out.println(user);
//				String SQL = "INSERT INTO door.history(email,outtime)"
//			    		  +"VALUES ('"+ user +"',CURRENT_TIMESTAMP)";
				String SQL1="UPDATE door.history SET outtime = CURRENT_TIMESTAMP, inside='0' WHERE email = '"+emailinside+"'AND inside='1' ";
				String SQL2="DELETE from door.users_inside where email= '"+emailinside+"'";
//				String SQL1="INSERT INTO door.history(email)"
				try {
					int m=statement.executeUpdate(SQL2);
					int n=statement.executeUpdate(SQL1);
					
					if (m==1 && n==1)
					    System.out.println("User Welcome");
					else
					    System.out.println("Some technical fault is there, please try again after sometime!!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//				System.out.println("User Welcome");
				
				try {
					home_page window = new home_page();
					window.frame.setVisible(true);
					frame.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
//		}
//		else
//		{
//			System.out.println("Email"+ email +" not registered");
//		}
		
	}
}

void ruko(int x) {
	long timestamp_start = System.currentTimeMillis()/1000;
	long limit=(long) x;
	while(true) {
		long timestamp_start_tt = System.currentTimeMillis() / 1000;
		long diff=timestamp_start_tt-timestamp_start;
		if(limit<diff) {
			break;
		}
		
	}
	return;
	
}

}

//}
