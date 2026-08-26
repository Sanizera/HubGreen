const GLOBAL_URL = "https://6a63aec1b30b52361e1a9073.mockapi.io/events";

document.addEventListener("DOMContentLoaded", () => {
  loadEvents();
});

async function loadEvents() {
  try {
    const response = await fetch(GLOBAL_URL);
    const data = await response.json();

    populateTable(data);
  } catch (err) {
    console.log(err);
    alert("Impossível carregar Eventos.");
  }
}

function populateTable(data) {
  const tbody = qs("tbody");

  let html = "";
  for (event of data) {
    const dateTime = getDateTime(event.date);

    html += `
    <tr class="position-relative">
        <td>
            <a href="/event?id=${event.id}" class="stretched-link text-decoration-none text-dark">
                ${event.name}
            </a>
        </td>
        <td>${event.local}</td>
        <td>${dateTime[0]}</td>
        <td>${dateTime[1]}</td>
        <td>Opções</td>
    </tr>
    `;
  }

  tbody.innerHTML = html;
}

function getDateTime(timeStamp) {
  const [date, time] = timeStamp.split("T");

  const [year, month, day] = date.split("-");

  const timeResult = time.substring(0, 5);
  return [`${day}/${month}/${year}`, timeResult];
}

document.addEventListener("DOMContentLoaded", () => {
  flatpickr("#dataEvento", {
    enableTime: true,
    time_24hr: true,
    locale: "pt",
    disableMobile: true,
    altInput: true,
    altFormat: "d/m/Y H:i",
    dateFormat: "Y-m-d H:i",

    minDate: "today",

    plugins: [
      new confirmDatePlugin({
        confirmText: "OK",
      }),
    ],
  });
});
