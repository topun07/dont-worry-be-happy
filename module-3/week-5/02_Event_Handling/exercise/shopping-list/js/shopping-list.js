let allItemsIncomplete = true;
const pageTitle = "My Shopping List";
const groceries = [
  { id: 1, name: "Oatmeal", completed: false },
  { id: 2, name: "Milk", completed: false },
  { id: 3, name: "Banana", completed: false },
  { id: 4, name: "Strawberries", completed: false },
  { id: 5, name: "Lunch Meat", completed: false },
  { id: 6, name: "Bread", completed: false },
  { id: 7, name: "Grapes", completed: false },
  { id: 8, name: "Steak", completed: false },
  { id: 9, name: "Salad", completed: false },
  { id: 10, name: "Tea", completed: false },
];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById("title");
  title.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.querySelector("ul");
  groceries.forEach((item) => {
    const li = document.createElement("li");
    li.innerText = item.name;

    const checkCircle = document.createElement("i");
    checkCircle.setAttribute("class", "far fa-check-circle");

    li.appendChild(checkCircle);
    ul.appendChild(li);

    // Event listener for marking item complete
    li.addEventListener("click", () => {
      if (!li.classList.contains("completed")) {
        li.classList.add("completed");
        checkCircle.classList.add("completed");
        item.completed = true;
      }
    });

    // Event listener for marking item incomplete
    li.addEventListener("dblclick", () => {
      if (li.classList.contains("completed")) {
        li.classList.remove("completed");
        checkCircle.classList.remove("completed");
        item.completed = false;
      }
    });
  });
}

/**
 * Toggles all items between complete and incomplete.
 */
function toggleAllItems() {
  const button = document.getElementById("toggleAll");
  const items = document.querySelectorAll("li");

  if (allItemsIncomplete) {
    items.forEach((item, index) => {
      item.classList.add("completed");
      item.querySelector("i").classList.add("completed");
      groceries[index].completed = true;
    });
    button.innerText = "Mark All Incomplete";
  } else {
    items.forEach((item, index) => {
      item.classList.remove("completed");
      item.querySelector("i").classList.remove("completed");
      groceries[index].completed = false;
    });
    button.innerText = "Mark All Complete";
  }
  allItemsIncomplete = !allItemsIncomplete;
}

// Run setup when DOM is loaded
document.addEventListener("DOMContentLoaded", () => {
  setPageTitle();
  displayGroceries();

  // Add event listener for toggle button
  document
    .getElementById("toggleAll")
    .addEventListener("click", toggleAllItems);
});
