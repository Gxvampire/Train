package Huochepiao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.util.*;
//import javax.swing.event.*;
//import java.sql.*;

public class Setxinxi extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel JL=new JLabel("个人信息",JLabel.CENTER);
    JLabel JLName=new JLabel("姓名:");
    JLabel JLName1=new JLabel("ca");
    JLabel JLsex=new JLabel("性别:");
    JLabel JLsex1=new JLabel("女");
	JLabel JL2=new JLabel("手机号：");
	JLabel JL21=new JLabel("152");
	JLabel JLrole=new JLabel("角色:");
	JLabel JLrole1=new JLabel("用户");
	JButton JBExit=new JButton("退出");
	String sql="";
	public Setxinxi()
	{
		this.setTitle("个人信息");
		this.setLayout(null);
		JL.setForeground(Color.blue);
		JL.setFont(new java.awt.Font("宋体",Font.PLAIN,19));
		JL.setBounds(100, 30, 200, 40);
		this.add(JL);
		JLName.setBounds(100,80,80,20);
		this.add(JLName);
		JLName1.setBounds(300,80,80,20);
		this.add(JLName1);
		
		JLsex.setBounds(100,120,80,20);
		this.add(JLsex);
		JLsex1.setBounds(300,120,80,20);
		this.add(JLsex1);
		
		JL2.setBounds(100,160,80,20);
		this.add(JL2);
		JL21.setBounds(300,160,80,20);
		this.add(JL21);
		
		JLrole.setBounds(100,200,80,20);
		this.add(JLrole);
		JLrole1.setBounds(300,200,80,20);
		this.add(JLrole1);
		
		JBExit.setBounds(300,320,90,20);
		this.add(JBExit);
		JBExit.addActionListener(this);
		this.setBounds(10,10,500,400);
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
	new Setxinxi();
}

}                                                     
