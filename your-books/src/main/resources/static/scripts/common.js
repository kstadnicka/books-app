const toggle = document.querySelector(".menu-toggle");
const menu = document.querySelector(".menu");

function toggleMenu() {
       if (menu.classList.contains("expanded")) {
              menu.classList.remove("expanded");
              toggle.querySelector('a').innerHTML = '<i id="toggle-icon" class="fa fa-circle-plus"></i>';
       } else {
              menu.classList.add("expanded");
              toggle.querySelector('a').innerHTML = '<i id="toggle-icon" class="fa fa-circle-minus"></i>';
       }
}

toggle.addEventListener("click", toggleMenu, false);