const GLOBAL_URL = "http://localhost:8080/api/v1";

document.addEventListener("DOMContentLoaded", () => {
  loadEvents();
});

async function loadEvents() {
  try {
    const response = await fetch(`${GLOBAL_URL}/eventos`);
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
    const dateTime = getDateTime(event.dthrEvento);

    html += `
    <tr class="position-relative">
        <td>
            <a href="/event?id=${event.cdEvento}" class="stretched-link text-decoration-none text-dark">
                ${event.nmEvento}
            </a>
        </td>
        <td>${event.localEvento}</td>
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
    const eventPayload = buildEventPayload(formData);
    saveEvent(eventPayload);
  })

  flatpickr("#dthrEvento", {
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

async function saveEvent(eventPayload){
  console.log(eventPayload);
  try{

    const response = await fetch(`${GLOBAL_URL}/eventos`,{
      method: "POST",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify(eventPayload)  
    });
    const data = await response.json();
     
    console.log(data);
    if (data.cdEvento) { 
      window.location.href = `${window.location.origin}/event?id=${await data.cdEvento}`
    } else {
      alert("Erro");
    }
    
  }catch (error){
    alert("impossível criar evento.");
    console.log(error);
  }

}  


async function loadStates(){
  const response = await fetch(`${GLOBAL_URL}/estados`);
  const data = await response.json();

  populateStateOptions(data);
}

async function loadCities(sguf) { 
  if (sguf == "null") {
    populateCitiesOptions(sguf);
    return;
  }
  const response = await fetch(`${GLOBAL_URL}/cidades/estado/${sguf}`);
  const data = await response.json();
  
  populateCitiesOptions(data);
}

function populateStateOptions(data) {
  
  const select = document.querySelector("#sguf");
  let html = "<option value='null'>Selecionar Estado</option>";

  data.forEach(estado => {
    html += `<option value=${estado.sguf}>${estado.nmuf}</option>`
  });
  
  select.innerHTML = html;
}

function populateCitiesOptions(data){
  const select = document.querySelector("#cdCidade");
  
  
  if (data == "null") {
    select.innerHTML = html;
    return;
  }
  
  data.forEach(cidade => {
    html += `<option value=${cidade.cdCidade}>${cidade.nmCidade}</option>`
  });

  select.innerHTML = html;
}

function buildEventPayload(formData) {
  const raw = Object.fromEntries(formData.entries())

  return {
    nmEvento: raw.nmEvento,
    localEvento: raw.localEvento,
    dsEvento: raw.dsEvento,
    cidade: { cdCidade: parseInt(raw.cdCidade) },
    dthrEvento: formatDatetime(raw.dthrEvento)
  };
}

function formatDatetime(value) {
  let corrected = value.replace(' ', 'T');
  if (corrected.length === 16) {
    corrected += ':00';
  }
  return corrected;
}