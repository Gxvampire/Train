package Huochepiao;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
*/
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DengLu extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String str;
	
	JLabel JL=new JLabel("登录",JLabel.CENTER);
    JLabel JLNumber=new JLabel("身份证号:");
    JTextField JTNumber=new JTextField(12);
    JLabel JLPassword=new JLabel("密码:");
    JPasswordField JTPassword=new JPasswordField();
    JLabel JLfield=new JLabel("验证码:");
    JTextField JTfield = new JTextField(9);
    JLabel lab2= null;
	ButtonGroup BG2=new ButtonGroup();
    JRadioButton JRole1=new JRadioButton("管理员登录");
    JButton JBlogin=new JButton("登录");
	JButton JB1=new JButton("忘记密码");
	JButton JB2=new JButton("注册");
	String sql="";
	public static String ID = null;

	public static String password = null;

	String s[] = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8",

	"9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",

	"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y",

	"Z" };
	public DengLu(){
		Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		Border border2 = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
		this.setTitle("登录");
		this.setLayout(null);
		JL.setForeground(Color.blue);
		JL.setFont(new java.awt.Font("宋体",Font.PLAIN,30));
		JL.setBounds(100, 10, 200, 40);
		this.add(JL);
		JLNumber.setBounds(40,70,100,20);
		JLNumber.setFont(new Font("", Font.PLAIN, 20));
		this.add(JLNumber);
		JTNumber.setBounds(160,70,100,20);
		this.add(JTNumber);
		JLPassword.setBounds(40,100,100,20);
		JLPassword.setFont(new Font("", Font.PLAIN, 20));
		this.add(JLPassword);
		JTPassword.setBounds(160,100,100,20);
		this.add(JTPassword);
		JLfield.setBounds(40,130,100,20);
		JLfield.setFont(new Font("", Font.PLAIN, 20));
		this.add(JLfield);
		JTfield.setBounds(160,130,100,20);
		this.add(JTfield);
		
		str = yanzheng();
		lab2=new JLabel(str);
		JTfield.setBorder(border2);
		lab2.setBounds(280,130,100,20);
		lab2.setFont(new Font("", Font.PLAIN, 18));
		this.add(lab2);
		
		JRole1.setBounds(140,170,110,20);
		this.add(JRole1);
		JRole1.addActionListener(this);
		BG2.add(JRole1);
		
		JBlogin.setBounds(40,200,80,30);
		JBlogin.setBorder(border);
		JBlogin.setPreferredSize(new Dimension(80, 35));
		JBlogin.setFont(new Font("", Font.PLAIN, 14));
		this.add(JBlogin);
		JBlogin.addActionListener(this);
		JB1.setBounds(130,200,80,30);
		JB1.setBorder(border);
		JB1.setFont(new Font("", Font.PLAIN, 14));
		this.add(JB1);
		JB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new ZhaoHuiMiMa(); 
			}

			});
		JB2.setBounds(220,200,80,30);
		JB2.setBorder(border);
		JB2.setFont(new Font("", Font.PLAIN, 14));
		this.add(JB2);
		JB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new register();
			}

			});
		this.setBounds(200,100,400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("登陆");
		addWindowListener(new WindowAdapter()
		   {public void windowClosing(WindowEvent e)
			   {
			   System.exit(0);
			   }
			   
		   });
	}
	
	public static void main(String[] args){
		new DengLu();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==JRole1)
		   {
			password = String.valueOf(JTPassword.getPassword());
			if(password.equals("ch"))
			   new GuanLiYuan();
			  else{
				   JOptionPane.showMessageDialog(null,"尊敬的管理员，您的密码错误","系统提示",
							JOptionPane.ERROR_MESSAGE);
			   }
		   }
		 if(e.getSource()==JBlogin)
		   {
			   password = String.valueOf(JTPassword.getPassword());
			   if(password.equals("ca"))
			   new YongHu();
			   else{
				   JOptionPane.showMessageDialog(null,"您的密码错误","系统提示",
							JOptionPane.ERROR_MESSAGE);
			   }  
			   
		   }
	}
	private String yanzheng() {
		String y=s[(int) (Math.random() * s.length)]

				+ s[(int) (Math.random() * s.length)]

				+ s[(int) (Math.random() * s.length)] + s[(int) (Math.random() * s.length)];

		return (y);

		}

}