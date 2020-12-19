<h1 class="">Search for a Property</h1>

<div class="form-group">
    <label for="search-property-select">Search by</label>
    <select id="search-property-select" class="form-control">
        <option value="propertyID" selected>Property ID</option>
        <option value="afm">AFM</option>
    </select>
</div>
<form id="propertyID-form" action="/admin/properties/search" name="searchForm">
    <div id="propertyID-div">
        <div class="row">
            <div class="col-12"><label for="propertyID">Property ID</label></div>
        </div>

        <div class="row">
            <div class="input-group col-12">
                <div class="input-group-prepend">
                    <span class="input-group-text"><span data-feather="home"></span></span>
                </div>
                <input type="propertyID" class="form-control" name="propertyID" id="propertyID" >
            </div>
        </div>
    </div>
    <button class="btn btn-primary btn-lg mt-4" type="submit">Search</button>
</form>

<form id="afm-form" action="/admin/properties/search" class="display-none">
    <div id="afm-div">
    <div class="row">
                <div class="col-12"><label for="afm">AFM</label></div>
            </div>
        <div class="input-group" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">AFM</span>
            </div>
            <label for="afm"></label>
            <input type="text" class="form-control" name="afm" id="afm" placeholder="afm" aria-describedby="basic-addon1">
        </div>
    </div>
    <button class="btn btn-primary btn-lg mt-4" type="submit">Search</button>
</form>
