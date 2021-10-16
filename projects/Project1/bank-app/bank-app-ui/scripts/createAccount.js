let account = document.getElementById("accountNumber");
let balance = document.getElementById("balance");
let successMessage = document.getElementById("success");
let errorMessage = document.getElementById("error");
let accountSubBtn = document.getElementById("submit");
successMessage.style.display = "none";
errorMessage.style.display = "none";
let accountError = document.getElementById("accountNumberError");
let balanceError = document.getElementById("balanceError");

accountSubBtn.addEventListener("click", function () {
    let balanceValid = true;
    let accountValid = true;

    if (account.value == "") {
        accountValid = false;
        accountError.innerText = "Account number is Manadatory";
        return;
    }
    else if (account.value <= 0 || account.value > 10000000) {
        accountValid = false;
        accountError.innerText = "Account No cannot be 0 or negative or more than 10000000";
    }
    else if (!account.value.match(/^[0-9]+$/)) {
        accountValid = false;
        accountError.innerText = "Account Number Should be integers only";
    }
    if (balance.value == "") {
        balanceValid = false;
        balanceError.innerText = "Balance is Manadatory";
        return;
    }
    else if (balance.value <= 0 || balance.value > 10000000) {
        balanceValid = false;
        balanceError.innerText = "Balance cannot be 0 or negative or more than 10000000";
    }
    else if (!balance.value.match(/^[0-9]+$/)) {
        balanceValid = false;
        balanceError.innerText = "Balance Should be integers only";
    }
    console.log(accountValid);
    console.log(balanceValid);
    if (accountValid==true && balanceValid == true) {
        console.log("clicked");
        createAccount();
    }
});
account.addEventListener("keyup", function () {
    if (account.value != "") {
        accountError.innerText = "";
    }
});

balance.addEventListener("keyup", function () {
    if (balance.value != "") {
        balanceError.innerText = "";
    }
});

async function createAccount() {
    let account1 = {
        accountNo: account.value,
        balance: balance.value
    };
    var options = {
        method: 'POST',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(account1)
    };
    try{
    let response = await fetch("http://localhost:8080/bank-app-rest/accounts",options)
    console.log("Account Created Successfully");
    clearFormData();
    successMessage.style.display = "block";
    successMessage.innerText = "Account Created Successfully. "
    }
    catch(err){
        errorMessage.style.display = "block";
        errorMessage.innerText = "Failed to create account. Retry or report to site administrator.";
    }
};
function clearFormData(){
    account.value = "",
    balance.value = "";
}