<#import "../partials/repair-partial.ftlh" as repairComponent>
<h1 class="">Search for a Repair </h1>

<form action="/admin/repairs/search" name="searchForm">

    <div class="form-group">
        <label>Search by</label>
        <select id="search-repair-select" class="form-control">
            <option value="date" selected> Ημερομηνία </option>
            <option value="afm">ΑΦΜ</option>
        </select>
    </div>

    <div id="date-div">
        <div class="input-group mb-0 mt-3">
            <div class="input-group-prepend">
                <span class="input-group-text"><span data-feather="calendar"></span></span>
            </div>
            <label for="date"></label>
            <!-- <div> -->
            <input type="date" class="form-control" name="date" id="date" >
            <!-- </div> -->
        </div>
    </div>

    <div id="afm-div" class="display-none">
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
<#if repair??> <@repairComponent.repairSingle repair /> </#if>
