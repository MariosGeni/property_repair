<#import "/spring.ftl" as spring />

<h4 class="mb-3">Edit Owner Details</h4>
<form action="/admin/repairs/edit/" method="post">

    <input type="hidden" name="id" value="${owner.id}">

    <div class="mb-3">
        <label for="user-first-name">User First Name</label>
        <div class="input-group">
            <input type="text" class="form-control" id="user-first-name" name="userFirstName" value="${owner.firstName}">
        </div>
    </div>

    <div class="mb-3">
        <label for="user-last-name">User Last Name</label>
        <div class="input-group">
            <input type="text" class="form-control" id="user-last-name" name="userLastName"  value="${owner.lastName}">
        </div>
    </div>

    <div class="mb-3">
        <label for="user-address">User address</label>
        <div class="input-group">
            <input type="text" class="form-control" id="user-address" name="userAddress" value="${owner.address}">
        </div>
    </div>

    <div class="mb-3">
        <label for="author-phone-number">User phone number</label>
        <div class="input-group">
            <input type="text" class="form-control" id="user-phone-number" name="userPhoneNumber" value="${owner.phoneNumber?c}">
        </div>
    </div>

    <button class="btn btn-primary btn-lg mt-4" type="submit">Update</button>
</form>