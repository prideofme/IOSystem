import java.io.*;
import java.util.Random;

public class char1812 implements Serializable{

    private static Random rand = new Random(47);
    private Data[] d = {
      new Data(rand.nextInt(10)),
      new Data(rand.nextInt(10)),
      new Data(rand.nextInt(10))
    };
    private char1812 next;
    private char c;

    public char1812(int i, char x){
        System.out.println("char1812 constuctor: " + i);
        c = x;
        if(--i > 0)
            next = new char1812(i, (char)(x+1));
    }
    public char1812(){
        System.out.println("Default constructor");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for (Data dat : d){
            result.append(dat);
        }
        result.append(")");
        if(next != null)
            result.append(next);
        return result.toString();
    }

    public static void main(String[] args) throws Exception{
        char1812 ch = new char1812(6,'a');
        System.out.println("ch = " + ch);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("F:\\test.txt"));
        out.writeObject("char1812 storage\n");
        out.writeObject(ch);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("F:\\test.txt"));
        String s = (String) in.readObject();
        char1812 ch2 = (char1812) in.readObject();
        System.out.println(s + "CH2 =  " + ch2);

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("char1812 storage\n");
        out2.writeObject(ch);
        out2.flush();
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        s = (String) in2.readObject();
        char1812 ch3 = (char1812)in2.readObject();
        System.out.println(s + "CH3 =  " + ch3);
    }
}
class Data implements Serializable{
    private int n;
    public Data(int n) {this.n = n;}
    public String toString() {return Integer.toString(n);}
}