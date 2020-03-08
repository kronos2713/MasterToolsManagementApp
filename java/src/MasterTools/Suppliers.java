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

public class Suppliers extends JFrame {
	private JPanel contentPane;
	private JTextField txtCountry;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtSuppliers;
	private JTable table;
	Connection con;
	PreparedStatement stmt;
	protected Object ex;
	


	private void tabelUpdate() {
		int c;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastertools", "root" , "root");
			stmt = con.prepareStatement("select * from suppliers");
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData Rss = rs.getMetaData(); 
			c = Rss.getColumnCount();
			
			DefaultTableModel Df = (DefaultTableModel)table.getModel();
			Df.setRowCount(0);
			
			while(rs.next()){
				Vector v1 = new Vector();
				
				for(int i=1; i<=c; i++) {
					
					v1.add(rs.getString("id"));
					v1.add(rs.getString("name"));
					v1.add(rs.getString("country"));
					v1.add(rs.getString("phone"));
					v1.add(rs.getString("email"));
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
					Suppliers frame = new Suppliers();
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
	public Suppliers () {
		setFont(new Font("Georgia", Font.BOLD, 20));
		setTitle("Suppliers");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/suppliers.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(59, 58, 355, 215);
		contentPane.add(lblNewLabel);
		
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
		btnNewButton.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Country");
		lblNewLabel_1.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel_1.setBounds(31, 363, 178, 31);
		contentPane.add(lblNewLabel_1);
		
		txtCountry = new JTextField();
		txtCountry.setFont(new Font("Georgia", Font.BOLD, 15));
		txtCountry.setBounds(219, 363, 243, 31);
		contentPane.add(txtCountry);
		txtCountry.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Georgia", Font.BOLD, 15));
		txtPhone.setColumns(10);
		txtPhone.setBounds(219, 414, 243, 31);
		contentPane.add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Georgia", Font.BOLD, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(219, 473, 243, 31);
		contentPane.add(txtEmail);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone");
		lblNewLabel_1_1.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(31, 412, 178, 31);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblVAT = new JLabel("Email");
		lblVAT.setFont(new Font("Georgia", Font.BOLD, 20));
		lblVAT.setBounds(31, 471, 178, 31);
		contentPane.add(lblVAT);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String supplier = txtSuppliers.getText();
				String country = txtCountry.getText();
				String phone = txtPhone.getText();
				String email = txtEmail.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastertools", "root" , "root");
					stmt = con.prepareStatement("insert into suppliers(name,country,phone,email)values(?,?,?,?)");
					stmt.setString(1, supplier);
					stmt.setString(2, country);
					stmt.setString(3, phone);
					stmt.setString(4, email);
					stmt.executeUpdate();
					
					JOptionPane.showMessageDialog(contentPane, "Supplier added.");
					tabelUpdate(); 
					
					txtSuppliers.setText(" ");
					txtCountry.setText(" ");
					txtPhone.setText(" ");
					txtEmail.setText(" ");
					txtSuppliers.requestFocus();
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
				
				try {
					
					int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
					String supplier = txtSuppliers.getText();
					String country = txtCountry.getText();
					String phone = txtPhone.getText();
					String email = txtEmail.getText();
					
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastertools", "root" , "root");
					stmt = con.prepareStatement("update suppliers set name=?, country=? , phone=?, email=? where id=? ");
					stmt.setString(1, supplier);
					stmt.setString(2, country);
					stmt.setString(3, phone);
					stmt.setString(4, email);
					stmt.setInt(5, id);
					
					stmt.executeUpdate();
					
					JOptionPane.showMessageDialog(contentPane, "Supplier updated.");
					tabelUpdate(); 
					

					txtSuppliers.setText(" ");
					txtCountry.setText(" ");
					txtPhone.setText(" ");
					txtEmail.setText(" ");
					txtSuppliers.requestFocus();
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
		
		JButton btnNewButton_1_2 = new JButton("Delete");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int selectedIndex = table.getSelectedRow();
				
				try {
					int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
					int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this supplier?","Warning",JOptionPane.YES_NO_OPTION);
					
					if(dialogResult == JOptionPane.YES_OPTION) {
						Class.forName("com.mysql.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastertools", "root" , "root");
						stmt = con.prepareStatement("delete from suppliers where id=?");
						stmt.setInt(1, id);
						
						stmt.executeUpdate();
						
						JOptionPane.showMessageDialog(contentPane, "Record Deleted.");
						tabelUpdate(); 
						
						txtSuppliers.setText(" ");
						txtCountry.setText(" ");
						txtPhone.setText(" ");
						txtEmail.setText(" ");
						txtSuppliers.requestFocus();
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
		btnNewButton_1_2.setBounds(309, 585, 105, 48);
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
				
				txtSuppliers.setText(Df.getValueAt(selectedIndex, 1).toString());
				txtCountry.setText(Df.getValueAt(selectedIndex, 2).toString());
				txtPhone.setText(Df.getValueAt(selectedIndex, 3).toString());
				txtEmail.setText(Df.getValueAt(selectedIndex, 4).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Id", "Name", "Country", "Phone", "Email"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(130);
		table.setFont(new Font("Georgia", Font.PLAIN, 16));
		tabelUpdate();
		
		JLabel lblNewLabel_1_2 = new JLabel("Supplier");
		lblNewLabel_1_2.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(31, 316, 178, 31);
		contentPane.add(lblNewLabel_1_2);
		
		txtSuppliers = new JTextField();
		txtSuppliers.setFont(new Font("Georgia", Font.BOLD, 15));
		txtSuppliers.setColumns(10);
		txtSuppliers.setBounds(219, 316, 243, 31);
		contentPane.add(txtSuppliers);
	}
}