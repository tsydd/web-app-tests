define(["jquery"], function ($) {
    'use strict';

    return function (formSelector) {
        var self = {
            init: function () {
                self.cacheElements();
                self.bindEvents();
            },
            cacheElements: function () {
                var form = $(formSelector);
                self.$firstName = form.find("input:nth(0)");
                self.$lastName = form.find("input:nth(1)");
                self.$buttonAdd = form.find("button:nth(0)");
                self.$buttonReset = form.find("button:nth(1)");
            },
            bindEvents: function () {
                self.$buttonAdd.on('click', function () {
                    if (typeof self.$callback == "function") {
                        self.$callback(self.getModel());
                    }
                });
                self.$buttonReset.on('click', function () {
                    self.setModel({});
                });
            },
            getModel: function () {
                return {
                    firstName: self.$firstName.val(),
                    lastName: self.$lastName.val()
                };
            },
            setModel: function (model) {
                self.$firstName.val(model.firstName);
                self.$lastName.val(model.lastName);
            },
            onSubmit: function (callback) {
                self.$callback = callback;
            }
        };

        self.init();
        return {
            getModel: self.getModel,
            setModel: self.setModel,
            onSubmit: self.onSubmit
        };
    };
});