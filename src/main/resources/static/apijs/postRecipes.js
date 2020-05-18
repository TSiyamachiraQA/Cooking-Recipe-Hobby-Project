
const POSTRREQ = new XMLHttpRequest();

function postRec() {
    let e = document.getElementById("recServ");
    let reci = e.options[e.selectedIndex].value;

    let paras = document.getElementById("recname").value;

    let descr = document.getElementById("description").value;

// POSTING INFORMATION TO THE SERVER
    let data =
      `{"recipeName":"${paras}","recipeServing":"${reci}","description":"${descr}"}`;

    console.log(data);

    POSTRREQ.open('POST', 'http://localhost:8080/createRecipes');
    POSTRREQ.setRequestHeader('Content-Type', 'Application/json');
    POSTRREQ.setRequestHeader('Access-Control-Allow-Origin', '*');
    POSTRREQ.onload = () => {
        if (POSTRREQ.status === 201) {
            console.log(POSTRREQ.response);
        } else {
            console.log('handle error');
        }
    };
    POSTRREQ.send(data); // Waht we want to send across
}

let postrecipes = document.querySelector("#postrecipe");
postrecipes.addEventListener("click", postRec);