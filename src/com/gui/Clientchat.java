package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Clientchat extends JFrame  implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JButton send;
	private JLabel lblNewLabel_2;
	private JTextArea textArea;
	
	private JComboBox comboBox;
	
	private PreparedStatement ps,ps1;
	private Connection con;
	private ResultSet rs,rs1;
	
	private String n;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientchat frame = new Clientchat();
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
	public Clientchat() {
		con=CrudOperation.createConnection();
		creategui(); 
		adddata();
		
	}
	public Clientchat(String client) {
		con=CrudOperation.createConnection();
		creategui(); 
		adddata();
		
	}
	public void name(String name)
	{
	 n= name;
	}
	
	public void creategui() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,935, 638);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.setFocusable(false);
		contentPane.setForeground(new Color(0, 0, 102));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 102));
		panel.setBorder(null);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 941, 85);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CLIENT CHAT PANEL");
		lblNewLabel.setBounds(10, 25, 281, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JButton btnClose = new JButton("close");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClose.setForeground(new Color(0, 0, 102));
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(204, 204, 255));
		btnClose.setBounds(826, 10, 85, 21);
		panel.add(btnClose);
		btnClose.addActionListener(this);
		
		JLabel lblPersonalChatTo = new JLabel("personal chat to desired operator");
		lblPersonalChatTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPersonalChatTo.setForeground(new Color(255, 255, 255));
		lblPersonalChatTo.setBounds(688, 54, 223, 21);
		panel.add(lblPersonalChatTo);
		
		 comboBox = new JComboBox();
		comboBox.setBounds(10, 148, 395, 21);
		contentPane.add(comboBox);
		
		JLabel lblSelectTheOperator = new JLabel("select the operator");
		lblSelectTheOperator.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSelectTheOperator.setForeground(new Color(0, 0, 102));
		lblSelectTheOperator.setBounds(10, 95, 395, 43);
		contentPane.add(lblSelectTheOperator);
		
		send = new JButton("send");
		send.setBorder(null);
		send.setBackground(new Color(255, 255, 255));
		send.setFont(new Font("Tahoma", Font.PLAIN, 15));
		send.setForeground(new Color(0, 0, 102));
		send.setBounds(826, 570, 85, 21);
		contentPane.add(send);
		send.addActionListener(this);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 0, 0));
		textField.setBounds(10, 541, 901, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterYourChat = new JLabel("enter your chat");
		lblEnterYourChat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterYourChat.setForeground(new Color(0, 0, 102));
		lblEnterYourChat.setBounds(10, 510, 264, 21);
		contentPane.add(lblEnterYourChat);
		
		JLabel lblOperatorsResponse = new JLabel("operators response");
		lblOperatorsResponse.setForeground(new Color(0, 0, 102));
		lblOperatorsResponse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOperatorsResponse.setBounds(10, 236, 214, 21);
		contentPane.add(lblOperatorsResponse);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRefresh.setBorder(null);
		btnRefresh.setBackground(new Color(255, 255, 255));
		btnRefresh.setForeground(new Color(0, 0, 102));
		btnRefresh.setBounds(826, 161, 85, 21);
		contentPane.add(btnRefresh);
		btnRefresh.addActionListener(this);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(0, 153, 153));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 267, 901, 95);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblYourChat = new JLabel("your chat");
		lblYourChat.setForeground(new Color(0, 0, 102));
		lblYourChat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYourChat.setBounds(10, 374, 63, 21);
		contentPane.add(lblYourChat);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setForeground(new Color(0, 102, 102));
		textArea.setBounds(10, 405, 901, 95);
		contentPane.add(textArea);
		
	}
	//--------------------------------------------------------------------------------fuctions
	
	public void adddata()
	{
	comboBox.removeAllItems();
	try {
		ps=con.prepareStatement("select name from login where position='Contractor'");
		rs=ps.executeQuery();
		while(rs.next())
		{
			comboBox.addItem(rs.getString(1));
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
	}
	//----------------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e) {
        String caption = e.getActionCommand();
		
		//--------------------------------------------------------------add labour details
		if(caption.equals("send"))
		{ 
			String text=textField.getText();
			String operator=comboBox.getSelectedItem().toString();
			int i=0;
			try {
			ps=con.prepareStatement("select* from chat where client ='"+n+"' and operator ='"+operator+"'");
			rs = ps.executeQuery();
			 if (rs.next()==true)
			{
				 String text2=rs.getString(4);
				 text2=text2+"-"+text;
				 try {
						ps1=con.prepareStatement("update chat set clientchat='"+text2+"', operatorchat= '-' where client='"+n+"' and operator='"+operator+"'");
						int row = ps1.executeUpdate();
						if(row>0)
						{
							JOptionPane.showMessageDialog(this, "sent");
							textArea.append(text+"\n");
							textField.setText("");
						}
						
					}catch(SQLException se)
					{
						System.out.println(se);
					}

			}
				
			 else {
				 try {
						ps1=con.prepareStatement("insert into chat values(?,?,?,?,?)");
						ps1.setInt(1, i);
						ps1.setString(2,n);
						ps1.setString(3,operator);
						ps1.setString(4,text);
						ps1.setString(5,"-");
						i++;
						int row = ps1.executeUpdate();
						if(row>0)
						{
							JOptionPane.showMessageDialog(this, "sent");
							textArea.append(text+"\n");
							textField.setText("");
						}
						
					}catch(SQLException se)
					{
						System.out.println(se);
					}
					}
			}catch (SQLException se) {
				// TODO: handle exception
			}finally {
				try {
					ps.close();
					rs.close();
					ps1.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		
		//---------------------------------------------------refresh
		else if(caption.equals("Refresh"))
		{
			String operator=comboBox.getSelectedItem().toString();
					 try {
							ps1=con.prepareStatement("select * from chat where client='"+n+"' and operator='"+operator+"'");
							rs1 = ps1.executeQuery();
							
							 if (rs1.next()==true)
							{
								JOptionPane.showMessageDialog(this, "fetched");
								lblNewLabel_2.setText(rs1.getString(5));
							}
							else {
								 JOptionPane.showMessageDialog(this, "unexpected error");
								 }
							
						}catch(SQLException se)
						{
							System.out.println(se);
						}

		}
		else if(caption.equals("close"))
		{
			
		}
	}
}
