package devjun.codingTestdongbinna.greedy;

import java.util.*;

public class Ex3_UntilOne {
    /*
        1. N에서 1을 뺀다.
        2. N을 K로 나눈다.
        이것을 1이 될 때 까지 반복하는데 최소 Count를 구해라

        */
    public void untilOneSimply () {
        Scanner sc = new Scanner(System.in);

        // N, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while(n >= k) {
            // n이 k로 나누어 떨어지지 않늗다면 N에서 1씩 빼기
            while (n % k != 0) {
                n -= 1;
                result += 1;
            }
            // k로 나누기
            n = n / k;
            result += 1;
        }

        while (n > 1) {
            n -= 1;
            result += 1;
        }

        System.out.println(result);
    }

    public void untilOne () {
        Scanner sc = new Scanner(System.in);

        // N, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while (true) {
            // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
            int target = (n / k) * k;
            result += (n - target);
            n = target;
            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (n < k) break;
            // K로 나누기
            result += 1;
            n /= k;
        }

        // 마지막으로 남은 수에 대하여 1씩 빼기
        result += (n - 1);
        System.out.println(result);
    }
}
