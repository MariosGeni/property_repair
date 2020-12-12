<#import "../partials/owner-partial.ftlh" as ownerComponent />
<html lang="en">
    <head>
        <#include "../partials/head.ftlh"/>
        <title>Admin - Owner ${owner.id}</title>
    </head>
    <body>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <#if owner?has_content>
                    <@ownerComponent.ownerSingle owner/>
                </#if>
            </div>
        </div>
    </div>
    </body>
</html>