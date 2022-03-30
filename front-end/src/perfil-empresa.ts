const Highcharts = require("highcharts");
require("highcharts/modules/exporting")(Highcharts);
class PerfilEmpresa {
  main: HTMLElement | null = null;

  constructor() {
    this.main = document.getElementById("main");
    this.renderGrafico();
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

  renderCandidatos() {}
}

const perfilEmpresa = new PerfilEmpresa();
