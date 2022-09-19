package com.example.demo.view;


import com.example.demo.service.DepartmentService;
import com.example.demo.service.LectorService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class View {
    private static final Scanner scanner = new Scanner(System.in);

    private DepartmentService departmentService;

    private LectorService lectorService;

    private final Map<String, Printable> menu = new LinkedHashMap<>();

    public View(DepartmentService departmentService, LectorService lectorService){
        this.departmentService = departmentService;
        this.lectorService = lectorService;
        menu.put("1", this::findHeadByDepartmentName);
        menu.put("2", this::showStatistics);
        menu.put("3", this::averageSalary);
        menu.put("4", this::countOfEmployee);
        menu.put("5", this::globalSearch);

    }
    public void displayMenu() {
        System.out.println("=======================================================================");
        System.out.println("                 Enter a number to choose the option, where:");
        System.out.println("=======================================================================");
        System.out.println("  1 - Who is a head of department  |");
        System.out.println("  2 - Show statistics.             |");
        System.out.println("  3 - Show the average salary      |");
        System.out.println("  4 - Show count of employee       |");
        System.out.println("  5 - Global search                |");
        System.out.println("====================================");
    }

    private void findHeadByDepartmentName(){
        System.out.println("\n[Head of department]");
        System.out.println("Print department name");
        String name = scanner.next();
        System.out.println("\n\n" + departmentService.findHeadByDepartmentName(name) + "\n");

        System.out.println("Print 0 to return to the main menu");
        if (scanner.nextInt() == 0)
            show();
    }

    private void showStatistics(){
        System.out.println("\n[Show statistics]");
        System.out.println("Print department name");
        String name = scanner.next();
        System.out.println("\n\n" + departmentService.countEmployeesByRoleAndDepartment(name) + "\n");

        System.out.println("Print 0 to return to the main menu");
        if (scanner.nextInt() == 0)
            show();
    }

    private void averageSalary(){
        System.out.println("\n[Average salary by department]");
        System.out.println("Print department name");
        String name = scanner.next();
        System.out.println("\n\n" + departmentService.averageSalary(name) + "\n");

        System.out.println("Print 0 to return to the main menu");
        if (scanner.nextInt() == 0)
            show();
    }

    private void countOfEmployee(){
        System.out.println("\n[Show count of employee]");
        System.out.println("Print department name");
        String name = scanner.next();
        System.out.println("\n\n" + departmentService.countEmployeesByDepartment(name) + "\n");

        System.out.println("Print 0 to return to the main menu");
        if (scanner.nextInt() == 0)
            show();
    }

    private void globalSearch(){
        System.out.println("\n[GlobalSearch]");
        System.out.println("Print part of employee name");
        String name = scanner.next();
        System.out.println("\n\n" + lectorService.findByPartName(name) + "\n");

        System.out.println("Print 0 to return to the main menu");
        if (scanner.nextInt() == 0)
            show();
    }

    public final void show() {
        String input;
        displayMenu();
        System.out.println("\nChoose an option:\n");
        do {
            try {
                input = scanner.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (scanner.hasNext());
    }
}
