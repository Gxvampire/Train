package Huochepiao;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;


public class GuanLiYuan extends JFrame implements ActionListener{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JMenuBar jmb=new JMenuBar();
   JMenu jm1=new JMenu("信息情况");
   JMenuItem jmi11=new JMenuItem("添加火车信息");
   JMenuItem jmi12=new JMenuItem("删除火车信息");
   JMenuItem jmi13=new JMenuItem("修改火车信息");
   JMenu jm2=new JMenu("查询");
   JMenuItem jmi21=new JMenuItem("火车信息查询");
   JMenuItem jmi22=new JMenuItem("日期");
   JMenu jm3=new JMenu("其他");
   JMenuItem jmi31=new JMenuItem("退出系统");
   JTextArea JTDate=new JTextArea();

   public GuanLiYuan()
   {
	   this.setTitle("火车基本信息");
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
	   jm2.add(jmi21);
	   jm2.addActionListener(this);
	   jmi21.addActionListener(this);
	   jm2.add(jmi22);
	   jmi22.addActionListener(this);
	   jm3.add(jmi31);
	   jm3.addActionListener(this);
	   jmi31.addActionListener(this);
	   this.add(JTDate);
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
		     new Add();
	   }
	   if(e.getSource()==jmi12)
	   {
		   new Delete();
	   }
	   if(e.getSource()==jmi13)
	   {
		   new Set();
	   }
	   if(e.getSource()==jmi21)
	   {
		  new Get();
	   }
	   if(e.getSource()==jmi22)
		{	
		    JTDate.requestFocus();
			Calendar rightNow=Calendar.getInstance();
			Date date=rightNow.getTime();
		    JTDate.insert(date.toString(),JTDate.getCaretPosition());
		}
	   if(e.getSource()==jmi31)
	   {
		   new GExit().setVisible(true);
	   }
   }
   public static void main(String args[])
   {
	   new GuanLiYuan ();
	   
   }
}