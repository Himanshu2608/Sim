package javadoor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
//import java.awt.EventQueue;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.JTable;



public class UsersInside {

	private JFrame frame;
	private JTextField txtBannedUsers;
	private JTable table;
	
	Connection con = null;
	Statement statement=null;
	final Statement statement_temp=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	ResultSet resultSettemp=null;
//
//	private JTextField email_txt;
//	private JLabel lblNewLabel_1;
//	private JButton otp_btn;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsersInside window = new UsersInside();
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
	public UsersInside() throws ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException {
		frame = new JFrame();
		frame.setBounds(100, 100, 573, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 105, 348);
		frame.getContentPane().add(panel);
		
		JButton Home = new JButton("Home");
		Home.setHorizontalAlignment(SwingConstants.LEFT);
		Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(Home);
		
		JButton btnNewButton_2 = new JButton("User's Inside");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("User's Info");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("User's History");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton);
		
		txtBannedUsers = new JTextField();
		txtBannedUsers.setText("User Inside");
		txtBannedUsers.setColumns(10);
		txtBannedUsers.setBounds(139, 25, 105, 33);
		frame.getContentPane().add(txtBannedUsers);
		
		table = new JTable();
		table.setBounds(139, 69, 373, 214);
		frame.getContentPane().add(table);
		
		
		Connection con = null;
		Statement statement=null;
//		@SuppressWarnings("unused")
//		PreparedStatement preparedStatement=null;
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
}
