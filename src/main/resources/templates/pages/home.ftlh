<#import "../partials/repair-partial.ftlh" as repairComponent>
<html lang="en">
    <head>
        <#include "../partials/html-header-partial.ftlh">
        <title>Home</title>
    </head>
    <body>
    <!-- header here -->
    <#include "../partials/navbar.ftlh">

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
    <!-- footer here -->
    </body>
</html>