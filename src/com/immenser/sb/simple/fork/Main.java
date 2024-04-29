package com.immenser.sb.fork;

import com.immenser.sb.Callback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Rule tree1_subRule1 = new Rule(10, "<", 20);
        Rule tree1_subRule2 = new Rule(10, "<", 20);
        Rule tree1_finalRule = new Rule(20, "=", 20);

        Rule tree2_subRule1 = new Rule(20, "<", 30);
        Rule tree2_subRule2 = new Rule(20, "<", 30);
        Rule tree2_finalRule = new Rule(30, "=", 30);

        List<List<Rule>> chain = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(tree1_subRule1, tree1_subRule2)), new ArrayList<>(Arrays.asList(tree2_subRule1, tree2_subRule2))));

        tree1_subRule1.chain(new Rule(10, "<", 20)).chain(tree1_finalRule);
        tree1_subRule2.chain(new Rule(10, "<", 20)).chain(tree1_finalRule);

        tree2_subRule1.chain(new Rule(20, ">", 30)).chain(tree2_finalRule);
        tree2_subRule2.chain(new Rule(20, "<", 30)).chain(tree2_finalRule);

        Callback callback1 = () -> System.out.println("Speed faster!");
        Callback callback2 = () -> System.out.println("Do something other!");

        tree1_finalRule.setAction(callback1);
        tree2_finalRule.setAction(callback2);

        Engine engine = new Engine(chain);
        engine.getResult();
    }
}