package Garage;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CardCompany {
  List<CreditCard> cards;

  public  CardCompany(){
      cards = new ArrayList<CreditCard>();
      CreditCard a;
      a=new CreditCard("123",5000);
      cards.add(a);
      CreditCard a2;
      a2=new CreditCard("124",5000);
      cards.add(a2);
      CreditCard a3;
      a3=new CreditCard("125",5000);
      cards.add(a3);
      CreditCard a5;
      a5=new CreditCard("126",10);
      cards.add(a5);
  }


  public boolean Pay(String ID ,double amount){
      for (CreditCard searchCard : cards) {
          if (searchCard.getId().equals(ID))
              return searchCard.pay(amount);
      }

      return false;
  }

  public double getBalance(String Id) {
      for (CreditCard searchCard : cards) {
          if (searchCard.getId().equals(Id))
              return searchCard.getBalance();

      }
      return -1;

  }
}
