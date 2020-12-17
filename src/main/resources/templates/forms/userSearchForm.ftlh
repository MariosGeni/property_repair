<h1 class="">Search for an Owner</h1>

<div class="form-group">
    <label for="search-user-select">Search by</label>
    <select id="search-user-select" class="form-control">
        <option value="email" selected>Email</option>
        <option value="afm">AFM</option>
    </select>
</div>

<form id="email-form" action="/admin/owners/search" name="searchForm">
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
    <button class="btn btn-primary btn-lg mt-4" type="submit">Search</button>
</form>
<form id="afm-form" action="/admin/owners/search" class="display-none">
    <div id="afm-div">
        <div class="input-group mb-0 mt-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">AFM</span>
            </div>
            <label for="afm"></label>
            <!-- <div> -->
            <input type="text" class="form-control" name="afm" id="afm" placeholder="afm" aria-describedby="basic-addon1">
            <!-- </div> -->
        </div>
    </div>
    <button class="btn btn-primary btn-lg mt-4" type="submit">Search</button>
</form>