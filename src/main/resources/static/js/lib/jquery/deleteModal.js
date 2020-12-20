(function () {
    const $modalElement = $('.remove-modal');

    $modalElement.on('show.bs.modal', function (event) {
        let modalButton = $(event.relatedTarget);
        let id = modalButton.closest('[data-id]').data('id');

        let deleteForm = $('.delete-form');

        let baseActionUrl = deleteForm.closest('[data-action]').data('action');

        deleteForm.attr('action', baseActionUrl + id);
    });
})();