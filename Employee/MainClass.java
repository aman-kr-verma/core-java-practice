import java.util.*;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101,"aman",101,"Active",2000));
        employees.add(new Employee(102,"siva",101,"Active",3000));
        employees.add(new Employee(103,"hanuman",102,"Active",2400));
        employees.add(new Employee(104,"bheem",103,"InActive",2060));
        employees.add(new Employee(105,"arjun",103,"Active",6000));
        employees.add(new Employee(106,"bali",102,"InActive",1200));


        // Employees based on per departments
        Map<Integer,List<Employee>> empsBasedOnDepts = employees.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.toList()));
//        empsBasedOnDepts.entrySet().forEach(entry -> {
//            System.out.println(entry.getKey() + " ---- " + entry.getValue());
//        });

        //empsBasedOnDepts.forEach((a,b)->);

        //Employee Count per dept
        Map<Integer,Long> empCountOnDepts = employees.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.counting()));
        empCountOnDepts.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        });

        //employee with status active
        List<Employee> activeEmployees = employees.stream().filter(e->"Active".equals(e.getStatus())).collect(Collectors.toList());
        for (Employee e: activeEmployees ) {
            //System.out.println(e.getEmpId() + e.getEmpName() + e.getDeptId() + e.getStatus() + e.getSalary());
            System.out.println(e.toString());
        }

        //employees with status inactive
        List<Employee> inactiveEmployees = employees.stream().filter(e->"InActive".equals(e.getStatus())).collect(Collectors.toList());
        for (Employee e: inactiveEmployees) {
            System.out.println(e.toString());
        }

        //max salary
        Employee maxSalaryEmployee = employees.stream().max(Comparator.comparing(Employee::getSalary)).get();
        System.out.println("max salary is " + maxSalaryEmployee.getSalary());

        //min salary
        Optional<Employee> minSalaryEmployee = employees.stream().min(Comparator.comparing(Employee::getSalary));
        System.out.println("min salary is " + minSalaryEmployee.get().getSalary());
    }
}
