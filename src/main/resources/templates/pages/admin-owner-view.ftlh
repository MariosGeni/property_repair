<#import "../partials/owner-partial.ftlh" as ownerComponent />
<#include "../partials/top-design.ftlh">
        <title>Admin - Owner ${owner.id}</title>
    </head>
    <body>
    <!-- header here -->
    <#include "../partials/navbar.ftlh">
    <#include "../partials/beginContainerWithSidebar.ftlh">
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
    </body>
</html>