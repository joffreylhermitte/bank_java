package com.bankroot.beans;

public class ConditionBean {

    private String name;
    private String operator;
    private String value;
    private String score;
    private String args;


    public String getName() {
        return name;
    }

    public ConditionBean setName(String name) {
        this.name = name;

        return this;
    }

    public String getOperator() {
        return operator;
    }

    public ConditionBean setOperator(String operator) {
        this.operator = operator;

        return this;
    }

    public String getValue() {
        return value;
    }

    public ConditionBean setValue(String value) {
        this.value = value;

        return this;
    }

    public String getScore() {
        return score;
    }

    public ConditionBean setScore(String score) {
        this.score = score;

        return this;
    }

    public String getArgs() {
        return args;
    }

    public ConditionBean setArgs(String args) {
        this.args = args;

        return this;
    }
}
