(function () {
    const $modalElement = $('.remove-modal');

    $modalElement.on('show.bs.modal', function (event) {
        let modalButton = $(event.relatedTarget);
        let id = modalButton.closest('[data-id]').data('id');

        let deleteForm = $(event.target).find(".delete-form");
        let baseActionUrl = deleteForm.data('action');
        let redirectUrl = deleteForm.data("redirect-url");
        console.log(redirectUrl);
        // if (baseActionUrl.equals("owners")) // fix for user deletion
        //     deleteForm.attr('action', baseActionUrl + id);
        // else
        if (baseActionUrl.includes("owners")) // fix for user deletion
            deleteForm.attr('action', baseActionUrl + id);
        else
            deleteForm.attr('action', baseActionUrl + id + redirectUrl);
    });
})();
