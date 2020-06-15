

/*********************************************************************************
자바 스크립트 로거
*********************************************************************************/

var logLevel = "DEBUG";

var _LOG = function(){

    this.debug = function(text){
        if(logLevel == "DEBUG" || logLevel == "WARN" || logLevel == "INFO" || logLevel == "ERROR")
            console.log("LOG : DEBUG : "  + text);
    }
    this.warn = function(text){
        if(logLevel == "WARN" || logLevel == "INFO" || logLevel == "ERROR")
            console.log("LOG : WARN : "  + text);
    }
    this.info = function(text){
        if(logLevel == "INFO" || logLevel == "ERROR")
            console.log("LOG : INFO : "  + text);
    }
    this.error = function(text){
        if(logLevel == "ERROR")
            console.log("LOG : ERROR : "  + text);
    }
}
// 초기화
var LOG = new _LOG();

/*********************************************************************************

*********************************************************************************/

/*
    statusbar hide
    특정시간 이후 스테이터스 바를 hide 시킨다.
*/
var fnHideStatusbar = function(id, sec) {
    setTimeout(function() {
        LOG.debug("hide statusbar : " + id);
        $("#" + id).hide();
    }, sec * 1000);
}

$(document).ready(function(){
    /*
        register statusbar hide event
        스테이스바 show 시 hide 이벤트를 등록한다.
    */
    $(".app-statusbar-open").on("click", function(){
        var id = $(this).attr("href").replace("#", "");
        fnHideStatusbar(id, 2);
    });
});

var enableStatusBars = true;

var _STATUSBAR = function(){

    //기본 노출 초
    var defaultSes = 2;

    this.success = function(ses){
        LOG.debug("show statusbar success");
        if(enableStatusBars === false) return;
        if (typeof ses === 'undefined' || ses === '' || ses === null){ ses = defaultSes; }

        var id = "greenStatusBarId";
        $("#" + id).show(); fnHideStatusbar(id, ses);
    }
    this.fail = function(ses){
        LOG.debug("show statusbar fail");
        if(enableStatusBars === false) return;
        if (typeof ses === 'undefined' || ses === '' || ses === null){ ses = defaultSes; }

        var id = "redStatusBarId";
        $("#" + id).show(); fnHideStatusbar(id, ses);
    }
    this.saving = function(ses){
        LOG.debug("show statusbar saving");
        if(enableStatusBars === false) return;
        if (typeof ses === 'undefined' || ses === '' || ses === null){ ses = defaultSes; }

        var id = "blackSavingStatusBarId";
        $("#" + id).show(); fnHideStatusbar(id, ses);
    }
}

var SBAR = new _STATUSBAR();

alert(SBAR);
console.log(SBAR);

/*********************************************************************************

*********************************************************************************/

/*
    SEND AJAX POST
*/
function POST (path, fName, sFn, fFn, qString) {

   LOG.debug("start POST function");

//   if (!(this instanceof arguments.callee )) return new arguments.callee(path, fName, sFn, fFn, qString);

    var callPath = path;
    var formName = fName;

    //------------------------------

    var sendData = $('#'+formName).serialize();
    console.log("sendData : "  + sendData);

    // 추가로 전달할 파리미터 전달
    if (typeof qString !== 'undefined' && qString !== '' && qString !== null){
        LOG.debug("add query String : " + qString);

        sendData += qString;
    }

    SBAR.saving();

    $.post({
        url : callPath,
        type : 'POST',
        data : sendData,
        dataType: "json",
        success : function(data) {
            SBAR.success();
            LOG.debug("show statusbar success");

            console.log(data);
            // var jsonObj = JSON.parse(data);
            if (typeof sFn !== 'undefined'){
                sFn(data);
            }
        }, // success
        error : function(xhr, status) {
            SBAR.fail();

            if (typeof fFn !== 'undefined'){
                fFn(xhr, status);
            }
        }
    }); // $.ajax */
};