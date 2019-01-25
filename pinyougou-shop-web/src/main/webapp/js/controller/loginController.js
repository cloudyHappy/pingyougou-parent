app.controller("loginController",function ($scope,loginService) {
    $scope.getName = function () {
        loginService.getLoginName().success(function (result) {
            $scope.loginName = result.loginName;
        })
    }
})