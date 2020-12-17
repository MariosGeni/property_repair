<#import "../partials/property-partial.ftlh" as propertyComponent>
<h1 class="">Search for a Property</h1>

<form action="/admin/properties/search" name="searchForm">

    <div class="form-group">
        <label>Search by</label>
        <select id="search-user-select" class="form-control">
            <option value="id" selected>ID</option>
            <option value="afm">ΑΦΜ</option>
        </select>
    </div>

    <div id="id-div">
        <div class="input-group mb-0 mt-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">@</span>
            </div>
            <label for="id"></label>
            <!-- <div> -->
            <input type="text" class="form-control" name="id" id="id" placeholder="id" aria-describedby="basic-addon1">
            <!-- </div> -->
        </div>
    </div>

    <div id="afm-div" class="display-none">
        <div class="input-group mb-0 mt-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">ID</span>
            </div>
            <label for="afm"></label>
            <!-- <div> -->
            <input type="text" class="form-control" name="id" id="id" placeholder="afm" aria-describedby="basic-addon1">
            <!-- </div> -->
        </div>
    </div>

    <button class="btn btn-primary btn-lg mt-4" type="submit">Search</button>
</form>
<#if property??> <@propertyComponent.propertySingle property /> </#if>
