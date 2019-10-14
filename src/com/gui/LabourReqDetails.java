package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;

import com.dbutils.CrudOperation;
import com.sun.security.auth.NTNumericCredential;

import javax.swing.border.BevelBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.MatteBorder;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;

public class LabourReqDetails extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Connection con;
	private PreparedStatement ps,pswid,pscid,psrid,psr,pscheck,psclose,ps1;
	private ResultSet rs,rswid,rscid,rsrid,rsr,rsclose;
	
	private JTabbedPane tabbedPane;
	private JTextField days1;
	
	private JDateChooser dateChooser,dateChooser_1,dateChooser_2;
	
	private String cid,wid,noofworkers,lidmin,noofdays1,noofdays2,noofdays3;
	
	private JComboBox workcombo1,cidcombo,requestidcombo,workcombo2;
	
	private java.sql.Date dbSqlDate;
	private JDateChooser currentdate;  
	
	int countlid,i,no;
	private JTextField noofdays;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabourReqDetails frame = new LabourReqDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public LabourReqDetails() {
		con=CrudOperation.createConnection();
		createGui();
		createpanel();
		createpanel_1();
		createpanel_2();
		combofetch();
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,935, 638 );
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 921, 601);
		contentPane.add(tabbedPane);
		
	}
	
	public void createpanel()
	{
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("add labour request", null, panel, null);
		panel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("labour request pane\r\n");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel.setBounds(10, 10, 273, 30);
			panel.add(lblNewLabel);
		}
		
		JLabel lblNewLabel_1 = new JLabel("C ID");
		lblNewLabel_1.setBounds(10, 78, 257, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("work select\r\n");
		lblNewLabel_2.setBounds(10, 130, 257, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("no of workers required");
		lblNewLabel_3.setBounds(10, 182, 257, 13);
		panel.add(lblNewLabel_3);
		
		days1 = new JTextField();
		days1.setBounds(277, 179, 629, 19);
		panel.add(days1);
		days1.setColumns(10);
		
		workcombo1 = new JComboBox();
		workcombo1.setBounds(277, 126, 629, 21);
		panel.add(workcombo1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(277, 245, 629, 19);
		panel.add(dateChooser);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(277, 307, 629, 19);
		panel.add(dateChooser_1);
		
		dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(277, 371, 629, 19);
		panel.add(dateChooser_2);
		
		JLabel lblNewLabel_4 = new JLabel("from date");
		lblNewLabel_4.setBounds(10, 251, 257, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("To date");
		lblNewLabel_5.setBounds(10, 313, 257, 13);
		panel.add(lblNewLabel_5);
		
		JLabel lblRequestDate = new JLabel("Request date ");
		lblRequestDate.setBounds(10, 371, 257, 13);
		panel.add(lblRequestDate);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(791, 534, 115, 30);
		panel.add(btnSubmit);
		btnSubmit.addActionListener(this);
		
		cidcombo = new JComboBox();
		cidcombo.setBounds(275, 74, 631, 21);
		panel.add(cidcombo);
		
		JLabel lblNoOfDays = new JLabel("no of days to work");
		lblNoOfDays.setBounds(10, 449, 85, 13);
		panel.add(lblNoOfDays);
		
		noofdays = new JTextField();
		noofdays.setBounds(277, 446, 96, 19);
		panel.add(noofdays);
		noofdays.setColumns(10);
	}
	public void createpanel_1()
	{
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("palce labour request", null, panel_1, null);
		panel_1.setLayout(null);
		
		requestidcombo = new JComboBox();
		requestidcombo.setBounds(10, 116, 416, 21);
		panel_1.add(requestidcombo);
		
		JLabel lblSelectTheRequest = new JLabel("select the request id");
		lblSelectTheRequest.setBounds(10, 93, 272, 13);
		panel_1.add(lblSelectTheRequest);
		
		JButton btnPlaceLabourRequest = new JButton("place labour request");
		btnPlaceLabourRequest.setBounds(749, 536, 157, 28);
		panel_1.add(btnPlaceLabourRequest);
		
		workcombo2 = new JComboBox();
		workcombo2.setBounds(10, 170, 416, 21);
		panel_1.add(workcombo2);
		
		JLabel lblNewLabel_6 = new JLabel("select the work id ");
		lblNewLabel_6.setBounds(10, 147, 116, 13);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Place labour request");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(10, 25, 207, 35);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("caution select correct work id for no grevence ");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setBounds(10, 201, 416, 13);
		panel_1.add(lblNewLabel_8);
		btnPlaceLabourRequest.addActionListener(this);
	}
	public void createpanel_2()
	{
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("update labours", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblLabourDisangagementSystem = new JLabel("labour disengagement system");
		lblLabourDisangagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLabourDisangagementSystem.setBounds(10, 10, 360, 28);
		panel_2.add(lblLabourDisangagementSystem);
		
		currentdate = new JDateChooser();
		currentdate.setBounds(10, 111, 360, 19);
		panel_2.add(currentdate);
		
		JLabel lblSelectTodaysDate = new JLabel("select todays date");
		lblSelectTodaysDate.setBounds(10, 88, 360, 13);
		panel_2.add(lblSelectTodaysDate);
		
		JButton btnDisengage = new JButton("disengage");
		btnDisengage.setBounds(804, 536, 102, 28);
		panel_2.add(btnDisengage);
		btnDisengage.addActionListener(this);
		
	}
	
	public void combofetch()
	{
		try {
			pswid=con.prepareStatement("select workid from workmgmt");
			pscid=con.prepareStatement("select cid from clientdetails");
			psrid=con.prepareStatement("select requestid from labourrequest");
			rswid=pswid.executeQuery();
			rscid=pscid.executeQuery();
			rsrid=psrid.executeQuery();
			while(rswid.next())
			{
				workcombo1.addItem(rswid.getString(1));
				workcombo2.addItem(rswid.getString(1));
			}
			while(rscid.next())
			{
				cidcombo.addItem(rscid.getString(1));
			}
			while(rsrid.next())
			{
				requestidcombo.addItem(rsrid.getString(1));
			}
		}catch(SQLException se)
		{
			System.out.println(se);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String caption = e.getActionCommand();
		
		//-----------------------------------------------submit request
		if(caption.equals("Submit"))
		{
			cid=cidcombo.getSelectedItem().toString();
			noofworkers=days1.getText();
			wid=workcombo1.getSelectedItem().toString();
			noofdays1=noofdays.getText();
			
			java.util.Date d = dateChooser.getDate(); long date=d.getTime();
			  java.sql.Date sd = new java.sql.Date(date);
			  
			  java.util.Date d1 = dateChooser_1.getDate(); long date1=d1.getTime();
			  java.sql.Date ed = new java.sql.Date(date1);
			  
			  java.util.Date d2 = dateChooser_2.getDate(); long date2=d2.getTime();
			  java.sql.Date cd = new java.sql.Date(date2);
			
			try {
				ps=con.prepareStatement("insert into labourrequest values(?,?,?,?,?,?,?,?,?)");
				ps.setString(1, cid+wid);
				ps.setString(2,cid);
				ps.setString(3,wid );
				ps.setString(4,noofworkers);
				ps.setDate(5, sd);
				ps.setDate(6,ed);
				ps.setDate(7, cd);
				ps.setString(8,"not processed");
				ps.setString(9, noofdays1);
				int row = ps.executeUpdate();
				if(row>0)
				{
					JOptionPane.showMessageDialog(this, "your request id is"+cid+wid+"\nyour request will be processed");
				}
			}catch(SQLException se)
			{
				System.out.println(se);
			}
			finally
			{
				try {
					ps.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		//---------------------------------------------------------request labour
		if(caption.equals("place labour request"))
		{
			String sta= "-";
			String statsu="online";
			String rid=requestidcombo.getSelectedItem().toString();
			wid=workcombo2.getSelectedItem().toString(); 
			try {
				ps=con.prepareStatement("select * from labourrequest where requestid =?");
				ps.setString(1, rid);
				rs=ps.executeQuery();
				if(rs.next()==true)
				{
					noofworkers=rs.getString(4);
					noofdays1=rs.getString(9);
					dbSqlDate = rs.getDate(6);
				}
				psr=con.prepareStatement("select count(lid) from labourdetails where workid='"+wid+"' and status='"+sta+"'");
				 rsr = psr.executeQuery();
				 while(rsr.next())
				 	{
					countlid = rsr.getInt("Count(lid)");
					}
				 if(countlid>Integer.parseInt(noofworkers))
				 {
					JOptionPane.showMessageDialog(this,"worker available for request are"+countlid);
					i=0;
					while(i<Integer.parseInt(noofworkers))
					{  
					   psclose=con.prepareStatement("SELECT Lid, noofdays FROM labourdetails WHERE Lid = (SELECT MIN(Lid) FROM labourdetails WHERE status='"+sta+"' and workid='"+wid+"');");
					   rsclose=psclose.executeQuery();
					   if(rsclose.next()==true)
					   {
						    lidmin=rsclose.getString("Lid");
						    noofdays2=rsclose.getString("noofdays");
					   }
					   no=Integer.parseInt(noofdays1)+Integer.parseInt(noofdays2);
					   noofdays3=Integer.toString(no);
						pscheck=con.prepareStatement("update labourdetails SET CurrentRequestId='"+rid+"',status='"+statsu+"',noofdays='"+noofdays3+"',DateOfLeaving='"+dbSqlDate+"' where workid='"+wid+"'and status='"+sta+"' and lid='"+lidmin+"'");
					    pscheck.executeUpdate();
					    i++;
					}
					JOptionPane.showMessageDialog(this, "done");
				 }
			}catch(SQLException se)
			{
				System.out.println(se);
			}finally {
				try {
					ps.close();
					psr.close();
					psclose.close();
					rs.close();
					rsr.close();
					rsclose.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		//--------------------------------------------------------------------------------disengage labour
		if(caption.equals("disengage"))
		{
			String d="";
			String sta="-";
			java.util.Date d3 = currentdate.getDate(); long date3=d3.getTime();
			java.sql.Date cd1 = new java.sql.Date(date3);
			try {
				ps1=con.prepareStatement("update labourdetails SET status='"+sta+"',currentrequestid='"+d+"' where dateofleaving='"+cd1+"' ");
				int row = ps1.executeUpdate();
				if(row>0)
				{
					JOptionPane.showMessageDialog(this, "done for today");
				}
				else
				{
					JOptionPane.showMessageDialog(this," can't be done today");
				}
				 
			}catch(SQLException se)
			{
				System.out.println(se);
			}finally {
				try {
					ps1.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}

