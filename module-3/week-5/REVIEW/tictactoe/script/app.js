// Add code here
//TODO 1: Assign the game a cool title; assign name and className properties for players 1 and 2 - Objects can be helpful  
const player1 = null;

const player2 = null;

const gameTitle = null; 

//TODO 2: assign values for remaining scoring sets  
//Scoring Sets  - Arrays are a handy tool in JavaScript
const row1 = null;  
const row2 = null;
const row3 = null;
const col1 = null;
const col2 = null;
const col3 = null;
const dia1 = null;
const dia2 = null;

//TODO 3.1: Capture all of the scoringSets 
const scoringSets = null; // An Array is a handy tool in JavaScript    

let currentPlayer = null;  // 3.2 pick a default player to start with.
let gameOver = null; // 3.3 update this value based on a new game starting

//'DOMContentCheck
document.addEventListener('DOMContentLoaded', intializeGame);  //calling a named function instead of using anonymous function.

function intializeGame(){
    setGameHeader();    
    setPlayerNames();
    attachListeners();
}

//TODO 4.1: Create setGameHeader() function - gameTitle could be useful here


//TODO 4.2: Create setPlayerNames() function to Display player names - Object properties can be useful


//TODO 4.3: Create attachListeners() function 
    //1. add event listener to game-board  ; click ; event.target -- pass to circleClick function.
    //2. add event listener to btnClearBoard; click.




//TODO 5: Create circleClick(clickedCircle) function 
    //an option to consider is using classList in your function per the following

    //check if circle is "available"

        //"add" player to circle

        //record score 
    
    //let user know selected circle is not valid selection
    



 //TODO 6: Create scoreGameBoard(player) function 
      //check each scoring sets

        //check each id 

            // when player has three in gameOver = true...... display an alert with winner. "player x Wins!"

    
   

//TODO 7: Create clearBoard() function

