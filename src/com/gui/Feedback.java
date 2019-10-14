package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.dbutils.CrudOperation;
import com.toedter.calendar.JDateChooser;

import java.sql.*;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class Feedback extends JFrame implements ActionListener{

	private JPanel contentPane;
	
	private Connection con;
	private PreparedStatement ps,pscid,pslid,pstxt;
	private ResultSet rs,rscid,rslid,rstxt;
	
	private JComboBox clid, lbrid;
	private JTextArea textArea;
	private JOptionPane dialog;
	private JDateChooser dateChooser;
	private JTextField feedid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feedback frame = new Feedback();
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
	public Feedback() {
		con = CrudOperation.createConnection();
		CreateGui();
		datafetch();
		client_load();
	}
		
/*--------------------------------------------------------------Fetch Data------------------------------------------------------------------------------------*/
	
	public void datafetch()
	{
		String lbid = "select lid from labourdetails";
		String ctid = "select cid from clientdetails";
		
		try {
			pscid = con.prepareStatement(ctid);		/*- - - - - -ClientID- - - - - - - - */
			rscid = pscid.executeQuery();
			pslid = con.prepareStatement(lbid);		/*- - - - - -LabourID- - - - - - - - */
			rslid = pslid.executeQuery();
			while(rscid.next())						/*- - - - - -Client Additems- - - - - - - - */
			{
				String cid = rscid.getString("cid");
				clid.addItem(cid);
			}
			while(rslid.next())						/*- - - - - -Labour Additems- - - - - - - - */
			{
				String lid = rslid.getString("lid");
				lbrid.addItem(lid);
			}
		}
		catch (SQLException se) 
		{
			System.out.println(se);
		}
		
	}
	
	public void client_load()
	{
		/*- - - - - -Feedback fetch on basis of LabourID- - - - - - - - */
		String clidload = clid.getSelectedItem().toString();
		String lbridload = lbrid.getSelectedItem().toString();
		String strsql = "select fid,text,date from feedbackinfo where cid='"+clidload+"' and lid='"+lbridload+"'";
		try {
		pstxt = con.prepareStatement(strsql);
		rstxt = pstxt.executeQuery();
		if(rstxt.next())
			{
			String load = rstxt.getString("text");
			String feedload = rstxt.getString("fid");
//			
			textArea.setText(load);
			feedid.setText(feedload);
//			dateChooser.setDate(Date date);
			}
		else
			{
			textArea.setText(null);
			feedid.setText("-");
			}
		}
		catch(SQLException se)
		{System.out.println(se);}
	}
/*--------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	public void client_addupdate()
	{
		String clidload = clid.getSelectedItem().toString();
		String lbridload = lbrid.getSelectedItem().toString();
		//get date.
		
		java.util.Date d = dateChooser.getDate();
		long date = d.getTime();
		java.sql.Date sd = new java.sql.Date(date);

		//----
		String fidget = feedid.getText();
		String textget = textArea.getText();
		
		String str_rec = "select * from feedbackinfo where cid='"+clidload+"'and lid='"+lbridload+"'";
		try {
		ps = con.prepareStatement(str_rec);
		rs = ps.executeQuery();
		if(!rs.next()) //check whether a row exists or not.
			{
			String n_str = "insert into feedbackinfo values('"+fidget+"','"+clidload+"','"+lbridload+"','"+textget+"','"+sd+"')";
			ps = con.prepareStatement(n_str);			
			int rownew = ps.executeUpdate();
			if(rownew>0)
			JOptionPane.showMessageDialog(dialog, "Feedback Submitted");
			}
		else
			{
			String up_str = "update feedbackinfo set text='"+textget+"',date='"+sd+"' where fid='"+fidget+"'";
			ps = con.prepareStatement(up_str);
			int row = ps.executeUpdate();
			JOptionPane.showMessageDialog(dialog, "Feedback Updated Successfully");
			}
		}
		catch(SQLException se)
		{System.out.println(se);}
	}

/*--------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	public void CreateGui()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 638);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFeedback = new JLabel("Feedback");
		lblFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedback.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 35));
		lblFeedback.setBounds(10, 10, 901, 47);
		contentPane.add(lblFeedback);
		
		JLabel lblClientId = new JLabel("Client ID");
		lblClientId.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		lblClientId.setBounds(314, 84, 110, 40);
		contentPane.add(lblClientId);
		
		JLabel label = new JLabel("Labour ID");
		label.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		label.setBounds(314, 134, 110, 40);
		contentPane.add(label);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		lblDate.setBounds(10, 551, 56, 40);
		contentPane.add(lblDate);
		
		JLabel lblNewLabel = new JLabel("*maximum 300 words");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 474, 157, 19);
		contentPane.add(lblNewLabel);
		
		JLabel FeedbackID = new JLabel("Feedback ID");
		FeedbackID.setHorizontalAlignment(SwingConstants.CENTER);
		FeedbackID.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		FeedbackID.setBounds(10, 84, 180, 40);
		contentPane.add(FeedbackID);
		
/*--------------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*- - - - - - ClientID- - - - - - - - */
		clid = new JComboBox();
		clid.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
		clid.setBounds(434, 90, 170, 31);
		contentPane.add(clid);
		
		
		/*- - - - - - LabourID- - - - - - - - */
		lbrid = new JComboBox();
		lbrid.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
		lbrid.setBounds(434, 140, 170, 31);
		contentPane.add(lbrid);
	
		/*- - - - - - Date- - - - - - - - */
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(76, 560, 170, 31);
		contentPane.add(dateChooser);
		
/*-------------------- Button ------------------------------------------------------------------------------------------------------------------------------*/
		
		JButton btnFetchFeedback = new JButton("Get Feedback");
		btnFetchFeedback.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		btnFetchFeedback.setBounds(722, 157, 189, 40);
		contentPane.add(btnFetchFeedback);
		btnFetchFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client_load();				
			}
		});
		
		
		JButton button = new JButton("Submit");
		button.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		button.setBounds(787, 551, 124, 40);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(feedid.getText()== "-")
					JOptionPane.showMessageDialog(dialog, "Enter Feedback ID and Date");
				else if (dateChooser.getDate()==null)
					JOptionPane.showMessageDialog(dialog, "Enter Feedback ID and Date");
				else
					client_addupdate();
			}
		});
		
/*----------------------TextArea---------------------------------------------------------------------------------------------------------------------------*/
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setRows(10);
		textArea.setBounds(10, 207, 901, 257);
		contentPane.add(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
	
		
		feedid = new JTextField();
		feedid.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		feedid.setBounds(10, 138, 180, 31);
		contentPane.add(feedid);
		feedid.setColumns(10);
		
/*--------------------------------------------------------------------------------------------------------------------------------------------------*/
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
}
