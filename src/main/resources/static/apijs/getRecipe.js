const GETRREQ = new XMLHttpRequest();


function getRec() {

// console.log(REQ);

    GETRREQ.onload = () => {
        if (GETRREQ.status === 200) {
        let obj =  GETRREQ.response;
            buildTable(obj)


            // console.log(obj);

        } else {
            console.log(`Handle Error!`);
        }
    }
    GETRREQ.open('GET', 'http://localhost:8080/getAllRecipes');
    GETRREQ.setRequestHeader('Content-Type', 'Application/json');
    // REQ.setRequestHeader('Access-Control-Allow-Origin', '*');
    GETRREQ.responseType = 'json';
    GETRREQ.send();

}

let getrecipes = document.querySelector('#getrecipes');
getrecipes.addEventListener('click', getRec);



function buildTable(data){
    var table = document.getElementById('myTable')

    for (var i = 0; i < data.length; i++){
        var row = `<tr>
							<td>${data[i].recipeName}</td>
							<td>${data[i].recipeServing}</td>
							<td>${data[i].description}</td>
					  </tr>`
        table.innerHTML += row


    }
}
