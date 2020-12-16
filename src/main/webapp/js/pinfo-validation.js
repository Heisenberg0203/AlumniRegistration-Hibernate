let pinfo_form = document.getElementById('pinfo-form');


pinfo_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (pinfo_form.checkValidity() === true) {
        let response = await fetch('api/pinfo/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                email: document.getElementById('email').value,
                contact: document.getElementById('contact').value,
                student:{id:1,fname:'rushikesh'},
            })
        });
        let result = await response
        console.log(result);
        // console.log("helloworld");
        // console.log(result[0].fname);

        pinfo_form.classList.add('was-validated');
        window.location.href="educationinfo.html";
    }


});

