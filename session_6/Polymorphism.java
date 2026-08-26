public class Polymorphism {
    public static void main(String[] args) {
        System.out.println("=== Compile-time Polymorphism (Method Overloading) ===");
        Employee emp = new Employee("Generic Staff", 101);
        System.out.println("Standard Salary (40 hrs @ $20/hr): $" + emp.calculateSalary(40f, 20f));
        System.out.println("Salary with Bonus: $" + emp.calculateSalary(40f, 20f, 500f));

        System.out.println("\n=== Runtime Polymorphism (Dynamic Method Dispatch) ===");
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Alice", 102);
        employees[1] = new SalariedEmployee("Bob", 103, 5000f);
        employees[2] = new HourlyEmployee("Charlie", 104, 45f, 25f);

        for (Employee e : employees) {
            e.displayInfo();
        }
    }
}

class Employee {
    String name;
    int id;
    float salary;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Method Overloading: calculateSalary with 2 parameters
    float calculateSalary(float hours, float wage) {
        salary = hours * wage;
        return salary;
    }

    // Method Overloading: calculateSalary with 3 parameters (including bonus)
    float calculateSalary(float hours, float wage, float bonus) {
        salary = (hours * wage) + bonus;
        return salary;
    }

    void displayInfo() {
        System.out.println("Employee ID: " + id + ", Name: " + name + " [Base Employee Role]");
    }
}

class SalariedEmployee extends Employee {
    float monthlySalary;

    SalariedEmployee(String name, int id, float monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    void displayInfo() {
        System.out.println("Employee ID: " + id + ", Name: " + name + " [Salaried] - Monthly Pay: $" + monthlySalary);
    }
}

class HourlyEmployee extends Employee {
    float hoursWorked;
    float hourlyRate;

    HourlyEmployee(String name, int id, float hoursWorked, float hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
        this.salary = hoursWorked * hourlyRate;
    }

    @Override
    void displayInfo() {
        System.out.println("Employee ID: " + id + ", Name: " + name + " [Hourly] - Worked: " + hoursWorked + " hrs @ $" + hourlyRate + "/hr (Total: $" + salary + ")");
    }
}
