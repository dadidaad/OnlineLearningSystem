let form = document.getElementById("form");
form.addEventListener('submit', (e)=>{
    let name = document.getElementById('subName');
    let des = document.getElementById('description');
    
    if(name.value.trim()==""){
        e.preventDefault();
        let error = form.querySelector('.error');
        error.innerText ="Name can not be Empty";
        error.classList.add('active');
    }
    if(des.value.trim().length > 500){
        e.preventDefault();
        let error = form.querySelector('.error');
        error.innerText = "Description cant more than 500";
        error.classList.add('active');
    }
    
})


