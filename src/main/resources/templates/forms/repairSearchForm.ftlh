<h1 class="">Search for a Repair</h1>

<#--paidia to logic skeftomai na einai na elegxoume an exei eishxthei specific date (duskolo siga mh thumatai kaneis-->
<#--hmeromhnia akribws :P) kai meta an oxi na tsekaroume ta alla duo pedia gia to euros hmeromhniwn -->

<div class="form-group">
    <label for="search-repair-select">Search by</label>
    <select id="search-repair-select" class="form-control">
        <option value="date" selected> Ημερομηνία </option>
        <option value="date-range"> Εύρος Ημερομηνιών </option>
        <option value="afm">ΑΦΜ</option>
    </select>
</div>
<form id="date-form" action="/admin/repairs/search" name="searchForm">
    <div id="date-div">
        <div class="row">
            <div class="col-12"><label for="date">Date</label></div>
        </div>

        <div class="row">
            <div class="input-group col-12">
                <div class="input-group-prepend">
                    <span class="input-group-text"><span data-feather="calendar"></span></span>
                </div>
                <input type="date" class="form-control" name="date" id="date" >
            </div>
        </div>
    </div>
    <button class="btn btn-primary btn-lg mt-4" type="submit">Search</button>
</form>
<form id="range-form" action="/admin/repairs/search" class="display-none">
    <div id="range-div">
        <div class="row">
            <div class="col-6"><label for="fromDate">From Date</label></div>
            <div class="col-6"><label for="toDate">To Date</label></div>
        </div>
        <div class="row">
            <div class="input-group col-6">
                <div class="input-group-prepend">
                    <span class="input-group-text"><span data-feather="calendar"></span></span>
                </div>
                <input type="date" class="form-control" name="fromDate" id="fromDate" >
            </div>
            <div class="input-group col-6">
                <div class="input-group-prepend">
                    <span class="input-group-text"><span data-feather="calendar"></span></span>
                </div>
                <input type="date" class="form-control" name="toDate" id="toDate" >
            </div>
        </div>
    </div>
    <button class="btn btn-primary btn-lg mt-4" type="submit">Search</button>
</form>
<form id="afm-form" action="/admin/repairs/search" class="display-none">
    <div id="afm-div">
        <div class="input-group mb-0 mt-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">ΑΦΜ</span>
            </div>
            <label for="afm"></label>
            <input type="text" class="form-control" name="afm" id="afm" placeholder="afm" aria-describedby="basic-addon1">
        </div>
    </div>
    <button class="btn btn-primary btn-lg mt-4" type="submit">Search</button>
</form>
