package b_10171;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class b_10171 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("\\    /\\");
        bw.write("\n");
        bw.write(" )  ( ')");
        bw.write("\n");
        bw.write("(  /  )");
        bw.write("\n");
        bw.write(" \\(__)|");
        bw.flush();
        bw.close();
    }
}
