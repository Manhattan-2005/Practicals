package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Stack;

public class Practical_9_Exercise2 extends AppCompatActivity {

    private EditText displayEditText;
    private double operand1 = Double.NaN;
    private String pendingOperation = "=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical9_exercise2);

        displayEditText = findViewById(R.id.input_For_Practical9_Exercise2);

        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                String currentText = displayEditText.getText().toString();

                if (currentText.isEmpty() || currentText.endsWith(".") || currentText.endsWith("-")) {
                    displayEditText.append(button.getText());
                } else if (currentText.startsWith("-") && currentText.length() == 1) {
                    // Treat single '-' as a number
                    displayEditText.append(button.getText());
                } else {
                    // Append other characters normally
                    displayEditText.append(button.getText());
                }
            }
        };


        findViewById(R.id.button0).setOnClickListener(numberClickListener);
        findViewById(R.id.button1).setOnClickListener(numberClickListener);
        findViewById(R.id.button2).setOnClickListener(numberClickListener);
        findViewById(R.id.button3).setOnClickListener(numberClickListener);
        findViewById(R.id.button4).setOnClickListener(numberClickListener);
        findViewById(R.id.button5).setOnClickListener(numberClickListener);
        findViewById(R.id.button6).setOnClickListener(numberClickListener);
        findViewById(R.id.button7).setOnClickListener(numberClickListener);
        findViewById(R.id.button8).setOnClickListener(numberClickListener);
        findViewById(R.id.button9).setOnClickListener(numberClickListener);
        findViewById(R.id.buttonAdd).setOnClickListener(numberClickListener);
        findViewById(R.id.buttonSubtract).setOnClickListener(numberClickListener);
        findViewById(R.id.buttonMultiply).setOnClickListener(numberClickListener);
        findViewById(R.id.buttonDivide).setOnClickListener(numberClickListener);
        findViewById(R.id.buttonOpeningParenthesis).setOnClickListener(numberClickListener);
        findViewById(R.id.buttonClosingParenthesis).setOnClickListener(numberClickListener);
        findViewById(R.id.buttonDecimalPoint).setOnClickListener(numberClickListener);

        findViewById(R.id.buttonEquals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayText = displayEditText.getText().toString();
                if (!displayText.isEmpty()) {
                    double result = performOperation(displayText);
                    displayEditText.setText(Double.toString(result));
                }
            }
        });

        findViewById(R.id.buttonAllClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                displayEditText.setText("");

            }
        });

        findViewById(R.id.buttonClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!displayEditText.getText().toString().isEmpty()){
                    displayEditText.setText(displayEditText.getText().toString().substring(0,displayEditText.getText().toString().length() - 1));
                }

            }
        });

    }

    public static double performOperation(String expression) {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '(') {
                operators.push(c);
            } else if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                i--;
                values.push(Double.parseDouble(sb.toString()));
            } else if (isOperator(c)) {
                while (!operators.isEmpty() &&
                        (operators.peek() != '(' && hasPrecedence(operators.peek(), c))) {
                    values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
            }
        }

        while (!operators.isEmpty()) {
            if (operators.peek() == '(') {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^';
    }

    private static boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '^' && op2 == '^') || (op1 == '^' && op2 != '^')) {
            return false;
        } else if ((op1 == '*' || op1 == '/' || op1 == '%') && (op2 == '+' || op2 == '-')) {
            return false;
        } else {
            return true;
        }
    }

    private static double applyOperation(char op, double operand2, double operand1) {
        switch (op) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            case '%':
                return operand1 % operand2;
            case '^':
                return Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }

}
