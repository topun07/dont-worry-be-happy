package com.techelevator;

public class RectangleWall extends Wall {
    //instances
    public int length;
    public int height;

    //constructor
    public RectangleWall(String name, String color, int length, int height) {
        super(name, color);
        this.length = length;
        this.height = height;
    }

    // getters
    public int getLength(){
        return length;
    }

    public int getHeight(){
        return height;
    }

    // method to calculate area
    @Override
    public int getArea(){
        return length * height;
    }

    //to String Method
    @Override
    public String toString(){
        return String.format("%s (%dx%d) rectangle", getName(), length, height);
    }
}
/*
Step Two: Implement the `RectangleWall` class

`RectangleWall` extends `Wall` and adds two new instance variables, `length` and `height`, that are readonly.
Add a constructor that looks like this:

``` Java
public RectangleWall(String name, String color, int length, int height)
```

`getArea()` returns the `length` multiplied by the `height`.

Add a `toString()` method that returns a `String` in the following format:

```
name (lengthxheight) rectangle
```

To complete this step, you must:
- Verify that all tests in `/src/test/java/com/techelevator/RectangleWallTest` pass.
- Uncomment any code that's commented out following `// Step Two:`.
- Run the application and perform any steps available.
 */