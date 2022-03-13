let deletebutton = document.getElementById("delete");
let cancelbutton = document.getElementById("cancel");

cancelbutton.addEventListener('click', (e)=>{
    let confirmation = document.getElementById("confirmation");
    confirmation.classList.remove("modal-open");
})

function confirmnek(x,y){
    let confirmation = document.getElementById("confirmation");
    console.log(confirmation);
    let accept = document.getElementById("acceptDelete");
    if(!confirmation.classList.contains("modal-open")){
        confirmation.classList.add("modal-open");
    }
    accept.href='KnowledgeDeleteController?knowledgeId='+x+'&chapId='+y;
}