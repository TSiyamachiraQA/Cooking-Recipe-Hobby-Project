//
//     Ingredients.setRequestHeader('Content-Type', 'Application/json');
//     Ingredients.setRequestHeader('Access-Control-Allow-Origin', '*');
//
// public Ingredients(){
// // Get all ingredieints
//     function getAllIngredients() {
//         var url = "http://localhost:8080/getAllIngredients";
//         var xhr = new XMLHttpRequest()
//         xhr.open('GET', url, true)
//         xhr.onload = function () {
//             var ingr = JSON.parse(xhr.responseText);
//             if (xhr.readyState == 4 && xhr.status == "200") {
//                 console.table(ingr);
//             } else {
//                 console.error(ingr);
//             }
//         }
//         xhr.send(null);
//     }
//
// // Get a ingredient
//     function getIngredient() {
//         var url = "http://localhost:8080/getIngredientsById";
//         var xhr = new XMLHttpRequest()
//         xhr.open('GET', url + '/1', true)
//         xhr.onload = function () {
//             var ingr = JSON.parse(xhr.responseText);
//             if (xhr.readyState == 4 && xhr.status == "200") {
//                 console.table(ingr);
//             } else {
//                 console.error(ingr);
//             }
//         }
//         xhr.send(null);
//     }
//
// // Post a ingr
//     function postIngredient() {
//         var url = "http://localhost:8080/createIngredients";
//
//         var data = {};
//         data.ingredientName = "Potatoes";
//         data.ingredientType = "Veg";
//         var json = JSON.stringify(data);
//
//         var xhr = new XMLHttpRequest();
//         xhr.open("POST", url, true);
//         xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
//         xhr.onload = function () {
//             var ingr = JSON.parse(xhr.responseText);
//             if (xhr.readyState == 4 && xhr.status == "201") {
//                 console.table(ingr);
//             } else {
//                 console.error(ingr);
//             }
//         }
//         xhr.send(json);
//     }
//
// // Update a ingr
//     function updateIngredient() {
//         var url = "http://localhost:8080/updateIngredients";
//
//         var data = {};
//         data.ingredientName = "Potatoes";
//         data.ingredientType = "Veg";
//         var json = JSON.stringify(data);
//
//         var xhr = new XMLHttpRequest();
//         xhr.open("PUT", url + '/2', true);
//         xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
//         xhr.onload = function () {
//             var ingr = JSON.parse(xhr.responseText);
//             if (xhr.readyState == 4 && xhr.status == "200") {
//                 console.table(ingr);
//             } else {
//                 console.error(ingr);
//             }
//         }
//         xhr.send(json);
//     }
//
// // Delete a ingr
//     function deleteIngredient() {
//         var url = "http://localhost:8080/deleteIngredients";
//         var xhr = new XMLHttpRequest();
//         xhr.open("DELETE", url + '/2', true);
//         xhr.onload = function () {
//             var ingr = JSON.parse(xhr.responseText);
//             if (xhr.readyState == 4 && xhr.status == "200") {
//                 console.table(ingr);
//             } else {
//                 console.error(ingr);
//             }
//         }
//         xhr.send(null);
//     }
//
// }
//
// let getAllOfIngredients = document.querySelector("#getAllIngredients");
// getAllIngredients.addEventListener("click", getAllIngredients);
//
// let getAnIngredient = document.querySelector("#getIngredient");
// getIngredient.addEventListener("click", getIngredient);
//
// let postAnIngredient = document.querySelector("#postIngredient");
// postIngredient.addEventListener("click", postIngredient);
//
// let updateAIngredients = document.querySelector("#updateIngredients");
// updateIngredient.addEventListener("click", updateIngredient);
//
// let deleteAnIngredient = document.querySelector("#deleteIngredient");
// deleteIngredient.addEventListener("click", deleteIngredient);
