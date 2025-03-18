
/**
 * Did you know the average english word length is 4.7 characters?
 * To help visualize which words are "long", reverse all words that are five characters or longer in a given string.
 * 
 * Write a function called wordFlipper
 * It takes a string of one or more words, and returns the string, but with all words that are five letters or more reversed.
 * Treat special characters or punctuation as if they were just another letter.
 * 
 * Given the following string:
 * "I bless the rains down in Africa."
 * Your function should return:
 * "I sselb the sniar down in .acirfA"
 * 
 * @param {string} input
 * @returns {string}
 */

/**
 * Write a function called calculateTotal.
 * Given an array of numbers the function calculates a total from the array given some...peculiar rules.
 * 
 * An amount is either added to or subtracted from this total given the following conditions:
 * If the length of the array is a multiple of a number, subtract the number from the total instead.
 * If a number is a multiple of 2, add it to the total twice. 
 * If a number is a multiple of 2 AND of the length of the array, subtract it from the total twice.
 * 
 * @param {number[]} numbers
 * @returns {number} total
 */

/**
 * Caesar ciphers, or shift ciphers, are one of the most basic forms of encryption. 
 * Each letter in the message is replaced by a letter some fixed number of positions down the alphabet, determined by the key.
 * For example, with a key of 3, D would become G, E would become H, etc.
 * 
 * Write a function called caesarCipher to encrypt a given string with a given key.
 * Be sure that a letter that is uppercase remains uppercase and vice versa.
 * Make sure to only shift letters - all punctuation, numbers, and spaces also remain the same.
 * Also be aware of keys greater than 26 and less than -26. There are only 26 letters in the alphabet.
 * If a key falls outside of this range loop back to the start of the alphabet, so a key of 27 yields the same result as a key of 1, and 28, 2, etc.
 * 
 * @param {number} key
 * @param {string} message
 * @returns {string}
 */

/**
 * Write a function called orderArrivals
 * It takes an array of objects with the following properties:
 *   name
 *   estimatedTripTime (minutes)
 *   avgSpeed (miles per hour)
 *   routeDistance (miles)
 *   distanceRemaining (miles)
 * 
 * This function calculates if a train is on schedule, when it will arrive in minutes, and sorts the array in order of arrival.
 * It then returns an array of objects with the following properties, sorted from least timeRemaining to most:
 *   name
 *   isOnSchedule
 *   timeRemaining
 * 
 * @param {object[]} trains
 * @returns {object}
 */

/**
 * Being a wrangler for Monsters"R"Us is dangerous work. 
 * Write a function called captureMonsters to calculate whether you are able to safely capture a group of monsters before taking to the field.
 * This function should also return counts for any remaining traps, monsters, and distance for record keeping purposes.
 * 
 * Write a function called captureMonsters
 * The function takes an object with the following properties:
 *   numberOfMonsters
 *   numberOfTraps
 *   distance
 * 
 * Then returns an object with the following properties:
 *   isSafe
 *   monstersRemaining
 *   trapsRemaining
 *   distanceRemaining 
 * 
 * Distance is measured in feet.
 * Trap a monster every turn, removing one trap, and one monster.
 * If there are no monsters remaining before the distance reaches 0, the capture isSuccessful, otherwise the capture has failed.
 * 
 * The order of each turn should be:
 * Remove monster/trap if enough remain
 * Check if monsters have reached you or have all been trapped
 * Monsters move 1.5ft closer
 * Check if monsters have reached you or have all been trapped
 * 
 * @param {object} properties
 * @param {number} properties.numberOfMonsters
 * @param {number} properties.numberOfTraps
 * @param {number} properties.distance
 * @returns {object}
 */

/**
 * ***CHALLENGE***
 * Write a function called characterCount
 * It takes a string and returns an object that shows how many times each character occurs in the string.
 * The object should have a key for each character in the string, and the value should be the number of times it occurs.
 * 
 * Don't make the count case-sensitive, and return all keys in lowercase.
 * Do not count any spaces.
 * 
 * Given the following string:
 * "Screensaver"
 * Your function should return:
 * {
 *   "s": 2,
 *   "c": 1,
 *   "r": 2,
 *   "e": 3,
 *   "n": 1,
 *   "a": 1,
 *   "v": 1
 * }
 * 
 * @param {string} input
 * @returns {object}
 */
