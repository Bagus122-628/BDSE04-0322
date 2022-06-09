import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SoftwareEngineerTest {

  SoftwareEngineer SE = new SoftwareEngineer("Yoghantara");
  TechnicalLead TL = new TechnicalLead("Jhon");
  Accountant ACT = new Accountant("Silva");
  BusinessLead BL = new BusinessLead("Ryan");

  @Test
  void testSetCodeAccessFalse() {
    SE.setCodeAccess(false);
    TL.addReport(SE);
    assertFalse(TL.approveCheckIn(SE));
  }

  @Test
  void testSetCodeAccessTrue() {
    SE.setCodeAccess(true);
    TL.addReport(SE);
    assertTrue(TL.approveCheckIn(SE));
  }

  @Test
  void testCanGetBonusFalse() {
    TL.addReport(SE);
    ACT.supportTeam(TL);
    BL.addReport(ACT, ACT.getTeamSupported());
    assertFalse(TL.requestBonus(SE, 20000000));
  }

  @Test
  void testCanGetBonusTrue() {
    TL.addReport(SE);
    ACT.supportTeam(TL);
    BL.addReport(ACT, ACT.getTeamSupported());
    assertTrue(TL.requestBonus(SE, 1000));
  }

}
