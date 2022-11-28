import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.*;   
public class SwingTest { 
	private void makeFrameFullSize(JFrame aFrame) {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    aFrame.setSize(screenSize.width, screenSize.height);
	}
	/*public static void main(String[] args) {  
	JFrame f=new JFrame();//creating instance of JFrame     
	String word = "3" + "\u02D9";
	JButton b=new JButton("click");//creating instance of JButton  
	JLabel text = new JLabel(word);
	text.setFont(new Font("Arial", Font.PLAIN, 24));
	text.setBounds(50,50, 100,30); 
	b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
	       SwingTest t = new SwingTest();   
	f.add(b);//adding button in JFrame 
	f.add(text);
	  t.makeFrameFullSize(f);        
	//f.setSize(800,800);//400 width and 500 height  
	f.setLayout(null);//using no layout managers  
	f.setVisible(true);//making the frame visible  
	*//*String fonts[]
	        = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

	for (int i = 0; i < fonts.length; i++) {
	    System.out.println(fonts[i]);
	}*/
	//}  
}
