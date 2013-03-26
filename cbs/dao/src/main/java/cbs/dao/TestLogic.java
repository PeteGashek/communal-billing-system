package cbs.dao;

import java.util.HashSet;
import java.util.Set;


public class TestLogic {

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        System.out.println(set.add("aaa"));
        System.out.println(set.add("bbb"));
        System.out.println(set.add("aaa"));
        System.out.println(set);
    }
}