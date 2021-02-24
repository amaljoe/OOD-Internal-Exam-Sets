import java.io.*;
import java.util.*;

public class telephone {
    String name;
    String num;

    telephone(String name, String num) {
        this.name = name;
        this.num = num;

    }

    public String toString() {
        return name + "-" + num + "\n";
    }

    public static void main(String[] args) throws IOException {
        // read the contents of file
        File file = new File("telephone.txt");
        FileWriter fw = new FileWriter(file);

        int read;
        ArrayList<telephone> ppl = new ArrayList<telephone>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of people");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String num = sc.next();
            telephone tele = new telephone(name, num);
            tele.toString();
            ppl.add(tele);
            fw.append(tele.toString() + "\n");
        }
        fw.close();

        // wrote contents.......
        ArrayList<telephone> ppls = new ArrayList<telephone>();
        FileReader fr = new FileReader(file);
        String name = "";
        String num = "";
        int i = 0;
        while ((read = fr.read()) != -1) {
            char ch = (char) read;
            if (ch == '\n') {
                i = 0;
                System.out.println(name);
                System.out.println(num);
                ppls.add(new telephone(name, num));
                name = "";
                num = "";

            } else {
                if (ch == '-') {
                    i++;
                } else {
                    switch (i) {
                        case 0: {
                            name += ch;
                            break;
                        }
                        case 1: {
                            num += ch;
                            break;
                        }

                    }
                }
            }
        }

        ppls.add(new telephone(name, num));
        fr.close();

        SortByName a = new SortByName();
        ppls.sort(a);
        FileWriter fw1 = new FileWriter(file);
        ListIterator<telephone> itr = ppls.listIterator();
        while (itr.hasNext()) {
            telephone t = itr.next();
            System.out.println(t.name);
            fw1.append(t.toString() + "\n");
        }
        fw1.close();
        // ListIterator<telephone> itr = ppls.listIterator();
        // FileWriter fw1 = new FileWriter(file);
        // while (itr.hasNext()) {
        // telephone t = itr.next();
        // System.out.println(t.name);
        // fw1.append(t.toString() + "\n");
        // }
        // fw1.close();

    }

}

class SortByName implements Comparator<telephone> {
    public int compare(telephone a, telephone b) {
        return a.name.compareTo(b.name);
    }
}