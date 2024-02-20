window.onload = async function() {
    const uri = "http://localhost:8080/recipes/all";
    const config = {
        method: 'get'
    }

    const response = await fetch(uri, config);
    const data = await response.json();
    makeTable(data);

    const addButton = document.querySelector("#submit");
    addButton.onclick = addRecipe;

    const addMethodButton = document.querySelector("#addMethod");
    addMethodButton.onclick = addMethod;

    const addIngButton = document.querySelector("#addIngredient");
    addIngButton.onclick = addIngredient;

}

function makeTable(recipeData){
    const tBody = document.querySelector("#tbody");
    // console.log(recipeData[0])

    for(let i = 0; i < recipeData.length; i++){
        const row = document.createElement('tr');
        addRecipeToTable(row, recipeData[i], tBody);
    }
}

async function addRecipe(e){
    e.preventDefault();

    const newRecipe = {
        name: document.querySelector("#name").value,
        url: document.querySelector("#url").value,
        author: document.querySelector("#author").value,
        ingredients: Array.from(document.querySelectorAll(".ingredient-input")).map(input => input.value),
        method: Array.from(document.querySelectorAll(".method-input")).map(input => input.value)
    }

    console.log(newRecipe);

    const uri = "http://localhost:8080/recipes";
    const config = {
        method: "post",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(newRecipe)
    }

    const response = await fetch(uri, config);
    const recipe = await response.json();

    const row = document.createElement('tr');
    const tBody = document.querySelector("#tbody");
    addRecipeToTable(row, recipe, tBody);
}

function addRecipeToTable(row, recipeData, tBody){
    // let ingredientsListHTML = '<ul>';
    // for (let i = 0; i < recipeData.ingredients.length; i++) {
    //     ingredientsListHTML += `<li>${recipeData.ingredients[i]}</li>`;
    // }
    // ingredientsListHTML += '</ul>';

    row.innerHTML += `
            <td>${recipeData.name}</td>
            <td>${recipeData.ingredients}</td>
            <td>${recipeData.method}</td>
            <td>edit</td>
            <td>delete</td>
        `;
    tBody.appendChild(row);
}

function addIngredient() {
    const ingredientsInputs = document.getElementById('ingredientsInputs');

    const newInput = document.createElement('input');
    newInput.type = 'text';
    newInput.name = 'ingredients[]';
    newInput.className = 'ingredient-input';

    ingredientsInputs.appendChild(newInput);
}

function addMethod() {
    const methodInputs = document.getElementById('methodInputs');

    const newInput = document.createElement('input');
    newInput.type = 'text';
    newInput.name = 'method[]';
    newInput.className = 'method-input';

    methodInputs.appendChild(newInput);
}
