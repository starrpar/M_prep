   fetch('http://localhost:8080/hello')
       .then(response => response.text())
       .then(data => console.log(data))
       .catch(error => console.error(error));