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
	JLabel JL=new JLabel("���»���Ϣ",JLabel.CENTER);
    JLabel JLId=new JLabel("������Ϣ:");
    JTextField JTId=new JTextField();
    JLabel JLStarter=new JLabel("������:");
    JTextField JTStarter=new JTextField();
    JLabel JLReacher=new JLabel("Ŀ�ĵ�:");
    JTextField JTReacher=new JTextField();
    JLabel JLTicketNumber=new JLabel("Ʊ��:");
    JTextField JTTicketNumber=new JTextField();
    JLabel JLStartTime=new JLabel("����ʱ��:");
    JTextField JTStartTime=new JTextField();
    JLabel JLEndTime=new JLabel("����ʱ��:");
    JTextField JTEndTime=new JTextField();
    JLabel JLDate=new JLabel("����:");
    JTextField JTDate=new JTextField();
    JLabel JLPrice=new JLabel("Ʊ��:");
    JTextField JTPrice=new JTextField();
   
	JButton JBAdd=new JButton("��������");
	JButton JBNext=new JButton("����");
	JButton JBExit=new JButton("�˳�");
	String sql="";
	public Add()
	{
		this.setTitle("���»���Ϣ");
		this.setLayout(null);
		JL.setForeground(Color.blue);
		JL.setFont(new java.awt.Font("����",Font.PLAIN,19));
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
			System.out.println("���ݿ����ʧ��1"+sql);
			try {
				Class.forName("com.hxtt.sql.access.AccessDriver");
				Connection cot=DriverManager.getConnection("jdbc:Access:///D:/gbc.mdb");
				Statement stm=cot.createStatement();
				ResultSet rs=stm.executeQuery(sql);
				if(rs.next())
					JOptionPane.showMessageDialog(null,"�ó����Ѿ����ڣ�");
				else{
					sql="insert into train_table values('"+Id+"','"+Starter+"','"
							+Reacher+"','"+TicketNumber+"','"+StartTime+"','"
							+EndTime+"',' ','"+Date+"','"+Price+"')";
					System.out.println(""+sql);
					int i=stm.executeUpdate(sql);
		         if(i>0)JOptionPane.showMessageDialog(null,"���³ɹ���");
		         else JOptionPane.showMessageDialog(null,"����ʧ�ܣ�");
				}
			}catch(Exception ee) {
				System.out.println("���ݿ����ʧ��");
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

