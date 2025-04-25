document.querySelectorAll('.delete-btn').forEach(btn => {
    btn.addEventListener('click', (e) => {
      e.target.closest('tr').remove();
    });
  });
  
  document.getElementById('add-product-btn').addEventListener('click', () => {
    alert('Abrir modal de cadastro de produto (funcionalidade futura)');
  });
  
  document.getElementById('product-form').addEventListener('submit', function(e) {
    e.preventDefault();
    alert('Produto salvo (simulação)');
  });
  