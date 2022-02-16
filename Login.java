package ConnectSQL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPanel Login,Registration;
	private JPasswordField passwordField;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Login = new JPanel();
		Login.setBounds(45, 11, 328, 291);
		contentPane.add(Login);
		Login.setLayout(null);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("LOG IN");
		lblNewJgoodiesLabel_1.setFont(new Font("VnAachen2", Font.BOLD, 14));
		lblNewJgoodiesLabel_1.setBounds(132, 11, 75, 43);
		Login.add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Account");
		lblNewLabel_3.setFont(new Font("VnAachen2", Font.ITALIC, 10));
		lblNewLabel_3.setBounds(24, 77, 84, 23);
		Login.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setFont(new Font("VnAachen2", Font.ITALIC, 10));
		lblNewLabel_3_1.setBounds(24, 133, 84, 23);
		Login.add(lblNewLabel_3_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(118, 78, 155, 32);
		Login.add(textField_3);
		textField_3.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show password");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected() == true)
					passwordField.setEchoChar((char)0);
				else
					passwordField.setEchoChar('*');
			}
		});
		chckbxNewCheckBox.setFont(new Font("VNBengi", Font.BOLD, 8));
		chckbxNewCheckBox.setBounds(132, 173, 121, 16);
		Login.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					QLNhaTro frame = new QLNhaTro();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("VnAachen2", Font.ITALIC, 10));
		btnNewButton.setBounds(44, 217, 105, 50);
		Login.add(btnNewButton);
		
		JButton btnRegistration = new JButton("Registration");
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.setVisible(false);
				Registration.setVisible(true);
			}
		});
		btnRegistration.setFont(new Font("VnAachen2", Font.ITALIC, 10));
		btnRegistration.setBounds(184, 217, 105, 50);
		Login.add(btnRegistration);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 135, 155, 32);
		Login.add(passwordField);
		
		
		Registration = new JPanel();
		Registration.setVisible(false);
		Registration.setBounds(45, 11, 328, 291);
		contentPane.add(Registration);
		Registration.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(140, 81, 149, 25);
		Registration.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(140, 121, 149, 25);
		Registration.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(140, 165, 149, 25);
		Registration.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Account");
		lblNewLabel.setFont(new Font("VnAachen2", Font.ITALIC, 10));
		lblNewLabel.setBounds(20, 86, 78, 19);
		Registration.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("VnAachen2", Font.ITALIC, 10));
		lblNewLabel_1.setBounds(20, 126, 78, 19);
		Registration.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm password");
		lblNewLabel_2.setFont(new Font("VnAachen2", Font.ITALIC, 10));
		lblNewLabel_2.setBounds(20, 165, 111, 19);
		Registration.add(lblNewLabel_2);
		
		JButton btnngK = new JButton("Confirm");
		btnngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.setVisible(true);
				Registration.setVisible(false);
			}
		});
		btnngK.setFont(new Font("VnAachen2", Font.ITALIC, 10));
		btnngK.setBounds(112, 218, 99, 46);
		Registration.add(btnngK);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Registration");
		lblNewJgoodiesLabel.setFont(new Font("VnAachen2", Font.BOLD, 14));
		lblNewJgoodiesLabel.setBackground(Color.GRAY);
		lblNewJgoodiesLabel.setBounds(112, 11, 124, 39);
		Registration.add(lblNewJgoodiesLabel);
		
		setLocationRelativeTo(null);
	}
}
