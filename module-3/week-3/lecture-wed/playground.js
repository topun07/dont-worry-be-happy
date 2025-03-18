
function numberEntered(num) {
    let i = document.getElementById("display");
    i.value += num;
}

function onClear() {

    let i = document.getElementById("display");
    i.value = "";
}

function onEqual() {

    let i = document.getElementById("display");

    try {
        let result = eval(i.value);
        i.value = result;
    }
    catch (error) {
        i.value = "n/a";
        console.error("Unable to evaluate: " + error);
    }

}


function onDel() {
    let i = document.getElementById("display");
    let val = i.value;
    i.value = val.slice(0, -1);
}