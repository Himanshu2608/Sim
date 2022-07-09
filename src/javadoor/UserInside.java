package javadoor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;



import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;


public class UserInside {

	public JFrame frame;
	public JTextField txtBannedUsers;
	public JTable table;
	
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
					UserInside window = new UserInside();
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
	public UserInside() {
		try {
			initialize();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() throws ClassNotFoundException {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
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
		
		
		
		txtBannedUsers = new JTextField();
		txtBannedUsers.setText("User Inside");
		txtBannedUsers.setColumns(10);
		txtBannedUsers.setBounds(139, 25, 105, 33);
		frame.getContentPane().add(txtBannedUsers);
		

//		table = new JTable();
//		table.setBounds(139, 69, 373, 214);
//		frame.getContentPane().add(table);
		
		
//		String[] columnNames = {"First Name",
//                "Last Name",
//                "Sport",
//                "# of Years",
//                "Vegetarian"};


//jTable1 = new JTable(data, columnNames);  
//table = new JTable(data,columnNames);
//String[] columnNames = {"User name", "Email", "Password", "Country"};
//DefaultTableModel model = new DefaultTableModel();
//model.setColumnIdentifiers(columnNames);



//BidiUtils = (String) c1.getSelectedItem();

//String textvalue = textbox.getText();

//String uname = "";
//
//String email = "";
//
//String pass = "";
//
//String cou = "";
// frame.getContentPane().add(table);
//JScrollPane scrollableTextArea = new JScrollPane(table);
//scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
//scrollableTextArea.setBounds(139, 69, 373, 214);
//frame.getContentPane().add(scrollableTextArea);  
		
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
	      resultSet=statement.executeQuery("select id,email,intime from door.users_inside");
	      ResultSetMetaData rsmd = resultSet.getMetaData();
	      int columnsNumber = rsmd.getColumnCount();


	      

	      table = new JTable();
	      table.setModel(DbUtils.resultSetToTableModel(resultSet));
	      //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	      //table.setBounds(139, 69, 800, 400);
	      //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	      //table.setFillsViewportHeight(true);
	      JScrollPane scroll = new JScrollPane(table);
	      scroll.setBounds(139, 69, 800, 400);
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
