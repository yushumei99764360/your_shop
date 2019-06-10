var USER = function () {

    var select = function () {
        var selectAge = document.getElementById("selectAge");
        var contents;

        for (let i = 1; i <= 100; i++) {
            contents += "<option>" + i + "</option>";
        }
        selectAge.innerHTML = contents;
    };
    return {
        initSelect: function () {
            select();
        }
    }
}();