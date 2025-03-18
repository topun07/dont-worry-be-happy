/**
 * ACME Academy has received a large number of student applications. 
 * Write a function called isAdmitted to determine if a student meets the requirements to be admitted.
 * This function takes 3 parameters:
 *   gpa
 *   satScore
 *   recommendation
 * A student is admitted only if one of the following is true:
 * Their gpa is 4.0 or higher.
 * They score 1300 or more on the SAT.
 * Their gpa is 3.0 or higher and have a recommendation.
 * Their SAT score is 1200 or higher and they have a recommendation.
 *
 * @param {number} gpa the GPA of the student
 * @param {number} satScore the student's SAT score
 * @param {boolean} recommendation does the student have a recommendation
 * @returns {boolean} true if they are admitted
 */
function isAdmitted(gpa, satScore, recommendation) {

    if (gpa >= 4.0 || satScore >= 1300)
        return true;
    else if (recommendation == true && (gpa >= 3.0 || satScore >= 1200)) {
        return true;
    }
    else
        return false;
}


/**
 * Write a function called isPhysicallyFit
 * It determines whether or not someone passes gitFit's physical fitness test.
 
 * The function takes three parameters: situps, pushups, and mileInMinutes
 
 * They pass the test if one of the following:
 * They can run a mile in 10 minutes or less.
 * They can perform at least 50 situps and 50 pushups.
 * They can perform 60 situps and run a mile in 12 minutes or less.
 * They can perform 60 pushups and run a mile in 14 minutes or less.
 * 
 * @param {number} situps 
 * @param {number} pushups
 * @param {number} mileInMinutes
 * @returns {boolean} true if they pass
 */
function isPhysicallyFit(situps, pushups, mileInMinutes) {

    if (mileInMinutes <= 10)
        return true;

    if (situps >= 50 && pushups >= 50)
        return true;

    if (situps >= 60 && mileInMinutes <= 12)
        return true;

    if (pushups >= 60 && mileInMinutes <= 14)
        return true;

    return false;

}

/**
 * You are developing a game and need to write a function to determine whether a character makes it through a round of combat or gets knocked out. 
 * 
 * Write a function called isKnockedOut
 * It takes an object with the following properties: 
 *   currentHealth
 *   damage
 *   luck
 * 
 * A character is knocked out if:
 * They receive more than 20 damage and luck is 0.5 or less.
 * They receive damage equal to or greater than their current health.
 *
 * 
 * @param {object} combatRoll
 * @returns {boolean} true if they're knocked out
 */
function isKnockedOut(combatRoll) {

    if (combatRoll.damage > 20 && combatRoll.luck <= 0.5) {
        return true;
    }
    if (combatRoll.damage >= combatRoll.currentHealth) {
        return true;
    }
    return false;
}
