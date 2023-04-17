function addfood() {
    var name = document.getElementById('foodname').value;
    var action = "C";
    $.ajax({
        url: 'foodapp?foodname=' + name + '&action=' + action
    }).done(function (response) {
        location.href = "index.html";
    });
}


function loadFoodList1() {
    $.ajax({
        url: 'foodapp?action=R'
    }).done(function (response) {
        //  printOnDiv(response.listFromBackend);
        printOnDiv(response.listOfFood);
    });
}

function deleteAll() {
    $.ajax({
        url: 'manageMyToList?action=DELETE'
    }).done(function (response) {
        printOnDiv(response.listFromBackend); // ne vom asigura ca din backend ne vine listFromBackend goala
    });
}


function printOnDiv(listOfFood) {
    var listHtml = '';

    var list = document.getElementById('R');

    for (var i = 0; i < listOfFood.length; i++) {
        var elemC = listOfFood[i];
        var el = '<li>' + elemC + '</li>';
        listHtml = listHtml + el;
    }
    list.innerHTML = '<ol>' + listHtml + '</ol>';
}
