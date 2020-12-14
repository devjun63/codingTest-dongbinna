package devjun.codingTestdongbinna.greedy;

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
}
