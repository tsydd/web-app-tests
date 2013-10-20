var userServices = angular.module('userServices', ['ngResource']);

userServices.factory('User', ['$resource',
    function ($resource) {
        return $resource('/disp/users/:userId');
    }]);