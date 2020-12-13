<#import "../partials/owner-partial.ftlh" as ownerComponent />
<#include "../partials/navbar.ftlh">
<html lang="en">
    <head>
        <#include "../partials/head.ftlh"/>
        <title>Admin - Owner ${owner.id}</title>
    </head>
    <body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-12">
                <#if owner?has_content>
                    <@ownerComponent.ownerSingle owner/>
                </#if>
            </div>
        </div>
    </div>
    <#include "../partials/endContainerWithSidebar.ftlh">
    <#include "../partials/scripts.ftlh">
    </body>
</html>