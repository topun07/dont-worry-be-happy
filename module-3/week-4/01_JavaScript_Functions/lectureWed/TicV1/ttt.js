const boardElement = document.getElementById('board');
const statusElement = document.getElementById('status');

let board = Array(9).fill(null);
let currentPlayer = 'X';
let gameActive = true;

function makeMove(index) {
    if (board[index] || !gameActive)
        return;

    board[index] = currentPlayer;

    updateBoard();

    if (checkWinner()) {
        statusElement.textContent = `Player ${currentPlayer} wins!`;
        gameActive = false;
    } else if (board.every(cell => cell)) {
        statusElement.textContent = "It's a tie!";
        gameActive = false;
    } else {
        currentPlayer = currentPlayer === 'X' ? 'O' : 'X';
        statusElement.textContent = `Current Player: ${currentPlayer}`;
    }
}

function updateBoard() {
    board.forEach((value, index) => {
        boardElement.children[index].textContent = value;
    });
}

function checkWinner() {
    const winPatterns = [
        [0, 1, 2], [3, 4, 5], [6, 7, 8], // rows
        [0, 3, 6], [1, 4, 7], [2, 5, 8], // columns
        [0, 4, 8], [2, 4, 6]             // diagonals
    ];
    return winPatterns.some(pattern =>
        pattern.every(index => board[index] === currentPlayer)
    );
}
