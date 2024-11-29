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
    const postagem = await feed(); 
    console.log(postagem);

    const container = document.getElementById("comentariosContainer");
    container.innerHTML = ''; 

    if (postagem) {
        postagem.forEach(element => {
            
            const divComentario = document.createElement('div');
            divComentario.classList.add('divPosts');

            const usuario = document.createElement('h1');
            usuario.textContent = element.usuarioDono;

        
            const date = document.createElement('h2');
            const dataBruta = element.dataCriacao;
            const data = new Date(dataBruta);

            const dia = String(data.getDate()).padStart(2, '0');
            const mes = String(data.getMonth() + 1).padStart(2, '0');
            const ano = data.getFullYear();
            const horas = String(data.getHours()).padStart(2, '0');
            const minutos = String(data.getMinutes()).padStart(2, '0');
            const segundos = String(data.getSeconds()).padStart(2, '0');
            const dataFormatada = `${dia}/${mes}/${ano} ${horas}:${minutos}:${segundos}`;

            date.textContent = dataFormatada;
            const postagemTexto = document.createElement('p');
         
            postagemTexto.classList.add('textos');
            postagemTexto.textContent = element.postagem; 
            divComentario.appendChild(usuario);
            divComentario.appendChild(date);
            divComentario.appendChild(postagemTexto);
            container.appendChild(divComentario);
        });
    }
}
