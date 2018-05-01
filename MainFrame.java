import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame{
	
	private static AddForm addForm;
	private static DisplayForm showForm;
	private static Container c;
	MainFrame()
	{
		super("Forms JDBC");
		c = getContentPane();
		setDefaultFrame();
		addForm = new AddForm();
		showForm = new DisplayForm();
		setSize(200,400);
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent w)
			{
				System.exit(0);
			}
		});
	}
	
	static void setDefaultFrame()
	{
		c.removeAll();
		JButton btn1 = new JButton("Insert Data");
		JButton btn2 = new JButton("Display Representatives");
		JPanel mainPanel = new JPanel();
		mainPanel.add(btn1);
		mainPanel.add(btn2);
		mainPanel.setLayout(new GridLayout(0,1));
		c.add(mainPanel);
		c.revalidate();
		c.repaint();
		
		
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c.removeAll();
				c.add(addForm);
				c.revalidate();
				c.repaint();
			}
			
		});
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c.removeAll();				
				showForm.display();
				c.add(showForm);
				c.revalidate();
				c.repaint();
			}
			
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
		
	}
}
