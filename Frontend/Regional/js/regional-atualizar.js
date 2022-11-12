let id = localStorage.getItem('regionalID');

const formulario = document.querySelector("#form");

const dataOperacao = document.querySelector("#dataOperacao");
const veiculos = document.querySelector("#veiculos");

function carregar(){
    fetch("http://localhost:8090/v1/regional/" + id, {headers:{'Authorization': 'Basic ' + btoa("megatron:megatron")}, method: "GET"}).then((data)=>{
        return data.json();
    }).then((objectData)=>{
        dataOperacao.value = objectData.dataDeOperacao;
        veiculos.value = objectData.veiculos;
    });
}

formulario.addEventListener('submit', function(event){
    event.preventDefault();

    const dados = {
        regionalID: id,
        dataDeOperacao: dataOperacao.value,
        veiculos: veiculos.value
    }
    console.log(JSON.stringify(dados))
    atualizar(dados);
    window.location.assign('http://127.0.0.1:5500/Regional/lista.html');
});

function atualizar(dados){
    fetch("http://localhost:8090/v1/regional", {
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