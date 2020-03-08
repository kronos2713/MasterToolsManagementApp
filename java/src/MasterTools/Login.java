package MasterTools;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.FlowLayout;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private JPanel loginPane;
	private JTextField txtUsername;
	private JPasswordField txtPass;
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
					Login frame = new Login();
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
	public Login() {
		setType(Type.UTILITY);
		setState(Frame.ICONIFIED);
		setFont(new Font("Georgia", Font.BOLD, 20));
		setTitle("Login-MasterTools");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		loginPane = new JPanel();
		loginPane.setBackground(new Color(255, 255, 255));
		loginPane.setFont(new Font("Georgia", Font.BOLD, 18));
		loginPane.setToolTipText("");
		loginPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(loginPane);
		loginPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(83, 29, 640, 156);
		loginPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel_1.setBounds(163, 251, 150, 48);
		loginPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(163, 342, 150, 48);
		loginPane.add(lblNewLabel_1_1);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Georgia", Font.BOLD, 20));
		txtUsername.setBounds(382, 251, 191, 37);
		loginPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						if(txtUsername.getText().isEmpty() || txtPass.getText().isEmpty()) {
					
							JOptionPane.showMessageDialog(loginPane, "Username or password is blank.");
						}else {
							String username = txtUsername.getText();
							String password = txtPass.getText();
							Class.forName("com.mysql.jdbc.Driver");
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastertools", "root", "root" );
							stmt = con.prepareStatement("select* from users where username = ? and password = ?");
							stmt.setString(1, username);
							stmt.setString(2, password);
							rs = stmt.executeQuery();
							
							if(rs.next()) {
								Main m = new Main();
								loginPane.setVisible(false);
								dispose();
								m.setVisible(true);
								
							}else {
								JOptionPane.showMessageDialog(loginPane, "Incorrect username or password, please try again.");
								txtUsername.setText("");
								txtPass.setText("");
								txtUsername.requestFocus();
							}
							
						}
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {	
						e1.printStackTrace();
					}
			   }
				
			}
		});
		txtPass.setFont(new Font("Georgia", Font.BOLD, 20));
		txtPass.setBounds(382, 352, 191, 38);
		loginPane.add(txtPass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(txtUsername.getText().isEmpty() || txtPass.getText().isEmpty()) {
				
						JOptionPane.showMessageDialog(loginPane, "Username or password is blank.");
					}else {
						String username = txtUsername.getText();
						String password = txtPass.getText();
						Class.forName("com.mysql.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastertools", "root", "root" );
						stmt = con.prepareStatement("select* from users where username = ? and password = ?");
						stmt.setString(1, username);
						stmt.setString(2, password);
						rs = stmt.executeQuery();
						
						if(rs.next()) {
							Main m = new Main();
							loginPane.setVisible(false);
							dispose();
							m.setVisible(true);
							
						}else {
							JOptionPane.showMessageDialog(loginPane, "Incorrect username or password, please try again.");
							txtUsername.setText("");
							txtPass.setText("");
							txtUsername.requestFocus();
						}
						
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {	
					e1.printStackTrace();
				}
					
			}
		});
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 20));
		btnNewButton.setBounds(187, 454, 150, 37);
		loginPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText("");
				txtPass.setText("");
				
			}
		});
		btnCancel.setFont(new Font("Georgia", Font.BOLD, 20));
		btnCancel.setBounds(423, 454, 150, 37);
		loginPane.add(btnCancel);
	}
}
