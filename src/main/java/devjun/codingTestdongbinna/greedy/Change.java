package devjun.codingTestdongbinna.greedy;

public class Change {
    /*
    Greedy (탐욕법)의 대표적인 거스름돈 문제
    거스름돈 500원 100원 50원 10원이 무한으로 존재
    손님에게 거슬러 줘야 할 돈이 N원
    거슬러 줘야 할 동전의 최소 개수를 구하라.
    * */

    /* 문제 해설
    * 가장 큰 화폐 단위 부터 돈을 거슬러 주는 것
    N이 1260이라고 가정
    * */
    public void getChange(int n) {
        int cnt = 0;
        int[] coinTypes = {500, 100, 50, 10};
        for(int i = 0; i < 4; i++) {
            int coin = coinTypes[i];
            cnt += n / coin;
            n %= coin;
        }

        System.out.printf("입력하신 거스름돈 %d원을 500, 100, 50, 10원으로 나누어 드렸을 때 동전의 최소 개수는 %d개 입니다.", n, cnt);
    }





}
