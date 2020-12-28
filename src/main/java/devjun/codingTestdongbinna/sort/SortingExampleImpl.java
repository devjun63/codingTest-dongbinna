package devjun.codingTestdongbinna.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
}
