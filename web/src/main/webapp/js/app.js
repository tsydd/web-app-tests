define([
    'angular',
    'angularUiRouter',
    'user/users'
], function (angular) {
    return angular.module('app', [
            'users',
            'ui.router'
        ])
        .config(['$urlRouterProvider', function ($urlRouterProvider) {
            $urlRouterProvider.otherwise('/users/list');
        }]);
});
