define([
    'angular',
    'user/users-service'
], function (angular) {
    angular.module('users.list', [
            'users.service'
        ])
        .controller('UserListController', ['$scope', 'User',
            function ($scope, User) {
                $scope.users = User.query();
            }])
});