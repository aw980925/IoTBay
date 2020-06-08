function startTime(){
    var date = new Date();
    var n = date.toDateString();
    var time = date.toLocaleTimeString();
    
    document.getElementById('time').innerHTML = n + ' - ' + time;
    tt = display_c();
    
}
function display_c(){
    var refresh = 1000;
    mytime = setTimeout('startTime()', refresh);
}
function resetSearch(){
    document.getElementById("searchterm").value = "";
    
}
function filterTable() {
    var input, filter,table,tr,i,id;
    input = document.getElementById("searchterm");
    filter = input.value.toUpperCase();
    table = document.getElementById("productsTable"); // subjectsTable //need products.xsl in xsl folder
    tr = table.getElementByTagName("tr");
    
    for(i=0; i<tr.length; i++) {
        id = tr[i].getElementByTagName("td")[0];
        
        if(id) {
            if(id.innerHTML.toUpperCase().indexOf(filter) > -1 ){
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}


