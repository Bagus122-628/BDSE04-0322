public class BusinessEmployee extends Employee {

  public BusinessEmployee(String name, double baseSalary) {
    super(name, 50000);
  }

  public double getBonusBudget() {
    return bonusBudget;
  }

  public void setBonusBudget(double bonusBudget) {
    this.bonusBudget = bonusBudget;
  }

  @Override
  public String employeeStatus() {
    return super.toString() + " with a budget of " + bonusBudget;
  }

}
