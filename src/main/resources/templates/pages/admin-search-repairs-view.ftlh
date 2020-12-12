<#import "../partials/repair-partial.ftlh" as repairComponent />
<html lang="en">
    <head>
        <#include "../partials/head.ftlh"/>
        <title>Admin - Search Repairs</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <#if repairs?has_content && repairs?is_sequence>
                        <@repairComponent.repairList repairs/>
                    </#if>
                </div>
            </div>
        </div>
    </body>
</html>