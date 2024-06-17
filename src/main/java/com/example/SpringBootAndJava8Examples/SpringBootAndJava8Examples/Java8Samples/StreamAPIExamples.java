package com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Java8Samples;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIExamples {

    public static void main(String[] args) {

        String data="IamSudhakar";

        System.out.println("Count of each word"+Stream.of(data.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));


        List<Integer> listObj= Arrays.asList(1,100,10,50);

        System.out.println("max value  in List :::"+listObj.stream().max((a,b)->a.compareTo(b)).get());

        System.out.println("reverse order  in List :::"+listObj.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        Emp emp1=new Emp(2,"zzz",10);
        Emp emp2=new Emp(1,"aaa",20);
        Emp emp3=new Emp(3,"ppp",1);
        Emp emp4=new Emp(2,"sss",5);

        List<Emp> empObj=new ArrayList<>();
        empObj.add(emp1);
        empObj.add(emp2);
        empObj.add(emp3);
        empObj.add(emp4);

        System.out.println("Sortd by ID :::"+empObj.stream().sorted(Comparator.comparing(Emp::getId)).collect(Collectors.toList()));

        System.out.println("Sortd by Name :::"+empObj.stream().sorted(Comparator.comparing(Emp::getName)).collect(Collectors.toList()));


        Map<String,String> mapObj=new HashMap<>();
        mapObj.put("1","sudhakar");
        mapObj.put("2","test");
        mapObj.put("3","apple");
        mapObj.put("4","box");

        System.out.println("Get Values from Map sorted by value ::"+mapObj.entrySet().stream().map(one->one.getValue()).sorted().collect(Collectors.toList()));
        System.out.println("Get Values from Map sorted by value :: "+mapObj.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(one->one.getValue()).collect(Collectors.toList()));

    }

}

class Student {

    private int id;
    private String name;
    private int age;

    private String gender;

    public Student(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

class Emp{

    int id;

    String name;

    int age;

    public Emp(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}