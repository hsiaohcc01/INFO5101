import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Manager extends JFrame implements ActionListener {

	Function fun = new Function();
	JLabel lb1 = new JLabel("Student Information");

	JTextField id, name, age, phone, address,identify;
	JRadioButton male, female;
	ButtonGroup group = null;

	JButton add, query, delete, modify, show, back;
	JPanel p1, p2, p3, p4, p5, p6, p7, pv, ph, pb;

	public Manager() {
		super("Student Management System");
		id = new JTextField(15);
		name = new JTextField(15);
		age = new JTextField(15);
		phone = new JTextField(15);
		address = new JTextField(15);
		identify = new JTextField(15);

		group = new ButtonGroup();
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		group.add(male);
		group.add(female);

		add = new JButton("Register");
		query = new JButton("Query");
		delete = new JButton("Delete");
		modify = new JButton("Update");
		show = new JButton("Show All");
		back = new JButton("Back to Menu");

		pb = new JPanel();
		pb.add(lb1, JLabel.CENTER);

		p1 = new JPanel();
		p1.add(new JLabel("Student ID", JLabel.CENTER));
		p1.add(id);

		p2 = new JPanel();
		p2.add(new JLabel("Name", JLabel.CENTER));
		p2.add(name);

		p3 = new JPanel();
		p3.add(new JLabel("Gender", JLabel.CENTER));
		p3.add(male);
		p3.add(female);

		p4 = new JPanel();
		p4.add(new JLabel("Age", JLabel.CENTER));
		p4.add(age);

		p5 = new JPanel();
		p5.add(new JLabel("Phone", JLabel.CENTER));
		p5.add(phone);

		p6 = new JPanel();
		p6.add(new JLabel("Address", JLabel.CENTER));
		p6.add(address);

		p7 = new JPanel();
		p7.add(new JLabel("Identify ID", JLabel.CENTER));
		p7.add(identify);

		pv = new JPanel();
		pv.setLayout(new GridLayout(7, 1));
		pv.add(p1);
		pv.add(p2);
		pv.add(p3);
		pv.add(p4);
		pv.add(p5);
		pv.add(p6);
		pv.add(p7);

		ph = new JPanel();
		ph.add(add);
		ph.add(query);
		ph.add(modify);
		ph.add(delete);
		ph.add(show);
		ph.add(back);

		Container con = getContentPane();
		con.setLayout(new BorderLayout());

		con.add(pb, BorderLayout.NORTH);
		con.add(pv, BorderLayout.CENTER);
		con.add(ph, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		setVisible(true);

		student_information stu = new student_information();

		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sID = id.getText();
				if (fun.find(sID) != -1) {
					JOptionPane.showMessageDialog(null, "This Number Already in List\n Please Enter Again");
					id.setText("");
					name.setText("");
					age.setText("");
					phone.setText("");
					address.setText("");
					identify.setText("");
					return;
				}

				String sname = name.getText();
				String sage = age.getText();
				String sphone = phone.getText();
				String saddress = address.getText();
				String sidentify = identify.getText();
				String sgender = null;
				if (male.isSelected()) {
					sgender = male.getText();
				} else {
					sgender = female.getText();
				}

				if (sID.equals("") || sname.equals("") || sage.equals("") || sphone.equals("") || saddress.equals("") || sgender == null || sidentify.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter ALL the Information of Student");
					return;
				}

				stu.setStuID(sID);
				stu.setAge(sage);
				stu.setName(sname);
				stu.setGender(sgender);
				stu.setPhone(sphone);
				stu.setAddress(saddress);
				stu.setIdentityID(sidentify);
				System.out.println(stu.fileString());

				fun.add(stu);
				fun.writefile();

				JOptionPane.showMessageDialog(null, "Register Success");
				setVisible(false);
				new Manager();
			}
		});

		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new show_all();
			}
		});

		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sID = id.getText();
				if (sID.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter the Student's ID");
					return;
				}

//				if (sID.equals(""))
//					sID = "--";

				String sname = name.getText();
				if (sname.equals(""))
					sname = "--";

				String sage = age.getText();
				if (sage.equals(""))
					sage = "--";

				String sphone = phone.getText();
				if (sphone.equals(""))
					sphone = "--";

				String saddress = address.getText();
				if (saddress.equals(""))
					saddress = "--";

				String sidentify = identify.getText();
				if (sidentify.equals(""))
					sidentify = "--";

				String sgender = null;
				if (male.isSelected()) {
					sgender = male.getText();
				} else {
					if (female.isSelected())
						sgender = female.getText();
					else {
						sgender = "--";
					}
				}

				FileWriter fw = null;
				BufferedWriter out = null;
				try {
					fw = new FileWriter("TEMP.txt");
					out = new BufferedWriter(fw);
					out.write(sID + "  ");
					out.write(sname + "  ");
					out.write(sgender + "  ");
					out.write(sage + "  ");
					out.write(sphone + "  ");
					out.write(saddress + "  ");
					out.write(sidentify + "  ");
					out.close();
					fw.close();

				} catch (IOException e1) {
					e1.printStackTrace();
				}

				new show_one();

				id.setText("");
				name.setText("");
				age.setText("");
				phone.setText("");
				address.setText("");
				identify.setText("");
				group.clearSelection();
			}
		});

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sID = id.getText();
				if (sID.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter the Student's ID");
					return;
				}

				int flag = fun.find(sID);
				if (flag == -1 ) {
					JOptionPane.showMessageDialog(null, "Can't Find This Student. Please Enter Again");
				} else {
					fun.delete(sID);
					fun.writefile();
					JOptionPane.showMessageDialog(null, "Delete Success\n");
				}

				id.setText("");
				name.setText("");
				age.setText("");
				phone.setText("");
				address.setText("");
				identify.setText("");
				group.clearSelection();
			}
		});

		modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sID = id.getText();
				if (sID.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter the Student's ID");
					return;
				}

				int flag = fun.find(sID);
				if (flag == -1) {
					JOptionPane.showMessageDialog(null, "Can't Find This Student. Please Enter Again");
					return;
				}

				String sname = name.getText();
				if (sname.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter the Student's Name");
					return;
				}

				String sage = age.getText();
				if (sage.equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Age");
					return;
				}

				String sphone = phone.getText();
				if (sphone.equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter the Phone Number");
					return;
				}

				String saddress = address.getText();
				if (saddress.equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter the Address");
					return;
				}

				String sidentify = identify.getText();
				if (sidentify.equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter the Identity ID");
					return;
				}

				String sgender = null;
				if (male.isSelected()) {
					sgender = male.getText();
				} else {
					sgender = female.getText();
				}

				stu.setStuID(sID);
				stu.setAge(sage);
				stu.setName(sname);
				stu.setGender(sgender);
				stu.setPhone(sphone);
				stu.setAddress(saddress);
				stu.setIdentityID(sidentify);

				fun.update(stu);
				fun.writefile();
				JOptionPane.showMessageDialog(null, "Update Information Success");

				id.setText("");
				name.setText("");
				age.setText("");
				phone.setText("");
				address.setText("");
				identify.setText("");
				group.clearSelection();
			}
		});

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login();
			}
		});
	}

	@Override
	public void actionPerformed (ActionEvent arg0){
	}
}

