<#import "../partials/repair-partial.ftlh" as repairComponent>
<h1 class="">Search for a Repair</h1>

<#--paidia to logic skeftomai na einai na elegxoume an exei eishxthei specific date (duskolo siga mh thumatai kaneis-->
<#--hmeromhnia akribws :P) kai meta an oxi na tsekaroume ta alla duo pedia gia to euros hmeromhniwn -->

<form action="/admin/repairs/search" name="searchForm">

    <div class="form-group">
        <label>Search by</label>
        <select id="search-repair-select" class="form-control">
            <option value="date" selected> Ημερομηνία </option>
            <option value="afm">ΑΦΜ</option>
        </select>
    </div>

    <div id="date-div">
<#-- old code -->
<#--        <div class="input-group mb-0 mt-3">-->
<#--            <div class="input-group-prepend">-->
<#--                <span class="input-group-text"><span data-feather="calendar"></span></span>-->
<#--            </div>-->
<#--            <label for="date"></label>-->
<#--            <input type="date" class="form-control" name="date" id="date" >-->
<#--        </div>-->
        <div class="row " style="border:2px blue;">
            <div class="col-6"><h5>Specific date</h5></div>
            <div class="col-3"><h5>From date</h5></div>
            <div class="col-3"><h5>To date</h5></div>
        </div>

        <div class="row">
            <div class="input-group mb-0 mt-3 col-12 col-lg-6">
                <div class="input-group-prepend">
                    <span class="input-group-text"><span data-feather="calendar"></span></span>
                </div>
                <label for="date"></label>
                <input type="date" class="form-control" name="date" id="date" >
            </div>
            <div class="input-group mb-0 mt-3 col-6 col-lg-3">
                <div class="input-group-prepend">
                    <span class="input-group-text"><span data-feather="calendar"></span></span>
                </div>
                <label for="date"></label>
                <input type="date" class="form-control" name="fromDate" id="fromDate" >
            </div>
            <div class="input-group mb-0 mt-3 col-6 col-lg-3">
                <div class="input-group-prepend">
                    <span class="input-group-text"><span data-feather="calendar"></span></span>
                </div>
                <label for="date"></label>
                <input type="date" class="form-control" name="toDate" id="toDate" >
            </div>
        </div>
    </div>

    <div id="afm-div" class="display-none">
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
<#if repair??> <@repairComponent.repairSingle repair /> </#if>
