package Huochepiao;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;






//import java.util.*;
//import javax.swing.event.*;
import java.sql.*;

public class Delete extends JFrame implements ActionListener{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel JL=new JLabel("删除火车信息",JLabel.CENTER);
     JLabel JLId=new JLabel("车票信息:");
     JTextArea JTId1=new JTextArea();
     JTextArea JTId=new JTextArea();
     String str="tid\tstarter\treacher\tticketNumber\tstartTime\tendTime\tseatIdNumber\tbusDate\tprice";
     JButton JBDel=new JButton("删除 ");
     JButton JBNext=new JButton("显示 ");
     JButton JBExit=new JButton("退出 ");
     String sql="";
     public Delete() 
{
    Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
	Border border2 = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
    this.setTitle("删除火车信息");
    this.setLayout(null);
    JL.setForeground(Color.blue);
    JL.setFont(new java.awt.Font("宋体",Font.PLAIN,22));
    JL.setBounds(300, 30, 200, 40);
    this.add(JL);

    JLId.setBounds(100,80,100,20);
    this.add(JLId);
    JTId1.setBorder(border2);
    JTId1.setBounds(20,110,750,20);
    this.add(JTId1);
    JTId1.setText(str);
    JTId.setBorder(border2);
    JTId.setBounds(20,130,750,130);
    this.add(JTId);

    JBDel.setBounds(80,280,90,30);
    this.add(JBDel);
    JBDel.setBorder(border);
    JBDel.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
    		JTId.setText(null);
    		sql="select * from train_table" ;
    		System.out.println("数据库操作失败1"+sql);
    		try {
    			Class.forName("com.hxtt.sql.access.AccessDriver");
    			Connection cot=DriverManager.getConnection("jdbc:Access:///D:/gbc.mdb");
    			Statement stm=cot.createStatement();
    			ResultSet rs=stm.executeQuery(sql);
    			if(rs.next())
    				System.out.println(""+sql);
    			sql="delete from train_table where ticketNumber=''";
    				int i=stm.executeUpdate(sql);
    	         if(i>0)JOptionPane.showMessageDialog(null,"删除成功！");
    	         else JOptionPane.showMessageDialog(null,"删除失败！");
    		}catch(Exception ee) {
    			System.out.println("数据库操作失败");
    			ee.printStackTrace();
    		}
    	}
    	});
    JBNext.setBounds(190,280,90,30);
    this.add(JBNext);
    JBNext.setBorder(border);
    JBNext.addActionListener(new ActionListener(){
    	    	public void actionPerformed(ActionEvent e) {
    	    		sql="select * from train_table ";
    	    		System.out.println("数据库操作失败1"+sql);
    	    		try {
    	    			Class.forName("com.hxtt.sql.access.AccessDriver");
    	    			Connection cot=DriverManager.getConnection("jdbc:Access:///D:/gbc.mdb");
    	    			Statement stm=cot.createStatement();
    	    			ResultSet rs=stm.executeQuery(sql);
    	    			String s = new String();
    	    			String s1  = "";
    	    			
    	    					while (rs.next()) {
    	    						for (int i=1; i<10; i++) {
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
    JBExit.setBounds(300,280,90,30);
    this.add(JBExit);
    JBExit.setBorder(border);
    JBExit.addActionListener(this);
    this.setBounds(300,10,800,400);

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
	new Delete();
}

}
