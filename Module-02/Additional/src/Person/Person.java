public class Person {
  String name;
  float age;
  char gender;

  public Person(String name, float age, char gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  public void displayInfo() {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Gender: " + gender);
  }
}
