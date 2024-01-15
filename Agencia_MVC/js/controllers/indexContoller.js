class IndexController {
    constructor(model, view) {
        this.model = model;
        this.view = view;
    }
    init() {
        this.adicionarBotoesWhatsApp();
    }
    adicionarBotoesWhatsApp() {
        const linkWhatsApp = this.model.getLinkWhatsApp();
        this.view.renderWhatsAppButton(linkWhatsApp);
    }
}
class LoginController {
    constructor(model, view) {
        this.model = model;
        this.view = view;
    }

    init() {
        this.view.renderLoginForm();
       
    }

    
}
class CadastroController {
    constructor(model, view) {
        this.model = model;
        this.view = view;
    }

    init() {
        this.view.renderCadastroForm();
        this.setupFormSubmit();
    }

    setupFormSubmit() {
        const formElement = document.getElementById('cadastroForm');
        formElement.addEventListener('submit', (event) => {
            event.preventDefault();
            const nome = document.getElementById('nome').value;
            const login = document.getElementById('login').value;
            const senha = document.getElementById('senha').value;
            const email = document.getElementById('email').value;

        });
    }
}
class ContatoController {
    constructor(model, view) {
        this.model = model;
        this.view = view;
    }

    init() {
        this.view.renderContatoForm();
        this.setupFormSubmit();
    }

    setupFormSubmit() {
        const formElement = document.getElementById('contatoForm');
        formElement.addEventListener('submit', (event) => {
            event.preventDefault();
            const nome = document.getElementById('nome').value;
            const sobrenome = document.getElementById('sobrenome').value;
            const email = document.getElementById('email').value;
            const mensagem = document.getElementById('mensagem').value;

           
        });
    }
}


