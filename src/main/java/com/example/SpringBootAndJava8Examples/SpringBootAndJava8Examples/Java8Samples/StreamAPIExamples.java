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

        System.out.println("List max value :: "+listObj.stream().mapToInt(one->one).summaryStatistics().getMax());
        System.out.println("List min value :: "+listObj.stream().mapToInt(one->one).summaryStatistics().getMin());
        System.out.println("List avg value :: "+listObj.stream().mapToInt(one->one).summaryStatistics().getAverage());
        System.out.println("List count value :: "+listObj.stream().mapToInt(one->one).summaryStatistics().getCount());

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

        String dataString="I am Java Developer ";

        System.out.println("Count of each variable ::"+Stream.of(dataString.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

        // may 28

        List<Student> studentList =new ArrayList<>();

        studentList.add(new Student(2,"sudhaka",31,"male"));
        studentList.add(new Student(1,"zzzzz",32,"male"));
        studentList.add(new Student(3,"aaaaaa",32,"female"));
        studentList.add(new Student(4,"cccccc",33,"female"));
        studentList.add(new Student(5,"dddddd",33,"female"));
        studentList.add(new Student(6,"dddddd",17,"female"));
        studentList.add(new Student(7,"zzzzz123",15,"male"));

        System.out.println("Sorted by Age And Name ::"+studentList.stream().sorted(Comparator.comparing(Student::getAge).thenComparing(Comparator.comparing(Student::getName))).collect(Collectors.toList()));
        System.out.println("Sorted by Name And Age ::"+studentList.stream().sorted(Comparator.comparing(Student::getName).thenComparing(Comparator.comparing(Student::getAge))).collect(Collectors.toList()));

        System.out.println("Avg by gender ::"+studentList.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.averagingInt(Student::getAge))));


        System.out.println("Result like key is ID and Value are MAP Obj :"+studentList.stream().collect(Collectors.toMap(one->one.getId(),One->One)));

        // Accumulate in to TreeSet Obj as Result
        System.out.println("Result like Treeset  Obj :"+studentList.stream().map(Student::getAge).collect(Collectors.toCollection(TreeSet::new)));

        // Convert elements to strings and concatenate them, separated by commas
        System.out.println("Result in String with Kama(,)  Obj :"+studentList.stream().map(Student::getAge).map(Object::toString).collect(Collectors.joining(",")));

        // Compute sum of age of employee
        System.out.println("Result in SUM of Age  Obj :"+studentList.stream().collect(Collectors.summingInt(Student::getAge)));
        // (OR)
        System.out.println("Result in SUM of Age  Obj :"+ (Integer) studentList.stream().mapToInt(Student::getAge).sum());

        // group by AGE
        System.out.println("Result in Group By Age  Obj :"+studentList.stream().collect(Collectors.groupingBy(Student::getAge)));



        // Compute sum of ages by gender
        System.out.println("Result in Group By Age  Obj :"+studentList.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.summingInt(Student::getAge))));

        // Partition students into passing and failing
        System.out.println("Result in Group By Age  Obj :"+studentList.stream().collect(Collectors.partitioningBy(one->one.getAge() >=18)));


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