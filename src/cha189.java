import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class cha189 {
    private static final int SIZE = 1024;
    public static void main(String[] args) throws IOException {
        FileChannel in = new FileInputStream("F:\\text.txt").getChannel(),
                    out = new FileOutputStream("F:\\test.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(SIZE);
        while(in.read(buffer) != -1){
            //写准备
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }

    }
}
