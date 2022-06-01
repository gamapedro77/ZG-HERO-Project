const axios: any = require('axios')

class Home {
  btnCpf: HTMLElement | null = null;
  btnCnpj: HTMLElement | null = null;

  constructor() {
    this.btnCpf = document.getElementById("btn-submit-cpf");
    this.btnCnpj = document.getElementById("btn-submit-cnpj");

    this.btnCpf?.addEventListener("click", (e: Event) =>
      console.log(this.createCpfUser())
    );

    this.btnCnpj?.addEventListener("click", (e: Event) =>
      console.log(this.createCnpjUser())
    );
  }

  createCpfUser(): Object {
    const Nome: string | null = (<HTMLInputElement>(
      document.getElementById("nomeCandidato")
    )).value;
    const Sobrenome: string | null = (<HTMLInputElement> (
      document.getElementById("sobrenomeCandidato")
    )).value;
    const Email: string | null = (<HTMLInputElement>(
      document.getElementById("emailCandidato")
    )).value;
    const CPF: string | null = (<HTMLInputElement>(
      document.getElementById("cpf")
    )).value;
    const Senha: string | null = (<HTMLInputElement>(
      document.getElementById("senhaCandidato")
    )).value;

    const regexNome: RegExp = /[a-zA-Z]{1,36}/g;

    if (!Nome.match(regexNome)) {
      alert("Nome invalido, Nome deve conter apenas letras");
      return {};
    }


    const regexEmail: RegExp = /[\w._%+-]+@[\w.-]+\.[a-zA-Z]{1,4}/g;
    if (!Email.match(regexEmail)) {
      alert("Email invalido!");
      return {};
    }

    const regexCpf: RegExp = /[1-9]{3}\.[1-9]{3}\.[1-9]{3}-[0-9]{2}/;
    if (!CPF.match(regexCpf)) {
      alert("CPF Invalido! Cpf deve seguir o formato: 000.000.000-00");
      return {};
    }

    const regexSenha: RegExp = /(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}/;
    if (!Senha.match(regexSenha)) {
      alert(
        "Senha invalida! Senha deve conter letras maiusculas e minusculas e no minimo um numero"
      );
      return {};
    }
    // Salvando no local storage
    // Implementar conexão com o back-end aqui:
    const candidatos: Array<Object> = localStorage.getItem("candidatos")
      ? JSON.parse(localStorage.candidatos)
      : [];

    localStorage.setItem(
      "candidatos",
      JSON.stringify([
        ...candidatos,
        { nome: Nome, Email: Email, CPF: CPF, Senha: Senha },
      ])
    );

     console.log(this.postUser({nome: Nome, sobrenome: Sobrenome, email: Email, CPF: CPF, senha: Senha }))

    // location.href = "localhost:3000/paginas/perfil/candidato.html";

    return { nome: Nome, Email: Email, CPF: CPF, Senha: Senha };
  }

  createCnpjUser(): Object {
    const Nome: string | null = (<HTMLInputElement>(
      document.getElementById("nomeEmpresa")
    )).value;
    const Email: string | null = (<HTMLInputElement>(
      document.getElementById("emailEmpresa")
    )).value;
    const CNPJ: string | null = (<HTMLInputElement>(
      document.getElementById("cnpj")
    )).value;
    const Senha: string | null = (<HTMLInputElement>(
      document.getElementById("senhaEmpresa")
    )).value;

    const regexNome: RegExp = /[a-zA-Z]{1,36}/g;
    if (!Nome.match(regexNome)) {
      alert("Nome invalido, Nome deve conter apenas letras");
      return {};
    }

    const regexEmail: RegExp = /[\w._%+-]+@[\w.-]+\.[a-zA-Z]{1,4}/g;
    if (!Email.match(regexEmail)) {
      alert("Email invalido!");
      return {};
    }

    const regexCnpj: RegExp = /[1-9]{2}\.[1-9]{3}\.[1-9]{3}\/0001-[0-9]{2}/;
    if (!CNPJ.match(regexCnpj)) {
      alert("CNPJ Invalido! Cnpj deve seguir o formato: 00.000.000/0001-00");
      return {};
    }

    const regexSenha: RegExp = /(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}/;
    if (!Senha.match(regexSenha)) {
      alert(
        "Senha invalida! Senha deve conter letras maiusculas e minusculas e no minimo um numero"
      );
      return {};
    }
    // Salvando no local storage
    // Implementar conexão com o back-end aqui:

    const empresas: Array<Object> = localStorage.getItem("empresas")
      ? JSON.parse(localStorage.empresas)
      : [];

    localStorage.setItem(
      "empresas",
      JSON.stringify([
        ...empresas,
        { nome: Nome, Email: Email, CNPJ: CNPJ, Senha: Senha },
      ])
    );

    // location.href = "localhost:3000/paginas/perfil/empresa.html";

    return { nome: Nome, Email: Email, CNPJ: CNPJ, Senha: Senha };
  }

  postUser(user: Object) {

      axios.post('https://localhost:9999/candidatos', {...user}).then( (res: any) => console.log(res))

  }
}

new Home();
