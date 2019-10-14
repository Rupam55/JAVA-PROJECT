package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.dbutils.CrudOperation;

import java.sql.*;

public class ViewLabourDetails extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String []Columns = {"LabourID", "Labour Name" , "Phone No." ,"Address" ,"Gender" ,"Age","WorkID","DateOfJoining","DateOfLeaving","Status"};
	
	private String[][]tabledata=null;
	private Connection con;
	private PreparedStatement pscount, psdata;
	private ResultSet rscount,rsdata;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLabourDetails frame = new ViewLabourDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
				tabledata=new String[rowcnt][10];
				String strsql="select * from labourdetails";
				psdata=con.prepareStatement(strsql);
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
					i++;
				}
			}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		
	}

	/**
	 * Create the frame.
	 */
	public ViewLabourDetails() {
		setResizable(false);
		con = CrudOperation.createConnection();
		CreateGui();
		
	}
	
	public void CreateGui() {
		fillTwoD();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 935, 638);
		contentPane.add(scrollPane);
		
		table = new JTable();
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.DARK_GRAY);
		header.setForeground(Color.WHITE);
		header.setFont(new Font("Calibri",Font.BOLD|Font.ITALIC, 20));
		table.setModel(new DefaultTableModel(tabledata,Columns));
		table.getColumnModel().getColumn(0).setPreferredWidth(74);
		scrollPane.setViewportView(table);
	}
}
