function openPopup(itemName, imageUrl) {
    document.getElementById('popup-text').innerText = `Você deseja solicitar ${itemName}?`;
    document.getElementById('popup-image').src = imageUrl;
    document.getElementById('popup').style.display = 'flex';
  }
  
  function confirmRequest() {
    alert("Solicitação confirmada!");
    document.getElementById('popup').style.display = 'none';
  }
  