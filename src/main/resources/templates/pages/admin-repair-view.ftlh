<#import "../partials/repair-partial.ftlh" as repairComponent />
<html lang="en">
    <head>
        <#include "../partials/head.ftlh"/>
        <title>Admin - Repair ${repair.id}</title>
    </head>
    <#include "../partials/beginContainerWithSidebar.ftlh">
    <body>
    <#include "../partials/navbar.ftlh">
    <div class="container-fluid">
        <div class="row">
            <div class="col-12">
                <#if repair?has_content>
                    <@repairComponent.repairSingle repair/>
                </#if>
            </div>
        </div>
    </div>

    <#include "../partials/endContainerWithSidebar.ftlh">
    </body>
</html>