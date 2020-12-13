<#import "../partials/repair-partial.ftlh" as repairComponent />
<#include "../partials/top-design.ftlh">
        <title>Admin - Repairs</title>
    </head>
    <body>
        <!-- header here -->
        <#include "../partials/navbar.ftlh">
        <#include "../partials/beginContainerWithSidebar.ftlh">
        <!-- content here -->
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <#if repairs?has_content>
                        <h1>Repairs</h1>
                    <#else>
                        <h3>There are no Repairs</h3>
                    </#if>
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

        <#include "../partials/endContainerWithSidebar.ftlh">
        <!-- footer here -->
    </body>
</html>