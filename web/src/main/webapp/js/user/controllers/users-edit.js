define([
    'angular',
    'user/users-service'
], function (angular) {
    angular.module('users.edit', [
            'users.service'
        ])
        .controller('UserEditController', ['$scope', '$location', '$routeParams', 'User',
            function ($scope, $location, $routeParams, User) {
                var id = $routeParams.userId;
                $scope.user = id ? User.get({userId: $routeParams.userId}) : {};

                $scope.save = function () {
                    User.save($scope.user, function(user) {
                        $location.path('/users/' + user.id);
                    });
                }
            }])
});