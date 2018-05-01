import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class DisplayForm extends JPanel{
	
	DBHelper db = new DBHelper();
	private JButton btnBack = new JButton("Back");
	
	DisplayForm()
	{
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrame.setDefaultFrame();
			}
			
		});
	}
	void display()
	{
		this.removeAll();
		DefaultTableModel model = new DefaultTableModel();
		String header[] = {"RepNo","RepName"};
		
		model.setColumnIdentifiers(header);
		
		try
		{
			db.getReps(model);
		}catch(SQLException e){e.printStackTrace();}
		
		
		JTable tbl = new JTable(model);
		tbl.setPreferredScrollableViewportSize(tbl.getPreferredSize());
		
		add(new JScrollPane(tbl));
		add(btnBack);
		
	}

}
