package fr.marcwrobel.jbanking.creditcard;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Creditcard {
  public static boolean checkCardValid(String ccNumber) {
    String card = ccNumber;

    String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
      "(?<mastercard>5[1-5][0-9]{14})|" +
      "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
      "(?<amex>3[47][0-9]{13})|" +
      "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
      "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";

    Pattern pattern = Pattern.compile(regex);


    card = card.replaceAll("-", "");
    Matcher matcher = pattern.matcher(card);

    if (matcher.matches()) {
      return checkSumValidation(card);
    } else {
      return false;
    }
  }

  public static String getCreditCardGroup(String ccNumber) {
    String card = ccNumber;

    String visaRegex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?))$";
    String mcRegex = "^(?:(?<mastercard>5[1-5][0-9]{14}))$";
    String discRegex = "^(?:(?<discover>6(?:011|5[0-9]{2})[0-9]{12}))$";
    String amexRegex = "^(?:(?<amex>3[47][0-9]{13}))$";
    String dinersRegex = "^(?:(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11}))$";
    String jcbRegex = "^(?:(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";

    String[] regex = {visaRegex, mcRegex, discRegex, amexRegex, dinersRegex, jcbRegex};
    String[] anbieter = {"visa", "mastercard", "discover", "amex", "diners", "jcb"};

    int counter = 0;
    card = card.replaceAll("-", "");

    for (String reg: regex) {
      String anb = anbieter[counter];
      Pattern pattern = Pattern.compile(reg);
      Matcher matcher = pattern.matcher(card);
      if(matcher.matches()) {
        return anb;
      }
      counter++;
    }

    return "ERROR!";
  }

  public static boolean checkSumValidation(String ccNumber)
  {
    ccNumber = ccNumber.replaceAll("-", "");
    int sum = 0;
    boolean alternate = false;
    for (int i = ccNumber.length() - 1; i >= 0; i--)
    {
      int n = Integer.parseInt(ccNumber.substring(i, i + 1));
      if (alternate)
      {
        n *= 2;
        if (n > 9)
        {
          n = (n % 10) + 1;
        }
      }
      sum += n;
      alternate = !alternate;
    }
    return (sum % 10 == 0);
  }
}
