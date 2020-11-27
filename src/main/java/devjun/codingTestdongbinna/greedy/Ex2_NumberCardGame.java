package devjun.codingTestdongbinna.greedy;

import java.util.*;

public class Ex2_NumberCardGame {


    public void getBigNumberInSmallNumbers() {
        /*    1.  숫자가 쓰인 카드들이 N X M 형태로 놓여있다.
        N은 행의 개수 M은 열의 개수
    2.  먼저 뽑고자 하는 카드가 포함되어 있는 행을 선택한다.
    3.  그 다음 선택한 행에 포함된 카드들 중 가장 숫자가 낮은 카드를 뽑아야 한다.
    4.  따라서 처음에 카드를 골라낼 행을 선택할 때, 이후에 해당 행에서 가장 숫자가 낮은 카드를 뽑을 것을 고려하여
        최종적으로 가장 높은 숫자의 카드를 뽑을 수 있도록 전략을 세워야 한다.*/
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int result = 0;

        for(int i = 0 ; i < n; i++) {
        / 현재 줄에서 '가장 작은 수' 찾기
            int min_value = 10001;
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                min_value = Math.min(min_value, x);
            }
            // '가장 작은 수'들 중에서 가장 큰 수 찾기
            result = Math.max(result, min_value);
        }

        System.out.println(result); // 최종 답안 출력
    }

    }

}
