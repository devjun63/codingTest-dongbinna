package devjun.codingTestdongbinna.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortLibraryExampleImpl implements SortLibarayExample{
    @Override
    public void basicUsingSortLibrary() {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    @Override
    public void keyUsingSortLibrary() {
        List<Fruit> fruits = new ArrayList<>();

        fruits.add(new Fruit("바나나", 2));
        fruits.add(new Fruit("사과", 5));
        fruits.add(new Fruit("당근", 3));

        Collections.sort(fruits);

        for (int i = 0; i < fruits.size(); i++) {
            System.out.print("(" + fruits.get(i).getName() + "," + fruits.get(i).getScore() + ") ");
        }
    }
}
