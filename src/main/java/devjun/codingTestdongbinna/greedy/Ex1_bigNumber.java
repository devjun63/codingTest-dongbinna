package devjun.codingTestdongbinna.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1_bigNumber {
    /*큰 수의 법칙
    * 다양한 수로 이루어진 배열이 있을 때 주어진 수열을 M번 더하여 가장 큰 수를 만드는 법칙
    * 단, 배열의 특정한 인덱스(번호)에 해당하는 수가 연속해서 K번을 초과하여 더해질 수 없는 것이 이 법칙의 특징
    *
    *
    * 입력 조건
    * 첫째 줄에 N(2<= N <= 1000), M(1 <= M <+ 10,000), K(1 <= K <= 10,000)의 자연수가 주어지며, 각 자연수는 공백으로 구분
    * 둘째 줄에 N개의 자연수가 주어진다. 각 자연수는 공백으로 구분한다. 단, 각각의 자연수는 1 이상 10,000 이하의 수로 주어진다.
    * 입력으로 주어지는 K는 항상 M보다 작거나 같다.
    *
    * 출력 조건
    * 첫째 줄에 동빈이의 큰 수의 법칙에 따라 더해진 값을 출력한다.
    *
    * */

    // 단순 답안
    public void bigNumber() {
        Scanner sc = new Scanner(System.in);

        // N, M, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        // N개의 수를 공백을 기준으로 구분하여 입력 받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); // 입력 받은 수들 정렬하기
        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수

        int result = 0;

        while(true) {
            for (int i = 0; i < k; i++) {
                if (m == 0) {
                    break;
                }
                result += first;
                m -= 1;
            }
            if (m == 0) {
                break;
            }
            result += second;
            m -= 1;
        }
        System.out.println(result);
    }

    public void bigNum() {
        Scanner sc = new Scanner(System.in);

        // N, M, K를 공백을 기준으로 구분하여 입력 받기
        System.out.println("n 입력하세요");
        int n = sc.nextInt();
        System.out.println("m 입력하세요");
        int m = sc.nextInt();
        System.out.println("k 입력하세요");
        int k = sc.nextInt();

        // N개의 수를 공백을 기준으로 구분하여 입력 받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // 입력 받은 수들 정렬하기
        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수

        // 가장 큰 수가 더해지는 횟수 계산
        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1);

        int result = 0;
        result += cnt * first; // 가장 큰 수 더하기
        result += (m - cnt) * second; // 두 번째로 큰 수 더하기

        System.out.println(result);
    }


}
