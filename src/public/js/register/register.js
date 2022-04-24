const xhttp = new XMLHttpRequest()

var data = {
}

function clearAllFields() {
  document.getElementById("name").value = ("")
  document.getElementById("barcode").value = ("")
  document.getElementById("price").value = ("")
  document.getElementById("quantity").value = ("")
  document.getElementById("brand").value = ("")
}

function sendData() {
  if (verifyData()) {
    console.log("ok")
    var url = `http://localhost:8080/api/v1/product`

    xhttp.open("POST", url, true)

    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8")

    xhttp.onreadystatechange = function () {
      if (xhttp.readyState == 4 && xhttp.status == 201) {
        clearAllFields()
        alert("Produto cadastrado")
      } else if (xhttp.readyState == 4 ) {
        alert(xhttp.responseText)
      }
    }
    console.log(data)

    xhttp.send(JSON.stringify({
      name: data.name,
      brand: {
        name: data.brand
      },
      barcode: data.barcode,
      quantity: data.quantity,
      price: data.price,
      measure: data.measure
    })
    )
  }
}

function verifyData() {
  data.name = document.getElementById("name").value
  data.barcode = document.getElementById("barcode").value
  data.price = document.getElementById("price").value
  data.quantity = document.getElementById("quantity").value
  data.brand = document.getElementById("brand").value
  data.measure = document.querySelector('input[name="exampleRadios"]:checked').value;

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

