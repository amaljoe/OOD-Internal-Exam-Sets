import java.io.*;
import java.util.*;

public class mynew {
    public static void main(String[] args) throws IOException {
        File f = new File("myfile.txt");
        Scanner s = new Scanner(f);
        String name[] = new String[20];
        int age[] = new int[20];
        int i = 0;
        while (s.hasNext()) {
            String value[] = s.nextLine().split(" ");
            name[i] = value[0];
            age[i] = Integer.parseInt(value[1]);

            System.out.println(name[i]);
            System.out.println(age[i]);
            i = i + 1;

        }
        System.out.println(i);

    }
}