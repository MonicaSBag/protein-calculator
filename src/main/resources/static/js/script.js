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