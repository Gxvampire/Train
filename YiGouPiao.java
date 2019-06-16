package Huochepiao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
public class YiGouPiao extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel JL=new JLabel("已购票查询",JLabel.CENTER);
	    JLabel JLId=new JLabel("车票信息:");
	    JTextArea JTId=new JTextArea();
	    String sql="";
	    String str="tid\tuid\tstarter\treacher\tstartTime\tendTime\tdate\tprice";
	          //  +"\nK120\t济南\t连云港\t36\t12:25\t16:20\t25\t2019/05/25\t185";
	JButton JBNext=new JButton("显示 ");
	JButton JBExit=new JButton("退出");
	public YiGouPiao()
	{
		this.setTitle("票务信息");
		this.setLayout(null);
		JL.setForeground(Color.blue);
		JL.setFont(new java.awt.Font("宋体",Font.PLAIN,22));
		JL.setBounds(300, 30, 200, 40);
		this.add(JL);

		JLId.setBounds(100,80,100,20);
		this.add(JLId);
		JTId.setText(str);
		JTId.setBounds(20,140,750,100);
		this.add(JTId);

		JBNext.setBounds(190,320,90,20);
		this.add(JBNext);
		JBNext.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e) {
	    		sql="select * from piao_table ";
	    		try {
	    			Class.forName("com.hxtt.sql.access.AccessDriver");
	    			Connection cot=DriverManager.getConnection("jdbc:Access:///D:/gbc.mdb");
	    			Statement stm=cot.createStatement();
	    			ResultSet rs=stm.executeQuery(sql);
	    			String s = new String();
	    			String s1  = "";
	    			
	    					while (rs.next()) {
	    						//System.out.println("++++");
	    						//JTId.setText(str);
	    						for (int i=1; i<9; i++) {
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
		
		JBExit.setBounds(300,320,90,20);
		this.add(JBExit);
		JBExit.addActionListener(this);
		this.setBounds(10,10,820,400);
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
	new YiGouPiao();
	
}
}                 
