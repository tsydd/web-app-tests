define([
    'angular',
    'angularUiRouter',
    'user/controllers/users-list',
    'user/controllers/users-view',
    'user/controllers/users-edit'
], function (angular) {
    angular.module('users', [
            'ui.router',
            'users.list',
            'users.view',
            'users.edit'
        ])
        .config(['$stateProvider',
            function ($stateProvider) {
                $stateProvider
                    .state('users', {
                        abstract: true,
                        url: '/users',
                        template: '<ui-view/>'
                    })
                    .state('users.list', {
                        url: '/list',
                        templateUrl: 'partials/user/list.html',
                        controller: 'UserListController'
                    })
                    .state('users.edit', {
                        url: '/edit/:id',
                        templateUrl: 'partials/user/edit.html',
                        controller: 'UserEditController'
                    })
                    .state('users.view', {
                        url: '/view/:id',
                        templateUrl: 'partials/user/view.html',
                        controller: 'UserViewController'
                    });
            }]);
});