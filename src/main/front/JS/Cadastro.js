const form = document.getElementById('form');
const popup = document.getElementById('popup');

form.addEventListener('submit', function(event) {
    event.preventDefault();
    popup.classList.add('active');
});

function fazerLogin() {
    window.location.href = "../pags/cadastro.html"; // Aqui você pode redirecionar para a página de login
}
