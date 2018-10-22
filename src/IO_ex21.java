import java.io.*;

public class IO_ex21 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null) {
            System.out.println(s.toUpperCase());
        }
        br.close();
    }
}
