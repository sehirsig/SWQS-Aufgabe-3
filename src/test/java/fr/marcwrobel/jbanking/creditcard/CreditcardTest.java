package fr.marcwrobel.jbanking.creditcard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
  @DisplayName("checkCardValid Card that starts with 0 Test")
  void checkCardValid_StartsWithZero() {
    // Setup: Text Fixture
    String creditcard = "0532-4184-1054-0713";
    // Execute
    boolean result = Creditcard.checkCardValid(creditcard);
    // Verify
    assertEquals(false, result, "0532-4184-1054-0713 should be a valid Credit Card");
    // Clean
  }

  @Test
  @DisplayName("checkCardValid MasterCard Test")
  void checkCardValid_MasterCard() {
    // Setup: Text Fixture
    String creditcard = "5412-7512-3412-3858";
    // Execute
    boolean result = Creditcard.checkCardValid(creditcard);
    // Verify
    assertEquals(true, result, "5412-7512-3412-3858 should be a valid Credit Card");
    // Clean
  }

  @Test
  @DisplayName("checkCardValid Amex Test")
  void checkCardValid_Amex() {
    // Setup: Text Fixture
    String creditcard = "3759-876543-21004";
    // Execute
    boolean result = Creditcard.checkCardValid(creditcard);
    // Verify
    assertEquals(true, result, "3759-876543-21004 should be a valid Credit Card");
    // Clean
  }

  @Test
  @DisplayName("checkCardValid JCB Test")
  void checkCardValid_JCB() {
    // Setup: Text Fixture
    String creditcard = "3566-0020-2036-0505";
    // Execute
    boolean result = Creditcard.checkCardValid(creditcard);
    // Verify
    assertEquals(true, result, "3566-0020-2036-0505 should be a valid Credit Card");
    // Clean
  }

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
  @DisplayName("empty String Test")
  void checkCardValid_EmptyString() {
    //Setup: Text Fixture
    String creditcard = "";
    //Exeute
    boolean result = Creditcard.checkCardValid(creditcard);
    //Verify
    assertEquals(false, result, "Empty string shouldnt be a valid Credit Card");
    //Clean
  }

  @Test
  @DisplayName("checkSumValidation Mastercard Test")
  void checkSumValidation_MasterCard() {
    // Setup: Text Fixture
    String creditcard = "5412-7512-3412-3858";
    // Execute
    boolean result = Creditcard.checkSumValidation(creditcard);
    // Verify
    assertEquals(true, result, "5412-7512-3412-3858 should have a valid checkSum");
    // Clean
  }

  @Test
  @DisplayName("checkSumValidation Amex Test")
  void checkSumValidation_Amex() {
    // Setup: Text Fixture
    String creditcard = "3759-876543-21004";
    // Execute
    boolean result = Creditcard.checkSumValidation(creditcard);
    // Verify
    assertEquals(true, result, "3759-876543-21004 should have a valid checkSum");
    // Clean
  }

  @Test
  @DisplayName("checkSumValidation JCB Test")
  void checkSumValidation_JCB() {
    // Setup: Text Fixture
    String creditcard = "3566-0020-2036-0505";
    // Execute
    boolean result = Creditcard.checkSumValidation(creditcard);
    // Verify
    assertEquals(true, result, "3566-0020-2036-0505 should have a valid checkSum");
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
  @DisplayName("checkSumValidation Invalid Test")
  void checkSumValidation_InValid() {
    // Setup: Text Fixture
    String creditcard = "4531-4184-1054-0713";
    // Execute
    boolean result = Creditcard.checkSumValidation(creditcard);
    // Verify
    assertEquals(false, result, "4531-4184-1054-0713 should not have a valid checkSum");
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

  @Test
  @DisplayName("getCreditCardGroup Mastercard Test")
  void getCreditCardGroup_MasterCard() {
    // Setup: Text Fixture
    String creditcard = "5412-7512-3412-3858";
    // Execute
    String result = Creditcard.getCreditCardGroup(creditcard);
    // Verify
    assertEquals("mastercard", result, "5412-7512-3412-3858 should be a mastercard Credit Card");
    // Clean
  }

  @Test
  @DisplayName("getCreditCardGroup Discover Test")
  void getCreditCardGroup_Discover() {
    // Setup: Text Fixture
    String creditcard = "6011-4184-1054-0713";
    // Execute
    String result = Creditcard.getCreditCardGroup(creditcard);
    // Verify
    assertEquals("discover", result, "6011-4184-1054-0713 should be a discover Credit Card");
    // Clean
  }

  @Test
  @DisplayName("getCreditCardGroup Amex Test")
  void getCreditCardGroup_Amex() {
    // Setup: Text Fixture
    String creditcard = "3759-876543-21004";
    // Execute
    String result = Creditcard.getCreditCardGroup(creditcard);
    // Verify
    assertEquals("amex", result, "3759-876543-21004 should be a amex Credit Card");
    // Clean
  }

  @Test
  @DisplayName("getCreditCardGroup Diners Test")
  void getCreditCardGroup_Diners() {
    // Setup: Text Fixture
    String creditcard = "30036-5923-21275";
    // Execute
    String result = Creditcard.getCreditCardGroup(creditcard);
    // Verify
    assertEquals("diners", result, "30036-5923-21275 should be a diners Credit Card");
    // Clean
  }
  @Test
  @DisplayName("getCreditCardGroup JCBE Test")
  void getCreditCardGroup_JCB() {
    // Setup: Text Fixture
    String creditcard = "3566-0020-2036-0505";
    // Execute
    String result = Creditcard.getCreditCardGroup(creditcard);
    // Verify
    assertEquals("jcb", result, "3566-0020-2036-0505 should be a visa Credit Card");
    // Clean
  }

  @Test
  @DisplayName("getCreditCardGroup Invalid Test")
  void getCreditCardGroup_Invalid() {
    // Setup: Text Fixture
    String creditcard = "0000-0000-0000-0000";
    // Execute
    String result = Creditcard.getCreditCardGroup(creditcard);
    // Verify
    assertEquals("ERROR!", result, "0000-0000-0000-0000 should return an ERROR");
    // Clean
  }

  @ParameterizedTest(name = "{0} should be from {1}")
  @CsvSource({
    "3566-0020-2036-0505, jcb",
    "30036-5923-21275, diners",
    "3759-876543-21004, amex",
    "6011-4184-1054-0713, discover",
    "5412-7512-3412-3858, mastercard",
    "4532-4184-1054-0713, visa",
    "xxxx-xxxx-xxxx-xxxx, ERROR!"
  })
  void getGroup(String cc, String expectedResult) {
    // Setup: Text Fixture
    // => CSVSOURCE
    // Execute
    String result = Creditcard.getCreditCardGroup(cc);
    // Verify
    assertEquals(expectedResult, result,
      cc + " should be from "  + expectedResult);
    // Clean
  }


}
