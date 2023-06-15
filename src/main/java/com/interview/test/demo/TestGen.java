package com.interview.test.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
//Learning Generics
@Data
@AllArgsConstructor
class Employee{
    private int empId;
    private String empName;
}

@Data
@AllArgsConstructor
class Student{
    private int stId;
    private String stName;

}

class MyGen<T>{
    T obj;
    public void add(T obj){
        this.obj = obj;
    }

    public T get(){
        return obj;
    }
}

class MyGenList<T>  {
    List<T> list = new ArrayList<>();

    public void addToList(T obj){
        this.list.add(obj);
    }

    public List<T> getList(){
        return list;
    }
}

public class TestGen {

    public static void main(String[] args) {
        MyGen<Student> myGenSt = new MyGen<Student>();
        myGenSt.add(new Student(1,"saurabh student"));
       // System.out.println(myGenSt.get());

        MyGen<Employee> myGenEmp = new MyGen<Employee>();
        myGenEmp.add(new Employee(2,"saurabh Employee"));
       // System.out.println(myGenEmp.get());

        Student student1 = new Student(1, "Saurabh");
        Student student2 = new Student(2, "John");
        Student student3 = new Student(3, "Emily");
        Student student4 = new Student(4, "Michael");
        Student student5 = new Student(5, "Sarah");

        MyGenList<Student> myGenList = new MyGenList<>();
        myGenList.addToList(student1);
        myGenList.addToList(student2);
        myGenList.addToList(student3);
        myGenList.addToList(student4);
        myGenList.addToList(student5);

        myGenList.getList().stream().forEach(System.out::println);

     }
  }
