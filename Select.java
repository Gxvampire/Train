package Huochepiao;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Huochepiao.Threadsale;

import java.sql.*;

public class Select extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel JL=new JLabel("购票",JLabel.CENTER);
	    JLabel JLStarter=new JLabel("请输入出发地:");
	    JTextField JTStarter=new JTextField();
	    JLabel JLReacher=new JLabel("请输入目的地:");
	    JTextField JTReacher=new JTextField();
	    JLabel JLDate=new JLabel("请输入日期:");
	    JTextField JTDate=new JTextField();
	    JLabel JLX=new JLabel("车票信息:");
	    JTextArea JTX1=new JTextArea();
	    JTextArea JTX=new JTextArea();
	    JLabel JLC=new JLabel("已购买车票:");
	    JTextArea JTC=new JTextArea();
	    JTextArea JTC1=new JTextArea();
	    String str="tid\tstarter\treacher\tticketNumber\tstartTime\tendTime\tseatIdNumber\tbusDate\tprice";
	    String str2="tid\tstarter\treacher\tticketNumber\tstartTime\tendTime\tseatIdNumber\tbusDate\tprice";	   
	JButton JBSelect=new JButton("查询");
	JButton JBSet=new JButton("购买");
	JButton JBNext=new JButton("重置");
	JButton JBExit=new JButton("退出");
	String sql="";
	public Select()
	{
		this.setTitle("购票");
		this.setLayout(null);
		JL.setForeground(Color.blue);
		JL.setFont(new java.awt.Font("宋体",Font.PLAIN,22));
		JL.setBounds(300, 30, 200, 40);
		this.add(JL);
		
		JLStarter.setBounds(20,80,100,20);
		this.add(JLStarter);
		JTStarter.setBounds(120,80,100,20);
		this.add(JTStarter);
		JLReacher.setBounds(230,80,100,20);
		this.add(JLReacher);
		JTReacher.setBounds(330,80,100,20);
		this.add(JTReacher);
		JLDate.setBounds(440,80,100,20);
		this.add(JLDate);
		JTDate.setBounds(540,80,100,20);
		this.add(JTDate);
		
		JBSelect.setBounds(650,80,90,20);
		this.add(JBSelect);
		
		JBSelect.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e) {
				String Starter=JTStarter.getText();
				String Reacher=JTReacher.getText();
				String Date=JTDate.getText();
				sql="select * from train_table where starter='"+Starter+"'and reacher='"+Reacher+"'and date='"+Date+"'";
				System.out.println("数据库操作失败1"+sql);
				try {
					Class.forName("com.hxtt.sql.access.AccessDriver");
					Connection cot=DriverManager.getConnection("jdbc:Access:///D:/gbc.mdb");
					Statement stm=cot.createStatement();
					ResultSet rs=stm.executeQuery(sql);
					String s = new String();
					String s1  = "";
					
							while (rs.next()) {
								//System.out.println("++++");
								JTX1.setText(str);
								for (int i=1; i<10; i++) {
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
				
		JLX.setBounds(100,110,100,20);
		this.add(JLX);
		JTX1.setText(str);
		JTX1.setBounds(20,140,750,20);
		this.add(JTX1);
		JTX.setBounds(20,160,750,180);
		this.add(JTX);
		JLC.setBounds(100,350,80,20);
		this.add(JLC);
		JTC.setText(str2);
		JTC.setBounds(20,380,750,80);
		this.add(JTC);
		
		JBSet.setBounds(150,470,90,20);
		this.add(JBSet);
		JBSet.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				sql="select * from train_table ";
				System.out.println(" "+sql);
				//Threadsale t=new Threadsale();
				//Thread t1=new Thread(t,"第1售票窗口");
				try {
					Class.forName("com.hxtt.sql.access.AccessDriver");
					Connection cot=DriverManager.getConnection("jdbc:Access:///D:/gbc.mdb");
					Statement stm=cot.createStatement();
					ResultSet rs=stm.executeQuery(sql);
							while (rs.next()) {
								//t1.start();
								sql="update train_table set ticketNumber=ticketNumber-1 where tid='K120'";	
								System.out.println(" "+sql);
								int i=stm.executeUpdate(sql);
				    	         if(i>0)
				    	         {
				    	         JOptionPane.showMessageDialog(null,"购买成功！");
				    	         String s=JTX.getText();
				    	         JTC.append(s);
				    	         }
				    	         else JOptionPane.showMessageDialog(null,"购买失败！");
							}
							 
						} catch (Exception ee) {
							ee.printStackTrace();
							JTC.append(null);
						}
			}
		});
		JBNext.setBounds(300,470,90,20);
		this.add(JBNext);
		JBNext.addActionListener(this);
		JBExit.setBounds(450,470,90,20);
		this.add(JBExit);
		JBExit.addActionListener(this);
		this.setBounds(200,100,820,550);
		this.setVisible(true);
		this.setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==JBNext)
	{
		JTStarter.setText(null);
		JTReacher.setText(null);
		
	}
	if(e.getSource()==JBExit)
	{
		setVisible(false);
	}
}
public static void main(String args[]) {
	new Select();
}
}               
class Threadsale implements Runnable
{
	int tickets=36;
	public void run()
	{
		while(true)
		{
			if(tickets>0)
				System.out.println(Thread.currentThread().getName()+"售车票第"+tickets--+"号");
			else
				System.exit(0);
		}
	}
}
