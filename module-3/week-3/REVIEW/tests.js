let should = chai.should();

describe('Exercises', () => {

  describe('isAdmitted', () => {
    it('should accept anyone with at least a 4.0 gpa', () => {
      isAdmitted(4.0, 0, false).should.be.true;
    });
    it('should accept anyone with at least 1300 SAT score', () => {
      isAdmitted(1, 1300, false).should.be.true;
    });
    it('should accept anyone with at least a 3.0 gpa and recommendation', () => {
      isAdmitted(3.0, 0, true).should.be.true;
    });
    it('should accept anyone with at least 1200 SAT score and recommendation', () => {
      isAdmitted(1, 1200, true).should.be.true;
    });
    it('should reject gpa below 3.0 with recommendation', () => {
      isAdmitted(2.9, 100, true).should.be.false;
    });
    it('should reject SAT below 1200 even with recommendation', () => {
      isAdmitted(1, 1199, true).should.be.false;
    });
  });

  describe('isPhysicallyFit', () => {
    it('should pass if mileInMinutes is 10 or less', () => {
      isPhysicallyFit(0, 0, 10).should.be.true;
      isPhysicallyFit(0, 0, 9).should.be.true;
    });
    it('should pass with 50 or more pushups and 50 or more situps regardless of mileInMinutes', () => {
      isPhysicallyFit(50, 50, 300).should.be.true;
      isPhysicallyFit(60, 60, 300).should.be.true;
    });
    it('should pass with 60 or more situps and mileInMinutes is 12 or less regardless of pushups', () => {
      isPhysicallyFit(60, 0, 12).should.be.true;
      isPhysicallyFit(61, 0, 11).should.be.true;
    });
    it('should pass with 60 or more pushups and mileInMinutes is 14 or less regardless of situps', () => {
      isPhysicallyFit(0, 60, 14).should.be.true;
      isPhysicallyFit(0, 61, 13).should.be.true;
    });
    it('should fail if 11 minute mile, situps 59, pushups 49', () => {
      isPhysicallyFit(59, 49, 11).should.be.false;
    });
    it('should fail if 11 minute mile, situps 49, pushups 59', () => {
      isPhysicallyFit(49, 59, 11).should.be.false;
    });
  });

  describe('isKnockedOut', () => {
    it('should be true with more than 20 damage and luck of 0.5 or less', () => {
      isKnockedOut({ "damage": 20, "currentHealth": 40, "luck": 0.49 }).should.be.false;
      isKnockedOut({ "damage": 20, "currentHealth": 40, "luck": 0.5 }).should.be.false;
      isKnockedOut({ "damage": 21, "currentHealth": 40, "luck": 0.49 }).should.be.true;
      isKnockedOut({ "damage": 21, "currentHealth": 40, "luck": 0.5 }).should.be.true;
      isKnockedOut({ "damage": 21, "currentHealth": 40, "luck": 0.51 }).should.be.false;
    });
    it('should be true with at least as much damage as health, regardless of luck', () => {
      isKnockedOut({ "damage": 1, "currentHealth": 1, "luck": 0 }).should.be.true;
      isKnockedOut({ "damage": 1, "currentHealth": 1, "luck": 0.51 }).should.be.true;
      isKnockedOut({ "damage": 21, "currentHealth": 20, "luck": 0.51 }).should.be.true;
      isKnockedOut({ "damage": 19, "currentHealth": 19, "luck": 0 }).should.be.true;
      isKnockedOut({ "damage": 1, "currentHealth": 2, "luck": 0 }).should.be.false;

    });
  });

});