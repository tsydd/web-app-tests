define([
    'angular',
    'angularResource'
], function (angular) {
    angular.module('users.service', [
            'ngResource'
        ])
        .factory('User', ['$resource',
            function ($resource) {
                return $resource('/disp/users/:userId');
            }]);
});
