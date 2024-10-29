This exercise assesses your understanding of writing Java functions that interact with each other.

Begin by creating a new Java Application (project). This application will be designed to calculate the sums of all odd and even numbers within a given int[] array, subsequently returning the product of these two sums.

For instance, consider the array {1,2,3,4,5,6}. Your application should output 108, calculated as follows: [(1+3+5)*(2+4+6) = 9*12 = 108].

1. The array can vary in size and might even be empty (return 0 in this scenario).
2. Implement at least three functions, including the "main" function that is automatically generated with the project.
3. Assign only a single task to each function (for example, one function could sum values, another could multiply them, and a third could display outputs).
4. There is no limit on the number of other functions a single function can invoke.
5. The "main" function should solely invoke other functions or display outputs (like text or results). Refrain from conducting any calculations directly within the "main" function.

Considering this is likely your initial venture into crafting an application from scratch, first dedicate 5 to 10 minutes to conceptualize how would you divide the application into functions (think the "interns" we used as an example on Monday):

What is their primary (and only) task (e.g. to sum, multiply or display)?
What data (parameters) does each function ("intern") need in order to do their task?
What data should they return back to their "caller" (e.g. the function that called them)
What other "interns" (functions) do they need to call to get their job done? If any, in what Order?

For this exercise, you're encouraged to utilize any available resource (such as Google, Bing, ChatGPT, Copilot, etc.). If you opt to use an AI tool, DO NOT ask it to write the entire application. Instead seek assistance with writing the individual functions (which you will then integrate). For example you can ask something like "Write a Java function that receives XXX does YYY with the data and then returns the result".

As a reminder - to create a new project in IntelliJ, navigate to: File > New > Project... then assign a name to your project (pick any name) and specify <Your Student Folder>/module-1/week-2/01_Loops_and_Arrays as the location.

 