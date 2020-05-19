const GETREQ = new XMLHttpRequest();

function getIngredients() {
    GETREQ.onload = () => {
        if (GETREQ.status === 200) {
            // console.log(REQ);
            let obj = GETREQ.response
            console.log(obj);
        } else {
            console.log(`Handle Error!`);
        }
    }
    GETREQ.open('GET', 'http://localhost:8080/getAllIngredients');
    GETREQ.setRequestHeader('Content-Type', 'Application/json');
    // REQ.setRequestHeader('Access-Control-Allow-Origin', '*');
    GETREQ.responseType = 'json';
    GETREQ.send();
}

let getingredients = document.querySelector('#getingredients');
getingredients.addEventListener('click', getIngredients);