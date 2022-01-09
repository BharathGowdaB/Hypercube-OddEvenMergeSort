import java.util.Arrays;
import java.util.Scanner;

interface Sorter
{
    void sort(int[] a);
}

public class OddEvenMergesort {
    static int[] a; 

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Max array size in powers of 2 (i.e 2, 4, 8, 16...) : ");
        int n = input.nextInt();
        a = new int[n];
        System.out.println("Enter the array elements : ");
        for(int i=0 ; i <n ;i++)
        {
            a[i] = input.nextInt();
        }

        Sorter s = new OddEvenMergeSorter();
        s.sort(a);

        System.out.println("Sorted Array :");
        for(int i = 0;i<n;i++)
            System.out.print(a[i]+ " ");

        input.close();
    }
}

class OddEvenMergeSorter implements Sorter 
{
    private int[] a;
    public void sort(int[] a)
    {
        this.a=a;
        oddEvenMergeSort(0, a.length);
    }

    /* * sorts a piece of length n of the array starting at position low */
    private void oddEvenMergeSort(int low, int n)
    {
        if (n>1)
        {
            int m=n/2;
            oddEvenMergeSort(low, m);
            oddEvenMergeSort(low+m, m);
            oddEvenMerge(low, n, 1);
        }
    } 
    
    /* * low is the starting position and n is the length of the piece to be merged,
         r is the distance of the elements to be compare */
    private void oddEvenMerge(int low, int n, int r)
    {
        int m=r*2;
        if (m<n)
        {
            oddEvenMerge(low, n, m); // even subsequence
            oddEvenMerge(low+r, n, m); // odd subsequence
            for (int i=low+r; i+r<low+n; i+=m)
                compare(i, i+r);
        }
        else
            compare(low, low+r);
    }

    private void compare(int i, int j)
    {
        if (a[i]>a[j])
            exchange(i, j);
    }

    private void exchange(int i, int j)
    {
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
} 

