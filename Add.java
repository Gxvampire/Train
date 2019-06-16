package Huochepiao;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.util.*;
//import javax.swing.event.*;
import java.sql.*;

public class Add extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel JL=new JLabel("更新火车信息",JLabel.CENTER);
    JLabel JLId=new JLabel("车次信息:");
    JTextField JTId=new JTextField();
    JLabel JLStarter=new JLabel("出发地:");
    JTextField JTStarter=new JTextField();
    JLabel JLReacher=new JLabel("目的地:");
    JTextField JTReacher=new JTextField();
    JLabel JLTicketNumber=new JLabel("票数:");
    JTextField JTTicketNumber=new JTextField();
    JLabel JLStartTime=new JLabel("出发时间:");
    JTextField JTStartTime=new JTextField();
    JLabel JLEndTime=new JLabel("到达时间:");
    JTextField JTEndTime=new JTextField();
    JLabel JLDate=new JLabel("日期:");
    JTextField JTDate=new JTextField();
    JLabel JLPrice=new JLabel("票价:");
    JTextField JTPrice=new JTextField();
   
	JButton JBAdd=new JButton("更新数据");
	JButton JBNext=new JButton("重置");
	JButton JBExit=new JButton("退出");
	String sql="";
	public Add()
	{
		this.setTitle("更新火车信息");
		this.setLayout(null);
		JL.setForeground(Color.blue);
		JL.setFont(new java.awt.Font("宋体",Font.PLAIN,19));
		JL.setBounds(100, 30, 200, 40);
		this.add(JL);
		
		JLId.setBounds(20,80,70,20);
		this.add(JLId);
		JTId.setBounds(100,80,100,20);
		this.add(JTId);
		JLTicketNumber.setBounds(230,80,70,20);
		this.add(JLTicketNumber);
		JTTicketNumber.setBounds(300,80,100,20);
		this.add(JTTicketNumber);
		
		JLStarter.setBounds(20,120,70,20);
		this.add(JLStarter);
		JTStarter.setBounds(100,120,100,20);
		this.add(JTStarter);
		JLReacher.setBounds(230,120,70,20);
		this.add(JLReacher);
		JTReacher.setBounds(300,120,100,20);
		this.add(JTReacher);
		
		JLDate.setBounds(20,160,70,20);
		this.add(JLDate);
		JTDate.setBounds(100,160,100,20);
		this.add(JTDate);
		JLPrice.setBounds(230,160,70,20);
		this.add(JLPrice);
		JTPrice.setBounds(300,160,100,20);
		this.add(JTPrice);
		
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
			String Id=JTId.getText();
			String Starter=JTStarter.getText();
			String Reacher=JTReacher.getText();
			String TicketNumber=JTTicketNumber.getText();
			String StartTime=JTStartTime.getText();
			String EndTime=JTEndTime.getText();
			String Date=JTDate.getText();
			String Price=JTPrice.getText();
			
			sql="select * from train_table where tid='"+Id+"'";
			System.out.println("数据库操作失败1"+sql);
			try {
				Class.forName("com.hxtt.sql.access.AccessDriver");
				Connection cot=DriverManager.getConnection("jdbc:Access:///D:/gbc.mdb");
				Statement stm=cot.createStatement();
				ResultSet rs=stm.executeQuery(sql);
				if(rs.next())
					JOptionPane.showMessageDialog(null,"该车次已经存在！");
				else{
					sql="insert into train_table values('"+Id+"','"+Starter+"','"
							+Reacher+"','"+TicketNumber+"','"+StartTime+"','"
							+EndTime+"',' ','"+Date+"','"+Price+"')";
					System.out.println(""+sql);
					int i=stm.executeUpdate(sql);
		         if(i>0)JOptionPane.showMessageDialog(null,"更新成功！");
		         else JOptionPane.showMessageDialog(null,"更新失败！");
				}
			}catch(Exception ee) {
				System.out.println("数据库操作失败");
				ee.printStackTrace();
			}
			
		}
	if(e.getSource()==JBNext)
	{
		JTId.setText(null);
		JTStarter.setText(null);
		JTReacher.setText(null);
		JTTicketNumber.setText(null);
		JTStartTime.setText(null);
		JTEndTime.setText(null);
		JTDate.setText(null);
		JTPrice.setText(null);
	}
	if(e.getSource()==JBExit)
	{
		setVisible(false);
	}
}
public static void main(String args[]) {
	new Add();
}

}                                                     

