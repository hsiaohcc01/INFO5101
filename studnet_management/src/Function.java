import java.io.*;
import java.util.*;

class Function {

    ArrayList<student_information> array = new ArrayList<student_information>();
	public Function()
	{
		this.readfile();
	}

	public int find(String str) 
	{
		for(int i = 0; i<array.size(); i++)
			if(array.get(i).getStuID().equals(str))
				return i;
		return -1;
	}

	public void update(student_information stu){
		int flag = find(stu.getStuID());
		array.set(flag, stu);
	}	

	public boolean readfile() {
			String t = null;
			try{
				FileReader f1 = new FileReader("student.txt");
				BufferedReader br = new BufferedReader(f1);
				array.clear();
				while((t= br.readLine())!= null){
					String [] s=t.split("\\s+");
					student_information st = new student_information(s[0],s[1],s[2],s[3],s[4],s[5],s[6]);
					array.add(st);
					System.out.println("Read File");
					System.out.println(s[0]);
				}
				f1.close();
				br.close();
				return true;
			}catch(IOException e){
				e.printStackTrace();
				return false;
			}
	}

	public boolean add(student_information stu){
		System.out.println();
		System.out.println("Add List");
		System.out.println(stu.fileString());
		System.out.println();
		if (find(stu.getStuID())!=-1) return false;
		array.add(stu);
		return true;			
	}

	public boolean writefile(){
		FileWriter fw = null;
		BufferedWriter out = null;
		try{
			fw = new FileWriter("student.txt");
			out = new BufferedWriter(fw);
			for(int i = 0; i<array.size(); i++){
				String s=array.get(i).fileString();
				System.out.println("data:");
				System.out.println(array.get(i).fileString());
				out.write(s);
				out.newLine();
			}
			out.close();
			fw.close();
			return true;
		}catch(IOException e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(String s){
		int pos=find(s);
		if (pos==-1) return false;
		array.remove(pos);
		return true;
	}
}
	
