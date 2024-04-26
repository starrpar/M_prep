package mprep;

import java.util.Date;
import java.time.LocalDate;
import java.util.*;

public class Employee {

    long id;
    String name;
    LocalDate DOB;
    String gender;
    String dept;

    // gender - provide count by gender
    // dept - IT
    // DOB (45 - 65 y/o)

    public void findOlderEmployees() {

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Employee e = new Employee();
            e.id = i;
            e.name = ((Integer) i).toString();
            e.DOB = LocalDate.of(1965, 1, 1);
            if (i % 2 == 0)
                e.gender = "male";
            else
                e.gender = "female";
            e.dept = "IT";
            employees.add(e);
        }

        for (Employee e : employees) {
            System.out.println(e.id);
            System.out.println(e.name);
            System.out.println(e.gender);
            System.out.println(e.DOB);
            System.out.println(e.dept);
        }

        int male = 0;
        int female = 0;
        for (Employee e : employees) {
            LocalDate today = LocalDate.now();
            LocalDate oneYearAgo = LocalDate.of(2023, 4, 25);
            long age = (e.DOB.toEpochDay() - today.toEpochDay()) / (oneYearAgo.toEpochDay() - today.toEpochDay());

            if (e.dept == "IT" && (age >= 45 && age <= 65)) {
                if (e.gender.toLowerCase() == "male")
                    male++;
                else
                    female++;
                System.out.println(male + ", " + female);
            }
        }
    }
}
