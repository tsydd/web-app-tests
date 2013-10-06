/**
 * required parameters:
 * @param tableSelector - table selector
 * @param columns - column names
 * @param renderRow - function to render row
 */
define(["jquery"], function ($) {
    'use strict';

    return function (config) {
        var self = {
            identity: config.identity || function (model) {
                return model.id;
            },
            init: function () {
                self.emptyRow = '<tr><td colspan="' + config.columns.length + '">&nbsp;</td></tr>';
                self.modelToTr = new buckets.Dictionary();

                self.cacheElements();
                self.fixHead();
                self.fixBody();
                self.setModels([]);
            },
            cacheElements: function () {
                self.$table = $(config.tableSelector);
                self.$thead = self.$table.find("thead");
                self.$tbody = self.$table.find("tbody");
            },
            fixHead: function () {
                if (self.$thead.size() == 0) {
                    self.$thead = $("<thead></thead>");
                    self.$table.prepend(self.$thead);
                }
                for (var i = 0; i < config.columns.length; i++) {
                    self.$thead.append("<th>" + config.columns[i] + "</th>");
                }
            },
            fixBody: function () {
                if (self.$tbody.size() == 0) {
                    self.$tbody = $("<tbody></tbody>");
                    self.$table.append(self.$tbody);
                }
            },
            setModels: function (models) {
                self.$tbody.empty();
                self.modelToTr.clear();
                if (models.length == 0) {
                    self.$tbody.append(self.emptyRow);
                } else {
                    for (var i = 0; i < models.length; i++) {
                        self.addModel(models[i]);
                    }
                }
            },
            addModel: function (model) {
                var key = self.identity(model);
                if (self.modelToTr.containsKey(key)) {
                    return;
                }
                if (self.modelToTr.isEmpty()) {
                    self.$tbody.empty();
                }
                var tr = $('<tr></tr>');
                self.$tbody.append(tr);
                self.modelToTr.set(key, tr);
                config.renderRow(tr, model);
            },
            removeModel: function (model) {
                var key = self.identity(model);
                var tr = self.modelToTr.remove(key);
                tr.remove();
                if (self.modelToTr.isEmpty()) {
                    self.$tbody.html(self.emptyRow);
                }
            }
        };

        self.init();
        return {
            addModel: self.addModel,
            setModels: self.setModels,
            remove: self.removeModel
        };
    }
});