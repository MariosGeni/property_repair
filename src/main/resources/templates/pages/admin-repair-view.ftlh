
<#import "../partials/owner-partial.ftlh" as ownerComponent />
<#include "../partials/navbar.ftlh">
<html lang="en">
    <head>
        <#include "../partials/head.ftlh"/>
        <title>Admin - Repair ${repair.id}</title>
    </head>
    <body>
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