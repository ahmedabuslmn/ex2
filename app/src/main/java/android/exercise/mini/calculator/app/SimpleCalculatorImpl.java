package android.exercise.mini.calculator.app;

import java.io.Serializable;
import java.util.ArrayList;

public class SimpleCalculatorImpl implements SimpleCalculator {
   final char plus = '+' ;
   final char minus =  '-' ;
   final String empty = "0" ;
   String ScreenText = "0" ;

  // todo: add fields as needed
  @Override
  public String output() {
    // todo: return output based on the current state
    if(ScreenText.equals("0+")|| ScreenText.equals("0-"))
    {
      return ScreenText ;
    }
    if (ScreenText.equals("0")){

      return empty ;
     }
     return this.ScreenText.substring(1);
  }

  @Override
  public void insertDigit(int digit)  {

    if(digit > 9 || digit < 0  ){
      int a = 1/0 ;
    }
    this.ScreenText = this.ScreenText+ digit;
    // todo: insert a digit
  }

  @Override
  public void insertPlus() {
    if(this.ScreenText.charAt(this.ScreenText.length()-1) == plus
            || this.ScreenText.charAt(this.ScreenText.length()-1)==minus  )
    {
     this.ScreenText = this.ScreenText.substring(0,this.ScreenText.length()-1)+'+' ;

    }else {
      this.ScreenText = this.ScreenText + plus;
    }

    // todo: insert a plus
  }

  @Override
  public void insertMinus() {

    if(this.ScreenText.charAt(this.ScreenText.length()-1) == plus
            || this.ScreenText.charAt(this.ScreenText.length()-1)==minus  )
    {
      this.ScreenText = this.ScreenText.substring(0,this.ScreenText.length()-1)+'-' ;

    }else {
      this.ScreenText=this.ScreenText+minus ;

    // todo: insert a minus
  }
  }

  @Override
  public void insertEquals() {
    // todo: calculate the equation. after calling `insertEquals()`, the output should be the result
    //  e.g. given input "14+3", calling `insertEquals()`, and calling `output()`, output should be "17"
    // updating ScreenText  ;
    String delimiters = "[+\\-]";
    String[] tokensValString = ScreenText.split(delimiters);
    int[] tokenValInt = new int[tokensValString.length] ;
    String arth = "[0-9]+";
    String[] arthArr = ScreenText.split(arth);
    int index = 0 ;
    for (int i =0 ; i < tokenValInt.length ; i++)
    {
      tokenValInt[i] = Integer.parseInt(tokensValString[i]);
    }
    if(ScreenText.charAt(0)==minus)
    {
      tokenValInt[0]=-tokenValInt[0];
      index = 1;
    }
    int firstVal = tokenValInt[0] ;
    for(int i = 1 ; i<tokenValInt.length  ; i++ )
    {
      if(arthArr[i+index].equals("+"))
      {
        firstVal += tokenValInt[i] ;
      }else
        {
          firstVal-=tokenValInt[i] ;
        }
    }
    ScreenText = empty+firstVal ;
  }


  @Override
  public void deleteLast() {
    // todo: delete the last input (digit, plus or minus)
    //  e.g.
    //  if input was "12+3" and called `deleteLast()`, then delete the "3"
    //  if input was "12+" and called `deleteLast()`, then delete the "+"
    //  if no input was given, then there is nothing to do here
    if(ScreenText.equals(empty))
    {
      return;
    }
   if (ScreenText.length() == 2)
   {
     ScreenText =empty ;
    return;
   }
    ScreenText = ScreenText.substring(0, ScreenText.length() - 1) ;

  }

  @Override
  public void clear() {
    // todo: clear everything (same as no-input was never given)
        ScreenText = empty;
  }

  @Override
  public Serializable saveState() {
    CalculatorState state = new CalculatorState();
    state.ScreenText=this.ScreenText ;
    // todo: insert all data to the state, so in the future we can load from this state
    return state;
  }

  @Override
  public void loadState(Serializable prevState) {
    if (!(prevState instanceof CalculatorState)) {
      return; // ignore
    }
    CalculatorState casted = (CalculatorState) prevState;
    this.ScreenText = casted.ScreenText ;
    // todo: use the CalculatorState to load

  }

  private static class CalculatorState implements Serializable {
    public String ScreenText  ;
    /*
    TODO: add fields to this class that will store the calculator state
    all fields must only be from the types:
    - primitives (e.g. int, boolean, etc)
    - String
    - ArrayList<> where the type is a primitive or a String
    - HashMap<> where the types are primitives or a String
     */
  }

}
