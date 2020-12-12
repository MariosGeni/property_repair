<#import "/spring.ftl" as spring />

<h4 class="mb-3">Add Owner Details</h4>
<form id="createForm" action="/admin/owner/create" method="post">

    <div class="mb-3">
        <label for="user-afm">User A.F.M</label>
        <div class="input-group">
            <input type="text" class="form-control" id="user-afm" name="userAfm">
        </div>
    </div>

    <div class="mb-3">
        <label for="user-first-name">User First Name</label>
        <div class="input-group">
            <input type="text" class="form-control" id="user-first-name" name="userFirstName" >
        </div>
    </div>

    <div class="mb-3">
        <label for="user-last-name">User Last Name</label>
        <div class="input-group">
            <input type="text" class="form-control" id="user-last-name" name="userLastName">
        </div>
    </div>

    <div class="mb-3">
        <label for="user-address">User address</label>
        <div class="input-group">
            <input type="text" class="form-control" id="user-address" name="userAddress" >
        </div>
    </div>

    <div class="mb-3">
        <label for="author-phone-number">User phone number</label>
        <div class="input-group">
            <input type="text" class="form-control" id="user-phone-number" name="userPhoneNumber">
        </div>
    </div>

    <div class="mb-3">
        <label for="category">Category</label>
        <div class="input-group">
            <select class="custom-select d-block w-100" id="category" name="category">
                <#if userCategories??>
                    <#list userCategories as category>
                        <option value="${category}">${category}</option>
                    </#list>
                </#if>
            </select>
        </div>
    </div>

    <button class="btn btn-primary btn-lg mt-4" type="submit">Create</button>
</form>