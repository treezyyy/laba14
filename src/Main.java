import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("gg.txt"));
            BufferedWriter fl = new BufferedWriter(new FileWriter("newFile.txt"))){

            int s;
            StringBuffer prinyat = new StringBuffer();
            while((s = br.read())!=-1){
                prinyat.append((char) s);
            }

            Pattern pattern = Pattern.compile("(/\\*.*?\\*/)|(//[^\n]*)", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(prinyat.toString());
            StringBuffer izmenen =new StringBuffer(matcher.replaceAll(""));
            fl.write(izmenen.toString());
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}