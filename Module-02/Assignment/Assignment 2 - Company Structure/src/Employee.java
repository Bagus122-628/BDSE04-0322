public abstract class Employee {
  private String name;
  private static int ID;
  private int employeeID;
  public int headCount = 0;
  public double bonusBudget;
  public double baseSalary;
  public double bonus;
  public Employee manager;
  public Accountant accountantSupport;

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

  public Accountant getAccountantSupport() {
    return accountantSupport;
  }
}
