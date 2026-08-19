import java.util.ArrayList;

public class t1 {
    public static void main(String[] args) {
        int i = 6;
        int out = Sum(i);
        System.out.println(out);
    }
    static int Sum(int n){
        if (n == 0) {return 0;}
        return n + Sum(n-1);
    }

    static int total(int[] marks){
        int sum = 0;
        for (int mark: marks) {sum += mark;}
        return sum;
    }

    static float find_average(int [] marks) {
        int sum = total(marks);
        int len = marks.length;
        return (float) sum/len;
    }

    static ArrayList<Integer> findPeaks(int[] temp){
        ArrayList<Integer> out = new ArrayList<>();
        for (int i=1; i < temp.length; i++) {
            if (temp[i] > temp[i+1] && temp[i] > temp[i-1]) {out.add(i);}
        }
        return out;
    }
}
