define([
    'angular',
    'angularUiRouter',
    'user/users-service'
], function (angular) {
    angular.module('users.edit', [
            'ui.router',
            'users.service'
        ])
        .controller('UserEditController', ['$scope', '$state', '$stateParams', 'User',
            function ($scope, $state, $stateParams, User) {
                var id = $stateParams.id;
                $scope.user = id ? User.get({userId: id}) : {};

                $scope.save = function () {
                    User.save($scope.user, function (user) {
                        $state.go('users.view', { id: user.id });
                    });
                }
            }]);
});