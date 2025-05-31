package main;

import javax.swing.JOptionPane;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class signupForm extends JFrame {
	
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    

	private JPanel contentPane;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtUserId;
	private JPasswordField txtSPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signupForm frame = new signupForm();
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
	public signupForm() {
		
		conn = MyConnection.getConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1176, 743);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel header = new JPanel();
		contentPane.add(header, BorderLayout.CENTER);
		header.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1148, 108);
		panel.setBackground(new Color(0, 204, 204));
		header.add(panel);
		panel.setLayout(null);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setForeground(Color.WHITE);
		lblSignUp.setBounds(487, 41, 155, 54);
		lblSignUp.setFont(new Font("Times New Roman", Font.BOLD, 45));
		panel.add(lblSignUp);
		
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblFirstName.setBounds(388, 148, 110, 27);
		header.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblLastName.setBounds(658, 148, 110, 29);
		header.add(lblLastName);
		
		txtFname = new JTextField();
		txtFname.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtFname.setBounds(388, 188, 190, 46);
		header.add(txtFname);
		txtFname.setColumns(10);
		
		txtLname = new JTextField();
		txtLname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtLname.setBounds(658, 188, 190, 46);
		header.add(txtLname);
		txtLname.setColumns(10);
		
		JLabel lblUserId = new JLabel("User Id:");
		lblUserId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUserId.setBounds(388, 249, 132, 27);
		header.add(lblUserId);
		
		txtUserId = new JTextField();
		txtUserId.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtUserId.setBounds(388, 289, 460, 46);
		header.add(txtUserId);
		txtUserId.setColumns(10);
		
		JLabel lblEmialId = new JLabel("Password:");
		lblEmialId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmialId.setBounds(388, 431, 110, 35);
		header.add(lblEmialId);
		
		txtSPass = new JPasswordField();
		txtSPass.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtSPass.setBounds(388, 474, 460, 46);
		header.add(txtSPass);
		
		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDesignation.setBounds(388, 348, 157, 27);
		header.add(lblDesignation);
		
		final JComboBox txtdes = new JComboBox();
		txtdes.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtdes.setModel(new DefaultComboBoxModel(new String[] {"User", "Medical Professional ", "Volunteer", "Community Leader"}));
		txtdes.setBounds(388, 390, 460, 46);
		header.add(txtdes);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//GEN-FIRST:event_jButton1ActionPerformed
			        // TODO add your handling code here:
			        int a = JOptionPane.showConfirmDialog(null, "Are you Sure to add this record ?", "Add Record", JOptionPane.YES_NO_OPTION);
			        if (a == 0) {
			            try {
			                String sql = "INSERT INTO `loginuser`(`uname`, `pass`, `fname`, `lname`, `designation`) VALUES (?,?,?,?,?)";
			                ps = conn.prepareStatement(sql);
			                
			                ps.setString(1, txtFname.getText());
			                ps.setString(2, String.valueOf(txtSPass.getPassword()));
			                ps.setString(3, txtFname.getText());
			                ps.setString(4, txtLname.getText());
			                ps.setString(5, (String) txtdes.getSelectedItem());
			                ps.execute();

			                JOptionPane.showMessageDialog(null, "Data Saved Successfully");
			                LoginForm l = new LoginForm();
			                l.setVisible(true);
			                signupForm.this.dispose();
			                
			            } catch (Exception ex) {
			                JOptionPane.showMessageDialog(null, ex);
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "Data not saved Successfully in Database");
			        }
			    }
			
		});
	
		
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(new Color(0, 204, 204));
		btnSignUp.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnSignUp.setBounds(468, 539, 302, 45);
		header.add(btnSignUp);
		
		JLabel lblAccs = new JLabel("Already have an account?");
		lblAccs.setForeground(Color.GRAY);
		lblAccs.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAccs.setBounds(530, 597, 162, 27);
		header.add(lblAccs);
		
		JLabel lblLoginNow = new JLabel("LOGIN NOW");
		lblLoginNow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginForm l = new LoginForm();
                l.setVisible(true);
                signupForm.this.dispose();
			}
		});
		lblLoginNow.setForeground(new Color(0, 204, 204));
		lblLoginNow.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblLoginNow.setBounds(540, 626, 132, 27);
		header.add(lblLoginNow);
	}
}
