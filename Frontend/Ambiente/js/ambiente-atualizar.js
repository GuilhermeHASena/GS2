let id = localStorage.getItem('ambienteID');

const formulario = document.querySelector("#form");

const estado = document.querySelector("#estado");
const cidade = document.querySelector("#cidade");
const bairro = document.querySelector("#bairro");
const temperatura = document.querySelector("#temperatura");
const qualidadeAr = document.querySelector("#qualidadeAr");

function carregar(){

    fetch("http://localhost:8090/v1/ambiente/" + id, {headers:{'Authorization': 'Basic ' + btoa("megatron:megatron")}, method: "GET"}).then((data)=>{
        return data.json();
    }).then((objectData)=>{
        estado.value = objectData.estado;
        cidade.value = objectData.cidade;
        bairro.value = objectData.bairro;
        temperatura.value = objectData.temperaturaAmbiente;
        qualidadeAr.value = objectData.qualidadeDoAr;
    });
}

formulario.addEventListener('submit', function(event){
    event.preventDefault();

    const dados = {
        ambienteID: id,
        estado: estado.value,
        cidade: cidade.value,
        bairro: bairro.value,
        temperaturaAmbiente: temperatura.value,
        qualidadeDoAr: qualidadeAr.value
    }
    atualizar(dados);
    window.location.assign('http://127.0.0.1:5500/Ambiente/lista.html');
});

function atualizar(dados){
    fetch("http://localhost:8090/v1/ambiente", {
        headers:{
            'Accept' : 'application/json',
            'Content-Type' : 'application/json',
            'Authorization': 'Basic ' + btoa("megatron:megatron")
        },
        method: "PUT",
        body: JSON.stringify(dados)
    })
    .then(function (res) { console.log(res) })
    .catch(function (res) { console.log(res) })
};