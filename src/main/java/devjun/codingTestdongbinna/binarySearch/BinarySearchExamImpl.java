package devjun.codingTestdongbinna.binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class BinarySearchExamImpl implements BinarySearchExam{

    public static int sequantialSearch(int n, String target, String[] arr) {
        // 각 원소를 하나씩 확인하며
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
            // 현재의 원소가 찾고자 하는 원소와 동일한 경우
            if (arr[i].equals(target)) {
                return i + 1; // 현재의 위치 반환 (인덱스는 0부터 시작하므로 1 더하기)
            }
        }
        return -1; // 원소를 찾지 못한 경우 -1 반환
    }

    @Override
    public void basicSequentialSearch() {

        Scanner sc = new Scanner(System.in);

        System.out.println("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력하세요.");
        // 원소의 개수
        int n = sc.nextInt();
        // 찾고자 하는 문자열
        String target = sc.next();

        System.out.println("앞서 적은 원소 개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한 칸으로 합니다.");
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        // 순차 탐색 수행 결과 출력
        System.out.println(sequantialSearch(n, target, arr));
    }

// ----------------------------------------------------------------------------------------------------------------

    public static int recursiveBinarySearch(int[] arr, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        // 찾은 경우 중간점 인덱스 반환
        if (arr[mid] == target) return mid;
            // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
        else if (arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
            // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
        else return binarySearch(arr, target, mid + 1, end);
    }

    @Override
    public void recursiveFuncBinarySearch() {
        Scanner sc = new Scanner(System.in);

        // 원소의 개수(n)와 찾고자 하는 값(target)을 입력받기
        int n = sc.nextInt();
        int target = sc.nextInt();

        // 전체 원소 입력받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색 수행 결과 출력
        int result = recursiveBinarySearch(arr, target, 0, n - 1);
        if (result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        }
        else {
            System.out.println(result + 1);
        }
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target) return mid;
                // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if (arr[mid] > target) end = mid - 1;
                // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else start = mid + 1;
        }
        return -1;
    }

    @Override
    public void iterationBinarySearch() {
        Scanner sc = new Scanner(System.in);

        // 원소의 개수(n)와 찾고자 하는 값(target)을 입력받기
        int n = sc.nextInt();
        int target = sc.nextInt();

        // 전체 원소 입력받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색 수행 결과 출력
        int result = binarySearch(arr, target, 0, n - 1);
        if (result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        }
        else {
            System.out.println(result + 1);
        }
    }


    public static int partsbinarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target) return mid;
                // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if (arr[mid] > target) end = mid - 1;
                // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else start = mid + 1;
        }
        return -1;
    }

    @Override
    public void searchPartsBinarySearch() {
        /*
        동빈이네 전자 매장에 부품이 N개 있다.
        손님은 M개 부품을 대량으로 구매
        N = 5
        [8, 3, 7, 9, 2]
        M = 3
        [5, 7, 9]
        부품 확인 후 있으면 yes 없으면 no출력
        no yes yes

        입력 조건
        1 <= n <= 1,000,000
        1 <= M <= 100,000

        문제 해설
        다량의 데이터는 이진 탐색 알고리즘을 이용해 효과적으로 처리할 수 있다.
        N개 부품을 번호를 기준으로 정렬 => M개의 찾고자 하는 부품이 각각 매장에 존재하는지 검사
        정렬 되어 있기 때문에 이진 탐색을 수행 가능
        O(M X logN) 200만번
        정렬은 2,000만 O(N X logN)
        O((M + N) X logN)
        * */

        // N(가게의 부품 개수)
        int n = (int)(Math.random() * 999999) + 1;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * 999999) + 1;
        }

        // 이진 탐색을 수행하기 위해 사전에 정렬 수행
        Arrays.sort(arr);

        // M(손님이 확인 요청한 부품 개수)
        int m = (int)(Math.random() * 99999) + 1;
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = (int)(Math.random() * 999999) + 1;
        }

        // 손님이 확인 요청한 부품 번호를 하나씩 확인
        for (int i = 0; i < m; i++) {
            // 해당 부품이 존재하는지 확인
            int result = partsbinarySearch(arr, targets[i], 0, n - 1);
            if (result != -1) {
                System.out.print("yes ");
            }
            else {
                System.out.print("no ");
            }
        }


    }

    @Override
    public void searchPartsCountSort() {


        // N(가게의 부품 개수)
        int n = (int)(Math.random() * 999999) + 1;
        int[] arr = new int[1000001];
        for (int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 999999) + 1;
            arr[x] = 1;
        }

        // M(손님이 확인 요청한 부품 개수)
        int m = (int)(Math.random() * 99999) + 1;
        int[] targets = new int[n];
        for (int i = 0; i < m; i++) {
            targets[i] = (int)(Math.random() * 999999) + 1;
        }

        // 손님이 확인 요청한 부품 번호를 하나씩 확인
        for (int i = 0; i < m; i++) {
            // 해당 부품이 존재하는지 확인
            if (arr[targets[i]] == 1) {
                System.out.print("yes ");
            }
            else {
                System.out.print("no ");
            }
        }
    }

    @Override
    public void searchPartsUsingSet() {


        // N(가게의 부품 개수)
        int n = (int)(Math.random() * 999999) + 1;
        // 집합(Set) 정보를 처리하기 위한 HashSet 라이브러리
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = (int)(Math.random() * 999999) + 1;
            s.add(x);
        }

        // M(손님이 확인 요청한 부품 개수)
        int m = (int)(Math.random() * 99999) + 1;
        int[] targets = new int[n];
        for (int i = 0; i < m; i++) {
            targets[i] = (int)(Math.random() * 999999) + 1;
        }

        // 손님이 확인 요청한 부품 번호를 하나씩 확인
        for (int i = 0; i < m; i++) {
            // 해당 부품이 존재하는지 확인
            if (s.contains(targets[i])) {
                System.out.print("yes ");
            }
            else {
                System.out.print("no ");
            }
        }
    }
    
}
