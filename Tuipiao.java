package Huochepiao;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

public class Tuipiao extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel JL=new JLabel("��Ʊ",JLabel.CENTER);
	JLabel JLId=new JLabel("�ѹ���ĳ�Ʊ:");
	JTextArea JTId=new JTextArea();
	//JLabel JLDate=new JLabel("��Ʊ��ʷ:");
	//JTextArea JTDate=new JTextArea();
	    
	JButton JBSet=new JButton("��ѡ");
	JButton JBNext=new JButton("��ʾ ");
	JButton JBExit=new JButton("�˳�");
	String sql="";
	String str="tid\tstarter\treacher\tstartTime\tendTime\tdate\tprice";
		//	+"\nK120\t����\t���Ƹ�\t36\t12:25\t16:20\t25\t2019/05/25\t185";
	public Tuipiao()
	{
		this.setTitle("��Ʊ");
		this.setLayout(null);
		JL.setForeground(Color.blue);
		JL.setFont(new java.awt.Font("����",Font.PLAIN,22));
		JL.setBounds(100, 30, 400, 40);
		this.add(JL);
		
		JLId.setBounds(100,80,100,20);
		this.add(JLId);
		JTId.setText(str);
		JTId.setBounds(20,110,750,50);
		this.add(JTId);
		//JLDate.setBounds(100,170,80,20);
		//this.add(JLDate);
		//JTDate.setBounds(20,200,750,50);
		//this.add(JTDate);

		
		JBSet.setBounds(80,170,90,20);
		this.add(JBSet);
		JBSet.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e) {
	    		//String s=JTId.getText();
	    		//JTDate.append(s);
	    		//JTId.setText(null);
	    		sql="select * from piao_table" ;
	    		System.out.println("���ݿ����ʧ��1"+sql);
	    		try {
	    			Class.forName("com.hxtt.sql.access.AccessDriver");
	    			Connection cot=DriverManager.getConnection("jdbc:Access:///D:/gbc.mdb");
	    			Statement stm=cot.createStatement();
	    			ResultSet rs=stm.executeQuery(sql);
	    			if(rs.next())
	    				System.out.println(""+sql);
	    			sql="delete from piao_table";
	    				int i=stm.executeUpdate(sql);
	    	         if(i>0)JOptionPane.showMessageDialog(null,"��Ʊ�ɹ���");
	    	         else JOptionPane.showMessageDialog(null,"��Ʊʧ�ܣ�");
	    		}catch(Exception ee) {
	    			System.out.println("���ݿ����ʧ��");
	    			ee.printStackTrace();
	    		}
	    	}
	    	});
		
		JBNext.setBounds(190,170,90,20);
		this.add(JBNext);
		JBNext.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e) {
	    		sql="select * from piao_table ";
	    		System.out.println("���ݿ����ʧ��1"+sql);
	    		try {
	    			Class.forName("com.hxtt.sql.access.AccessDriver");
	    			Connection cot=DriverManager.getConnection("jdbc:Access:///D:/gbc.mdb");
	    			Statement stm=cot.createStatement();
	    			ResultSet rs=stm.executeQuery(sql);
	    			String s = new String();
	    			String s1  = "";
	    			
	    					while (rs.next()) {
	    						//System.out.println("++++");
	    						JTId.setText(str);
	    						for (int i=1; i<8; i++) {
	    							s = rs.getString(i) + "\t";
	    							s1 += s;
	    						}
	    						s = "\n";
	    						s1 += s;

	    					}
	    					JTId.append("\n"+s1);
	    				} catch (Exception ee) {
	    					ee.printStackTrace();
	    					JTId.append(null);
	    				}
	    		
	    	}		
});
		
		JBExit.setBounds(300,170,90,20);
		this.add(JBExit);
		JBExit.addActionListener(this);
		this.setBounds(10,10,800,300);
		this.setVisible(true);
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
	new Tuipiao();
}

}                                                     
