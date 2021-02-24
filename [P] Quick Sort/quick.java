import java.util.*;
public class quick{
    public static void main(String args[]){
        quick ob=new quick();
        int k,n;
        int a[]=new int[20];
        Scanner st=new Scanner(System.in);
        System.out.println("Enter the no of elements:");
            n=st.nextInt();
        System.out.println("Enter the element:");
        for(k=0;k<n;k++)
            a[k]=st.nextInt();
        ob.quicksort(a, 0, n-1);
        System.out.println("Sorted  array:");
        for(k=0;k<n;k++)
            System.out.println(a[k]+"\t");
    }
    public static int partition(int a[],int l,int h){
        int i,j,temp,pivot;
        pivot=a[l];
        i=l;
        j=h;
        while(i<j)
       {
           System.out.println(i + "," + j);
        while(i<a.length && a[i]<=pivot)
            i++;
        while(j<a.length && a[j]>pivot)
            j--;
        if(i<j)
        {
            temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }
    }
    temp=a[l];
    a[l]=a[j];
    a[j]=temp;
    return j;
}
    public static void quicksort(int a[],int l,int h){
    int j;
    if(l<h)
    {
        j=partition(a,l,h);
        quicksort(a,l,j);
        quicksort(a,j+1,h);
        
    }
}
}