
async function getCustomerAccounts() {
    let response = await fetch("http://localhost:8080/bank-app-rest/employees");
    let customers = await response.json();
    let element = "";
    for (var customer of customers) {
        console.log("called");
        element += `<tr>
    <td>${customer.id}</td>
    <td>${customer.balance}</td>
    <td><a href="transactions.html?id=${customer.id}" >Transactions</a></td>
  </tr>`
    }
    document.getElementById("cust").innerHTML = element;


}
getCustomerAccounts();
