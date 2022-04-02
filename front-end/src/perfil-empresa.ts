const Highcharts = require("highcharts");
require("highcharts/modules/exporting")(Highcharts);

class PerfilEmpresa {
  main: HTMLElement | null = null;

  constructor() {
    this.main = document.getElementById("main");
    this.renderPerfil();
    const perfil = document.getElementById("perfil");

    perfil?.addEventListener("click", () => {
      this.cleanMain();
      this.renderPerfil();
    });

    const grafico = document.getElementById("grafico");

    grafico?.addEventListener("click", () => {
      this.cleanMain();
      this.renderGrafico();
    });

    const listaUsuarios = document.getElementById("lista-usuarios");
    listaUsuarios?.addEventListener("click", () => {
      this.cleanMain();
      this.renderCandidatos();
    });
  }

  renderPerfil() {}

  renderGrafico() {
    const container = document.createElement("div");
    container.id = "container-chart";
    this.main?.appendChild(container);

    Highcharts.chart("container-chart", {
      chart: {
        type: "column",
      },
      tooltip: {
        borderColor: "black",
      },
      title: {
        text: "Candidatos p/ Habilidade",
      },
      xAxis: {
        categories: [
          "JavaScript",
          "Python",
          "Java",
          "ReactJs",
          "AWS",
          "CSS",
          "HTML5",
        ],
        crosshair: true,
      },
      yAxis: {
        min: 0,
        title: {
          text: "Candidatos",
        },
      },
      plotOptions: {
        column: {
          pointPadding: 0.2,
          borderWidth: 0,
        },
      },
      series: [
        {
          name: "candidatos",
          data: [10, 8, 4, 2, 1, 1, 1],
        },
      ],
    });
  }

  cleanMain() {
    let child = this.main?.firstChild;
    if (child) {
      this.main?.removeChild(child);
    }
  }

  renderCandidatos() {
    const uList = document.createElement("ul");
    uList.classList.add("lista-usuarios");

    interface candidatoObject {
      nome: string;
      skills: Array<string>;
    }
    const sampleCandidatos: Array<candidatoObject> = [
      {
        nome: "sample name",
        skills: ["JavaScript", "React", "HTML", "CSS", "Java", "NodeJs"],
      },
      {
        nome: "sample name",
        skills: ["JavaScript", "React", "Java", "NodeJs"],
      },
      {
        nome: "sample name",
        skills: ["JavaScript", "React", "HTML", "CSS"],
      },
      {
        nome: "sample name",
        skills: ["JavaScript", "HTML", "CSS", "Java", "NodeJs"],
      },
    ];

    sampleCandidatos.forEach((element) => {
      const listItem = document.createElement("li");
      listItem.classList.add("usuario");
      listItem.innerHTML = "<h3>Nome Confidencial</h3>";
      const skillsList = document.createElement("ul");
      skillsList.classList.add("lista-skills");
      element.skills?.forEach((skill) => {
        const listItemSkill = document.createElement("li");
        listItemSkill.classList.add("skill-item");
        listItemSkill.innerHTML = skill;
        skillsList.appendChild(listItemSkill);
      });

      listItem.appendChild(skillsList);
      uList.appendChild(listItem);
    });

    this.main?.appendChild(uList);
  }
}

const perfilEmpresa = new PerfilEmpresa();
