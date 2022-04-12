class LoginEmpresa {
  email;
  senha;
  button;
  constructor() {
    this.email = document.getElementById("email");
    this.senha = document.getElementById("senha");
    this.button = document.getElementById("submit");

    this.button?.addEventListener("click", this.logar);
  }

  logar(event: Event) {
    console.log("ola");
    event.preventDefault();
    location.href = "http://localhost:3000/paginas/perfil/empresa.html";
  }
}

new LoginEmpresa();
