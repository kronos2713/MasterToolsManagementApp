package MasterTools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class EmployeeDB extends JFrame {

	private JPanel contentPane;
	private JTextField txtlname;
	private JTextField txtfunction;
	private JTextField txtphone;
	private JTextField txtemail;
	private JTextField txtfname;
	private JTextField txtsalary;
	private JTable table;
	
	Connection con;
	PreparedStatement stmt;
	protected Object ex;
	
	


	private void tabelUpdate() {
		int c;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastertools", "root" , "root");
			stmt = con.prepareStatement("select * from employee");
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData Rss = rs.getMetaData(); 
			c = Rss.getColumnCount();
			
			DefaultTableModel Df = (DefaultTableModel)table.getModel();
			Df.setRowCount(0);
			
			while(rs.next()){
				Vector v1 = new Vector();
				
				for(int i=1; i<=c; i++) {
					
					v1.add(rs.getString("id"));
					v1.add(rs.getString("firstname"));
					v1.add(rs.getString("lastname"));
					v1.add(rs.getString("Role"));
					v1.add(rs.getString("phone"));
					v1.add(rs.getString("email"));
					v1.add(rs.getString("salary"));
				}
				
				Df.addRow(v1);
			} 
			
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}
		catch (SQLException e1) {
		
			e1.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeDB frame = new EmployeeDB();
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
	public EmployeeDB() {
		setFont(new Font("Georgia", Font.BOLD, 20));
		setTitle("Employee Database");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/employees.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(31, 58, 483, 224);
		contentPane.add(lblNewLabel);
		
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
		btnNewButton.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel_1.setBounds(31, 338, 178, 31);
		contentPane.add(lblNewLabel_1);
		
		txtlname = new JTextField();
		txtlname.setFont(new Font("Georgia", Font.BOLD, 15));
		txtlname.setBounds(219, 340, 243, 31);
		contentPane.add(txtlname);
		txtlname.setColumns(10);
		
		txtfunction = new JTextField();
		txtfunction.setFont(new Font("Georgia", Font.BOLD, 15));
		txtfunction.setColumns(10);
		txtfunction.setBounds(219, 381, 243, 31);
		contentPane.add(txtfunction);
		
		txtphone = new JTextField();
		txtphone.setFont(new Font("Georgia", Font.BOLD, 15));
		txtphone.setColumns(10);
		txtphone.setBounds(219, 422, 243, 31);
		contentPane.add(txtphone);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Georgia", Font.BOLD, 15));
		txtemail.setColumns(10);
		txtemail.setBounds(219, 463, 243, 31);
		contentPane.add(txtemail);
		
		txtsalary = new JTextField();
		txtsalary.setFont(new Font("Georgia", Font.BOLD, 15));
		txtsalary.setColumns(10);
		txtsalary.setBounds(219, 504, 243, 31);
		contentPane.add(txtsalary);
		
		JLabel lblNewLabel_1_1 = new JLabel("Role");
		lblNewLabel_1_1.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(31, 379, 178, 31);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblVAT = new JLabel("Phone");
		lblVAT.setFont(new Font("Georgia", Font.BOLD, 20));
		lblVAT.setBounds(31, 420, 178, 31);
		contentPane.add(lblVAT);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email");
		lblNewLabel_1_3.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(31, 461, 178, 31);
		contentPane.add(lblNewLabel_1_3);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fName = txtfname.getText();
				String lName = txtlname.getText();
				String Role = txtfunction.getText();
				String phone = txtphone.getText();
				String email = txtemail.getText();
				String salary = txtsalary.getText();
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastertools", "root" , "root");
					stmt = con.prepareStatement("insert into employee(firstname,lastname,Role,phone,email,salary)values(?,?,?,?,?,?)");
					stmt.setString(1, fName);
					stmt.setString(2, lName);
					stmt.setString(3, Role);
					stmt.setString(4, phone);
					stmt.setString(5, email);
					stmt.setString(6, salary);
					stmt.executeUpdate();
					
					JOptionPane.showMessageDialog(contentPane, "Employee added.");
					tabelUpdate(); 
					
					txtfname.setText("");
					txtlname.setText("");
					txtfunction.setText("");
					txtphone.setText("");
					txtemail.setText("");
					txtsalary.setText("");
					txtlname.requestFocus();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
				}
		});
		btnNewButton_1.setFont(new Font("Georgia", Font.BOLD, 20));
		btnNewButton_1.setBounds(31, 585, 105, 48);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Edit");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int selectedIndex = table.getSelectedRow();
				int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
				String fName = txtfname.getText();
				String lName = txtlname.getText();
				String Role = txtfunction.getText();
				String phone = txtphone.getText();
				String email = txtemail.getText();
				String salary = txtsalary.getText();
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastertools", "root" , "root");
					stmt = con.prepareStatement("update employee set firstname=?, lastname=? , Role=?, phone=?, email=?, salary=? where id=? ");
					stmt.setString(1, fName);
					stmt.setString(2, lName);
					stmt.setString(3, Role);
					stmt.setString(4, phone);
					stmt.setString(5, email);
					stmt.setString(6, salary);
					stmt.setInt(7, id);
					stmt.executeUpdate();
					
					
					
					JOptionPane.showMessageDialog(contentPane, "Employee updated.");
					tabelUpdate(); 
					
					txtfname.setText("");
					txtlname.setText("");
					txtfunction.setText("");
					txtphone.setText("");
					txtemail.setText("");
					txtsalary.setText("");
					txtlname.requestFocus();
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				}
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Georgia", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(174, 585, 105, 48);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Remove");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int selectedIndex = table.getSelectedRow();
				
				try {
					int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
					int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this employee?","Warning",JOptionPane.YES_NO_OPTION);
					
					if(dialogResult == JOptionPane.YES_OPTION) {
						Class.forName("com.mysql.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastertools", "root" , "root");
						stmt = con.prepareStatement("delete from employee where id=?");
						stmt.setInt(1, id);
						
						stmt.executeUpdate();
						
						JOptionPane.showMessageDialog(contentPane, "Employee removed.");
						tabelUpdate(); 
						
						txtfname.setText("");
						txtlname.setText("");
						txtfunction.setText("");
						txtphone.setText("");
						txtemail.setText("");
						txtsalary.setText("");
						txtlname.requestFocus();
					}
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				}
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_2.setFont(new Font("Georgia", Font.BOLD, 20));
		btnNewButton_1_2.setBounds(309, 585, 130, 48);
		contentPane.add(btnNewButton_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(547, 58, 583, 575);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int selectedIndex = table.getSelectedRow();
				
				txtfname.setText(Df.getValueAt(selectedIndex, 1).toString());
				txtlname.setText(Df.getValueAt(selectedIndex, 2).toString());
				txtfunction.setText(Df.getValueAt(selectedIndex, 3).toString());
				txtphone.setText(Df.getValueAt(selectedIndex, 4).toString());
				txtemail.setText(Df.getValueAt(selectedIndex, 5).toString());
				txtsalary.setText(Df.getValueAt(selectedIndex, 6).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "First Name", "Last Name", "Role", "Phone", "Email", "Salary"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.setFont(new Font("Georgia", Font.PLAIN, 14));
		tabelUpdate();
		
		JLabel lblNewLabel_1_2 = new JLabel("First Name");
		lblNewLabel_1_2.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(31, 297, 178, 31);
		contentPane.add(lblNewLabel_1_2);
		
		txtfname = new JTextField();
		txtfname.setFont(new Font("Georgia", Font.BOLD, 15));
		txtfname.setColumns(10);
		txtfname.setBounds(219, 299, 243, 31);
		contentPane.add(txtfname);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Salary");
		lblNewLabel_1_3_1.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel_1_3_1.setBounds(31, 502, 178, 31);
		contentPane.add(lblNewLabel_1_3_1);
		
		
	}
}
