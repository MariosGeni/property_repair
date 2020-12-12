<#import "../partials/repair-partial.ftlh" as repairComponent />
<html lang="en">
    <head>
        <#include "../partials/head.ftlh"/>
        <title>Admin - Repair ${repair.id}</title>
    </head>
    <body>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <#if repair?has_content>
                    <@repairComponent.repairSingle repair/>
                </#if>
            </div>
        </div>
    </div>
    </body>
</html>