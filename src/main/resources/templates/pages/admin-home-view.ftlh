<#import "../partials/repair-partial.ftlh" as repairComponent />
<html lang="en">
    <head>
        <#include "../partials/html-header-partial.ftlh">
        <#include "../partials/navbar.ftlh">
        <title>Admin - Home</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <h1>Today's Repairs</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-12" style="overflow-x: auto;">
                    <#if activeRepairs?has_content && activeRepairs?is_sequence>
                        <@repairComponent.repairList activeRepairs/>
                    </#if>
                </div>
            </div>
        </div>
        <#include "../partials/endContainerWithSidebar.ftlh">
        <#include "../partials/scripts.ftlh">
    </body>
</html>