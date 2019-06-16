package Huochepiao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.util.*;
//import javax.swing.event.*;

public class YongHu extends JFrame implements ActionListener{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JMenuBar jmb=new JMenuBar();
   JMenu jm1=new JMenu("车票");
   JMenuItem jmi11=new JMenuItem("购票");
   JMenuItem jmi12=new JMenuItem("改签");
   JMenuItem jmi13=new JMenuItem("退票");
   JMenu jm2=new JMenu("查询");
   JMenuItem jmi21=new JMenuItem("个人信息查询");
   JMenuItem jmi22=new JMenuItem("票务查询");
   JMenu jm3=new JMenu("其他");
   JMenuItem jmi31=new JMenuItem("退出系统");
   public YongHu()
   {
	   this.setTitle("欢迎用户登入");
	   this.setLayout(new CardLayout());
	   this.setJMenuBar(jmb);
	   jmb.add(jm1);
	   jmb.add(jm2);
	   jmb.add(jm3);
	   jm1.add(jmi11);
	   jm1.add(jmi12);
	   jm1.add(jmi13);
	   jmi11.addActionListener(this);
	   jmi12.addActionListener(this);
	   jmi13.addActionListener(this);
	   jm2.add(jmi21);jm2.addActionListener(this);
	   jmi21.addActionListener(this);
	   jm2.add(jmi22); 
	   jmi22.addActionListener(this);
	   jm3.add(jmi31);
	   jm3.addActionListener(this);
	   jmi31.addActionListener(this);
	   this.setBounds(10,10,500,400);
	   this.setVisible(true);
	   addWindowListener(new WindowAdapter()
	   {public void windowClosing(WindowEvent e)
		   {
		   System.exit(0);
		   }
		   
	   });
   }
   public void actionPerformed(ActionEvent e)
   {
	   if(e.getSource()==jmi11)
	   {
		   new Select();
	   }
	   if(e.getSource()==jmi12)
	   {
		   JOptionPane.showMessageDialog(null,"暂时无法进行改签奥！*.*","系统提示",
					JOptionPane.ERROR_MESSAGE);
	   }
	   if(e.getSource()==jmi13)
	   {
		   new Tuipiao();
	   }
	   if(e.getSource()==jmi21)
	   {
		   new Setxinxi();
	   }
	   if(e.getSource()==jmi22)
	   {
		   new YiGouPiao();
	   }
	   if(e.getSource()==jmi31)
	   {
		   new GExit().setVisible(true);
	   }
   }
   public static void main(String args[])
   {
	   new YongHu ();
	   
   }
}