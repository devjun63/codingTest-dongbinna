package devjun.codingTestdongbinna.sort;

public class Fruit implements Comparable<Fruit> {

    private String name;
    private int score;

    public Fruit(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    // 정렬 기준은 '점수가 낮은 순서'
    @Override
    public int compareTo(Fruit other) {
        if (this.score < other.score) {
            return -1;
        }
        return 1;
    }
}

