<#assign page = springMacroRequestContext.requestUri>
<#assign redirectId = page?starts_with("/admin/owners/")?then(page?split("/admin/owners/")[1], "")>
<div class="modal fade remove-modal" id="repair-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
<div class="modal-dialog" style="top:5rem" role="document">
    <div class="modal-content">
        <div class="modal-header border-bottom-0">
            <h4 class="modal-title text-black-50" id="exampleModalLongTitle">Delete Confirmation</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="modal-body">
            <h5 style="color:grey" class="pl-4 font-weight-normal">Are you sure you want to delete it?</h5>
        </div>
            <div class="modal-footer border-top-0">
                <form class="delete-form form-inline" data-action="/admin/repairs/delete/" method="post" data-redirect-url="<#if redirectId?has_content>?userId=${redirectId}</#if>">
                    <input type="submit" class="btn-danger mr-2 btn-lg" value="Delete">
                    <button type="button" class="btn btn-lg btn-secondary" data-dismiss="modal">Cancel</button>
                </form>
            </div>
        </div>
    </div>
</div>