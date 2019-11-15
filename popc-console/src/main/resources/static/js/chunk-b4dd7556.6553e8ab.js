(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-b4dd7556"],{"292e2":function(e,t,n){"use strict";n.r(t);var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"power-manage"},[n("div",{staticClass:"clearfix"},[n("el-form",{staticClass:"form-inline",attrs:{inline:!0,model:e.formInline}},[n("el-form-item",{attrs:{label:"小区名称"}},[n("el-input",{attrs:{size:"small",placeholder:"请输入",clearable:""},model:{value:e.formInline.communityName,callback:function(t){e.$set(e.formInline,"communityName",t)},expression:"formInline.communityName"}})],1),n("el-form-item",{attrs:{label:"楼栋名称"}},[n("el-input",{attrs:{size:"small",placeholder:"请输入",clearable:""},model:{value:e.formInline.apartmentNum,callback:function(t){e.$set(e.formInline,"apartmentNum",t)},expression:"formInline.apartmentNum"}})],1),n("el-form-item",{attrs:{label:"房号"}},[n("el-input",{attrs:{size:"small",placeholder:"请输入",clearable:""},model:{value:e.formInline.roomNum,callback:function(t){e.$set(e.formInline,"roomNum",t)},expression:"formInline.roomNum"}})],1),n("el-form-item",{attrs:{label:"房屋状态"}},[n("el-select",{attrs:{size:"small",placeholder:"请选择",clearable:""},model:{value:e.formInline.houseStatus,callback:function(t){e.$set(e.formInline,"houseStatus",t)},expression:"formInline.houseStatus"}},e._l(e.options,function(e){return n("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}))],1),n("el-form-item",{attrs:{label:"房东姓名"}},[n("el-input",{attrs:{size:"small",placeholder:"请输入",clearable:""},model:{value:e.formInline.landlordName,callback:function(t){e.$set(e.formInline,"landlordName",t)},expression:"formInline.landlordName"}})],1),n("el-form-item",{attrs:{label:"房东身份证号"}},[n("el-input",{attrs:{size:"small",placeholder:"请输入",clearable:""},model:{value:e.formInline.landlordId,callback:function(t){e.$set(e.formInline,"landlordId",t)},expression:"formInline.landlordId"}})],1),n("el-form-item",{attrs:{label:"房屋隐患"}},[n("el-select",{attrs:{placeholder:"请选择",clearable:"",size:"small"},model:{value:e.formInline.houseDanger,callback:function(t){e.$set(e.formInline,"houseDanger",t)},expression:"formInline.houseDanger"}},[n("el-option",{attrs:{label:"房屋存在隐患",value:"1"}}),n("el-option",{attrs:{label:"房屋未存在隐患",value:"2"}})],1)],1),n("el-form-item",[n("el-button",{attrs:{type:"primary",size:"small"},on:{click:e.onQuery}},[e._v("查询")])],1)],1)],1),n("div",{staticStyle:{"text-align":"right","margin-bottom":"10px"}},[e.isAdmin?n("el-button",{attrs:{size:"small",type:"warning"},on:{click:function(t){e.uploadFun("register")}}},[e._v("上传房屋登记信息")]):e._e(),e.isAdmin?n("el-button",{attrs:{size:"small",type:"success"},on:{click:function(t){e.uploadFun("trade")}}},[e._v("上传房屋交易信息")]):e._e()],1),n("div",{directives:[{name:"loading",rawName:"v-loading",value:e.isLoading,expression:"isLoading"}],staticClass:"table-box"},[n("el-table",{attrs:{border:"",data:e.tableData}},[n("el-table-column",{attrs:{label:"序号",type:"index",index:e.indexMethod,width:"96",align:"center"}}),n("el-table-column",{attrs:{prop:"communityName",label:"小区名称"}}),n("el-table-column",{attrs:{prop:"apartmentNum",label:"楼栋名称"}}),n("el-table-column",{attrs:{prop:"houseUnit",label:"单元",width:"100px"}}),n("el-table-column",{attrs:{label:"房号",width:"80px"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-button",{attrs:{type:"text"},on:{click:function(n){e.gotoRoomInfo(t.row.proCollId)}}},[e._v(e._s(t.row.roomNum))])]}}])}),n("el-table-column",{attrs:{prop:"houseStatus",label:"房屋状态",width:"80"}}),n("el-table-column",{attrs:{prop:"houseSpecialMark",label:"房屋特殊标记",width:"120"}}),n("el-table-column",{attrs:{prop:"houseDanger",label:"房屋隐患情况",width:"120"}}),n("el-table-column",{attrs:{label:"房东信息"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("span",[e._v(e._s(t.row.landlordName)+" - "+e._s(t.row.landlordId))])]}}])}),n("el-table-column",{attrs:{prop:"landlordPhone",label:"联系方式"}})],1),n("el-pagination",{staticStyle:{"text-align":"right",padding:"20px 0"},attrs:{background:"",layout:"total, prev, pager, next","current-page":e.currentPage,"page-size":10,total:e.total},on:{"update:currentPage":function(t){e.currentPage=t}}})],1),n("el-dialog",{attrs:{title:e.title,visible:e.dialogVisible,width:"30%"},on:{"update:visible":function(t){e.dialogVisible=t},close:e.handleClose}},[n("el-upload",{attrs:{action:e.uploadUrl,limit:1,"on-success":e.onSuccess,"file-list":e.fileList}},[n("el-button",{attrs:{size:"small",type:"primary"}},[e._v("点击上传")]),n("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[e._v("只能上传txt文件")])],1)],1)],1)},r=[],l=n("be94"),o=(n("96cf"),n("1da1")),i=(n("cadf"),n("551c"),n("097d"),n("b6e2")),s=n("a78e"),u=n.n(s),c={name:"HouseInfo",data:function(){return{formInline:{communityName:"",apartmentNum:"",roomNum:"",houseStatus:"",landlordName:"",landlordId:"",houseDanger:""},options:[{value:"自住",label:"自住"},{value:"出租",label:"出租"},{value:"空置",label:"空置"},{value:"待核",label:"待核"},{value:"其他",label:"其他"}],tableData:[],total:0,currentPage:1,isLoading:!1,officerNo:"",fileList:[],dialogVisible:!1,title:"",uploadUrl:""}},watch:{currentPage:function(){this.init(this.formInline)}},mounted:function(){this.init()},computed:{isAdmin:function(){var e=JSON.parse(u.a.get("officerInfo"));return"admin"===e.role}},methods:{init:function(){var e=Object(o["a"])(regeneratorRuntime.mark(function e(){var t,n,a,r,o,s,u=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=u.length>0&&void 0!==u[0]?u[0]:{},this.isLoading=!0,n={currentPage:this.currentPage,offset:10},e.next=5,i["a"].getHouseInfo(Object(l["a"])({},n,t));case 5:a=e.sent,r=a.data,o=a.totalSize,s=void 0===o?0:o,this.tableData=r,this.total=s,this.isLoading=!1;case 10:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),onQuery:function(){this.currentPage=1,this.init(this.formInline)},indexMethod:function(e){return e+1+10*(this.currentPage-1)},gotoRoomInfo:function(e){this.$router.push({path:"/room-info",query:{proCollId:e}})},uploadFun:function(e){"trade"===e?(this.title="上传房屋交易信息",this.uploadUrl="/water/use/uploadHouseDealFile"):(this.title="上传房屋登记信息",this.uploadUrl="/water/use/uploadHouseRegisterFile"),this.dialogVisible=!0},handleClose:function(){this.dialogVisible=!1,this.fileList=[]},onSuccess:function(){this.$message.success("文件上传成功！")}}},m=c,d=(n("c637"),n("2877")),p=Object(d["a"])(m,a,r,!1,null,"dc7bc2d6",null);p.options.__file="index.vue";t["default"]=p.exports},"557b":function(e,t,n){},b6e2:function(e,t,n){"use strict";n("96cf");var a=n("1da1"),r=(n("cadf"),n("551c"),n("097d"),{houseInfo:{API:{getHouseInfo:"house/info/queryByCondition",getRoomInfo:"house/info/basic",getVisitInfo:"house/info/queryAllFeedbackByProCollId",getWaterTrend:"house/info/queryWaterTrendByProCollId",getShoppingInfo:"shopping/info/getShoppingInfoByProCollId",saveBasicCommunity:"house/info/saveBasicCommunity"}}}),l=r,o=n("7c15"),i=l.houseInfo.API;t["a"]={getHouseInfo:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,o["a"].get(i["getHouseInfo"],t);case 3:return n=e.sent,e.abrupt("return",n);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),getRoomInfo:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,o["a"].get(i["getRoomInfo"],t);case 3:return n=e.sent,e.abrupt("return",n);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),getVisitInfo:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,o["a"].get(i["getVisitInfo"],t);case 3:return n=e.sent,e.abrupt("return",n);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),getWaterTrend:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,o["a"].get(i["getWaterTrend"],t);case 3:return n=e.sent,e.abrupt("return",n.data);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),getShoppingInfo:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,o["a"].get(i["getShoppingInfo"],t);case 3:return n=e.sent,e.abrupt("return",n.data);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),saveBasicCommunity:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,o["a"].get(i["saveBasicCommunity"],t);case 3:return n=e.sent,e.abrupt("return",n.data);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}()}},c637:function(e,t,n){"use strict";var a=n("557b"),r=n.n(a);r.a}}]);
//# sourceMappingURL=chunk-b4dd7556.6553e8ab.js.map