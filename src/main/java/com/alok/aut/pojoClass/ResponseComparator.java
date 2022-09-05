package com.alok.aut.pojoClass;

import java.util.*;

public class ResponseComparator implements Comparator<TestClass> {
    @Override
    public int compare(TestClass o1, TestClass o2) {

        return o1.toString().compareTo(o2.toString());
    }
}
