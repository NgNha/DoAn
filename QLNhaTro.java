package ConnectSQL;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.jgoodies.forms.factories.DefaultComponentFactory;


import java.awt.Font;
import java.awt.Color;

public class QLNhaTro extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private Vector vT, vD;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLNhaTro frame = new QLNhaTro();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public QLNhaTro() throws SQLException {
		Connect cn = new Connect();
		Connection conn = cn.getConnection();
		setVisible(true);
		setTitle("QUAN LI KHACH HANG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 483);
		contentPane = new JPanel();
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 43, 625, 121);
		contentPane.add(scrollPane);
		
		table = new JTable();
		vD = new Vector();
		String sql = "SELECT * FROM qlnha";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				 Vector t = new Vector();
				 t.add(rs.getInt(1));
				 t.add(rs.getString(2));
				 t.add(rs.getString(3));
				 t.add(rs.getString(4));
				 t.add(rs.getString(5));
				 vD.add(t);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		vT = new Vector();
		vT.add("ID");
		vT.add("Name");
		vT.add("PhoneNumber");
		vT.add("IDHOUSE");
		vT.add("TimeRent");
		table.setModel(new DefaultTableModel(vD, vT));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(27);
		table.getColumnModel().getColumn(1).setPreferredWidth(125);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		scrollPane.setViewportView(table);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Management");
		lblNewJgoodiesLabel.setForeground(Color.DARK_GRAY);
		lblNewJgoodiesLabel.setFont(new Font(".VnArial", Font.BOLD, 20));
		lblNewJgoodiesLabel.setBounds(282, 11, 130, 21);
		contentPane.add(lblNewJgoodiesLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(40, 190, 67, 30);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(363, 190, 67, 30);
		contentPane.add(lblName);
		
		JLabel lblPhonenumber = new JLabel("PhoneNumber");
		lblPhonenumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhonenumber.setBounds(30, 255, 89, 30);
		contentPane.add(lblPhonenumber);
		
		JLabel lblIdhouse = new JLabel("IDHOUSE");
		lblIdhouse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdhouse.setBounds(363, 255, 67, 30);
		contentPane.add(lblIdhouse);
		
		JLabel lblThoigianthue_1 = new JLabel("TimeRent");
		lblThoigianthue_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblThoigianthue_1.setBounds(30, 322, 67, 30);
		contentPane.add(lblThoigianthue_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(117, 190, 160, 30);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(458, 190, 160, 30);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(117, 255, 160, 30);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(458, 255, 160, 30);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(117, 322, 160, 30);
		contentPane.add(textField_4);
		
		JButton btnFind = new JButton("FIND");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connect cn = new Connect();
					Connection conn = cn.getConnection();
					PreparedStatement ss = conn.prepareStatement("SELECT * FROM qlnha WHERE ID = ?");
					ss.setString(1, textField.getText());
					ResultSet tim = ss.executeQuery();
					if (tim.next()) {
						JOptionPane.showMessageDialog(null, "Find ID successfully");
						textField.setText(tim.getString("ID"));
						textField_1.setText(tim.getString("Name"));
						textField_2.setText(tim.getString("PhoneNumber"));
						textField_3.setText(tim.getString("IDHOUSE"));
						textField_4.setText(tim.getString("TimeRent"));
					} else {
						JOptionPane.showMessageDialog(null, "This ID does not exist!!!");
					}
				} catch (Exception e4) {
					// TODO: handle exception
					e4.printStackTrace();
				}
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFind.setBounds(510, 381, 160, 39);
		contentPane.add(btnFind);
		
		JButton btnNewButton_2_1 = new JButton("EDIT");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
/*				int a = table.getSelectedRow();
				if (a != -1) {
					Vector t = new Vector();
					t.add(textField.getText());
					t.add(textField_1.getText());
					t.add(textField_2.getText());
					t.add(textField_3.getText());
					t.add(textField_4.getText());
					vD.set(a, t);
					table.setModel(new DefaultTableModel(vD, vT));
				}
				try {
					Connect cn = new Connect();
					Connection conn = cn.getConnection();
					PreparedStatement stm = conn.prepareStatement("UPDATE qlnha SET Name = ? ,PhoneNumber = ?,IDHOUSE = ? ,TimeRent = ?  WHERE ID = ?");
					stm.setString(5, textField.getText());
					stm.setString(1, textField_1.getText());
					stm.setString(2, textField_2.getText());
					stm.setString(3, textField_3.getText());
					stm.setString(4, textField_4.getText());;
					stm.executeUpdate();		
					JOptionPane.showMessageDialog(null, "Update successful");
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
				}*/
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2_1.setBounds(10, 379, 151, 42);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k = table.getSelectedRow();
				if (k != -1) {
					vD.remove(k);
					table.setModel(new DefaultTableModel(vD, vT));
					JOptionPane.showMessageDialog(null, "Delete successfully", "", JOptionPane.INFORMATION_MESSAGE);
				}
				try {
					Connect cn = new Connect();
					Connection conn = cn.getConnection();
					PreparedStatement stm = conn.prepareStatement("DELETE FROM qlnha WHERE ID = ?");
					stm.setString(1, textField.getText());
					stm.executeUpdate();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(182, 379, 151, 42);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector t = new Vector();
				t.add(textField.getText());
				t.add(textField_1.getText());
				t.add(textField_2.getText());
				t.add(textField_3.getText());
				t.add(textField_4.getText());
				vD.add(t);
				table.setModel(new DefaultTableModel(vD, vT));
				JOptionPane.showMessageDialog(null, "Add to success!!!", "", JOptionPane.INFORMATION_MESSAGE);
				try {
					PreparedStatement stm = conn.prepareStatement("INSERT INTO qlnha(ID, Name, PhoneNumber, IDHOUSE, TimeRent) VALUES (?, ?, ?, ?, ?)");
					stm.setString(1, textField.getText());
					stm.setString(2, textField_1.getText());
					stm.setString(3, textField_2.getText());
					stm.setString(4, textField_3.getText());
					stm.setString(5, textField_4.getText());
					stm.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(343, 379, 151, 42);
		contentPane.add(btnNewButton_1);
		setLocationRelativeTo(null);
	}
}