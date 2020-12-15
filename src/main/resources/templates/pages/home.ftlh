<#import "../partials/repair-partial.ftlh" as repairComponent>
<html lang="en">
    <head>
        <#include "../partials/html-header-partial.ftlh">
        <title>Home</title>
    </head>
    <body>
    <!-- header here -->
    <nav class="navbar navbar-expand-lg navbar-dark sticky-top bg-dark p-0">
        <a href="/" style="background-color:#343a40">
            <img class="site-logo" src="/images/OBOBOMASTORAS.png" width="200" height="100" style="filter:invert(0.95)">
        </a>
            <form class="form-inline my-lg-0 mr-2" action="/" type="get">
                <button type="submit"  style="font-size: 1.05em;" class="btn-nav btn btn-dark btn-lg">
                    <span data-feather="log-out"></span> Logout
                </button>
            </form>
    </nav>

    <!-- content here -->
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h1>Owners</h1>
            </div>
        </div>

        <div class="row">
            <div class="col-12" style="overflow: auto;">
                <#if repairs?has_content>
                    <@repairComponent.repairList repairs />
                </#if>
            </div>
        </div>
    </div>
    <!-- footer here -->
    </body>
</html>