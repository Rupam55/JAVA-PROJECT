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



public class UpdateClient extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtcid;
	private JTextField txtcname;
	private JTextField txtcemail;
	private JTextField txtcphone;
	private JTextField txtcaddress;
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
					UpdateClient frame = new UpdateClient();
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
	public UpdateClient() {
		con= (Connection) CrudOperation.createConnection();
		createGui();
		
		
		
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 584);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(221, 115, 448, 387);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Constantia", Font.BOLD, 14));
		lblName.setBounds(69, 90, 71, 22);
		panel.add(lblName);
		
		JLabel lblClientId = new JLabel("Client Id :");
		lblClientId.setFont(new Font("Constantia", Font.BOLD, 14));
		lblClientId.setBounds(69, 44, 71, 22);
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
		
		txtcid = new JTextField();
		txtcid.setBackground(new Color(255, 255, 255));
		txtcid.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		txtcid.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		txtcid.setBounds(161, 42, 211, 21);
		panel.add(txtcid);
		txtcid.setColumns(10);
		
		txtcname = new JTextField();
		txtcname.setBackground(new Color(255, 255, 255));
		txtcname.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		txtcname.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		txtcname.setBounds(161, 89, 211, 21);
		panel.add(txtcname);
		txtcname.setColumns(10);
		
		txtcemail = new JTextField();
		txtcemail.setBackground(new Color(255, 255, 255));
		txtcemail.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		txtcemail.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		txtcemail.setBounds(161, 136, 211, 21);
		panel.add(txtcemail);
		txtcemail.setColumns(10);
		
		txtcphone = new JTextField();
		txtcphone.setBackground(new Color(255, 255, 255));
		txtcphone.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		txtcphone.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		txtcphone.setBounds(161, 188, 211, 21);
		panel.add(txtcphone);
		txtcphone.setColumns(10);
		
		txtcaddress = new JTextField();
		txtcaddress.setBackground(new Color(255, 255, 255));
		txtcaddress.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		txtcaddress.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		txtcaddress.setBounds(161, 232, 211, 21);
		panel.add(txtcaddress);
		txtcaddress.setColumns(10);
		
		JButton btnupdate = new JButton("UPDATE");
		
		btnupdate.setForeground(new Color(255, 255, 255));
		btnupdate.setBackground(new Color(102, 51, 0));
		btnupdate.setFont(new Font("Calisto MT", Font.BOLD, 13));
		btnupdate.addActionListener(this);
		btnupdate.setBounds(272, 286, 107, 31);
		panel.add(btnupdate);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(new Color(51, 51, 0));
		panel_1.setBounds(221, 24, 448, 85);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAddClientDetails = new JLabel("Update Client Details");
		lblAddClientDetails.setForeground(new Color(255, 255, 255));
		lblAddClientDetails.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblAddClientDetails.setBounds(66, 11, 372, 61);
		panel_1.add(lblAddClientDetails);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) 
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
				   String cname=rs.getString("Name");
				   String caddress=rs.getString("Address");
				   String cemail=rs.getString("Email");
				   String cphoneno=rs.getString("Phoneno");
				   
				   String ctname=txtcname.getText() ;
				   String ctemail=txtcemail.getText();
				   String ctaddress=txtcaddress.getText();
				   String ctphoneno=txtcphone.getText();
				   
				if(!ctname.isEmpty())
					cname=ctname;
				if(!ctaddress.isEmpty())
					caddress=ctaddress;
				if(!ctemail.isEmpty())
				    cemail=ctemail;
				if(!ctphoneno.isEmpty())
					cphoneno=ctphoneno;
				
				String strupdate="UPDATE clientdetails SET Name=?,Email=?,Phoneno=?,Address=? WHERE Cid=?"	;
				    ps=con.prepareStatement(strupdate);
				    ps.setString(1,cname);
				    ps.setString(2, cemail);
				    ps.setString(3,cphoneno);
				    ps.setString(4, caddress);
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
