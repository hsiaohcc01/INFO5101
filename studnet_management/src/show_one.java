import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class show_one {
		ArrayList<student_information> array = new ArrayList<student_information>();
		JTable table = null;
	    DefaultTableModel model = null;

	   public show_one() {
		   JFrame jf = new JFrame("Student Information");
		   JPanel panel = new JPanel();
		   Vector columnNames = createColumnNames();

		   String [] f = new String [7];

		   try{
			   FileReader f1 = new FileReader("TEMP.txt");
			   BufferedReader br = new BufferedReader(f1);
			   String t = null;
			   while ((t = br.readLine())!= null){
				   f = t.split("\\s+");
			   }
			   f1.close();
			   br.close();
		   }catch(IOException e){
			   e.printStackTrace();
		   }

		   File file = new File("TEMP.txt");
		   try{
			   if(!file.exists()){
				   file.createNewFile();
			   }

			   FileWriter fileWriter = new FileWriter(file);
			   fileWriter.write("");
			   fileWriter.flush();
			   fileWriter.close();

		   }catch(IOException e){
			   e.printStackTrace();
		   }

		   ArrayList List = new ArrayList();
		   for(int i=0; i<7; i++) {
			   if(!f[i].equals("--"))
				   List.add(i);
		   }

		   for(int i=0; i<List.size(); i++)
			   System.out.println(List.get(i));

		   try{
			   FileReader f1 = new FileReader("student.txt");
			   BufferedReader br = new BufferedReader(f1);
			   String t = null;
			   int flag = 0;
			   int t1 = 0;

			   array.clear();
			   while((t= br.readLine())!= null){
				   String [] s = t.split("\\s+");
				   for(int i=0; i<List.size(); i++){
					   t1 = (int) List.get(i);
					   if(f[t1].equals(s[t1])){
						   flag = flag+1;
					   }
				   }

				   if(flag == List.size()){
					   student_information st = new student_information(s[0],s[1],s[2],s[3],s[4],s[5],s[6]);
					   array.add(st);
				   }

				   flag=0;
			   }
			   f1.close();
			   br.close();
		   }catch(IOException e){
			   e.printStackTrace();
		   }

		   Vector data = createTableModelData();

		   model = new DefaultTableModel(data, columnNames);
		   table = new JTable(model);

		   table.setPreferredScrollableViewportSize(new Dimension(400, 80));
		   table.setForeground(Color.BLACK);
		   table.setFont(new Font(null, Font.PLAIN, 14));
		   table.setSelectionForeground(Color.DARK_GRAY);
		   table.setSelectionBackground(Color.LIGHT_GRAY);
		   table.setGridColor(Color.GRAY);

		   table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));
		   table.getTableHeader().setForeground(Color.RED);
		   table.getTableHeader().setResizingAllowed(false);
		   table.getTableHeader().setReorderingAllowed(false);

		   table.setRowHeight(40);
		   table.getColumnModel().getColumn(0).setPreferredWidth(40);
		   table.setPreferredScrollableViewportSize(new Dimension(900, 320));

		   RowSorter sorter = new TableRowSorter(model);
		   table.setRowSorter(sorter);
		   JScrollPane scrollPane = new JScrollPane(table);

		   panel.add(scrollPane);
		   jf.setContentPane(panel);
		   jf.pack();
		   jf.setSize(900, 400);
		   jf.add(scrollPane, BorderLayout.CENTER);

		   DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		   r.setHorizontalAlignment(JLabel.CENTER);
		   table.setDefaultRenderer(Object.class, r);

		   jf.setLocationRelativeTo(null);
		   int t = array.size();

		   if(t == 0){
			   JOptionPane.showMessageDialog(null, "Didn't have this student.");
			   jf.setVisible(false);
		   }else{
			   jf.setVisible(true);
		   }
	   }

	   private Vector createColumnNames() {
		   Vector columnNames = new Vector();
		   columnNames.add("Student ID");
		   columnNames.add("Name");
		   columnNames.add("Gender");
		   columnNames.add("Age");
		   columnNames.add("Phone");
		   columnNames.add("Address");
		   return columnNames;
       }

	   private Vector createTableModelData(){
		   Vector data = new Vector();
		   for(int i=0; i<array.size(); i++){
			   Vector<String> rowData=new Vector<>();
			   rowData.add(array.get(i).getStuID());
			   rowData.add(array.get(i).getName());
			   rowData.add(array.get(i).getGender());
			   rowData.add(array.get(i).getAge());
			   rowData.add(array.get(i).getPhone());
			   rowData.add(array.get(i).getAddress());
			   rowData.add(array.get(i).getIdentityID());
			   data.add(rowData);
		  }	   
         return data;
	  }
}
