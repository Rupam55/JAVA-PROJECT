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

public class ViewClientDetails extends JFrame {

	private JPanel contentPane;
	private JTable table1;
	private String []Columns = {"ClientID", "Client Name" , "Email" , "Phone No." , "Address"};
	
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
					ViewClientDetails frame = new ViewClientDetails();
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
			String stcount = "select count(*) from clientdetails";
			pscount=con.prepareStatement(stcount);
			rscount=pscount.executeQuery();
			
			rscount.next();
			int rowcnt=rscount.getInt(1);
			if(rowcnt>0)
			{
				tabledata=new String[rowcnt][5];
				String strsql="select * from clientdetails";
				psdata=con.prepareStatement(strsql);
				rsdata=psdata.executeQuery();
				int i=0;
				while(rsdata.next())
				{
					
					String cid=rsdata.getString("cid");
					String name=rsdata.getString("name");
					String email=rsdata.getString("email");
					String phoneno=rsdata.getString("phoneno");
					String address=rsdata.getString("address");
					
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

	/**
	 * Create the frame.
	 */
	public ViewClientDetails() {
		setResizable(false);
		con = CrudOperation.createConnection();
		CreateGui();
		
	}
	
	public void CreateGui() {
		fillTwoD();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 674);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(91, 27, 800, 600);
		contentPane.add(scrollPane1);
		
		table1 = new JTable();
		JTableHeader header = table1.getTableHeader();
		header.setBackground(Color.DARK_GRAY);
		header.setForeground(Color.WHITE);
		header.setFont(new Font("Calibri",Font.BOLD|Font.ITALIC, 20));
		table1.setModel(new DefaultTableModel(tabledata,Columns));
		table1.getColumnModel().getColumn(0).setPreferredWidth(74);
		scrollPane1.setViewportView(table1);
	}
}
