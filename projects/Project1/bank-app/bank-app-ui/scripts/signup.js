let signup = document.getElementById("submit");
let firstName = document.getElementById("firstName");
let lastName = document.getElementById("lastName");
let email = document.getElementById("email");
let password = document.getElementById("password");
let form = document.forms[0];
let valid = true;

let firstNameError = document.getElementById("firstNameError");
let lastNameError = document.getElementById("lastNameError");
let emailError = document.getElementById("emailError");
let passwordError = document.getElementById("passwordError");

let success = document.getElementById("success");
let error = document.getElementById("error");

let firstNameValidError;
let lastNameValidError;

success.style.display = "none";
error.style.display = "none";


signup.addEventListener("click", function() {
    // console.log("clicked");
    let firstNameValid = true;
    let lastNameValid = true;
    let emailValid = true;
    let passwordValid = true;

    if (firstName.value == "") {
        
        firstNameError.innerText = "First name is required";
        firstNameValid = false;
        // return;
    }
    else if (!firstName.value.match(/^[A-Za-z]+$/)) {

        firstNameError.innerText = "First name should be in alphabets only";
        firstNameValid = false;
        // return;

    }
    if (lastName.value == "") {
        
        lastNameError.innerText = "last name is required";
        lastNameValid = false;
        // return;
    }
    else if (!lastName.value.match(/^[A-Za-z]+$/)) {

        lastNameError.innerText = "last name should be in alphabets only";
        lastNameValid = false;
        // return;
    }

    if (email.value == "") {
        
        emailError.innerText = "Email is required";
        emailValid = false;

    }
    else if (!email.value.match(/@{1}.{1}/)) {
        emailError.innerText = "Invalid format ex : abc@mail.com";
        emailValid = false;

    }
    if (password.value == "") {
        
        passwordError.innerText = "Password is required";
        passwordValid = false;
        

    }
    if (firstNameValid == true && lastNameValid == true && emailValid == true && passwordValid == true) {
        console.log("Clicked");
        addCustomer();
    }

    // addCustomer();
});

firstName.addEventListener("keyup", function () {
    //console.log(firstName.value);
    firstNameValidError = true;
    if (firstName.value != "" && firstName.value.length > 20) {
        firstNameValidError = false;
        firstNameError.innerText = "First Name cannot exceed 20 characters";
        return;
    }
    if (firstName.value != "" && firstName.value.length <= 20) {
        
       
        firstNameError.innerText = "";
        return;
    }
});
lastName.addEventListener("keyup", function () {
    //console.log(firstName.value);
    lastNameValidError = true;
    if (lastName.value != "" && lastName.value.length > 20) {
        
        lastNameValidError = false;
        lastNameError.innerText = "Last Name cannot exceed 20 characters";
        return;
    }
    if (lastName.value != "" && lastName.value.length <= 20) {
        
        lastNameError.innerText = "";
        return;
    }
});
email.addEventListener("keyup", function () {
    //console.log(firstName.value);
    // if (email.value != "" && email.value.length > 20) {
        
    //     emailError.innerText = "Last Name cannot exceed 20 characters";
    //     return;
    // }
    if (email.value != "" ) {
        emailError.innerText = "";
        return;
    }
    
});
password.addEventListener("keyup", function(){
    if (password.value != "" && password.value.length <= 20) {
        console.log("called");
        passwordError.innerText = "";
        return;
    }
});


async function addCustomer() {
    let customer = {
        firstname: firstName.value,
        lastname: lastName.value,
        email: email.value,
        password: password.value
    };

    var options = {
        method: 'POST',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(customer)
    };

    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/customers", options);
        clearFormData();
        success.style.display = "block";
        success.innerText = "Customer Added Successfully";
        // window.location.href = "customerLogin.html"
    }
    catch (err) {
        error.style.display = "block";
        error.innerText = "Failed to add employee. Retry or report to site administrator."
        console.log("failed");
    }
}
function clearFormData() {
    firstName.value = "",
        lastName.value = "",
        email.value = "",
        password.value = ""
}

