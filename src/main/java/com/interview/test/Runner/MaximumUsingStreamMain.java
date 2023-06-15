package com.interview.test.Runner;


import java.util.*;
import java.util.stream.Collectors;

public class MaximumUsingStreamMain {

    public static void main(String args[])
    {
        //EmployeeWithAgeGreaterThan20();
       //Given a list of employees, you need to filter all the employee whose age is greater
        // than 20 and print the employee names.(Java 8 APIs only)

        //CountEmployeeWithAgeGreaterThan20();
        //Given the list of employees, count number of employees with age 25?

        //FindEmployeeWithNameMarry();
        //Given the list of employees, find the employee with name “Mary”.

        //FindEmployeeWithMaximumAge();
        //Given a list of employee, find maximum age of employee?

        //SortEmployeeByAge();
        //Given a list of employees, sort all the employee on the basis of age?

        //groupEmployeeByName();
        //Given the list of employee, group them by employee name?

       // removeDuplicatesFromIntegers();
        //Given the list of numbers, remove the duplicate elements from the list.
        
        sqaureAndFilter();
        //Given a list of numbers, square them and filter the numbers which are greater 10000 
        // and then find average of them

    }

    private static void sqaureAndFilter() {
        Integer[] arr=new Integer[]{100,24,13,44,114,200,40,112};
        List<Integer> list = Arrays.asList(arr);
        OptionalDouble average = list.stream()
                .mapToInt(n->n*n)
                .filter(n->n>10000)
                .average();

        if(average.isPresent())
            System.out.println(average.getAsDouble());
    }

    private static void removeDuplicatesFromIntegers() {
        Integer[] arr=new Integer[]{1,2,3,4,3,2,4,2};
        List<Integer> listWithDuplicates = Arrays.asList(arr);

        Set<Integer> setWithoutDups = listWithDuplicates.stream().collect(Collectors.toSet());
        setWithoutDups.forEach((i)->System.out.print(" "+i));
    }

    private static void groupEmployeeByName() {
        List<Employee> employeeList = createEmployeeList();
        Map<String, List<Employee>> map = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getName));
        map.forEach((key,value)->System.out.println(key+"-> "+value));

    }

    private static void SortEmployeeByAge() {
        List<Employee> employeeList = createEmployeeList();
        employeeList.sort((e1,e2)->e1.getAge()-e2.getAge());
        //or
        employeeList.sort(Comparator.comparingInt(Employee::getAge));
        employeeList.forEach(System.out::println);
    }

    private static void FindEmployeeWithMaximumAge() {
        List<Employee> employeeList = createEmployeeList();
        OptionalInt max = employeeList.stream().
                mapToInt(Employee::getAge).max();

        if(max.isPresent())
            System.out.println("Maximum age of Employee: "+max.getAsInt());

    }

    private static void FindEmployeeWithNameMarry() {
        List<Employee> employeeList = createEmployeeList();
        employeeList.stream().filter(name -> name.getName().equals("Mary")).forEach(System.out::println);
        //or
        List<Integer> employeee = employeeList.stream().filter(name -> name.getName().equals("Mary")).
                map(Employee::getAge).collect(Collectors.toList());

        employeee.forEach(System.out::println);

        //or
        Optional<Employee> employeeWithNameMary = employeeList.stream()
                .filter(employee -> employee.getName().equals("Mary"))
                .findFirst();
        //findFirst methods from the Java 8 Stream API to find the first employee in the list whose name is "Mary"
        if (employeeWithNameMary.isPresent()) {
            System.out.println("Employee with name Mary found: " + employeeWithNameMary.get().getName());
        } else {
            System.out.println("Employee with name Mary not found.");
        }

        //or using findAny
        Optional<Employee> e1 = employeeList.stream()
                .filter(e->e.getName().equalsIgnoreCase("Mary")).findAny();

        if(e1.isPresent())
            System.out.println(e1.get());

    }

    private static void CountEmployeeWithAgeGreaterThan20() {
        List<Employee> employeeList = createEmployeeList();
        long x = employeeList.stream().filter(emp -> emp.getAge()>20).count();
        System.out.println(x);
    }

    private static void EmployeeWithAgeGreaterThan20() {
        List<Employee> employeeList = createEmployeeList();

        List<String> emplNames = employeeList.stream().filter(emp -> emp.getAge()>20).
                map(Employee::getName).collect(Collectors.toList());

        emplNames.stream().forEach(name->System.out.println(name));
        //or
        emplNames.stream().forEach(System.out::println);

        // another way
        employeeList.stream()
                .filter(employee -> employee.getAge() > 20)
                .forEach(employee -> System.out.println(employee.getName()));
    }


    public static List<Employee> createEmployeeList()
    {
        List<Employee> employeeList=new ArrayList<>();

        Employee e1=new Employee("John",21);
        Employee e2=new Employee("Martin",19);
        Employee e3=new Employee("Mary",31);
        Employee e4=new Employee("Stephan",18);
        Employee e5=new Employee("Gary",26);
        Employee e6=new Employee("Mary",22);
        Employee e7=new Employee("Gary",44);


        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
        employeeList.add(e6);
        employeeList.add(e7);

        return employeeList;
    }
}
