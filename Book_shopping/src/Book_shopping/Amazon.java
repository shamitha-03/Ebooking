package Book_shopping;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Amazon {

	private JFrame frame;
	int cart=0;
	int cost=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Amazon window = new Amazon();
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
	public Amazon() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 502, 351);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AMAZON");
		lblNewLabel.setBounds(46, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\on lab\\Desktop\\book1.PNG"));
		lblNewLabel_1.setBounds(29, 45, 117, 154);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\on lab\\Desktop\\book2.PNG"));
		lblNewLabel_2.setBounds(156, 45, 127, 154);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\on lab\\Desktop\\book3.PNG"));
		lblNewLabel_3.setBounds(305, 45, 134, 154);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lb1 = new JLabel("cart:0");
		lb1.setBounds(230, 11, 46, 14);
		frame.getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("cost:0");
		lb2.setBounds(322, 11, 100, 14);
		frame.getContentPane().add(lb2);
		
		JLabel lblNewLabel_6 = new JLabel("200/-");
		lblNewLabel_6.setBounds(166, 210, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("100/-");
		lblNewLabel_6_1.setBounds(29, 208, 46, 14);
		frame.getContentPane().add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("300/-");
		lblNewLabel_6_2.setBounds(315, 210, 46, 14);
		frame.getContentPane().add(lblNewLabel_6_2);
		
		JButton a1 = new JButton("Add to cart");
		a1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cart=cart+1;
				lb1.setText("cart:"+cart);
				cost=cost+100;
				lb2.setText("cost:"+cost);
				
			}
		});
		a1.setBounds(57, 206, 89, 18);
		frame.getContentPane().add(a1);
		
		JButton a2 = new JButton("Add to cart");
		a2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cart=cart+1;
				lb1.setText("cart:"+cart);
				cost=cost+200;
				lb2.setText("cost:"+cost);
			}
		});
		a2.setBounds(199, 206, 84, 18);
		frame.getContentPane().add(a2);
		
		JButton a3 = new JButton("Add to cart");
		a3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cart=cart+1;
				lb1.setText("cart:"+cart);
				cost=cost+300;
				lb2.setText("cost:"+cost);
			}
		});
		a3.setBounds(350, 206, 89, 23);
		frame.getContentPane().add(a3);
		
		JComboBox c1 = new JComboBox();
		c1.setModel(new DefaultComboBoxModel(new String[] {"Paper", "Kindel", "Pdf"}));
		c1.setBounds(29, 233, 117, 22);
		frame.getContentPane().add(c1);
		
		JComboBox c2 = new JComboBox();
		c2.setModel(new DefaultComboBoxModel(new String[] {"Paper", "Kindel", "Pdf"}));
		c2.setBounds(156, 233, 127, 22);
		frame.getContentPane().add(c2);
		
		JComboBox c3 = new JComboBox();
		c3.setModel(new DefaultComboBoxModel(new String[] {"Paper", "Kindel", "Pdf"}));
		c3.setBounds(305, 235, 134, 22);
		frame.getContentPane().add(c3);
		
		JButton done = new JButton("DONE");
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(done, cart);
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/it","root","root");
					Statement stmt=con.createStatement();
					String qry="insert into books values('"+cart+"','"+cost+"')";
					stmt.executeUpdate(qry);
					JOptionPane.showMessageDialog(done, "Done!!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		done.setFont(new Font("Tahoma", Font.BOLD, 18));
		done.setBounds(182, 266, 89, 23);
		frame.getContentPane().add(done);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
		
	}
}
