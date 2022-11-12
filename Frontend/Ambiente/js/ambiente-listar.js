function listar(){
    fetch("http://localhost:8090/v1/ambiente", {headers:{'Authorization': 'Basic ' + btoa("megatron:megatron")}, method: "GET"}).then((data)=>{
        return data.json();
    }).then((objectData)=>{
        let tableData = "";
        objectData.map((values)=>{
            tableData += `<tr class="ambiente-content">
                            <td>${values.estado}</td>
                            <td>${values.cidade}</td>
                            <td>${values.bairro}</td>
                            <td>${values.temperaturaAmbiente + "ºC"}</td>
                            <td>${values.qualidadeDoAr}</td>
                            <td><i class="fa-solid fa-pen icons" onclick="atualizar(${values.ambienteID})"></i> <i class="fa-solid fa-trash icons" onclick="deletar(${values.ambienteID})"></i></td>	
                          </tr>`;
        });
        document.querySelector("#tableContent").innerHTML = tableData;
    });
}

function deletar(id){
    fetch("http://localhost:8090/v1/ambiente", {
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
    window.location.assign('http://127.0.0.1:5500/Ambiente/lista.html');
}

function atualizar(id){
    localStorage.setItem('ambienteID', id);
    window.location.assign('http://127.0.0.1:5500/Ambiente/atualizar.html');
}
