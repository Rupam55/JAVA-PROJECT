package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.dbutils.CrudOperation;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;

public class ReportManagement extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane; 
	private JTable table;
	private JTable table1;

	private String []Columns = {"LabourID", "Labour Name" , "Phone No." ,"Address" ,"Gender" ,"Age","WorkID","DateOfJoining","DateOfLeaving","Status"};
	private String []Columns1 = {"ClientID", "Client Name" , "Email" , "Phone No." , "Address"};
	
	private String[][]tabledata=null;
	private Connection con;
	private PreparedStatement pscount, psdata, psdata1;
	private ResultSet rscount,rsdata,rsdata1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportManagement frame = new ReportManagement();
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
	public ReportManagement() {
		con = CrudOperation.createConnection();
		creategui();
		panel1();
		panel2();
	}
	
	public void fillTwoD()
	{
		try {
			String stcount = "select count(*) from labourdetails";
			pscount=con.prepareStatement(stcount);
			rscount=pscount.executeQuery();
			
			rscount.next();
			int rowcnt=rscount.getInt(1);
			if(rowcnt>0)
			{
				tabledata=new String[rowcnt][12];
				psdata=con.prepareStatement("select * from labourdetails");
				rsdata=psdata.executeQuery();
				int i=0;
				while(rsdata.next())
				{
					
					String lid=rsdata.getString("lid");
					String name=rsdata.getString("name");
					String phoneno=rsdata.getString("phoneno");
					String address=rsdata.getString("address");
					String gender=rsdata.getString("gender");
					String age=rsdata.getString("age");
					String workid=rsdata.getString("workid");
					String dateofjoining=rsdata.getString("dateofjoining");
					String dateofleaving=rsdata.getString("dateofleaving");
					String status=rsdata.getString("status");
					String noofdays=rsdata.getString("noofdays");
					String requestid=rsdata.getString("CurrentRequestId");
					
					tabledata[i][0] = lid;
					tabledata[i][1] = name;
					tabledata[i][2] = phoneno;
					tabledata[i][3] = address;
					tabledata[i][4] = gender;
					tabledata[i][5] = age;
					tabledata[i][6] = workid;
					tabledata[i][7] = dateofjoining;
					tabledata[i][8] = dateofleaving;
					tabledata[i][9] = status;
					tabledata[i][10]= noofdays;
					tabledata[i][11]= requestid;
					i++;
				}
			}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}finally {
			try {
				psdata.close();
				rsdata.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void fillTwoC()
	{
		try {
			String stcount = "select count(*) from clientdetails";
			pscount=con.prepareStatement(stcount);
			rscount=pscount.executeQuery();
			
			rscount.next();
			int rowcnt=rscount.getInt(1);
			if(rowcnt>0)
			{
				tabledata=new String[rowcnt][5];
				psdata1=con.prepareStatement("select * from clientdetails");
				rsdata1=psdata1.executeQuery();
				int i=0;
				while(rsdata1.next())
				{
					
					String cid=rsdata1.getString("cid");
					String name=rsdata1.getString("name");
					String email=rsdata1.getString("email");
					String phoneno=rsdata1.getString("phoneno");
					String address=rsdata1.getString("address");
					
					tabledata[i][0] = cid;
					tabledata[i][1] = name;
					tabledata[i][2] = email;
					tabledata[i][3] = phoneno;
					tabledata[i][4] = address;
					i++;
				}
			}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		
	}

	public void creategui()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//--------------------------------------------------------tabbed pane
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 921, 601);
		contentPane.add(tabbedPane);
	}
	public void panel1()
	{
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("View details of all the clients", null, panel, null);
		panel.setLayout(null);
		
		fillTwoD();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 916, 574);
		panel.add(scrollPane);
		
		table = new JTable();
		JTableHeader header = table.getTableHeader();
		table.setModel(new DefaultTableModel(tabledata,Columns));
		table.getColumnModel().getColumn(0).setPreferredWidth(74);
		scrollPane.setViewportView(table);
		header.setBackground(Color.DARK_GRAY);
		header.setForeground(Color.WHITE);
		header.setFont(new Font("Calibri",Font.BOLD|Font.ITALIC, 20));
		
	}
	public void panel2()
	{
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("View details of all the labours", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(0, 0, 800, 600);
		panel_1.add(scrollPane1);
		
		table1 = new JTable();
		JTableHeader header = table1.getTableHeader();
		table1.setModel(new DefaultTableModel(tabledata,Columns1));
		table1.getColumnModel().getColumn(0).setPreferredWidth(74);
		scrollPane1.setViewportView(table1);
		
		fillTwoC();
		header.setBackground(Color.DARK_GRAY);
		header.setForeground(Color.WHITE);
		header.setFont(new Font("Calibri",Font.BOLD|Font.ITALIC, 20));
	}
}
