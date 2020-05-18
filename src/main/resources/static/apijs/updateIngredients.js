const UPREQ = new XMLHttpRequest();

// POSTING INFORMATION TO THE SERVER
let data =
    '{"ingredientName":"Potatoes","ingredientType":"Veg"}';
function upIngredients() {
    UPREQ.open('PUT', 'http://localhost:8080/createIngredients');
    UPREQ.setRequestHeader('Content-Type', 'Application/json');
    UPREQ.setRequestHeader('Access-Control-Allow-Origin', '*');
    UPREQ.onload = () => {
        if (UPREQ.status === 201) {
            console.log(UPREQ.response);
        } else {
            console.log('handle error');
        }
    };
    UPREQ.send(data); // Waht we want to send across
}

let upingredients = document.querySelector("#upingredients");
upingredients.addEventListener("click", upIngredients);