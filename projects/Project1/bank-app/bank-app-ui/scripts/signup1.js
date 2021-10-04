let signup = document.getElementById("submit");
let firstName = document.getElementById("firstName");
let lastName = document.getElementById("lastName");
let email = document.getElementById("email");
let password = document.getElementById("password");
let form = document.forms[0];
let valid = true;

let firstNameError = document.getElementById("firstNameError");
let lastNameError = document.getElementById("LastNameError");
let emailError = document.getElementById("emailError");
let passwordError = document.getElementById("passwordError");

success.style.display = "none";
error.style.display = "none";

let firstNameValid = true;
let lastNameValid = true;
let emailValid = true;
let passwordValid = true;
 


signup.addEventListener("click", function () {

    if (firstName.value == "" ) {
        
        firstNameError.innerText = "First name is required";
        firstNamevalid=false;
        
    }
    if(!firstName.value.match( /^[A-Za-z]+$/)){
         
        firstNameError.innerText = "Numbers cannot be included in name";
        firstNamevalid=false;
    }
    if (lastName.value == "" ) {
        
        lastNameError.innerText = "Last name is required";
        lastNamevalid=false;
    }
    if(!lastName.value.match( /^[A-Za-z]+$/)){
         
        lastNameError.innerText = "Numbers and Special Charcters can not be included in Lastname";
        lastNamevalid=false;
    }
    if(email.value == ""){
        emailError.innerText = "Email is mandatory";
        emailValid = false;
    }
    if(!email.value.match(/\S+@\S+\.\S+/)){
        emailError.innerText="Enter in valid format. Example abc@mail.com";
        emailValid = false;
    }
    if(password.value == ""){
        passwordError.innerText = "Password is Mandatory";
        passwordValid = false;
    }
    console.log(valid);
    if(firstNameValid == true && lastNameValid == true && emailValid == true && passwordValid == true){
        console.log("Clicked");
        addCustomer(); 
    }
});

firstName.addEventListener("keyup", function () {
    //console.log(firstName.value);
    if (firstName.value != "" && firstName.value.length > 20) {
        valid = false;
        firstNameError.innerText = "First Name cannot exceed 20 characters";
        return;
    }
    if (firstName.value != "" && firstName.value.length <= 20) {
        
      
        firstNameError.innerText = "";
        return;
    }
    // if (firstName.value != "") {
    //     let pattern = /^[A-Za-z]+$/;
    //     console.log(pattern);
    //     console.log(firstName.value.match(pattern));
    //     if (!firstName.value.match(pattern)) {
    //         firstNameError.innerText = "Numbers not allowed";
    //     }
    // }
   
});
lastName.addEventListener("keyup", function () {
    //console.log(firstName.value);
    if (lastName.value != "" && lastName.value.length > 20) {
        
        valid=false;
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

password.addEventListener("click",function(){
    if (password.value != "" && password.value.length <= 20) {
        
        passwordError.innerText = "";
        return;
    }
})

async function addCustomer() {
    let customer = {
        firstName: form.firstname.value,
        lastName: form.lastname.value,
        email: form.email.value,
        passowrd: form.password.value
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
        //window.location.href = "login.html"
    }
    catch (err) {
        error.style.display = "block";
        error.innerText = "Failed to add employee. Retry or report to site administrator."
    }
}
function clearFormData() {
    form.firstname.value = "",
        form.lastname.value = "",
        form.email.value = "",
        form.password.value = ""
}