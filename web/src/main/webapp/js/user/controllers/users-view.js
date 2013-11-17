define([
    'angular',
    'user/users-service'
], function (angular) {
    angular.module('users.view', [
            'users.service'
        ])
        .controller('UserViewController', ['$scope', '$routeParams', 'User',
            function ($scope, $routeParams, User) {
                $scope.user = User.get({userId: $routeParams.id});
            }])
});