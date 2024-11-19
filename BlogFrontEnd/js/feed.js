function exibirIframe(event)
{
   const iframe = document.getElementById("iframeFeed");
   if (iframe.style.display === 'none') {
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
    window.location.href = "/cadastro"
}