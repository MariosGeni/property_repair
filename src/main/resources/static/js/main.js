$(document).ready(function() {
    toggleUserSearch();
});

(function(){
    console.log("Hello World!");
})();

function toggleUserSearch() {
    let afmDiv = document.getElementById("afm-div");
    let emailDiv = document.getElementById("email-div");
    // toggle visibility
    // can be written in less lines but kept it readable
    if (afmDiv.style.display === "none") {
        afmDiv.style.display = "block";
        emailDiv.style.display = "none";
    } else {
        afmDiv.style.display = "none";
        emailDiv.style.display = "block";
    }
}