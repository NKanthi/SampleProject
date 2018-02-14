var myIndex = 0;
var imageSource = ["Images/honghe.jpg", "Images/beijing.jpg", "Images/leiden.jpg", "Images/denhaag.jpg"];
var imageName = ["Mengzi", "Beijing", "Leiden", "Den Haag"];
var slides = document.getElementsByClassName("mySlides");
var dots = document.getElementsByClassName("dot");


imageSliding(myIndex);
var timeId = window.setInterval(imageSliding, 2000);

function imageSliding() {

  if(myIndex >= imageSource.length) {
    myIndex = myIndex%imageSource.length;
  }
  if (myIndex < 0) {
    myIndex = slides.length-1;
  }

  for (var i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[myIndex].style.display = "block";
  dots[myIndex].className += " active";

  myIndex = myIndex + 1;
}

function nextSlides() {
  window.clearInterval(timeId);
  imageSliding(myIndex);
  timeId = window.setInterval(imageSliding, 2000, myIndex);
}

function prevSlides() {
  	myIndex = myIndex - 2;
    window.clearInterval(timeId);
    imageSliding(myIndex);
    timeId = window.setInterval(imageSliding, 2000, myIndex);
}

function dotClick(index) {
  myIndex = index;
  window.clearInterval(timeId);
  imageSliding(myIndex);
  timeId = window.setInterval(imageSliding, 2000, myIndex);
}

function imageFreeze() {
  window.clearInterval(timeId);
}

function imageContinue() {
  timeId = window.setInterval(imageSliding, 2000, myIndex);
}

function checkInfo() {
  try{
    var email = document.getElementById('inputEmail').value;
    console.log(email);
    var emailRegExpression = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (emailRegExpression.test(email)){

      var messageInfo = {"name": document.getElementById('inputName').value,
                        "email": document.getElementById('inputEmail').value,
                        "message": document.getElementById('inputMessage').value};

      var myJSON = JSON.stringify(messageInfo);
      localStorage.setItem("userMessage", myJSON);

    } else {
      alert("Invalid email address");
    }
  } catch (e) {
    alert(e.message);
  }
}

function showInfo() {
  var text = localStorage.getItem("userMessage");
  var obj = JSON.parse(text);
  if (obj != null) {
    alert(JSON.stringify(obj, null, 4));
  } else {
    alert("please submit a message.");
  }
}
