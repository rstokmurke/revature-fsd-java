let submitBtn = document.getElementById("submit");
let error = document.getElementById("error");
let form = document.forms[0];
error.style.display = "none";

submitBtn.addEventListener("click", function () { checkLogin(); });

async function checkLogin() {
    let email = form.email.value;
    let password = form.password.value;

    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/customers/"+email+"/"+password);
        // let data =  await response.json();
        
        if (response.status == 200){
            console.log("Login successful");
            window.location.href = "acc.html";
        
        }
        else if(response.status == "401"){
            console.log("Login failed");
            error.style.display = "block";
            error.innerText = "Enter Correct Credentials";
        }
       else  if(response.status == "404"){
            error.style.display = "block";
            error.innerText = "Enter E-mail and Password";
        }
    }
    catch(err) {
         error.style.display = "block";
         error.innerText = "Server is facing an issue. Try after sometime. Sorry For Inconvenience";
    }
} 
