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
	JLabel JL=new JLabel("ע����Ϣ",JLabel.CENTER);
    JLabel JLNumber=new JLabel("���֤��:");
    JTextField JTNumber=new JTextField();
    JLabel JLName=new JLabel("����:");
    JTextField JTName=new JTextField();
    JLabel JLPassword=new JLabel("����:");
    JTextField JTPassword=new JTextField();
    JLabel JLsex=new JLabel("�Ա�:");
    ButtonGroup BG=new ButtonGroup();
    JRadioButton JRB1=new JRadioButton("��");
    JRadioButton JRB2=new JRadioButton("Ů");
	JLabel JL2=new JLabel("�ֻ��ţ�");
	JTextField JT2=new JTextField();
	JLabel JLrole=new JLabel("��ɫ:");
	ButtonGroup BG2=new ButtonGroup();
    JRadioButton JRole1=new JRadioButton("����Ա");
    JRadioButton JRole2=new JRadioButton("�û�");
	JButton JBAdd=new JButton("ע��");
	JButton JBNext=new JButton("����");
	JButton JBExit=new JButton("�˳�");
	String sql="";
	public register()
	{
		this.setTitle("ע����Ϣ");
		this.setLayout(null);
		JL.setForeground(Color.blue);
		JL.setFont(new java.awt.Font("����",Font.PLAIN,19));
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
			String ssex="Ů";
			if(JRB1.isSelected())
				ssex="��";
			String sphone=JT2.getText();
			String sRole="�û�",sql;
			if(JRole1.isSelected())
				ssex="����Ա";
			
			sql="select * from user_table where ID='"+snumber+"'";
			System.out.println("���ݿ����ʧ��1"+sql);
			try {
				Class.forName("com.hxtt.sql.access.AccessDriver");
				Connection cot=DriverManager.getConnection("jdbc:Access:///D:/gbc.mdb");
				Statement stm=cot.createStatement();
				ResultSet rs=stm.executeQuery(sql);
				if(rs.next())
					JOptionPane.showMessageDialog(null,"�ú��Ѿ����ڣ�");
				else{
					sql="insert into user_table values('"+snumber+"','"
							+sname+"','','"+ssex+"','"+sphone+"','"+sRole+"')";
					System.out.println(""+sql);
					int i=stm.executeUpdate(sql);
		         if(i>0)JOptionPane.showMessageDialog(null,"��ӳɹ���");
		         else JOptionPane.showMessageDialog(null,"���ʧ�ܣ�");
				}
			}catch(Exception ee) {
				System.out.println("���ݿ����ʧ��");
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
