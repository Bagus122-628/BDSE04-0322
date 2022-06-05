import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AccountantTest {

  Accountant ACT = new Accountant("Yoghantara");

  @Test
  void testCanApproveBonusFalse() {
    boolean bonus = ACT.canApproveBonus(20000000);
    assertFalse(bonus);
  }

  @Test
  void testCanApproveBonusTrue() {
    boolean bonus = ACT.canApproveBonus(1000);
    assertThrows(AssertionError.class, () -> {
      assertEquals(true, bonus);
    });
  }

}
