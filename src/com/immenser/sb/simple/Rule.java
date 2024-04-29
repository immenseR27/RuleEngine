package com.immenser.sb.chain;

import com.immenser.sb.Callback;

public class Rule{

    private int var1;
    private String operation;
    private int var2;
    private Rule next;
    private Callback action;

    public Rule(int var1, String operation, int var2){
        this.var1 = var1;
        this.operation = operation;
        this.var2 = var2;
        this.next = null;
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

    public Rule chain(Rule rule){
        this.next = rule;
        return next;
    }

    public Rule getNext() {
        return next;
    }

    public void setAction(Callback action) {
        this.action = action;
    }

    public Callback getAction() {
        return action;
    }
}
