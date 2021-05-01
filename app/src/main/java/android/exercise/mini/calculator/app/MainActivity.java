package android.exercise.mini.calculator.app;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

  @VisibleForTesting
  public SimpleCalculator calculator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (calculator == null) {
      calculator = new SimpleCalculatorImpl();
    }
    TextView ScreenOutput = findViewById(R.id.textViewCalculatorOutput);
    ScreenOutput.setText("0");

    TextView button0= findViewById(R.id.button0);
    TextView button1= findViewById(R.id.button1);
    TextView button2= findViewById(R.id.button2);
    TextView button3= findViewById(R.id.button3);
    TextView button4= findViewById(R.id.button4);
    TextView button5= findViewById(R.id.button5);
    TextView button6= findViewById(R.id.button6);
    TextView button7= findViewById(R.id.button7);
    TextView button8= findViewById(R.id.button8);
    TextView button9= findViewById(R.id.button9);
    TextView  plus =findViewById(R.id.buttonPlus);
    TextView  minus =findViewById(R.id.buttonMinus);
    View  backSpace =findViewById(R.id.buttonBackSpace);
    TextView  clear =findViewById(R.id.buttonClear) ;
     TextView  equalbutton = findViewById(R.id.buttonEquals);
    button0.setOnClickListener(v ->
    {
      calculator.insertDigit(0);
      ScreenOutput.setText(calculator.output());
    });
    button1.setOnClickListener(v ->
    {
      calculator.insertDigit(1);
      ScreenOutput.setText(calculator.output());
    });
    button2.setOnClickListener(v ->
    {
      calculator.insertDigit(2);
      ScreenOutput.setText(calculator.output());
    });
    button3.setOnClickListener(v ->
    {
      calculator.insertDigit(3);
      ScreenOutput.setText(calculator.output());
    });
    button4.setOnClickListener(v ->
    {
      calculator.insertDigit(4);
      ScreenOutput.setText(calculator.output());
    });
    button5.setOnClickListener(v ->
    {
      calculator.insertDigit(5);
      ScreenOutput.setText(calculator.output());
    });
    button6.setOnClickListener(v ->
    {
      calculator.insertDigit(6);
      ScreenOutput.setText(calculator.output());
    });
    button7.setOnClickListener(v ->
    {
      calculator.insertDigit(7);
      ScreenOutput.setText(calculator.output());
    });
    button8.setOnClickListener(v ->
    {
      calculator.insertDigit(8);
      ScreenOutput.setText(calculator.output());
    });
    button9.setOnClickListener(v ->
    {
      calculator.insertDigit(9);
      ScreenOutput.setText(calculator.output());
    });

    plus.setOnClickListener(v ->
    {
      calculator.insertPlus();
      ScreenOutput.setText(calculator.output());
    });
    minus.setOnClickListener(v ->
    {
      calculator.insertMinus();
      ScreenOutput.setText(calculator.output());
    });
    backSpace.setOnClickListener(v ->
    {
      calculator.deleteLast();
      ScreenOutput.setText(calculator.output());
    });

    clear.setOnClickListener(v ->
    {
      calculator.clear();
      ScreenOutput.setText(calculator.output());
    });
    equalbutton.setOnClickListener(v ->
    {
      calculator.insertEquals();
      ScreenOutput.setText(calculator.output());
    });


    /*

    TODO:

    - find all views
    - initial update main text-view based on calculator's output
    - set click listeners on all buttons to operate on the calculator and refresh main text-view
     */
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putSerializable("sve state ",calculator.saveState());
    // todo: save calculator state into the bundle1
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    // todo: restore calculator state from the bundle, refresh main text-view from calculator's output
    calculator.loadState(savedInstanceState.getSerializable("sve state "));
    ((TextView) findViewById(R.id.textViewCalculatorOutput)).setText(calculator.output());

  }
}