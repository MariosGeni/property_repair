<#import "../partials/repair-partial.ftlh" as repairComponent>
<html lang="en">
    <head>
        <#include "../partials/html-header-partial.ftlh">
        <title>Home</title>
    </head>
    <body>
    <!-- header here -->
    <nav class="navbar navbar-expand-lg navbar-dark sticky-top bg-dark p-0">
        <a href="/home" style="background-color:#343a40">
            <img class="site-logo" src="/images/OBOBOMASTORAS.png" width="200" height="100" style="filter:invert(0.95)">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto"></ul>
            <form class="form-inline my-lg-0 mr-2" action="/logout" type="get">
                <button type="submit"  style="font-size: 1.05em;" class="btn-nav btn btn-dark btn-lg">
                    <span data-feather="log-out"></span> Logout
                </button>
            </form>
        </div>
    </nav>

    <!-- content here -->
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h1>Welcome ${userName!"user"}, here are your repairs</h1>
            </div>
        </div>

        <div class="row">
            <div class="col-12" style="overflow: auto;">
                <#if repairs?has_content>
                    <@repairComponent.repairList repairs, 0, 0, 0, 0, true />
                </#if>
            </div>
        </div>
    </div>
    <!-- footer here -->
    </body>
</html>