window.onload=fetch_companies;
let company_names;
let oinfo_form = document.getElementById('oinfo-form');


oinfo_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (oinfo_form.checkValidity() === true) {
        let organisation_list=[];
        let array = $("#oinfo-form").serializeArray();

        for(let i=0;i<array.length;){
            let organisation={};
            organisation['organisation']={name:array[i++].value,};
            organisation['alumni']={id:1,};
            organisation['position']=array[i++].value;
            organisation['joining_year']=array[i++].value;
            organisation['leaving_year']=array[i++].value;

            organisation_list.push(organisation);
        }

        let response = await fetch('api/oinfo/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(organisation_list),
        });
        let result = await response;
        console.log(result);
        // console.log("helloworld");
        // console.log(result[0].fname);
        oinfo_form.classList.add('was-validated');

        alert("Succesfull");
        // window.href.location="orginfo.html";

    }

    //console.log($("#oinfo-form").serializeObject());


});

function add_more(btn) {
    const div = document.createElement('div');
    div.className = "form-row element";
    div.innerHTML = $(btn).closest("div.element")[0].innerHTML;

    document.getElementById("oinfo-element").appendChild(div);
    //console.log($(btn)[0]);
    $(btn)[0].value="-";
    $(btn)[0].setAttribute("onclick","remove_div(this)");
    $(btn).removeClass("btn-success");
    $(btn).addClass("btn-danger");
    // return false;
}

function remove_div(btn){
    $(btn).closest("div.element").remove();
}

async function fetch_companies(){
    let response = await fetch("api/oinfo/get");
    company_names= await response.json();
    //console.log(company_names);
    for(let i=0;i<company_names.length;i++)document.getElementById("company-names").innerHTML=document.getElementById("company-names").innerHTML+""+"\n <option>"+company_names[i].name+"</option>";

}



