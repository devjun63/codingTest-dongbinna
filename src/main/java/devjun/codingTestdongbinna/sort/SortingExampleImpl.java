package devjun.codingTestdongbinna.sort;

import java.util.*;

public class SortingExampleImpl implements SortingExample{

    @Override
    public void sortDesc() {
        /*
        <2> 실전문제 위에서 아래로
        입력을 난수로 대체하여 출력

        N개의 수가 주어진다.
        수의 범위는 1 <= number <= 100,000

        주어진 수를 내림차순으로 정렬된 결과를 공백을 구분하여 출력하라.
        */

        int n = (int)(Math.random() * 99) + 1;
        Integer[] array = new Integer[n];
        for(int i = 0; i < n; i++){
            array[i] = (int)(Math.random() * 99999) + 1;
        }
        Arrays.sort(array, Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            System.out.print(array[i]+" ");
        }
    }

    @Override
    public void printGradeDesc() {
        // N을 입력받기
        int n = (int)(Math.random() * 99999) + 1;

        // N명의 학생 정보를 입력받아 리스트에 저장
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = String.valueOf((char)((int)(Math.random() * 26) + 97));
            int score = (int)(Math.random() * 100);
            students.add(new Student(name, score));
        }

        Collections.sort(students);

        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).getName() + " ");
        }
    }

    @Override
    public void exchangeTwoArraysElements() {
        Scanner sc = new Scanner(System.in);

        // N과 K를 입력받기
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 배열 A의 모든 원소를 입력받기
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        // 배열 B의 모든 원소를 입력받기
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        // 배열 A는 오름차순 정렬 수행
        Arrays.sort(a);
        // 배열 B는 내림차순 정렬 수행
        Arrays.sort(b, Collections.reverseOrder());

        // 첫 번째 인덱스부터 확인하며, 두 배열의 원소를 최대 K번 비교
        for (int i = 0; i < k; i++) {
            // A의 원소가 B의 원소보다 작은 경우
            if (a[i] < b[i]) {
                // 두 원소를 교체
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
            // A의 원소가 B의 원소보다 크거나 같을 때, 반복문을 탈출
            else break;
        }

        // 배열 A의 모든 원소의 합을 출력
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += a[i];
        }
        System.out.println(result);
    }
}
