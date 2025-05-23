<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page Navigation</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Cinzel&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
    <script>
        function redirect() {
            const selected = document.querySelector('input[name="custom-radio"]:checked');
            if (!selected) return;

            const value = selected.value;

            if (value === "option1") {
                window.location.href = "fac_dean/create";
            } else if (value === "option2") {
                window.location.href = "fac_dean/modify";
            }  else if (value === "option4") {
                window.location.href = "fac_dean/open";
            }
        }
        function goToLink(url) {
            window.location.href = url;
        }
    </script>
</head>
<body>
    <button class="buttonn home-button" onclick="goToLink('/')">
        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
            <path stroke-linecap="round" stroke-linejoin="round" d="M4.5 12h15m0 0l-6.75-6.75M19.5 12l-6.75 6.75"></path>
        </svg>

        
        <div class="text">
            HOME
        </div>

        </button>
    <h2 class="cinzel">Select an Action</h2>

    <form>
        <div class="custom-radio-group">
            <label class="custom-radio-container">
              <input type="radio" name="custom-radio" value="option1" />
              <span class="custom-radio-checkmark"></span>
              Create Department Dean Account
            </label>
            <label class="custom-radio-container">
              <input type="radio" name="custom-radio" value="option2" />
              <span class="custom-radio-checkmark"></span>
              Modify Department Dean Account
            </label>
            <label class="custom-radio-container">
              <input type="radio" name="custom-radio" value="option4" />
              <span class="custom-radio-checkmark"></span>
              Manage Assignments
            </label>
          </div>
    </form>
    <button onclick="redirect()" class="select-btn"> Get Selected Option
    </button>
</body>
</html>
