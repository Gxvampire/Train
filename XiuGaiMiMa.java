package Huochepiao;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.util.*;
//import javax.swing.event.*;
import java.sql.*;

public class XiuGaiMiMa extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel JL=new JLabel("�޸�����",JLabel.CENTER);
	JLabel JLphone=new JLabel("�ֻ��ţ�");
	JTextField JTphone=new JTextField();
	JLabel JLNewp=new JLabel("�����룺");
	JTextField JTNewp=new JTextField();
	JLabel JLNewp2=new JLabel("ȷ�����룺");
	JTextField JTNewp2=new JTextField();
	JButton JBGet=new JButton("ȷ��");
	JButton JBNext=new JButton("����");
	JButton JBExit=new JButton("�˳�");
	String sql="";
	public XiuGaiMiMa()
	{
		this.setTitle("�޸�����");
		this.setLayout(null);
		JL.setForeground(Color.blue);
		JL.setFont(new java.awt.Font("����",Font.PLAIN,22));
		JL.setBounds(150, 30, 200, 40);
		this.add(JL);
		JLphone.setBounds(150,100,100,20);
		this.add(JLphone);
		JTphone.setBounds(250,100,80,20);
		this.add(JTphone);
		JLNewp.setBounds(150,140,100,20);
		this.add(JLNewp);
		JTNewp.setBounds(250,140,80,20);
		this.add(JTNewp);
		JLNewp2.setBounds(150,180,100,20);
		this.add(JLNewp2);
		JTNewp2.setBounds(250,180,80,20);
		this.add(JTNewp2);
		
		JBGet.setBounds(80,320,90,20);
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
			String sphone=JTphone.getText();
			String snewp=JTNewp.getText();
			//String snewp2=JTNewp2.getText();
			sql="select*from user_table where phone="+sphone+"";
			try {
				Class.forName("com.hxtt.sql.access.AccessDriver");
				Connection cot=DriverManager.getConnection("jdbc:Access:///D:/gbc.mdb");
				Statement stm=cot.createStatement();
				ResultSet rs=stm.executeQuery(sql);
				if(rs.next())
				{
					sql="update user_table set password='"+snewp+"'where phone="
							+sphone+"";
					int n=stm.executeUpdate(sql);
		         if(n>0)JOptionPane.showMessageDialog(null,"�޸ĳɹ���");
		         else JOptionPane.showMessageDialog(null,"�޸�ʧ�ܣ�");
				}else {
					JOptionPane.showMessageDialog(null,"���û������ڣ�");
				}
			}catch(Exception er) {
				er.printStackTrace();
			}
		}
	if(e.getSource()==JBNext)
	{
		JTphone.setText(null);
		JTNewp.setText(null);
		JTNewp2.setText(null);
	}
	if(e.getSource()==JBExit)
	{
		setVisible(false);
	}
	}
public static void main(String args[]) {
	new XiuGaiMiMa();
}

}                                                     
