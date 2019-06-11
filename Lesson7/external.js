function checkAllItems() {
    var checkbox = document.getElementById('selectAllItems');
    var checkboxes = document.getElementsByName('selectItemID');

    for (var i in checkboxes) {
        checkboxes[i].checked = checkbox.checked;
    }
}