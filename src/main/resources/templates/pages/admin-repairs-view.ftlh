<#import "../partials/repair-partial.ftlh" as repairComponent>
<html lang="en">
    <head>
        <#include "../partials/html-header-partial.ftlh">
        <title>Admin - Repairs</title>
    </head>
    <body>
        <!-- header here -->

        <!-- content here -->
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1>Repairs</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-12" style="overflow-x: auto;">
                    <#if repairs?has_content && repairs?is_sequence>
                        <@repairComponent.repairList repairs />
                    </#if>
                </div>
            </div>
        </div>

        <!-- footer here -->
    </body>
</html>