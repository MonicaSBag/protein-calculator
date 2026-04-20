// =============================================
// script.js — Botanical Lab Calculator
// =============================================

/**
 * Calcula la proteína neta en base a:
 *  - Proteína por cada 100g del alimento
 *  - Cantidad de gramos consumidos
 * Fórmula: (proteína_por_100g × gramos_consumidos) / 100
 */
function calcularProteina() {
    const prot100g = parseFloat(document.getElementById('proteina100g').value);
    const gramos   = parseFloat(document.getElementById('gramosConsumidos').value);
    const display  = document.getElementById('resultado');

    if (!isNaN(prot100g) && !isNaN(gramos)) {
        const total = (prot100g * gramos) / 100;
        display.innerText = total.toFixed(1);

        // Micro-animación de feedback al calcular
        display.classList.remove('scale-100');
        display.classList.add('scale-110');
        setTimeout(() => display.classList.replace('scale-110', 'scale-100'), 150);
    } else {
        display.innerText = '-';
    }
}
// =============================================
// script.js — Autocompletar desde Spring Boot
// =============================================

const inputAlimento = document.getElementById("alimento");
const dropdown = document.getElementById("dropdownAlimentos");
const inputProteina = document.getElementById("proteina100g");

let timeout = null;

inputAlimento.addEventListener("input", () => {
    const query = inputAlimento.value.trim();

    clearTimeout(timeout);

    if (query.length < 2) {
        dropdown.classList.add("hidden");
        return;
    }

    timeout = setTimeout(() => buscarAlimentosBackend(query), 300);
});

function buscarAlimentosBackend(query) {
    fetch(`http://localhost:8080/alimentos?search=${query}`)
        .then(res => res.json())
        .then(data => mostrarOpciones(data))
        .catch(() => dropdown.classList.add("hidden"));
}

function mostrarOpciones(lista) {
    dropdown.innerHTML = "";

    if (!lista || lista.length === 0) {
        dropdown.classList.add("hidden");
        return;
    }

    lista.forEach(item => {
        const li = document.createElement("li");
        li.textContent = item.nombre;
        li.className = "px-4 py-2 hover:bg-primary/10 cursor-pointer";

        li.addEventListener("click", () => {
            inputAlimento.value = item.nombre;
            inputProteina.value = item.proteina100g;
            dropdown.classList.add("hidden");
        });

        dropdown.appendChild(li);
    });

    dropdown.classList.remove("hidden");
}
