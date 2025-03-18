const player1 = {
    id: 1,
    char: 'x',
    iconClass: 'fa-times',
    scoreClass: '#score-player-1 .score-text'
};

const player2 = {
    id: 2,
    char: 'o',
    iconClass: 'fa-circle',
    scoreClass: '#score-player-2 .score-text'
};

/* Global variable that keeps whose turn is to play */
let currentPlayer = player1;

/**
 * Place the current player's icon within the tile.
 */
function selectTile(tile, player) {
    // TODO: Step 1

    // 1. Find the icon inside of the tile (i element)
    const iconToUpdate = tile.querySelector('i');

    // 2. Update the class of the icon to be the player's icon class
    iconToUpdate.classList.add(player.iconClass);

    tile.removeEventListener('click', onTileClicked);
}

/**
 * Returns true if there is a tie. A tie occurs when the entire
 * board is full.
 * 
 * @returns {boolean} true if there is a tie, false otherwise
 */
function isATie() {
    // TODO: Step 2

    const tiles = Array.from(document.querySelectorAll('.tile'));
    return tiles.every(t => t.querySelector("i").classList.contains(player1.iconClass) ||
        t.querySelector("i").classList.contains(player2.iconClass));

    return false;
}

/**
 * Record a win by increasing the number of ties on the UI.
 */
function recordTie() {
    // TODO: Step 3
    // 1. find the p element that has the ties count
    const scoreTiesElement = document.querySelector('#score-ties .score-text');

    // 2. increase the count by 1
    // get the current amount of ties
    const currentScore = Number.parseInt(scoreTiesElement.innerText);

    // update the ties by increasing
    scoreTiesElement.innerText = currentScore + 1;
}

/**
 * Returns true if the current player has won. A win can
 * be three in a row horizontally, vertically, or diagonally.
 */
function isAWin() {
    // TODO: Step 4

    //Check rows
    for (let i = 1; i < 4; i++) {
        if (isRowWinner(i))
            return true;
    }

    for (let i = 1; i < 4; i++) {
        if (isColWinner(i))
            return true;
    }

    if (isDiagonal1Winner())
        return true;


    if (isDiagonal2Winner())
        return true;


    return false;
}

function isRowWinner(rowNo) {

    let row = getRow(rowNo);

    const tiles = Array.from(row);

    if(tiles.every(t => t.querySelector("i").classList.contains(player1.iconClass)) || 
        tiles.every(t => t.querySelector("i").classList.contains(player2.iconClass))) {
        
            colorWinner(tiles);
            return true;

        }

    return false;

}

function isColWinner(row) {

    return false;
}

function isDiagonal1Winner() {
 
    return false;
}

function isDiagonal2Winner() {
 
    return false;
}


function getRow(rowNo) {

    let rowClass = ".top-row";

    if(rowNo === 2)
        rowClass = ".center-row";
    
    if(rowNo === 3)
        rowClass = ".bottom-row";

    return document.querySelectorAll(rowClass);
}

function colorWinner(tiles) {

    tiles.forEach(t => {
        t.querySelector("i").classList.add("won");
    })
}

/**
 * Record a win by increasing the current player's score on the UI.
 */
function recordWin() {
    // TODO: Step 5

    // 1. find the p element that has the current player's win count
    const scoreElement = document.querySelector(currentPlayer.scoreClass);

    // 2. increase the count by 1

    // get the current amount of ties
    const currentScore = Number.parseInt(scoreElement.innerText);

    // update the wins to increase by 1
    scoreElement.innerText = currentScore + 1;
}

function executeGameLogic(clickedTile) {

    selectTile(clickedTile, currentPlayer);

    if (isAWin()) {
        recordWin();
        return;
    }

    if (isATie()) {
        recordTie();
        return;
    }

    switchPlayer();
}

function switchPlayer() {
    currentPlayer = currentPlayer.id === 1 ? player2 : player1;

    const currentPlayerElement = document.getElementById('current-player');
    currentPlayerElement.innerText = currentPlayer.char.toUpperCase();
}

/* Initialize the game when the game loads */
document.addEventListener('DOMContentLoaded', () => {
    onGameLoaded();
});

function onGameLoaded() {

    /* Hook-up event listeners for all tiles */
    const tiles = document.querySelectorAll('.tile');

    tiles.forEach(t => {
        t.addEventListener('click', onTileClicked);
    });

    const btn = document.getElementById('btn-play-again');
    btn.addEventListener('click', onPlayAgainClicked);
}

function onTileClicked(event) {
    let clickedTile = event.currentTarget;
    executeGameLogic(clickedTile);
}

function onPlayAgainClicked() {
    removeAllIcons();
    switchPlayer();
    onGameLoaded();
}

/**
 * Remove all player icons from the board.
 */
function removeAllIcons() {
    // TODO: Step 7

    // 1. find all icons
    const icons = document.querySelectorAll('i');

    // 2. remove fa-times and fa-circle from each icon
    icons.forEach(icon => {
        icon.classList.remove(player1.iconClass);
        icon.classList.remove(player2.iconClass);
        icon.classList.remove("won");
    });
}
