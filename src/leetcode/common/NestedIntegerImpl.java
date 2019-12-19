package leetcode.common;

import java.util.LinkedList;
import java.util.List;

public class NestedIntegerImpl implements NestedInteger {

    Integer value;
    List<NestedInteger> nestInteger;

    public NestedIntegerImpl(Integer value) {
        this.value = value;
        nestInteger = new LinkedList<>();
    }

    public NestedIntegerImpl() {
        nestInteger = new LinkedList<>();
    }

    @Override
    public boolean isInteger() {
        if (nestInteger.size() == 0)
            return true;
        return false;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    public void setInteger(int value) {
        this.value = value;
    }

    @Override
    public void add(NestedInteger nestedInteger) {
        nestedInteger.add(nestedInteger);
    }

    @Override
    public List<NestedInteger> getList() {
        return null;
    }
}
