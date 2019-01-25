app.controller("indexController",function ($scope,loginService) {
    $scope.getLoginName = function () {
        console.log("1")
         loginService.getLoginName().success(function (result) {
            console.log(result.loginName)
            $scope.loginName = result.loginName;
        });
    }
})