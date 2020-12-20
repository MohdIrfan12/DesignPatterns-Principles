package OODesignPatterns.structural;

import java.util.ArrayList;
import java.util.List;

/**
 * intent here is to -> Compose objects into tree structures to represent whole-part hierarchies.
 * Composite lets clients treat individual objects and compositions of objects uniformly.
 *
 *
 * Applicability
 * • you want to represent part-whole hierarchies of objects.
 * • you want clients to be able to ignore the difference between compositions of objects and individual objects. Clients
 *   will treat all objects in the composite structure uniformly.
 */
public class Composite {

    // A common interface for all employee. COMPONENT
    private interface Employee {
        public void showEmployeeDetails();
    }

    private static class Developer implements Employee {
        private String name;
        private long empId;
        private String position;

        public Developer(long empId, String name, String position) {
            // Assign the Employee id,
            // name and the position
            this.empId = empId;
            this.name = name;
            this.position = position;
        }

        @Override
        public void showEmployeeDetails() {
            System.out.println(empId + " " + name + " " + position);
        }
    }

    private static class Management implements Employee {
        private String name;
        private long empId;
        private String position;

        public Management(long empId, String name, String position) {
            this.empId = empId;
            this.name = name;
            this.position = position;
        }

        @Override
        public void showEmployeeDetails() {
            System.out.println(empId + " " + name + " " + position);
        }
    }


    // Class used to get Employee List, and do the operations like add or remove Employee.
    // COMPOSITE
    private static class COMPOSITE implements Employee {
        private List<Employee> employeeList = new ArrayList<Employee>();

        @Override
        public void showEmployeeDetails() {
            for (Employee emp : employeeList) {
                emp.showEmployeeDetails();
            }
        }

        public void addEmployee(Employee emp) {
            employeeList.add(emp);
        }

        public void removeEmployee(Employee emp) {
            employeeList.remove(emp);
        }
    }


    // Client
    public static void main(String[] args) {
        Developer dev = new Developer(100, "dev x", "developer");
        Developer dev1 = new Developer(100, "Alisha Bindal", "sr. developer");
        Developer dev2 = new Developer(101, "Saurabh Verma", "Team lead");
        Developer dev3 = new Developer(101, "Shashank Singla", "sr. Architect");
        COMPOSITE engTeamDirectory = new COMPOSITE();
        engTeamDirectory.addEmployee(dev);
        engTeamDirectory.addEmployee(dev1);
        engTeamDirectory.addEmployee(dev2);
        engTeamDirectory.addEmployee(dev3);
        engTeamDirectory.showEmployeeDetails();

        Management manager1 = new Management(200, "Vinamra mittal", "CEO");
        Management manager2 = new Management(201, "Shalini Sahu ", "ast. product manager");
        COMPOSITE managementDirectory = new COMPOSITE();
        managementDirectory.addEmployee(manager1);
        managementDirectory.addEmployee(manager2);
        engTeamDirectory.showEmployeeDetails();

        COMPOSITE employeeDirectory = new COMPOSITE();
        employeeDirectory.addEmployee(employeeDirectory);
        employeeDirectory.addEmployee(managementDirectory);
        employeeDirectory.showEmployeeDetails();
    }
}
