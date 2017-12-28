package rocks.ninjachen.hacker_rank_soulutions;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/insertionsort2/problem
 * Created by ninja on 12/28/17.
 */
public class InsertionSort2 {

    public static void insertionSortPart2(int[] ar)
    {
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided
        for(int i = 1; i < ar.length; i++){
            int cur = ar[i];
            ar[i] = ar[i -1];
            for(int j = i - 1; j>= 0;j--){
                if(ar[j] > cur){
                    ar[j+1] = ar[j];
                }else{
                    ar[j+1] = cur;
                    cur = -1;
                    printArray(ar);
                    break;
                }
            }
            // Do the last one
            if(cur != -1){
                ar[0] = cur;
                printArray(ar);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertionSortPart2(ar);

    }
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }}
