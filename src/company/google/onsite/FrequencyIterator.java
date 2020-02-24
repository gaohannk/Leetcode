package company.google.onsite;

import java.util.*;

/**
 * input iterator {1,1,1,2,2,3}
 * ouput iterator {{1,3},{2,2},{3,1}}
 */
public class FrequencyIterator implements Iterator {

    Iterator<Integer> iterator;
    Integer cur = null;
    boolean lastElement;
    boolean callOnce;

    FrequencyIterator(Iterator<Integer> iterator){
      this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        if(lastElement){
            return false;
        }
        if(callOnce ==false && iterator.hasNext() == false){
            callOnce = true;
            return callOnce;
        }
        return iterator.hasNext();
    }

    @Override
    public Pair next() {
        int count = 1;
        while (iterator.hasNext()) {
            int next = iterator.next();
            // Initial State
            if(cur == null){
                cur = next;
                continue;
            }
            if (next == cur) {
                count++;
            } else {
                Pair p = new Pair(cur, count);
                cur = next;
                return p;
            }
        }
        lastElement  = true;
        return new Pair(cur, count);
    }

    class Pair {
        int val;
        int freq;

        public Pair(int cur, int count) {
            this.val = cur;
            this.freq = count;
        }

        @Override
        public String toString(){
            return this.val + "," + this.freq;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
//        list.add(3);
//        list.add(3);

        FrequencyIterator fi = new FrequencyIterator(list.iterator());
        while(fi.hasNext()){
            System.out.println(fi.next());
        }
    }

}
