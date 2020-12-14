<#import "../partials/owner-partial.ftlh" as ownerComponent>
<h1 class="">Search for an Owner</h1>

<form action="/admin/owners/search" name="searchForm">

    <div class="form-group">
        <label>Search by</label>
        <select id="search-user-select" class="form-control">
            <option value="email" selected>Email</option>
            <option value="afm">ΑΦΜ</option>
        </select>
    </div>

    <div id="email-div">
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
        <div class="input-group mb-0 mt-3" style="display:none;">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">ΑΦΜ</span>
            </div>
            <label for="afm"></label>
            <!-- <div> -->
            <input type="text" class="form-control" name="afm" id="afm" placeholder="αφμ" aria-describedby="basic-addon1">
            <!-- </div> -->
        </div>
    </div>

    <button class="btn btn-primary btn-lg mt-4" type="submit">Search</button>
</form>
<#if owner??> <@ownerComponent.ownerSingle owner /> </#if>
