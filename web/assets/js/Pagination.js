const list_element = document.getElementById('list');
const pagination_element = document.getElementById('pagination');

const ulTag = document.querySelector(".pagination-ex ul");
let totalPages = 10;
let current_page = 1;
let rows = 5;

function DisplayList (items, wrapper, rows_per_page, page) {
	wrapper.innerHTML = "";
	page--;

	let start = rows_per_page * page;
	let end = start + rows_per_page;
	let paginatedItems = items.slice(start, end);

	for (let i = 0; i < paginatedItems.length; i++) {
		let item = paginatedItems[i];

		let item_element = document.createElement('div');
		item_element.classList.add('item');
		item_element.innerText = item;
		
		wrapper.appendChild(item_element);
	}
}

function SetupPagination (items, wrapper, rows_per_page) {
	wrapper.innerHTML = "";

	totalPages = Math.ceil(items.length / rows_per_page);
}

function PaginationButton (page) {
    DisplayList(list_items, list_element, rows, page);
}

function element(totalPages, page) {
    let liTag = '';
    let activeLi;
    let beforePages = page - 1;
    let afterPages = page + 1;
    if(page > 1){
        liTag += `<li><a id="btn" href="#" onclick="element(totalPages, ${page - 1}), PaginationButton(${page - 1})" class="py-2 px-3 ml-0 leading-tight text-gray-500 bg-white rounded-l-lg border border-gray-300 hover:bg-gray-100 hover:text-gray-700">Previous</a></li>`;
    }
    
    if(page > 2){
        liTag += `<li><a href="#" onclick="element(totalPages, 1), PaginationButton(1)" class="py-2 px-3 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 ">1</a></li>`;
        if(page > 3){
            liTag += `<li><a href="#" class="py-2 px-3 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 ">...</a></li>`;
        }
    }
    
    if(page == totalPages){
        beforePages = beforePages - 2;
    }else if(page == totalPages - 1){
        beforePages = beforePages - 1;
    }
    
    if(page == 1){
        afterPages = afterPages + 2;
    }else if(page == 2){
        afterPages = afterPages + 1;
    }
    
    for(let pageLength = beforePages; pageLength <= afterPages; pageLength++) {
        if(pageLength > totalPages) {
            continue;
        }
        if(pageLength == 0){
            pageLength = pageLength + 1;
        }
        if(page == pageLength){
            activeLi = "py-2 px-3 text-blue-600 bg-blue-50 border border-gray-300 hover:bg-blue-100 hover:text-blue-700";
        }
        else{
            activeLi = "py-2 px-3 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 ";
        }
        liTag += `<li><a href="#" onclick="element(totalPages, ${pageLength}), PaginationButton(${pageLength})" class="${activeLi}">${pageLength}</a></li>`;
    }
    
    if(page < totalPages - 1){
        if(page < totalPages - 2){
            liTag += `<li><a href="#" class="py-2 px-3 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 ">...</a></li>`;
        }
        liTag += `<li><a href="/Wallet?page=${page}" onclick="element(totalPages, ${totalPages}), PaginationButton(${totalPages})" class="py-2 px-3 leading-tight text-gray-500 bg-white border border-gray-300 hover:bg-gray-100 hover:text-gray-700 ">${totalPages}</a></li>`;
    }
    
    if(page < totalPages){
        liTag += `<li><a href="#" onclick="element(totalPages, ${page + 1}), PaginationButton(${page + 1})" class="py-2 px-3 leading-tight text-gray-500 bg-white rounded-r-lg border border-gray-300 hover:bg-gray-100 hover:text-gray-700 ">Next</a></li>`;
    }
    
    ulTag.innerHTML = liTag;
}


//DisplayList(list_items, list_element, rows, current_page);
//SetupPagination(list_items, pagination_element, rows);
element(totalPages, 1);

