app.controller("brandController", function ($scope, $controller,brandService) {
    //继承父控制器
    $controller("baseController",{$scope:$scope})

    $scope.findAll = function () {
        brandService.findAll().success(function (result) {
            $scope.list = result;
        });
    }

    //刷新结果
    $scope.reloadResult = function (result) {
        if (result.success) {
            $scope.reloadList();
        } else {
            alert(result.message);
        }
    }
    //分页获取品牌
    $scope.findPage = function (currentPage, pageSize) {
        brandService.findPage(currentPage, pageSize).success(function (result) {
            $scope.list = result.rows;//当前页数据
            $scope.paginationConf.totalItems = result.total;//更新记录数
        })
    }
    //添加品牌
    $scope.add = function () {
        if ($scope.entity.id != null) {
            //修改
            brandService.add($scope.entity).success(function (result) {
                $scope.reloadResult(result);
            });
        } else {
            //添加
            brandService.update($scope.entity).success(function (result) {
                $scope.reloadResult(result);
            });
        }

    }
    //获取商品信息
    $scope.getTbrand = function (id) {
        brandService.getTbrand(id).success(function (result) {
            $scope.entity = result;
        })
    }

    //删除商品
    $scope.delete = function () {
        if (confirm("确认删除吗?")) {
            brandService.delete($scope.selectIds).success(function (result) {
                $scope.reloadResult(result);
            })
        }

    }

    $scope.searchEntity = {};
    //条件查询
    $scope.search = function (currentPage, pageSize) {
        brandService.search(currentPage,pageSize,$scope.searchEntity).success(
            function
                (result) {
                $scope.list = result.rows;//当前页数据
                $scope.paginationConf.totalItems = result.total;//更新记录数
            })
    }

});