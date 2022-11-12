const formulario = document.querySelector("#form");

const ambiente = document.querySelector("#ambiente");
const marca = document.querySelector("#marca");
const modelo = document.querySelector("#modelo");
const placa = document.querySelector("#placa");
const quilometragem = document.querySelector("#quilometragem");

function carregarAmbiente(){
    fetch("http://localhost:8090/v1/ambiente", {headers:{'Authorization': 'Basic ' + btoa("megatron:megatron")}, method: "GET"}).then((data)=>{
        return data.json();
    }).then((objectData)=>{
        let tableData = "";
        objectData.map((values)=>{
            tableData += `<option value="${values.ambienteID}">${values.estado + " - " + values.bairro + " - " + values.temperaturaAmbiente + "ºC"}</option>`;
        });
        document.querySelector("#ambiente").innerHTML += tableData;
    });
}

formulario.addEventListener('submit', function(event){
    event.preventDefault();

    const dados = {
        ambienteID: {ambienteID: ambiente.value},
        marca: marca.value,
        modelo: modelo.value,
        placa: placa.value,
        quilometragem: quilometragem.value
    }
    console.log(JSON.stringify(dados))
    cadastrar(dados);
    window.location.assign('http://127.0.0.1:5500/Veiculo/lista.html');
});

function cadastrar(dados){
    fetch("http://localhost:8090/v1/veiculo", {
        headers:{
            'Accept' : 'application/json',
            'Content-Type' : 'application/json',
            'Authorization': 'Basic ' + btoa("megatron:megatron")
        },
        method: "POST",
        body: JSON.stringify(dados)
    })
    .then(function (res) { console.log(res) })
    .catch(function (res) { console.log(res) })
};
