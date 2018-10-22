import sun.corba.EncapsInputStreamFactory;

import java.io.*;

public class cha188 {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("F:\\text.txt"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("F:\\test.txt")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null)
            System.out.println(s);
            out.close();
            System.setOut(console);

    }
}
