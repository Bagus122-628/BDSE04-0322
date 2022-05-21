public abstract class Employee {
  private String name;
  private double baseSalary;
  private int employeeID;
  private static int ID;
  private Employee manager;
  public double bonusBudget;

  public Employee(String name, double baseSalary) {
    this.name = name;
    this.baseSalary = baseSalary;
    ID++;
    this.employeeID = ID;
  }

  public double getBaseSalary() {
    return baseSalary;
  }

  public String getName() {
    return name;
  }

  public int getEmployeeID() {
    return employeeID;
  }

  public Employee getManager() {
    return manager;
  }

  public void setManager(Employee manager) {
    this.manager = manager;
  }

  public boolean equals(Employee other) {
    return this.getEmployeeID() == other.getEmployeeID();
  }

  public String toString() {
    return getEmployeeID() + " " + getName();
  }

  public abstract String employeeStatus();

  public void getBonus() {

  }
}
