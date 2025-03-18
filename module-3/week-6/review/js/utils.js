
/* HELPER METHODS */

// this function will remove the red class from the specified
// element and the add the black class
function black(item) {
    item.classList.remove('red');
    item.classList.add('black');

}

// this function will remove the blacj class from the specified
// element and the add the red class
function red(item) {
    item.classList.remove('black')
    item.classList.add('red');
}

// this function will changge the specified element
// to red if it is currently black or black if it
// is currently red
function toggleColor(item) {
    // let item = document.querySelector(id);
    if (item.classList.contains('red')) {
        black(item);
    } else {
        red(item);
    }
}

// this function updates the screen text with x and y values
// function updateXYInfo(x, y) {

//     let xSpan = document.getElementById('x-pos');
//     let ySpan = document.getElementById('y-pos');

//     xSpan.innerText = x;
//     ySpan.innerText = y;

// }

function createXYPosDiv(parent) {
    const coordsDiv = document.createElement('div');
    coordsDiv.classList.add('mouse-coords');

    const xDiv = document.createElement('div');
    xDiv.setAttribute('id', 'x-container');

    const xLabelSpan = document.createElement('span');
    xLabelSpan.setAttribute('id', 'x-label');
    xLabelSpan.innerText = 'X:';
    xDiv.appendChild(xLabelSpan);

    const xPosSpan = document.createElement('span');
    xPosSpan.setAttribute('id', 'x-pos');
    xDiv.appendChild(xPosSpan);
    
    
    const yDiv = document.createElement('div');
    yDiv.setAttribute('id', 'y-container');

    const yLabelSpan = document.createElement('span');
    yLabelSpan.setAttribute('id', 'y-label');
    yLabelSpan.innerText = 'Y:';
    yDiv.appendChild(yLabelSpan);

    const yPosSpan = document.createElement('span');
    yPosSpan.setAttribute('id', 'y-pos');

    yDiv.appendChild(yPosSpan);

    coordsDiv.appendChild(xDiv);
    coordsDiv.appendChild(yDiv);

    parent.appendChild(coordsDiv);
}

function addListenersToOtherWordsAndImages() {
    const loveWord = document.querySelector('#love-word');
    loveWord.addEventListener('mouseover', () => {
        toggleColor(loveWord);
    });
    loveWord.addEventListener('mouseleave', () => {
        toggleColor(loveWord);
    });

    const musicWord = document.querySelector('#music-word');
    musicWord.addEventListener('mouseover', () => {
        toggleColor(musicWord);
    });
    musicWord.addEventListener('mouseleave', () => {
        toggleColor(musicWord);
    });

    const loveImage = document.querySelector('#love-image');
    loveImage.addEventListener('click', () => {
        toggleColor(loveImage);
    });

    const musicImage = document.querySelector('#music-image');
    musicImage.addEventListener('click', () => {
        toggleColor(musicImage);
    });
}