package softwareEngineering;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class CSV {
    public static void main(String[]args) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(new File("userInfo.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append("Name");
        sb.append(',');
        sb.append("Shipping");
        sb.append(',');
        sb.append("Billing");
        sb.append(',');
        sb.append("Credit Card");
        sb.append('\n');

        sb.append("John Travolta");
        sb.append(',');
        sb.append("1234 Newton Rd. Manhattan New York 30011");
        sb.append(',');
        sb.append("1234 Newton Rd. Manhattan New York 30011");
        sb.append(',');
        sb.append("1234567890");
        sb.append('\n');

        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
    }
}