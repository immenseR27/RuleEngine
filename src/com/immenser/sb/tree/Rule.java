package com.immenser.sb.tree;

import com.immenser.sb.Callback;

import java.util.ArrayList;
import java.util.List;

public class Rule{

    private int var1;
    private String operation;
    private int var2;
    private List<Rule> next;
    private List<Rule> prev;
    private Callback action;
    public String name;

    public Rule(String name, int var1, String operation, int var2){
        this.name = name;
        this.var1 = var1;
        this.operation = operation;
        this.var2 = var2;
        this.next = null;
        this.prev = null;
        this.action = null;
    }

    public boolean check(){
        if (this.operation.equals("=")){
            return this.var1 == var2;
        }
        if (this.operation.equals("<")){
            return this.var1 < var2;
        }
        if (this.operation.equals(">")){
            return this.var1 > var2;
        }
        return false;
    }

    public List<Rule> chain(List<Rule> rules){
        this.next = rules;
        for (Rule rule : rules){
            if (rule.getPrev() == null){
                rule.setPrev(new ArrayList<>());
            }
            rule.prev.add(this);
        }
        return next;
    }

    public List<Rule> getNext() {
        return next;
    }

    public void setPrev(List<Rule> prev) {
        this.prev = prev;
    }

    public List<Rule> getPrev() {
        return prev;
    }

    public void setAction(Callback action) {
        this.action = action;
    }

    public Callback getAction() {
        return action;
    }
}
