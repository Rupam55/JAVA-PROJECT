package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.dbutils.CrudOperation;
import javax.swing.JTabbedPane;


public class WorkManagement extends JFrame implements ActionListener{
	
	private Connection con;
	private PreparedStatement pslid,pswid, psonline, psadd;
	private ResultSet rslid, rswid, rsonline, rsadd;
	
	private JPanel contentPane;
	private JComboBox lbrdel, lbrallot, workallot, workupdate, lbrupdate;
	private JOptionPane dialog;

	ActionListener sub;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkManagement frame = new WorkManagement();
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
	public WorkManagement() {
		con = CrudOperation.createConnection();
		CreateGui();
		datafetch();
	}
	
/*----------------------------------------------------Data Fetch----------------------------------------------------------------------------------------------*/	
	public void datafetch() {
		
		lbrdel.removeAllItems();
		lbrallot.removeAllItems();
		workallot.removeAllItems();
		workupdate.removeAllItems();
		lbrupdate.removeAllItems();
		/*- - - - - - -Allot- - - - - - - */

		String fetchlbrid = "select lid from labourdetails where status='-'";
		String fetchworkid = "select workid from workmgmt";
		
		/*- - - - - - -Update- - - - - - - */
		
		String onlinelbrid = "select lid from labourdetails where status='online'";
		
		 try {
			 
		 pslid = con.prepareStatement(fetchlbrid);
		 pswid = con.prepareStatement(fetchworkid);
		 psonline = con.prepareStatement(onlinelbrid);
		 
		 rslid = pslid.executeQuery();
		 rswid = pswid.executeQuery();
		 rsonline = psonline.executeQuery();
		 
		 while(rswid.next())
		 {	
			 String wkid = rswid.getString("workid");
			 workallot.addItem(wkid);
			 workupdate.addItem(wkid);
		}
		 
		 while(rsonline.next())
		 {
			 String olnid = rsonline.getString("lid");		 
			 lbrdel.addItem(olnid);
			 lbrupdate.addItem(olnid);
			 
		 }
		 while(rslid.next())
		 {
			 String lbrid = rslid.getString("lid");
			 lbrallot.addItem(lbrid);		 
		 }
		 }
		 
		 catch(SQLException se)
		 {System.out.println(se);}
		 
	}

/*--------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	public void CreateGui()
	{
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 935, 638);
	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JSeparator separator = new JSeparator();
	separator.setOrientation(SwingConstants.VERTICAL);
	separator.setForeground(Color.BLACK);
	separator.setBackground(Color.BLACK);
	separator.setBounds(321, 132, 2, 449);
	contentPane.add(separator);
	
	JSeparator separator_2 = new JSeparator();
	separator_2.setOrientation(SwingConstants.VERTICAL);
	separator_2.setForeground(Color.BLACK);
	separator_2.setBackground(Color.BLACK);
	separator_2.setBounds(623, 132, 2, 449);
	contentPane.add(separator_2);
	
/*--------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	/*- - - - - - Allot- - - - - - - - */
	
	lbrallot = new JComboBox();
	lbrallot.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
	lbrallot.setBounds(130, 245, 124, 31);
	contentPane.add(lbrallot);
	
	workallot = new JComboBox();
	workallot.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
	workallot.setBounds(130, 333, 124, 31);
	contentPane.add(workallot);
	
	/*- - - - - - Update- - - - - - - - */
	
	lbrupdate = new JComboBox();
	lbrupdate.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
	lbrupdate.setBounds(453, 245, 124, 31);
	contentPane.add(lbrupdate);
		
	workupdate = new JComboBox();
	workupdate.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
	workupdate.setBounds(453, 333, 124, 31);
	contentPane.add(workupdate);
	
	/*- - - - - - Delete- - - - - - - - */
	
	lbrdel = new JComboBox();
	lbrdel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
	lbrdel.setBounds(755, 242, 124, 31);
	contentPane.add(lbrdel);

	
/*---------------------------------------------------Buttons-----------------------------------------------------------------------------------------------*/	
	
/*- - - - - - - - - - - - - -addButton- - - - - - - - - - - - - - */
	JButton btnsubmit = new JButton("Submit");
	btnsubmit.setForeground(new Color(255, 255, 255));
	btnsubmit.setBorder(null);
	btnsubmit.setBackground(new Color(0, 0, 102));
	btnsubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnsubmit.setBounds(103, 550, 124, 31);
	contentPane.add(btnsubmit);
	btnsubmit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent aeA) {
			String getwkallot = workallot.getSelectedItem().toString();
			String getlballot = lbrallot.getSelectedItem().toString();
			String insallot = "update labourdetails set workid = '"+getwkallot+"' where lid='"+getlballot+"'";
			try
			{
				psadd = con.prepareStatement(insallot);
				int update = psadd.executeUpdate();
				JOptionPane.showMessageDialog(dialog, "Work Alloted Successfully");
				datafetch();
			}
			catch(SQLException se1)
			{
				System.out.println(se1);
			}			
			
		}
	});
	
	
/*- - - - - - - - - - - - - -updateButton- - - - - - - - - - - - - - */
	JButton btnUpdate = new JButton("Update");
	btnUpdate.setBorder(null);
	btnUpdate.setBackground(new Color(0, 0, 102));
	btnUpdate.setForeground(new Color(255, 255, 255));
	btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnUpdate.setBounds(415, 550, 124, 31);
	contentPane.add(btnUpdate);
	btnUpdate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent aeU) {
			String uplbr = lbrupdate.getSelectedItem().toString();
			String wkuplbr = workupdate.getSelectedItem().toString();
			String upd = "update labourdetails set workid = '"+wkuplbr+"' where lid='"+uplbr+"'";
			try
			{
				psadd = con.prepareStatement(upd);
				int updl = psadd.executeUpdate();
				JOptionPane.showMessageDialog(dialog, "Work Updated Successfully");
				datafetch();
			}
			catch(SQLException se)
			{
				System.out.println(se);
			}			
		}
	});
	
	
/*- - - - - - - - - - - - - -deleteButton- - - - - - - - - - - - - - */
	JButton btnDelete = new JButton("Delete");
	btnDelete.setForeground(new Color(255, 255, 255));
	btnDelete.setBorder(null);
	btnDelete.setBackground(new Color(0, 0, 102));
	btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnDelete.setBounds(717, 550, 124, 31);
	contentPane.add(btnDelete);
	btnDelete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent aeD) {
			String dellbr = lbrdel.getSelectedItem().toString();
			String del = "update labourdetails set workid = ''where lid='"+dellbr+"'";
			try
			{
				psadd = con.prepareStatement(del);
				int dlt = psadd.executeUpdate();
				JOptionPane.showMessageDialog(dialog, "Work Removed Successfully");
				
				datafetch();
			}
			catch(SQLException se1)
			{
				System.out.println(se1);
			}			
			
		}
	});
	
/*-------------------------------------------------------------Labels-------------------------------------------------------------------------------------*/		
	
	JLabel lblWorkManagement = new JLabel("Work Management");
	lblWorkManagement.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 35));
	lblWorkManagement.setHorizontalAlignment(SwingConstants.CENTER);
	lblWorkManagement.setBounds(10, 10, 911, 47);
	contentPane.add(lblWorkManagement);
	
	JLabel lblAllotWork = new JLabel("Allot Work");
	lblAllotWork.setHorizontalAlignment(SwingConstants.CENTER);
	lblAllotWork.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 25));
	lblAllotWork.setBounds(10, 132, 301, 47);
	contentPane.add(lblAllotWork);
	
	JLabel lblLabourId = new JLabel("Labour ID");
	lblLabourId.setFont(new Font("Microsoft JhengHei", Font.BOLD, 15));
	lblLabourId.setBounds(10, 239, 110, 40);
	contentPane.add(lblLabourId);
	
	JLabel lblWork = new JLabel("Work");
	lblWork.setFont(new Font("Microsoft JhengHei", Font.BOLD, 15));
	lblWork.setBounds(10, 327, 110, 40);
	contentPane.add(lblWork);
	
	JLabel label = new JLabel("Labour ID");
	label.setFont(new Font("Microsoft JhengHei", Font.BOLD, 15));
	label.setBounds(333, 239, 110, 40);
	contentPane.add(label);
	
	JLabel label_1 = new JLabel("Work");
	label_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 15));
	label_1.setBounds(333, 327, 110, 40);
	contentPane.add(label_1);
	
	JLabel label_2 = new JLabel("Labour ID");
	label_2.setFont(new Font("Microsoft JhengHei", Font.BOLD, 15));
	label_2.setBounds(635, 236, 110, 40);
	contentPane.add(label_2);
	
	JLabel lblUpdateWork = new JLabel("Update Work");
	lblUpdateWork.setHorizontalAlignment(SwingConstants.CENTER);
	lblUpdateWork.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 25));
	lblUpdateWork.setBounds(333, 132, 280, 47);
	contentPane.add(lblUpdateWork);
	
	JLabel lblDeleteAlotments = new JLabel("Delete Allotments");
	lblDeleteAlotments.setHorizontalAlignment(SwingConstants.CENTER);
	lblDeleteAlotments.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 25));
	lblDeleteAlotments.setBounds(635, 132, 286, 47);
	contentPane.add(lblDeleteAlotments);
	
	}
	public void actionPerformed(ActionEvent e) {}
				
}