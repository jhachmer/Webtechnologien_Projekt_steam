function toggleMenu() {
    var body = document.getElementsByTagName("body")[0]
    body.classList.toggle("showmobilemenu");
}

function fillStars(obj) {
    var active_elem = document.getElementsByClassName("steam-active");
    for (var i = 0; i < active_elem.length; i++) {
        active_elem[i].classList.remove("steam-active");
    }
    obj.classList.add("steam-active")
}