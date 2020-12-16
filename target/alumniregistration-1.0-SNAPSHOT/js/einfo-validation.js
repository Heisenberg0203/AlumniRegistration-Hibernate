let einfo_form = document.getElementById('einfo-form');


einfo_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (einfo_form.checkValidity() === true) {
        let alumni_list=[];
        let array = $("#einfo-form").serializeArray();

        for(let i=0;i<array.length;){
            let alumni={};
            alumni['college_name']=array[i++].value;
            alumni['address']=array[i++].value;
            alumni['degree']=array[i++].value;
            alumni['joining_year']=array[i++].value;
            alumni['passing_year']=array[i++].value;
            alumni['alumni']={id:1};

            alumni_list.push(alumni);
        }

        let response = await fetch('api/einfo/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(alumni_list),
        });
        let result = await response;
        console.log(result);
        // console.log("helloworld");
        // console.log(result[0].fname);
        einfo_form.classList.add('was-validated');

        window.href.location="orginfo.html";

    }

    //console.log($("#einfo-form").serializeObject());


});

function add_more(btn) {
    const div = document.createElement('div');
    div.className = "form-row element";
    div.innerHTML = `
        
                <div class="form-group col-md-3">
                <input type="text" class="form-input" name="ae[][college_name]"  placeholder="College Name"/>
                </div>
            <div class="form-group col-md-3">
                <input type="text" class="form-input" name="ae[][address]" placeholder="Address"/>
            </div>
            <div class="form-group col-md-2">
                <input type="text" class="form-input" name="ae[][degree]" placeholder="Degree"/>
            </div>
            <div class="form-row form-group col-md-4">
                <div class=" col-md-5">
                    <input type="text" class="form-input" name="ae[][joining_year]" placeholder="Joining Year"/>
                </div>
                <div class=" col-md-5">
                    <input type="text" class="form-input" name="ae[][passing_year]" placeholder="Passing Year"/>
                </div>
                <div class="col-md-2">
                    <input type="button" name="ae[][add-button]"  class="form-btn btn btn-success" onclick="add_more(this)" value="+"/>
                </div>
            </div>
        `;

    document.getElementById("einfo-element").appendChild(div);
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
function skip_edetails(){
    window.location.href="orginfo.html";
}

