package com.example.calculus;

public class CalculatorModel {
    int firstArg;
    int secondArg;

    StringBuilder inputStr = new StringBuilder();

    private State state;

    private int actionSelected;


    private enum State {
        firstArgInput,
        secondArgInput,
        resultShow,
    }

    public CalculatorModel() {
        state = State.firstArgInput;
    }

    public void onNumPressed (int buttonId) {

        if (state == State.resultShow) {
            state = State.firstArgInput;
            inputStr.setLength(0);
        }
        if (inputStr.toString().equals("0")){
            return;
        }
        if (inputStr.length() <= 12) {
            switch (buttonId) {
                case R.id.zero:
                    inputStr.append("0");
                    break;
                case R.id.one:
                    inputStr.append("1");
                    break;
                case R.id.two:
                    inputStr.append("2");
                    break;
                case R.id.three:
                    inputStr.append("3");
                    break;
                case R.id.four:
                    inputStr.append("4");
                    break;
                case R.id.five:
                    inputStr.append("5");
                    break;
                case R.id.six:
                    inputStr.append("6");
                    break;
                case R.id.seven:
                    inputStr.append("7");
                    break;
                case R.id.eight:
                    inputStr.append("8");
                    break;
                case R.id.nine:
                    inputStr.append("9");
                    break;
            }
        }
    }

    public void onActionPressed(int actionId){
        if (actionId == R.id.backspace){
            if (inputStr.length() != 0) {
                inputStr.setLength(inputStr.length() - 1);
            }
        }
        if (actionId == R.id.clear){
            state = State.resultShow;
            inputStr.setLength(0);
        }
        if (actionId == R.id.equal && state == State.secondArgInput) {
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            switch (actionSelected) {

                case R.id.plus:
                    inputStr.append(firstArg + secondArg);
                    break;
                case R.id.minus:
                    inputStr.append(firstArg - secondArg);
                    break;
                case R.id.times:
                    inputStr.append(firstArg * secondArg);
                    break;
                case R.id.divide:
                    if (secondArg == 0){
                        inputStr.append("Division by zero");
                    }
                    else {
                        inputStr.append(firstArg / secondArg);
                    }
                    break;
            }
        }
        if (actionId == R.id.equal && state != State.secondArgInput) {
            firstArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            inputStr.append(firstArg);
        }else if (inputStr.length() > 0 && state == State.firstArgInput && actionId != R.id.backspace) {
            firstArg = Integer.parseInt(inputStr.toString());
            state = State.secondArgInput;
            inputStr.setLength(0);
            switch (actionId) {

                case R.id.plus:
                    actionSelected  = R.id.plus;
                    break;
                case R.id.minus:
                    actionSelected  = R.id.minus;
                    break;
                case R.id.times:
                    actionSelected = R.id.times;
                    break;
                case R.id.divide:
                    actionSelected = R.id.divide;
                    break;
            }
        }

        }

    public String getText() {
        return inputStr.toString();
    }
}
