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

  http.open("GET", url, true)

  http.onreadystatechange = function () {
    if (http.readyState == 4 && http.status == 200) {
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

function updateData() {
  console.log(data)
  if (verifyData()) {
    var url = `http://localhost:8080/api/v1/product`

    xhttp.open("PATCH", url, true)

    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8")

    xhttp.onreadystatechange = function () {
      if (http.readyState == 4 && xhttp.status == 200) {
        data = {
          all: []
        }
        alert("Produto editado")
        findAll()
      } else if (http.readyState == 4 ) {
      }
    }

    xhttp.send(JSON.stringify({
          id: data.id,
          name: data.name,
          brand: {
            name: data.brand
          },
          barcode: data.barcode,
          quantity: data.quantity,
          price: data.price
        })
    )
  }
}

function populateTable(data) {
  data.forEach(element => {
    tablePopulate(element.name, element.brand.name, element.barcode, element.price, element.quantity, element.measure, element.id)
  });
}

function cleanTable(){
  document.getElementById('tbody').innerHTML = ""
}

function deleteProduct(contextId) {
  var url = `http://localhost:8080/api/v1/product/${contextId}`

  http.open("DELETE", url, true)

  http.onreadystatechange = function () {
    if (http.readyState == 4 && http.status == 200) {
      clearField()
      findAll()
    } else if(http.readyState == 4) {
      alert("Erro interno do servidor")
    }
  }
  http.send()
}

function tablePopulate(name, brand, barcode, price, quantity, measure, id) {
  var html = `
    <th scope="row"> ${name}
      <img id="${id}" onclick="deleteProduct(this.id)" src="assets/icon.webp" alt="" style="width: 1rem">
      <br>
      <small class="form-text text-muted">Fornecedor: ${brand}</small>
    </th>

    <td>
    <small class="form-text text-muted">Código: ${barcode}</small>
    </td>

    <td>
    <small class="form-text text-muted">R$: ${price.toFixed(2)} / ${measure == "UNIT" ? "Und." : "Kg"} </small>
    </td>

    <td>
    <small class="form-text text-muted">${quantity} ${measure == "UNIT" ? "Unds." : "Kgs"}</small>
    </td>
    
    <td>
     <img id="${id}" onclick="deleteProduct(this.id)" src="assets/icon_x_.png" alt="" style="width: 1rem; cursor: pointer;"> Apagar
     <br>
     <img id="${id}" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="populateModal(this.id)" src="https://cdn-icons-png.flaticon.com/512/46/46549.png" alt="" style="width: 1rem; cursor: pointer;"> Editar
    </td>
    `
  var table = document.getElementById('tbody')
  var row = document.createElement("tr")
  row.innerHTML = html
  table.append(row)
}

function verifyData() {
  data.name = document.getElementById("name").value
  data.barcode = document.getElementById("barcode").value
  data.price = document.getElementById("price").value
  data.quantity = document.getElementById("quantity").value
  data.brand = document.getElementById("brand").value

  if (data.name === "" || data.name === null || data.name === undefined) {
    alert("Nome inválido")
    return false
  }
  else if (data.barcode === "" || data.barcode === null || data.barcode === undefined) {
    alert("Barcode inválido")
    return false
  }
  else if (data.price === "" || data.price === null || data.price === undefined) {
    alert("Preço inválido")
    return false
  }
  else if (data.quantity === "" || data.quantity === null || data.quantity === undefined) {
    alert("Quantidade inválido")
    return false
  }
  else if (data.brand === "" || data.brand === null || data.brand === undefined) {
    alert("Marca inválida")
    return false
  }
  else {
    return true
  }

}

function populateModal(contextId) {
  var product = data.all.find(index => index.id == contextId)

  data.id = product.id
  data.name = document.getElementById("name").value = product.name
  data.barcode = document.getElementById("barcode").value = product.barcode
  data.price = document.getElementById("price").value = product.price
  data.quantity = document.getElementById("quantity").value = product.quantity
  data.brand = document.getElementById("brand").value = product.brand.name
}
