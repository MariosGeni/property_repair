$(function() { // <-- is short for $(document).ready(function() {});
    $("#search-user-select").on("change", function(){ toggleUserSearch();} ); // same thing as doing directly from the element
    // its better to call in js so you can see all events at once without having to go in the html and check for events
    $("#search-repair-select").on("change", function(){ toggleRepairSearch();} );
});

//jQuery - its good to make use of jQuery because we implemented it.
function toggleUserSearch() {
    var selectedValue = $("#search-user-select").children("option:selected").val();
    let $afmDivUser = $("#afm-div");
    let $emailDiv = $("#email-div");

    // toggle visibility
    // can be written in less lines but kept it readable
    if(selectedValue === "afm") {
        $emailDiv.addClass("display-none");
        $afmDivUser.removeClass("display-none");
    }

    if (selectedValue === "email") {
        $afmDivUser.addClass("display-none");
        $emailDiv.removeClass("display-none");
    }
}
function toggleRepairSearch() {
    var selectedValue = $("#search-repair-select").children("option:selected").val();
    let $afmDivRepair = $("#afm-div");
    let $dateDiv = $("#date-div");
    let $dateRangeDiv = $("#range-div");

    // toggle visibility
    // can be written in less lines but kept it readable
    if(selectedValue === "afm") {
        $dateDiv.addClass("display-none");
        $dateRangeDiv.addClass("display-none");
        $afmDivRepair.removeClass("display-none");
    }
    if (selectedValue === "date-range"){
        //alert("I'M IN DATE RANGE");
        $dateDiv.addClass("display-none");
        $afmDivRepair.addClass("display-none");
        $dateRangeDiv.removeClass("display-none");
    }
    if (selectedValue === "date") {
        $afmDivRepair.addClass("display-none");
        $dateRangeDiv.addClass("display-none");
        $dateDiv.removeClass("display-none");
    }
}


// vanilla js
/*function toggleUserSearch() {
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
}*/