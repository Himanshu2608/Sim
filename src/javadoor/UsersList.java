package javadoor;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;

public class UsersList {

	private JFrame frame;
	private JTextField txtTleUsers;
	private JTable table;
	Connection con = null;
	Statement statement=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsersList window = new UsersList();
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
	public UsersList() throws ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 819, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 105, 348);
		frame.getContentPane().add(panel);
		
		JButton Home = new JButton("Admin Home");
		Home.setHorizontalAlignment(SwingConstants.LEFT);
		Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminhome.main(null);
				frame.dispose();
			}
		});
		panel.add(Home);
		
		txtTleUsers = new JTextField();
		txtTleUsers.setForeground(Color.BLACK);
		txtTleUsers.setText("User's List");
		txtTleUsers.setColumns(10);
		txtTleUsers.setBounds(138, 26, 105, 33);
		frame.getContentPane().add(txtTleUsers);
		
//		table = new JTable();
//		table.setBounds(159, 74, 348, 239);
//		frame.getContentPane().add(table);
		
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
	      resultSet=statement.executeQuery("select id,email,isban from door.users where isAdmin=0");
	      ResultSetMetaData rsmd = resultSet.getMetaData();
	      int columnsNumber = rsmd.getColumnCount();


	      

	      table = new JTable();
	      table.setModel(DbUtils.resultSetToTableModel(resultSet));
	     
	      //table.setBounds(139, 69, 800, 400);
	      
	      JScrollPane scroll = new JScrollPane(table);
	      scroll.setBounds(139, 69, 500, 400);
		  frame.getContentPane().add(scroll);
			
			
			
			
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
