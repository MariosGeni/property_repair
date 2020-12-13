<#import "../partials/repair-partial.ftlh" as ownerComponent />
<#include "../partials/navbar.ftlh">
<html lang="en">
    <head>
        <#include "../partials/head.ftlh"/>
        <title>Admin - Search Repairs</title>
    </head>
    <#include "../partials/beginContainerWithSidebar.ftlh">
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <#if repairs?has_content && repairs?is_sequence>
                        <@repairComponent.repairList repairs/>
                    </#if>
                </div>
            </div>
        </div>
        <#include "../partials/endContainerWithSidebar.ftlh">
        <#include "../partials/scripts.ftlh">
    </body>
</html>