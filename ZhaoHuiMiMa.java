package Huochepiao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.util.*;
//import javax.swing.event.*;
//import java.sql.*;

public class ZhaoHuiMiMa extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel JL=new JLabel("身份验证",JLabel.CENTER);
	JLabel JLNumber=new JLabel("身份证号：");
	JTextField JTNumber=new JTextField();
	JLabel JLName=new JLabel("姓名：");
	JTextField JTName=new JTextField();
	JButton JBGet=new JButton("进入");
	JButton JBNext=new JButton("重置");
	JButton JBExit=new JButton("退出");
	String sql="";
	public ZhaoHuiMiMa()
	{
		this.setTitle("身份验证");
		this.setLayout(null);
		JL.setForeground(Color.blue);
		JL.setFont(new java.awt.Font("宋体",Font.PLAIN,22));
		JL.setBounds(150, 30, 200, 40);
		this.add(JL);
		JLNumber.setBounds(150,100,100,20);
		this.add(JLNumber);
		JTNumber.setBounds(250,100,80,20);
		this.add(JTNumber);
		JLName.setBounds(150,140,100,20);
		this.add(JLName);
		JTName.setBounds(250,140,80,20);
		this.add(JTName);
		JBGet.setBounds(80,320,90,20);
		this.add(JBGet);
		JBGet.addActionListener(this);
		JBNext.setBounds(190,320,90,20);
		this.add(JBNext);
		JBNext.addActionListener(this);
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
	if(e.getSource()==JBGet)
		   {
			   new XiuGaiMiMa();
		   }
	if(e.getSource()==JBNext)
	{
		JTNumber.setText(null);
		JTName.setText(null);
	}
	if(e.getSource()==JBExit)
	{
		setVisible(false);
	}
	}
public static void main(String args[]) {
	new ZhaoHuiMiMa();
}

}                                                     
