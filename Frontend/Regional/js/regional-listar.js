function listar(){
    fetch("http://localhost:8090/v1/regional", {headers:{'Authorization': 'Basic ' + btoa("megatron:megatron")}, method: "GET"}).then((data)=>{
        return data.json();
    }).then((objectData)=>{
        let tableData = "";
        objectData.map((values)=>{
            tableData += `<tr class="regional-content">
                            <td>${values.dataDeOperacao}</td>
                            <td>${values.veiculos}</td>
                            <td><i class="fa-solid fa-pen icons" onclick="atualizar(${values.regionalID})"></i> <i class="fa-solid fa-trash icons" onclick="deletar(${values.regionalID})"></i></td>	
                          </tr>`;
        });
        document.querySelector("#tableContent").innerHTML = tableData;
    });
}

function deletar(id){
    fetch("http://localhost:8090/v1/regional", {
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
    window.location.assign('http://127.0.0.1:5500/Regional/lista.html');
}

function atualizar(id){
    localStorage.setItem('regionalID', id);
    window.location.assign('http://127.0.0.1:5500/Regional/atualizar.html');
}