package rocks.ninjachen.hacker_rank_soulutions;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/big-sorting/problem
 * Created by ninja on 12/28/17.
 */
public class BigSorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        // your code goes here
        List<NinjaString> unsortedInt = new ArrayList<>();
        for(int i = 0; i < n; i++){
            unsortedInt.add(new NinjaString(unsorted[i]));
        }
        Collections.sort(unsortedInt);
        for(int i = 0; i < n; i++){
            System.out.println(unsortedInt.get(i).s);
        }
    }

    public static class NinjaString implements Comparable<NinjaString>{
        final public String s;
        public NinjaString(String s){
            this.s = s;
        }

        public int compareTo(NinjaString o){
            if(o.s.length() != this.s.length()){
                if(this.s.length() > o.s.length()){
                    return 1;
                }else{
                    return -1;
                }
            }
            // len is equal
            for(int i = 0; i < this.s.length(); i++){
                if(this.s.charAt(i) > o.s.charAt(i)){
                    return 1;
                }

                if(this.s.charAt(i) < o.s.charAt(i)){
                    return -1;
                }
            }
            return 0;
        }
    }
}
