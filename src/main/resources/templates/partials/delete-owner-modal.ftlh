<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog" style="top:5rem" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-black-50" id="exampleModalLongTitle">Delete Confirmation</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p class="pl-4" style="color:grey">Are you sure you want to delete it?</p>
            </div>
            <div class="modal-footer">
                <form action="/admin/owners/delete/${owner.id}" method="post">
                    <input type="submit" class="btn-danger btn-block btn-lg" value="Delete" ></input>
                </form>
                <form method="post" id="deleteForm">
                    <button type="button" class="btn btn-lg btn-block btn-secondary" data-dismiss="modal">Cancel</button>
                </form>
            </div>
        </div>
    </div>
</div>