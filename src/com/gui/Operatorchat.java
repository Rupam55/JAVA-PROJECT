package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Operatorchat extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
    private JButton send;
	
	private PreparedStatement ps,ps1;
	private Connection con;
	private ResultSet rs,rs1;
	
	private JComboBox comboBox;
	
	private JLabel lblNewLabel_2;
	private JTextArea textArea;
	private String n;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Operatorchat frame = new Operatorchat();
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
	public Operatorchat() {
		con=CrudOperation.createConnection();
		creategui();
		adddata();
	}
	public void name(String name)
	{
	 n= name;
	}
	
	
	public void creategui(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,935, 638);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 102));
		panel.setBorder(null);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 941, 85);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("OPERATOR CHAT PANEL\r\n");
		lblNewLabel.setBounds(10, 25, 333, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JButton btnClose = new JButton("close");
		btnClose.setBounds(826, 10, 85, 21);
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClose.setForeground(new Color(0, 0, 102));
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(153, 204, 255));
		panel.add(btnClose);
		
		comboBox = new JComboBox();
		comboBox.setBounds(10, 163, 395, 21);
		contentPane.add(comboBox);
		
		JLabel lblSelectTheOperator = new JLabel("select the client");
		lblSelectTheOperator.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSelectTheOperator.setForeground(new Color(0, 0, 102));
		lblSelectTheOperator.setBounds(10, 95, 395, 44);
		contentPane.add(lblSelectTheOperator);
		
		send = new JButton("send");
		send.setFocusPainted(false);
		send.setRequestFocusEnabled(false);
		send.setFocusable(false);
		send.setBorder(null);
		send.setBackground(new Color(255, 255, 255));
		send.setFont(new Font("Tahoma", Font.PLAIN, 15));
		send.setForeground(new Color(0, 0, 102));
		send.setBounds(826, 570, 85, 21);
		contentPane.add(send);
		send.addActionListener(this);
		
		textField = new JTextField();
		textField.setBounds(10, 541, 901, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterYourChat = new JLabel("enter your chat");
		lblEnterYourChat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterYourChat.setForeground(new Color(0, 0, 102));
		lblEnterYourChat.setBounds(10, 510, 264, 21);
		contentPane.add(lblEnterYourChat);
		
		textArea = new JTextArea();
		textArea.setBorder(new EmptyBorder(2, 2, 2, 2));
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setBounds(10, 412, 901, 85);
		contentPane.add(textArea);
		
		JButton btnRefresh = new JButton("refresh");
		btnRefresh.addActionListener(this);
		btnRefresh.setForeground(new Color(0, 0, 102));
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRefresh.setBorder(null);
		btnRefresh.setBackground(Color.WHITE);
		btnRefresh.setBounds(826, 161, 85, 21);
		contentPane.add(btnRefresh);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 478, 5, 22);
		contentPane.add(textArea_1);
		
		JLabel lblNewLabel_1 = new JLabel("your chat");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setBounds(10, 381, 98, 21);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(0, 102, 102));
		lblNewLabel_2.setBounds(10, 286, 901, 85);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("client chat");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(new Color(0, 0, 102));
		lblNewLabel_3.setBounds(10, 255, 98, 21);
		contentPane.add(lblNewLabel_3);
	
	}
		public void adddata()
		{
		comboBox.removeAllItems();
		try {
			ps=con.prepareStatement("select name from login where position='client'");
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
				String client=comboBox.getSelectedItem().toString();
				int i=0;
				try {
				ps=con.prepareStatement("select* from chat where client ='"+client+"' and operator ='"+n+"'");
				rs = ps.executeQuery();
				 if (rs.next()==true)
				{
					 String text2=rs.getString(5);
					 text2=text2+"-"+text;
					 try {
							ps1=con.prepareStatement("update chat set clientchat='-', operatorchat= '"+text2+"' where client='"+client+"' and operator='"+n+"'");
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
							ps1.setString(2,client);
							ps1.setString(3,n);
							ps1.setString(4,"-");
							ps1.setString(5,text);
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
			else if(caption.equals("refresh"))
			{
				String client=comboBox.getSelectedItem().toString();
				try {
					ps1=con.prepareStatement("select * from chat where client='"+client+"' and operator='"+n+"'");
					rs1 = ps1.executeQuery();
					
					 if (rs1.next()==true)
					{
						JOptionPane.showMessageDialog(this, "fetched");
						lblNewLabel_2.setText(rs1.getString(4));
					}
					else {
						 JOptionPane.showMessageDialog(this, "unexpected error");
						 }
					
				}catch(SQLException se)
				{
					System.out.println(se);
				}
			}
		}
	}
