const formulario = document.querySelector("#form");

const dataOperacao = document.querySelector("#dataOperacao");
const veiculos = document.querySelector("#veiculos");

formulario.addEventListener('submit', function(event){
    event.preventDefault();

    const dados = {
        dataDeOperacao: dataOperacao.value,
        veiculos: veiculos.value
    }
    cadastrar(dados);
    window.location.assign('http://127.0.0.1:5500/Regional/lista.html');
});

function cadastrar(dados){
    fetch("http://localhost:8090/v1/regional", {
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
