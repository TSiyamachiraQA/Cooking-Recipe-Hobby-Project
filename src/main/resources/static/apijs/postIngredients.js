
const POSTREQ = new XMLHttpRequest();

function postIngredients() {
    let e = document.getElementById("ingrType");
    let ingr = e.options[e.selectedIndex].value;

    let params = document.getElementById("ingrName").value;

// POSTING INFORMATION TO THE SERVER
    let data =
        `{"ingredientName":"${params}","ingredientType":"${ingr}"}`;
    console.log(data);

    POSTREQ.open('POST', 'http://localhost:8080/createIngredients');
    POSTREQ.setRequestHeader('Content-Type', 'Application/json');
    POSTREQ.setRequestHeader('Access-Control-Allow-Origin', '*');
    POSTREQ.onload = () => {
        if (POSTREQ.status === 201) {
            console.log(POSTREQ.response);
        } else {
            console.log('handle error');
        }
    };
    POSTREQ.send(data); // Waht we want to send across
}

let postingredients = document.querySelector("#postingredients");
postingredients.addEventListener("click", postIngredients);