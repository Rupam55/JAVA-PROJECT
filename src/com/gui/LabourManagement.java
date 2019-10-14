package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.dbutils.CrudOperation;
import com.toedter.calendar.JDateChooser;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import java.sql.*;
import javax.swing.JComboBox;

public class LabourManagement extends JFrame implements ActionListener {

	private JPanel contentPane;

	private JTextField Lid,Name,Phoneno,Address,Age,Lid_2,name2,phoneno2,address2,age2;
	
	private JDateChooser dateChooser,dateChooser_1,dateChooser_2,dateChooser_3;
	
	private ButtonGroup gender;
	private JRadioButton rdbtnMale,rdbtnFemale,rdbtnMale2,rdbtnFemale2;
	 
	private String Lid1,Name1,Phoneno1,Address1,Age1,Workid1,gender1;
	
	private JComboBox labouridcmb,workcombo1,workcombo2;
	
	private String lid2;
	 
	private PreparedStatement ps,pswid;
	private Connection con;
	private ResultSet rs,rswid;
	    
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabourManagement frame = new LabourManagement();
					frame.setUndecorated(true);
					frame.setLocation(100,100);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LabourManagement() {
		
		con=CrudOperation.createConnection();
		CreateGui();
		adddata();
		workfetch();
		
	}
	
	public void CreateGui()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,935, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//-------------------------------------------------------tabbed pane 
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		 tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 tabbedPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		 tabbedPane.setBackground(new Color(255, 255, 255));
		 tabbedPane.setFocusable(false);
		 tabbedPane.setFocusTraversalKeysEnabled(false);
		 tabbedPane.setBounds(0, 0, 935, 638);
		 contentPane.add(tabbedPane);
		 
		 //------------------------------------------------------panel 4
		 
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
		 Lid.setBounds(12, 96, 449, 19);
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
		 
		 JLabel lblLid = new JLabel("Lid");
		 lblLid.setBounds(12, 73, 449, 13);
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
		 
		 //-----------------------------------------panel 4 >labour management> radio button
		 
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
		 
		 JLabel lblDateOfLeaving = new JLabel("Date of leaving");
		 lblDateOfLeaving.setBounds(471, 435, 449, 13);
		 panel_4.add(lblDateOfLeaving);
		 
		 workcombo1 = new JComboBox();
		 workcombo1.setBounds(471, 279, 449, 21);
		 panel_4.add(workcombo1);
		 
		 //----------------------------------------------------------------------panel 6
		 
		 JPanel panel_6 = new JPanel();
		 panel_6.setBorder(null);
		 panel_6.setBackground(new Color(255, 255, 255));
		 tabbedPane.addTab("UPDATE LABOUR DETAILS", null, panel_6, null);
		 panel_6.setLayout(null);
		 
		 JButton btnUpdateLabourDetails = new JButton("Update Labour Details");
		 btnUpdateLabourDetails.setRequestFocusEnabled(false);
		 btnUpdateLabourDetails.setForeground(new Color(255, 255, 255));
		 btnUpdateLabourDetails.setBorder(null);
		 btnUpdateLabourDetails.setBackground(new Color(0, 0, 102));
		 btnUpdateLabourDetails.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 btnUpdateLabourDetails.setBounds(765, 577, 155, 21);
		 panel_6.add(btnUpdateLabourDetails);
		 btnUpdateLabourDetails.addActionListener(this);
		 
		 JLabel lblLId = new JLabel("L ID");
		 lblLId.setBounds(10, 75, 46, 13);
		 panel_6.add(lblLId);
		 
		 JLabel lblName_1 = new JLabel("Name");
		 lblName_1.setBounds(469, 75, 46, 13);
		 panel_6.add(lblName_1);
		 
		 name2 = new JTextField();
		 name2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 name2.setBounds(469, 98, 451, 19);
		 panel_6.add(name2);
		 name2.setColumns(10);
		 
		 phoneno2 = new JTextField();
		 phoneno2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 phoneno2.setBounds(10, 188, 449, 19);
		 panel_6.add(phoneno2);
		 phoneno2.setColumns(10);
		 
		 address2 = new JTextField();
		 address2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 address2.setBounds(469, 188, 451, 19);
		 panel_6.add(address2);
		 address2.setColumns(10);
		 
		 age2 = new JTextField();
		 age2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		 age2.setBounds(10, 279, 449, 19);
		 panel_6.add(age2);
		 age2.setColumns(10);
		 
		 JLabel lblNewLabel_2 = new JLabel("Phone no");
		 lblNewLabel_2.setBounds(10, 165, 449, 13);
		 panel_6.add(lblNewLabel_2);
		 
		 JLabel lblNewLabel_3 = new JLabel("Age");
		 lblNewLabel_3.setBounds(10, 256, 449, 13);
		 panel_6.add(lblNewLabel_3);
		 
		 JLabel lblNewLabel_4 = new JLabel("Address");
		 lblNewLabel_4.setBounds(469, 165, 451, 13);
		 panel_6.add(lblNewLabel_4);
		 
		 JLabel lblNewLabel_5 = new JLabel("Work id");
		 lblNewLabel_5.setBounds(469, 256, 451, 13);
		 panel_6.add(lblNewLabel_5);
		 
		  dateChooser_2 = new JDateChooser();
		 dateChooser_2.setBounds(469, 375, 451, 19);
		 panel_6.add(dateChooser_2);
		 
		dateChooser_3 = new JDateChooser();
		 dateChooser_3.setBounds(469, 470, 451, 19);
		 panel_6.add(dateChooser_3);
		 
		 JLabel lblNewLabel_6 = new JLabel("date of joining");
		 lblNewLabel_6.setBounds(469, 352, 451, 13);
		 panel_6.add(lblNewLabel_6);
		 
		 JLabel lblNewLabel_7 = new JLabel("date of leaving");
		 lblNewLabel_7.setBounds(469, 447, 451, 13);
		 panel_6.add(lblNewLabel_7);
		 
		 JLabel lblNewLabel_8 = new JLabel("Gender");
		 lblNewLabel_8.setBounds(10, 352, 46, 13);
		 panel_6.add(lblNewLabel_8);
		 
		rdbtnMale2 = new JRadioButton("Male");
		 rdbtnMale2.setBounds(6, 375, 105, 21);
		 panel_6.add(rdbtnMale2);
		 
		 rdbtnFemale2 = new JRadioButton("Female");
		 rdbtnFemale2.setBounds(113, 375, 105, 21);
		 panel_6.add(rdbtnFemale2);
		 
		 JButton btnSearchLabourDetails = new JButton("Search Labour Details");
		 btnSearchLabourDetails.setRequestFocusEnabled(false);
		 btnSearchLabourDetails.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 btnSearchLabourDetails.setForeground(new Color(255, 255, 255));
		 btnSearchLabourDetails.setBorder(null);
		 btnSearchLabourDetails.setBackground(new Color(0, 0, 102));
		 btnSearchLabourDetails.setBounds(600, 578, 155, 21);
		 panel_6.add(btnSearchLabourDetails);
		 btnSearchLabourDetails.addActionListener(this);
		 
		 JLabel label = new JLabel("Enter Labour id to fetch data and edit it");
		 label.setBounds(10, 10, 449, 13);
		 panel_6.add(label);
		 
		 labouridcmb = new JComboBox();
		 labouridcmb.setBounds(10, 96, 449, 21);
		 panel_6.add(labouridcmb);
		 
		 workcombo2 = new JComboBox();
		 workcombo2.setBounds(469, 277, 451, 21);
		 panel_6.add(workcombo2);
		 
	

		 //_------------------------------------------- panel 5
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
		 lblLabourIdTo.setBounds(10, 83, 147, 13);
		 panel_5.add(lblLabourIdTo);
	}


	public void adddata()
	{
	labouridcmb.removeAllItems();
	try {
		ps=con.prepareStatement("select Lid from labourdetails");
		rs=ps.executeQuery();
		while(rs.next())
		{
			labouridcmb.addItem(rs.getString(1));
		}
		
	}catch(SQLException se)
	{
		System.out.println(se);
	}
	}
	
	public void workfetch()
	{
		try {
			pswid=con.prepareStatement("select workid from workmgmt");
			rswid=pswid.executeQuery();
			while(rswid.next())
			{
				workcombo1.addItem(rswid.getString(1));
				workcombo2.addItem(rswid.getString(1));
				
			}
		}catch(SQLException se)
		{
			System.out.println(se);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String caption = e.getActionCommand();
		
		//--------------------------------------------------------------add labour details
		if(caption.equals("Add Labour Details"))
		{
			
			
			try {
				
				Lid1 = Lid.getText();
				 Name1 = Name.getText(); 
				 Phoneno1 = Phoneno.getText();
				 Address1= Address.getText();
				 Age1 = Age.getText(); 
				 Workid1=workcombo1.getSelectedItem().toString(); 
				  
				  gender1=null; if (rdbtnMale.isSelected()==true) {
				  gender1=rdbtnMale.getText(); } if(rdbtnFemale.isSelected()==true) {
				  gender1=rdbtnFemale.getText(); }
				  
				  java.util.Date d = dateChooser.getDate(); long date=d.getTime();
				  java.sql.Date sd = new java.sql.Date(date);
				  JOptionPane.showMessageDialog(this,sd.toString());
				  
				  java.util.Date d_1 = dateChooser_1.getDate(); long date_1=d_1.getTime();
				  java.sql.Date ed = new java.sql.Date(date_1);
				  JOptionPane.showMessageDialog(this,ed.toString());
				
				String strinsert = "insert into labourdetails values(?,?,?,?,?,?,?,?,?,?,?,?)";
				ps=con.prepareStatement(strinsert);
				ps.setString(1,Lid1);
				ps.setString(2,Name1);
				ps.setString(3,Phoneno1);
				ps.setString(4,Address1);
				ps.setString(5,gender1 );
				ps.setString(6,Age1);
				ps.setString(7, Workid1);
				ps.setDate(8, sd);
				ps.setDate(9, ed);
				ps.setString(10, "-");
				ps.setInt(11, 0);
				ps.setString(12, "-");
				int row = ps.executeUpdate();
					if(row>0)
					{
					JOptionPane.showMessageDialog(this,"done");
					
					Lid.setText("");Name.setText("");Phoneno.setText("");Address.setText("");Age.setText("");
					
					rdbtnFemale.setSelected(false);
					rdbtnMale.setSelected(false);
					
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
		
		//---------------------------------------------------------labour search
		if(caption.equals("Search Labour Details"))
		{
			lid2= labouridcmb.getSelectedItem().toString();
			
			
			try {
				ps=con.prepareStatement("select * from labourdetails where Lid ="+lid2);
				rs = ps.executeQuery();
				
				 if (rs.next()==true)
				{
			    name2.setText(rs.getString(2));
			    phoneno2.setText(rs.getString(3));
			    address2.setText(rs.getString(4));
			    age2.setText(rs.getString(6));
			    workcombo2.setSelectedItem(rs.getString(7));
			    dateChooser_2.setDate(rs.getDate(8));
			    dateChooser_3.setDate(rs.getDate(9));
			    gender1= rs.getString(5);
			    if(gender1.equals("male"))
			    {
				  rdbtnMale2.setSelected(true); 
			    }
			    else
			    {
				   rdbtnFemale2.setSelected(true);
			    }
			   
				}
				 else {
					 JOptionPane.showMessageDialog(this, "no one found","Searching",JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(Exception se) 
			{
				System.out.println(se);
			}
	}
		//---------------------------------------------------------labour update
		
		if(caption.equals("Update Labour Details"))
		{   
			
			
				JOptionPane.showMessageDialog(this, "1");
				 Name1 = name2.getText(); Phoneno1 = phoneno2.getText(); Address1
				  = address2.getText(); Age1 = age2.getText(); Workid1 =
				  workcombo2.getSelectedItem().toString();
				  
				  gender1=null; if (rdbtnMale2.isSelected()==true) {
				  gender1=rdbtnMale.getText(); } if(rdbtnFemale2.isSelected()==true) {
				  gender1=rdbtnFemale.getText(); }
				  
				  java.util.Date d_2 = dateChooser_2.getDate(); long date_2=d_2.getTime();
				  java.sql.Date sd1 = new java.sql.Date(date_2);
				  
				  java.util.Date d_3 = dateChooser_3.getDate(); long date_3=d_3.getTime();
				  java.sql.Date ed1 = new java.sql.Date(date_3);
				  
				  String strupdate ="update labourdetails SET Name='"+Name1+"',Phoneno='"+Phoneno1+"',Address='"+Address1+"',Gender='"+gender1+"',Age='"+Age1+"',Workid='"+Workid1+"',DateOfJoining='"+sd1+"',DateOfLeaving='"+ed1+"' where Lid ="+lid2;
				  
				  try {
						ps=con.prepareStatement(strupdate);
						
						int row = ps.executeUpdate();
				        	if(row>0)
				        	{
				        		JOptionPane.showMessageDialog(this, "updated");
				        	}
				        	else 
				        	{
				        		JOptionPane.showMessageDialog(this, "error");
				        	}
					}
	      			catch(SQLException se) 
					{
						System.out.println(se);
					}
			}
		}
}
