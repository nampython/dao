package com.example.Excercise1.learn;

public class People extends Human{

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    static {
        System.out.println("static");
    }

    {
        System.out.println("wq");
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void color() {

    }

    class PersonA {
        public void getName() {
            System.out.println(People.this.getName());
            System.out.println(People.this.age);
        }
    }
}
