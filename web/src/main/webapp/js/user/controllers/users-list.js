define([
    'angular',
    'angularUiRouter',
    'user/users-service'
], function (angular) {
    angular.module('users.list', [
            'ui.router',
            'users.service'
        ])
        .controller('UserListController', ['$scope', '$state', 'User',
            function ($scope, $state, User) {
                $scope.users = User.query();

                $scope.create = function () {
                    $state.go('users.edit');
                }
            }]);
});