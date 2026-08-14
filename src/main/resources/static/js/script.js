const qs = (el) => document.querySelector(el);
const qsAll = (el) => document.querySelectorAll(el);

document.addEventListener('DOMContentLoaded', ()=>{

    const currentPath = window.location.pathname;

    qsAll(".main-menu .nav-link").forEach(link =>{
        const linkPath = new URL(link.href).pathname;

        if(linkPath === currentPath){
            link.classList.add("active");
        }
    })
})