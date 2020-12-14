<#import "../partials/owner-partial.ftlh" as ownerComponent>
<h1 class="">Search for an Owner</h1>

<form action="/admin/owners/search" name="searchForm">

    <div class="form-group">
        <label>Search by</label>
        <select class="form-control" onchange="toggleUserSearch();">
            <option value="afm">ΑΦΜ</option>
            <option value="email">Email</option>
        </select>
    </div>

    <div id="email-div" style="display:none;">
        <div class="input-group mb-0 mt-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">@</span>
            </div>
            <label for="email"></label>
            <!-- <div> -->
            <input type="email" class="form-control" name="email" id="email" placeholder="email" aria-describedby="basic-addon1">
            <!-- </div> -->
        </div>
    </div>

    <div id="afm-div">
        <div class="input-group mb-0 mt-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">ΑΦΜ</span>
            </div>
            <label for="afm"></label>
            <!-- <div> -->
            <input type="text" class="form-control" name="afm" id="afm" placeholder="afm" aria-describedby="basic-addon1">
            <!-- </div> -->
        </div>
    </div>

    <button class="btn btn-primary btn-lg mt-4" type="submit">Search</button>
</form>
<#if owner??> <@ownerComponent.ownerSingle owner /> </#if>

<script>
    // will be imported in another file -> main.js later -> TODO
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
</script>
