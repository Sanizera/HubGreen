const GLOBAL_URL = "https://6a63aec1b30b52361e1a9073.mockapi.io/events";

document.addEventListener("DOMContentLoaded", async () => {
  // DADOS DO EVENTO

  const params = new URLSearchParams(window.location.search);
  const id = params.get("id");

  if (id) {
    try {
      const resposta = await fetch(`${GLOBAL_URL}/${id}`);

      if (!resposta.ok) {
        throw new Error(`Erro na requisição: ${resposta.status}`);
      }

      const evento = await resposta.json();

      console.log("Dados do evento:", evento);

      const tituloEvent = document.getElementById("titulo-evento");

      if (tituloEvent) {
        tituloEvent.textContent = evento.name;
      }

      const [dataFormatada, horaFormatada] = getDateTime(evento.date);

      const tbody = document.getElementById("tabela-event");

      if (tbody) {
        tbody.innerHTML = `
          <tr>
            <td>${evento.name}</td>
            <td>${dataFormatada}</td>
            <td>${horaFormatada}</td>
            <td>${evento.local}</td>
          </tr>
        `;
      }
    } catch (erro) {
      console.error("Erro ao carregar o evento:", erro);
    }
  }

  // MODAL DAS FOTOS

  const fotos = document.querySelectorAll(".foto-modal");
  const imagemModal = document.querySelector("#imagemModal");
  const modalElement = document.querySelector("#modalFoto");

  fotos.forEach((foto) => {
    foto.addEventListener("click", () => {
      // Coloca a imagem clicada no modal
      imagemModal.src = foto.src;

      // Cria/recupera o modal do Bootstrap
      const modal = bootstrap.Modal.getOrCreateInstance(modalElement);

      // Abre o modal
      modal.show();
    });
  });
});

function getDateTime(timeStamp) {
  if (!timeStamp) {
    return ["--/--/----", "--:--"];
  }

  const [date, time] = timeStamp.split("T");

  const [year, month, day] = date.split("-");

  const timeResult = time ? time.substring(0, 5) : "--:--";

  return [`${day}/${month}/${year}`, timeResult];
}
