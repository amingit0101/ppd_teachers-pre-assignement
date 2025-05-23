<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page Navigation</title>
    <link rel="stylesheet" href="index.css">
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
                window.location.href = "creat.html";
            } else if (value === "option2") {
                window.location.href = "modify.html";
            } else if (value === "option3") {
                window.location.href = "remove.html";
            } else if (value === "option4") {
                window.location.href = "open.html";
            }
        }
    </script>
</head>
<body>

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
              <input type="radio" name="custom-radio" value="option3" />
              <span class="custom-radio-checkmark"></span>
              Remove Department Dean Account
            </label>
            <label class="custom-radio-container">
              <input type="radio" name="custom-radio" value="option4" />
              <span class="custom-radio-checkmark"></span>
              Manage Assignments
            </label>
          </div>
    </form>
    <button onclick="redirect()"> Get Selected Option
    </button>
</body>
</html>
