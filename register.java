package Huochepiao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class register extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel JL=new JLabel("注册信息",JLabel.CENTER);
    JLabel JLNumber=new JLabel("身份证号:");
    JTextField JTNumber=new JTextField();
    JLabel JLName=new JLabel("姓名:");
    JTextField JTName=new JTextField();
    JLabel JLPassword=new JLabel("密码:");
    JTextField JTPassword=new JTextField();
    JLabel JLsex=new JLabel("性别:");
    ButtonGroup BG=new ButtonGroup();
    JRadioButton JRB1=new JRadioButton("男");
    JRadioButton JRB2=new JRadioButton("女");
	JLabel JL2=new JLabel("手机号：");
	JTextField JT2=new JTextField();
	JLabel JLrole=new JLabel("角色:");
	ButtonGroup BG2=new ButtonGroup();
    JRadioButton JRole1=new JRadioButton("管理员");
    JRadioButton JRole2=new JRadioButton("用户");
	JButton JBAdd=new JButton("注册");
	JButton JBNext=new JButton("重置");
	JButton JBExit=new JButton("退出");
	String sql="";
	public register()
	{
		this.setTitle("注册信息");
		this.setLayout(null);
		JL.setForeground(Color.blue);
		JL.setFont(new java.awt.Font("宋体",Font.PLAIN,19));
		JL.setBounds(100, 30, 200, 40);
		this.add(JL);
		JLNumber.setBounds(100,80,100,20);
		this.add(JLNumber);
		JTNumber.setBounds(200,80,80,20);
		this.add(JTNumber);
		JLName.setBounds(100,120,100,20);
		this.add(JLName);
		JTName.setBounds(200,120,80,20);
		this.add(JTName);
		JLPassword.setBounds(100,160,100,20);
		this.add(JLPassword);
		JTPassword.setBounds(200,160,80,20);
		this.add(JTPassword);
		
		JLsex.setBounds(100,200,100,20);
		this.add(JLsex);
		JRB1.setBounds(200, 200, 40, 20);
		JRB2.setBounds(300, 200, 40, 20);
		this.add(JRB1);
		this.add(JRB2);
		BG.add(JRB1);
		BG.add(JRB2);
		JL2.setBounds(100,240, 100, 20);
		this.add(JL2);
		JT2.setBounds(200, 240, 80, 20);
		this.add(JT2);
		
		JLrole.setBounds(100,280,100,20);
		this.add(JLrole);
		JRole1.setBounds(200, 280, 80, 20);
		JRole2.setBounds(300, 280, 80, 20);
		this.add(JRole1);JRole1.addActionListener(this);
		this.add(JRole2);JRole2.addActionListener(this);
		BG2.add(JRole1);
		BG2.add(JRole2);
		JBAdd.setBounds(80,320,90,20);
		this.add(JBAdd);
		JBAdd.addActionListener(this);
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
		if(e.getSource()==JBAdd)
		{
			String snumber=JTNumber.getText();
			String sname=JTName.getText();
			String ssex="女";
			if(JRB1.isSelected())
				ssex="男";
			String sphone=JT2.getText();
			String sRole="用户",sql;
			if(JRole1.isSelected())
				ssex="管理员";
			
			sql="select * from user_table where ID='"+snumber+"'";
			System.out.println("数据库操作失败1"+sql);
			try {
				Class.forName("com.hxtt.sql.access.AccessDriver");
				Connection cot=DriverManager.getConnection("jdbc:Access:///D:/gbc.mdb");
				Statement stm=cot.createStatement();
				ResultSet rs=stm.executeQuery(sql);
				if(rs.next())
					JOptionPane.showMessageDialog(null,"该号已经存在！");
				else{
					sql="insert into user_table values('"+snumber+"','"
							+sname+"','','"+ssex+"','"+sphone+"','"+sRole+"')";
					System.out.println(""+sql);
					int i=stm.executeUpdate(sql);
		         if(i>0)JOptionPane.showMessageDialog(null,"添加成功！");
		         else JOptionPane.showMessageDialog(null,"添加失败！");
				}
			}catch(Exception ee) {
				System.out.println("数据库操作失败");
				ee.printStackTrace();
			}
		}
	if(e.getSource()==JBNext)
	{
		JTNumber.setText(null);
		JTName.setText(null);
		JT2.setText(null);
	}
	if(e.getSource()==JBExit)
	{
		setVisible(false);
	}
}
public static void main(String args[]) {
	new register();
}

}                                                     
