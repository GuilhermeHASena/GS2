function listar(){
    fetch("http://localhost:8090/v1/veiculo", {headers:{'Authorization': 'Basic ' + btoa("megatron:megatron")}, method: "GET"}).then((data)=>{
        return data.json();
    }).then((objectData)=>{
        let tableData = "";
        objectData.map((values)=>{
            tableData += `<tr class="veiculo-content">
                            <td>${values.ambienteID.estado}</td>
                            <td>${values.marca}</td>
                            <td>${values.modelo}</td>
                            <td>${values.placa}</td>
                            <td>${values.quilometragem}</td>
                            <td><i class="fa-solid fa-pen icons" onclick="atualizar(${values.veiculoID})"></i> <i class="fa-solid fa-trash icons" onclick="deletar(${values.veiculoID})"></i></td>	
                          </tr>`;
        });
        document.querySelector("#tableContent").innerHTML = tableData;
    });
}

function deletar(id){
    fetch("http://localhost:8090/v1/veiculo", {
        headers:{
            'Accept' : 'application/json',
            'Content-Type' : 'application/json',
            'Authorization': 'Basic ' + btoa("megatron:megatron")
        },
        method: "DELETE",
        body: JSON.stringify(id)
    })
    .then(function (res) { console.log(res) })
    .catch(function (res) { console.log(res) })
    window.location.assign('http://127.0.0.1:5500/Veiculo/lista.html');
}

function atualizar(id){
    localStorage.setItem('veiculoID', id);
    window.location.assign('http://127.0.0.1:5500/Veiculo/atualizar.html');
}