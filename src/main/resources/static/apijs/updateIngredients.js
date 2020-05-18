const UPREQ = new XMLHttpRequest();

function upIngredients() {
// POSTING INFORMATION TO THE SERVER
    let data =
        '{"ingredientName":"Gerkin","ingredientType":"Veg"}';

    let id = 3;
    let URL = "http://localhost:8080/updateIngredients";
    UPREQ.open('PUT', URL + `/${id}`);
    UPREQ.setRequestHeader('Content-Type', 'Application/json');
    UPREQ.setRequestHeader('Access-Control-Allow-Origin', '*');
    UPREQ.onload = () => {
        if (UPREQ.status === 200) {
            console.log(UPREQ.response);
            console.log("UPDATED");

        } else {
            console.log('handle error');
        }
    };
    UPREQ.send(data); // Waht we want to send across
}

let updateIngredients = document.querySelector("#updateAnIngredient");
updateIngredients.addEventListener("click", upIngredients);