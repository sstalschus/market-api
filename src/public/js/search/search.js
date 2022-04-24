const http = new XMLHttpRequest()
var data = {
  all: []
}

function clearField() {
  document.getElementById("productName").value = ("")
}

function alertP(dis) {
  document.getElementById("myAlert").style.display = dis;
}

function findAll() {
  cleanTable()
  var value = document.getElementById("productName").value

  var url = `http://localhost:8080/api/v1/product`

  if(value != null && value != "" && value != undefined) 
    url = `http://localhost:8080/api/v1/product/by?name=${value}`

    console.log(url)


  http.open("GET", url, true)

  http.onreadystatechange = function () {
    if (http.readyState == 4 && http.status == 200) {
      console.log(http.response)
      data.all = JSON.parse(http.response)
      if(data.all.length == 0) {
        alertP("block")
      } else {
        alertP("none")
        populateTable(data.all)
      }
    }
  }
  http.send()
}

function populateTable(data) {
  data.forEach(element => {
    tablePopulate(element.name, element.brand.name, element.barcode, element.price, element.quantity, element.measure)
  });
}

function cleanTable(){
  document.getElementById('tbody').innerHTML = ""
}

function tablePopulate(name, brand, barcode, price, quantity, measure) {
  var html = `
    <th scope="row"> ${name}
      <img src="assets/icon.webp" alt="" style="width: 1rem">
      <br>
      <small class="form-text text-muted">Fornecedor: ${brand}</small>
    </th>

    <td>
    <small class="form-text text-muted">Código: ${barcode}</small>
    </td>

    <td>
    <small class="form-text text-muted">R$: ${price},00 / ${measure == "UNIT" ? "Und." : "Kg"} </small>
    </td>

    <td>
    <small class="form-text text-muted">${quantity} ${measure == "UNIT" ? "Unds." : "Kgs"}</small>
    </td>
    `
  var table = document.getElementById('tbody')
  var row = document.createElement("tr")
  row.innerHTML = html
  table.append(row)
}
