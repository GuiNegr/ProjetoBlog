async function publicar(event){
    event.preventDefault();
    console.log("fui assionado")
    const publicacao = document.getElementById("publicacao").value;
    console.log(publicacao)
    const usuarioLogado = JSON.parse(sessionStorage.getItem("usuarioLogado"));
    console.log(usuarioLogado)
    try{

        const publicacaoJson =
            {
                postagem : publicacao,
                usuarioDono : usuarioLogado.nomeUsuario
            }
        const url = `http://localhost:8000/postagem/${usuarioLogado.id}`;
        const response = await fetch(url,{
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(publicacaoJson)
        })
        if(!response.ok){
            const errorText = await response.text();
            document.getElementById("spanP").innerHTML = errorText;
        }else{
            document.getElementById("publicacao").value = "";
            window.parent.postMessage("fecharIframe", "*");
        }
    }catch(error){
        console.log(error)
    }
}