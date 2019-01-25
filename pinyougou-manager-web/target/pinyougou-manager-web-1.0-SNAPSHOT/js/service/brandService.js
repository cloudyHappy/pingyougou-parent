//品牌服务
app.service("brandService",function ($http) {
    this.findAll = function () {
        return $(http).get('../brand/getAll.do');
    }
    this.findPage = function (currentPage,pageSize) {
        return $http.get("../brand/findPage.do?currentPage=" + currentPage + "&pageSize=" + pageSize)
    }
    this.getTbrand = function (id) {
        return  $http.post("../brand/getById.do?id=" + id);
    }
    this.add = function (entity) {
        return $http.post("../brand/update.do",entity );
    }
    this.update = function (entity) {
        return $http.post("../brand/add.do", entity);
    }
    this.delete = function (deleteList) {
        return  $http.post("../brand/delete.do",deleteList);
    }
    this.search = function (currentPage,pageSize,searchEntity) {
        return $http.post("../brand/search.do?currentPage=" + currentPage + "&pageSize=" + pageSize,searchEntity
        );
    }
    this.selectOptionList = function () {
        return $http.get("../brand/selectOptionList.do")
    }

});