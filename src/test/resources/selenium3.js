infoCount = 0;
            
function removeUser(name) {
    var info = document.getElementById("info");
    info.innerHTML = name + " was removed.";
    info.style.display = 'block';
    infoCount++;
    setTimeout('hideInfo(' + infoCount + ')', 2500);
                
    var trs = document.getElementsByTagName("tr");
    for(var i=0; i<trs.length; i++) {
        var tr = trs[i];
        var currentName = tr.childNodes[1].textContent;
        if(currentName == name) {
            tr.parentNode.removeChild(tr);
        }
    }
}

function hideInfo(currentInfoCount) {
    if(currentInfoCount == infoCount) {
        var info = document.getElementById("info");
        info.style.display = 'none';
    }
}