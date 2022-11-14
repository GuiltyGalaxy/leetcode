package top.L341;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedIterator implements Iterator<Integer> {

    private Queue<Integer> q = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        //直接把nestedList全部解開
        parse(nestedList);
    }

    private void parse(List<NestedInteger> nestedList) {
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                //數字直接加到queue
                q.add(n.getInteger());
            } else {
                //list則遞迴parse繼續拆解
                parse(n.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return q.poll();
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }
}