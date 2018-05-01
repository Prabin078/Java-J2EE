import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class testFrame
{
    JLabel lblSource , lblDest;
    JTextField txtSource, txtDest;
    JButton startButton, stopButton;
    JPanel p1;
    JFrame frm;
    JTextArea textArea;
    JScrollPane scroll;
    JProgressBar progressBar;
    String source, dest;

    public void prepareGUI()
    {
      lblSource  = new JLabel("Source File: ");
      lblDest = new JLabel("Destination File: ");

      txtSource = new JTextField(10);
      txtDest = new JTextField(10);

      startButton = new JButton("Copy");
      stopButton = new JButton("Stop");

      textArea = new JTextArea("",10,30);
      textArea.setLineWrap(true);

      scroll = new JScrollPane(textArea);

      p1 = new JPanel();
      p1.setLayout(new FlowLayout());
      p1.add(lblSource);
      p1.add(txtSource);
      p1.add(lblDest);
      p1.add(txtDest);
      p1.add(startButton);
      p1.add(scroll);

      frm = new JFrame("Login!");
      frm.add(p1);
      frm.setSize(800,800);
      frm.setLayout(new GridLayout(3, 1));
      frm.setVisible(true);
    }

    public void setActions()
    {
      frm.addWindowListener(new WindowAdapter(){
          public void windowClosing(WindowEvent winEvt)
          {
              System.exit(0);
          }
      });

      startButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            source = txtSource.getText();
            dest = txtDest.getText();
            copyFiles(source, dest);
            showProgressBar();
         }
      });

      stopButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            hideProgressBar();
            displayContents(dest);
         }
      });
    }

    public void showProgressBar()
    {
        progressBar = new JProgressBar(0,100);
        progressBar.setString("Copying");
        progressBar.setVisible(true);
        progressBar.setStringPainted(true);
        progressBar.setIndeterminate(true);
        p1.add(progressBar);
        p1.add(stopButton);
        frm.setVisible(true);
     }

     public void hideProgressBar(){
       progressBar.setVisible(false);
       stopButton.setVisible(false);
     }

    public testFrame()
    {
        prepareGUI();
        setActions();
    }

    public void copyFiles(String src, String dest) {
      try {
        InputStream in = new FileInputStream(new File(src));
        OutputStream out = new FileOutputStream(new File(dest));
        byte[] buf = new byte[1024];
        int len;

        while ((len = in.read(buf)) > 0)
          out.write(buf, 0, len);

        in.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }

    public void displayContents(String dest){
        try {
          String content = new Scanner(new File(dest)).useDelimiter("\\Z").next();
          textArea.setText(content);
        }
        catch(Exception e){
          e.printStackTrace();
        }

    }

    public static void main(String[] args) {
      testFrame frmLogin = new testFrame();
    }
}