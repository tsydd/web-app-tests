require(["jquery", "subjects-form", "grid"], function ($, SubjectsForm, DirectorsGrid) {
    'use strict';

    var subjectsForm = SubjectsForm("#directors");
    var directorsGrid = DirectorsGrid({
        tableSelector: "#directors_grid",
        columns: ["id", "first name", "last name", "actions"],
        renderRow: function (tr, director) {
            tr.append('<td>' + director.id + '</td>')
                .append('<td>' + director.firstName + '</td>')
                .append('<td>' + director.lastName + '</td>');
            var actionsTd = $('<td></td>');
            tr.append(actionsTd);
            addActions(actionsTd, director);
            return tr;
        }
    });

    function addActions(td, model) {
        addRemoveModelAction(td, model);
    }

    function addRemoveModelAction(td, model) {
        var icon = $('<icon class="glyphicon glyphicon-remove"></icon>').on('click', function () {
            directorsGrid.remove(model);
        });
        td.append(icon);
    }

    var counter = 0;
    subjectsForm.onSubmit(function (model) {
        console.log(model);
        model.id = counter++;
        directorsGrid.addModel(model);
    });
});