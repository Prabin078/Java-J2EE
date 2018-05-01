import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class AddForm extends JPanel{
	
	private JTextField txtCustName;
	private JTextField txtCustState;
	private JTextField txtCreditLimit;
	private JTextField txtCustRepNo;
	private JLabel lblCustId;
	private JLabel lblCustName;
	private JLabel lblCustState;
	private JLabel lblCreditLimit;
	private JLabel lblCustRepNo;
	private JButton btnAddCust;
	private JTextField txtRepName;
	private JTextField txtRepState;
	private JTextField txtComm;
	private JTextField txtRepRate;
	private JLabel lblRepName;
	private JLabel lblRepState;
	private JLabel lblComm;
	private JLabel lblRepRate;
	private JButton btnAddRep,btnBack;
	DBHelper db;
	AddForm()
	{
		db = new DBHelper();
		setupLayout();
		setActions();
	}
	
	void setupLayout(){
		
		lblRepName = new JLabel("Representative Name: ");
		lblRepState = new JLabel("Representative State: ");
		lblComm = new JLabel("Commission: ");
		lblRepRate = new JLabel("Representative Rate: ");
		
		txtRepName = new JTextField(10);
		txtRepState = new JTextField(10);
		txtComm = new JTextField(10);
		txtRepRate = new JTextField(10);
		btnAddRep = new JButton("Add Representative");		
		
		add(lblRepName);add(txtRepName);
		add(lblRepState);add(txtRepState);
		add(lblComm);add(txtComm);
		add(lblRepRate);add(txtRepRate);
		add(btnAddRep);
		
		lblCustName = new JLabel("Customer Name: ");
		lblCustState = new JLabel("Customer State: ");
		lblCreditLimit = new JLabel("Customer Credit Limit: ");
		lblCustRepNo = new JLabel("Representative Number: ");
		
		txtCustName = new JTextField(10);
		txtCustState = new JTextField(10);
		txtCreditLimit = new JTextField(10);
		txtCustRepNo = new JTextField(10);
		btnAddCust = new JButton("Add Customer");		
		
		add(lblCustName);add(txtCustName);
		add(lblCustState);add(txtCustState);
		add(lblCreditLimit);add(txtCreditLimit);
		add(lblCustRepNo);add(txtCustRepNo);
		add(btnAddCust);
		btnBack = new JButton("Back");
		add(btnBack);
		
	}
	
	void setActions()	{
		btnAddRep.addActionListener(new ActionListener()	{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Submitted");
			
				String name = txtRepName.getText();
				String state = txtRepState.getText();
				double comm = Double.parseDouble(txtComm.getText());
				Double rate = Double.parseDouble(txtRepRate.getText());
				try {
					db.insertRep(name, state, comm, rate);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally{
					
				}
			}
		});
		btnAddCust.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
/* TODO Auto-generated method stub */
				System.out.println("Submitted");
				
				String name1 = txtCustName.getText();
				String state = txtCustState.getText();
				double creditLimit = Double.parseDouble(txtCreditLimit.getText());
				int repNo = Integer.parseInt(txtCustRepNo.getText());
				try {
					db.insertCustomer(name1, state, creditLimit, repNo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					
				}
			}
		});
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrame.setDefaultFrame();
			}
			
		});
	}
}
