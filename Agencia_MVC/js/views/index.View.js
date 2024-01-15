class IndexView {
    renderWhatsAppButton(link) {
        const comprarButton = document.getElementById('botaoComprar');
        const comprarButton1 = document.getElementById('botaoComprar1');
        const comprarButton2 = document.getElementById('botaoComprar2');
        const comprarButton3 = document.getElementById('botaoComprar3');
        comprarButton.href = link;
        comprarButton1.href=link;
        comprarButton2.href=link;
        comprarButton3.href=link;
    }
 
}

class LoginView {
    renderLoginForm() {
        const formContainer = document.querySelector('.form-container');
        formContainer.innerHTML = `<!DOCTYPE html>
        <html lang="pt-br">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Seu Título</title>
            <style>
                body {
                    height: 100vh;
                    margin: 0;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    text-align: center;
                }
        
                form {
                    max-width: 300px;
                    padding: 15px;
                    margin: auto;
                }
        
                .form-floating {
                    margin-bottom: 15px;
                }
        
                .btn {
                    cursor: pointer;
                }
            </style>
        </head>
        <body>
        
        
            <form class="form-signin">
                <img src="img/globe-asia-australia.svg" alt="" class="mb-4" height="57" width="72">
                <h1 class="h3 mb-3 fw-normal">Faça Login</h1>
                <div class="form-floating">
                    <input type="text" name="username" class="form-control" id="floatingInput" placeholder="seunome@gmail.com" required>
                    <label for="floatingInput">Login</label>
                </div>
                <div class="form-floating">
                    <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="senha" required>
                    <label for="floatingPassword">Senha</label>
                </div>
                <button class="btn btn-primary w-100 py-2" id="loginButton">Entrar</button>
            </form>
        </body>
        </html>
        
        `;
        const loginButton = document.getElementById('loginButton');
        loginButton.addEventListener('click', () => this.handleLoginButtonClick());
    }

    handleLoginButtonClick() {
       
        const username = document.querySelector('input[name="username"]').value;
        const password = document.querySelector('input[name="password"]').value;
        console.log('Usuário:', username);
        console.log('Senha:', password);
    }
}


class CadastroView {
    renderCadastroForm() {
        const formHtml = `
            <form id="cadastroForm">
                <div class="mb-3 row">
                    <label for="staticEmail" class="col-sm-2 col-form-label">Nome</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="nome" required>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="staticEmail" class="col-sm-2 col-form-label">Login</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="login" required>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="inputPassword" class="col-sm-2 col-form-label">Senha</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="senha" required placeholder="Utilize senhas fortes">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="email" required placeholder="joao@gmail.com">
                    </div>
                </div>
                <div class="container" id="botao_cadastrar">
                    <button type="submit" style="width: 50vw; text-align: center; align-items: center;" class="btn btn-primary">Cadastrar</button>
                </div>
            </form>
        `;

        document.getElementById('cadastroContainer').innerHTML = formHtml;
    }
}
class ContatoView {
    renderContatoForm() {
        const formHtml = `
            <div class="container-fluid">
                <h3>Contate-nos</h3>
                <hr>
                <form id="contatoForm">
                    <p>
                        <label for="nome">Nome:</label>
                        <input type="text" name="nome" id="nome">
                        <label for="sobrenome">SobreNome:</label>
                        <input type="text" name="sobrenome" id="sobrenome">
                    </p>
                    <p>
                        <label for="E-mail">E-mail:</label>
                        <input type="email" name="email" id="email"> 
                    </p>
                    <h6>Mande uma Mensagem</h6>
                    <textarea name="mensagem" id="mensagem" cols="40" rows="5" width="30px" ></textarea><br>
                    <button type="submit" class="btn btn-dark">Enviar</button>
                </form>
            </div>
        `;

        document.getElementById('contatoContainer').innerHTML = formHtml;
    }
}
