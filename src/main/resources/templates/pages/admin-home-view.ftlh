<#import "../partials/repair-partial.ftlh" as repairComponent />
<#include "../partials/top-design.ftlh">
        <title>Admin - Home</title>
    </head>
    <body>
    <!-- header here -->
    <#include "../partials/navbar.ftlh">
    <#include "../partials/beginContainerWithSidebar.ftlh">
        <div class="container-fluid">
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
        </div>
        <#include "../partials/endContainerWithSidebar.ftlh">
    </body>
</html>