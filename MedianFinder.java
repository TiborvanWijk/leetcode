import java.util.ArrayList;
import java.util.List;

class MedianFinder {

    List<Integer> list = new ArrayList<>();



    public MedianFinder() {

    }

    public void addNum(int num) {
        if (list.size() == 0) list.add(num);
        else {
            int i = 0;
            while (list.get(i) <= num && i < list.size() - 1){
                i++;
            }
            if (list.get(i) <= num) list.add(i + 1, num);
            else list.add(i,num);

        }
    }

    public double findMedian() {

        if (list.size() % 2 == 1){
            return list.get(list.size()/2);
        }
        else {
            return (double) (list.get(list.size() / 2) + list.get((list.size() / 2) - 1)) / 2;
        }


    }
}