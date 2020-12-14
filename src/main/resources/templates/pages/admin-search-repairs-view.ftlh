<#import "/spring.ftl" as spring />
<#import "../partials/repair-partial.ftlh" as repairComponent />
<#include "../partials/top-design.ftlh">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
        <title>Admin - Search Repairs</title>
    </head>
    <body>
    <!-- header here -->
    <#include "../partials/navbar.ftlh">
    <#include "../partials/beginContainerWithSidebar.ftlh">
        <div class="container-fluid">
       <div class="row">
     <div class="col-12">
        <#include "../forms/repairSearchForm.ftlh">
        </div>

        </div>
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