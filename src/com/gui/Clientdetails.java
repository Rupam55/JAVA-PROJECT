package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.dbutils.CrudOperation;
import com.mysql.jdbc.Connection;
import javax.swing.JTabbedPane;

import java.sql.*;

public class Clientdetails extends JFrame implements ActionListener {


	private JPanel contentPane;
	private JTextField txtcname,txtcid,txtcemail,txtcphone,txtcaddress,txtcname1,txtcid1,txtcemail1,txtcphone1,txtcaddress1;
	private PreparedStatement p,ps;
	private Connection con;
	private ResultSet rs;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientdetails frame = new Clientdetails();
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
	public Clientdetails() {
		con= (Connection) CrudOperation.createConnection();
		Creategui();
		
	}
	public void Creategui()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 916, 596);
		contentPane.add(tabbedPane);
		
		
		//----------------------------------------------------------------------------
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Constantia", Font.BOLD, 14));
		lblName.setBounds(69, 47, 71, 22);
		panel.add(lblName);
		
		JLabel lblClientId = new JLabel("Client Id :");
		lblClientId.setFont(new Font("Constantia", Font.BOLD, 14));
		lblClientId.setBounds(69, 92, 71, 22);
		panel.add(lblClientId);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Constantia", Font.BOLD, 14));
		lblEmail.setBounds(69, 139, 71, 22);
		panel.add(lblEmail);
		
		JLabel lblPhoneNo = new JLabel("Phone No :");
		lblPhoneNo.setFont(new Font("Constantia", Font.BOLD, 14));
		lblPhoneNo.setBounds(69, 190, 82, 22);
		panel.add(lblPhoneNo);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Constantia", Font.BOLD, 14));
		lblAddress.setBounds(69, 236, 71, 22);
		panel.add(lblAddress);
		
		txtcname = new JTextField();
		txtcname.setBackground(new Color(255, 255, 255));
		txtcname.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		txtcname.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		txtcname.setBounds(168, 49, 211, 21);
		panel.add(txtcname);
		txtcname.setColumns(10);
		
		txtcid = new JTextField();
		txtcid.setBackground(new Color(255, 255, 255));
		txtcid.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		txtcid.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		txtcid.setBounds(168, 94, 211, 21);
		panel.add(txtcid);
		txtcid.setColumns(10);
		
		txtcemail = new JTextField();
		txtcemail.setBackground(new Color(255, 255, 255));
		txtcemail.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		txtcemail.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		txtcemail.setBounds(168, 141, 211, 21);
		panel.add(txtcemail);
		txtcemail.setColumns(10);
		
		txtcphone = new JTextField();
		txtcphone.setBackground(new Color(255, 255, 255));
		txtcphone.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		txtcphone.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		txtcphone.setBounds(168, 192, 211, 21);
		panel.add(txtcphone);
		txtcphone.setColumns(10);
		
		txtcaddress = new JTextField();
		txtcaddress.setBackground(new Color(255, 255, 255));
		txtcaddress.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		txtcaddress.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		txtcaddress.setBounds(168, 237, 211, 21);
		panel.add(txtcaddress);
		txtcaddress.setColumns(10);
		
		JButton btnadd = new JButton("SUBMIT");
		btnadd.setBorder(null);
		
		btnadd.setForeground(new Color(255, 255, 255));
		btnadd.setBackground(new Color(0, 0, 102));
		btnadd.setFont(new Font("Calisto MT", Font.BOLD, 13));
		btnadd.addActionListener(this);
		btnadd.setBounds(794, 528, 107, 31);
		panel.add(btnadd);
	
	
	//------------------------------------------------------------------------------------------------  update tab
	
	JPanel panel2 = new JPanel();
	tabbedPane.addTab("update", null, panel2, null);
	panel2.setBackground(new Color(255, 255, 255));
	panel2.setBounds(221, 115,935,638 );
	panel2.setLayout(null);
	
	JLabel lblName1 = new JLabel("Name :");
	lblName1.setFont(new Font("Constantia", Font.BOLD, 14));
	lblName1.setBounds(69, 90, 71, 22);
	panel2.add(lblName1);
	
	JLabel lblClientId1 = new JLabel("Client Id :");
	lblClientId1.setFont(new Font("Constantia", Font.BOLD, 14));
	lblClientId1.setBounds(69, 44, 71, 22);
	panel2.add(lblClientId1);
	
	JLabel lblEmail1 = new JLabel("Email :");
	lblEmail1.setFont(new Font("Constantia", Font.BOLD, 14));
	lblEmail1.setBounds(69, 139, 71, 22);
	panel2.add(lblEmail1);
	
	JLabel lblPhoneNo1 = new JLabel("Phone No :");
	lblPhoneNo1.setFont(new Font("Constantia", Font.BOLD, 14));
	lblPhoneNo1.setBounds(69, 190, 82, 22);
	panel2.add(lblPhoneNo1);
	
	JLabel lblAddress1 = new JLabel("Address :");
	lblAddress1.setFont(new Font("Constantia", Font.BOLD, 14));
	lblAddress1.setBounds(69, 236, 71, 22);
	panel2.add(lblAddress1);
	
	txtcid1 = new JTextField();
	txtcid1.setBackground(new Color(255, 255, 255));
	txtcid1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	txtcid1.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
	txtcid1.setBounds(161, 42, 211, 21);
	panel2.add(txtcid1);
	txtcid1.setColumns(10);
	
	txtcname1 = new JTextField();
	txtcname1.setBackground(new Color(255, 255, 255));
	txtcname1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	txtcname1.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
	txtcname1.setBounds(161, 89, 211, 21);
	panel2.add(txtcname1);
	txtcname1.setColumns(10);
	
	txtcemail1 = new JTextField();
	txtcemail1.setBackground(new Color(255, 255, 255));
	txtcemail1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	txtcemail1.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
	txtcemail1.setBounds(161, 136, 211, 21);
	panel2.add(txtcemail1);
	txtcemail1.setColumns(10);
	
	txtcphone1 = new JTextField();
	txtcphone1.setBackground(new Color(255, 255, 255));
	txtcphone1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	txtcphone1.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
	txtcphone1.setBounds(161, 188, 211, 21);
	panel2.add(txtcphone1);
	txtcphone1.setColumns(10);
	
	txtcaddress1 = new JTextField();
	txtcaddress1.setBackground(new Color(255, 255, 255));
	txtcaddress1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	txtcaddress1.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
	txtcaddress1.setBounds(161, 232, 211, 21);
	panel2.add(txtcaddress1);
	txtcaddress1.setColumns(10);
	
	JButton btnupdate = new JButton("UPDATE");
	
	btnupdate.setForeground(new Color(255, 255, 255));
	btnupdate.setBackground(new Color(102, 51, 0));
	btnupdate.setFont(new Font("Calisto MT", Font.BOLD, 13));
	btnupdate.addActionListener(this);
	btnupdate.setBounds(272, 286, 107, 31);
	panel2.add(btnupdate);

	}
	
	//-------------------------------------------------------------action

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String caption = e.getActionCommand();
		if(caption.equals("SUBMIT"))
		{
		String cname=txtcname.getText();
		String cid=txtcid.getText();
		String cemail=txtcemail.getText();
		String cphoneno=txtcphone.getText();
		String caddress=txtcaddress.getText();
		
		if(cname.isEmpty()||cid.isEmpty()||cemail.isEmpty()||cphoneno.isEmpty()||caddress.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Data Required");
		}
		
		else
		{
			try
			{
			p=con.prepareStatement("insert into clientDetails values(?,?,?,?,?)");
			p.setString(1,cid);
			p.setString(2, cname);
			p.setString(3,cemail);
			p.setString(4,cphoneno);
			p.setString(5,caddress);
			
			int row=p.executeUpdate();
			if(row>0)
			{
				JOptionPane.showMessageDialog(this,"Done");
				txtcname.setText("");
				txtcid.setText("");
				txtcemail.setText("");
				txtcphone.setText("");
				txtcaddress.setText("");
				
			}
			
			}
			catch(Exception se)
			{
				System.out.println(se);
			}
		}
		}
		
		//--------------------------------------------------------------update query
		
		if(caption.equals("UPDATE"))
		{
		String id=txtcid.getText();
		if(id.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Cliet ID Required");
		}
		else
		{
			try 
			{
			   String strins="SELECT * FROM clientdetails WHERE Cid=?";
			   p=con.prepareStatement(strins);
			   p.setString(1,id);
			   rs=p.executeQuery();
			   if(rs.next()==true)
			   {
				   String cname1=rs.getString("Name");
				   String caddress1=rs.getString("Address");
				   String cemail1=rs.getString("Email");
				   String cphoneno1=rs.getString("Phoneno");
				   
				   String ctname=txtcname.getText() ;
				   String ctemail=txtcemail.getText();
				   String ctaddress=txtcaddress.getText();
				   String ctphoneno=txtcphone.getText();
				   
				if(!ctname.isEmpty())
					cname1=ctname;
				if(!ctaddress.isEmpty())
					caddress1=ctaddress;
				if(!ctemail.isEmpty())
				    cemail1=ctemail;
				if(!ctphoneno.isEmpty())
					cphoneno1=ctphoneno;
				
				String strupdate="UPDATE clientdetails SET Name=?,Email=?,Phoneno=?,Address=? WHERE Cid=?"	;
				    ps=con.prepareStatement(strupdate);
				    ps.setString(1,cname1);
				    ps.setString(2, cemail1);
				    ps.setString(3,cphoneno1);
				    ps.setString(4, caddress1);
				    ps.setString(5, id);
				
				    int row=ps.executeUpdate();
				    if(row>0)
				    {
				    	JOptionPane.showMessageDialog(this, "Client Details Updated Successfully");
				    	
				    }
				    else
				    {
				    	JOptionPane.showMessageDialog(this, "Client Id Not Found");
				    	
				    }
				    
			   }
			   
			  
			   
				
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
			finally {
				try
				{
					if(rs!=null)rs.close();
					
					if(ps!=null)ps.close();
					if(p!=null)p.close();
				}
				catch(Exception exe)
				{
					System.out.println(exe);
				}
			}
		}
		}
	}
}
