let li = document.querySelectorAll(".faq-text li");
console.log(li);
for (let i = 0; i < li.length; i++) {
    li[i].addEventListener("click", (e)=>{
        let clickedLi;
        if(e.target.classList.contains("question-arrow")){
            clickedLi = e.target.parentElement;
        }else{
            clickedLi = e.target.parentElement.parentElement;
        }
        clickedLi.classList.toggle("showAnswer");
    })
    
}