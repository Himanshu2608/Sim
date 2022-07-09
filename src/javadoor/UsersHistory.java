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
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;

public class UsersHistory {

	private JFrame frame;
	private JTable table;
	private JTextField d1y;
	private JTextField d1m;
	private JTextField d1d;
	private JTextField d2y;
	private JTextField d2m;
	private JTextField d2d;
	public String date_from;
	public String date_to;
	public ResultSet resultSet=null;
	public Connection con = null;
	public Statement statement=null;
	int columnsNumber;
	ResultSetMetaData rsmd;
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsersHistory window = new UsersHistory();
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
	public UsersHistory() throws ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 105, 348);
		frame.getContentPane().add(panel);
		
		JPanel d1 = new JPanel();
		d1.setBounds(139, 53, 309, 47);
		frame.getContentPane().add(d1);
		d1.setLayout(null);
		
		d1y = new JTextField();
		d1y.setBounds(10, 16, 96, 20);
		d1.add(d1y);
		d1y.setColumns(10);
		
		d1m = new JTextField();
		d1m.setColumns(10);
		d1m.setBounds(136, 16, 52, 20);
		d1.add(d1m);
		
		d1d = new JTextField();
		d1d.setColumns(10);
		d1d.setBounds(198, 16, 96, 20);
		d1.add(d1d);
		
		JLabel lblNewLabel = new JLabel("Year");
		lblNewLabel.setBounds(10, 0, 49, 14);
		d1.add(lblNewLabel);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(136, 0, 49, 14);
		d1.add(lblMonth);
		
		JLabel lblDay = new JLabel("day");
		lblDay.setBounds(198, 0, 49, 14);
		d1.add(lblDay);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFrom.setBounds(140, 28, 49, 14);
		frame.getContentPane().add(lblFrom);
		
		JPanel d1_1 = new JPanel();
		d1_1.setLayout(null);
		d1_1.setBounds(486, 53, 309, 47);
		frame.getContentPane().add(d1_1);
		
		d2y = new JTextField();
		d2y.setColumns(10);
		d2y.setBounds(10, 16, 96, 20);
		d1_1.add(d2y);
		
		d2m = new JTextField();
		d2m.setColumns(10);
		d2m.setBounds(136, 16, 52, 20);
		d1_1.add(d2m);
		
		d2d = new JTextField();
		d2d.setColumns(10);
		d2d.setBounds(198, 16, 96, 20);
		d1_1.add(d2d);
		
		JLabel lblNewLabel_1 = new JLabel("Year");
		lblNewLabel_1.setBounds(10, 0, 49, 14);
		d1_1.add(lblNewLabel_1);
		
		JLabel lblMonth_1 = new JLabel("Month");
		lblMonth_1.setBounds(136, 0, 49, 14);
		d1_1.add(lblMonth_1);
		
		JLabel lblDay_1 = new JLabel("day");
		lblDay_1.setBounds(198, 0, 49, 14);
		d1_1.add(lblDay_1);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTo.setBounds(486, 28, 49, 14);
		frame.getContentPane().add(lblTo);
		
		JButton check = new JButton("Check");
		
		check.setFont(new Font("Tahoma", Font.PLAIN, 15));
		check.setBounds(822, 66, 89, 23);
		frame.getContentPane().add(check);
		
		JButton Home = new JButton("Admin Home");
		Home.setHorizontalAlignment(SwingConstants.LEFT);
		Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminhome.main(null);
				frame.dispose();
			}
		});
		panel.add(Home);
		
		
		
		//
		
//		@SuppressWarnings("unused")
//		PreparedStatement preparedStatement=null;
		
		
	    String url = "jdbc:mysql://localhost:3306/door";
	    String username = "root";
	    
	    String password = "Ekam@2019";
	    
	    try { 
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      con = DriverManager.getConnection(url, username, password);
	      System.out.println("Connected!");
	      statement=con.createStatement();
	      
	      LocalDate ttt=java.time.LocalDate.now();
		  String date1=ttt.toString();
		  String date2="2022-05-01";
		  
		  //SELECT id ,email ,intime ,outtime   FROM 'history'  where  borrowed_date between date2 and date1
		  check.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					  try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				      try {
						con = DriverManager.getConnection(url, username, password);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				      System.out.println("Connected!");
				      try {
						statement=con.createStatement();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					date_from=d1y.getText()+"-"+d1m.getText()+"-"+d1d.getText();
					date_to=d2y.getText()+"-"+d2m.getText()+"-"+d2d.getText();
					try {
						resultSet=statement.executeQuery("SELECT id ,email ,intime ,outtime   FROM history  where  outtime between' "+date_from+"' and '"+ date_to+"'");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				     
				     
				     try {
						rsmd = resultSet.getMetaData();
						columnsNumber = rsmd.getColumnCount();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//System.out.println("Connenvcgvcted!");
				     
				      table = new JTable();
				      table.setModel(DbUtils.resultSetToTableModel(resultSet));
				      //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				      //table.setBounds(139, 132, 600, 600);
				      //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				      //table.setFillsViewportHeight(true);
				      JScrollPane scrollPanesss = new JScrollPane(table);
					  scrollPanesss.setBounds(100, 100, 600, 600);
					  frame.getContentPane().add(scrollPanesss);
				      //frame.getContentPane().add(table); 
				      try {
						while (resultSet.next()) {
						      for (int i = 1; i <= columnsNumber; i++) {
						    	  
						          if (i > 1) System.out.print(",  ");
						          String columnValue = resultSet.getString(i);
						          System.out.print(columnValue + " " + rsmd.getColumnName(i));
						      }
						      System.out.println("");
						  }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
//				      JScrollPane scroll = new JScrollPane(table);
//				      scroll.setHorizontalScrollBarPolicy(
			//
//				              JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			//
//				      scroll.setVerticalScrollBarPolicy(
			//
//				              JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
						
					
					
				}
		  });
	      


	      

	     
//	      JScrollPane scroll = new JScrollPane(table);
//	      scroll.setHorizontalScrollBarPolicy(
//
//	              JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//
//	      scroll.setVerticalScrollBarPolicy(
//
//	              JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
			
			
			
			
			
			
	      
	      
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
	
		
		//
	}
}
