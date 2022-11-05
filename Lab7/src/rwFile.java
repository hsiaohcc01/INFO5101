import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  Assignment 7
 *  HsiaoChing Chen
 *  002749406
 *  Section 08
 */

public class rwFile {

    private String rFileName;
    private String wFileName;

    public List<String> readFile(String filename) {

        // check the file name contains ".cvs" or not
        String path;
        if(filename.contains(".csv")){
            path = filename;
        } else {
            path = filename + ".csv";
        }

        // create an array to store data from read
        List<String> record = new ArrayList<>();
        try{
            String line;
            BufferedReader br = new BufferedReader(new FileReader(path));

            // read data and store into array
            while ((line = br.readLine()) != null) {
                record.add(line);
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
        return record;
    }

    public void writeFile(String fileName, List<String> record) {

        // check the file name contains ".cvs" or not
        String path;
        if (fileName.contains(".csv")) {
            path = fileName;
        } else {
            path = fileName + ".csv";
        }

        try{
            FileWriter fw = new FileWriter(fileName, false);
            if (record != null){
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                StringBuilder sb = new StringBuilder();

                // write data form 1~3 rows
                for(String line: record) {
                    String[] values = line.split(",");
                    sb.setLength(0);
                    for(int i = 0; i < 3; i++) {
                        sb.append(values[i]);
                        if( i != 2) {
                            sb.append(",");
                        }
                    }
                    pw.println(sb);
                }
                pw.flush();
                pw.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // set the read file name
    public void rsetName(String rFileName){
        this.rFileName = rFileName;
    }

    // get the read file name
    public String rgetName(){
        return rFileName;
    }

    // set the write file name
    public void wsetName(String wFileName){
        this.wFileName = wFileName;
    }

    // get the write file name
    public String wgetName(){
        return wFileName;
    }

}