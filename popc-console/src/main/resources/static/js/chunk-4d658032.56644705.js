(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4d658032"],{"0098":function(e,t,a){},2094:function(e,t,a){"use strict";var l=a("0098"),n=a.n(l);n.a},"456d":function(e,t,a){var l=a("4bf8"),n=a("0d58");a("5eda")("keys",function(){return function(e){return n(l(e))}})},"5eda":function(e,t,a){var l=a("5ca1"),n=a("8378"),o=a("79e5");e.exports=function(e,t){var a=(n.Object||{})[e]||Object[e],i={};i[e]=t(a),l(l.S+l.F*o(function(){a(1)}),"Object",i)}},ac6a:function(e,t,a){for(var l=a("cadf"),n=a("0d58"),o=a("2aba"),i=a("7726"),r=a("32e9"),s=a("84f2"),u=a("2b4c"),c=u("iterator"),p=u("toStringTag"),d=s.Array,m={CSSRuleList:!0,CSSStyleDeclaration:!1,CSSValueList:!1,ClientRectList:!1,DOMRectList:!1,DOMStringList:!1,DOMTokenList:!0,DataTransferItemList:!1,FileList:!1,HTMLAllCollection:!1,HTMLCollection:!1,HTMLFormElement:!1,HTMLSelectElement:!1,MediaList:!0,MimeTypeArray:!1,NamedNodeMap:!1,NodeList:!0,PaintRequestList:!1,Plugin:!1,PluginArray:!1,SVGLengthList:!1,SVGNumberList:!1,SVGPathSegList:!1,SVGPointList:!1,SVGStringList:!1,SVGTransformList:!1,SourceBufferList:!1,StyleSheetList:!0,TextTrackCueList:!1,TextTrackList:!1,TouchList:!1},f=n(m),b=0;b<f.length;b++){var h,v=f[b],g=m[v],S=i[v],w=S&&S.prototype;if(w&&(w[c]||r(w,c,d),w[p]||r(w,p,v),s[v]=d,g))for(h in l)w[h]||o(w,h,l[h],!0)}},ad25:function(e,t,a){"use strict";a.r(t);var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"manage-water"},[e.showTable?a("div",[a("div",[a("el-form",{staticClass:"form-inline",attrs:{inline:!0,model:e.formInline}},[a("el-form-item",{attrs:{label:"房屋状态"}},[a("el-select",{attrs:{placeholder:"请选择",clearable:"",size:"small"},model:{value:e.formInline.houseStatus,callback:function(t){e.$set(e.formInline,"houseStatus",t)},expression:"formInline.houseStatus"}},[a("el-option",{attrs:{label:"自住",value:"自住"}}),a("el-option",{attrs:{label:"出租",value:"出租"}}),a("el-option",{attrs:{label:"空置",value:"空置"}}),a("el-option",{attrs:{label:"待核",value:"待核"}}),a("el-option",{attrs:{label:"其他",value:"其他"}})],1)],1),a("el-form-item",{attrs:{label:"状态"}},[a("el-select",{attrs:{placeholder:"请选择",clearable:"",size:"small"},model:{value:e.formInline.houseWaterStatus,callback:function(t){e.$set(e.formInline,"houseWaterStatus",t)},expression:"formInline.houseWaterStatus"}},[a("el-option",{attrs:{label:"全部",value:"全部"}}),a("el-option",{attrs:{label:"异常",value:"异常"}})],1)],1),a("el-form-item",{attrs:{label:"Z分数超出百分比"}},[a("el-select",{attrs:{size:"small",filterable:"",clearable:"","allow-create":"","default-first-option":"",placeholder:"默认值500"},model:{value:e.formInline.standardScore,callback:function(t){e.$set(e.formInline,"standardScore",t)},expression:"formInline.standardScore"}},e._l(e.options,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}))],1),a("el-form-item",{attrs:{label:"房屋特殊标注"}},[a("el-select",{attrs:{size:"small",multiple:"",filterable:"","allow-create":"","default-first-option":"",placeholder:"请选择"},on:{change:e.houseSpecialChange},model:{value:e.formInline.houseSpecialMarkArr,callback:function(t){e.$set(e.formInline,"houseSpecialMarkArr",t)},expression:"formInline.houseSpecialMarkArr"}},e._l(e.houseSpecialMarkGroups,function(t){return a("el-option-group",{key:t.label,attrs:{label:t.label}},e._l(t.options,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}))}))],1),a("el-form-item",{attrs:{label:"街路巷/小区名称"}},[a("el-input",{attrs:{placeholder:"请输入",clearable:"",size:"small"},model:{value:e.formInline.communityName,callback:function(t){e.$set(e.formInline,"communityName",e._n(t))},expression:"formInline.communityName"}})],1),a("el-form-item",{attrs:{label:"用水疑似空转租"}},[a("el-select",{attrs:{placeholder:"请选择",clearable:"",size:"small"},model:{value:e.formInline.suspectRent,callback:function(t){e.$set(e.formInline,"suspectRent",t)},expression:"formInline.suspectRent"}},[a("el-option",{attrs:{label:"是",value:"是"}}),a("el-option",{attrs:{label:"否",value:"否"}})],1)],1),a("el-form-item",{attrs:{label:"空房购物判断"}},[a("el-select",{attrs:{placeholder:"请选择",clearable:"",size:"small"},model:{value:e.formInline.emptyShopping,callback:function(t){e.$set(e.formInline,"emptyShopping",t)},expression:"formInline.emptyShopping"}},[a("el-option",{attrs:{label:"全部",value:"全部"}}),a("el-option",{attrs:{label:"空房购物",value:"空房购物"}})],1)],1),a("el-form-item",[a("el-button",{attrs:{type:"primary",size:"small"},on:{click:e.onQuery}},[e._v("查询")])],1)],1)],1),a("div",[a("div",{staticClass:"headerBox"},[a("el-button",{attrs:{size:"small",disabled:!e.multipleSelection.length},on:{click:function(t){e.dialogJudgeAbnormalShow=!0}}},[e._v("判定异常\n        ")]),a("div",[e.updatedTime?a("span",[e._v("数据更新时间："+e._s(e.updatedTime))]):e._e(),a("el-button",{staticStyle:{"margin-left":"20px"},attrs:{size:"small",type:"primary"},on:{click:e.downTable}},[e._v("导出数据")]),e.isAdmin?a("el-button",{attrs:{size:"small",type:"warning"},on:{click:function(t){e.uploadFun(1)}}},[e._v("上传房屋用水数据")]):e._e(),e.isAdmin?a("el-button",{attrs:{size:"small",type:"warning"},on:{click:function(t){e.judgeAutoAbnormal()}}},[e._v("数据完整性筛查")]):e._e()],1)],1),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.isLoadingData,expression:"isLoadingData"}],staticClass:"table-content"},[a("el-table",{staticStyle:{width:"100%"},attrs:{size:"mini",border:"",data:e.tableData,"row-key":function(e){return e.id}},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",align:"center",selectable:e.handleSelectable,"reserve-selection":""}}),a("el-table-column",{attrs:{prop:"communityName",label:"街路巷/小区",width:"180"}}),a("el-table-column",{attrs:{prop:"apartmentNum",label:"门牌号/楼栋号",width:"80"}}),a("el-table-column",{attrs:{prop:"houseUnit",label:"单元",width:"80"}}),a("el-table-column",{attrs:{label:"室",width:"80"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){e.handleClick(t.row.proCollId)}}},[e._v(e._s(t.row.roomNum)+"\n              ")])]}}])}),a("el-table-column",{attrs:{prop:"houseStatus",label:"房屋状态",width:"80"}}),a("el-table-column",{attrs:{prop:"houseSpecialMark",label:"房屋特殊标注",width:"80"}}),a("el-table-column",{attrs:{label:"房东信息",width:"200"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.landlordName))]),e._v(" - "),a("span",[e._v(e._s(t.row.landlordId))])]}}])}),a("el-table-column",{attrs:{prop:"landlordPhone",label:"联系方式",width:"120"}}),a("el-table-column",{attrs:{prop:"previousWaterConsumption",label:"上次用水量",width:"96"}}),a("el-table-column",{attrs:{prop:"currentWaterConsumption",label:"本次用水量",width:"96"}}),a("el-table-column",{attrs:{prop:"avgWaterConsumption",label:"平均用水量",width:"96"}}),a("el-table-column",{attrs:{prop:"suspectRent",label:"用水疑似空转租",width:"100"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n              "+e._s(t.row.suspectRent?"是":"否")+"\n            ")]}}])}),a("el-table-column",{attrs:{prop:"standardScore",label:"Z分数超出百分比"}}),a("el-table-column",{attrs:{prop:"shoppingTimes",label:"购物次数"}}),a("el-table-column",{attrs:{prop:"emptyShopping",label:"疑似空房购物"}}),a("el-table-column",{attrs:{prop:"houseWaterStatus",label:"状态"}})],1),a("el-pagination",{staticStyle:{"text-align":"right",padding:"20px 0"},attrs:{background:"","current-page":e.currentPage,"page-size":10,layout:"total, prev, pager, next",total:e.total},on:{"update:currentPage":function(t){e.currentPage=t}}})],1)])]):a("div",[a("div",{staticStyle:{"text-align":"right","margin-bottom":"10px"}},[a("el-button",{attrs:{type:"primary",size:"small"},on:{click:function(t){e.showTable=!0}}},[e._v("返回")])],1),a("el-tabs",{attrs:{type:"border-card"}},[a("el-tab-pane",{attrs:{label:"房屋基本信息"}},e._l(3,function(t){return a("el-card",{key:t,staticStyle:{"margin-bottom":"10px"}},[a("div",{attrs:{slot:"header"},slot:"header"},[a("span",[e._v("卡片名称")])]),e._l(4,function(t){return a("div",{key:t},[e._v("\n            "+e._s("列表内容 "+t)+"\n          ")])})],2)})),a("el-tab-pane",{attrs:{label:"房屋生活信息"}},[e._v("配置管理")]),a("el-tab-pane",{attrs:{label:"调查走访记录"}},[a("el-collapse",{model:{value:e.activeNames,callback:function(t){e.activeNames=t},expression:"activeNames"}},[a("el-collapse-item",{attrs:{title:"一致性 Consistency",name:"1"}},[a("div",[e._v("与现实生活一致：与现实生活的流程、逻辑保持一致，遵循用户习惯的语言和概念；")]),a("div",[e._v("在界面中一致：所有的元素和结构需保持一致，比如：设计样式、图标和文本、元素的位置等。")])]),a("el-collapse-item",{attrs:{title:"反馈 Feedback",name:"2"}},[a("div",[e._v("控制反馈：通过界面样式和交互动效让用户可以清晰的感知自己的操作；")]),a("div",[e._v("页面反馈：操作后，通过页面元素的变化清晰地展现当前状态。")])]),a("el-collapse-item",{attrs:{title:"效率 Efficiency",name:"3"}},[a("div",[e._v("简化流程：设计简洁直观的操作流程；")]),a("div",[e._v("清晰明确：语言表达清晰且表意明确，让用户快速理解进而作出决策；")]),a("div",[e._v("帮助用户识别：界面简单直白，让用户快速识别而非回忆，减少用户记忆负担。")])]),a("el-collapse-item",{attrs:{title:"可控 Controllability",name:"4"}},[a("div",[e._v("用户决策：根据场景可给予用户操作建议或安全提示，但不能代替用户进行决策；")]),a("div",[e._v("结果可控：用户可以自由的进行操作，包括撤销、回退和终止当前操作等。")])])],1)],1)],1)],1),a("el-dialog",{attrs:{title:e.uploadTitle,visible:e.dialogVisible,width:"30%"},on:{"update:visible":function(t){e.dialogVisible=t},close:e.handleClose}},[a("el-upload",{attrs:{action:e.uploadUrl,limit:1,"on-success":e.onSuccess,"file-list":e.fileList}},[a("el-button",{attrs:{size:"small",type:"primary"}},[e._v("点击上传")]),a("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[e._v("只能上传txt文件")])],1)],1),a("el-dialog",{attrs:{title:"异常判定确认",visible:e.dialogJudgeAbnormalShow},on:{"update:visible":function(t){e.dialogJudgeAbnormalShow=t}}},[a("el-form",{ref:"judgeAbnormalDialog",attrs:{rules:{info:[{required:!0,message:"情选择判定原因",trigger:"change"}]},model:e.judgeAbnormalInfo}},[a("el-form-item",{attrs:{label:"判定原因",prop:"info"}},[a("el-select",{attrs:{placeholder:"请选择"},model:{value:e.judgeAbnormalInfo.info,callback:function(t){e.$set(e.judgeAbnormalInfo,"info",t)},expression:"judgeAbnormalInfo.info"}},[a("el-option",{attrs:{label:"用水异常",value:"用水异常"}}),a("el-option",{attrs:{label:"用水疑似空转租",value:"用水疑似空转租"}}),a("el-option",{attrs:{label:"空房购物",value:"空房购物"}})],1)],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.dialogJudgeAbnormalShow=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.doDiffClick}},[e._v("确 定")])],1)],1)],1)},n=[],o=(a("456d"),a("ac6a"),a("be94")),i=(a("96cf"),a("1da1")),r=(a("cadf"),a("551c"),a("097d"),a("a78e")),s=a.n(r),u={manageWater:{API:{getWaterInfo:"water/use/queryByCondition",setStatus:"water/use/judgeAbnormal",judgeAutoAbnormal:"water/use/judgeAutoAbnormal"}}},c=u,p=a("7c15"),d=c.manageWater.API,m={getWaterInfo:function(){var e=Object(i["a"])(regeneratorRuntime.mark(function e(){var t,a,l=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=l.length>0&&void 0!==l[0]?l[0]:{},e.next=3,p["a"].get(d["getWaterInfo"],t);case 3:return a=e.sent,e.abrupt("return",a);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),setStatus:function(){var e=Object(i["a"])(regeneratorRuntime.mark(function e(){var t,a,l=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=l.length>0&&void 0!==l[0]?l[0]:{},e.next=3,p["a"].post(d["setStatus"],t);case 3:return a=e.sent,e.abrupt("return",a);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),judgeAutoAbnormal:function(){var e=Object(i["a"])(regeneratorRuntime.mark(function e(){var t,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:t=a.length>0&&void 0!==a[0]?a[0]:{},p["a"].post(d["judgeAutoAbnormal"],t);case 2:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}()},f=a("f121"),b="变异系数：标准差能很客观准确的反映一组数据的离散程度，但是对于不同的项目，或同一项目不同的样本，标准差就缺乏可比性了，因此引入变异系数。例如：住户A只有一个人居住是一套1居室，住户A的标准差只能反应住户A各月用水数据分布的离散程度，如果和其他住户的标准差进行对比是缺乏可比性的，例如住户B是一幢别墅，居住人数为10，各月用水量从基数量级上就远大于住户A，在标准差的绝对值上，住户B可能远大于住户A，但是住户A和住户B各月数据分布离散程度的相对值可能是相似的。简单来讲，从1到5上升了4，从10到50上升了40，后者上升的绝对值40远大于前者上升的绝对值4，但上升幅度前后两次均为80%。这也就意味着当我们对比不同项目或同一项目的不同样本时，我们也需考虑不同样本本身的数据量纲，去除样本原始数据量纲的影响，从而更客观的对比数据，变异系数=样本原始数据的标准差/样本原始数据的平均数，通过除以样本原始数据的平均数消除数据量纲的影响，表达的是样本数据离散程度的相对值",h={name:"ManageWater",data:function(){return{formInline:{houseStatus:"",houseWaterStatus:"",standardScore:"",houseSpecialMarkArr:[],houseSpecialMark:"",communityName:"",suspectRent:"",emptyShopping:"",specialGoods:""},options:[{value:"500",label:"500"}],houseSpecialMarkGroups:[{label:"",options:[{value:"无",label:"无"}]},{label:"特殊标记",options:[{value:"重点人员",label:"重点人员"},{value:"风险人员",label:"风险人员"},{value:"涉案人员",label:"涉案人员"}]}],variationNum:b,multipleSelection:[],tableData:[],showTable:!0,activeNames:["1"],currentPage:1,total:0,updatedTime:"",isLoadingData:!1,officerNo:"",fileList:[],dialogVisible:!1,uploadUrl:"/water/use/uploadWaterInfoFile?uploadType=1",dialogJudgeAbnormalShow:!1,judgeAbnormalInfo:{info:""},uploadTitle:""}},watch:{currentPage:function(){this.init(this.formInline)}},mounted:function(){s.a.get("officerNo")&&(this.officerNo=s.a.get("officerNo")),this.init()},computed:{isAdmin:function(){var e=JSON.parse(s.a.get("officerInfo"));return"admin"===e.role}},methods:{init:function(){var e=Object(i["a"])(regeneratorRuntime.mark(function e(){var t,a,l,n,i,r,s=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=s.length>0&&void 0!==s[0]?s[0]:{},this.formInline.houseSpecialMark=this.formInline.houseSpecialMarkArr.join(","),a={currentPage:this.currentPage,offset:10,officerNo:this.officerNo},this.isLoadingData=!0,e.next=6,m.getWaterInfo(Object(o["a"])({},a,t));case 6:l=e.sent,this.isLoadingData=!1,n=l.data,i=l.totalSize,r=void 0===i?0:i,this.tableData=n,this.updatedTime=n[0].dt?n[0].dt:"",this.total=r;case 12:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),onQuery:function(){this.currentPage=1,this.init(this.formInline)},handleClick:function(e){this.showTable=!1,this.$router.push({path:"/room-info",query:{proCollId:e}})},handleSelectionChange:function(e){e&&(this.multipleSelection=e.map(function(e){return e.id}))},doDiffClick:function(){var e=Object(i["a"])(regeneratorRuntime.mark(function e(){var t=this;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:this.$refs.judgeAbnormalDialog.validate(function(e){if(!e)return!1;var a={officerNo:t.officerNo,ids:t.multipleSelection,abnormalInfo:t.judgeAbnormalInfo.info};t.addjudgeAbnormalInfo(a)});case 1:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),addjudgeAbnormalInfo:function(){var e=Object(i["a"])(regeneratorRuntime.mark(function e(t){var a;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,m.setStatus(t);case 2:a=e.sent,a.data&&(this.$message({type:"success",message:"判定异常成功"}),this.dialogJudgeAbnormalShow=!1,this.multipleSelection=[],this.init());case 4:case"end":return e.stop()}},e,this)}));return function(t){return e.apply(this,arguments)}}(),handleSelectable:function(e,t){return"异常"!==e.houseWaterStatus},downTable:function(){var e=Object(o["a"])({officerNo:this.officerNo},this.formInline),t=f["a"].LOCAL+"/water/use/download?"+this.dealGetParams(e);console.log(t),window.open(t)},dealGetParams:function(e){var t=[];return e instanceof Object&&Object.keys(e).forEach(function(a){t.push("".concat(a,"=").concat(e[a]))}),t.join("&")},uploadFun:function(e){this.dialogVisible=!0,1==e&&(this.uploadUrl=f["a"].LOCAL+"/water/use/uploadWaterInfoFile?uploadType=1",this.uploadTitle="上传房屋用水数据"),2==e&&(this.uploadUrl=f["a"].LOCAL+"/water/use/uploadHouseShoppingFile?uploadType=1",this.uploadTitle="上传房屋购物数据"),3==e&&(this.uploadUrl=f["a"].LOCAL+"/water/use/uploadHouseShoppingFile?uploadType=1",this.uploadTitle="上传房屋物流数据")},judgeAutoAbnormal:function(){this.$alert("异常数据已自动进入调查差走访页面","提示",{confirmButtonText:"确定",callback:function(e){m.judgeAutoAbnormal()}})},handleClose:function(){this.dialogVisible=!1,this.fileList=[]},onSuccess:function(){this.$message.success("文件上传成功！")},houseSpecialChange:function(e,t){"无"==e[e.length-1]?this.formInline.houseSpecialMarkArr=["无"]:-1!=this.formInline.houseSpecialMarkArr.indexOf("无")&&this.formInline.houseSpecialMarkArr.splice(this.formInline.houseSpecialMarkArr.indexOf("无"),1)}}},v=h,g=(a("2094"),a("2877")),S=Object(g["a"])(v,l,n,!1,null,null,null);S.options.__file="index.vue";t["default"]=S.exports}}]);
//# sourceMappingURL=chunk-4d658032.56644705.js.map