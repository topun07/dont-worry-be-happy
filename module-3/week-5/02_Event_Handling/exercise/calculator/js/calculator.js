document.addEventListener("DOMContentLoaded", () => {
  let display = document.getElementById("display");
  let previous = null;
  let operator = null;
  let operatorClicked = false;

  function performOperation() {
    let result;
    const current = parseNumber(display.value);
    previous = parseNumber(previous);

    switch (operator) {
      case "+":
        result = previous + current;
        break;
      case "-":
        result = previous - current;
        break;
      case "*":
        result = previous * current;
        break;
      case "/":
        result = previous / current;
        break;
    }

    display.value = result;
    operator = null;
  }

  function parseNumber(num) {
    return num.includes(".") ? parseFloat(num) : parseInt(num);
  }

  function clickOperator(event) {
    operator = event.target.value;
    previous = display.value;
    operatorClicked = true;
  }

  function clickNumber(event) {
    const val = event.target.value;

    if (operatorClicked) {
      display.value = val;
      operatorClicked = false;
    } else {
      display.value == 0 ? (display.value = val) : (display.value += val);
    }
  }

  function clear() {
    display.value = 0;
  }

  // Get number buttons
  const numbers = document.querySelectorAll(".number");
  numbers.forEach((num) => num.addEventListener("click", clickNumber));

  // Get decimal button
  const decimal = document.querySelector(".decimal");
  if (decimal) decimal.addEventListener("click", clickNumber);

  // Get clear button
  const allClear = document.querySelector(".all-clear");
  if (allClear) allClear.addEventListener("click", clear);

  // Get operator buttons
  const operators = document.querySelectorAll(".operator");
  operators.forEach((op) => op.addEventListener("click", clickOperator));

  // Get equal button
  const equals = document.querySelector(".equal-sign");
  if (equals) equals.addEventListener("click", performOperation);
});
