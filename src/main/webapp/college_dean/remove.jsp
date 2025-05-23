<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Department Dean Account</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/remove.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Cinzel&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</head>
<body>
    <h2 class="cinzel">Delete Department Dean Account</h2>

<section class="section_form">
    <form id="consultation-form" class="feed-form" action="#">
      <input name="email" required="" placeholder="Email Address of Account to Remove" type="email">
       <div class="radio-inputs">
        <label class="radio">
        <input type="radio" name="radio" checked="" value="ENGINEER">
        <span class="name">ENGINEER</span>
        </label>
        <label class="radio">
        <input type="radio" name="radio" value="GL">
        <span class="name">GL</span>
        </label>
            
        <label class="radio">
        <input type="radio" name="radio" value="TL">
        <span class="name">TL</span>
        </label>
        <label class="radio">
        <input type="radio" name="radio" value="STI">
        <span class="name">STI</span>
        </label>
    </div>
      <button onclick="delet()"> Delete</button>
    </form>
  </section>
    
</body>
<script>
    function delet() {
    const email = document.querySelector('input[name="email"]').value;
    const dep = document.querySelector('input[name="radio"]:checked').value;
    console.log("Email:", email);
    console.log("departemnt :",dep) ; 
}

</script>
</html>