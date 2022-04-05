class PerfilCandidato {
  main: HTMLElement | null = null;

  constructor() {
    this.main = document.getElementById("main");

    const listaEmpresas = document.getElementById("lista-usuarios");
    listaEmpresas?.addEventListener("click", () => {
      this.cleanMain();
      this.renderEmpresas();
    });
  }

  cleanMain() {
    let child = this.main?.firstChild;
    if (child) {
      this.main?.removeChild(child);
    }
  }

  renderEmpresas() {
    const uList = document.createElement("ul");
    uList.classList.add("lista-usuarios");

    interface empresaObject extends Object {
      nome: string;
      vaga: string;
      descricao: string;
    }
    const sampleEmpresas: Array<empresaObject> = [
      {
        nome: "sample name",
        vaga: "Desenvolvedor front end jr",
        descricao: "sample descricao",
      },
      {
        nome: "sample name",
        vaga: "Desenvolvedor front end jr",
        descricao: "sample descricao",
      },
      {
        nome: "sample name",
        vaga: "Desenvolvedor front end jr",
        descricao: "sample descricao",
      },
      {
        nome: "sample name",
        vaga: "Desenvolvedor front end jr",
        descricao: "sample descricao",
      },
    ];

    sampleEmpresas.forEach((element) => {
      const listItem = document.createElement("li");
      listItem.classList.add("usuario");
      listItem.innerHTML = "<h3>Nome Confidencial</h3>";
      const tituloVaga = document.createElement("p");
      tituloVaga.classList.add("lista-skills");
      tituloVaga.append(element.vaga);
      listItem.appendChild(tituloVaga);
      uList.appendChild(listItem);
    });

    this.main?.appendChild(uList);
  }
}

new PerfilCandidato();
