package Huochepiao;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
//import javax.swing.table.AbstractTableModel;

import java.sql.*;

public class Get extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel JL=new JLabel("查询",JLabel.CENTER);
	    JLabel JLX=new JLabel("用户信息:");
	    JTextArea JTX1=new JTextArea();
	    JTextArea JTX=new JTextArea();
	    JLabel JLC=new JLabel("车票:");
	    JTextArea JTC1=new JTextArea();
	    JTextArea JTC=new JTextArea();
	    
	    String str="id\tname\tpassword\tsex\tphone\trole";
	    String str2="tid\tstarter\treacher\tstartTime\tendTime\tbusDate\tprice\tticketNumber\tseatIdNumber";
	JButton JBSelect=new JButton("查询");
	JButton JBSelect2=new JButton("查询");
	JButton JBExit=new JButton("退出");
	String sql="";
	public Get()
	{
		this.setTitle("查询");
		this.setLayout(null);
		JL.setForeground(Color.blue);
		JL.setFont(new java.awt.Font("宋体",Font.PLAIN,22));
		JL.setBounds(300, 30, 200, 40);
		this.add(JL);
		
		JLX.setBounds(100,80,100,20);
		this.add(JLX);
		JTX1.setText(str);
		JTX1.setBounds(20,110,750,20);
		this.add(JTX1);
		JTX.setBounds(20,130,750,180);
		this.add(JTX);
		JBSelect.setBounds(650,320,90,20);
		this.add(JBSelect);
		
		JBSelect.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e) {
				sql="select * from user_table ";
				System.out.println("数据库操作失败1"+sql);
				try {
					Class.forName("com.hxtt.sql.access.AccessDriver");
					Connection cot=DriverManager.getConnection("jdbc:Access:///D:/gbc.mdb");
					Statement stm=cot.createStatement();
					ResultSet rs=stm.executeQuery(sql);
					String s = new String();
					String s1  = "";
					
							while (rs.next()) {
								for (int i=1; i<7; i++) {
									s = rs.getString(i) + "\t";
									s1 += s;
								}
								s = "\n";
								s1 += s;
							}
							 JTX.append("\n"+s1);
						} catch (Exception ee) {
							ee.printStackTrace();
							JTX.append(null);
						}

					}
		});
		
		
		JLC.setBounds(100,330,80,20);
		this.add(JLC);
		JTC1.setText(str2);
		JTC1.setBounds(20,360,750,20);
		this.add(JTC1);
		JTC.setBounds(20,380,750,180);
		this.add(JTC);
		
		
		
		JBSelect2.setBounds(650,570,90,20);
		this.add(JBSelect2);
		JBSelect2.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e) {
				sql="select * from train_table ";
				System.out.println("数据库操作失败1"+sql);
				try {
					Class.forName("com.hxtt.sql.access.AccessDriver");
					Connection cot=DriverManager.getConnection("jdbc:Access:///D:/gbc.mdb");
					Statement stm=cot.createStatement();
					ResultSet rs=stm.executeQuery(sql);
					String s = new String();
					String s1  = "";
					
							while (rs.next()) {
								for (int i=1; i<10; i++) {
									s = rs.getString(i) + "\t";
									s1 += s;
								}
								s = "\n";
								s1 += s;
							}
							 JTC.append("\n"+s1);
						} catch (Exception ee) {
							ee.printStackTrace();
							JTC.append(null);
						}

					}
		});
		JBExit.setBounds(450,570,90,20);
		this.add(JBExit);
		JBExit.addActionListener(this);
		this.setBounds(50,20,820,650);
		this.setVisible(true);
		this.setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		
	if(e.getSource()==JBExit)
	{
		setVisible(false);
	}
}
public static void main(String args[]) {
	new Get();
	
}
}                 
