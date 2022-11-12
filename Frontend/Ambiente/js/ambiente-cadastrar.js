const formulario = document.querySelector("#form");

const estado = document.querySelector("#estado");
const cidade = document.querySelector("#cidade");
const bairro = document.querySelector("#bairro");
const temperatura = document.querySelector("#temperatura");
const qualidadeAr = document.querySelector("#qualidadeAr");

formulario.addEventListener('submit', function(event){
    event.preventDefault();

    const dados = {
        estado: estado.value,
        cidade: cidade.value,
        bairro: bairro.value,
        temperaturaAmbiente: temperatura.value,
        qualidadeDoAr: qualidadeAr.value
    }
    cadastrar(dados);
    window.location.assign('http://127.0.0.1:5500/Ambiente/lista.html');
});

function cadastrar(dados){
    fetch("http://localhost:8090/v1/ambiente", {
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
