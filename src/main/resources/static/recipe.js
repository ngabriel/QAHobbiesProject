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
        
        
        //console.log(IngIDLteResponseist);
        //console.log(IngIDList[0]);
        //for ()
       

        data.name = recipeIn.value; 
        data.method = methodIn.value;
        axios.post(BASE_URL + '/recipe/create', data)
            .then(res => {
                const ingredList = document.getElementById("IDIn").value;
                let ingNameList = ingredList.split(', ');

                //document.getElementById("createRecipe").innerText = JSON.stringify(data, undefined, 2);
                const recipeID = res.data.id;
                axios.post(BASE_URL + '/ingredient/createRecipe/'+ recipeID, ingNameList)
                .then(res2 => {
                    document.getElementById("createRecipe").innerText = JSON.stringify(data, undefined, 2).pretty;
                })

            }
 ).catch(err => console.error(err));
           
    });

    document.getElementById('createIngButton').addEventListener('click', function () {
     
        let ingredient = prompt("Enter name of Ingredient to add");
        let data = {};
        if (ingredient == null || ingredient == "") {
           alert("User cancelled the prompt.");
          } else {
             alert("Ingredinent succesfully added");
   //const IngredientIn = document.getElementById("ingIn");
   //const IngredientIn = this.ingredient.value;
          }    
          
   data.name = ingredient; 
        axios.post(BASE_URL + '/ingredient/create', data)
            .then(res => document.getElementById("createIngredient").innerText = JSON.stringify(data.name, undefined, 2)
            
            ).catch(err => console.error(err));
           
    })
    ;

    document.getElementById('readRecButton').addEventListener('click', function () {
        axios.get(BASE_URL + '/recipe/read')
            .then(res =>
                document.getElementById('readRecOutput').innerText = res.data.map(recipe => recipe.name)
            ).catch(err => console.error(err));
    });

    document.getElementById('readIngButton').addEventListener('click', function () {
        axios.get(BASE_URL + '/ingredient/read')
            .then(res =>{
                alert("why!");
                document.getElementById('readIngOutput').innerText = JSON.stringify(res.data)
                      }
                                ).catch(err => console.error(err));
    });


    document.getElementById('deleteRecButton').addEventListener('click', function () {
        let data = {};
 
        const recipeDel = document.getElementById("recDel").value;
        
        axios.delete(BASE_URL + '/recipe/delete/'+ recipeDel)
        .then(res =>{
 
            console.log("recipe deleted")
            }
                
            ).catch(err => console.error(err));
    });   


    document.getElementById('updateIngButton').addEventListener('click', function () {
        let data = {};
 
        const oldN = document.getElementById("oldName").value;
        const newN  = document.getElementById("newName").value;
        
        axios.put(BASE_URL + '/ingredient/update/'+ oldN + '?name='+ newN)
        .then(res =>{
 
            console.log("recipe updated")
            }
                
            ).catch(err => console.error(err));
    }); 


})
();

