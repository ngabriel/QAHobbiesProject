const BASE_URL = "http://localhost:8083";

(function () {

    function displayOutput(id, {data}) {
        document.getElementById(id).innerText = JSON.stringify(data, undefined, 2);
    }
    function displayOutputName(id, {data}) {
        document.getElementById(id).innerText = JSON.stringify(data, undefined, 2);
    }

    document.getElementById('createRecButton').addEventListener('click', function () {
        let data = {};
        const recipeIn = document.getElementById("recIn");
        const methodIn = document.getElementById("methIn");
        data.name = recipeIn.value; 
        data.method = methodIn.value;
        axios.post(BASE_URL + '/recipe/create', data)
            .then(res => document.getElementById("createRecipe").innerText = JSON.stringify(data, undefined, 2)
            
            ).catch(err => console.error(err));
           
    });

    document.getElementById('createIngButton').addEventListener('click', function () {
        let data = {};
        const IngredientIn = document.getElementById("ingIn");
        data.name = IngredientIn.value; 
        axios.post(BASE_URL + '/ingredient/create', data)
            .then(res => document.getElementById("createIngredient").innerText = JSON.stringify(data.name, undefined, 2)
            
            ).catch(err => console.error(err));
           
    });

    document.getElementById('readRecButton').addEventListener('click', function () {
        axios.get(BASE_URL + '/recipe/read')
            .then(res =>
                document.getElementById('readRecOutput').innerText = JSON.stringify(res.data)
            ).catch(err => console.error(err));
    });

    document.getElementById('readIngButton').addEventListener('click', function () {
        axios.get(BASE_URL + '/ingredient/read')
            .then(res =>
                document.getElementById('readIngOutput').innerText = JSON.stringify(res.data)
            ).catch(err => console.error(err));
    });







    // document.getElementById('deleteButton').addEventListener('click', function () {
    //     axios.delete(`${BASE_URL}/duck/deleteDuck/${document.getElementById('deleteInput').value}`)
    //         .then(res =>
    //             displayOutput("deleteOutput", res)
    //         ).catch(err => console.error(err));
    // });
})()

