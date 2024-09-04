function populateMedicineSelect(){
    $.ajax({
        url: '/medicines',
        method: 'GET',
        success: function(response) {
            var select = $('#medicine-select');
            select.empty(); // clear any existing options

            $.each(response, function(index, medicine) {
                var option = $('<option>');
                option.val(medicine.medicineId);
                option.text(medicine.medicineName);
                select.append(option);
            });
        },
        error: function(xhr, status, error) {
            console.error(error);
        }
    });
}