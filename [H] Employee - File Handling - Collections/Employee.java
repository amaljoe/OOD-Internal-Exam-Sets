import java.io.*;
import java.util.*;

// Develop an application to read the details of employees including name
// ,age,address,department and salary from a file .
// Write functions
// (a) to perform sorting of employees based on salary
// (b) to display the salary of the highest paid employee
// (c) to write the list of employees with details into a file in the increasing order
// of their salary.

public class Employee {
    String name;
    int age;
    String address;
    String department;
    double salary;

    Employee(String name, String age, String address, String department, String salary) {
        this.name = name;
        this.age = Integer.parseInt(age);
        this.address = address;
        this.department = department;
        this.salary = Double.parseDouble(salary);
    }

    @Override
    public String toString() {
        return name + "," + age + "," + address + "," + department + "," + salary;
    }

    public static void main(String[] args) throws IOException {
        // read the contents of file
        File file = new File("employees.txt");
        FileReader fr = new FileReader(file);
        int read;
        ArrayList<Employee> employees = new ArrayList<Employee>();
        String name = "";
        String age = "";
        String address = "";
        String department = "";
        String salary = "";
        int i = 0;
        while ((read = fr.read()) != -1) {
            char ch = (char) read;
            if (ch == '\n') {
                i = 0;
                employees.add(new Employee(name, age, address, department, salary));
                name = "";
                age = "";
                address = "";
                department = "";
                salary = "";
            } else {
                if (ch == ',') {
                    i++;
                } else {
                    switch (i) {
                        case 0:
                            name += ch;
                            break;
                        case 1:
                            age += ch;
                            break;
                        case 2:
                            address += ch;
                            break;
                        case 3:
                            department += ch;
                            break;
                        case 4:
                            salary += ch;
                            break;
                    }
                }
            }
        }
        employees.add(new Employee(name, age, address, department, salary));
        fr.close();
        employees.sort(new SortBySalary());
        ListIterator<Employee> itr= employees.listIterator();
        System.out.println("Employees sorted in ascending order:");
        FileWriter fw = new FileWriter("employees_sorted.txt");
        while(itr.hasNext())
        {
            Employee employee = itr.next();
            System.out.println(employee.name);
            fw.append(employee.toString() + "\n");
        }
        Employee highestPaidEmployee = employees.get(employees.size() - 1);
        System.out.println("Highest paid employee:" + highestPaidEmployee.name);
        System.out.println(highestPaidEmployee.toString());
        fw.close();
    }
}

class SortBySalary implements Comparator<Employee>
{
    public int compare(Employee a, Employee b)
    {
        return (int) a.salary - (int) b.salary;
    }
}
