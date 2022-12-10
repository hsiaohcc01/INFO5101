import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements  ActionListener{

    private JPanel jp1,jp2,jp3;
    private JLabel label1,label2;
    private JTextField jtext;
    private JButton jblog,jbout;
    private JPasswordField jpassword;
    private ImageIcon banner = new ImageIcon(new ImageIcon("banner.png").getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT));
    private JLabel label3 = new JLabel(banner);

    public static void main(String[] args){
        new Login();
    }

    public Login(){

        this.add(label3);
        this.setTitle("Student Management System");
        this.setSize(500,500);
        this.setLocation(200,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(0,1));

        jp1 = new JPanel();
        label1 = new JLabel("Username");
        jtext = new JTextField(10);
        jp1.add(label1);
        jp1.add(jtext);
        this.add(jp1);

        jp2 = new JPanel();
        label2 = new JLabel("Password");
        jpassword = new JPasswordField(10);
        jp2.add(label2);
        jp2.add(jpassword);
        this.add(jp2);

        jp3 = new JPanel();
        jblog = new JButton("Login");
        jbout = new JButton("Exit");
        jp3.add(jblog);
        jp3.add(jbout);
        this.add(jp3);

        this.setVisible(true);

        jblog.addActionListener((ActionListener) this);
        jbout.addActionListener((ActionListener) this);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == jblog){
            String account = jtext.getText();
            String password  = new String(jpassword.getPassword());

            if(account.equals("admin") && password.equals("123456")){
                JOptionPane.showMessageDialog(this, "Manager Login Success!");
                this.dispose();
                new Manager();
            }
            else{
                JOptionPane.showMessageDialog(this, "Login Fail! Please Enter the correct information.");
            }
        }else if(e.getSource() == jbout){
            JOptionPane.showMessageDialog(this,"Exit the System");
            System.exit(0);
        }
    }
}
