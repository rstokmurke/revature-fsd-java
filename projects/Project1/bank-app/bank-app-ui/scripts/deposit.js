const urlParams = new URLSearchParams(window.location.search);
const currentAccountId = urlParams.get('id');
console.log(currentAccountId);

let amountEntered = document.getElementById("amount");
let depositBtn = document.getElementById("depositButton")

let amountError = document.getElementById("amountError");
let successMessage = document.getElementById("success");
let errorMessage = document.getElementById("error");

successMessage.style.display = "none";
errorMessage.style.display = "none";

depositBtn.addEventListener("click", function () {
    amountEnteredValid = true;
    if (amountEntered.value == "") {
        amountError.innerText = "Amount is manadatory";
        amountEnteredValid = false;
    }
    else if (amountEntered.value <= 0) {
        amountError.innerText = "Amount Cannot be less than 0";
        amountEnteredValid = false;
    }
    else if (!amountEntered.value.match(/^[0-9]+$/)) {
        amountError.innerText = "Amount should be in integers only.";
        amountEnteredValid = false;
    }
    if (amountEnteredValid == true) {
        console.log("Clicked");
        performDeposit();
    }
});

amountEntered.addEventListener("keyup", function () {
    if (amountEntered.value != "") {
        amountError.innerText = "";
    }
});

async function performDeposit() {
    let depositDetails = {
        id: currentAccountId,
        amount: amountEntered.value
    };
    var options = {
        method: 'PUT',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(depositDetails)
    };
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/transactions/deposit", options);

        if (response.status == 200){
            successMessage.style.display = "Block";
            errorMessage.style.display = "none";
            successMessage.innerText = "Deposit successfull."
            clearData();
        }

    }
    catch (err) {
        errorMessage.style.display = "block";
        errorMessage.innerText = "Server is facing issues. Try again later"
    }
}
function clearData(){
    amountEntered.value = " ";
}