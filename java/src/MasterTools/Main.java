package MasterTools;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

public class Main extends JFrame {

	private JPanel contentPane;
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setBackground(new Color(204, 204, 204));
		setTitle("Master Tools");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/cordless.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(804, 64, 355, 220);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/power4.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(33, 367, 355, 220);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/woodworking.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		lblNewLabel_2.setBounds(419, 367,355, 220);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/outdoor.jpg")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img3));
		lblNewLabel_3.setBounds(804, 367, 355, 220);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/administration.jpg")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img4));
		lblNewLabel_4.setBounds(33, 64, 355, 220);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/suppliers.jpg")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(img5));
		lblNewLabel_5.setBounds(419, 64, 355, 220);
		contentPane.add(lblNewLabel_5);
		
		JButton btn1 = new JButton("CORDLESS TOOLS");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CordlessTools c = new CordlessTools();
				contentPane.setVisible(false);
				dispose();
				c.setVisible(true);
			}
		});
		btn1.setForeground(new Color(255, 255, 255));
		btn1.setFont(new Font("Georgia", Font.BOLD, 26));
		btn1.setBounds(804, 294, 355, 58);
		contentPane.add(btn1);
		btn1.setBackground(Color.DARK_GRAY);
		
		JButton btn3 = new JButton("WOODWORKING");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Woodworking w = new Woodworking();
				contentPane.setVisible(false);
				dispose();
				w.setVisible(true);
			}
		});
		btn3.setForeground(new Color(255, 255, 255));
		btn3.setFont(new Font("Georgia", Font.BOLD, 26));
		btn3.setBackground(Color.DARK_GRAY);
		btn3.setBounds(419, 597, 355, 58);
		contentPane.add(btn3);
		
		JButton btn2 = new JButton("POWER TOOLS");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PowerTools p = new PowerTools();
				contentPane.setVisible(false);
				dispose();
				p.setVisible(true);
			}
		});
		btn2.setForeground(new Color(255, 255, 255));
		btn2.setFont(new Font("Georgia", Font.BOLD, 26));
		btn2.setBackground(Color.DARK_GRAY);
		btn2.setBounds(33, 597, 355, 58);
		contentPane.add(btn2);
		
		JButton btn4 = new JButton("OUTDOOR TOOLS");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Outdoor o = new Outdoor();
				contentPane.setVisible(false);
				dispose();
				o.setVisible(true);
			}
		});
		btn4.setForeground(new Color(255, 255, 255));
		btn4.setFont(new Font("Georgia", Font.BOLD, 26));
		btn4.setBackground(Color.DARK_GRAY);
		btn4.setBounds(804, 597, 355, 58);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("ADMINISTRATION");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Administration adm = new Administration();
					contentPane.setVisible(false);
					dispose();
					adm.setVisible(true);	
			}
		});
		btn5.setForeground(Color.WHITE);
		btn5.setFont(new Font("Georgia", Font.BOLD, 26));
		btn5.setBackground(Color.DARK_GRAY);
		btn5.setBounds(33, 294, 355, 58);
		contentPane.add(btn5);
		
		
		JButton btn6 = new JButton("SUPPLIERS");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Suppliers sp = new Suppliers();
				contentPane.setVisible(false);
				dispose();
				sp.setVisible(true);
			}
		});
		btn6.setForeground(Color.WHITE);
		btn6.setFont(new Font("Georgia", Font.BOLD, 26));
		btn6.setBackground(Color.DARK_GRAY);
		btn6.setBounds(419, 294, 355, 58);
		contentPane.add(btn6);
		
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Login l = new Login();
					contentPane.setVisible(false);
					dispose();
					l.setVisible(true);
				}
		});
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 14));
		btnNewButton.setBounds(1005, 10, 100, 25);
		contentPane.add(btnNewButton);
	
		
		
	}
}
