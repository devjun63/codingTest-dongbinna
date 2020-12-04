package devjun.codingTestdongbinna.implementation;

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
}
