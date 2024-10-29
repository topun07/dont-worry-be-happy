package com.techelevator;

import static org.junit.jupiter.api.Assertions.*;
import com.techelevator.AnimalGroupName;
import org.junit.jupiter.api.Test;

public class AnimalGroupNameTests {
    @Test
    public void testGetHerdWithKnownAnimal(){
        AnimalGroupName animalGroupName = new AnimalGroupName();
        assertEquals("Crash", animalGroupName.getHerd("rhino"));
        assertEquals("Tower", animalGroupName.getHerd("giraffe"));
        assertEquals("Herd", animalGroupName.getHerd("elephant"));
        assertEquals("Pride", animalGroupName.getHerd("lion"));
    }

    @Test
    public void testHerdWithCaseInsensitiveAnimal(){
        AnimalGroupName animalGroupName = new AnimalGroupName();
        assertEquals("Crash", animalGroupName.getHerd("Rhino"));
        assertEquals("Crash", animalGroupName.getHerd("RHINO"));
        assertEquals("Tower", animalGroupName.getHerd("GIRAFFE"));
        assertEquals("Herd", animalGroupName.getHerd("Elephant"));
    }

    @Test
    public void testHerdWithUnknownAnimal(){
        AnimalGroupName animalGroupName = new AnimalGroupName();
        assertEquals("unknown", animalGroupName.getHerd("walrus"));
        assertEquals("unknown", animalGroupName.getHerd("tiger"));
        assertEquals("unknown", animalGroupName.getHerd("elephants"));
        //assertEquals("unknown", animalGroupName.getHerd(" "));
    }

    @Test
    public void testGetHerdWithNull(){
        AnimalGroupName animalGroupName = new AnimalGroupName();
        assertEquals("unknown", animalGroupName.getHerd("null"));
    }

    @Test
    public void testHerdAnimalWithEmptyString(){
        AnimalGroupName animalGroupName = new AnimalGroupName();
        assertEquals("unknown", animalGroupName.getHerd(" "));
    }

    @Test
    public void testGetHerdWithAllAnimals(){
        AnimalGroupName animalGroupName = new AnimalGroupName();
        assertEquals("Crash", animalGroupName.getHerd("rhino"));
        assertEquals("Tower", animalGroupName.getHerd("giraffe"));
        assertEquals("Herd", animalGroupName.getHerd("elephant"));
        assertEquals("Pride", animalGroupName.getHerd("lion"));
        assertEquals("Murder", animalGroupName.getHerd("crow"));
        assertEquals("Kit", animalGroupName.getHerd("pigeon"));
        assertEquals("Pat", animalGroupName.getHerd("flamingo"));
        assertEquals("Herd", animalGroupName.getHerd("deer"));
        assertEquals("Pack", animalGroupName.getHerd("dog"));
        assertEquals("Float", animalGroupName.getHerd("crocodile"));
    }

}
