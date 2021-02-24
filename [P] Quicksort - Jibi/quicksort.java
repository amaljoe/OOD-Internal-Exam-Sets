import java.util.*;

public class quicksort {
    static ArrayList<String> a = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k, n;
        String b;

        System.out.println("Enter the number of elements:\n");
        n = sc.nextInt();
        System.out.println("Enter the elements:\n");
        for (k = 0; k < n; k++) {
            b = sc.next();
            a.add(b);
        }
        sort1(0, n - 1);
        System.out.println("The sorted array is:\n");
        for (k = 0; k < n; k++)
            System.out.println("\t" + a.get(k));
    }

    public static int partition(int l, int h) {
        int i, j;
        String  pivot;
        pivot = a.get(l);
        i = l;
        j = h;
        while (i < j) {
            while(( i<a.size())&&(( a.get(i).compareTo(pivot))<=0))
                i++;
            while ((j<a.size())&&(( a.get(j).compareTo(pivot))>0))
                j--;
            if (i < j) {
               {
                   Collections.swap(a,i,j);
                  
               }

            }
        }
        Collections.swap(a, l, j);

        return j;
    }

    static void sort1(int l, int h) {
        int j;
        if (l < h) {
            j = partition(l, h);
            sort1(l, j);
            sort1(j + 1, h);

        }
    }
}