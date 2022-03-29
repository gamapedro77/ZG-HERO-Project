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
    const Email: string | null = (<HTMLInputElement>(
      document.getElementById("emailCandidato")
    )).value;
    const CPF: string | null = (<HTMLInputElement>(
      document.getElementById("cpf")
    )).value;
    const Senha: string | null = (<HTMLInputElement>(
      document.getElementById("senhaCandidato")
    )).value;

    // Salvando no local storage
    // Implementar conexão com o back-end aqui:
    const candidatos: Array<Object> = localStorage.getItem("candidatos")
      ? JSON.parse(localStorage.users)
      : [];

    localStorage.setItem(
      "candidatos",
      JSON.stringify([
        ...candidatos,
        { nome: Nome, Email: Email, CPF: CPF, Senha: Senha },
      ])
    );

    location.href = "localhost:3000/paginas/perfil/candidato.html";

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

    // Salvando no local storage
    // Implementar conexão com o back-end aqui:

    const empresas: Array<Object> = localStorage.getItem("empresas")
      ? JSON.parse(localStorage.users)
      : [];

    localStorage.setItem(
      "empresas",
      JSON.stringify([
        ...empresas,
        { nome: Nome, Email: Email, CNPJ: CNPJ, Senha: Senha },
      ])
    );

    location.href = "localhost:3000/paginas/perfil/empresa.html";

    return { nome: Nome, Email: Email, CNPJ: CNPJ, Senha: Senha };
  }
}

new Home();
