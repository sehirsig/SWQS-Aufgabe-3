package fr.marcwrobel.jbanking.creditcard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fr.marcwrobel.jbanking.TestUtils.shouldHaveThrown;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CreditcardTest {
  //4-Phasen-Testmuter
  // Setup: Text Fixture
  // Execute
  // Verify
  // Clean
  @Test
  @DisplayName("checkCardValid VisaSparkasseDE Test")
  void checkCardValid_VisaSparkasseDE() {
    // Setup: Text Fixture
    String creditcard = "4532-4184-1054-0713";
    // Execute
    boolean result = Creditcard.checkCardValid(creditcard);
    // Verify
    assertEquals(true, result, "4532-4184-1054-0713 should be a valid Credit Card");
    // Clean
  }

  @Test
  @DisplayName("checkSumValidation VisaSparkasseDE Test")
  void checkSumValidation_VisaSparkasseDE() {
    // Setup: Text Fixture
    String creditcard = "4532-4184-1054-0713";
    // Execute
    boolean result = Creditcard.checkSumValidation(creditcard);
    // Verify
    assertEquals(true, result, "4532-4184-1054-0713 should have a valid checkSum");
    // Clean
  }

  @Test
  @DisplayName("getCreditCardGroup VisaSparkasseDE Test")
  void getCreditCardGroup_VisaSparkasseDE() {
    // Setup: Text Fixture
    String creditcard = "4532-4184-1054-0713";
    // Execute
    String result = Creditcard.getCreditCardGroup(creditcard);
    // Verify
    assertEquals("visa", result, "4532-4184-1054-0713 should be a visa Credit Card");
    // Clean
  }

}
