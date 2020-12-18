<#import "../partials/property-partial.ftlh" as propertyComponent />
<#include "../partials/top-design.ftlh">
        <title>Admin - Properties</title>
    </head>
    <body>
        <!-- header here -->
        <#include "../partials/navbar.ftlh">
        <#include "../partials/beginContainerWithSidebar.ftlh">
        <!-- content here -->
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <#--<#if properties?has_content>-->
                    <#if properties?has_content>
                        <h1>Properties</h1>
                    <#else>
                        <h3>There are no Properties</h3>
                    </#if>
                </div>
            </div>

            <div class="row">
                <div class="col" style="overflow-x: auto;">
                    <#if properties?has_content && properties?is_sequence>
                        <@propertyComponent.propertyList properties /><#--properties.getContent(), properties.getTotalPages(), properties.getNumber() + 1, properties.getTotalElements()?number, properties.getSize()/>-->
                    </#if>
                </div>
            </div>

        <#include "../partials/endContainerWithSidebar.ftlh">
        <!-- footer here -->
    </body>
</html>