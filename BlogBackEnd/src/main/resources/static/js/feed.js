document.addEventListener('DOMContentLoaded', async function () {
    const usuarioLogado = JSON.parse(sessionStorage.getItem("usuarioLogado"));
    if(usuarioLogado){
        exibirFeed()
    }else{
        window.location.href = "login.html"
    }
});



function exibirIframe(event)
{
    const iframe = document.getElementById("iframeFeed");
    const computedStyle = window.getComputedStyle(iframe);
    if (computedStyle.display === 'none') {
        iframe.style.display = 'block';
    } else {
        iframe.style.display = 'none';
    }
    const navBtn = document.getElementById("nav-button")
    if(navBtn.textContent === 'ENVIAR PUBLICAÇÃO'){
        navBtn.innerHTML = "FECHAR PUBLICAÇÃO"
    }else{
        navBtn.innerHTML = "ENVIAR PUBLICAÇÃO"
    }
}

function logout(){
    sessionStorage.removeItem("usuarioLogado")
    window.location.href = "/"
}


window.addEventListener("message", function(event) {

    if (event.data === "fecharIframe") {
        const iframe = document.getElementById("iframeFeed");
        iframe.style.display = "none";
        const navBtn = document.getElementById("nav-button");
        navBtn.innerHTML = "ENVIAR PUBLICAÇÃO";
        this.window.location.reload()
    }
});

async function feed() {

    const url =  `http://localhost:8000/postagem/CarregarFeed`;

    try {
        const response = await fetch(url)
        const data = await response.json();
        return data
    }catch (Error){
        console.log(Error)
    }
}


 async function exibirFeed() {
  
        const postagem = await feed()
        console.log(postagem)
        const container = document.getElementById("comentariosContainer")
        container.innerHTML = '';
        if(postagem){
            postagem.forEach(element => {
                const divComentario =document.createElement('div')
                divComentario.classList.add('divComentario')
         
                const loginEData = document.createElement('div')
                loginEData.classList.add('loginEData')
         
                const usuario = document.createElement('p')
                 usuario.textContent = element.usuarioDono;
         
                 const date = document.createElement('p')
         
                 const dataBruta = element.dataCriacao;
                 const data = new Date(dataBruta);
         
                 const dia = String(data.getDate()).padStart(2, '0');
                 const mes = String(data.getMonth() + 1).padStart(2, '0');
                 const ano = data.getFullYear();
                 const horas = String(data.getHours()).padStart(2, '0');
                 const minutos = String(data.getMinutes()).padStart(2, '0');
                 const segundos = String(data.getSeconds()).padStart(2, '0');
                 const dataFormatada = `${dia}/${mes}/${ano} ${horas}:${minutos}:${segundos}`;
         
         
                 date.textContent = dataFormatada
         
                 loginEData.appendChild(usuario)
                 loginEData.appendChild(date)
         
                 const postagem = document.createElement('div');
                 postagem.classList.add('postagem')
         
                 const texto = document.createElement('p');
                 texto.textContent = element.postagem;
         
                 postagem.appendChild(texto);
         
         
                 divComentario.appendChild(loginEData);
                 divComentario.appendChild(postagem);
         
                 container.appendChild(divComentario);
             });
        }
}