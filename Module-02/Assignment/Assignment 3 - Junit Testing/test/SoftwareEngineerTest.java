import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SoftwareEngineerTest {

  SoftwareEngineer SE = new SoftwareEngineer("Yoghantara");

  @Test
  void testSetCodeAccessFalse() {
    SE.setCodeAccess(false);
    boolean assumptions = SE.getCodeAccess();
    assertFalse(assumptions);
  }

  @Test
  void testSetCodeAccessTrue() {
    SE.setCodeAccess(true);
    boolean assumptions = SE.getCodeAccess();
    assertTrue(assumptions);
  }

}
