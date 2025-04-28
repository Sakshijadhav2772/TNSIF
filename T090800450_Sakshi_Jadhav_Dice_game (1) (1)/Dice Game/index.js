function rollDice() {
 
  document.querySelector("h1").classList.remove("fade-in");
  document.querySelectorAll("img").forEach(img => img.classList.remove("winner-dice"));

  var randomNumber1 = Math.floor(Math.random() * 6) + 1;
  var randomNumber2 = Math.floor(Math.random() * 6) + 1;
  var randomNumber3 = Math.floor(Math.random() * 6) + 1;

  var randomImageSource1 = "images/dice" + randomNumber1 + ".png";
  var randomImageSource2 = "images/dice" + randomNumber2 + ".png";
  var randomImageSource3 = "images/dice" + randomNumber3 + ".png";

  document.querySelectorAll("img")[0].setAttribute("src", randomImageSource1);
  document.querySelectorAll("img")[1].setAttribute("src", randomImageSource2);
  document.querySelectorAll("img")[2].setAttribute("src", randomImageSource3);

  let resultText = document.querySelector("h1");
  resultText.classList.add("fade-in"); 

 
  if (randomNumber1 > randomNumber2 && randomNumber1 > randomNumber3) {
    resultText.innerHTML = "Player 1 Wins!";
    document.querySelectorAll("img")[0].classList.add("winner-dice");
  } else if (randomNumber2 > randomNumber1 && randomNumber2 > randomNumber3) {
    resultText.innerHTML = "Player 2 Wins!";
    document.querySelectorAll("img")[1].classList.add("winner-dice");
  } else if (randomNumber3 > randomNumber1 && randomNumber3 > randomNumber2) {
    resultText.innerHTML = "Player 3 Wins!";
    document.querySelectorAll("img")[2].classList.add("winner-dice");
  } else {
    resultText.innerHTML = "It's a Draw!";
  }
}
