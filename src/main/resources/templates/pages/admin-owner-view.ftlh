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
    <script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/130527/h5ab-snow-flurry.js"></script>
    <script src="/js/lib/jquery/let_it_snow.js"></script>
    </body>
</html>