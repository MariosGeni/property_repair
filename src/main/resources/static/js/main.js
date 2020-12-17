$(function() { // <-- is short for $(document).ready(function() {});
    $("#search-user-select").on("change", function(){ toggleUserSearch();} ); // same thing as doing directly from the element
    // its better to call in js so you can see all events at once without having to go in the html and check for events
    $("#search-repair-select").on("change", function(){ toggleRepairSearch();} );

    $(".page-number-link").on("click", function(e) { if($(e.target).hasClass("active")) e.preventDefault(); });
});

//jQuery - its good to make use of jQuery because we implemented it.
function toggleUserSearch() {
    clearNoResultsFoundH3();
    var selectedValue = $("#search-user-select").children("option:selected").val();
    let $emailForm = $("#email-form");
    let $afmFormOwner = $("#afm-form");

    // toggle visibility
    // can be written in less lines but kept it readable
    if(selectedValue === "afm") {
        $emailForm.addClass("display-none");
        $afmFormOwner.removeClass("display-none");
    } else if (selectedValue === "email") {
        $afmFormOwner.addClass("display-none");
        $emailForm.removeClass("display-none");
    }
}
function toggleRepairSearch() {
    clearNoResultsFoundH3();
    var selectedValue = $("#search-repair-select").children("option:selected").val();
    let $afmFormRepair = $("#afm-form");
    let $dateForm = $("#date-form");
    let $dateRangeForm = $("#range-form");

    // toggle visibility
    // can be written in less lines but kept it readable
    if(selectedValue === "afm") {
        $dateForm.addClass("display-none");
        $dateRangeForm.addClass("display-none");
        $afmFormRepair.removeClass("display-none");
    } else if (selectedValue === "date-range"){
        //alert("I'M IN DATE RANGE");
        $dateForm.addClass("display-none");
        $afmFormRepair.addClass("display-none");
        $dateRangeForm.removeClass("display-none");
    } else if (selectedValue === "date") {
        $afmFormRepair.addClass("display-none");
        $dateRangeForm.addClass("display-none");
        $dateForm.removeClass("display-none");
    }
}

function clearNoResultsFoundH3() { $(".no-result-found-h3").remove(); } // if the search type changed clear the no results found message

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