package com.stream.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

public class Streams {

	public static void main(String[] args) {

		List<Employee> employeeList = createEmployeeList();
		
		//Given a list of employees, you need to filter all the employee whose age is greater than 20 and print the employee names
		
		List<String> employeeName = employeeList.stream().filter(e -> e.getAge()>20).map(Employee::getName).collect(Collectors.toList());
		System.out.println(employeeName);
		
		//Given the list of employees, count number of employees with age 25?
		long count = employeeList.stream().filter(e -> e.getAge()>25).count();
		System.out.println(count);
		
		
		//Given the list of employees, find the employee with name “Mary”.
		List<Employee> employee = employeeList.stream().filter(e -> e.getName().equalsIgnoreCase("Mary")).map(e-> e).collect(Collectors.toList());
		System.out.println(employee);
		//else
		
		Optional<Employee> employeeOpt = employeeList.stream().filter(e -> e.getName().equalsIgnoreCase("Mary")).findAny();
		System.out.println(employeeOpt.get());
		
		
		//Given a list of employee, find maximum age of employee?
		Optional<Integer> age = employeeList.stream().map(Employee::getAge).max((e1,e2)-> e1.compareTo(e2));
		System.out.println(age);
		//else better way
        OptionalInt max = employeeList.stream().mapToInt(Employee::getAge).max();
			
        //Given a list of employees, sort all the employee on the basis of age?
        List<Employee> employeeSort = employeeList.stream().sorted((e1,e2)-> e1.getAge()-e2.getAge()).collect(Collectors.toList());
        System.out.println(employeeSort);
        
		Map<String, List<Employee>> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getName));
		map.forEach((name, employeeListTemp) -> System.out.println("Name: " + name + " ==>" + employeeListTemp));
        
		
		//Given the list of numbers, remove the duplicate elements from the list
		Integer[] arr = new Integer[] { 1, 2, 3, 4, 3, 2, 4, 2 };
		List<Integer> listWithDuplicates = Arrays.asList(arr);
		Set<Integer> setWithoutDups = listWithDuplicates.stream().collect(Collectors.toSet());
		setWithoutDups.forEach((i)->System.out.print(" "+i));
		
		System.out.println(" ");
		
		List<Integer> listWithoutDups = listWithDuplicates.stream().distinct().collect(Collectors.toList());
        listWithoutDups.forEach((i)->System.out.print(" "+i));
        System.out.println(" ");
        
        //Given a list of numbers, square them and filter the numbers which are greater 10000 and then find average of them.
        Integer[] arr2=new Integer[]{100,24,13,44,114,200,40,112};
        List<Integer> list = Arrays.asList(arr2);
        OptionalDouble average = list.stream()
                                 .mapToInt(n->n*n)
                                 .filter(n->n>10000)
                                 .average();
 
        if(average.isPresent())
            System.out.println(average.getAsDouble());
		  
	}
	
	public static List<Employee> createEmployeeList()
    {
        List<Employee> employeeList=new ArrayList<>();
 
        Employee e1=new Employee("John",21);
        Employee e2=new Employee("Martin",19);
        Employee e3=new Employee("Mary",31);
        Employee e4=new Employee("Stephan",18);
        Employee e5=new Employee("Gary",26);
 
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
 
        return employeeList;
    }

}
