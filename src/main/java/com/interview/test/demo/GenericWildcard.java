package com.interview.test.demo;

import java.util.*;
abstract class Shape{
    abstract void draw();
}
class Rectangle extends Shape{
    void draw(){System.out.println("drawing rectangle");}
}
class Circle extends Shape{
    void draw(){System.out.println("drawing circle");}
}
class GenericTest{
    //creating a method that accepts only child class of Shape
    public static void drawShapes(Shape lists){
//        for(Shape s:lists){
//            s.draw();//calling method of Shape class by child class instance
//        }
    }
    public static void main(String args[]){
        List<Rectangle> list1=new ArrayList<Rectangle>();
        list1.add(new Rectangle());

        List<Circle> list2=new ArrayList<Circle>();
        list2.add(new Circle());
        list2.add(new Circle());

        //drawShapes(list1);
        //drawShapes(list2);

        drawShapes(new Circle());
    }}

//List or anything else is different than objects, you can pass subclass into drowShapes(Shapes s) like

// you can pass drawShapes(circle) where circle is a n implementation of Shapes but you can't do with others
//like drowShapes(List<Shapes> s) and call with a List of Circles, List<Circle>, you  have to use Lisr