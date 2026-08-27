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
  const saveBtn = document.querySelector("#save-btn");

  saveBtn.addEventListener('click', (e)=>{
    const form = e.target.closest("form");
    const formData = new FormData(form);
    const event = Object.fromEntries(formData.entries());

    saveEvent(event);
  })

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

async function saveEvent(event){

  try{

    const response = await fetch(GLOBAL_URL,{
      method: "POST",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify(event)  
    });
    const data = await response.json();
     
    window.location.href = `${window.location.origin}/event?id=${data.id}`
    return data;
    
  }catch (error){
    alert("impossível criar evento.");
    console.log(error);
  }

}   