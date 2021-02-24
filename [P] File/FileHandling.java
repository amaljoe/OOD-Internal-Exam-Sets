import java.io.*;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) throws IOException {
        File file = new File("J:/Workstation/College Works/OOD-Internal-Exam-Sets/[P] File/names.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            String values[] = sc.nextLine().split(" ");
            System.out.println("name = " + values[0] + ", age = " + values [1]);
        }
    }
}