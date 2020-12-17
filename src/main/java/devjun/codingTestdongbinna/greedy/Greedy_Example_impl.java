package devjun.codingTestdongbinna.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Greedy_Example_impl implements Greedy_Example{

    public int makeAdventurerNum(){
        return (int)(Math.random() * 99999) + 1;
    }

    @Override
    public void adventurerGuild() {
        /*
        모험가 n 명이 있다. 모험가는 각각 공포도를 가지고 있다.
        모험가 길드장의 명령으로 공포도 x를 가진 사람은 x명 이상의 그룹으로 모험을 나가야 한다.
        이떄 나갈 수 있는 그룹의 최대치를 구하시오

        계수 정렬로 접근 (최악의 시간 복잡도 O(N))

        */


        int cnt = 0;
        int n = makeAdventurerNum();
        int[] arr = new int[n+1];
        for(int i = 1; i < n+1; i++) {
            int temp = makeAdventurerNum();
            arr[temp] += 1;
        }

        for(int i = 1; i < n+1; i++) {
            cnt += arr[i] / i;
        }

        System.out.println(cnt);
    }

    @Override
    public void multipleOrPlus() {
        /*
        각 자리가 숫자 (0~9)로만 이루어진 문자열 S
        왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하며 숫자 사이에 'X' or '+' 연산자를 넣어
        결과적으로 만들 수 있는 가장 큰 수를 도출하시오.
        단 + 보다 X를 먼저 계산하는 일반적 방식이 아니라 모든 연산은 좌에서 우로 이루어 진다고 가정

        입력: S문자열의 길이 1 <= S <= 20
        출력: 뭐.. 그냥

        문제 접근
        result라는 변수를 두고
        for문으로 S.charAt(0)부터 length까지 돌리는데
        result가 0 혹은 1인 상태라면 +연산을
        그렇지 않으면서 해당 자리 숫자가 0이나 1이라면 +연산을
        그 외의 연산에 대해서는 곱셈 연산을 하면 가장 큰 수를 구할수 있을것이라고 생각했다.

        */
        int result = 0;
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            int temp =Character.getNumericValue(s.charAt(i));
            if(result == 0 || result == 1) {
                result = result + temp;
            }else {
                if(temp == 0 || temp == 1) {
                    result = result + temp;
                }else {
                    result = result * temp;
                }
            }
        }

        System.out.println(result);
    }

    @Override
    public void filpString() {
        /*
        0과 1로만 이루어진 문자열 S
        이 문자열 S에 있는 모든 숫자를 전부 같도록
        S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집어 보자.
        뒤집는 것은 1을 0으로 0을 1로 바꾸는 것

        ex) S = 0001100 -> 1110011 -> 1111111
        but 0001100 -> 0000000 가능

        모두 같은 숫자가 되도록 만드는데 필요한 최소 횟수를 구하고 출력하시오.

        일단 그냥 종이에 010100010010, 0100010010001011101 이런식으로 막 적은 후 최소 횟수를 구해 보았다.
        바뀌는 숫자를 구해보니 8번 바뀌고, 0이 5블록, 1이 4블록개가 존재
        11, 0이 6블록,1이 6블록
        나온 공식이 바뀐 횟수가 짝수 라면 (횟수 / 2), 홀수 라면 (횟수 / 2) +1
        */

        int head = 0;
        int result = 0;

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            int temp = Character.getNumericValue(s.charAt(i));
            if(i==0) head = temp;
            if(head != temp) {
                head = temp;
                result = result + 1;
            }
        }
        System.out.println((result % 2 == 0) ? (result / 2) : (result / 2) +1);
    }

    @Override
    public void imposibleAmount() {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            arrayList.add(sc.nextInt());
        }

        Collections.sort(arrayList);

        int target = 1;
        for(int i = 0; i < n; i++) {
            if(target < arrayList.get(i)) break;
            target = target + arrayList.get(i);
        }

        System.out.println(target);

    }

    public int makeBallCount() {
        return (int)(Math.random() * 1000) + 1;
    }

    public int makeBall() {
        return (int)(Math.random() * 10) + 1;
    }

    @Override
    public void chooseBallingBall() {
        /*
        A,B가 볼링공의 무게를 다르게 가져가는 경우의 수를 구하라
        입력 1 <= N <= 1000, 1 <= M <= 10, 1 <= K <= M
        ex)에서 N = 5, M = 3
        K = 1,3,2,3,2 => 8개
        (1,2)(1,3)(1,4)(1,5)(2,3)(2,5)(3,4)(4,5)

         생각한 것이 계수 정렬하고 해당 배열 * 나머지를 지속하면 result가 나왔다.
         정확한 변수를 활용한 소스코드는 떠오르지 않아서 깃허브 코드를 참조했다.
        */
        int[] arr = new int[11];
        int n = makeBallCount();
        int m = makeBall();

        for(int i = 0; i < n ; i++) {
            int temp = makeBall();
            arr[temp] += 1;
        }

        int result = 0;

        // 1부터 m까지 각 무게에 대해서 처리
        for(int i = 1; i <= m; i++) {
            n -= arr[i];
            result += arr[i] * n;
        }

        System.out.println(result);
    }
}
