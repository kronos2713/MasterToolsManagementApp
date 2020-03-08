package MasterTools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Frame;

public class NewUser extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JPasswordField txtConfirmPass;
	Connection con;
	PreparedStatement stmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser frame = new NewUser();
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
	public NewUser() {
		setForeground(new Color(64, 224, 208));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(204,204,204));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 786, 563);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setBounds(83, 105, 220, 42);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Verdana", Font.BOLD, 20));
		lblPassword.setBounds(83, 198, 220, 42);
		panel.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Verdana", Font.BOLD, 20));
		lblConfirmPassword.setBounds(83, 289, 220, 42);
		panel.add(lblConfirmPassword);
		
		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setFont(new Font("Verdana", Font.BOLD, 20));
		lblUserType.setBounds(83, 376, 220, 42);
		panel.add(lblUserType);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Verdana", Font.BOLD, 20));
		txtUser.setBounds(339, 112, 192, 35);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Verdana", Font.BOLD, 20));
		txtPass.setBounds(339, 198, 192, 42);
		panel.add(txtPass);
		
		txtConfirmPass = new JPasswordField();
		txtConfirmPass.setFont(new Font("Verdana", Font.BOLD, 20));
		txtConfirmPass.setBounds(339, 289, 192, 42);
		panel.add(txtConfirmPass);
		
		JComboBox txtUType = new JComboBox();
		txtUType.setModel(new DefaultComboBoxModel(new String[] {"User", "Admin"}));
		txtUType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUType.setBounds(339, 376, 192, 42);
		panel.add(txtUType);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtUser.getText().length() == 0) {
					JOptionPane.showMessageDialog(panel, "Please type a username.");
				}else if(txtPass.getText().length() == 0) {
					JOptionPane.showMessageDialog(panel, "Please type a username.");
				}else if(txtPass.getText().equals(txtConfirmPass.getText()) == false) {
					JOptionPane.showMessageDialog(panel, "Passwords don't match, please type again.");
				}else {
					try {
						
						String username = txtUser.getText();
						String confirmPass = txtConfirmPass.getText();
						String userType = txtUType.getSelectedItem().toString();
						Class.forName("com.mysql.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastertools", "root", "root" );
						stmt = con.prepareStatement("insert into users(username,password,usertype)values(?,?,?)");
						stmt.setString(1, username);
						stmt.setString(2, confirmPass);
						stmt.setString(3, userType);
						stmt.executeUpdate();
						JOptionPane.showMessageDialog(panel, "User created.");
						txtUser.setText(" ");
						txtPass.setText(" ");
						txtConfirmPass.setText(" ");
						txtUType.setSelectedIndex(-1);
						txtUser.requestFocus();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				
			}
		});
		btnAdd.setForeground(new Color(245, 245, 220));
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAdd.setBounds(165, 479, 162, 48);
		panel.add(btnAdd);
		btnAdd.setBackground(Color.DARK_GRAY);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(245, 245, 220));
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCancel.setBounds(441, 479, 162, 48);
		panel.add(btnCancel);
		btnCancel.setBackground(Color.DARK_GRAY);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administration adm = new Administration();
				contentPane.setVisible(false);
				dispose();
				adm.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 14));
		btnNewButton.setBounds(24, 10, 85, 21);
		panel.add(btnNewButton);
	}
}
