let signup_form = document.getElementById('signup-form');

let signupsec = document.getElementById('signup-section');
let alumnisec = document.getElementById('alumni-section');
window.onload = hidealumnisec;
signup_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (signup_form.checkValidity() === true) {
        let response = await fetch('api/alumni/getinfo', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                fname: document.getElementById('fname').value,
                lname: document.getElementById('lname').value,
                year: document.getElementById('gradyear').value,
            })
        });
        let result = await response.json();
        // console.log("helloworld");
        // console.log(result[0].fname);
        signupsec.style.display="none";
        alumnisec.style.display="block";

        // insert rows
        let table = document.getElementById("alumni-table");
        result.forEach(function (student){
            let row = table.insertRow(1);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            let cell4 = row.insertCell(3);
            let cell5 = row.insertCell(4);
            cell1.innerHTML = '<input name="select" type="radio">';
            cell2.innerHTML = student.roll;
            cell3.innerHTML = student.fname;
            cell4.innerHTML = student.lname;
            cell5.innerHTML = student.email;
        });

    }
    signup_form.classList.add('was-validated');
});

async  function  hidealumnisec(){
    alumnisec.style.display="none";
}