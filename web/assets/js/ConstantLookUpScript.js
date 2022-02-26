
let sIcons = document.querySelectorAll('.sIcon');
let clear = document.querySelectorAll('.clear');
console.log(sIcons)
for(let i=0; i<sIcons.length; i++){
    sIcons[i].addEventListener("click",(e)=>{
        let search = e.target.parentElement;
        search.classList.toggle('active');
    })
}
for(let i=0; i<clear.length; i++){
    clear[i].addEventListener("click", (e)=>{
        let input = e.target.parentElement.querySelector('.mysearch');
        input.value='';
    })
}

//Validate data
let form = document.getElementById("form1");
let sName = document.getElementById('searchName');
let sSign = document.getElementById('searchSign');
let error = form.querySelector('.error');
form.addEventListener('submit', (e)=>{
   
    if(sName.value.trim()=='' && sSign.value.trim()==''){
        e.preventDefault();
        error.innerText='Can not null for both of Name and Sign';   
        error.classList.add('active');
    }
    if(sName.value.trim().length>40 || sSign.value.trim().length > 10){
        e.preventDefault();
        error.innerText='Name cant more than 40, Sign cant more than 10';   
        error.classList.add('active');
    }
})
