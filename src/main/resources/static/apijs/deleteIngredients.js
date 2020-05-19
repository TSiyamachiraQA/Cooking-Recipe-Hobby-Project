const DELREQ = new XMLHttpRequest();

function deleteIngredients() {
    let id = 2;
    let URL = "http://localhost:8080/deleteIngredients";

    DELREQ.open('DELETE', URL + `/${id}`);
    DELREQ.setRequestHeader('Content-Type', 'Application/JSON');
    DELREQ.setRequestHeader('Access-Control-Allow-Origin', '*');
    DELREQ.onload = () => {
        if (DELREQ.status === 204) {
            console.log(DELREQ.response);

            console.log("DELETED")
        } else {
            console.log('handle error');
        }
    }
    DELREQ.send();

}
let deleteButton = document.querySelector('#DeleteIngredient');
deleteButton.addEventListener('click', deleteIngredients);