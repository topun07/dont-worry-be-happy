package com.techelevator;

public abstract class Wall extends PaintCalculator{
    //instance variable
    private final String name;
    private final String color;


    //constructor
    public Wall(String name, String color){
        this.name = name;
        this.color = color;
    }

    //getters
    public String getName(){
        return name;
    }

    public String getColor(){
        return color;
    }

    public abstract int getArea();
}

/*
### Step One: Implement the `Wall` class

The `Wall` class can't be directly instantiated. It has two instance variables, `name` and `color`, that are readonly.
Add a constructor that looks like this:

``` Java
public Wall(String name, String color)
```

It also has one public method that subclasses must implement. `getArea()` takes no parameters and returns an integer
representing the total area of the wall.

To complete this step, you must:
- Verify that all tests in `/src/test/java/com/techelevator/WallTest` pass.
- Uncomment any code that's commented out following `// Step One:`.
- Run the application and perform any steps available.
*/
