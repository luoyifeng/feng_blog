(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-19730b5c"],{"11e9":function(e,t,n){var a=n("52a7"),i=n("4630"),r=n("6821"),o=n("6a99"),l=n("69a8"),s=n("c69a"),c=Object.getOwnPropertyDescriptor;t.f=n("9e1e")?c:function(e,t){if(e=r(e),t=o(t,!0),s)try{return c(e,t)}catch(n){}if(l(e,t))return i(!a.f.call(e,t),e[t])}},"28dd":function(e,t,n){"use strict";n.r(t);var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"manage-visit"},[n("el-tabs",{on:{"tab-click":e.handleClick},model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},[n("el-tab-pane",{attrs:{label:"未处理异常",name:"untreated"}}),n("el-tab-pane",{attrs:{label:"已处理异常",name:"treated"}})],1),n("el-form",{ref:"formInline",attrs:{inline:!0,model:e.formInline}},[n("el-form-item",{attrs:{label:"街路巷/小区"}},[n("el-select",{attrs:{placeholder:"请选择",clearable:"",filterable:"",size:"small"},model:{value:e.formInline.communityName,callback:function(t){e.$set(e.formInline,"communityName",t)},expression:"formInline.communityName"}},e._l(e.communityList,function(e,t){return n("el-option",{key:t,attrs:{label:e,value:e}})}))],1),n("el-form-item",{attrs:{label:"门牌号/楼栋号"}},[n("el-input",{attrs:{size:"small",placeholder:"请输入",clearable:""},model:{value:e.formInline.buildingName,callback:function(t){e.$set(e.formInline,"buildingName",t)},expression:"formInline.buildingName"}})],1),n("el-form-item",{attrs:{label:"单元"}},[n("el-input",{attrs:{size:"small",placeholder:"请输入",clearable:""},model:{value:e.formInline.houseUnit,callback:function(t){e.$set(e.formInline,"houseUnit",t)},expression:"formInline.houseUnit"}})],1),n("el-form-item",{attrs:{label:"房(室)号"}},[n("el-input",{attrs:{size:"small",placeholder:"请输入",clearable:""},model:{value:e.formInline.roomNo,callback:function(t){e.$set(e.formInline,"roomNo",t)},expression:"formInline.roomNo"}})],1),n("el-form-item",{attrs:{label:"异常类型"}},[n("el-select",{attrs:{size:"small",placeholder:"请选择",clearable:""},model:{value:e.formInline.abnormalType,callback:function(t){e.$set(e.formInline,"abnormalType",t)},expression:"formInline.abnormalType"}},[n("el-option",{attrs:{label:"用水异常",value:"用水异常"}}),n("el-option",{attrs:{label:"用水疑似空转租",value:"用水疑似空转租"}}),n("el-option",{attrs:{label:"空房购物",value:"空房购物"}})],1)],1),1==e.solveStatus?n("el-form-item",{attrs:{label:"房东姓名"}},[n("el-input",{attrs:{size:"small",placeholder:"请输入",clearable:""},model:{value:e.formInline.landlordName,callback:function(t){e.$set(e.formInline,"landlordName",t)},expression:"formInline.landlordName"}})],1):e._e(),0==e.solveStatus?n("el-form-item",{attrs:{label:"姓名"}},[n("el-input",{attrs:{size:"small",placeholder:"请输入",clearable:""},model:{value:e.formInline.commonName,callback:function(t){e.$set(e.formInline,"commonName",t)},expression:"formInline.commonName"}})],1):e._e(),n("el-form-item",{attrs:{label:"房屋特殊标注"}},[n("el-select",{attrs:{size:"small",multiple:"",filterable:"","allow-create":"","default-first-option":"",placeholder:"请选择"},on:{change:e.houseSpecialChange},model:{value:e.formInline.houseSpecialMarkArr,callback:function(t){e.$set(e.formInline,"houseSpecialMarkArr",t)},expression:"formInline.houseSpecialMarkArr"}},e._l(e.houseSpecialMarkGroups,function(t){return n("el-option-group",{key:t.label,attrs:{label:t.label}},e._l(t.options,function(e){return n("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}))}))],1),0==e.solveStatus?n("el-form-item",{attrs:{label:"房屋隐患"}},[n("el-select",{attrs:{placeholder:"请选择",clearable:"",size:"small"},model:{value:e.formInline.judgeDanger,callback:function(t){e.$set(e.formInline,"judgeDanger",t)},expression:"formInline.judgeDanger"}},[n("el-option",{attrs:{label:"房屋存在隐患",value:"1"}}),n("el-option",{attrs:{label:"房屋不存在隐患",value:"0"}})],1)],1):e._e(),0==e.solveStatus?n("el-form-item",{attrs:{label:"走访人员"}},[n("el-input",{attrs:{size:"small",placeholder:"请输入",clearable:""},model:{value:e.formInline.visitPerson,callback:function(t){e.$set(e.formInline,"visitPerson",t)},expression:"formInline.visitPerson"}})],1):e._e(),0==e.solveStatus?n("el-form-item",{attrs:{label:"核实人员"}},[n("el-input",{attrs:{size:"small",placeholder:"请输入",clearable:""},model:{value:e.formInline.checkPerson,callback:function(t){e.$set(e.formInline,"checkPerson",t)},expression:"formInline.checkPerson"}})],1):e._e(),0==e.solveStatus?n("el-form-item",{attrs:{label:"走访时间"}},[n("el-date-picker",{attrs:{type:"date","value-format":"yyyy-MM-dd",placeholder:"选择日期时间"},model:{value:e.formInline.visitDate,callback:function(t){e.$set(e.formInline,"visitDate",t)},expression:"formInline.visitDate"}})],1):e._e(),n("el-form-item",[n("el-button",{attrs:{type:"primary",size:"small"},on:{click:e.onQuery}},[e._v("查询")])],1)],1),n("div",{directives:[{name:"loading",rawName:"v-loading",value:e.isLoadingData,expression:"isLoadingData"}]},[n("el-table",{attrs:{data:e.tableData,border:""}},[n("el-table-column",{attrs:{label:"序号",type:"index",index:e.indexMethod,width:"56",align:"center"}}),n("el-table-column",{attrs:{prop:"abnormalType",label:"异常类型",width:"80"}}),n("el-table-column",{attrs:{prop:"standardScore",label:"Z分数超出百分比",width:"80"}}),n("el-table-column",{attrs:{prop:"shoppingTimes",label:"购物次数",width:"80"}}),n("el-table-column",{attrs:{prop:"emptyShopping",label:"疑似空房购物",width:"80"}}),n("el-table-column",{attrs:{prop:"emptyUseWater",label:"疑似空房用水",width:"80"}}),n("el-table-column",{attrs:{prop:"communityName",label:"街路巷/小区",width:"80"}}),n("el-table-column",{attrs:{prop:"apartmentNum",label:"门牌号/楼栋号",width:"80",align:"center"}}),n("el-table-column",{attrs:{prop:"houseUnit",label:"单元",width:"70",align:"center"}}),n("el-table-column",{attrs:{label:"房(室)号",width:"70",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-button",{attrs:{type:"text"},on:{click:function(n){e.gotoRoomInfo(t.row.proCollId)}}},[e._v(e._s(t.row.roomNum))])]}}])}),n("el-table-column",{attrs:{prop:"houseStatus",label:"房屋状态",align:"center",width:"80"}}),n("el-table-column",{attrs:{prop:"houseDanger",label:"房屋隐患情况",align:"center",width:"100"}}),n("el-table-column",{attrs:{prop:"houseSpecialMark",label:"房屋特殊标注",align:"center",width:"100"}}),n("el-table-column",{attrs:{align:"center",label:"房东信息",width:"115"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("span",[e._v(e._s(t.row.landlordName))]),e._v(" - "),n("span",[e._v(e._s(t.row.landlordId))])]}}])}),n("el-table-column",{attrs:{prop:"landlordPhone",label:"房东联系方式",width:"115",align:"center"}}),n("el-table-column",{attrs:{prop:"judgeAbnormalTime",label:"判断时间",width:"100",align:"center"}}),n("el-table-column",{attrs:{prop:"officerName",label:"负责人",width:"80",align:"center"}}),n("el-table-column",{attrs:{prop:"officerPhone",label:"负责人联系方式",width:"115",align:"center"}}),n("el-table-column",{attrs:{prop:"operate",label:"操作",width:"100",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return["untreated"===e.activeName?n("div",[n("el-button",{attrs:{type:"text"},on:{click:function(n){e.showPrintingDialog(t.row.proCollId)}}},[e._v("打印")]),n("el-button",{attrs:{type:"text"},on:{click:function(n){e.gotoFeedback(t.row.proCollId,t.row.id)}}},[e._v("反馈")])],1):n("div",[n("el-button",{attrs:{type:"text"},on:{click:function(n){e.showResultDialog(t.row.proCollId)}}},[e._v("结果查询")])],1)]}}])})],1),n("el-pagination",{staticStyle:{"text-align":"right",padding:"20px 0"},attrs:{background:"",layout:"total, prev, pager, next","current-page":e.currentPage,"page-size":e.pageSize,total:e.totalSize},on:{"current-change":e.onCurrentChange}})],1),n("printing-dialog",{ref:"printingDialog",attrs:{showType:e.showType,printingId:e.printingId}}),n("visit-printing",{ref:"visitPrinting",attrs:{showType:e.showType,printingId:e.printingId}})],1)},i=[],r=(n("96cf"),n("1da1")),o=(n("7f7f"),n("a78e")),l=n.n(o),s=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-dialog",{attrs:{top:"5vh",width:"900",title:e.dialogTitle,visible:e.dialogVisible},on:{close:e.handleClose}},[n("div",{directives:[{name:"loading",rawName:"v-loading",value:e.resultSearchLoading,expression:"resultSearchLoading"}],attrs:{id:"printBox"}},[n("div",{staticClass:"checkInfo",staticStyle:{position:"relative"}},[n("h4",{staticStyle:{"border-bottom":"1px solid #eee","padding-bottom":"20px","margin-bottom":"0"}},[e._v("核实信息 "),n("span",[e._v(e._s(e.checkResidentInfo?e.checkResidentInfo.createTime:""))])]),n("div",{staticClass:"list-box"},[n("el-row",{staticClass:"msg-box"},[n("el-col",{attrs:{span:24}},[n("div",{staticClass:"grid-content bg-purple"},[n("span",[e._v("房屋信息："+e._s(e.abnormalInfo?e.abnormalInfo.communityName+"-"+e.abnormalInfo.apartmentNum+e.abnormalInfo.houseUnit+e.abnormalInfo.roomNum:""))])])])],1),n("el-row",{staticClass:"msg-box"},[n("el-col",{attrs:{span:12}},[n("div",{staticClass:"grid-content bg-purple-light"},[n("span",[e._v("房屋状态："+e._s(e.abnormalInfo?e.abnormalInfo.houseStatus:""))])])]),n("el-col",{attrs:{span:12}},[n("div",{staticClass:"grid-content bg-purple-light"},[n("span",[e._v("房主信息："+e._s(e.abnormalInfo?e.abnormalInfo.landlordName+" "+e.abnormalInfo.landlordId:""))])])])],1),n("el-row",{staticClass:"msg-box"},[n("el-col",{attrs:{span:12}},[n("div",{staticClass:"grid-content bg-purple-light"},[n("span",[e._v("房主联系方式："+e._s(e.abnormalInfo?e.abnormalInfo.landlordPhone:""))])])]),n("el-col",{attrs:{span:12}},[n("div",{staticClass:"grid-content bg-purple"},[n("span",[e._v("走访原因："+e._s(e.abnormalInfo?e.abnormalInfo.abnormalType:""))])])])],1)],1),n("ul",{staticClass:"type-list"},[n("li",{staticClass:"switch-active",style:{display:null!=e.checkResidentInfo&&null!=e.checkResidentInfo.personTags&&-1!=e.checkResidentInfo.personTags.indexOf("重点人员")?"inline-block":"none"}},[e._v("重点")]),n("li",{staticClass:"switch-active",style:{display:null!=e.checkResidentInfo&&null!=e.checkResidentInfo.personTags&&-1!=e.checkResidentInfo.personTags.indexOf("风险人员")?"inline-block":"none"}},[e._v("风险")]),n("li",{staticClass:"switch-active",style:{display:null!=e.checkResidentInfo&&null!=e.checkResidentInfo.personTags&&-1!=e.checkResidentInfo.personTags.indexOf("涉案人员")?"inline-block":"none"}},[e._v("涉案")])]),n("br")]),n("div",{staticClass:"checkResult"},[n("h4",{staticStyle:{"border-bottom":"1px solid #eee","padding-bottom":"20px","margin-bottom":"0"}},[e._v("入住人员信息 ")]),n("section",{staticClass:"basic-info__content"},[n("el-table",{staticStyle:{width:"100%"},attrs:{data:null==e.checkResidentInfo||null==e.checkResidentInfo.residentsInfo?[]:e.checkResidentInfo.residentsInfo,border:""}},[n("el-table-column",{attrs:{prop:"name",align:"center",label:"姓名"}}),n("el-table-column",{attrs:{prop:"relation",align:"center",label:"关系"}}),n("el-table-column",{attrs:{prop:"sex",align:"center",label:"性别"}}),n("el-table-column",{attrs:{prop:"nation",align:"center",label:"民族"}}),n("el-table-column",{attrs:{prop:"idNumber",align:"center",label:"公民身份证号码"}}),n("el-table-column",{attrs:{prop:"permanentAddress",align:"center",label:"户籍地址"}}),n("el-table-column",{attrs:{prop:"outflow",align:"center",label:"是否流出"}}),n("el-table-column",{attrs:{prop:"outflowInfo",align:"center",label:"流出原因及详址"}}),n("el-table-column",{attrs:{prop:"caseBackGround",align:"center",label:"案底情况"}}),n("el-table-column",{attrs:{prop:"workPlace",align:"center",label:"工作单位/服务处所"}}),n("el-table-column",{attrs:{prop:"post",align:"center",label:"职务"}}),n("el-table-column",{attrs:{prop:"phone",align:"center",label:"联系方式"}}),n("el-table-column",{attrs:{prop:"checkPerson",align:"center",label:"核实人员"}}),n("el-table-column",{attrs:{prop:"checkPersonPhone",align:"center",label:"核实人员电话"}}),n("el-table-column",{attrs:{prop:"visitPerson",align:"center",label:"走访人员"}})],1)],1),n("h4",{staticStyle:{"border-bottom":"1px solid #eee","padding-bottom":"20px","margin-bottom":"0"}},[e._v("房屋安全隐患情况 ")]),n("section",{staticClass:"basic-info__content"},[n("table",{staticClass:"basic-table"},[n("tr",[n("td",{staticStyle:{width:"35%"}},[e._v("人员隐患")]),n("td",[e._v(e._s(e.checkResidentInfo?e.checkResidentInfo.hiddenDanger&&e.checkResidentInfo.hiddenDanger.personDanger:""))])]),n("tr",[n("td",{staticStyle:{width:"35%"}},[e._v("房屋隐患")]),n("td",[e._v(e._s(e.checkResidentInfo?e.checkResidentInfo.hiddenDanger&&e.checkResidentInfo.hiddenDanger.houseDanger:""))])])])])])]),"print"===e.showType?n("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{attrs:{size:"small",type:"success"},on:{click:e.onDownload}},[e._v("下载")]),n("el-button",{attrs:{size:"small",type:"success"},on:{click:e.onPrintFun}},[e._v("打印")]),n("el-button",{attrs:{size:"small",type:"primary"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("确 定")])],1):n("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{attrs:{size:"small"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),n("el-button",{attrs:{size:"small",type:"primary"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("确 定")])],1)])},c=[],u=(n("ac6a"),n("28a5"),n("c5f6"),n("3748")),p=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticStyle:{"margin-top":"10px"}},[n("el-table",{attrs:{data:e.data,border:"","cell-style":e.cellStyle}},[n("el-table-column",{attrs:{label:"姓名",width:"80",align:"center",prop:"name"}}),n("el-table-column",{attrs:{label:"证件类型",width:"100",align:"center",prop:"certificateType"}}),n("el-table-column",{attrs:{label:"证件号码",width:"100",align:"center",prop:"certificateNo"}}),n("el-table-column",{attrs:{label:"性别",width:"60",align:"center",prop:"sex"}}),n("el-table-column",{attrs:{label:"人员类别",width:"100",align:"center",prop:"personCategory"}}),n("el-table-column",{attrs:{label:"户籍地址",align:"center",prop:"residenceAddress"}}),n("el-table-column",{attrs:{label:"联系方式",width:"125",align:"center",prop:"contactInfo"}})],1)],1)},d=[],m={props:{data:{type:Array}},methods:{cellStyle:function(){return{padding:"5px 0"}}}},f=m,h=(n("474c"),n("2877")),b=Object(h["a"])(f,p,d,!1,null,"1c473036",null);b.options.__file="people-table.vue";var g=b.exports,v=n("c400"),y={name:"ResultDialog",components:{PeopleTable:g},props:{printingId:{type:[String,Number]},showType:{type:String}},data:function(){return{dialogVisible:!1,infoList:{},data:[],switchType:"1",activeNames:[0],basicHouseInfo:{},abnormalInfo:{},checkFormResponses:[],checkResidentInfo:{},hiddenDanger:{},resultSearchLoading:!1}},methods:{handleChange:function(e){""!=e&&(this.hiddenDanger=this.checkFormResponses[e].hiddenDanger)},handleClose:function(e){this.dialogVisible=!1},show:function(){this.dialogVisible=!0},onPrintFun:function(){var e=new u["Printd"];e.print(document.getElementById("printBox"))},getServer:function(){var e=Object(r["a"])(regeneratorRuntime.mark(function e(t){var n=this;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:this.resultSearchLoading=!0,v["a"].getFeedbackResult({proCollId:t}).then(function(e){n.abnormalInfo=e.data.abnormalInfo,n.checkFormResponses=e.data.checkFormResponses,n.checkResidentInfo=e.data.checkResidentInfo,n.resultSearchLoading=!1});case 2:case"end":return e.stop()}},e,this)}));return function(t){return e.apply(this,arguments)}}(),splitMessage:function(e){var t='<span style="line-height:20px">'+e.split("；").join('</span><br><span style="line-height:20px">')+"</span>";return t},contactMessage:function(e){return e.join(",")},extractMessage:function(e){var t="";return e.forEach(function(e){t+=e.name+"，",t+="联系方式："+e.contactInfo+"；"}),this.splitMessage(t)},onDownload:function(){this.printingId&&(window.open("http://popc.jd.com/survey/visit/check/form/print?proCollId="+this.printingId),this.dialogVisible=!1)},changeSwitchType:function(e){this.switchType=e}},watch:{printingId:function(e){this.getServer(e)}},computed:{dialogTitle:function(){return"print"===this.showType?"打印核实单":"走访核实单"}}},I=y,k=(n("8acd"),Object(h["a"])(I,s,c,!1,null,"2e655754",null));k.options.__file="PrintingDialog.vue";var w=k.exports,x=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-dialog",{attrs:{top:"5vh",width:"900",title:"打印核实单",visible:e.dialogVisible},on:{close:e.handleClose}},[n("div",{directives:[{name:"loading",rawName:"v-loading",value:e.printLoading,expression:"printLoading"}],attrs:{id:"printBox"}},[n("div",{staticClass:"checkInfo",staticStyle:{position:"relative"}},[n("h4",{staticStyle:{"border-bottom":"1px solid #eee",padding:"20px 0",margin:"0"}},[e._v("核实信息")]),n("section",{staticStyle:{padding:"10px"}},[n("span",{staticStyle:{display:"inline-block",width:"110px","text-align":"right","margin-right":"10px"}},[e._v("房屋信息:")]),n("span",[e._v(e._s(e.abnormalInfo?e.abnormalInfo.communityName+"-"+e.abnormalInfo.apartmentNum+e.abnormalInfo.houseUnit+e.abnormalInfo.roomNum:""))])]),n("section",{staticStyle:{padding:"10px"}},[n("span",{staticStyle:{display:"inline-block",width:"110px","text-align":"right","margin-right":"10px"}},[e._v("房主信息:")]),n("span",[e._v(e._s(e.abnormalInfo?e.abnormalInfo.landlordName+" "+e.abnormalInfo.landlordId+",联系方式"+e.abnormalInfo.landlordPhone:""))])]),n("section",{staticStyle:{padding:"10px"}},[n("span",{staticStyle:{display:"inline-block",width:"110px","text-align":"right","margin-right":"10px"}},[e._v("走访原因:")]),n("span",[e._v(e._s(e.abnormalInfo?e.abnormalInfo.abnormalType:""))])]),n("section",{staticStyle:{padding:"10px"}},[n("span",{staticStyle:{display:"inline-block",width:"110px","text-align":"right","margin-right":"10px"}},[e._v("房屋状态:")]),n("span",[e._v(e._s(e.abnormalInfo?e.abnormalInfo.houseStatus:""))])])]),n("div",{staticClass:"checkResult"},[n("h4",{staticStyle:{"border-bottom":"1px solid #eee","padding-bottom":"20px","margin-bottom":"0"}},[e._v("历史信息")]),n("section",{staticClass:"basic-info__content",staticStyle:{padding:"10px",overflow:"hidden"}},[n("span",{staticStyle:{float:"left",width:"110px","text-align":"right","margin-right":"10px","border-bottom":"1px solid #eee","padding-bottom":"20px","margin-bottom":"0"}},[e._v("入住人员信息:")]),n("el-table",{staticStyle:{width:"100%"},attrs:{data:null==e.checkResidentInfo||null==e.checkResidentInfo.residentsInfo?[]:e.checkResidentInfo.residentsInfo,border:""}},[n("el-table-column",{attrs:{prop:"name",align:"center",label:"姓名"}}),n("el-table-column",{attrs:{prop:"relation",align:"center",label:"关系"}}),n("el-table-column",{attrs:{prop:"sex",align:"center",label:"性别"}}),n("el-table-column",{attrs:{prop:"nation",align:"center",label:"民族"}}),n("el-table-column",{attrs:{prop:"idNumber",align:"center",label:"公民身份证号码"}}),n("el-table-column",{attrs:{prop:"permanentAddress",align:"center",label:"户籍地址"}}),n("el-table-column",{attrs:{prop:"outflow",align:"center",label:"是否流出"}}),n("el-table-column",{attrs:{prop:"outflowInfo",align:"center",label:"流出原因及详址"}}),n("el-table-column",{attrs:{prop:"caseBackGround",align:"center",label:"案底情况"}}),n("el-table-column",{attrs:{prop:"workPlace",align:"center",label:"工作单位/服务处所"}}),n("el-table-column",{attrs:{prop:"post",align:"center",label:"职务"}}),n("el-table-column",{attrs:{prop:"phone",align:"center",label:"联系方式"}}),n("el-table-column",{attrs:{prop:"checkPerson",align:"center",label:"核实人员"}}),n("el-table-column",{attrs:{prop:"checkPersonPhone",align:"center",label:"核实人员电话"}}),n("el-table-column",{attrs:{prop:"visitPerson",align:"center",label:"走访人员"}})],1)],1),n("section",{staticStyle:{padding:"10px",overflow:"hidden"}},[n("span",{staticStyle:{float:"left",width:"110px","text-align":"right","margin-right":"10px"}},[e._v("核实人员:")]),n("div",{staticStyle:{float:"left"}},[n("span",[e._v(e._s(e.checkResidentInfo?e.extractMessage(e.checkResidentInfo.checkPersons):""))])])]),n("section",{staticStyle:{padding:"10px"}},[n("span",{staticStyle:{display:"inline-block",width:"110px","text-align":"right","margin-right":"10px"}},[e._v("走访人员:")]),n("span",[e._v(e._s(e.checkResidentInfo?e.contactMessage(e.checkResidentInfo.visitPersons):""))])])])]),n("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{attrs:{size:"small",type:"success"},on:{click:e.onDownload}},[e._v("下载")]),n("el-button",{attrs:{size:"small",type:"success"},on:{click:e.onPrintFun}},[e._v("打印")]),n("el-button",{attrs:{size:"small",type:"primary"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("确 定")])],1)])},S=[],_=n("f121"),N={name:"visitPrinting",components:{PeopleTable:g},props:{printingId:{type:[String,Number]},showType:{type:String}},data:function(){return{dialogVisible:!1,infoList:{},data:[],switchType:"1",activeNames:[0],basicHouseInfo:{},abnormalInfo:{},checkFormResponses:[],checkResidentInfo:{},hiddenDanger:{houseDanger:"",personDanger:""},printLoading:!0}},methods:{getBasicHouseInfo:function(){this.abnormalInfo},handleChange:function(e){""!=e&&(this.hiddenDanger=this.checkFormResponses[e].hiddenDanger)},handleClose:function(e){this.dialogVisible=!1},show:function(){this.dialogVisible=!0},onPrintFun:function(){var e=new u["Printd"];e.print(document.getElementById("printBox"))},getServer:function(){var e=Object(r["a"])(regeneratorRuntime.mark(function e(t){var n=this;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return this.printLoading=!0,e.next=3,v["a"].getFeedbackResult({proCollId:t}).then(function(e){n.abnormalInfo=e.data.abnormalInfo,n.checkFormResponses=e.data.checkFormResponses,n.checkResidentInfo=e.data.checkResidentInfo});case 3:this.printLoading=!1;case 4:case"end":return e.stop()}},e,this)}));return function(t){return e.apply(this,arguments)}}(),splitMessage:function(e){var t='<span style="line-height:20px">'+e.split("；").join('</span><br><span style="line-height:20px">')+"</span>";return t},residentInfoMessage:function(e){if(void 0!=e){var t="";for(var n in e[0])t+='<span style="line-height:20px">'+n+':</span><span style="line-height:20px">'+e[n]+"</span><br>";var a=t;return a}},contactMessage:function(e){if(e)return e.join(",")},extractMessage:function(e){if(void 0!=e&&null!=e){var t="";return e.forEach(function(e){t+=e.name+"，",t+="联系方式："+e.contactInfo+"；"}),t}},onDownload:function(){this.printingId&&(window.open(_["a"].LOCAL+"/survey/visit/check/form/print?proCollId="+this.printingId),this.dialogVisible=!1)},changeSwitchType:function(e){this.switchType=e}},watch:{printingId:function(e){this.getServer(e)}}},C=N,R=(n("904d"),Object(h["a"])(C,x,S,!1,null,"666924fc",null));R.options.__file="visit-printing.vue";var P=R.exports,L={components:{PrintingDialog:w,VisitPrinting:P},data:function(){return{activeName:"untreated",formInline:{communityName:"",buildingName:"",houseUnit:"",roomNo:"",abnormalType:"",userName:"",landlordName:"",commonName:"",houseSpecialMarkArr:"",houseSpecialMark:"",judgeDanger:"",visitPerson:"",checkPerson:"",visitDate:""},value:"",tableData:[],currentPage:1,totalSize:0,pageSize:10,printingId:"",showType:"",solveStatus:1,officerNo:"",communityList:[],houseSpecialMarkGroups:[{label:"",options:[{value:"无",label:"无"}]},{label:"特殊标记",options:[{value:"重点人员",label:"重点人员"},{value:"风险人员",label:"风险人员"},{value:"涉案人员",label:"涉案人员"}]}],isLoadingData:!1}},mounted:function(){var e=this,t=sessionStorage.getItem("formValue");t&&(this.formInline=JSON.parse(t)),l.a.get("officerNo")&&(this.officerNo=l.a.get("officerNo")),this.getTableList(),v["a"].queryAllCommunity().then(function(t){e.communityList=t.data})},methods:{houseSpecialChange:function(e,t){"无"==e[e.length-1]?this.formInline.houseSpecialMarkArr=["无"]:-1!=this.formInline.houseSpecialMarkArr.indexOf("无")&&this.formInline.houseSpecialMarkArr.splice(this.formInline.houseSpecialMarkArr.indexOf("无"),1),this.formInline.houseSpecialMark=this.formInline.houseSpecialMarkArr.join(",")},handleClick:function(e){var t=e.name;this.solveStatus="treated"===t?0:1,this.$refs.formInline.resetFields(),this.tableData=[],this.totalSize=0,this.getTableList()},onQuery:function(){this.currentPage=1,this.getTableList(),sessionStorage.setItem("formValue",JSON.stringify(this.formInline))},indexMethod:function(e){return e+this.pageSize*(this.currentPage-1)+1},gotoRoomInfo:function(e){this.$router.push({path:"/room-info",query:{proCollId:e}})},gotoFeedback:function(e,t){this.$router.push({path:"/visit-feedback",query:{proCollId:e,id:t}})},showResultDialog:function(e){this.showType="result",this.printingId=e,this.$refs.printingDialog.show()},showPrintingDialog:function(e){this.showType="print",this.printingId=e,this.$refs.visitPrinting.show()},getTableList:function(){var e=Object(r["a"])(regeneratorRuntime.mark(function e(){var t=this;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return this.isLoadingData=!0,e.next=3,v["a"].getHouseInfo({communityName:this.formInline.communityName,apartmentNum:this.formInline.buildingName,houseUnit:this.formInline.houseUnit,roomNum:this.formInline.roomNo,abnormalType:this.formInline.abnormalType,landlordName:this.formInline.landlordName,commonName:this.formInline.commonName,houseSpecialMark:this.formInline.houseSpecialMark,judgeDanger:this.formInline.judgeDanger,visitPerson:this.formInline.visitPerson,checkPerson:this.formInline.checkPerson,visitDate:this.formInline.visitDate,solveStatus:this.solveStatus,currentPage:this.currentPage,totalSize:this.pageSize,officerNo:this.officerNo}).then(function(e){t.tableData=e.data,t.totalSize=e.totalSize});case 3:this.isLoadingData=!1;case 4:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),onCurrentChange:function(e){this.currentPage=e,this.getTableList()}}},T=L,D=(n("809e"),Object(h["a"])(T,a,i,!1,null,"3b747a98",null));D.options.__file="index.vue";t["default"]=D.exports},3748:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=/^(((http[s]?)|file):)?(\/\/)+([0-9a-zA-Z-_.=?&].+)$/g,i=/^([\.]?\/)([0-9a-zA-Z-_.=?&]+\/)*([0-9a-zA-Z-_.=?&]+)$/g,r=function(e){return a.test(e)||i.test(e)};function o(e,t){var n=e.createElement("style");return n.type="text/css",n.appendChild(window.document.createTextNode(t)),n}function l(e,t){var n=e.createElement("link");return n.type="text/css",n.rel="stylesheet",n.href=t,n}function s(e){var t=window.document.createElement("iframe"),n="visibility:hidden;width:0;height:0;position:absolute;z-index:-9999;bottom:0;";return t.setAttribute("src","about:blank"),t.setAttribute("style",n),t.setAttribute("width","0"),t.setAttribute("height","0"),t.setAttribute("wmode","opaque"),e.appendChild(t),t}t.createStyle=o,t.createLinkStyle=l,t.createIFrame=s;var c={parent:window.document.body,headElements:[],bodyElements:[]},u=function(){function e(e){this.isLoading=!1,this.hasEvents=!1,this.opts=Object.assign(c,e||{}),this.iframe=s(this.opts.parent)}return e.prototype.getIFrame=function(){return this.iframe},e.prototype.print=function(e,t,n,a){if(!this.isLoading){var i=this.iframe,s=i.contentDocument,c=i.contentWindow;if(s&&c&&(this.iframe.src="about:blank",this.elCopy=e.cloneNode(!0),this.elCopy)){this.isLoading=!0,this.callback=a;var u=c.document;u.open(),u.write('<!DOCTYPE html><html><head><meta charset="utf-8"></head><body></body></html>'),this.addEvents();var p=this.opts,d=p.headElements,m=p.bodyElements;Array.isArray(d)&&d.forEach(function(e){return u.head.appendChild(e)}),Array.isArray(m)&&m.forEach(function(e){return u.body.appendChild(e)}),Array.isArray(t)&&t.forEach(function(e){e&&(r(e)?u.head.appendChild(l(u,e)):u.head.appendChild(o(u,e)))}),u.body.appendChild(this.elCopy),Array.isArray(n)&&n.forEach(function(e){if(e){var t=u.createElement("script");r(e)?t.src=e:t.innerText=e,u.body.appendChild(t)}}),u.close()}}},e.prototype.printURL=function(e,t){this.isLoading||(this.addEvents(),this.isLoading=!0,this.callback=t,this.iframe.src=e)},e.prototype.launchPrint=function(e){var t=e.document.execCommand("print",!1,null);t||e.print()},e.prototype.addEvents=function(){var e=this;this.hasEvents||(this.hasEvents=!0,this.iframe.addEventListener("load",function(){return e.onLoad()},!1))},e.prototype.onLoad=function(){var e=this;if(this.iframe){this.isLoading=!1;var t=this.iframe,n=t.contentDocument,a=t.contentWindow;if(!n||!a)return;this.callback?this.callback({iframe:this.iframe,element:this.elCopy,launchPrint:function(){return e.launchPrint(a)}}):this.launchPrint(a)}},e}();t.Printd=u,t.default=u},"474c":function(e,t,n){"use strict";var a=n("5fb5"),i=n.n(a);i.a},"52a7":function(e,t){t.f={}.propertyIsEnumerable},"5dbc":function(e,t,n){var a=n("d3f4"),i=n("8b97").set;e.exports=function(e,t,n){var r,o=t.constructor;return o!==n&&"function"==typeof o&&(r=o.prototype)!==n.prototype&&a(r)&&i&&i(e,r),e}},"5fb5":function(e,t,n){},"748a":function(e,t,n){},"809e":function(e,t,n){"use strict";var a=n("9fe6"),i=n.n(a);i.a},"8acd":function(e,t,n){"use strict";var a=n("748a"),i=n.n(a);i.a},"8b97":function(e,t,n){var a=n("d3f4"),i=n("cb7c"),r=function(e,t){if(i(e),!a(t)&&null!==t)throw TypeError(t+": can't set as prototype!")};e.exports={set:Object.setPrototypeOf||("__proto__"in{}?function(e,t,a){try{a=n("9b43")(Function.call,n("11e9").f(Object.prototype,"__proto__").set,2),a(e,[]),t=!(e instanceof Array)}catch(i){t=!0}return function(e,n){return r(e,n),t?e.__proto__=n:a(e,n),e}}({},!1):void 0),check:r}},"904d":function(e,t,n){"use strict";var a=n("e9cf"),i=n.n(a);i.a},9093:function(e,t,n){var a=n("ce10"),i=n("e11e").concat("length","prototype");t.f=Object.getOwnPropertyNames||function(e){return a(e,i)}},"9fe6":function(e,t,n){},aa77:function(e,t,n){var a=n("5ca1"),i=n("be13"),r=n("79e5"),o=n("fdef"),l="["+o+"]",s="​",c=RegExp("^"+l+l+"*"),u=RegExp(l+l+"*$"),p=function(e,t,n){var i={},l=r(function(){return!!o[e]()||s[e]()!=s}),c=i[e]=l?t(d):o[e];n&&(i[n]=c),a(a.P+a.F*l,"String",i)},d=p.trim=function(e,t){return e=String(i(e)),1&t&&(e=e.replace(c,"")),2&t&&(e=e.replace(u,"")),e};e.exports=p},ac6a:function(e,t,n){for(var a=n("cadf"),i=n("0d58"),r=n("2aba"),o=n("7726"),l=n("32e9"),s=n("84f2"),c=n("2b4c"),u=c("iterator"),p=c("toStringTag"),d=s.Array,m={CSSRuleList:!0,CSSStyleDeclaration:!1,CSSValueList:!1,ClientRectList:!1,DOMRectList:!1,DOMStringList:!1,DOMTokenList:!0,DataTransferItemList:!1,FileList:!1,HTMLAllCollection:!1,HTMLCollection:!1,HTMLFormElement:!1,HTMLSelectElement:!1,MediaList:!0,MimeTypeArray:!1,NamedNodeMap:!1,NodeList:!0,PaintRequestList:!1,Plugin:!1,PluginArray:!1,SVGLengthList:!1,SVGNumberList:!1,SVGPathSegList:!1,SVGPointList:!1,SVGStringList:!1,SVGTransformList:!1,SourceBufferList:!1,StyleSheetList:!0,TextTrackCueList:!1,TextTrackList:!1,TouchList:!1},f=i(m),h=0;h<f.length;h++){var b,g=f[h],v=m[g],y=o[g],I=y&&y.prototype;if(I&&(I[u]||l(I,u,d),I[p]||l(I,p,g),s[g]=d,v))for(b in a)I[b]||r(I,b,a[b],!0)}},c400:function(e,t,n){"use strict";n("96cf");var a=n("1da1"),i={manageVisit:{API:{getAbnormalList:"/survey/visit/queryByCondition",getFormInfo:"/survey/visit/check/form/queryLastFeedbackByProCollId",postSaveMessage:"/survey/visit/check/form/save",checkResult:"/survey/visit/checkSurveyResultById",queryAllCommunity:"/community/officer/queryAllCommunity",getFeedbackResult:"/survey/visit/check/form/queryFeedbackResultByProCollId",getCaseBackGround:"/survey/visit/check/form/getCaseBackGround"}}},r=i,o=n("7c15"),l=r.manageVisit.API;t["a"]={getHouseInfo:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,o["a"].get(l["getAbnormalList"],t);case 3:return n=e.sent,e.abrupt("return",n);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),getFormInfo:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,o["a"].get(l["getFormInfo"],t);case 3:return n=e.sent,e.abrupt("return",n);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),postSaveMessage:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,o["a"].post(l["postSaveMessage"],t);case 3:return n=e.sent,e.abrupt("return",n);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),checkResult:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,o["a"].post(l["checkResult"],t);case 3:return n=e.sent,e.abrupt("return",n);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),queryAllCommunity:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,o["a"].get(l["queryAllCommunity"],t);case 3:return n=e.sent,e.abrupt("return",n);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),getFeedbackResult:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,o["a"].get(l["getFeedbackResult"],t);case 3:return n=e.sent,e.abrupt("return",n);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),getCaseBackGround:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,o["a"].get(l["getCaseBackGround"],t);case 3:return n=e.sent,e.abrupt("return",n);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}()}},c5f6:function(e,t,n){"use strict";var a=n("7726"),i=n("69a8"),r=n("2d95"),o=n("5dbc"),l=n("6a99"),s=n("79e5"),c=n("9093").f,u=n("11e9").f,p=n("86cc").f,d=n("aa77").trim,m="Number",f=a[m],h=f,b=f.prototype,g=r(n("2aeb")(b))==m,v="trim"in String.prototype,y=function(e){var t=l(e,!1);if("string"==typeof t&&t.length>2){t=v?t.trim():d(t,3);var n,a,i,r=t.charCodeAt(0);if(43===r||45===r){if(n=t.charCodeAt(2),88===n||120===n)return NaN}else if(48===r){switch(t.charCodeAt(1)){case 66:case 98:a=2,i=49;break;case 79:case 111:a=8,i=55;break;default:return+t}for(var o,s=t.slice(2),c=0,u=s.length;c<u;c++)if(o=s.charCodeAt(c),o<48||o>i)return NaN;return parseInt(s,a)}}return+t};if(!f(" 0o1")||!f("0b1")||f("+0x1")){f=function(e){var t=arguments.length<1?0:e,n=this;return n instanceof f&&(g?s(function(){b.valueOf.call(n)}):r(n)!=m)?o(new h(y(t)),n,f):y(t)};for(var I,k=n("9e1e")?c(h):"MAX_VALUE,MIN_VALUE,NaN,NEGATIVE_INFINITY,POSITIVE_INFINITY,EPSILON,isFinite,isInteger,isNaN,isSafeInteger,MAX_SAFE_INTEGER,MIN_SAFE_INTEGER,parseFloat,parseInt,isInteger".split(","),w=0;k.length>w;w++)i(h,I=k[w])&&!i(f,I)&&p(f,I,u(h,I));f.prototype=b,b.constructor=f,n("2aba")(a,m,f)}},e9cf:function(e,t,n){},fdef:function(e,t){e.exports="\t\n\v\f\r   ᠎             　\u2028\u2029\ufeff"}}]);
//# sourceMappingURL=chunk-19730b5c.f8e6022b.js.map