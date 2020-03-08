package MasterTools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;



public class CordlessTools extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtVAT;
	private JTextField txtStoc;
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
			stmt = con.prepareStatement("select * from cordless");
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData Rss = rs.getMetaData(); 
			c = Rss.getColumnCount();
			
			DefaultTableModel Df = (DefaultTableModel)table.getModel();
			Df.setRowCount(0);
			
			while(rs.next()){
				Vector v1 = new Vector();
				
				for(int i=1; i<=c; i++) {
					
					v1.add(rs.getString("id"));
					v1.add(rs.getString("suppliers"));
					v1.add(rs.getString("productname"));
					v1.add(rs.getString("price"));
					v1.add(rs.getString("vat"));
					v1.add(rs.getString("stoc"));
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
					CordlessTools frame = new CordlessTools();
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
	public CordlessTools() {
		setFont(new Font("Georgia", Font.BOLD, 20));
		setTitle("Power Tools");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/cordless.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(31, 58, 431, 215);
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
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel_1.setBounds(31, 328, 178, 31);
		contentPane.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Georgia", Font.BOLD, 15));
		txtName.setBounds(219, 328, 243, 31);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Georgia", Font.BOLD, 15));
		txtPrice.setColumns(10);
		txtPrice.setBounds(219, 379, 243, 31);
		contentPane.add(txtPrice);
		
		txtVAT = new JTextField();
		txtVAT.setFont(new Font("Georgia", Font.BOLD, 15));
		txtVAT.setColumns(10);
		txtVAT.setBounds(219, 438, 243, 31);
		contentPane.add(txtVAT);
		
		txtStoc = new JTextField();
		txtStoc.setFont(new Font("Georgia", Font.BOLD, 15));
		txtStoc.setColumns(10);
		txtStoc.setBounds(219, 499, 243, 31);
		contentPane.add(txtStoc);
		
		JLabel lblNewLabel_1_1 = new JLabel("Price");
		lblNewLabel_1_1.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(31, 379, 178, 31);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblVAT = new JLabel("V.A.T");
		lblVAT.setFont(new Font("Georgia", Font.BOLD, 20));
		lblVAT.setBounds(31, 438, 178, 31);
		contentPane.add(lblVAT);
		
		JLabel lblNewLabel_1_3 = new JLabel("Stock");
		lblNewLabel_1_3.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(31, 499, 178, 31);
		contentPane.add(lblNewLabel_1_3);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String supplier = txtSuppliers.getText();
				String name = txtName.getText();
				String price = txtPrice.getText();
				String vat = txtVAT.getText();
				String stoc = txtStoc.getText();
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastertools", "root" , "root");
					stmt = con.prepareStatement("insert into cordless(suppliers,productname,price,vat,stoc)values(?,?,?,?,?)");
					stmt.setString(1, supplier);
					stmt.setString(2, name);
					stmt.setString(3, price);
					stmt.setString(4, vat);
					stmt.setString(5, stoc);
					stmt.executeUpdate();
					
					JOptionPane.showMessageDialog(contentPane, "Product added.");
					tabelUpdate(); 
					
					txtSuppliers.setText(" ");
					txtName.setText(" ");
					txtPrice.setText(" ");
					txtVAT.setText(" ");
					txtStoc.setText(" ");
					txtName.requestFocus();
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
					String name = txtName.getText();
					String price = txtPrice.getText();
					String vat = txtVAT.getText();
					String stoc = txtStoc.getText();
					
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastertools", "root" , "root");
					stmt = con.prepareStatement("update cordless set suppliers=?, productname=? , price=?, vat=?, stoc=? where id=? ");
					stmt.setString(1, supplier);
					stmt.setString(2, name);
					stmt.setString(3, price);
					stmt.setString(4, vat);
					stmt.setString(5, stoc);
					stmt.setInt(6, id);
					
					stmt.executeUpdate();
					
					JOptionPane.showMessageDialog(contentPane, "Product updated.");
					tabelUpdate(); 
					
					txtSuppliers.setText(" ");
					txtName.setText(" ");
					txtPrice.setText(" ");
					txtVAT.setText(" ");
					txtStoc.setText(" ");
					txtName.requestFocus();
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				}
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		JButton btnNewButton_1_2 = new JButton("Delete");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int selectedIndex = table.getSelectedRow();
				
				try {
					int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
					int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this product?","Warning",JOptionPane.YES_NO_OPTION);
					
					if(dialogResult == JOptionPane.YES_OPTION) {
						Class.forName("com.mysql.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastertools", "root" , "root");
						stmt = con.prepareStatement("delete from cordless where id=?");
						stmt.setInt(1, id);
						
						stmt.executeUpdate();
						
						JOptionPane.showMessageDialog(contentPane, "Record Deleted.");
						tabelUpdate(); 
						
						txtSuppliers.setText(" ");
						txtName.setText(" ");
						txtPrice.setText(" ");
						txtVAT.setText(" ");
						txtStoc.setText(" ");
						txtName.requestFocus();
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
						txtName.setText(Df.getValueAt(selectedIndex, 2).toString());
						txtPrice.setText(Df.getValueAt(selectedIndex, 3).toString());
						txtVAT.setText(Df.getValueAt(selectedIndex, 4).toString());
						txtStoc.setText(Df.getValueAt(selectedIndex, 5).toString());
					}
				});
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
					},
					new String[] {
						"Id", "Supplier", "Product Name", "Price", "V.A.T", "Stock"
					}
				));
				table.getColumnModel().getColumn(0).setPreferredWidth(40);
				table.getColumnModel().getColumn(1).setPreferredWidth(80);
				table.getColumnModel().getColumn(2).setPreferredWidth(150);
				table.getColumnModel().getColumn(3).setPreferredWidth(60);
				table.getColumnModel().getColumn(4).setPreferredWidth(60);
			table.setFont(new Font("Georgia", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2 = new JLabel("Supplier");
		lblNewLabel_1_2.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(31, 283, 178, 31);
		contentPane.add(lblNewLabel_1_2);
		
		txtSuppliers = new JTextField();
		txtSuppliers.setFont(new Font("Georgia", Font.BOLD, 15));
		txtSuppliers.setColumns(10);
		txtSuppliers.setBounds(219, 283, 243, 31);
		contentPane.add(txtSuppliers);
		tabelUpdate();
	}
}
