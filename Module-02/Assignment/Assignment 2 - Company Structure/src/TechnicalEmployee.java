public class TechnicalEmployee extends Employee {
  private int checkIns;

  public TechnicalEmployee(String name, double baseSalary) {
    super(name, 75000);
    checkIns = 0;
  }

  @Override
  public String employeeStatus() {
    return super.toString() + " has " + checkIns + " successful check ins";
  }

  public void setCheckin() {
    checkIns++;
  }

}
