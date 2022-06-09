import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class AccountantTest {

  Accountant ACT = new Accountant("Silva");
  TechnicalLead TL = new TechnicalLead("Jhon");
  SoftwareEngineer SE = new SoftwareEngineer("Yoghantara");

  @Test
  void testCanApproveBonusFalse() {
    TL.addReport(SE);
    ACT.supportTeam(TL);
    assertFalse(ACT.canApproveBonus(20000000));
  }

  @Test
  void testCanApproveBonusTrue() {
    TL.addReport(SE);
    ACT.supportTeam(TL);
    assertTrue(ACT.canApproveBonus(1000));
  }

}
