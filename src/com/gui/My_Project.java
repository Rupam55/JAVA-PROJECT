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

public class My_Project extends JFrame implements ActionListener {

	
	//--------------------------------------------
	
	private JPanel contentPane;
	private JLabel lbl_head, errormsg,position,name,icon;
	private JTextField t;
	
    private JButton button,btn_WorkManagement,btn_clientManagement,btn_LabourManagement,btn_LabourRequestManagement,btn_ReportManagement,btn_FeedbackManagement,logout,btn_clientchat;
    
    private JPanel LOGIN,welcome;
    
    private LabourManagement l = new LabourManagement();
    private WorkManagement w = new WorkManagement();
    private LabourReqDetails lrd = new LabourReqDetails();
    private Clientdetails cd= new Clientdetails();
    private Feedback f = new Feedback();
    private ReportManagement rm = new ReportManagement();
    public Operatorchat oc = new Operatorchat();
    private Clientchat cc= new Clientchat();
    
    private JTextField UserID;
    private JTextField Password;
    
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection con;
	
    //-----------------------------------------------
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					My_Project frame = new My_Project();
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setResizable(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public My_Project() {
		con=CrudOperation.createConnection();
		CreateGui();
	}
	
	public void CreateGui()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1238, 760);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//------------------------------------------------------content pane buttons

		logout = new JButton("LOG OUT");
		logout.setRequestFocusEnabled(false);
		logout.setBounds(1073, 11, 89, 23);
		logout.setBorder(null);
		logout.setForeground(new Color(0, 0, 153));
		logout.setBackground(new Color(204, 204, 255));
		contentPane.add(logout);
		logout.addActionListener(this);
		logout.hide();
		 
		 JButton btnClose = new JButton("X");
		 btnClose.setRequestFocusEnabled(false);
		 btnClose.setForeground(new Color(255, 0, 0));
		 btnClose.setBorder(null);
		 btnClose.setBackground(new Color(204, 204, 255));
		 btnClose.setBounds(1192, 11, 22, 23);
		 contentPane.add(btnClose);
		 btnClose.addActionListener(this);
		 btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					btnClose.setBackground(new Color(254, 76, 76));
				 }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			        btnClose.setBackground(new Color(204, 204, 255));
			    }
				
			});
		 
		 JButton button_1 = new JButton("-");
		 button_1.setRequestFocusEnabled(false);
		 button_1.addActionListener(this);
		 	
		 button_1.setBorder(null);
		 button_1.setBackground(new Color(204, 204, 255));
		 button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 button_1.setForeground(new Color(0, 0, 102));
		 button_1.setBounds(1166, 11, 22, 23);
		 contentPane.add(button_1);
		 
		 //--------------------------------------- panel
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 259, 743);
		panel.setBackground(new Color(0, 0, 102));
		contentPane.add(panel);
		panel.setLayout(null);
		
		//-------------------------------------------------major buttons
		
		btn_WorkManagement = new JButton("Work Management");
		btn_WorkManagement.setRequestFocusEnabled(false);
		btn_WorkManagement.setIconTextGap(30);
		btn_WorkManagement.setHorizontalAlignment(SwingConstants.LEFT);
		btn_WorkManagement.setIcon(new ImageIcon(My_Project.class.getResource("/com/images/iconbtn1.png")));
		btn_WorkManagement.setBorder(null);
		btn_WorkManagement.setBackground(new Color(0, 255, 204));
		btn_WorkManagement.setBounds(0, 248, 249, 50);
		panel.add(btn_WorkManagement);
		btn_WorkManagement.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_WorkManagement.setBackground(new Color(0, 153, 153));
			 }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_WorkManagement.setBackground(new Color(0, 255, 204));
		    }
			
		});
		btn_WorkManagement.addActionListener(this);
		btn_WorkManagement.hide();
		
		btn_clientManagement = new JButton("Client Management");
		btn_clientManagement.setRequestFocusEnabled(false);
		btn_clientManagement.setIconTextGap(30);
		btn_clientManagement.setHorizontalAlignment(SwingConstants.LEFT);
		btn_clientManagement.setIcon(new ImageIcon(My_Project.class.getResource("/com/images/iconbtn1.png")));
		btn_clientManagement.setBorder(null);
		btn_clientManagement.setBackground(new Color(0, 255, 204));
		btn_clientManagement.setBounds(0, 297, 249, 50);
		panel.add(btn_clientManagement);
		btn_clientManagement.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_clientManagement.setBackground(new Color(0, 153, 153));
			 }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_clientManagement.setBackground(new Color(0, 255, 204));
		    }
			
		});
		btn_clientManagement.addActionListener(this);
		btn_clientManagement.hide();
		
		btn_LabourManagement = new JButton("Labour Management");
		btn_LabourManagement.setRequestFocusEnabled(false);
		btn_LabourManagement.setIconTextGap(30);
		btn_LabourManagement.setHorizontalAlignment(SwingConstants.LEADING);
		btn_LabourManagement.setIcon(new ImageIcon(My_Project.class.getResource("/com/images/iconbtn1.png")));
		btn_LabourManagement.setBorder(null);
		btn_LabourManagement.setBackground(new Color(0, 255, 204));
		btn_LabourManagement.setBounds(0, 199, 249, 50);
		panel.add(btn_LabourManagement);
		
		btn_LabourManagement.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_LabourManagement.setBackground(new Color(0, 153, 153));
			 }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_LabourManagement.setBackground(new Color(0, 255, 204));
		    }
			
		});
		btn_LabourManagement.addActionListener(this);
		btn_LabourManagement.hide();
		
		btn_LabourRequestManagement = new JButton("Labour Request Management");
		btn_LabourRequestManagement.setPressedIcon(new ImageIcon(My_Project.class.getResource("/com/images/iconbtn.png")));
		btn_LabourRequestManagement.setRequestFocusEnabled(false);
		btn_LabourRequestManagement.setIconTextGap(30);
		btn_LabourRequestManagement.setHorizontalAlignment(SwingConstants.LEFT);
		btn_LabourRequestManagement.setIcon(new ImageIcon(My_Project.class.getResource("/com/images/iconbtn1.png")));
		btn_LabourRequestManagement.setBorder(null);
		btn_LabourRequestManagement.setBackground(new Color(0, 255, 204));
		btn_LabourRequestManagement.setBounds(0, 346, 249, 50);
		panel.add(btn_LabourRequestManagement);
		btn_LabourRequestManagement.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_LabourRequestManagement.setBackground(new Color(0, 153, 153));
			 }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_LabourRequestManagement.setBackground(new Color(0, 255, 204));
		    }
			
		});
		btn_LabourRequestManagement.addActionListener(this);
		btn_LabourRequestManagement.hide();
		
		btn_ReportManagement = new JButton("Report Management");
		btn_ReportManagement.setRequestFocusEnabled(false);
		btn_ReportManagement.setHorizontalAlignment(SwingConstants.LEFT);
		btn_ReportManagement.setIconTextGap(30);
		btn_ReportManagement.setHorizontalTextPosition(SwingConstants.RIGHT);
		btn_ReportManagement.setIcon(new ImageIcon(My_Project.class.getResource("/com/images/iconbtn1.png")));
		btn_ReportManagement.setBorder(null);
		btn_ReportManagement.setBackground(new Color(0, 255, 204));
		btn_ReportManagement.setBounds(0, 395, 249, 50);
		panel.add(btn_ReportManagement);
		btn_ReportManagement.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_ReportManagement.setBackground(new Color(0, 153, 153));
			 }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_ReportManagement.setBackground(new Color(0, 255, 204));
		    }
			
		});
		btn_ReportManagement.addActionListener(this);
		btn_ReportManagement.hide();
		
		btn_FeedbackManagement = new JButton("Feedback Management");
		btn_FeedbackManagement.setRequestFocusEnabled(false);
		btn_FeedbackManagement.setBorderPainted(false);
		btn_FeedbackManagement.setIconTextGap(30);
		btn_FeedbackManagement.setIcon(new ImageIcon(My_Project.class.getResource("/com/images/iconbtn1.png")));
		btn_FeedbackManagement.setHorizontalAlignment(SwingConstants.LEFT);
		btn_FeedbackManagement.setBorder(null);
		btn_FeedbackManagement.setBackground(new Color(0, 255, 204));
		btn_FeedbackManagement.setBounds(0, 444, 249, 50);
		panel.add(btn_FeedbackManagement);
		btn_FeedbackManagement.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_FeedbackManagement.setBackground(new Color(0, 153, 153));
			 }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_FeedbackManagement.setBackground(new Color(0, 255, 204));
		    }
			
		});
		btn_FeedbackManagement.addActionListener(this);
		btn_FeedbackManagement.hide();
		
		btn_clientchat = new JButton("\tclient chat");
		btn_clientchat.setIconTextGap(30);
		btn_clientchat.setHorizontalAlignment(SwingConstants.LEFT);
		btn_clientchat.setIcon(new ImageIcon(My_Project.class.getResource("/com/images/iconbtn1.png")));
		btn_clientchat.setBorder(null);
		btn_clientchat.setBackground(new Color(0, 255, 204));
		btn_clientchat.setBounds(0, 493, 249, 50);
		panel.add(btn_clientchat);
		btn_clientchat.addActionListener(this);
		btn_clientchat.hide();
		btn_clientchat.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_clientchat.setBackground(new Color(0, 153, 153));
			 }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btn_clientchat.setBackground(new Color(0, 255, 204));
		    }
			
		});
		
		//----------------------------------------------------------------------
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 649, 239, 1);
		panel.add(separator_1);
		
		JLabel lblCopyRightsUnder = new JLabel("\u00A9 copyrights under Rupam and Gaurav");
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
		lbl_head.setBounds(10, 10, 125, 49);
		lbl_head.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbl_head.setForeground(new Color(255, 255, 255));
		panel_1.add(lbl_head);
		
		position = new JLabel("");
		position.setHorizontalAlignment(SwingConstants.TRAILING);
		position.setFont(new Font("Tahoma", Font.PLAIN, 16));
		position.setForeground(new Color(255, 255, 255));
		position.setBounds(548, 10, 318, 26);
		panel_1.add(position);
		
		 name = new JLabel("");
		name.setForeground(new Color(255, 255, 255));
		name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		name.setHorizontalAlignment(SwingConstants.TRAILING);
		name.setBounds(394, 33, 472, 26);
		panel_1.add(name);
		
		 icon = new JLabel("");
		icon.setIcon(new ImageIcon(My_Project.class.getResource("/com/images/customer-login-icon-27.jpg")));
		icon.setBounds(876, 10, 49, 49);
		panel_1.add(icon);
		icon.setVisible(false);
		
		
		//--------------------------------------------------------------
		
	    LOGIN = new JPanel();
		LOGIN.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.1f));
		LOGIN.setBounds(279, 116, 935, 638);
		contentPane.add(LOGIN);
		LOGIN.setLayout(null);
		
		JPanel login = new JPanel();
		login.setBackground(new Color(255, 255, 255));
		login.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		login.setBounds(293, 103, 389, 441);
		LOGIN.add(login);
		login.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setForeground(new Color(51, 0, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(78, 50, 131, 43);
		login.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(My_Project.class.getResource("/com/images/icon.png")));
		lblNewLabel_2.setBounds(22, 50, 46, 43);
		login.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 103, 131, 2);
		login.add(separator);
		
		UserID = new JTextField();
		UserID.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		UserID.setBounds(10, 189, 369, 19);
		login.add(UserID);
		UserID.setColumns(10);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setForeground(new Color(0, 102, 255));
		lblUserId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUserId.setBounds(10, 160, 369, 19);
		login.add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 102, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(10, 218, 369, 27);
		login.add(lblPassword);
		
		Password = new JTextField();
		Password.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		Password.setBounds(10, 255, 369, 19);
		login.add(Password);
		Password.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setRequestFocusEnabled(false);
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 0, 102));
		btnLogin.setBorder(null);
		btnLogin.setBounds(294, 410, 85, 21);
		login.add(btnLogin);
		btnLogin.addActionListener(this);
		
		JLabel lblLoginToAgree = new JLabel("Log-in to agree with terms and conditions");
		 lblLoginToAgree.setFont(new Font("Tahoma", Font.PLAIN, 10));
		 lblLoginToAgree.setBounds(10, 414, 284, 13);
		 login.add(lblLoginToAgree);
		 
		 errormsg = new JLabel("id or password did not match");
		 errormsg.setForeground(new Color(255, 0, 0));
		 errormsg.setBounds(10, 284, 369, 13);
		 login.add(errormsg);
		 errormsg.setVisible(false);
		 
		
		welcome = new JPanel();
		welcome.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
		welcome.setBounds(279, 116, 935, 638);
		contentPane.add(welcome);
		welcome.setVisible(false);
		 
		
		//--------------------------------------------------------------- bg image 
		
		JLabel lblNewLabel = new JLabel("New label");
		 lblNewLabel.setBounds(0, 0, 1224, 774);
		 contentPane.add(lblNewLabel);
		 lblNewLabel.setIcon(new ImageIcon(My_Project.class.getResource("/com/images/square.jpg")));
		
		//---------------------------------------------------------------- end of create gui
		
		
	}
	
	//---------------------------------------------------------------------------------methods for jframe
	
	public void closeframe()
	{
		l.dispose();
		w.dispose();
		lrd.dispose();
		cd.dispose();
		f.dispose();
		rm.dispose();
		cc.dispose();
		oc.dispose();
	}
	public void setframe()
	{
		My_Project my = new My_Project();
		l.setLocation(my.getX() + 279 , my.getY() + 116);
		l.setUndecorated(true);
		w.setLocation(my.getX() + 279 , my.getY() + 116);
		w.setUndecorated(true);
		lrd.setLocation(my.getX() + 279 , my.getY() + 116);
		lrd.setUndecorated(true);
		cd.setLocation(my.getX() + 279 , my.getY() + 116);
		cd.setUndecorated(true);
		f.setLocation(my.getX() + 279 , my.getY() + 116);
		f.setUndecorated(true);
		rm.setLocation(my.getX() + 279 , my.getY() + 116);
		rm.setUndecorated(true);
		cc.setLocation(my.getX() + 279 , my.getY() + 116);
		cc.setUndecorated(true);
		oc.setLocation(my.getX() + 279 , my.getY() + 116);
		oc.setUndecorated(true);
	}
	
	//----------------------------------------------------------------------------------

	@Override
	public void actionPerformed(ActionEvent e)  {
		String caption = e.getActionCommand();
		
		switch(caption) 
		{
		
			case "Labour Management":
			{
				closeframe();
				setframe();
				l.setVisible(true);
				break;
			}
			case "Work Management":
			{
				closeframe();
				setframe();
				w.setVisible(true);	
			break;
			}
			case "Client Management":
			{
				closeframe();
				setframe();
				cd.setVisible(true);
		
			break;
			}
			case "Labour Request Management":
			{
				closeframe();
				setframe();
				lrd.setVisible(true);
			break;	
		    }
			case "Report Management":
			{
				closeframe();
				setframe();
				rm.setVisible(true);
			break;
			}
			case "Feedback Management":
			{
				closeframe();
				setframe();
				f.setVisible(true);
			break;	
			}
			case "client chat":
			{
				closeframe();
				setframe();
				oc.setVisible(true);
			break;	
			}
			case "LOG OUT":
			{
				
				btn_LabourManagement.hide();
				btn_WorkManagement.hide();
				btn_clientManagement.hide();
				btn_LabourRequestManagement.hide();
				btn_ReportManagement.hide();
				btn_FeedbackManagement.hide();
				btn_clientchat.hide();
				LOGIN.setVisible(true);	
				UserID.setText("");
				Password.setText("");
				logout.hide();
				icon.setVisible(false);
				name.setText("");
				position.setText("");
				break;
			}
			case "X":
			{
				System.exit(0);
			break;
			}
			case "LOGIN":
			{
				String id = UserID.getText();
				String pass = Password.getText();
				try{
					ps=con.prepareStatement("select * from login where id='"+id+"' and pass='"+pass+"'");
				    rs=ps.executeQuery();
				    if(rs.next()==true)
				    {
				    	String pos =rs.getString(5);
				    	if(pos.equals("client"))
				    	{
				    		closeframe();
							setframe();
							cc.name(id);
							cc.setVisible(true);
							name.setText(rs.getString(4));
				    	    position.setText(rs.getString(5));
				    	    icon.setVisible(true);
				    	    logout.show();
				    									
				    	}else {
				    		name.setText(rs.getString(4));
				    	    position.setText(rs.getString(5));
				    	    icon.setVisible(true);
				    		btn_LabourManagement.show();
							btn_WorkManagement.show();
							btn_clientManagement.show();
							btn_LabourRequestManagement.show();
							btn_ReportManagement.show();
							btn_FeedbackManagement.show();
							btn_clientchat.show();
							LOGIN.setVisible(false);
							logout.show();
							btn_clientchat.show();	
							oc.name(rs.getString(4));
				    	}	
				    }
				    else
				    {
				    	errormsg.setVisible(true);
				    	UserID.setText("");
				    	Password.setText("");
				    }
				
					
				}catch(SQLException se)
				{
					System.out.println(se);
					
				}finally {
					try {
						ps.close();
						rs.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			break;
			}
			case "-":
			{
				
				break;
			}
		}
		
						
	}
}
