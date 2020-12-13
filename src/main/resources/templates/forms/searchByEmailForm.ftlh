<#import "../partials/owner-partial.ftlh" as ownerComponent>
    <h1 class="">Search for an Owner</h1>

<form action="/admin/owners/search" name="searchForm">

    <div class="form-group">
        <label>Search by</label>
        <select class="form-control">
            <option value="afm">ΑΦΜ</option>
            <option value="email">Email</option>
        </select>
    </div>

    <div class="input-group mb-0 mt-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon1">@</span>
        </div>
        <label for="email"></label>
        <!-- <div> -->
            <input type="email" class="form-control" name="email" id="email" placeholder="email" aria-describedby="basic-addon1">
        <!-- </div> -->
    </div>

    <button class="btn btn-primary btn-lg mt-4" type="submit">Search</button>

</form>
<#if owner??> <@ownerComponent.ownerSingle owner /> </#if>
