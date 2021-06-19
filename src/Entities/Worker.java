package Entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(String name, Department department , WorkerLevel level, Double baseSalary) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department =  department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary; 
    }

    public List<HourContract> getContracts() {
		return contracts;
    }
    
    public void addContract(HourContract contract){
        this.contracts.add(contract);
    }

    public void removeContract(HourContract contract){
        this.contracts.remove(contract);
    }

    public Department getDepartment(){
        return this.department;
    }

    public double income (int month, int year){
       double sum  =  getBaseSalary();
       Calendar cal =  Calendar.getInstance();
       for(HourContract c : contracts){
            cal.setTime(c.getDate());
            int c_month =  1 +  cal.get(Calendar.MONTH);
            int c_year =  cal.get(Calendar.YEAR);
            if(month ==  c_month && year == c_year ){
                sum += c.totalValue();
            }
       }
        return sum;
    }

}
