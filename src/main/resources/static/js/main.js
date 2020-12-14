$(function() { // <-- is short for $(document).ready(function() {});
    $("#search-user-select").on("change", function(e) { toggleUserSearch(e); }); // same thing as doing directly from the element
    // its better to call in js so you can see all events at once without having to go in the html and check for events
});

//jQuery - its good to make use of jQuery because we implemented it.
function toggleUserSearch(e) {
    var $target = $(e.target);
    let $afmDiv = $("#afm-div");
    let $emailDiv = $("#email-div");

    // toggle visibility
    // can be written in less lines but kept it readable
    if ($target.attr("value") == "email") {
        $afmDiv.css({ display: "none" });
        $emailDiv.css({ display: "block" });
    }

    if($target.attr("value") == "afm") {
        $emailDiv.css({ display: "none" });
        $afmDiv.css({ display: "block" });
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