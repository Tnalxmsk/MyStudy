import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Baekjoon1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String arr1 = br.readLine();
        String[] arr2 = arr1.split(" ");
        int[] arr3 = new int[n];
        for (int i = 0; i < n; i++) {
            arr3[i] = Integer.parseInt(arr2[i]);
        }

        float sum = 0f;
        float avg;
        int max = arr3[0];

        for (int i = 0; i < n; i++) {
            if (max < arr3[i]) {
                max = arr3[i];
            }
        }

        for (int i = 0; i < n; i++) {
            sum += ((float) arr3[i] /max*100);
        }
        avg = sum/n;

        System.out.println(avg);
    }
}
