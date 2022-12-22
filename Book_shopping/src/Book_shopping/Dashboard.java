package Book_shopping;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Dashboard {

	private JFrame frame;
	String cart=null,cost=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
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
	public Dashboard() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/it","root","root");
			Statement stmt=con.createStatement();
			String qry="select * from books";
			ResultSet rs=stmt.executeQuery(qry);
			//String cart=null,cost=null;
			while(rs.next()) {
				cart=rs.getString(1);
				cost=rs.getString(2);
			}
			//lb1.setText("Total Products sold:"+cart);
			//lb2.setText("Total Cost:"+cost);
			stmt.close();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dashboard");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(158, 11, 124, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lb1 = new JLabel("Total Products Sold:"+cart);
		lb1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb1.setBounds(40, 80, 333, 31);
		frame.getContentPane().add(lb1);
		JLabel lb2 = new JLabel("Total Cost:"+cost);
		lb2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb2.setBounds(40, 160, 242, 22);
		frame.getContentPane().add(lb2);
		
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
		
	}

}
