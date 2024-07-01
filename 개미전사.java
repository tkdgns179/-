import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 개미전사 {

    static int[] dp = new int[100];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n;
        n = Integer.parseInt(br.readLine());
        int[] targets = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            targets[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, targets));

    }

    public static int solution(int n, int[] targets) {

        dp[0] = targets[0];
        dp[1] = targets[1];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + targets[i]);
        }

        return dp[n-1];
    }

}
