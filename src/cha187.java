import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class cha187 extends ArrayList<String>{

	public static String read(String filename) {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(filename).getAbsoluteFile()));
			try {
				String s;
				while ((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("\n");
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
	
	public static void write(String filename, String text) {
		try {
			PrintWriter out = new PrintWriter(new File(filename).getAbsolutePath());
			try {
				out.print(text);
			} finally {
				// TODO: handle finally clause
				out.close();
			}
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public cha187(String filename, String splitter) {
		super(Arrays.asList(read(filename).split(splitter)));
		if(get(0).equals(""))
			remove(0);
	}
	
	public cha187(String filename) {
		this(filename, "\n");
	}

	public void write(String filename) {
		// TODO Auto-generated method stub
		try {
			PrintWriter out = new PrintWriter(new File(filename).getAbsolutePath());
			try {
				for(String item : this) {
					out.println(item);
				}
			} finally {
				// TODO: handle finally clause
				out.close();
			}
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = read("F:\\text.txt");
		write("F:\\test.txt", file);
		cha187 text = new cha187("F:\\text.txt");
		text.write("F:\\test2.txt");
		TreeSet<String> words = new TreeSet<>(new cha187("F:\\text.txt", "\\w+"));
		System.out.println(words.headSet("a"));

	}

}
