define([
    'angular',
    'user/users-service'
], function (angular) {
    angular.module('users.list', [
            'users.service'
        ])
        .controller('UserListController', ['$scope', '$location', 'User',
            function ($scope, $location, User) {
                $scope.users = User.query();

                $scope.create = function () {
                    $location.path('/users/edit')
                }
            }])
});