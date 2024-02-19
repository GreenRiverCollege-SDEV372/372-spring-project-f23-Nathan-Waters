window.onload = async function() {
    const uri = "http://localhost:8080/recipes/all";
    const config = {
        method: 'get'
    }

    const response = await fetch(uri, config);
    const data = await response.json();
    makeTable(data);
}

function makeTable(recipeData){
    const tBody = document.querySelector("#tbody");
    // console.log(recipeData[0])

    for(let i = 0; i < recipeData.length; i++){
        const row = document.createElement('tr');
        addRecipeToTable(row, recipeData[i], tBody);
    }
}

function addRecipeToTable(row, recipeData, tBody){
    const ingredientsList = recipeData.ingredients.map(ingredient => `<li>${ingredient}</li>`).join('');
    const methodList = recipeData.method.map(step => `<li>${step}</li>`).join('');

    row.innerHTML += `
            <td>${recipeData.name}</td>
            <td><ul>${ingredientsList}</ul></td>
            <td><ul>${methodList}</ul></td>
            <td>edit</td>
            <td>delete</td>
        `;
    tBody.appendChild(row);
}

