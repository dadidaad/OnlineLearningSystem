let form = document.getElementById("form");
form.addEventListener('submit', (e)=>{
    let des = document.getElementById('description');
    if(des.value.trim().length > 500 || des.value===""){
        e.preventDefault();
        let error = document.querySelector('.error');
        error.innerText = "Description cant more than 500";
        error.classList.add('active');
    }
    
})