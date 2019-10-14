package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Insets;
import javax.swing.JComboBox;
import java.awt.ComponentOrientation;
import java.awt.Cursor;

import com.dbutils.CrudOperation;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import java.sql.*;

public class My_Project_2 extends JFrame implements ActionListener {

	
	//--------------------------------------------
	
	private JPanel contentPane;
	private JPanel panel_3,LabourManagement,LOGIN,WorkManagement,ClientManagement,LabourRequestManagement,ReportManagement,FeedbackManagement;
	private JTextField txtUserIdphoneemailId;
	private JTextField txtPassword;
	private JLabel lbl_head;
	private JTextField Lid,Name,Phoneno,Address,Age,Workid,Lid_2,textField_7,textField_8,textField_9,textField_10,textField_11,textField_12;
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private JDateChooser dateChooser,dateChooser_1;
	private JTextField t;
	
    private ButtonGroup gender,status;
    private JRadioButton rdbtnMale,rdbtnFemale,rdbtnOnline,rdbtnOffline;
    
    private JButton button;
	
    //-----------------------------------------------
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					My_Project_2 frame = new My_Project_2();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public My_Project_2() {
		con = CrudOperation.createConnection();
		CreateGui();
	}
	
	public void CreateGui()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1238, 801);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//--------------------------------------- panel
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 259, 743);
		panel.setBackground(new Color(0, 0, 102));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_WorkManagement = new JButton("Work Management");
		btn_WorkManagement.setRequestFocusEnabled(false);
		btn_WorkManagement.setIconTextGap(30);
		btn_WorkManagement.setHorizontalAlignment(SwingConstants.LEFT);
		btn_WorkManagement.setIcon(new ImageIcon(My_Project_2.class.getResource("/com/images/download.png")));
		btn_WorkManagement.setBorder(null);
		btn_WorkManagement.setBackground(new Color(0, 255, 204));
		btn_WorkManagement.setBounds(0, 248, 249, 50);
		panel.add(btn_WorkManagement);
		btn_WorkManagement.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_WorkManagement.setBackground(new Color(153, 0, 255));
			 }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_WorkManagement.setBackground(new Color(0, 255, 204));
		    }
			
		});
		btn_WorkManagement.addActionListener(this);
		btn_WorkManagement.hide();
		
		JButton btn_clientManagement = new JButton("Client Management");
		btn_clientManagement.setRequestFocusEnabled(false);
		btn_clientManagement.setIconTextGap(30);
		btn_clientManagement.setHorizontalAlignment(SwingConstants.LEFT);
		btn_clientManagement.setIcon(new ImageIcon(My_Project_2.class.getResource("/com/images/download.png")));
		btn_clientManagement.setBorder(null);
		btn_clientManagement.setBackground(new Color(0, 255, 204));
		btn_clientManagement.setBounds(0, 297, 249, 50);
		panel.add(btn_clientManagement);
		btn_clientManagement.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_clientManagement.setBackground(new Color(153, 0, 255));
			 }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_clientManagement.setBackground(new Color(0, 255, 204));
		    }
			
		});
		btn_clientManagement.addActionListener(this);
		btn_clientManagement.hide();
		
		JButton btn_LabourManagement = new JButton("Labour Management");
		btn_LabourManagement.setRequestFocusEnabled(false);
		btn_LabourManagement.setIconTextGap(30);
		btn_LabourManagement.setHorizontalAlignment(SwingConstants.LEADING);
		btn_LabourManagement.setIcon(new ImageIcon(My_Project_2.class.getResource("/com/images/download.png")));
		btn_LabourManagement.setBorder(null);
		btn_LabourManagement.setBackground(new Color(0, 255, 204));
		btn_LabourManagement.setBounds(0, 199, 249, 50);
		panel.add(btn_LabourManagement);
		btn_LabourManagement.hide();
		btn_LabourManagement.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_LabourManagement.setBackground(new Color(153, 0, 255));
			 }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_LabourManagement.setBackground(new Color(0, 255, 204));
		    }
			
		});
		btn_LabourManagement.addActionListener(this);
		
		JButton btn_LabourRequestManagement = new JButton("Labour Request Management");
		btn_LabourRequestManagement.setRequestFocusEnabled(false);
		btn_LabourRequestManagement.setIconTextGap(30);
		btn_LabourRequestManagement.setHorizontalAlignment(SwingConstants.LEFT);
		btn_LabourRequestManagement.setIcon(new ImageIcon(My_Project_2.class.getResource("/com/images/download.png")));
		btn_LabourRequestManagement.setBorder(null);
		btn_LabourRequestManagement.setBackground(new Color(0, 255, 204));
		btn_LabourRequestManagement.setBounds(0, 346, 249, 50);
		panel.add(btn_LabourRequestManagement);
		btn_LabourRequestManagement.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_LabourRequestManagement.setBackground(new Color(153, 0, 255));
			 }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_LabourRequestManagement.setBackground(new Color(0, 255, 204));
		    }
			
		});
		btn_LabourRequestManagement.addActionListener(this);
		btn_LabourRequestManagement.hide();
		
		JButton btn_ReportManagement = new JButton("Report Management");
		btn_ReportManagement.setRequestFocusEnabled(false);
		btn_ReportManagement.setHorizontalAlignment(SwingConstants.LEFT);
		btn_ReportManagement.setIconTextGap(30);
		btn_ReportManagement.setHorizontalTextPosition(SwingConstants.RIGHT);
		btn_ReportManagement.setIcon(new ImageIcon(My_Project_2.class.getResource("/com/images/download.png")));
		btn_ReportManagement.setBorder(null);
		btn_ReportManagement.setBackground(new Color(0, 255, 204));
		btn_ReportManagement.setBounds(0, 395, 249, 50);
		panel.add(btn_ReportManagement);
		btn_ReportManagement.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_ReportManagement.setBackground(new Color(153, 0, 255));
			 }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_ReportManagement.setBackground(new Color(0, 255, 204));
		    }
			
		});
		btn_ReportManagement.addActionListener(this);
		btn_ReportManagement.hide();
		
		JButton btn_FeedbackManagement = new JButton("Feedback Management");
		btn_FeedbackManagement.setRequestFocusEnabled(false);
		btn_FeedbackManagement.setPressedIcon(new ImageIcon(My_Project_2.class.getResource("/com/images/undraw_walk_in_the_city_1ma6 - Copy.png")));
		btn_FeedbackManagement.setBorderPainted(false);
		btn_FeedbackManagement.setIconTextGap(30);
		btn_FeedbackManagement.setIcon(new ImageIcon(My_Project_2.class.getResource("/com/images/download.png")));
		btn_FeedbackManagement.setHorizontalAlignment(SwingConstants.LEFT);
		btn_FeedbackManagement.setBorder(null);
		btn_FeedbackManagement.setBackground(new Color(0, 255, 204));
		btn_FeedbackManagement.setBounds(0, 444, 249, 50);
		panel.add(btn_FeedbackManagement);
		btn_FeedbackManagement.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_FeedbackManagement.setBackground(new Color(153, 0, 255));
			 }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_FeedbackManagement.setBackground(new Color(0, 255, 204));
		    }
			
		});
		btn_FeedbackManagement.addActionListener(this);
		btn_FeedbackManagement.hide();
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 634, 239, 1);
		panel.add(separator_1);
		
		JLabel lblCopyRightsUnder = new JLabel("\u00A9 copyrights under Rupam, Shoeb and Gaurav");
		lblCopyRightsUnder.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyRightsUnder.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCopyRightsUnder.setForeground(new Color(255, 255, 255));
		lblCopyRightsUnder.setHorizontalTextPosition(SwingConstants.LEFT);
		lblCopyRightsUnder.setBounds(10, 681, 239, 13);
		panel.add(lblCopyRightsUnder);
		
		//-------------------------------------------------- panel 2
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 26, 259, 69);
		panel.add(panel_2);
		panel_2.setBackground(new Color(0, 255, 204));
		panel_2.setLayout(null);
		
		JLabel lblWorkforceManagementSystem = new JLabel("Workforce Management");
		lblWorkforceManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkforceManagementSystem.setBounds(0, 0, 259, 69);
		lblWorkforceManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_2.add(lblWorkforceManagementSystem);
		
		//------------------------------------------------- panel 1
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(279, 37, 935, 69);
		panel_1.setBackground(new Color(0, 0, 102));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lbl_head = new JLabel("Login Panel");
		lbl_head.setBounds(10, 10, 915, 49);
		lbl_head.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbl_head.setForeground(new Color(255, 255, 255));
		panel_1.add(lbl_head);
		
		JButton btnNewButton = new JButton("LOG OUT");
		btnNewButton.setRequestFocusEnabled(false);
		btnNewButton.setBounds(1125, 11, 89, 23);
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(new Color(0, 0, 153));
		btnNewButton.setBackground(new Color(204, 204, 255));
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		//----------------------------------------------------------- panel 3 
		
		 panel_3 = new JPanel();
		 panel_3.setBounds(279, 116, 935, 638);
		 panel_3.setBackground(new Color(255, 255, 255));
		 contentPane.add(panel_3);
		 panel_3.setLayout(new CardLayout(0, 0));
		 
		 LOGIN = new JPanel();
		 LOGIN.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.1f));
		 panel_3.add(LOGIN);
		 LOGIN.setLayout(null);
		 
		 JPanel panel_11 = new JPanel();
		 panel_11.setBorder(null);
		 panel_11.setBackground(new Color(255, 255, 255));
		 panel_11.setBounds(266, 92, 411, 467);
		 LOGIN.add(panel_11);
		 panel_11.setLayout(null);
		 
		 txtUserIdphoneemailId = new JTextField();
		 txtUserIdphoneemailId.setSelectedTextColor(new Color(51, 153, 255));
		 txtUserIdphoneemailId.setToolTipText("");
		 txtUserIdphoneemailId.setDisabledTextColor(new Color(255, 255, 255));
		 txtUserIdphoneemailId.setBackground(new Color(255, 255, 255));
		 txtUserIdphoneemailId.setForeground(new Color(0, 0, 204));
		 txtUserIdphoneemailId.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(153, 0, 255)));
		 txtUserIdphoneemailId.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		 txtUserIdphoneemailId.setBounds(10, 211, 391, 31);
		 panel_11.add(txtUserIdphoneemailId);
		 txtUserIdphoneemailId.setColumns(10);
		 
		 txtPassword = new JTextField();
		 txtPassword.setBackground(new Color(255, 255, 255));
		 txtPassword.setForeground(new Color(0, 0, 204));
		 txtPassword.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(153, 0, 255)));
		 txtPassword.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		 txtPassword.setBounds(10, 283, 391, 31);
		 panel_11.add(txtPassword);
		 txtPassword.setColumns(10);
		 
		 JButton btnNewButton_3 = new JButton("LOGIN");
		 btnNewButton_3.setRequestFocusEnabled(false);
		 btnNewButton_3.setBorder(null);
		 btnNewButton_3.setForeground(new Color(255, 255, 255));
		 btnNewButton_3.setBackground(new Color(0, 0, 153));
		 btnNewButton_3.setBounds(316, 436, 85, 21);
		 panel_11.add(btnNewButton_3);
		 
		 JLabel lblLogin = new JLabel("ADMIN LOGIN");
		 lblLogin.setForeground(new Color(0, 0, 204));
		 lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		 lblLogin.setHorizontalAlignment(SwingConstants.LEFT);
		 lblLogin.setBounds(76, 58, 158, 31);
		 panel_11.add(lblLogin);
		 
		 JLabel lblUserId = new JLabel("User ID");
		 lblUserId.setForeground(new Color(0, 0, 204));
		 lblUserId.setFont(new Font("Tahoma", Font.BOLD, 20));
		 lblUserId.setBounds(10, 180, 372, 21);
		 panel_11.add(lblUserId);
		 
		 JLabel lblPassword = new JLabel("Password");
		 lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		 lblPassword.setForeground(new Color(0, 0, 204));
		 lblPassword.setBounds(10, 252, 372, 21);
		 panel_11.add(lblPassword);
		 
		 JLabel lblLoginToAgree = new JLabel("Log-in to agree with terms and conditions");
		 lblLoginToAgree.setFont(new Font("Tahoma", Font.PLAIN, 10));
		 lblLoginToAgree.setBounds(10, 440, 284, 13);
		 panel_11.add(lblLoginToAgree);
		 
		 JSeparator separator = new JSeparator();
		 separator.setBounds(76, 99, 158, 2);
		 panel_11.add(separator);
		 
		 JLabel lblNewLabel_1 = new JLabel("New label");
		 lblNewLabel_1.setIcon(new ImageIcon(My_Project_2.class.getResource("/com/images/icon.png")));
		 lblNewLabel_1.setBounds(10, 58, 46, 43);
		 panel_11.add(lblNewLabel_1);
		 
		 LabourManagement = new JPanel();
		 LabourManagement.setBackground(new Color(255, 255, 255));
		 panel_3.add(LabourManagement, "name_247652658491700");
		 LabourManagement.setLayout(null);
		 
		 JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		 tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 tabbedPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		 tabbedPane.setBackground(new Color(255, 255, 255));
		 tabbedPane.setFocusable(false);
		 tabbedPane.setFocusTraversalKeysEnabled(false);
		 tabbedPane.setBounds(0, 0, 935, 638);
		 LabourManagement.add(tabbedPane);
		 
		 JPanel panel_4 = new JPanel();
		 panel_4.setBackground(new Color(255, 255, 255));
		 tabbedPane.addTab("ADD LABOUR DETAILS", null, panel_4, null);
		 panel_4.setLayout(null);
		 
		 JButton btnAddLabourDetails = new JButton("Add Labour Details");
		 btnAddLabourDetails.setRequestFocusEnabled(false);
		 btnAddLabourDetails.setForeground(new Color(255, 255, 255));
		 btnAddLabourDetails.setBackground(new Color(0, 0, 102));
		 btnAddLabourDetails.setBorder(null);
		 btnAddLabourDetails.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 btnAddLabourDetails.setBounds(781, 577, 139, 21);
		 panel_4.add(btnAddLabourDetails);
		 btnAddLabourDetails.addActionListener(this);
		 
		 Lid = new JTextField();
		 Lid.setCaretColor(new Color(0, 0, 153));
		 Lid.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 Lid.setBounds(10, 96, 449, 19);
		 panel_4.add(Lid);
		 Lid.setColumns(10);
		 
		 Name = new JTextField();
		 Name.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 Name.setBounds(471, 96, 449, 19);
		 panel_4.add(Name);
		 Name.setColumns(10);
		 
		 Phoneno = new JTextField();
		 Phoneno.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 Phoneno.setBounds(10, 188, 449, 19);
		 panel_4.add(Phoneno);
		 Phoneno.setColumns(10);
		 
		 Address = new JTextField();
		 Address.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 Address.setBounds(471, 188, 449, 19);
		 panel_4.add(Address);
		 Address.setColumns(10);
		 
		 Age = new JTextField();
		 Age.setCaretColor(new Color(0, 0, 153));
		 Age.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 Age.setBounds(10, 281, 449, 19);
		 panel_4.add(Age);
		 Age.setColumns(10);
		 
		 Workid = new JTextField();
		 Workid.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 Workid.setBounds(471, 281, 449, 19);
		 panel_4.add(Workid);
		 Workid.setColumns(10);
		 
		 JLabel lblLid = new JLabel("Lid");
		 lblLid.setBounds(10, 73, 449, 13);
		 panel_4.add(lblLid);
		 
		 JLabel lblPhoneno = new JLabel("Phoneno");
		 lblPhoneno.setBounds(10, 165, 449, 13);
		 panel_4.add(lblPhoneno);
		 
		 JLabel lblAddress = new JLabel("Address");
		 lblAddress.setBounds(471, 165, 449, 13);
		 panel_4.add(lblAddress);
		 
		 JLabel lblName = new JLabel("Name");
		 lblName.setBounds(471, 73, 449, 13);
		 panel_4.add(lblName);
		 
		 JLabel lblAge = new JLabel("Age");
		 lblAge.setBounds(10, 258, 449, 13);
		 panel_4.add(lblAge);
		 
		 JLabel lblWorkid = new JLabel("Workid");
		 lblWorkid.setBounds(471, 258, 449, 13);
		 panel_4.add(lblWorkid);
		 
		  dateChooser = new JDateChooser();
		 dateChooser.setBounds(471, 374, 449, 19);
		 panel_4.add(dateChooser);
		 
		dateChooser_1 = new JDateChooser();
		 dateChooser_1.setBounds(471, 458, 449, 19);
		 panel_4.add(dateChooser_1);
		 
		 JLabel lblDateOfJoining = new JLabel("Date of joining");
		 lblDateOfJoining.setBounds(471, 351, 449, 13);
		 panel_4.add(lblDateOfJoining);
		 
		 //-----------------------------------------panel 3 >labour management> radio button
		 
		 JLabel lblGender = new JLabel("Gender");
		 lblGender.setBounds(10, 351, 449, 13);
		 panel_4.add(lblGender);
		 
		 gender = new ButtonGroup();
		 
		 rdbtnMale = new JRadioButton("male");
		 rdbtnMale.setRequestFocusEnabled(false);
		 rdbtnMale.setBackground(new Color(255, 255, 255));
		 rdbtnMale.setBorder(null);
		 rdbtnMale.setBounds(10, 374, 66, 21);
		 panel_4.add(rdbtnMale);
		 gender.add(rdbtnMale);
		 
		 rdbtnFemale = new JRadioButton("female");
		 rdbtnFemale.setRequestFocusEnabled(false);
		 rdbtnFemale.setBackground(new Color(255, 255, 255));
		 rdbtnFemale.setBorder(null);
		 rdbtnFemale.setBounds(78, 374, 66, 21);
		 panel_4.add(rdbtnFemale);
		 gender.add(rdbtnFemale);
		 
		 //------------------------------------------
		 
		 JLabel lblStatus = new JLabel("Status");
		 lblStatus.setBounds(10, 435, 449, 13);
		 panel_4.add(lblStatus);
		 
		 JLabel lblDateOfLeaving = new JLabel("Date of leaving");
		 lblDateOfLeaving.setBounds(471, 435, 449, 13);
		 panel_4.add(lblDateOfLeaving);
		 
		 //-------------------------------------------radio button for status
		 
		 status = new ButtonGroup();
		 
		 rdbtnOnline = new JRadioButton("online");
		 rdbtnOnline.setRequestFocusEnabled(false);
		 rdbtnOnline.setBorder(null);
		 rdbtnOnline.setBackground(new Color(255, 255, 255));
		 rdbtnOnline.setBounds(10, 458, 66, 21);
		 panel_4.add(rdbtnOnline);
		 status.add(rdbtnOnline);
		 
		 rdbtnOffline = new JRadioButton("offline");
		 rdbtnOffline.setRequestFocusEnabled(false);
		 rdbtnOffline.setBackground(new Color(255, 255, 255));
		 rdbtnOffline.setBorder(null);
		 rdbtnOffline.setBounds(78, 458, 66, 21);
		 panel_4.add(rdbtnOffline);
		 status.add(rdbtnOffline);

		 //_-------------------------------------------
		 JPanel panel_5 = new JPanel();
		 panel_5.setBackground(new Color(255, 255, 255));
		 panel_5.setBorder(null);
		 tabbedPane.addTab("DELETE LABOUR DETAILS", null, panel_5, null);
		 panel_5.setLayout(null);
		 
		 JButton btnDeleteLabourDetails = new JButton("Delete Labour Details");
		 btnDeleteLabourDetails.setRequestFocusEnabled(false);
		 btnDeleteLabourDetails.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 btnDeleteLabourDetails.setBorder(null);
		 btnDeleteLabourDetails.setBackground(new Color(0, 0, 102));
		 btnDeleteLabourDetails.setForeground(new Color(255, 255, 255));
		 btnDeleteLabourDetails.setBounds(773, 577, 147, 21);
		 panel_5.add(btnDeleteLabourDetails);
		 btnDeleteLabourDetails.addActionListener(this);
		 
		 Lid_2 = new JTextField();
		 Lid_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		 Lid_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 Lid_2.setBackground(new Color(255, 255, 255));
		 Lid_2.setBounds(10, 145, 450, 19);
		 panel_5.add(Lid_2);
		 Lid_2.setColumns(10);
		 
		 JLabel lblLabourIdTo = new JLabel("Labour ID to be deleted");
		 lblLabourIdTo.setBounds(10, 122, 147, 13);
		 panel_5.add(lblLabourIdTo);
		 
		 JPanel panel_6 = new JPanel();
		 panel_6.setBorder(null);
		 panel_6.setBackground(new Color(255, 255, 255));
		 tabbedPane.addTab("UPDATE LABOUR DETAILS", null, panel_6, null);
		 panel_6.setLayout(null);
		 
		 JButton btnUpdateLabourDetails = new JButton("Update Labour details");
		 btnUpdateLabourDetails.setRequestFocusEnabled(false);
		 btnUpdateLabourDetails.setForeground(new Color(255, 255, 255));
		 btnUpdateLabourDetails.setBorder(null);
		 btnUpdateLabourDetails.setBackground(new Color(0, 0, 102));
		 btnUpdateLabourDetails.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 btnUpdateLabourDetails.setBounds(765, 577, 155, 21);
		 panel_6.add(btnUpdateLabourDetails);
		 
		 JLabel lblLId = new JLabel("L ID");
		 lblLId.setBounds(10, 75, 46, 13);
		 panel_6.add(lblLId);
		 
		 JLabel lblName_1 = new JLabel("Name");
		 lblName_1.setBounds(469, 75, 46, 13);
		 panel_6.add(lblName_1);
		 
		 textField_7 = new JTextField();
		 textField_7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 textField_7.setBounds(10, 98, 449, 19);
		 panel_6.add(textField_7);
		 textField_7.setColumns(10);
		 
		 textField_8 = new JTextField();
		 textField_8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 textField_8.setBounds(469, 98, 451, 19);
		 panel_6.add(textField_8);
		 textField_8.setColumns(10);
		 
		 textField_9 = new JTextField();
		 textField_9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 textField_9.setBounds(10, 188, 449, 19);
		 panel_6.add(textField_9);
		 textField_9.setColumns(10);
		 
		 textField_10 = new JTextField();
		 textField_10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 textField_10.setBounds(469, 188, 451, 19);
		 panel_6.add(textField_10);
		 textField_10.setColumns(10);
		 
		 textField_11 = new JTextField();
		 textField_11.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 textField_11.setBounds(10, 279, 449, 19);
		 panel_6.add(textField_11);
		 textField_11.setColumns(10);
		 
		 textField_12 = new JTextField();
		 textField_12.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 textField_12.setBounds(469, 279, 451, 19);
		 panel_6.add(textField_12);
		 textField_12.setColumns(10);
		 
		 JLabel lblNewLabel_2 = new JLabel("New label");
		 lblNewLabel_2.setBounds(10, 165, 46, 13);
		 panel_6.add(lblNewLabel_2);
		 
		 JLabel lblNewLabel_3 = new JLabel("New label");
		 lblNewLabel_3.setBounds(10, 256, 46, 13);
		 panel_6.add(lblNewLabel_3);
		 
		 JLabel lblNewLabel_4 = new JLabel("New label");
		 lblNewLabel_4.setBounds(469, 165, 46, 13);
		 panel_6.add(lblNewLabel_4);
		 
		 JLabel lblNewLabel_5 = new JLabel("New label");
		 lblNewLabel_5.setBounds(469, 256, 46, 13);
		 panel_6.add(lblNewLabel_5);
		 
		 JDateChooser dateChooser_2 = new JDateChooser();
		 dateChooser_2.setBounds(469, 375, 451, 19);
		 panel_6.add(dateChooser_2);
		 
		 JDateChooser dateChooser_3 = new JDateChooser();
		 dateChooser_3.setBounds(469, 470, 451, 19);
		 panel_6.add(dateChooser_3);
		 
		 JLabel lblNewLabel_6 = new JLabel("New label");
		 lblNewLabel_6.setBounds(469, 352, 46, 13);
		 panel_6.add(lblNewLabel_6);
		 
		 JLabel lblNewLabel_7 = new JLabel("New label");
		 lblNewLabel_7.setBounds(469, 447, 46, 13);
		 panel_6.add(lblNewLabel_7);
		 
		 JLabel lblNewLabel_8 = new JLabel("New label");
		 lblNewLabel_8.setBounds(10, 352, 46, 13);
		 panel_6.add(lblNewLabel_8);
		 
		 JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		 rdbtnNewRadioButton.setBounds(6, 375, 105, 21);
		 panel_6.add(rdbtnNewRadioButton);
		 
		 JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		 rdbtnNewRadioButton_1.setBounds(113, 375, 105, 21);
		 panel_6.add(rdbtnNewRadioButton_1);
		 
		 JLabel lblNewLabel_9 = new JLabel("New label");
		 lblNewLabel_9.setBounds(10, 447, 46, 13);
		 panel_6.add(lblNewLabel_9);
		 
		 JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		 rdbtnNewRadioButton_2.setBounds(10, 470, 105, 21);
		 panel_6.add(rdbtnNewRadioButton_2);
		 
		 JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		 rdbtnNewRadioButton_3.setBounds(117, 470, 105, 21);
		 panel_6.add(rdbtnNewRadioButton_3);
		 
		 WorkManagement = new JPanel();
		 WorkManagement.setBackground(new Color(255, 255, 255));
		 panel_3.add(WorkManagement, "name_345442966126300");
		 
		 ClientManagement = new JPanel();
		 ClientManagement.setBackground(new Color(255, 255, 255));
		 panel_3.add(ClientManagement, "name_345468046816900");
		 
		 LabourRequestManagement = new JPanel();
		 LabourRequestManagement.setBackground(new Color(255, 255, 255));
		 panel_3.add(LabourRequestManagement, "name_345477277708800");
		 
		 ReportManagement = new JPanel();
		 ReportManagement.setBackground(new Color(255, 255, 255));
		 panel_3.add(ReportManagement, "name_345495802535400");
		 
		 FeedbackManagement = new JPanel();
		 FeedbackManagement.setBackground(new Color(255, 255, 255));
		 panel_3.add(FeedbackManagement, "name_345498278301800");
		 
		 JLabel lblNewLabel = new JLabel("New label");
		 lblNewLabel.setBounds(0, 0, 1224, 774);
		 contentPane.add(lblNewLabel);
		 lblNewLabel.setIcon(new ImageIcon(My_Project_2.class.getResource("/com/images/square.jpg")));
		
		
	}
	 public String labourmanagementgettext() { String Lid1 = Lid.getText(); String
	 Name1 = Name.getText(); String Phoneno1 = Phoneno.getText(); String Address1
	  = Address.getText(); String Age1 = Age.getText(); String Workid1 =
	  Workid.getText();
	  
	  
	  String gender=null; if (rdbtnMale.isSelected()==true) {
	  gender=rdbtnMale.getText(); } if(rdbtnFemale.isSelected()==true) {
	  gender=rdbtnFemale.getText(); }
	  
	  String status=null; if (rdbtnOnline.isSelected()==true) {
	  status=rdbtnOnline.getText(); } if(rdbtnOffline.isSelected()==true) {
	  status=rdbtnOffline.getText(); }
	  
	  java.util.Date d = dateChooser.getDate(); long date=d.getTime();
	  java.sql.Date sd = new java.sql.Date(date);
	  JOptionPane.showMessageDialog(this,sd.toString());
	  
	  java.util.Date d_1 = dateChooser_1.getDate(); long date_1=d_1.getTime();
	  java.sql.Date ed = new java.sql.Date(date_1);
	  JOptionPane.showMessageDialog(this,ed.toString());
	  
	  return Name1;
	  
	  
	  }
	 

	@Override
	public void actionPerformed(ActionEvent e)  {
		String caption = e.getActionCommand();
		
		switch(caption) {
		
		case "Labour Management":
		{
			LOGIN.setVisible(false);
			WorkManagement.setVisible(false);
			ClientManagement.setVisible(false);
			LabourRequestManagement.setVisible(false);
			ReportManagement.setVisible(false);
			FeedbackManagement.setVisible(false);
			lbl_head.setText("  Labour Management");
			LabourManagement.setVisible(true);
			break;
		}
		case "Work Management":
		{
			
			lbl_head.setText("  Work Management");
			LabourManagement.setVisible(false);
			LOGIN.setVisible(false);
			ClientManagement.setVisible(false);
			LabourRequestManagement.setVisible(false);
			ReportManagement.setVisible(false);
			FeedbackManagement.setVisible(false);
			WorkManagement.setVisible(true);
			break;
		}
		case "Client Management":
		{
			LabourManagement.setVisible(false);
			LOGIN.setVisible(false);
			LabourRequestManagement.setVisible(false);
			ReportManagement.setVisible(false);
			FeedbackManagement.setVisible(false);
			WorkManagement.setVisible(false);
			ClientManagement.setVisible(true);
			lbl_head.setText("Client Management");
			break;
		}
		case "Labour Request Management":
		{
			LabourManagement.setVisible(false);
			LOGIN.setVisible(false);
			ReportManagement.setVisible(false);
			FeedbackManagement.setVisible(false);
			WorkManagement.setVisible(false);
			ClientManagement.setVisible(false);
			LabourRequestManagement.setVisible(true);
			lbl_head.setText("Labour Request Management");
			break;
	    }
		case "Report Management":
		{
			LabourManagement.setVisible(false);
			LOGIN.setVisible(false);
			FeedbackManagement.setVisible(false);
			WorkManagement.setVisible(false);
			ClientManagement.setVisible(false);
			LabourRequestManagement.setVisible(false);
			ReportManagement.setVisible(true);
			lbl_head.setText("report Management");
			break;
		}
		case "Feedback Management":
		{
			LabourManagement.setVisible(false);
			LOGIN.setVisible(false);
			WorkManagement.setVisible(false);
			ClientManagement.setVisible(false);
			LabourRequestManagement.setVisible(false);
			ReportManagement.setVisible(false);
			FeedbackManagement.setVisible(true);
			lbl_head.setText("Feedback Management");
			break;
		}
		case "LOG OUT":
		{
			LOGIN.setVisible(true);
			WorkManagement.setVisible(false);
			ClientManagement.setVisible(false);
			LabourRequestManagement.setVisible(false);
			ReportManagement.setVisible(false);
			FeedbackManagement.setVisible(false);
			LabourManagement.setVisible(false);
			break;
		}
		}
		//--------------------------------------------Labour entry 
			if(caption.equals("Add Labour Details"))
			{
				
				
				try {
					
					
					
//					String strinsert = "insert into labourdetails values(?,?,?,?,?,?,?,?,?,?)";
//					ps=con.prepareStatement(strinsert);
//					String Lid1;
//					ps.setString(1,Lid1);
//					String Name1;
//					ps.setString(2,Name1);
//					String Phoneno1;
//					ps.setString(3,Phoneno1);
//					String Address1;
//					ps.setString(4,Address1);
//					
//					String Age1;
//					ps.setString(6,Age1);
//					ps.setString(7, Workid1);
//					ps.setDate(8, sd);
//					ps.setDate(9, ed);
//					ps.setString(10, status);
					int row = ps.executeUpdate();
						if(row>0)
						{
						JOptionPane.showMessageDialog(this,"done");
						
						Lid.setText("");Name.setText("");Phoneno.setText("");Address.setText("");Age.setText("");Workid.setText("");
						
						rdbtnFemale.setSelected(false);
						rdbtnMale.setSelected(false);
						rdbtnOnline.setSelected(false);
						rdbtnOffline.setSelected(false);
						
						dateChooser_1.setCalendar(null);
						dateChooser.setCalendar(null);
						}
					}
					catch(SQLException se){
						System.out.println(se);
					}
			}
			
			//----------------------------------------------------------labour delete
			
			if(caption.equals("Delete Labour Details"))
			{
				String Lid2 = Lid_2.getText();
				String strdelete="delete from labourdetails where Lid=?";
				try {
					ps=con.prepareStatement(strdelete);
					ps.setString(1, Lid2);//variable
					int row = ps.executeUpdate();
					if(row>0)
					{
						JOptionPane.showMessageDialog(this, "done");
						Lid_2.setText("");
					}
					
				}catch(SQLException se) {
					System.out.println(se);
				}
			}
			//---------------------------------------------------------labour update
			
	}
}
