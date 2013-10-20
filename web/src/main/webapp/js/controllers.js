var userControllers = angular.module('userControllers', []);

userControllers.controller('UserListController', ['$scope', 'User',
    function UserListController($scope, User) {
        $scope.users = User.query();
    }]);

userControllers.controller('UserEditController', ['$scope', '$routeParams', 'User',
    function UserEditController($scope, $routeParams, User) {
        var id = $routeParams.userId;
        $scope.user = id ? User.get({userId: $routeParams.userId}) : {};

        $scope.save = function () {
            User.save($scope.user);
        }
    }]);

userControllers.controller('UserViewController', ['$scope', '$routeParams', 'User',
    function UserViewController($scope, $routeParams, User) {
        $scope.user = User.get({userId: $routeParams.id});
    }]);