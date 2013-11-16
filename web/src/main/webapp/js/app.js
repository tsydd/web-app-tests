var app = angular.module('app', [
    'ngRoute',
    'userControllers',
    'userServices'
]);

app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
            .when('/users', {
                templateUrl: 'partials/user/list.html',
                controller: 'UserListController'
            })
            .when('/users/edit/:userId', {
                templateUrl: 'partials/user/edit.html',
                controller: 'UserEditController'
            })
            .when('/users/edit/', {
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
