package com.immenser.sb.tree;

import com.immenser.sb.Callback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Rule rule1 = new Rule("rule1", 10, "<", 20);
        Rule rule2 = new Rule("rule2", 10, "<", 20);
        Rule rule3 = new Rule("rule3", 10, "<", 20);
        Rule rule4 = new Rule("rule4", 10, "<", 20);
        Rule rule5 = new Rule("rule5", 10, "<", 20);

        Callback callback1 = () -> System.out.println("Speed faster!");
        //Callback callback2 = () -> System.out.println("Do something other!");
        Callback callback3 = () -> System.out.println("Congratulations!!!");

        rule1.chain(new ArrayList<>(Arrays.asList(rule2, rule3)));
        rule2.chain(new ArrayList<>(Arrays.asList(rule4)));
        //rule3.chain(new ArrayList<>(Arrays.asList(rule4)));
        rule3.chain(new ArrayList<>(Arrays.asList(rule4, rule5)));
        rule4.setAction(callback1);
        rule5.setAction(callback3);

        List<Rule> chain = new ArrayList<>(Arrays.asList(rule1));

        Engine engine = new Engine(chain);
        engine.getResult();
    }
}
