package main;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.table.DefaultTableModel;

public class mainForm extends JFrame {
	
   
	private JPanel p1_addDis; 
    private JLabel lblUsername;
    private JLabel lblUserdesignation;
    private JPanel p1update;
    private JPanel p1_view;
    private JPanel p1_delete;
    
   
    

    private JPanel contentPane;
    private JPanel p1, p2_addres, p2_updateres, p4;
    private JPanel p2_deleteres;
    
    
    private DefaultTableModel model;


    Connection conn;
    ResultSet rs = null;
    PreparedStatement ps = null;
    private JComboBox<String> txt_disaster;
    private JComboBox<String> comboBox2;
    private JTextField txt_country;
    private JTextField txt_date;
    private JTextField txt_time;
    private JTextField txt_state;
    private JTextField txt_city;
    private JTextField txt_description;
    private JTextField txt_disaster1;
    private JTextField text_country1;
    private JTextField txt_date1;
    private JTextField txt_time1;
    private JTextField txt_state1;
    private JTextField txt_city1;
    private JTextField txt_description1;
    private JTextField txtSearch;
    private JTextField txt_sr_no;
    private JTextField txt_disastertype1;
    private JTable table;
    private JTextField txt_country2;
    private JTextField txt_date2;
    private JTextField txt_time2;
    private JTextField txt_state2;
    private JTextField txt_city2;
    private JTextField txt_description2;
    private JTextField txt_srno2;
    private JTextField txt_disastertype2;
    private JTextField txt_resourcename2;
    private JTextField txt_resourcename3;
    private JTextField txt_resourcename4;
    private JTextField txt_resid;
    
    private JTextField txt_resid3;
    private JTextField txt_resid4;
    private JTextField txt_disid2;
    private JTextField txt_disid3;
    private JTextField txt_disid4;
    private JTextField txt_datetime;
    private JTextField txt_datetime3;
    private JTextField txt_datetime4;
    private JTextField txtquntity;
    private JTextField textField;
    private JTextField textField1;
    private JTextField txtquntity3;
    private JTextField txtquntity4;
    private JPanel p1_viewres;
    private JTable table_1;
	

    /**
     * Create the frame.
     */
    public mainForm(String UserName, String UserDestination) {
    	
    	conn = MyConnection.getConnection();
    	
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1216, 732);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel sidepanel = new JPanel();
        sidepanel.setBounds(0, 0, 224, 685);
        sidepanel.setBackground(new Color(0, 204, 204));
        contentPane.add(sidepanel);
        sidepanel.setLayout(null);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon(mainForm.class.getResource("/images/Screenshot 2024-07-13 004002.png")));
        label.setBounds(0, 0, 224, 63);
        sidepanel.add(label);

        lblUsername = new JLabel(UserName);
        lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsername.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        lblUsername.setBounds(0, 80, 224, 26);
        sidepanel.add(lblUsername);

        lblUserdesignation = new JLabel(UserDestination);
        lblUserdesignation.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        lblUserdesignation.setHorizontalAlignment(SwingConstants.CENTER);
        lblUserdesignation.setBounds(0, 106, 224, 26);
        sidepanel.add(lblUserdesignation);

        JButton btn5 = new JButton("View Profile");
        btn5.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	showPanel(p4);
               
            }
        });
        btn5.setForeground(Color.BLACK);
        btn5.setBackground(Color.WHITE);
        btn5.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        btn5.setFocusPainted(false);
        btn5.setMargin(new Insets(0, 0, 0, 0));
        btn5.setBounds(43, 163, 137, 38);
        sidepanel.add(btn5);

        JPanel btn1 = new JPanel();
        btn1.setBackground(Color.BLACK);
        btn1.setBounds(0, 295, 224, 83);
        sidepanel.add(btn1);
        btn1.setLayout(null);

        JLabel label_1 = new JLabel("");
        label_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                showPanel(p1);
            }
        });
        label_1.setIcon(new ImageIcon(mainForm.class.getResource("/images/Screenshot 2024-07-12 233532.png")));
        label_1.setBounds(12, 0, 164, 50);
        btn1.add(label_1);

        JLabel lblDashboard = new JLabel("Dashboard");
        lblDashboard.setHorizontalAlignment(SwingConstants.CENTER);
        lblDashboard.setForeground(Color.WHITE);
        lblDashboard.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
        lblDashboard.setBounds(-2, 54, 214, 16);
        btn1.add(lblDashboard);

        JButton btn6 = new JButton("Logout");
        btn6.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        btn6.setMargin(new Insets(0, 0, 0, 0));
        btn6.setForeground(Color.BLACK);
        btn6.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
        btn6.setFocusPainted(false);
        btn6.setBackground(Color.WHITE);
        btn6.setBounds(43, 602, 144, 38);
        sidepanel.add(btn6);
        btn6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                LoginForm l = new LoginForm();
                l.setVisible(true);
                dispose();
            }
        });

        JPanel centerpanel = new JPanel();
        centerpanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        centerpanel.setBounds(222, 63, 976, 622);
        contentPane.add(centerpanel);
        centerpanel.setLayout(new CardLayout(0, 0));

        p1 = new JPanel();
        p1.setBackground(new Color(0, 204, 204));
        centerpanel.add(p1, "name_137738704717699");
        p1.setLayout(null);
        
        final JPanel p1_view = new JPanel();
        p1_view.setBackground(new Color(0, 204, 204));
        JPanel viewPanel = new JPanel();
        viewPanel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(java.awt.event.MouseEvent evt) {
        		
        		p1.setVisible(false);
        		p1_addDis.setVisible(false);
                p1update.setVisible(false);
                
                p1_view.setVisible(true);
                p2_addres.setVisible(false);
                p2_updateres.setVisible(false);
                p4.setVisible(false);
               
        	}
        });
        viewPanel.setBounds(286, 181, 169, 95);
        p1.add(viewPanel);
        viewPanel.setLayout(null);

        JLabel lblViewDisasters = new JLabel("View Disasters");
        lblViewDisasters.setHorizontalAlignment(SwingConstants.CENTER);
        lblViewDisasters.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        lblViewDisasters.setBounds(0, 31, 169, 33);
        viewPanel.add(lblViewDisasters);

        JPanel addPanel = new JPanel();
        addPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p1_addDis.setVisible(true);
                p1.setVisible(false);
            }
        });
        addPanel.setBounds(67, 181, 161, 95);
        p1.add(addPanel);
        addPanel.setLayout(null);

        JLabel lblAddDisaster = new JLabel("Add Disaster");
        lblAddDisaster.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        lblAddDisaster.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddDisaster.setBounds(0, 36, 146, 33);
        addPanel.add(lblAddDisaster);

        
        JPanel updatePanel = new JPanel();
        updatePanel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked( java.awt.event.MouseEvent evt) {
        		
        		p1.setVisible(false);
        		p1_addDis.setVisible(false);
                p1update.setVisible(true);
                p1_view.setVisible(false);
                p2_addres.setVisible(false);
                p2_updateres.setVisible(false);
                p4.setVisible(false);
               
        	}
        });
        updatePanel.setBounds(509, 181, 169, 95);
        p1.add(updatePanel);
        updatePanel.setLayout(null);

        JLabel lblUpdateDisaster = new JLabel("Update disaster");
        lblUpdateDisaster.setHorizontalAlignment(SwingConstants.CENTER);
        lblUpdateDisaster.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        lblUpdateDisaster.setBounds(0, 31, 169, 38);
        updatePanel.add(lblUpdateDisaster);
        
        final JPanel p1_delete = new JPanel();
        JPanel deletePanel = new JPanel();
        deletePanel.addMouseListener(new MouseAdapter() {
        	@Override
			public void mouseClicked( java.awt.event.MouseEvent evt) {
			        		
			        		p1.setVisible(false);
			        		
			        		p1_addDis.setVisible(false);
			                p1update.setVisible(false);
			                p1_view.setVisible(false);
			                p1_delete.setVisible(true);
			                p2_addres.setVisible(false);
			                p2_updateres.setVisible(false);
			                p4.setVisible(false);
			               
			        	}
			        });
        deletePanel.setBounds(759, 181, 161, 95);
        p1.add(deletePanel);
        deletePanel.setLayout(null);

        JLabel lblDeleteDisaster = new JLabel("Delete Disaster");
        lblDeleteDisaster.setHorizontalAlignment(SwingConstants.CENTER);
        lblDeleteDisaster.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        lblDeleteDisaster.setBounds(0, 38, 161, 27);
        deletePanel.add(lblDeleteDisaster);

        JPanel headerpanel = new JPanel();
        headerpanel.setBounds(222, 0, 976, 60);
        contentPane.add(headerpanel);
        headerpanel.setLayout(null);

        JLabel lblWelcomeToDisaster = new JLabel("Welcome to Disaster Management");
        lblWelcomeToDisaster.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcomeToDisaster.setForeground(Color.BLACK);
        lblWelcomeToDisaster.setFont(new Font("Segoe UI Historic", Font.BOLD, 26));
        lblWelcomeToDisaster.setBounds(0, 0, 1022, 60);
        headerpanel.add(lblWelcomeToDisaster);
        
        p2_addres = new JPanel();
        p2_addres.setBackground(new Color(0, 204, 204));
        centerpanel.add(p2_addres, "name_137738716541500");
        p2_addres.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("Resource Name :");
        lblNewLabel_2.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        lblNewLabel_2.setBounds(263, 291, 167, 33);
        p2_addres.add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("Resource Type :");
        lblNewLabel_2_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        lblNewLabel_2_1.setBounds(263, 208, 167, 33);
        p2_addres.add(lblNewLabel_2_1);
        
        JLabel lbldisid = new JLabel("Disaster ID :");
        lbldisid.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        lbldisid.setBounds(519, 123, 167, 33);
        p2_addres.add(lbldisid);
        
        JLabel lblresId = new JLabel("Resource ID :");
        lblresId.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        lblresId.setBounds(263, 123, 167, 33);
        p2_addres.add(lblresId);
        
        JLabel lblNewLabel_2_4 = new JLabel("date and Time :");
        lblNewLabel_2_4.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        lblNewLabel_2_4.setBounds(263, 355, 167, 33);
        p2_addres.add(lblNewLabel_2_4);
        
        txt_resourcename2 = new JTextField();
        txt_resourcename2.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        txt_resourcename2.setBounds(263, 320, 448, 39);
        p2_addres.add(txt_resourcename2);
        txt_resourcename2.setColumns(10);
        
        txt_resid = new JTextField();
        txt_resid.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        txt_resid.setColumns(10);
        txt_resid.setBounds(263, 169, 191, 39);
        p2_addres.add(txt_resid);
        
        txt_disid2 = new JTextField();
        txt_disid2.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        txt_disid2.setColumns(10);
        txt_disid2.setBounds(519, 169, 191, 39);
        p2_addres.add(txt_disid2);
        
        txt_datetime = new JTextField();
        txt_datetime.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        txt_datetime.setColumns(10);
        txt_datetime.setBounds(263, 384, 448, 39);
        p2_addres.add(txt_datetime);
        
        final JComboBox comboBox2 = new JComboBox();
        comboBox2.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        comboBox2.setModel(new DefaultComboBoxModel(new String[] {"Food", "Shelter", "Medical", "Sanitation", "Water"}));
        comboBox2.setBounds(263, 239, 448, 39);
        p2_addres.add(comboBox2);
        
        JButton btnRequestAssistance = new JButton("Request");
        btnRequestAssistance.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
                try {
                	String query = "INSERT INTO `resource_table`(`resourceid`, `sr_no`, `resourcetype`, `resourcename`, `datetime`, `quantity`) VALUES (?, ?, ?, ?, ?, ?)";
                	ps = conn.prepareStatement(query);

                	
                	ps.setString(1, txt_resid.getText());
                	ps.setString(2, txt_disid2.getText()); 

                	ps.setString(3, (String) comboBox2.getSelectedItem());
                	
                	ps.setString(4, txt_resourcename2.getText());

                	
                	LocalDateTime now = LocalDateTime.now();
                	Timestamp timestamp = Timestamp.valueOf(now);
                	ps.setTimestamp(5, timestamp);

                	
                	ps.setString(6, txtquntity.getText());
                	ps.execute();
                	
                    JOptionPane.showMessageDialog(null, "Data Saved");
                    
                    loadData1();
                    
                    reset();
                    
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        
        });
        btnRequestAssistance.setBackground(new Color(102, 204, 51));
        btnRequestAssistance.setForeground(SystemColor.text);
        btnRequestAssistance.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        btnRequestAssistance.setBounds(332, 526, 133, 33);
        p2_addres.add(btnRequestAssistance);
        
        JButton btnGoBack_1 = new JButton("Go Back");
        btnGoBack_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                p2_addres.setVisible(false);
                p1.setVisible(true);
                reset();
            }
        });
        btnGoBack_1.addMouseListener(new MouseAdapter() {
        	public void actionPerformed(ActionEvent e) {
                p1_addDis.setVisible(false);
                p1.setVisible(true);
                reset();
            }
        });
        btnGoBack_1.setForeground(SystemColor.text);
        btnGoBack_1.setBackground(new Color(204, 0, 51));
        btnGoBack_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        btnGoBack_1.setBounds(508, 526, 140, 33);
        p2_addres.add(btnGoBack_1);
        
        JLabel lblNewLabel_2_4_1 = new JLabel("quantity:");
        lblNewLabel_2_4_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        lblNewLabel_2_4_1.setBounds(263, 427, 167, 33);
        p2_addres.add(lblNewLabel_2_4_1);
        
        txtquntity = new JTextField();
        txtquntity.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        txtquntity.setColumns(10);
        txtquntity.setBounds(263, 460, 448, 39);
        p2_addres.add(txtquntity);
        
        
        
        
        p2_updateres = new JPanel();
        p2_updateres.setBackground(new Color(0, 204, 204));
        centerpanel.add(p2_updateres, "name_97537187933500");
        p2_updateres.setLayout(null);

        JLabel lblResourceName = new JLabel("Resource Name:");
        lblResourceName.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        lblResourceName.setBounds(263, 288, 167, 33);
        p2_updateres.add(lblResourceName);

        JLabel lblResourceType = new JLabel("Resource Type:");
        lblResourceType.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        lblResourceType.setBounds(263, 208, 167, 33);
        p2_updateres.add(lblResourceType);

        JLabel lblDisasterID = new JLabel("Disaster ID:");
        lblDisasterID.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        lblDisasterID.setBounds(519, 123, 167, 33);
        p2_updateres.add(lblDisasterID);

        JLabel lblResourceID = new JLabel("Resource ID:");
        lblResourceID.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        lblResourceID.setBounds(263, 123, 167, 33);
        p2_updateres.add(lblResourceID);

        JLabel lblDateTime = new JLabel("Date and Time:");
        lblDateTime.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        lblDateTime.setBounds(263, 356, 167, 33);
        p2_updateres.add(lblDateTime);

        txt_resourcename3 = new JTextField();
        txt_resourcename3.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        txt_resourcename3.setBounds(263, 318, 448, 39);
        p2_updateres.add(txt_resourcename3);
        txt_resourcename3.setColumns(10);

        txt_resid3 = new JTextField();
        
        txt_resid3.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(java.awt.event.KeyEvent evt) {
         		if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        String sql = "SELECT * FROM `resource_table` WHERE `resourceid` = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, txt_resid3.getText());
                        rs = ps.executeQuery();
                        if (rs.next()) {
                        	txt_disid3.setText(rs.getString(2));
                        	textField.setText(rs.getString(3));
                            txt_resourcename3.setText(rs.getString(4));
                            txt_datetime3.setText(rs.getString(5));
                            txtquntity3.setText(rs.getString(6));
                            
                           
                        } else {
                            JOptionPane.showMessageDialog(null, "disater no. not found in database");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
         	}
        });
        txt_resid3.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(java.awt.event.FocusEvent evt) {
        		 if (txt_resid3.getText().trim().equals("Enter serial no.")) {
                    txt_resid3.setText("");
                    txt_resid3.setForeground(new Color(153,153,153));
                }
        		 txt_resid.setForeground(Color.BLACK);
        	}
        	@Override
        	public void focusLost(java.awt.event.FocusEvent evt) {
         		if (txt_resid3.getText().trim().equals("")) {
                    txt_resid3.setText("   Enter serial no.");
                    txt_disid3.setText("");
                    textField.setText("");
                    txt_resourcename3.setText("");
                    txt_datetime3.setText("");
                    txtquntity3.setText("");
                    
                    
                    
                }
         		
         	}
        });
        txt_resid3.setForeground(SystemColor.activeCaptionBorder);
        txt_resid3.setText("   Enter serial no.");
        txt_resid3.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        txt_resid3.setColumns(10);
        txt_resid3.setBounds(263, 169, 191, 39);
        p2_updateres.add(txt_resid3);

        txt_disid3 = new JTextField();
        txt_disid3.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        txt_disid3.setColumns(10);
        txt_disid3.setBounds(519, 169, 191, 39);
        p2_updateres.add(txt_disid3);

        txt_datetime3 = new JTextField();
        txt_datetime3.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        txt_datetime3.setColumns(10);
        txt_datetime3.setBounds(263, 384, 448, 39);
        p2_updateres.add(txt_datetime3);

        JButton btnRequestAssistance1 = new JButton("Update");
        btnRequestAssistance1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
             	String value1 = txt_resid3.getText();
             	String value2 = txt_disid3.getText();
             	String value3 = textField.getText();
             	String value4 = txt_resourcename3.getText();
             	String value5 = txt_datetime3.getText();
             	String value6 = txtquntity3.getText();
             	
             	
                int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to update?","Update Record",JOptionPane.YES_NO_OPTION);
                if (p==0) {
                    try {
                    	 String sql = "UPDATE `resource_table` SET `resourceid` = '"+value1+"',`sr_no` = '"+value2+"', `resourcetype`='"+value3+"',`resourcename`='"+value4+"',`datetime`='"+value5+"',`quantity`='"+value6+"' WHERE `resourceid` = '"+value1+"'";
                        ps = conn.prepareStatement(sql);
                        ps.execute();
                        JOptionPane.showMessageDialog(null, "Data updated successfully");
                        loadData1();
                        reset();
                        
                        txt_resid3.setText("");
                        txt_disid3.setText("");
                        textField.setText("");
                        txt_resourcename3.setText("");
                        txt_datetime3.getText();
                     	txtquntity3.setText("");
                     	
                        
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }

             	}
        });
        btnRequestAssistance1.setBackground(new Color(102, 204, 102));
        btnRequestAssistance1.setForeground(SystemColor.text);
        btnRequestAssistance1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        btnRequestAssistance1.setBounds(332, 526, 133, 33);
        p2_updateres.add(btnRequestAssistance1);

        JButton btnGoBack_11 = new JButton("Go Back");
        btnGoBack_11.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                p2_updateres.setVisible(false);
                p1.setVisible(true);
                reset();
            }
        });
        
        btnGoBack_11.setForeground(SystemColor.text);
        btnGoBack_11.setBackground(new Color(204, 0, 51));
        btnGoBack_11.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        btnGoBack_11.setBounds(519, 526, 140, 33);
        p2_updateres.add(btnGoBack_11);
        centerpanel.add(p2_updateres, "name_97537198173400");
        
        textField = new JTextField();
        textField.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        textField.setColumns(10);
        textField.setBounds(263, 236, 448, 39);
        p2_updateres.add(textField);
        
        JLabel lblDateTime_1 = new JLabel("quantity:");
        lblDateTime_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        lblDateTime_1.setBounds(263, 436, 167, 33);
        p2_updateres.add(lblDateTime_1);
        
        txtquntity3 = new JTextField();
        txtquntity3.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        txtquntity3.setColumns(10);
        txtquntity3.setBounds(263, 464, 448, 39);
        p2_updateres.add(txtquntity3);
        
        
        
        
        
        p2_deleteres = new JPanel();
        p2_deleteres.setBackground(new Color(0, 204, 204));
        centerpanel.add(p2_deleteres, "name_97537187933500");
        p2_deleteres.setLayout(null);

        JLabel lblResourceName1 = new JLabel("Resource Name:");
        lblResourceName1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        lblResourceName1.setBounds(263, 288, 167, 33);
        p2_deleteres.add(lblResourceName1);

        JLabel lblResourceType1 = new JLabel("Resource Type:");
        lblResourceType1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        lblResourceType1.setBounds(263, 208, 167, 33);
        p2_deleteres.add(lblResourceType1);

        JLabel lblDisasterID1 = new JLabel("Disaster ID:");
        lblDisasterID1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        lblDisasterID1.setBounds(519, 123, 167, 33);
        p2_deleteres.add(lblDisasterID1);

        JLabel lblResourceID1 = new JLabel("Resource ID:");
        lblResourceID1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        lblResourceID1.setBounds(263, 123, 167, 33);
        p2_deleteres.add(lblResourceID1);

        JLabel lblDateTime1 = new JLabel("Date and Time:");
        lblDateTime1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        lblDateTime1.setBounds(263, 356, 167, 33);
        p2_deleteres.add(lblDateTime1);

        txt_resourcename4 = new JTextField();
        txt_resourcename4.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        txt_resourcename4.setBounds(263, 318, 448, 39);
        p2_deleteres.add(txt_resourcename4);
        txt_resourcename4.setColumns(10);

        txt_resid4 = new JTextField();
        
        txt_resid4.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(java.awt.event.KeyEvent evt) {
         		if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        String sql = "SELECT * FROM `resource_table` WHERE `resourceid` = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, txt_resid4.getText());
                        rs = ps.executeQuery();
                        if (rs.next()) {
                        	txt_disid4.setText(rs.getString(2));
                        	textField1.setText(rs.getString(3));
                            txt_resourcename4.setText(rs.getString(4));
                            txt_datetime4.setText(rs.getString(5));
                            txtquntity4.setText(rs.getString(6));
                            
                           
                        } else {
                            JOptionPane.showMessageDialog(null, "disater no. not found in database");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
         	}
        });
        txt_resid4.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(java.awt.event.FocusEvent evt) {
       		 if (txt_resid4.getText().trim().equals("Enter serial no.")) {
                   txt_resid4.setText("");
                   txt_resid4.setForeground(new Color(153,153,153));
               }
       		 txt_resid.setForeground(Color.BLACK);
       	}
       	@Override
       	public void focusLost(java.awt.event.FocusEvent evt) {
        		if (txt_resid4.getText().trim().equals("")) {
                   txt_resid4.setText("   Enter serial no.");
                   txt_disid4.setText("");
                   textField1.setText("");
                   txt_resourcename4.setText("");
                   txt_datetime4.setText("");
                   txtquntity4.setText("");
                   
                   
                   
               }
        		
        	}
        });
        txt_resid4.setForeground(SystemColor.activeCaptionBorder);
        txt_resid4.setText("   Enter serial no.");
        txt_resid4.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        txt_resid4.setColumns(10);
        txt_resid4.setBounds(263, 169, 191, 39);
        p2_deleteres.add(txt_resid4);

        txt_disid4 = new JTextField();
        txt_disid4.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        txt_disid4.setColumns(10);
        txt_disid4.setBounds(519, 169, 191, 39);
        p2_deleteres.add(txt_disid4);

        txt_datetime4 = new JTextField();
        txt_datetime4.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        txt_datetime4.setColumns(10);
        txt_datetime4.setBounds(263, 384, 448, 39);
        p2_deleteres.add(txt_datetime4);

        JButton btndelete1 = new JButton("Delete");
        btndelete1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
         		
             	
                int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?","delete Record",JOptionPane.YES_NO_OPTION);
                if (p==0) {
                    try {
                    	 String sql = "DELETE FROM `resource_table` WHERE `resourceid` = ?";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1,txt_resid4.getText());
                        ps.execute();
                        JOptionPane.showMessageDialog(null, "Data deleted successfully");
                        loadData1();
                        reset();
                        
                        txt_resid4.setText("");
                        txt_disid4.setText("");
                        textField1.setText("");
                        txt_resourcename4.setText("");
                        txt_datetime4.getText();
                     	txtquntity4.setText("");
                     	
                        
                        
                        
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }

             	}
        });
        btndelete1.setBackground(new Color(102, 204, 102));
        btndelete1.setForeground(SystemColor.text);
        btndelete1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        btndelete1.setBounds(332, 526, 133, 33);
        p2_deleteres.add(btndelete1);

        JButton btnGoBack_111 = new JButton("Go Back");
        btnGoBack_111.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                p2_deleteres.setVisible(false);
                p1.setVisible(true);
                reset();
            }
        });
        
        btnGoBack_111.setForeground(SystemColor.text);
        btnGoBack_111.setBackground(new Color(204, 0, 51));
        btnGoBack_111.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        btnGoBack_111.setBounds(519, 526, 140, 33);
        p2_deleteres.add(btnGoBack_111);
        centerpanel.add(p2_deleteres, "name_97537198173400");
        
        textField1 = new JTextField();
        textField1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        textField1.setColumns(10);
        textField1.setBounds(263, 236, 448, 39);
        p2_deleteres.add(textField1);
        
        JLabel lblDateTime_11 = new JLabel("quantity:");
        lblDateTime_11.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        lblDateTime_11.setBounds(263, 436, 167, 33);
        p2_deleteres.add(lblDateTime_11);
        
        txtquntity4 = new JTextField();
        txtquntity4.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
        txtquntity4.setColumns(10);
        txtquntity4.setBounds(263, 464, 448, 39);
        p2_deleteres.add(txtquntity4);
        
        p4 = new JPanel();
        p4.setBackground(new Color(0, 204, 204));
        centerpanel.add(p4, "name_137738727172699");
        p4.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(390, 46, 154, 93);
        p4.add(panel);
        panel.setLayout(null);
        
        JLabel label_2 = new JLabel("New label");
        label_2.setIcon(new ImageIcon(mainForm.class.getResource("/images/Screenshot 2024-07-13 004002.png")));
        label_2.setBounds(-46, 0, 200, 92);
        panel.add(label_2);
        
        JLabel lblUsername_1 = new JLabel(UserName);
        lblUsername_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsername_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        lblUsername_1.setBounds(355, 173, 224, 26);
        p4.add(lblUsername_1);
        
        JLabel lblUserdesignation_1 = new JLabel(UserDestination);
        lblUserdesignation_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblUserdesignation_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        lblUserdesignation_1.setBounds(355, 206, 224, 26);
        p4.add(lblUserdesignation_1);
        
        showPanel(p1);
        
                p1_addDis = new JPanel();
                p1_addDis.setBackground(new Color(0, 204, 204));
                centerpanel.add(p1_addDis, "name_137738735960200");
                p1_addDis.setLayout(null);
                p1_addDis.setVisible(false);
                
                 JLabel lblDisasterType = new JLabel("Disaster Type:");
                 lblDisasterType.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                 lblDisasterType.setBounds(538, 28, 150, 25);
                 p1_addDis.add(lblDisasterType);
                        
                 txt_disaster = new JComboBox<String>();
                 txt_disaster.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                 txt_disaster.setModel(new DefaultComboBoxModel<String>(new String[] {"Cyclone", "Flood", "Earthquake", "Fire", "Disaster", "Tsunami", "Other"}));
                 txt_disaster.setBounds(539, 61, 198, 33);
                 p1_addDis.add(txt_disaster);
                                
                 JLabel lblCountry = new JLabel("Country:");
                 lblCountry.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                 lblCountry.setBounds(295, 107, 132, 25);
                 p1_addDis.add(lblCountry);
                                        
                 txt_country = new JTextField();
                 txt_country.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                 txt_country.setColumns(10);
                 txt_country.setBounds(295, 145, 442, 33);
                 p1_addDis.add(txt_country);
                 
                 JButton btnAddDisaster = new JButton("Add Disaster");
                 btnAddDisaster.setForeground(SystemColor.text);
                 btnAddDisaster.setBackground(new Color(51, 204, 0));
                 btnAddDisaster.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                 btnAddDisaster.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent arg0) {
                         try {
                             String query = "INSERT INTO `disaster_list`(`disastername`, `country`, `date`, `time`, `state`, `city`, `description`) VALUES (?,?,?,?,?,?,?)";
                             ps = conn.prepareStatement(query);
                             
                             ps.setString(1, (String) txt_disaster.getSelectedItem());
                             ps.setString(2, txt_country.getText());
                             
                             java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
                             ps.setDate(3, sqlDate); 
                             
                             LocalTime currentTime = LocalTime.now(); // get the current time
                             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss"); // format: hour:minute:secon
                             String formattedTime = currentTime.format(formatter);
                             ps.setString(4, formattedTime);
                             
                             
                             ps.setString(5, txt_state.getText());
                             ps.setString(6, txt_city.getText());
                             ps.setString(7, txt_description.getText());
                             ps.execute();
                             
                             JOptionPane.showMessageDialog(null, "Data Saved");
                             
                             loadData();
                             
                             reset();
                             
                             
                         } catch (Exception e) {
                             JOptionPane.showMessageDialog(null, e);
                         }
                     }
                 });
                 btnAddDisaster.setBounds(373, 517, 150, 33);
                 p1_addDis.add(btnAddDisaster);
                 
                         JButton btnCancel = new JButton("Cancel");
                         btnCancel.setForeground(SystemColor.text);
                         btnCancel.setBackground(new Color(204, 0, 51));
                         btnCancel.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         btnCancel.addActionListener(new ActionListener() {
                             public void actionPerformed(ActionEvent e) {
                                 p1_addDis.setVisible(false);
                                 p1.setVisible(true);
                                 reset();
                             }
                         });
                         btnCancel.setBounds(551, 517, 137, 33);
                         p1_addDis.add(btnCancel);
                         
                         JLabel lblDate = new JLabel("Date :");
                         lblDate.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblDate.setBounds(295, 193, 132, 25);
                         p1_addDis.add(lblDate);
                         
                         JLabel lblTime_1 = new JLabel("Time :");
                         lblTime_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblTime_1.setBounds(539, 191, 132, 25);
                         p1_addDis.add(lblTime_1);
                         
                         JLabel lblState_1 = new JLabel("State :");
                         lblState_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblState_1.setBounds(295, 266, 132, 25);
                         p1_addDis.add(lblState_1);
                         
                         txt_date = new JTextField();
                         txt_date.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txt_date.setColumns(10);
                         txt_date.setBounds(295, 220, 198, 33);
                         p1_addDis.add(txt_date);
                         
                         txt_time = new JTextField();
                         txt_time.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txt_time.setColumns(10);
                         txt_time.setBounds(539, 220, 198, 33);
                         p1_addDis.add(txt_time);
                         
                         txt_state = new JTextField();
                         txt_state.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txt_state.setColumns(10);
                         txt_state.setBounds(295, 304, 198, 33);
                         p1_addDis.add(txt_state);
                         
                         JLabel lblTime_1_1 = new JLabel("city :");
                         lblTime_1_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblTime_1_1.setBounds(539, 266, 132, 25);
                         p1_addDis.add(lblTime_1_1);
                         
                         txt_city = new JTextField();
                         txt_city.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txt_city.setColumns(10);
                         txt_city.setBounds(539, 304, 198, 33);
                         p1_addDis.add(txt_city);
                         
                         JLabel lblState_1_1 = new JLabel("Description :");
                         lblState_1_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblState_1_1.setBounds(295, 374, 132, 25);
                         p1_addDis.add(lblState_1_1);
                         
                         txt_description = new JTextField();
                         txt_description.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txt_description.setColumns(10);
                         txt_description.setBounds(295, 412, 442, 59);
                         p1_addDis.add(txt_description );
                         
                         JLabel lblSrNo_1 = new JLabel("Sr No. :");
                         lblSrNo_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblSrNo_1.setBounds(295, 34, 150, 25);
                         p1_addDis.add(lblSrNo_1);
                         
                         txt_sr_no = new JTextField();
                         txt_sr_no.setEditable(false);
                         txt_sr_no.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txt_sr_no.setColumns(10);
                         txt_sr_no.setBounds(295, 61, 198, 33);
                         p1_addDis.add(txt_sr_no);
                         showPanel(p1);
                         
                         JPanel addPanel_1 = new JPanel();
                         addPanel_1.addMouseListener(new MouseAdapter() {
                         	@Override
                         	public void mouseClicked(java.awt.event.MouseEvent evt) {
                                p2_addres.setVisible(true);
                                p1.setVisible(false);
                            }
                         });
                         addPanel_1.setLayout(null);
                         addPanel_1.setBounds(67, 366, 161, 95);
                         p1.add(addPanel_1);
                         
                         JLabel lblRequstAssistance = new JLabel("Request");
                         lblRequstAssistance.setHorizontalAlignment(SwingConstants.CENTER);
                         lblRequstAssistance.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
                         lblRequstAssistance.setBounds(0, 33, 146, 33);
                         addPanel_1.add(lblRequstAssistance);
                         
                         JPanel viewPanel_1 = new JPanel();
                         viewPanel_1.addMouseListener(new MouseAdapter() {
                         	@Override
                         	public void mouseClicked(java.awt.event.MouseEvent evt) {
                        		
                        		p1.setVisible(false);
                        		p1_addDis.setVisible(false);
                                p1update.setVisible(false);
                                
                                p1_viewres.setVisible(true);
                                p2_addres.setVisible(false);
                                p2_updateres.setVisible(false);
                                p4.setVisible(false);
                               
                        	}
                         });
                         viewPanel_1.setLayout(null);
                         viewPanel_1.setBounds(286, 366, 169, 95);
                         p1.add(viewPanel_1);
                         
                         JLabel lblViewRequests = new JLabel("View Request");
                         lblViewRequests.setHorizontalAlignment(SwingConstants.CENTER);
                         lblViewRequests.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
                         lblViewRequests.setBounds(0, 31, 169, 33);
                         viewPanel_1.add(lblViewRequests);
                         
                         JPanel updatePanel_1 = new JPanel();
                         updatePanel_1.addMouseListener(new MouseAdapter() {
                         	@Override
                         	public void mouseClicked( java.awt.event.MouseEvent evt) {
                        		
                        		p1.setVisible(false);
                        		p2_updateres.setVisible(true);
                        		p1_addDis.setVisible(false);
                        		p1update.setVisible(false);
                        		
                                p1_view.setVisible(false);
                                p2_addres.setVisible(false);
                               
                                p4.setVisible(false);
                               
                        	}
                         });
                         updatePanel_1.setLayout(null);
                         updatePanel_1.setBounds(509, 366, 169, 95);
                         p1.add(updatePanel_1);
                         
                         JLabel lblUpdateRequest = new JLabel("Update Request");
                         lblUpdateRequest.setHorizontalAlignment(SwingConstants.CENTER);
                         lblUpdateRequest.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
                         lblUpdateRequest.setBounds(0, 31, 169, 38);
                         updatePanel_1.add(lblUpdateRequest);
                         
                         JPanel deletePanel_1 = new JPanel();
                         deletePanel_1.addMouseListener(new MouseAdapter() {
                         	@Override
                         	public void mouseClicked( java.awt.event.MouseEvent evt) {
    			        		
    			        		p1.setVisible(false);
    			        		
    			        		p1_addDis.setVisible(false);
    			                p1update.setVisible(false);
    			                p1_view.setVisible(false);
    			                p2_deleteres.setVisible(true);
    			                p1_delete.setVisible(false);
    			                p2_addres.setVisible(false);
    			                p2_updateres.setVisible(false);
    			                p4.setVisible(false);
    			               
    			        	}
                         });
                         deletePanel_1.setLayout(null);
                         deletePanel_1.setBounds(759, 366, 161, 95);
                         p1.add(deletePanel_1);
                         
                         JLabel lblDeleteRequest = new JLabel("Delete Request");
                         lblDeleteRequest.setHorizontalAlignment(SwingConstants.CENTER);
                         lblDeleteRequest.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
                         lblDeleteRequest.setBounds(0, 38, 161, 27);
                         deletePanel_1.add(lblDeleteRequest);
                         
                         JLabel lblDisasterManage = new JLabel("Disaster Manage :");
                         lblDisasterManage.setFont(new Font("Segoe UI Historic", Font.BOLD, 22));
                         lblDisasterManage.setBounds(67, 101, 309, 31);
                         p1.add(lblDisasterManage);
                         
                         JLabel lblAssistanceRequestManage = new JLabel("Assistance Request manage :");
                         lblAssistanceRequestManage.setFont(new Font("Segoe UI Historic", Font.BOLD, 22));
                         lblAssistanceRequestManage.setBounds(67, 305, 309, 31);
                         p1.add(lblAssistanceRequestManage);
                         
                         p1update = new JPanel();
                         p1update.setBackground(new Color(0, 204, 204));
                         centerpanel.add(p1update, "name_137738755819000");
                         p1update.setLayout(null);
                         
                         JLabel lblNewLabel = new JLabel("Disaster Type :");
                         lblNewLabel.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblNewLabel.setBounds(512, 38, 152, 24);
                         p1update.add(lblNewLabel);
                         
                         text_country1 = new JTextField();
                         text_country1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         text_country1.setBounds(249, 169, 452, 44);
                         p1update.add(text_country1);
                         text_country1.setColumns(10);
                         
                         JLabel lblCountry_1 = new JLabel("Country :");
                         lblCountry_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblCountry_1.setBounds(250, 132, 167, 24);
                         p1update.add(lblCountry_1);
                         
                         txt_date1 = new JTextField();
                         txt_date1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txt_date1.setBounds(249, 267, 202, 44);
                         p1update.add(txt_date1);
                         txt_date1.setColumns(10);
                         
                         txt_time1 = new JTextField();
                         txt_time1.setBounds(512, 255, 189, 45);
                         p1update.add(txt_time1);
                         txt_time1.setColumns(10);
                         
                         JLabel lblDate_1 = new JLabel("Date :");
                         lblDate_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblDate_1.setBounds(249, 229, 94, 24);
                         p1update.add(lblDate_1);
                         
                         JLabel lblTime = new JLabel("Time :");
                         lblTime.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblTime.setBounds(499, 225, 73, 33);
                         p1update.add(lblTime);
                         
                         JLabel lblState = new JLabel("State :");
                         lblState.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblState.setBounds(249, 324, 133, 33);
                         p1update.add(lblState);
                         
                         JLabel lblCity = new JLabel("City :");
                         lblCity.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblCity.setBounds(512, 324, 133, 33);
                         p1update.add(lblCity);
                         
                         txt_state1 = new JTextField();
                         txt_state1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txt_state1.setColumns(10);
                         txt_state1.setBounds(249, 358, 202, 33);
                         p1update.add(txt_state1);
                         
                         txt_city1 = new JTextField();
                         txt_city1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txt_city1.setColumns(10);
                         txt_city1.setBounds(512, 358, 189, 33);
                         p1update.add(txt_city1);
                         
                         JLabel lblDescription = new JLabel("Description :");
                         lblDescription.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblDescription.setBounds(249, 410, 133, 33);
                         p1update.add(lblDescription);
                         
                         txt_description1 = new JTextField();
                         txt_description1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txt_description1.setColumns(10);
                         txt_description1.setBounds(249, 445, 452, 44);
                         p1update.add(txt_description1);
                         
                         JButton btnupdate = new JButton("Update Disaster");
                         btnupdate.setBackground(new Color(102, 204, 51));
                         btnupdate.setForeground(SystemColor.text);
                         btnupdate.addActionListener(new ActionListener() {
                         	public void actionPerformed(ActionEvent arg0) {
                         	String value1 = txtSearch.getText();
                         	String value2 = txt_disastertype1.getText();
                         	String value3 = text_country1.getText();
                         	String value4 = txt_date1.getText();
                         	String value5 = txt_time1.getText();
                         	String value6 = txt_state1.getText();
                         	String value7 = txt_city1.getText();
                         	String value8 = txt_description1.getText();
                         	
                            int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to update?","Update Record",JOptionPane.YES_NO_OPTION);
                            if (p==0) {
                                try {
                                	 String sql = "UPDATE `disaster_list` SET `sr_no` = '"+value1+"', `disastername`='"+value2+"',`country`='"+value3+"',`date`='"+value4+"',`time`='"+value5+"',`state`='"+value6+"',`city`='"+value7+"',`description`='"+value8+"' WHERE `sr_no` = '"+value1+"'";
                                    ps = conn.prepareStatement(sql);
                                    ps.execute();
                                    JOptionPane.showMessageDialog(null, "Data updated successfully");
                                    loadData();
                                    reset();
                                    
                                    txtSearch.setText("");
                                    txt_disastertype1.setText("");
                                    text_country1.setText("");
                                    txt_date1.setText("");
                                    txt_time1.setText("");
                                    txt_state1.setText("");
                                   
                                    txt_city1.setText("");
                                    txt_description.setText("");
                                    
                                    
                                    
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, ex);
                                }
                            }

                         	}
                         });
                         btnupdate.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         btnupdate.setBounds(293, 543, 178, 33);
                         p1update.add(btnupdate);
                         
                         JButton btnCancel1 = new JButton("Cancel");
                         btnCancel1.setBackground(new Color(204, 0, 51));
                         btnCancel1.setForeground(SystemColor.text);
                         btnCancel1.addActionListener(new ActionListener() {
                         	public void actionPerformed(ActionEvent evt) {
                         		
                         		p1.setVisible(true);
                                p1_addDis.setVisible(false);
                                p1update.setVisible(false);
                                
                                p2_addres.setVisible(false);
                                p2_updateres.setVisible(false);
                                p4.setVisible(false);
                                
                         	}
                         });
                         btnCancel1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         btnCancel1.setBounds(512, 543, 152, 33);
                         p1update.add(btnCancel1);
                         
                         JLabel lblSrNo = new JLabel("Sr. No. :");
                         lblSrNo.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblSrNo.setBounds(249, 44, 152, 24);
                         p1update.add(lblSrNo);
                         
                         txtSearch = new JTextField();
                         txtSearch.addKeyListener(new KeyAdapter() {
                         	@Override
                         	public void keyPressed(java.awt.event.KeyEvent evt) {
                         		if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                                    try {
                                        String sql = "SELECT * FROM `disaster_list` WHERE `sr_no` = ?";
                                        ps = conn.prepareStatement(sql);
                                        ps.setString(1, txtSearch.getText());
                                        rs = ps.executeQuery();
                                        if (rs.next()) {
                                            txt_disastertype1.setText(rs.getString(2));
                                            text_country1.setText(rs.getString(3));
                                            txt_date1.setText(rs.getString(4));
                                            txt_time1.setText(rs.getString(5));
                                            txt_state1.setText(rs.getString(6));
                                            txt_city1.setText(rs.getString(7));
                                            txt_description1.setText(rs.getString(8));
                                            
                                           
                                        } else {
                                            JOptionPane.showMessageDialog(null, "disater no. not found in database");
                                        }
                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, ex);
                                    }
                                }
                         	}
                         });
                         txtSearch.addFocusListener(new FocusAdapter() {
                         	public void focusGained(java.awt.event.FocusEvent evt) {
                         		 if (txtSearch.getText().trim().equals("Enter serial no.")) {
                                     txtSearch.setText("");
                                     txtSearch.setForeground(new Color(153,153,153));
                                 }
                         		 txtSearch.setForeground(Color.BLACK);
                         	}
                         	
                         	public void focusLost(java.awt.event.FocusEvent evt) {
                         		if (txtSearch.getText().trim().equals("")) {
                                    txtSearch.setText("   Enter serial no.");
                                    txt_disaster1.setText("");
                                    text_country1.setText("");
                                    txt_date1.setText("");
                                    txt_time1.setText("");
                                    txt_state1.setText("");
                                    
                                    txt_description1.setText("");
                                    
                                }
                         		
                         	}
                         	
                         	
                         });
                         
                         txtSearch.setForeground(SystemColor.activeCaptionBorder);
                         txtSearch.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txtSearch.setText("   Enter serial no.");
                         txtSearch.setColumns(10);
                         txtSearch.setBounds(249, 75, 202, 44);
                         p1update.add(txtSearch);
                         
                         txt_disastertype1 = new JTextField();
                         txt_disastertype1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txt_disastertype1.setColumns(10);
                         txt_disastertype1.setBounds(499, 75, 202, 44);
                         p1update.add(txt_disastertype1);
                         
                         
                         
                         centerpanel.add(p1_view, "name_137738765263300");
                         p1_view.setLayout(null);
                         
                         JLabel lblheadline = new JLabel("View all Disasters Added");
                         lblheadline.setBounds(327, 71, 344, 28);
                         lblheadline.setHorizontalAlignment(SwingConstants.CENTER);
                         lblheadline.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
                         p1_view.add(lblheadline);
                         
                         JScrollPane scrollPane = new JScrollPane();
                         scrollPane.setBounds(12, 123, 951, 318);
                         p1_view.add(scrollPane);
                         
                         table = new JTable();
                         scrollPane.setViewportView(table);

                         loadData();
                         table.setModel(new DefaultTableModel(
                         	new Object[][] {
                         	},
                         	new String[] {
                         		"Sr No.", "Disaster Type", "Country", "Date", "Time", "State", "City", "Description"
                         	}
                         ));
                         
                         JButton btnGoBack = new JButton("Go Back");
                         btnGoBack.setBounds(442, 493, 140, 43);
                         btnGoBack.addActionListener(new ActionListener() {
                        	 public void actionPerformed(ActionEvent evt) {
                          		
                          		p1.setVisible(true);
                          		p1_view.setVisible(false);
                          		p1_delete.setVisible(false);
                                 p1_addDis.setVisible(false);
                                 p1update.setVisible(false);
                                 
                                 p2_addres.setVisible(false);
                                 p2_updateres.setVisible(false);
                                 p4.setVisible(false);
                                 
                          	}
                         });
                         btnGoBack.setForeground(SystemColor.text);
                         btnGoBack.setBackground(new Color(204, 0, 0));
                         btnGoBack.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         p1_view.add(btnGoBack);
                         
                         
                         p1_delete.setLayout(null);
                         p1_delete.setBackground(new Color(0, 204, 204));
                         centerpanel.add(p1_delete, "name_137738774608100");
                         
                         JLabel lblNewLabel_1 = new JLabel("Disaster Type :");
                         lblNewLabel_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblNewLabel_1.setBounds(512, 38, 152, 24);
                         p1_delete.add(lblNewLabel_1);
                         
                         txt_country2 = new JTextField();
                         txt_country2.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txt_country2.setColumns(10);
                         txt_country2.setBounds(249, 169, 452, 44);
                         p1_delete.add(txt_country2);
                         
                         JLabel lblCountry_1_1 = new JLabel("Country :");
                         lblCountry_1_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblCountry_1_1.setBounds(250, 132, 167, 24);
                         p1_delete.add(lblCountry_1_1);
                         
                         txt_date2 = new JTextField();
                         txt_date2.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txt_date2.setColumns(10);
                         txt_date2.setBounds(249, 267, 202, 44);
                         p1_delete.add(txt_date2);
                         
                         txt_time2 = new JTextField();
                         txt_time2.setColumns(10);
                         txt_time2.setBounds(512, 255, 189, 45);
                         p1_delete.add(txt_time2);
                         
                         JLabel lblDate_1_1 = new JLabel("Date :");
                         lblDate_1_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblDate_1_1.setBounds(249, 229, 94, 24);
                         p1_delete.add(lblDate_1_1);
                         
                         JLabel lblTime_2 = new JLabel("Time :");
                         lblTime_2.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblTime_2.setBounds(499, 225, 73, 33);
                         p1_delete.add(lblTime_2);
                         
                         JLabel lblState_2 = new JLabel("State :");
                         lblState_2.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblState_2.setBounds(249, 324, 133, 33);
                         p1_delete.add(lblState_2);
                         
                         JLabel lblCity_1 = new JLabel("City :");
                         lblCity_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblCity_1.setBounds(512, 324, 133, 33);
                         p1_delete.add(lblCity_1);
                         
                         txt_state2 = new JTextField();
                         txt_state2.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txt_state2.setColumns(10);
                         txt_state2.setBounds(249, 358, 202, 33);
                         p1_delete.add(txt_state2);
                         
                         txt_city2 = new JTextField();
                         txt_city2.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txt_city2.setColumns(10);
                         txt_city2.setBounds(512, 358, 189, 33);
                         p1_delete.add(txt_city2);
                         
                         JLabel lblDescription_1 = new JLabel("Description :");
                         lblDescription_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblDescription_1.setBounds(249, 410, 133, 33);
                         p1_delete.add(lblDescription_1);
                         
                         txt_description2 = new JTextField();
                         txt_description2.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txt_description2.setColumns(10);
                         txt_description2.setBounds(249, 445, 452, 44);
                         p1_delete.add(txt_description2);
                         
                         JButton btndelete = new JButton("Delete Disaster");
                         btndelete.setForeground(SystemColor.text);
                         btndelete.setBackground(new Color(102, 204, 51));
                         btndelete.addActionListener(new ActionListener() {
                         	public void actionPerformed(ActionEvent evt) {
                         		
                                 	
                                    int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?","delete Record",JOptionPane.YES_NO_OPTION);
                                    if (p==0) {
                                        try {
                                        	 String sql = "DELETE FROM `disaster_list` WHERE `sr_no` = ?";
                                            ps = conn.prepareStatement(sql);
                                            ps.setString(1,txt_srno2.getText());
                                            ps.execute();
                                            JOptionPane.showMessageDialog(null, "Data deleted successfully");
                                            loadData();
                                            reset();
                                            
                                            txt_srno2.setText("");
                                            txt_disastertype2.setText("");
                                            txt_country2.setText("");
                                            txt_date2.setText("");
                                            txt_time2.setText("");
                                            txt_state2.setText("");
                                           
                                            txt_city2.setText("");
                                            txt_description2.setText("");
                                            
                                            
                                            
                                        } catch (Exception ex) {
                                            JOptionPane.showMessageDialog(null, ex);
                                        }
                                    }

                                 	}
                                 });
                         		
                         	
                         
                         btndelete.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         btndelete.setBounds(293, 543, 178, 33);
                         p1_delete.add(btndelete);
                         
                         JButton btnCancel1_1 = new JButton("Cancel");
                         btnCancel1_1.setForeground(SystemColor.text);
                         btnCancel1_1.setBackground(new Color(204, 0, 51));
                         btnCancel1_1.addActionListener(new ActionListener() {
                          	public void actionPerformed(ActionEvent evt) {
                          		
                          		p1.setVisible(true);
                          		p1_delete.setVisible(false);
                                 p1_addDis.setVisible(false);
                                 p1update.setVisible(false);
                                 
                                 p2_addres.setVisible(false);
                                 p2_updateres.setVisible(false);
                                 p4.setVisible(false);
                                 
                          	}
                          });

                         btnCancel1_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         btnCancel1_1.setBounds(512, 543, 152, 33);
                         p1_delete.add(btnCancel1_1);
                         
                         JLabel lblSrNo_2 = new JLabel("Sr. No. :");
                         lblSrNo_2.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         lblSrNo_2.setBounds(249, 44, 152, 24);
                         p1_delete.add(lblSrNo_2);
                         
                         txt_srno2 = new JTextField();
                         txt_srno2.addFocusListener(new FocusAdapter() {
                         	@Override
                         	public void focusGained(java.awt.event.FocusEvent evt) {
                         		 if (txt_srno2.getText().trim().equals("Enter serial no.")) {
                                     txt_srno2.setText("");
                                     txt_srno2.setForeground(new Color(153,153,153));
                                 }
                         		 txtSearch.setForeground(Color.BLACK);
                         	}
                         	@Override
                         	public void focusLost(java.awt.event.FocusEvent evt) {
                         		if (txt_srno2.getText().trim().equals("")) {
                                    txt_srno2.setText("   Enter serial no.");
                                    txt_disastertype2.setText("");
                                    txt_country2.setText("");
                                    txt_date2.setText("");
                                    txt_time2.setText("");
                                    txt_state2.setText("");
                                    
                                    txt_description2.setText("");
                                    
                                }
                         		
                         	}
                         	
                         });
						
                         
                         txt_srno2.addKeyListener(new KeyAdapter() {
                         	public void keyPressed(java.awt.event.KeyEvent evt) {
                         		if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                                    try {
                                        String sql = "SELECT * FROM `disaster_list` WHERE `sr_no` = ?";
                                        ps = conn.prepareStatement(sql);
                                        ps.setString(1, txt_srno2.getText());
                                        rs = ps.executeQuery();
                                        if (rs.next()) {
                                            txt_disastertype2.setText(rs.getString(2));
                                            txt_country2.setText(rs.getString(3));
                                            txt_date2.setText(rs.getString(4));
                                            txt_time2.setText(rs.getString(5));
                                            txt_state2.setText(rs.getString(6));
                                            txt_city2.setText(rs.getString(7));
                                            txt_description2.setText(rs.getString(8));
                                            
                                            
                                        } else {
                                            JOptionPane.showMessageDialog(null, "disater no. not found in database");
                                        }
                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, ex);
                                    }
                         		}
                         	}
                         	});
                         
                         
                         txt_srno2.setText("   Enter serial no.");
                         txt_srno2.setForeground(SystemColor.activeCaptionBorder);
                         txt_srno2.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txt_srno2.setColumns(10);
                         txt_srno2.setBounds(249, 75, 202, 44);
                         p1_delete.add(txt_srno2);
                         
                         txt_disastertype2 = new JTextField();
                         txt_disastertype2.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         txt_disastertype2.setColumns(10);
                         txt_disastertype2.setBounds(499, 75, 202, 44);
                         p1_delete.add(txt_disastertype2);
                         
                         p1_viewres = new JPanel();
                         p1_viewres.setLayout(null);
                         p1_viewres.setBackground(new Color(0, 204, 204));
                         centerpanel.add(p1_viewres, "name_137738783987200");
                         
                         JLabel lblViewAllAssistance = new JLabel("View all Assistance Requests");
                         lblViewAllAssistance.setHorizontalAlignment(SwingConstants.CENTER);
                         lblViewAllAssistance.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
                         lblViewAllAssistance.setBounds(327, 71, 344, 28);
                         p1_viewres.add(lblViewAllAssistance);
                         
                         JButton btnGoBack_2 = new JButton("Go Back");
                         btnGoBack_2.addActionListener(new ActionListener() {
                        	 public void actionPerformed(ActionEvent evt) {
                           		
                           		p1.setVisible(true);
                           		p1_view.setVisible(false);
                           		p1_delete.setVisible(false);
                           		p1_viewres.setVisible(false);
                                  p1_addDis.setVisible(false);
                                  p1update.setVisible(false);
                                  
                                  p2_addres.setVisible(false);
                                  p2_updateres.setVisible(false);
                                  p4.setVisible(false);
                                  
                           	}
                         });
                         btnGoBack_2.setForeground(Color.WHITE);
                         btnGoBack_2.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
                         btnGoBack_2.setBackground(new Color(204, 0, 0));
                         btnGoBack_2.setBounds(442, 493, 140, 43);
                         p1_viewres.add(btnGoBack_2);
                         
                         JScrollPane scrollPane_1 = new JScrollPane();
                         scrollPane_1.setBounds(65, 163, 844, 286);
                         p1_viewres.add(scrollPane_1);
                         
                         
                         table_1 = new JTable();
                         
                         scrollPane_1.setViewportView(table_1);
                         loadData1();
                         table_1.setModel(new DefaultTableModel(
                         	new Object[][] {
                         	},
                         	new String[] {
                         		"Resource ID", "Disaster ID", "Resource Type", "Resource Name", "Date and Time", "Quntity"
                         	}
                         ));
    					}
    
    
    private void loadData() {
        try {
            String query = "SELECT * FROM disaster_list";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            // Get the column names
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i-1] = metaData.getColumnName(i);
            }
            
            // Create a new DefaultTableModel
            model = new DefaultTableModel(columnNames, 0);
            
            // Add rows to the model
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i-1] = rs.getObject(i);
                }
                model.addRow(row);
            }
            
            // Set the model to the table
            table.setModel(model);
            
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void loadData1() {
        try {
            String query = "SELECT * FROM resource_table";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            // Get the column names
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i-1] = metaData.getColumnName(i);
            }
            
            // Create a new DefaultTableModel
            model = new DefaultTableModel(columnNames, 0);
            
            // Add rows to the model
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i-1] = rs.getObject(i);
                }
                model.addRow(row);
            }
            
            // Set the model to the table
            table_1.setModel(model);
            
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

                                                
                                                        
    public void showPanel(JPanel panel) {
        p1.setVisible(false);
        p2_addres.setVisible(false);
        p2_deleteres.setVisible(false);
        p4.setVisible(false);
        panel.setVisible(true);
    }
    public void reset(){
    	txt_disaster.setSelectedIndex(0);
        txt_country.setText("");
        txt_state.setText("");
        txt_city.setText("");
        txt_date.setText("");
        txt_time.setText("");
        txt_description.setText("");
        
        txt_disastertype1.setText("");
        text_country1.setText("");
        txt_state1.setText("");
        txt_city1.setText("");
        txt_date1.setText("");
        txt_time1.setText("");
        txt_description1.setText("");
        
        txt_disastertype2.setText("");
        txt_country2.setText("");
        txt_state2.setText("");
        txt_city2.setText("");
        txt_date2.setText("");
        txt_time2.setText("");
        txt_description2.setText("");
        
        txt_resid.setText("");
        txt_disid2.setText("");
        
        txt_resourcename2.setText("");
        txt_datetime.setText("");
        txtquntity.setText("");
        
        txt_resid4.setText("");
        txt_disid4.setText("");
        textField1.setText("");
        txt_resourcename4.setText("");
        txt_datetime4.setText("");
        txtquntity4.setText("");
        
        txt_resid3.setText("");
        txt_disid3.setText("");
    	textField.setText("");
        txt_resourcename3.setText("");
        txt_datetime3.setText("");
        txtquntity3.setText("");
    }
    

   
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    String userName = "TestUser";
                    String userDestination = "TestDesignation";
                    mainForm frame = new mainForm(userName, userDestination);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}