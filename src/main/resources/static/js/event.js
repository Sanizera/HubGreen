const GLOBAL_URL = "https://6a63aec1b30b52361e1a9073.mockapi.io/events";

document.addEventListener("DOMContentLoaded", async () => {
  // A) Pega o ID da URL (?id=...)
  const params = new URLSearchParams(window.location.search);
  const id = params.get("id");

  if (!id) {
    console.error("Nenhum ID encontrado na URL");
    return;
  }

  try {
    // B) Faz o GET no endpoint
    const resposta = await fetch(`${GLOBAL_URL}/${id}`);

    if (!resposta.ok) {
      throw new Error(`Erro na requisição: ${resposta.status}`);
    }

    const evento = await resposta.json();
    console.log("Dados do evento:", evento);

    // 1. Atualiza o título <h2> com o nome do evento
    const tituloEvent = document.getElementById("titulo-evento");
    if (tituloEvent) {
      tituloEvent.textContent = evento.name;
    }

    // C) Formata a data e a hora usando a sua função
    // (Assume que evento.date vem no formato ISO "AAAA-MM-DDT... ")
    const [dataFormatada, horaFormatada] = getDateTime(evento.date);

    // D) Monta a linha da tabela
    const tbody = document.getElementById("tabela-event");

    tbody.innerHTML = `
      <tr>
        <td>${evento.name}</td>
        <td>${dataFormatada}</td>
        <td>${horaFormatada}</td>
        <td>${evento.local}</td>
      </tr>
    `;
  } catch (erro) {
    console.error("Erro ao carregar o evento:", erro);
  }
});

function getDateTime(timeStamp) {
  if (!timeStamp) return ["--/--/----", "--:--"];

  const [date, time] = timeStamp.split("T");
  const [year, month, day] = date.split("-");
  const timeResult = time ? time.substring(0, 5) : "--:--";

  return [`${day}/${month}/${year}`, timeResult];
}
