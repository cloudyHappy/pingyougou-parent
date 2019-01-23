app.controller("baseController",function ($scope) {
    //分页控制配件
    $scope.paginationConf = {
        currentPage: 1,//当前页
        totalItems: 10,//总记录数
        itemsPerPage: 10,//每页记录数
        perPageOptions: [10, 20, 30, 40, 50],//分页选项
        onChange: function () {
            //当前页码变更事件
            $scope.reloadList();
        }
    }

    //刷新列表
    $scope.reloadList = function () {
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }


    //删除的元素集合
    $scope.selectIds = [];

    $scope.updateDeleteList = function ($event, id) {
        console.log(id);
        if ($event.target.checked) {
            $scope.selectIds.push(id);
        } else {
            var index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index,1);
        }
    }
    
    $scope.jsonToString = function (json,key) {
       var obj  = JSON.parse(json);
       var value = "";

        for (var i = 0; i < obj.length; i++) {
            value+=obj[i][key]
            if(i!=obj.length-1){
                value+=",";
            }
        }
        return value;
    }
});