class User{
    nomeUsuario;
    email;
    senha;

    constructor(nomeUsuario,email,senha){
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }
}

function cadastroUser(event){
    event.preventDefault();
    const nomeusuario = document.getElementById("nome").value;
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value
    const senhaRepetida = document.getElementById("senhaRepetida").value
    checkSenha(nomeusuario,email,senha,senhaRepetida)
}

function checkSenha(nomeUsuario,email,senha,senhaRepetida){
    const regex = /^(?=.*[!@#$%^&*(),.?":{}|<>]).{8,20}$/;
    if (senha !== senhaRepetida) {
        document.getElementById("spanP").innerHTML = "As senhas não são iguais.";
    } else if (senha.length < 8) {
        document.getElementById("spanP").innerHTML = "A senha deve ter no mínimo 8 caracteres.";
    } else if (!regex.test(senha)) {
        document.getElementById("spanP").innerHTML = "A senha deve conter pelo menos um caractere especial.";
    } else {
        document.getElementById("spanP").innerHTML = "";
        salvarCad(nomeUsuario, email, senha);
    }
}

async function salvarCad(nomeUsuario,email,senha){
    const novoUser = new User (nomeUsuario,email,senha)
    console.log(novoUser)
    const url = 'http://localhost:8000/usuario'

    try{
        const response = await fetch(url,{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(novoUser)
        })

        if (!response.ok) {
            const errorText = await response.text();
            document.getElementById("spanP").innerHTML = errorText;
        }else{
            window.location.href = "index.html";
        }


    }catch(Error){
        alert(Error)
    }
}

