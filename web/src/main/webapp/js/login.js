function Login($scope, $http) {
    $scope.doLogin = function () {
        $http.post('disp/login', $scope.login)
            .success(function (data, status) {
                $scope.message = 'success';
                $scope.data = data;
                $scope.status = status;
            })
            .error(function (data, status) {
                $scope.message = 'fail';
                $scope.data = data;
                $scope.status = status;
            })
    }
}
