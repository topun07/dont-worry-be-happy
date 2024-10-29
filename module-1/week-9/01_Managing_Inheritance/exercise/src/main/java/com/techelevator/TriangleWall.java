package com.techelevator;

public class TriangleWall extends Wall{
    //constructor
    private final int base;
    private final int height;

    public TriangleWall(String name, String color, int base, int height){
        super(name, color);
        this.base = base;
        this.height = height;
    }

    //getters
    public int getBase(){
        return base;
    }

    public int getHeight(){
        return height;
    }

    //method to calculate area
    @Override
    public int getArea(){
        return (base * height) / 2;
    }

    //to string method
    @Override
    public String toString(){
        return String.format("%s (%dx%d) triangle", getName(), base, height);
    }
}
/*
### Step Four: Implement the `TriangleWall` class

`TriangleWall` extends `Wall` and adds two new instance variables, `base` and `height`, that are readonly.
Add a constructor that looks like this:

``` Java
public TriangleWall(String name, String color, int base, int height)
```

`getArea()` returns the `base` multiplied by the `height` and then divided by two.

>Note: Dividing an `int` by another `int` rounds down the answer to the nearest whole number.

Add a `toString()` method that returns a `String` in the following format:

```
name (basexheight) triangle
```

To complete this step, you must:
- Verify that all tests in `/src/test/java/com/techelevator/TriangleWallTest` pass.
- Uncomment any code that's commented out following `// Step Four:`.
- Run the application and perform any steps available.

 */