package Book_shopping;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
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
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton b1 = new JButton("SHOPPING");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Amazon amazon=new Amazon();
				amazon.setVisible(true);
				
			}
		});
		b1.setFont(new Font("Tahoma", Font.BOLD, 20));
		b1.setBounds(115, 49, 172, 39);
		frame.getContentPane().add(b1);
		
		JButton b2 = new JButton("ADMIN");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.setVisible(true);
			}
		});
		b2.setFont(new Font("Tahoma", Font.BOLD, 20));
		b2.setBounds(134, 140, 136, 33);
		frame.getContentPane().add(b2);
	}
}
