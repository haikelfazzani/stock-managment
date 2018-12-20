window.onload = () => {

    var isClose = true;
    var btnClose = document.getElementById('btn-close');
    var aside = document.querySelector(".m-col-3");

    btnClose.onclick = () => {

        if(isClose) {
            aside.style.display = "none";
            isClose = false;
        }else {
            aside.style.display = "block";
            isClose = true;
        }
    }
}