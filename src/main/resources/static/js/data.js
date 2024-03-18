window.onload = async function() {
    const uri = `${window.location.origin}/recipes/all`;
    const config = {
        method: 'get'
    }
        console.log(window.location.origin);

    const response = await fetch(uri, config);
    const data = await response.json();
    makeTable(data);

    const addButton = document.querySelector("#submit");
    addButton.onclick = addRecipe;

    const addMethodButton = document.querySelector("#addMethod");
    addMethodButton.onclick = addMethod;

    const addIngButton = document.querySelector("#addIngredient");
    addIngButton.onclick = addIngredient;

    const editLinks = document.querySelectorAll('.edit');
    for (const link of editLinks) {
        link.onclick = editRecord;
    }

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

async function editRecord(e) {
    e.preventDefault();
    const editLink = e.target;
    const row = editLink.parentElement.parentElement;
    const recipeId = row.firstElementChild.attributes[0].value;

    console.log(row.children[1].innerHTML)
    console.log(row.children[2].innerHTML)

    const name = row.querySelector('td:nth-child(1)').textContent.trim();
    const ingredients = Array.from(row.querySelector('td:nth-child(2) ul').children).map(li => li.textContent);
    const method = Array.from(row.querySelector('td:nth-child(3) ol').children).map(li => li.textContent);

    console.log(ingredients);

    row.querySelector('td:nth-child(1)').innerHTML = `<input type="text" id="name" value="${name}">`;
    row.querySelector('td:nth-child(2)').innerHTML = ingredients.map(ingredient => `<input type="text" class="ingredient-input" value="${ingredient}">`).join('<br>');
    row.querySelector('td:nth-child(3)').innerHTML = method.map(step => `<input type="text" class="method-input" value="${step}">`).join('<br>');

    const updateButton = row.querySelector('td:nth-child(4) button');
    updateButton.textContent = 'Save';
    updateButton.onclick = () => saveEdit(row, recipeId);

    row.querySelector('td:nth-child(5) button').disabled = true;

}

async function saveEdit(row, recipeId) {

    const name = document.querySelector("#name").value;
    const ingredients = Array.from(document.querySelectorAll(".ingredient-input")).map(input => input.value);
    const method = Array.from(document.querySelectorAll(".method-input")).map(input => input.value);
    method.length = method.length - 1;
    ingredients.length = ingredients.length - 1;
    console.log(method);
    const updateRecipe = {
        id: recipeId,
        name: name,
        ingredients: ingredients,
        method: method
    };

    const uri = `${window.location.origin}/recipes/${recipeId}`;
    const config = {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(updateRecipe)
    };

    try {
        const response = await fetch(uri, config);
        const updatedRecipe = await response.json();
        // You might want to update the UI or handle success here
    } catch (error) {
        console.error('Error:', error);
        // Handle errors appropriately
    }


    let cells = row.children;
    console.log(cells[1].innerHTML);

    let ingredientsListHTML = '<ul>';
    for (let i = 0; i < ingredients.length; i++) {
        ingredientsListHTML += `<li>${ingredients[i]}</li>`;
    }
    ingredientsListHTML += '</ul>';

    //creates method lis
    let methodListHTML = '<ol>';
    for (let i = 0; i < method.length; i++) {
        methodListHTML += `<li>${method[i]}</li>`;
    }
    methodListHTML += '</ol>';

    cells[0].innerHTML = name;
    cells[1].innerHTML = ingredientsListHTML;
    cells[2].innerHTML = methodListHTML;
    cells[3].innerHTML = '<button class="edit">Edit</button>';
    cells[4].innerHTML = `<button class="deleteBtn" data-id="${recipeId}">Delete</button>`
}

function makeTable(recipeData) {
    const tBody = document.querySelector("#tbody");

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

    const uri = `${window.location.origin}/recipes`;
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
            <td id="${recipeData.id}">${recipeData.name}</td>
            <td>${ingredientsListHTML}</td>
            <td>${methodListHTML}</td>
            <td><button class="edit" >Edit</button></td>
            <td><button class="deleteBtn" data-id="${recipeData.id}">Delete</button></td>
        `;
    tBody.appendChild(row);
}

async function deleteRecipe(recipeId){
    const uri = `${window.location.origin}/recipes/${recipeId}`;
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
