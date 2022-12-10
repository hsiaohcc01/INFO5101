import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.io.*;
import java.util.Vector;

public class show_all {
	JTable table ;
    DefaultTableModel model;

   public show_all() {

	    JFrame jf = new JFrame("Student Information");
		JPanel panel = new JPanel();
		Vector columnNames = createColumnNames();
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
		jf.setSize(900, 600);
		jf.add(scrollPane, BorderLayout.CENTER);

		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
			
		jf.setLocationRelativeTo(null);
		int t = table.getRowCount();
		if(t <= 0){
			JOptionPane.showMessageDialog(null, "No Student Information");
			jf.setVisible(false);
		}else{
			jf.setVisible(true);
		}
   }

   private Vector createColumnNames(){
	   Vector columnNames = new Vector();
       columnNames.add("Student ID");
       columnNames.add("Name");
       columnNames.add("Gender");
       columnNames.add("Age");
       columnNames.add("Phone");
       columnNames.add("Address");
	   columnNames.add("Identify ID");
       return columnNames;
   }

   private Vector createTableModelData() {

	   Vector data = new Vector();
	   String t;
	   try{
		   FileReader f1 = new FileReader("student.txt");
		   BufferedReader br = new BufferedReader(f1);
		   int i = 0;
		   while((t = br.readLine()) != null){
			   String [] s=t.split("\\s+");
			   Vector rowData = new Vector();
			   rowData.add(s[0]);
			   rowData.add(s[1]);
			   rowData.add(s[2]);
			   rowData.add(s[3]);
			   rowData.add(s[4]);
			   rowData.add(s[5]);
			   rowData.add(s[6]);
			   data.add(rowData);
			   i++;
		   }
		   f1.close();
		   br.close();
	   }catch(IOException e){
		   e.printStackTrace();
	   }
	   return data;
   }
}
	

	       

	
