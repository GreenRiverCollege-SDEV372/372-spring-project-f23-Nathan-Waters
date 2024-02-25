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

    document.addEventListener('click', function(event) {
        if (event.target.classList.contains('deleteBtn')) {
            const btn = event.target;
            const recipeId = btn.dataset.id;
            deleteRecipe(recipeId);
            // Remove the corresponding row from the table
            btn.closest('tr').remove();
        }
    });
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
    //creates ingredient lis
    let ingredientsListHTML = '<ul>';
    for (let i = 0; i < recipeData.ingredients.length; i++) {
        ingredientsListHTML += `<li>${recipeData.ingredients[i]}</li>`;
    }
    ingredientsListHTML += '</ul>';

    //creates method lis
    let methodListHTML = '<ol>';
    for (let i = 0; i < recipeData.method.length; i++) {
        methodListHTML += `<li>${recipeData.method[i]}</li>`;
    }
    methodListHTML += '</ol>';

    row.innerHTML += `
            <td>${recipeData.name}</td>
            <td>${ingredientsListHTML}</td>
            <td>${methodListHTML}</td>
            <td>edit</td>
            <td><button class="deleteBtn" data-id="${recipeData.id}">Delete</button></td>
        `;
    tBody.appendChild(row);
}

async function deleteRecipe(recipeId){
    const uri = `http://localhost:8080/recipes/${recipeId}`;
    const config = {
        method: "delete"
    }
    await fetch(uri, config);
}

function addIngredient() {
    const ingredientsInputs = document.getElementById('ingredientsInputs');

    const newInput = document.createElement('input');
    newInput.type = 'text';
    newInput.name = 'ingredients[]';
    newInput.className = 'ingredient-input';
    newInput.placeholder = 'next ingredient...'
    newInput.required = true;

    ingredientsInputs.appendChild(newInput);
}

function addMethod() {
    const methodInputs = document.getElementById('methodInputs');

    const newInput = document.createElement('input');
    newInput.type = 'text';
    newInput.name = 'method[]';
    newInput.className = 'method-input';
    newInput.placeholder = 'next step...'
    newInput.required = true;

    methodInputs.appendChild(newInput);
}
