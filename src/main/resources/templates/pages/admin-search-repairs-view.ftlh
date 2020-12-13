<#import "../partials/repair-partial.ftlh" as repairComponent />
<#include "../partials/top-design.ftlh">
        <title>Admin - Search Repairs</title>
    </head>
    <body>
    <!-- header here -->
    <#include "../partials/navbar.ftlh">
    <#include "../partials/beginContainerWithSidebar.ftlh">
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
    </body>
</html>