package com.techelevator;

import static org.junit.jupiter.api.Assertions.*;
import com.techelevator.AnimalGroupName;
import com.techelevator.CigarParty;
import org.junit.jupiter.api.Test;

public class CigarPartyTests {
    @Test
    public void testHavePartyOnWeekdayWithTooFewCigars(){
        CigarParty cigarParty = new CigarParty();
        assertFalse(cigarParty.haveParty(30, false));
    }

    @Test
    public void testHavePartyOnWeekdayWithEnoughCigars(){
        CigarParty cigarParty = new CigarParty();
        assertTrue(cigarParty.haveParty(50, false));
    }

    @Test
    public void testHavePartyOnWeekdayWithTooManyCigars(){
        CigarParty cigarParty = new CigarParty();
        assertFalse(cigarParty.haveParty(70, false));
    }

    @Test
    public void testHavePartyOnWeekendWithTooFewCigars(){
        CigarParty cigarParty = new CigarParty();
        assertFalse(cigarParty.haveParty(30, true));
    }

    @Test
    public void testHavePartyOnWeekendWithEnoughCigars(){
        CigarParty cigarParty = new CigarParty();
        assertTrue(cigarParty.haveParty(50, true));
    }

    @Test
    public void testHavePartyOnWeekendWithManyCigars(){
        CigarParty cigarParty = new CigarParty();
        assertTrue(cigarParty.haveParty(70, true));
    }

    @Test
    public void testHavePartyOnWeekdayWithMinimumBoundryCigars(){
        CigarParty cigarParty = new CigarParty();
        assertTrue(cigarParty.haveParty(40, false));
    }

    @Test
    public void testHavePartyOnWeekdayWithMaximumBoundaryCigars(){
        CigarParty cigarParty = new CigarParty();
        assertTrue(cigarParty.haveParty(60, false));
    }

    @Test
    public void testHavePartyOnWeekendWithMinimumBoundaryCigars(){
        CigarParty cigarParty = new CigarParty();
        assertTrue(cigarParty.haveParty(40, true));
    }

    @Test
    public void testHavePartyWithExactMaximumBoundaryOnWeekday(){
        CigarParty cigarParty = new CigarParty();
        assertTrue(cigarParty.haveParty(60, false));
    }

    @Test
    public void testHavePartyWithExactMinimumBoundaryOnWeekend(){
        CigarParty cigarParty = new CigarParty();
        assertTrue(cigarParty.haveParty(40, true));
    }
}
