import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

class RandomizedSet {


    HashSet<Integer> set = new HashSet<>();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (set.contains(val)){
            return false;
        }
        set.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (set.contains(val)){
            set.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        List<Integer> list = new ArrayList<>(set);
        int r=(int)(Math.random()*set.size());

        return list.get(r);
    }
}