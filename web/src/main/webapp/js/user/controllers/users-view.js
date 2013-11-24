define([
    'angular',
    'angularUiRouter',
    'user/users-service'
], function (angular) {
    angular.module('users.view', [
            'ui.router',
            'users.service'
        ])
        .controller('UserViewController', ['$scope', '$stateParams', 'User',
            function ($scope, $stateParams, User) {
                $scope.user = User.get({userId: $stateParams.id});
            }]);
});