app.service('uploadService',function ($http) {


    //上传文件
    this.uploadFile =function () {
        var formdata = new FormData();
        //                     file: 文件上传框的name ,取第一个文件上传框
        formdata.append('file',file.files[0]);

        return $http({
            url:'../upload.do',
            method:'post',
            data:formdata,
            headers:{'Content-Type':undefined},
            transformRequest:angular.identity

        })
    }
})