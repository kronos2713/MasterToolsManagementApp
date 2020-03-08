package MasterTools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administration extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administration frame = new Administration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Administration() {
		setTitle("Administration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(204,204,204));
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/newuser.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(45, 114, 535, 457);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel2 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/employees.jpg")).getImage();
		lblNewLabel2.setIcon(new ImageIcon(img1));
		lblNewLabel2.setBounds(621, 107, 535, 464);
		contentPane.add(lblNewLabel2);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m = new Main();
				contentPane.setVisible(false);
				dispose();
				m.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 14));
		btnNewButton.setBounds(29, 20, 111, 33);
		contentPane.add(btnNewButton);
		
		JButton btn1 = new JButton("Create a new User");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewUser nu = new NewUser();
				contentPane.setVisible(false);
				dispose();
				nu.setVisible(true);
			}
		});
		btn1.setFont(new Font("Georgia", Font.BOLD, 20));
		btn1.setBounds(130, 581, 362, 64);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("Employee Database");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeDB ed = new EmployeeDB();
				contentPane.setVisible(false);
				dispose();
				ed.setVisible(true);
			}
		});
		btn2.setFont(new Font("Georgia", Font.BOLD, 20));
		btn2.setBounds(734, 581, 362, 64);
		contentPane.add(btn2);
	}
}
