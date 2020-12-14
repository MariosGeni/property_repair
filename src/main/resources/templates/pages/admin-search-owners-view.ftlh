<#import "/spring.ftl" as spring />
<#import "../partials/owner-partial.ftlh" as ownerComponent />
<#include "../partials/top-design.ftlh">
    <title>Admin- Search Owners</title>
</head>

<body>
<!-- header here -->
<#include "../partials/navbar.ftlh">
<#include "../partials/beginContainerWithSidebar.ftlh">
<div class="container-fluid">
    <div class="row">
        <main role="main" class="col-md-12 ml-xsm-auto col-lg-12 pt-3 px-4">
            <div class="row">
                <div class="col-md-12 order-md-1">
                    <#include "../forms/userSearchForm.ftlh">
                </div>
            </div>
        </main>
    </div>
</div>
<#include "../partials/endContainerWithSidebar.ftlh">
</body>
</html>