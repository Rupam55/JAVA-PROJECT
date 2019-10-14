package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;
import com.mysql.jdbc.Connection;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class AddClient extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtcname;
	private JTextField txtcid;
	private JTextField txtcemail;
	private JTextField txtcphone;
	private JTextField txtcaddress;
	private PreparedStatement p;
	private Connection con;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddClient frame = new AddClient();
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
	public AddClient() {
		con= (Connection) CrudOperation.createConnection();
		createGui();
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 585);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
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
		
		btnadd.setForeground(new Color(255, 255, 255));
		btnadd.setBackground(new Color(102, 51, 0));
		btnadd.setFont(new Font("Calisto MT", Font.BOLD, 13));
		btnadd.addActionListener(this);
		btnadd.setBounds(272, 286, 107, 31);
		panel.add(btnadd);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(new Color(51, 51, 0));
		panel_1.setBounds(221, 29, 448, 83);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAddClientDetails = new JLabel("Add Client Details");
		lblAddClientDetails.setForeground(new Color(255, 255, 255));
		lblAddClientDetails.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblAddClientDetails.setBounds(10, 11, 428, 61);
		panel_1.add(lblAddClientDetails);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
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
}
