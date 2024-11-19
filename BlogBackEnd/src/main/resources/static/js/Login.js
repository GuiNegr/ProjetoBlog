class UserDTO{
    email;
    senha;

    constructor(email,senha){
        this.email = email;
        this.senha = senha;
    }

}

function logarUser(event){
    event.preventDefault();
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value
    verificabanco(email,senha)
}

async function verificabanco(email,senha){
  

    const loginDto = new UserDTO(email,senha)

    const url = 'http://localhost:8000/usuario/login'

    try{
        const response = await fetch(url,{
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(loginDto)
        })

        if(!response.ok){
            const errorText = await response.text();
            document.getElementById("spanP").innerHTML = errorText;
        }else{
            const userLogado = await response.json()
            sessionStorage.setItem("usuarioLogado", JSON.stringify(userLogado));
            window.location.href = "feed.html"
        }
    }catch(Error){
        console.log(Error)
    }
}