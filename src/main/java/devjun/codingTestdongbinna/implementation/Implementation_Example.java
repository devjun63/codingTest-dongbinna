package devjun.codingTestdongbinna.implementation;

import java.util.HashMap;
import java.util.Map;

public class Implementation_Example implements Implementaion_Example_impl{

    public String[] movePlansArray() {
        int moveValue = (int)(Math.random() * 99) + 1;
        String[] plans = new String[moveValue];
        for(int i = 0; i < moveValue; i++){
            plans[i] = createUDLR()+" ";
        }
        return plans;
    }

    public char createUDLR(){
        int moveValue = (int)(Math.random() * 3);
        char moveType = 'a';
        switch (moveValue) {
            case 0: moveType = 'U'; break;
            case 1: moveType = 'D'; break;
            case 2: moveType = 'L'; break;
            case 3: moveType = 'R'; break;
        }
        return moveType;
    }

    @Override
    public void upDownLeftRight(int n) {
        /*
        여행가 A는 N X M 크기의 정사각형 공간 위에 서 있다. 이 공간은 1 X 1 크기의 정사각형으로 나
        누어져 있다. 가장 왼쪽 위 좌표는 (1,1)이며, 가장 오른쪽 아래 좌표는 (N,N)에 해당한다. 여행
        가 A는 상, 하, 좌, 우 방향으로 이동할 수 있으며, 시작 좌표는 항상 (1,1)이다. 우리 앞에는 여행
        가 A가 이동할 계획이 적힌 계획서가 놓여 있다.
        UP DOWN LEFT RIGHT 에 따라서 움직이는데 정사각형 공간을 벗어나지는 않음
        도착 좌표를 구하시오

        입력 조건
        첫째 줄에 공간의 크기를 나타내는 N이 주어진다. ( 1 <= N <= 100 )
        둘째 줄에 여행가 A가 이동할 계획서 내용이 주어진다. ( 1 <= 이동 횟수 <= 100 )

        출력 조건
        첫째 줄에 여행가 A가 최종적으로 도착할 지점의 좌표 (X, Y)를 공백으로 구분하여 출력한다.

        ex)
        5
        R R R U D D => 3 4

        */

        //
        String[] plans = movePlansArray();
        int x = 1, y = 1;

        // L, R, U, D에 따른 이동 방향
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        // 이동 계획을 하나씩 확인
        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);
            // 이동 후 좌표 구하기
            int nx = -1, ny = -1;
            for (int j = 0; j < 4; j++) {
                if (plan == moveTypes[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            // 공간을 벗어나는 경우 무시
            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
            // 이동 수행
            x = nx;
            y = ny;
        }
    }

    public static boolean check(int h, int m, int s) {
        if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3)
            return true;
        return false;
    }

    @Override
    public void checkThreeProvideTime(int n) {
        /*
        정수 N이 입력되면 00시 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포
        함되는 모든 경우의 수를 구하는 프로그램을 작성하시오. 예를 들어 1을 입력했을 때 다음은3 이 하
        나라도 포함되어 있으므로 세어햐 하는 시각이다.
        00시 00분 03초
        00시 13분 30초

        반면에 다음은 3이 하나도 포함되어 있지 않으므로 세면 안 되는 시각이다.
        00시 02분 55초
        01시 27분 45초

        입력 조건
        첫째 줄에 정수 N이 입력된다. (0 <= N <= 23)

        출력 조건
        00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의
        수를 출력한다.

        ex) 5 -> 11475

        모든 경우의 수 86,400
        24 * 60 * 60
        완전 탐색(Brute Forcing)
        */

        int cnt = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    // 매 시각 안에 '3'이 포함되어 있다면 카운트 증가
                    if (check(i, j, k)) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public Map<Integer, Integer> kightPosition(){
        Map<Integer, Integer> position = new HashMap<>();
        // n 1 ~ 8
        // ASCII CODE 'a' ~ 'h' - 65 ~ '73'
        int row = (int)(Math.random() * 8) +1 ;
        int column = (int)(Math.random() * 8) + 1;
        position.put(row, column);
        return position;
    }

    @Override
    public void royalKnight() {
        /*
        8 X 8 좌표 평면에 특정한 한 칸에 나이트가 서 있다.
        나이트는 L자 형태로만 이동 가능하다.
        1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
        2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기

        int[] row = {1, 2, 3, 4, 5, 6, 7, 8}
        int[] column = {a, b, c, d, e, f, g, h}

        이러한 8 X 8 좌표 평면상에서 나이트가 위치할 때 이동 가능한 경우의 수를 출력하시오

        ex) a1 ... 2 / e4 .... 8

        */

        Map<Integer, Integer> position = new HashMap<>();
        position = this.kightPosition();

        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
        int result = 0;
        for (int i = 0; i < 8; i++) {
            // 이동하고자 하는 위치 확인
            int nextRow = position.get(0) + dx[i];
            int nextColumn = position.get(1) + dy[i];
            // 해당 위치로 이동이 가능하다면 카운트 증가
            if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
                result += 1;
            }
        }
        System.out.println(result);
    }


    public static int n, m, x, y, direction;
    // 방문한 위치를 저장하기 위한 맵을 생성하여 0으로 초기화
    public static int[][] d = new int[50][50];
    // 전체 맵 정보
    public static int[][] arr = new int [50][50];

    // 북, 동, 남, 서 방향 정의
    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, 1, 0, -1};

    // 왼쪽으로 회전
    public static void turn_left() {
        direction -= 1;
        if (direction == -1) direction = 3;
    }

    public void generateWorldSize(){
        // 3 <=N, M <= 50
        n = (int)(Math.random() * 47) + 3;
        m = (int)(Math.random() * 47) + 3;
        direction = (int)(Math.random() * 3);
    }

    public void generateGameWorld(){
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = (int) Math.random() * 1;
                }
            }
        }
    }

    @Override
    public void developmentGame() {
        for(int i = 0; i < 50; i++){
            for(int j = 0; j < 50; j++){
                if(arr[i][j] == 0) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        d[x][y] = 1;

        // 시뮬레이션 시작
        int cnt = 1;
        int turn_time = 0;
        while (true) {
            // 왼쪽으로 회전
            turn_left();
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            // 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
            if (d[nx][ny] == 0 && arr[nx][ny] == 0) {
                d[nx][ny] = 1;
                x = nx;
                y = ny;
                cnt += 1;
                turn_time = 0;
                continue;
            }
            // 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
            else turn_time += 1;
            // 네 방향 모두 갈 수 없는 경우
            if (turn_time == 4) {
                nx = x - dx[direction];
                ny = y - dy[direction];
                // 뒤로 갈 수 있다면 이동하기
                if (arr[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                }
                // 뒤가 바다로 막혀있는 경우
                else break;
                turn_time = 0;
            }
        }
        System.out.println(cnt);
    }
}
