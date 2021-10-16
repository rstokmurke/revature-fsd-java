let submitBtn = document.getElementById("submit");
let error = document.getElementById("error");
let form = document.forms[0];
let emailfield = document.getElementById("email");
let passowrdfield = document.getElementById("password");
let emailError = document.getElementById("emailerror");
let passwordError = document.getElementById("passworderror");
error.style.display = "none";

submitBtn.addEventListener("click", function () {
    let emailValid = true;
    let passwordValid = true;
    if (email.value == "") {
        emailError.innerText = "Email is mandatory";
        emailValid = false;
    }
    else if (!email.value.match(/[a-z0-9._%+-]+@[a-z0-9.9.-]+\.[a-z]{2,}$/)) {
        emailError.innerText = "Enter in valid format. Example abc@mail.com";
        emailValid = false;
    }
    if (password.value == "") {
        passwordError.innerText = "Password is Mandatory";
        passwordValid = false;
    }

    if(emailValid == true && passwordValid == true){
        console.log("called");
        checkLogin();
    }

    
});

email.addEventListener("keyup", function () {
    //console.log(firstName.value);
    // if (email.value != "" && email.value.length > 20) {
        
    //     emailError.innerText = "Last Name cannot exceed 20 characters";
    //     return;
    // }
    if (email.value != "" ) {
        emailError.innerText = "Email is mandatory";
        return;
    }
    
});

password.addEventListener("keyup", function(){
    if (password.value != "" && password.value.length <= 20) {
        console.log("called");
        passwordError.innerText = "Password is mandatory";
        return;
    }
});



async function checkLogin() {
    let employee = {
        email: form.email.value,
        password: form.password.value
    }
    var options = {
        method: 'POST',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(employee)
    };
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/employees", options);
        //let data =  await response.json();

        if (response.status == 200) {
            console.log("Login successfyul");
            window.location.href = "employeeaccounts.html";

        }
        else if (response.status == "401") {
            console.log("Login failed");
            error.style.display = "block";
            error.innerText = "Invalid email/password. Enter correct credentials";
        }
        else if (response.status == "404") {
            error.style.display = "block";
            error.innerText = "Enter E-mail and Password";
        }
    }
    catch (err) {
        error.style.display = "block";
        error.innerText = "Server is facing an issue. Try after sometime. Sorry For Inconvenience";
    }
}