package Application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.Department;
import Entities.HourContract;
import Entities.Worker;
import Entities.WorkerLevel;

public class Program{
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc =  new Scanner(System.in);
        SimpleDateFormat spdf =  new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String department =  sc.nextLine();

        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String name =  sc.nextLine();
        System.out.print("Level: ");
        String level =  sc.nextLine();
        System.out.print("Base salary: ");
        Double baseSalary = sc.nextDouble();
        sc.nextLine();

        Worker worker = new Worker(name, new Department(department), WorkerLevel.valueOf(level), baseSalary);

        System.out.print("How many contracts to this worker? ");
        Integer numContract = sc.nextInt();
        for(int i = 1 ;  i <= numContract ;  i++){
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date date = spdf.parse(sc.next());
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble(); 
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            sc.nextLine();
            HourContract contract= new HourContract(date, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear =  sc.nextLine();

        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year  = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: "+worker.getName() );
        System.out.println("Department: "+worker.getDepartment().getName());
        System.out.println("Income: "+worker.income(month, year));
       
        sc.close();
    }


}