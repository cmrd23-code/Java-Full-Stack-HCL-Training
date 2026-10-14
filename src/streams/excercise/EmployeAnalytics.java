package streams.excercise;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

public class EmployeAnalytics {
    String name;
    record Employee(int id, String name, String dept, BigDecimal salary,
                    LocalDate hireDate, Set<String> skills) {}

    static Employee e(int id, String n, String d, int sal, String date, String... skills) {
        return new Employee(id, n, d, BigDecimal.valueOf(sal),
                LocalDate.parse(date), Set.of(skills));
    }
    public static void main(String[] args) {
        List<Employee> emps = List.of(
                e(1, "Asha",   "Engineering",  90000, "2019-03-01", "Java", "SQL"),
                e(2, "Ravi",   "Engineering", 120000, "2016-07-15", "Java", "Spring", "AWS"),
                e(3, "Meera",  "HR",           60000, "2020-01-10", "Recruiting"),
                e(4, "John",   "Sales",        70000, "2018-11-20", "Negotiation", "CRM"),
                e(5, "Priya",  "Engineering", 105000, "2021-05-05", "Java", "React"),
                e(6, "Karan",  "Sales",        65000, "2022-02-14", "CRM"),
                e(7, "Sara",   "HR",           62000, "2017-09-09", "Recruiting", "Payroll"),
                e(8, "Vikram", "Finance",      80000, "2015-04-30", "Excel", "SQL"));
        // Solve Q1 to Q12 below
        //**************Level-1****************
        //---------Solution of Q1---------------
        List<Employee> engineering = emps.stream().filter(s -> s.dept().equals("Engineering"))
                .sorted((s1, s2) -> s2.salary().compareTo(s1.salary()))
                .toList();
        engineering.forEach(s-> System.out.println(s.name() + " " + s.salary()));
        //----------Solution of Q2----------------
        List<Employee> top3 = emps.stream().sorted((s1, s2)-> s2.salary().compareTo(s1.salary()))
                .limit(3)
                .toList();
        top3.forEach(s-> System.out.print(s.name() + " "));
        //----------Solution of Q3----------------

        List<String> recentHires = emps.stream().filter(s->s.hireDate().isBefore(LocalDate.parse("2018-01-01")))
                .sorted((s1, s2) -> s2.hireDate().compareTo(s1.hireDate()))
                .map(s -> s.name() + " (" + s.hireDate().getYear() + ")")
                .toList();
        System.out.println("");
        recentHires.forEach(s-> System.out.print(s+" "));
        System.out.println("");
        //----------Solution of Q4----------------
        String allNames = emps.stream().map(Employee::name).collect(Collectors.joining(", "));
        System.out.println(allNames);
        //*********************Level-2****************
        //----------Solution of Q5----------------
        BigDecimal totalPayroll = emps.stream().map(Employee::salary).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total Payroll: " + totalPayroll);
        //----------Solution of Q6----------------
        boolean hasAWSSkill = emps.stream().anyMatch(s -> s.skills().contains("AWS"));
        boolean allHaveHighSalary = emps.stream().allMatch(s -> s.salary().compareTo(BigDecimal.valueOf(50000)) > 0);
        boolean noneHaveVeryHighSalary = emps.stream().noneMatch(s -> s.salary().compareTo(BigDecimal.valueOf(150000)) > 0);
        System.out.println("Has AWS skill: " + hasAWSSkill);
        System.out.println("All have high salary: " + allHaveHighSalary);
        System.out.println("None have very high salary: " + noneHaveVeryHighSalary);
        //----------Solution of Q7----------------
        Optional<Employee> highestPaid = emps.stream().max(Comparator.comparing(Employee::salary));
        System.out.println("Highest-paid employee: " + highestPaid.map(Employee::name).orElse("none"));
        //*********************Level-3****************
        //----------Solution of Q8----------------
        Map<String, Double> avgSalaryPerDept = emps.stream()
                .collect(Collectors.groupingBy(Employee::dept, Collectors.averagingDouble(s -> s.salary().doubleValue())));
        System.out.println("Average salary per department: " + avgSalaryPerDept);
        //----------Solution of Q9----------------
        Map<String, String> highestPaidPerDept = emps.stream()
                .collect(Collectors.groupingBy(Employee::dept, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::salary)), opt -> opt.map(Employee::name).orElse("none"))));
        System.out.println("Highest-paid employee per department: " + highestPaidPerDept);
        //----------Solution of Q10----------------
        Map<Boolean, List<Employee>> partitionedBySalary = emps.stream()
                .collect(Collectors.partitioningBy(s -> s.salary().compareTo(BigDecimal.valueOf(75000)) >= 0));
        System.out.println("Employees with salary >= 75000: ");
        partitionedBySalary.get(true).forEach(emp -> System.out.println("  " + emp.name()));
        System.out.println("Employees with salary < 75000: ");
        partitionedBySalary.get(false).forEach(emp -> System.out.println("  " + emp.name()));
        //*********************Level-4****************
        //----------Solution of Q11----------------
        List<String> distinctSkills = emps.stream()
                .flatMap(emp -> emp.skills().stream())
                .distinct()
                .sorted()
                .collect(toList());
        System.out.println("Sorted list of distinct skills: " + distinctSkills);
        //----------Solution of Q12----------------
        Map<String, Long> skillFrequency = emps.stream()
                .flatMap(emp -> emp.skills().stream())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));
        String mostCommonSkill = skillFrequency.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("none");
        System.out.println("Most common skill: " + mostCommonSkill);

        }
    }