<#import "../partials/repair-partial.ftlh" as repairComponent />
<html lang="en">
    <head>
        <#include "../partials/html-header-partial.ftlh">
        <title>Admin - Home</title>
    </head>
    <body>
        <a href="/admin/owners">Owners</a>
        <a href="/admin/repairs">Repairs</a>

        <div class="container">
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

            <div class="row">
                <div class="col-12">
                    <@repairComponent.repairSingle activeRepairs[0] />
                </div>
            </div>
        </div>
    </body>
</html>