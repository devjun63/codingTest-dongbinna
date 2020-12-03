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
}
