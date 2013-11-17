define([
    'angular',
    'angularRoute',
    'user/controllers/users-list',
    'user/controllers/users-view',
    'user/controllers/users-edit'
], function (angular) {
    angular.module('users', [
            'ngRoute',
            'users.list',
            'users.view',
            'users.edit'
        ])
        .config(['$routeProvider',
            function ($routeProvider) {
                $routeProvider
                    .when('/users', {
                        templateUrl: 'partials/user/list.html',
                        controller: 'UserListController'
                    })
                    .when('/users/edit/:userId?', {
                        templateUrl: 'partials/user/edit.html',
                        controller: 'UserEditController'
                    })
                    .when('/users/:id', {
                        templateUrl: 'partials/user/view.html',
                        controller: 'UserViewController'
                    })
                    .otherwise({
                        redirectTo: '/users'
                    });
            }]);
});