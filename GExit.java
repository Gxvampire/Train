package Huochepiao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GExit extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel JLInfo=new JLabel("�˳����棿");
	JButton JBExit=new JButton("�˳�");
	JButton JBNE=new JButton("ȡ��");
	String sql="";
	public GExit()
	{
		this.setTitle("�˳�����");
		this.setLayout(null);
		JLInfo.setForeground(Color.black);
		JLInfo.setFont(new java.awt.Font("����",Font.PLAIN,22));
		JLInfo.setBounds(100, 40, 200, 40);
		this.add(JLInfo);
		JBExit.setBounds(80,100,90,20);
		this.add(JBExit);
		JBExit.addActionListener(this);
		JBNE.setBounds(190,100,90,20);
		this.add(JBNE);
		JBNE.addActionListener(this);
		this.setBounds(10,10,400,250);
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
			System.exit(0);
		}
	    if(e.getSource()==JBNE)
	    {
		    setVisible(false);
	    }
    }
public static void main(String args[]) {
	new GExit().setVisible(true);
}

}                                                     
