<#import "/spring.ftl" as spring />
<#import "../partials/owner-partial.ftlh" as ownerComponent />
<#include "../partials/top-design.ftlh">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
    <title>Edit Book</title>
</head>

<body>
<!-- header here -->
<#include "../partials/navbar.ftlh">
<#include "../partials/beginContainerWithSidebar.ftlh">

<div class="container-fluid">
    <div class="row">

        <#include "../partials/beginContainerWithSidebar.ftlh">
        <!--class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4"-->
        <main role="main" class="col-md-12 ml-xsm-auto col-lg-12 pt-3 px-4">
            <div class="row">
                <div class="col-md-12 order-md-1">
                    <#include "../forms/userEditForm.ftlh">
                </div>
            </div>
        </main>
    </div>
</div>
<#include "../partials/endContainerWithSidebar.ftlh">
</body>
</html>

