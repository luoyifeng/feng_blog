(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5a14c4f6"],{"0d66":function(e,t,i){"use strict";i.r(t);var r=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"police-message"},[i("div",{staticClass:"search"},[i("el-form",{ref:"policeMessageForm",attrs:{inline:!0,model:e.policeMessageForm}},[i("el-form-item",{attrs:{label:"小区名称"}},[i("el-input",{staticClass:"input",attrs:{size:"small",clearable:"",placeholder:"请输入"},model:{value:e.policeMessageForm.communityName,callback:function(t){e.$set(e.policeMessageForm,"communityName",t)},expression:"policeMessageForm.communityName"}})],1),i("el-form-item",{attrs:{label:"负责警员"}},[i("el-input",{staticClass:"input",attrs:{size:"small",clearable:"",placeholder:"请输入"},model:{value:e.policeMessageForm.officerName,callback:function(t){e.$set(e.policeMessageForm,"officerName",t)},expression:"policeMessageForm.officerName"}})],1),i("el-form-item",{attrs:{label:"警员编号"}},[i("el-input",{staticClass:"input",attrs:{size:"small",clearable:"",placeholder:"请输入"},model:{value:e.policeMessageForm.officerNo,callback:function(t){e.$set(e.policeMessageForm,"officerNo",t)},expression:"policeMessageForm.officerNo"}})],1),i("el-form-item",[i("el-button",{attrs:{size:"small",type:"primary"},on:{click:e.handleSearch}},[e._v("查询")]),i("el-button",{attrs:{size:"small",type:"primary",icon:"el-icon-edit"},on:{click:e.newCommunity}},[e._v("新建小区")])],1)],1)],1),i("div",{staticClass:"main-table"},[i("main-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loadingTable,expression:"loadingTable"}],ref:"table",attrs:{border:!0,data:e.tableData,columns:e.columns,page:e.page},on:{currentChangePage:e.currentChange},model:{value:e.currentPage,callback:function(t){e.currentPage=t},expression:"currentPage"}})],1),i("community-new",{ref:"communityAdd"})],1)},n=[],o=i("be94"),a=(i("96cf"),i("1da1")),c=(i("cadf"),i("551c"),i("097d"),function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",[i("el-table",{ref:"table",staticStyle:{width:"100%"},attrs:{data:e.data,border:e.border,stripe:e.stripe,"span-method":e.spanMethod,"highlight-current-row":e.highlightCurrentRow,"default-sort":e.defaultSort,"row-key":"treeId","tree-props":{children:"children"}},on:{"sort-change":e.sortChange,"current-change":e.currentChangeRow}},[e._l(e.columns,function(t){return[t.slot?e._t(t.slot):t.opration?i("el-table-column",{attrs:{prop:t.prop,label:t.label,width:t.width,sortable:t.sortable,"show-overflow-tooltip":t.tooltip},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{attrs:{size:"mini"},on:{click:function(i){e.handleEdit(t.$index,t.row)}}},[e._v("编辑\n            ")]),i("el-button",{attrs:{size:"mini"},on:{click:function(i){e.newOfficer(t.$index,t.row)}}},[e._v("警员管理\n            ")]),i("el-button",{attrs:{size:"mini"},on:{click:function(i){e.importData(t.$index,t.row)}}},[e._v("导入数据\n            ")]),i("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(i){e.handleDeleteCommunity(t.$index,t.row)}}},[e._v("删除小区\n            ")])]}}])}):i("el-table-column",{attrs:{type:t.type,prop:t.prop,label:t.label,width:t.width,sortable:t.sortable,"show-overflow-tooltip":t.tooltip}})]})],2),i("div",{staticClass:"page",class:e.page.align},[e.page.show?i("el-pagination",{attrs:{background:"",layout:"total, prev, pager, next",total:e.page.total,"page-size":10,"page-sizes":e.page.pageSizes,"pager-count":e.page.pageCount,"current-page":e.currentPage},on:{"update:currentPage":function(t){e.currentPage=t},"size-change":e.sizeChange,"current-change":e.currentChangePage}}):e._e()],1),i("EditCommunity",{ref:"EditCommunity"}),i("EditCommunityOfficers",{ref:"EditCommunityOfficers"}),i("el-dialog",{attrs:{title:e.title,visible:e.dialogVisible,width:"600px"},on:{"update:visible":function(t){e.dialogVisible=t},close:e.handleClose}},[i("el-form",{attrs:{"label-position":"right","label-width":"100px"}},[i("el-form-item",{attrs:{label:"小区名称: "}},[i("el-input",{attrs:{disabled:"",width:"50px"},model:{value:e.commiuntyName,callback:function(t){e.commiuntyName=t},expression:"commiuntyName"}})],1),i("el-upload",{attrs:{action:e.uploadUrl,limit:1,"on-success":e.onSuccess,accept:".xls,.xlsx","file-list":e.fileList}},[i("el-button",{attrs:{size:"small",type:"primary"}},[e._v("点击上传")]),i("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[e._v("只可上传.xlsx 、.xls文件")])],1)],1)],1)],1)}),s=[],m=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{attrs:{title:"小区信息修改",visible:e.showEdit,width:"600px"},on:{close:e.close}},[i("div",{staticClass:"officer-edit"},[i("el-form",{ref:"editForm",attrs:{inline:!0,model:e.editForm,rules:e.rules,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:"行政区划",prop:"communityRegion"}},[i("el-input",{attrs:{placeholder:"行政区划"},model:{value:e.editForm.communityRegion,callback:function(t){e.$set(e.editForm,"communityRegion",t)},expression:"editForm.communityRegion"}})],1),i("el-form-item",{attrs:{label:"街道",prop:"communityStreet"}},[i("el-input",{attrs:{placeholder:"街道"},model:{value:e.editForm.communityStreet,callback:function(t){e.$set(e.editForm,"communityStreet",t)},expression:"editForm.communityStreet"}})],1),i("el-form-item",{attrs:{label:"居委会",prop:"communityCommittee"}},[i("el-input",{attrs:{placeholder:"居委会"},model:{value:e.editForm.communityCommittee,callback:function(t){e.$set(e.editForm,"communityCommittee",t)},expression:"editForm.communityCommittee"}})],1),i("el-form-item",{attrs:{label:"街路巷/小区",prop:"communityName"}},[i("el-input",{attrs:{placeholder:"街路巷/小区"},model:{value:e.editForm.communityName,callback:function(t){e.$set(e.editForm,"communityName",t)},expression:"editForm.communityName"}})],1),i("el-form-item",{staticStyle:{"text-align":"right","margin-bottom":"0","padding-left":"100px"}},[i("el-button",{attrs:{size:"small",type:"primary"},on:{click:e.submit}},[e._v("确认")]),i("el-button",{attrs:{size:"small",type:"primary",plain:""},on:{click:e.close}},[e._v("取消")])],1)],1)],1)])},u=[],f=i("ade3"),l={officerInfo:{API:{getOfficerList:"community/officer/queryByCondition",getCommunityList:"community/officer/queryCommunityByName",queryOfficerName:"community/officer/queryOfficerByName",queryOfficerPhone:"community/officer/queryOfficerByPhone",saveNewCommunity:"community/officer/saveNewCommunityWithOfficerRelation",saveCommunity:"community/officer/saveCommunityOfficerRelation",deleteCommunity:"community/officer/deleteCommunity",updateCommunity:"community/officer/updateCommunityInfo",detachRelation:"community/officer/detachCommunityOfficerRelation",queryByOfficeInfoByCommunityId:"community/officer/queryByOfficeInfoByCommunityId"}}},d=l,p=i("7c15"),h=d.officerInfo.API,y={getOfficerList:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,i,r=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=r.length>0&&void 0!==r[0]?r[0]:{},e.next=3,p["a"].get(h["getOfficerList"],t);case 3:return i=e.sent,e.abrupt("return",i);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),getCommunityList:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,i,r=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=r.length>0&&void 0!==r[0]?r[0]:{},e.next=3,p["a"].get(h["getCommunityList"],t);case 3:return i=e.sent,e.abrupt("return",i);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),queryOfficerName:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,i,r=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=r.length>0&&void 0!==r[0]?r[0]:{},e.next=3,p["a"].get(h["queryOfficerName"],t);case 3:return i=e.sent,e.abrupt("return",i);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),queryOfficerPhone:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,i,r=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=r.length>0&&void 0!==r[0]?r[0]:{},e.next=3,p["a"].get(h["queryOfficerPhone"],t);case 3:return i=e.sent,e.abrupt("return",i);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),saveNewCommunity:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,i,r=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=r.length>0&&void 0!==r[0]?r[0]:{},e.next=3,p["a"].post(h["saveNewCommunity"],t);case 3:return i=e.sent,e.abrupt("return",i);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),deleteCommunity:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,i,r=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=r.length>0&&void 0!==r[0]?r[0]:{},e.next=3,p["a"].get(h["deleteCommunity"],t);case 3:return i=e.sent,e.abrupt("return",i);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),updateCommunity:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,i,r=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=r.length>0&&void 0!==r[0]?r[0]:{},e.next=3,p["a"].get(h["updateCommunity"],t);case 3:return i=e.sent,e.abrupt("return",i);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),detachRelation:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,i,r=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=r.length>0&&void 0!==r[0]?r[0]:{},e.next=3,p["a"].post(h["detachRelation"],t);case 3:return i=e.sent,e.abrupt("return",i);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),saveCommunity:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,i,r=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=r.length>0&&void 0!==r[0]?r[0]:{},e.next=3,p["a"].get(h["saveCommunity"],t);case 3:return i=e.sent,e.abrupt("return",i);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),getOfficersInfoById:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,i,r=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=r.length>0&&void 0!==r[0]?r[0]:{},e.next=3,p["a"].get(h["queryByOfficeInfoByCommunityId"],t);case 3:return i=e.sent,e.abrupt("return",i);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}()},g={props:{},data:function(){return{showEdit:!1,loading:!1,loadingArea:!1,editForm:{communityId:0,communityRegion:"",communityStreet:"",communityCommittee:"",communityName:""},officerLists:[],communityList:[],rules:{communityRegion:[{required:!0,message:"请输入行政区划",trigger:"blur"}],communityStreet:[{required:!0,message:"请输入街道",trigger:"blur"}],communityName:[{required:!0,message:"请输入街路巷/小区",trigger:"blur"}]}}},methods:{saveCommunity:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=Object(f["a"])({id:this.editForm.communityId,communityName:this.editForm.communityName,communityRegion:this.editForm.communityRegion,communityStreet:this.editForm.communityStreet,communityCommittee:this.editForm.communityCommittee},"communityName",this.editForm.communityName),e.next=3,y.updateCommunity(t);case 3:e.sent,this.$refs.editForm.resetFields(),this.showEdit=!1,this.$parent.$parent.getOfficerList();case 7:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),submit:function(){var e=this;this.$refs.editForm.validate(function(t){if(!t)return!1;e.saveCommunity()})},close:function(){this.$refs.editForm.resetFields(),this.showEdit=!1,this.communityList=[]},show:function(e){this.editForm.communityId=e.communityId,this.editForm.communityRegion=e.communityRegion,this.editForm.communityStreet=e.communityStreet,this.editForm.communityCommittee=e.communityCommittee,this.editForm.communityName=e.communityName,this.showEdit=!0}}},b=g,v=(i("15ef"),i("2877")),w=Object(v["a"])(b,m,u,!1,null,null,null);w.options.__file="EditCommunity.vue";var x=w.exports,N=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{attrs:{title:"添加警员",visible:e.showEdit,width:"800px"},on:{close:e.close}},[i("div",{staticClass:"officer-edit"},[i("el-form",{ref:"editForm",attrs:{inline:!0,model:e.editForm,rules:e.rules,"label-position":"right","label-width":"150px"}},[i("el-form-item",{attrs:{label:"行政区划",prop:"communityRegion"}},[i("el-input",{attrs:{placeholder:"行政区划",disabled:!0},model:{value:e.editForm.communityRegion,callback:function(t){e.$set(e.editForm,"communityRegion",t)},expression:"editForm.communityRegion"}})],1),i("el-form-item",{attrs:{label:"街道",prop:"communityStreet"}},[i("el-input",{attrs:{placeholder:"行政区划",disabled:!0},model:{value:e.editForm.communityStreet,callback:function(t){e.$set(e.editForm,"communityStreet",t)},expression:"editForm.communityStreet"}})],1),i("el-form-item",{attrs:{label:"居委会",prop:"communityCommittee"}},[i("el-input",{attrs:{placeholder:"行政区划",disabled:!0},model:{value:e.editForm.communityCommittee,callback:function(t){e.$set(e.editForm,"communityCommittee",t)},expression:"editForm.communityCommittee"}})],1),i("el-form-item",{attrs:{label:"街路巷/小区",prop:"communityName"}},[i("el-input",{attrs:{placeholder:"行政区划",disabled:!0},model:{value:e.editForm.communityName,callback:function(t){e.$set(e.editForm,"communityName",t)},expression:"editForm.communityName"}})],1),e._l(e.editForm.officerInfos,function(t,r){return i("el-form-item",{key:t.key,attrs:{label:"负责民警"+[r+1],prop:"officerInfos."+r+".officerName","label-width":"140px"}},[i("el-select",{staticStyle:{width:"120px"},attrs:{placeholder:"请输入搜索",filterable:"",clearable:"",remote:"",loading:e.loading,"remote-method":e.queryOfficerName},on:{change:function(i){e.choseSelectOfficer(r,t.officerName)}},model:{value:t.officerName,callback:function(i){e.$set(t,"officerName",i)},expression:"officerInfo.officerName"}},e._l(e.officerLists,function(t){return i("el-option",{key:t.officerName,attrs:{label:t.officerName,value:t}},[i("span",{staticStyle:{float:"left"}},[e._v(e._s(t.officerName))]),i("span",{staticStyle:{float:"right",color:"#8492a6","font-size":"13px"}},[e._v(e._s(t.officerNo))])])})),i("span",{staticStyle:{"padding-left":"40px","padding-right":"10px"}},[e._v("警号")]),i("el-select",{staticStyle:{width:"120px"},attrs:{placeholder:"请输入搜索",filterable:"",clearable:"",remote:"",loading:e.loading,"remote-method":e.queryOfficerName},on:{change:function(i){e.choseSelectOfficer(r,t.officerNo)}},model:{value:t.officerNo,callback:function(i){e.$set(t,"officerNo",i)},expression:"officerInfo.officerNo"}},e._l(e.officerLists,function(t){return i("el-option",{key:t.officerNo,attrs:{label:t.officerNo,value:t}},[i("span",{staticStyle:{float:"left"}},[e._v(e._s(t.officerName))]),i("span",{staticStyle:{float:"right",color:"#8492a6","font-size":"13px"}},[e._v(e._s(t.officerNo))])])})),i("span",{staticStyle:{"padding-left":"40px","padding-right":"10px"}},[e._v("电话")]),i("el-select",{staticStyle:{width:"140px"},attrs:{placeholder:"请输入搜索",filterable:"",clearable:"",remote:"",loading:e.loading,"remote-method":e.queryOfficerPhone},on:{change:function(i){e.choseSelectOfficer(r,t.officerPhone)}},model:{value:t.officerPhone,callback:function(i){e.$set(t,"officerPhone",i)},expression:"officerInfo.officerPhone"}},e._l(e.officerLists,function(t){return i("el-option",{key:t.officerPhone,attrs:{label:t.officerPhone,value:t}},[i("span",{staticStyle:{float:"left"}},[e._v(e._s(t.officerName))]),i("span",{staticStyle:{float:"right",color:"#8492a6","font-size":"13px"}},[e._v(e._s(t.officerNo))])])})),i("span",{staticStyle:{"padding-left":"20px","padding-right":"5px"}},[i("el-button",{attrs:{type:"primary",icon:"el-icon-delete",size:"mini"},on:{click:function(t){e.deleteOne(r)}}})],1)],1)}),i("el-form-item",{staticStyle:{"text-align":"right","margin-bottom":"0","padding-left":"100px"}},[i("el-button",{attrs:{size:"small",type:"primary"},on:{click:e.addOfficer}},[e._v("添加民警")])],1),i("el-form-item",{staticStyle:{"text-align":"right","margin-bottom":"0","padding-left":"151px"}},[i("el-button",{attrs:{size:"small",type:"primary"},on:{click:e.addCommunityOfficers}},[e._v("确认")]),i("el-button",{attrs:{size:"small",type:"primary",plain:""},on:{click:e.close}},[e._v("取消")]),i("el-button",{attrs:{size:"small",type:"primary",plain:""},on:{click:e.resetForm}},[e._v("重置")])],1)],2)],1)])},F=[],C={props:{},data:function(){return{showEdit:!1,loading:!1,loadingArea:!1,editForm:{communityId:"",communityRegion:"",communityStreet:"",communityCommittee:"",communityName:"",officerInfos:[{officerId:0,officerName:"",officerNo:"",officerPhone:""}]},officerLists:[],communityList:[],rules:{communityName:[{required:!0,message:"请选择小区名称",trigger:"blur"}],officerId:[{required:!0,message:"请选择警号",trigger:"blur"}],officerName:[{required:!0,message:"请选择姓名",trigger:"blur"}],officerPhone:[{required:!0,message:"请选择电话",trigger:"blur"}]}}},methods:{deleteOne:function(e){this.editForm.officerInfos.splice(e,1)},addOfficer:function(){this.editForm.officerInfos.push({officerName:"",officerId:0,officerNo:"",officerPhone:"",key:Date.now()})},getCommunityList:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(t){var i;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return this.loadingArea=!0,e.next=3,y.getCommunityList({communityName:t});case 3:i=e.sent,this.communityList=i.data,this.loadingArea=!1;case 6:case"end":return e.stop()}},e,this)}));return function(t){return e.apply(this,arguments)}}(),queryOfficerName:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(t){var i;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:if(""===t){e.next=9;break}return this.loading=!0,e.next=4,y.queryOfficerName({officerName:t});case 4:i=e.sent,this.officerLists=i.data,this.loading=!1,e.next=10;break;case 9:this.officerLists=[];case 10:case"end":return e.stop()}},e,this)}));return function(t){return e.apply(this,arguments)}}(),queryOfficerPhone:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(t){var i;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:if(""===t){e.next=9;break}return this.loading=!0,e.next=4,y.queryOfficerPhone({officerPhone:t});case 4:i=e.sent,this.officerList=i.data,this.loading=!1,e.next=10;break;case 9:this.officerList=[];case 10:case"end":return e.stop()}},e,this)}));return function(t){return e.apply(this,arguments)}}(),addCommunityOfficers:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,i,r;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:for(i in t=[],this.editForm.officerInfos)t.push(this.editForm.officerInfos[i].officerId);return r={communityId:this.editForm.communityId,officerIds:t.join(",")},e.next=5,y.saveCommunity(r);case 5:e.sent,this.showEdit=!1,this.$parent.$parent.getOfficerList();case 8:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),submit:function(){var e=this;this.$refs.editForm.validate(function(t){if(!t)return!1;e.addCommunityOfficers()})},choseSelectOfficer:function(e,t){this.editForm.officerInfos[e].officerNo=t.officerNo,this.editForm.officerInfos[e].officerId=t.id,this.editForm.officerInfos[e].officerName=t.officerName,this.editForm.officerInfos[e].officerPhone=t.officerPhone},close:function(){this.$refs.editForm.resetFields(),this.showEdit=!1,this.communityList=[]},show:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(t,i){var r,n;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return this.showEdit=!0,e.next=3,y.getOfficersInfoById({id:i.communityId});case 3:if(r=e.sent,200==r.code){e.next=7;break}return this.$message({type:"info",message:"接口超时!"}),e.abrupt("return");case 7:n=r.data.map(function(e){return{officerNo:e.officerNo,officerPhone:e.officerPhone,officerName:e.officerName,officerId:e.id}}),this.$set(this.editForm,"officerInfos",n),this.editForm.communityRegion=i.communityRegion,this.editForm.communityStreet=i.communityStreet,this.editForm.communityCommittee=i.communityCommittee,this.editForm.communityName=i.communityName,this.editForm.communityId=i.communityId;case 14:case"end":return e.stop()}},e,this)}));return function(t,i){return e.apply(this,arguments)}}(),resetForm:function(){this.$refs.editForm.resetFields(),this.$set(this.editForm,"officerInfos",[{officerName:"",officerId:"",officerPhone:""}])}}},O=C,k=(i("fdefc"),Object(v["a"])(O,N,F,!1,null,null,null));k.options.__file="EditCommunityOfficers.vue";var R=k.exports,_={components:{EditCommunity:x,EditCommunityOfficers:R},props:{border:{type:Boolean,default:!1},data:{type:Array,default:function(){return[]}},columns:{type:Array,default:function(){return[]}},page:{type:Object,default:function(){return{}}},stripe:{type:Boolean,default:!1},highlightCurrentRow:{type:Boolean,default:!1},spanMethod:Function,defaultSort:{type:Object,default:function(){return{}}},sortChange:{type:Function,default:function(){return null}}},data:function(){return{commiuntyName:"",fileList:[],currentPage:0,dialogVisible:!1,title:"上传房屋交易信息",uploadUrl:"/community/officer/uploadCommunityInfo"}},methods:{sizeChange:function(e){this.$emit("sizeChange",e)},currentChangePage:function(e){this.currentPage=e,this.$emit("currentChangePage",e)},currentChangeRow:function(e){this.$emit("currentChangeRow",e)},resetPage:function(){this.currentPage=1},newOfficer:function(e,t){this.$refs.EditCommunityOfficers.show(e,t)},handleEdit:function(e,t){this.$refs.EditCommunity.show(t)},handleDeleteCommunity:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(t,i){var r=this;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:this.$confirm("此操作将删除小区信息及所有相关警员信息, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(Object(a["a"])(regeneratorRuntime.mark(function e(){var t;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,y.deleteCommunity({communityId:i.communityId});case 2:t=e.sent,200===t.code?r.$message({type:"success",message:"删除成功!"}):r.$message({type:"info",message:"删除失败"+t.msg}),r.$parent.getOfficerList();case 5:case"end":return e.stop()}},e,this)}))).catch(function(){r.$message({type:"info",message:"已取消删除"})});case 1:case"end":return e.stop()}},e,this)}));return function(t,i){return e.apply(this,arguments)}}(),importData:function(e,t){console.log(e,t),this.commiuntyName=t.communityName,this.dialogVisible=!0},onSuccess:function(){this.$message.success("文件上传成功！"),this.handleClose()},handleClose:function(){this.dialogVisible=!1,this.fileList=[]},handleDeleteOfficer:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(t,i){var r=this;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:this.$confirm("此操作将删除该小区和警员关系, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(Object(a["a"])(regeneratorRuntime.mark(function e(){return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,y.detachRelation({communityId:i.communityId,officerIds:[i.id]});case 2:e.sent,r.$message({type:"success",message:"删除成功!"}),r.$parent.getOfficerList();case 5:case"end":return e.stop()}},e,this)}))).catch(function(e){r.$message({type:"info",message:"已取消删除"})});case 1:case"end":return e.stop()}},e,this)}));return function(t,i){return e.apply(this,arguments)}}()}},I=_,S=(i("81b7"),Object(v["a"])(I,c,s,!1,null,"2fae8a4c",null));S.options.__file="index.vue";var $=S.exports,P=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{attrs:{title:"新建小区",visible:e.showEdit,width:"800px"},on:{close:e.close}},[i("div",{staticClass:"officer-edit"},[i("el-form",{ref:"editForm",attrs:{inline:!0,model:e.editForm,rules:e.rules,"label-position":"right","label-width":"150px"}},[i("el-form-item",{attrs:{label:"行政区划",prop:"communityRegion"}},[i("el-input",{attrs:{placeholder:"行政区划"},model:{value:e.editForm.communityRegion,callback:function(t){e.$set(e.editForm,"communityRegion",t)},expression:"editForm.communityRegion"}})],1),i("el-form-item",{attrs:{label:"街道",prop:"communityStreet"}},[i("el-input",{attrs:{placeholder:"街道"},model:{value:e.editForm.communityStreet,callback:function(t){e.$set(e.editForm,"communityStreet",t)},expression:"editForm.communityStreet"}})],1),i("el-form-item",{attrs:{label:"居委会",prop:"communityCommittee"}},[i("el-input",{attrs:{placeholder:"居委会"},model:{value:e.editForm.communityCommittee,callback:function(t){e.$set(e.editForm,"communityCommittee",t)},expression:"editForm.communityCommittee"}})],1),i("el-form-item",{attrs:{label:"街路巷/小区",prop:"communityName"}},[i("el-input",{attrs:{placeholder:"街路巷/小区"},model:{value:e.editForm.communityName,callback:function(t){e.$set(e.editForm,"communityName",t)},expression:"editForm.communityName"}})],1),e._l(e.editForm.officerInfos,function(t,r){return i("el-form-item",{key:t.key,attrs:{label:"负责民警"+[r+1],prop:"officerInfos."+r+".officerName","label-width":"140px"}},[i("el-select",{staticStyle:{width:"120px"},attrs:{placeholder:"请输入搜索",filterable:"",clearable:"",remote:"",loading:e.loading,"remote-method":e.queryOfficerName},on:{change:function(i){e.choseSelectOfficer(r,t.officerName)}},model:{value:t.officerName,callback:function(i){e.$set(t,"officerName",i)},expression:"officerInfo.officerName"}},e._l(e.officerLists,function(t){return i("el-option",{key:t.officerName,attrs:{label:t.officerName,value:t}},[i("span",{staticStyle:{float:"left"}},[e._v(e._s(t.officerName))]),i("span",{staticStyle:{float:"right",color:"#8492a6","font-size":"13px"}},[e._v(e._s(t.officerNo))])])})),i("span",{staticStyle:{"padding-left":"40px","padding-right":"10px"}},[e._v("警号")]),i("el-select",{staticStyle:{width:"130px"},attrs:{placeholder:"请输入搜索",filterable:"",clearable:"",remote:"",loading:e.loading,"remote-method":e.queryOfficerName},on:{change:function(i){e.choseSelectOfficer(r,t.officerId)}},model:{value:t.officerId,callback:function(i){e.$set(t,"officerId",i)},expression:"officerInfo.officerId"}},e._l(e.officerLists,function(t){return i("el-option",{key:t.officerNo,attrs:{label:t.officerNo,value:t}},[i("span",{staticStyle:{float:"left"}},[e._v(e._s(t.officerName))]),i("span",{staticStyle:{float:"right",color:"#8492a6","font-size":"13px"}},[e._v(e._s(t.officerNo))])])})),i("span",{staticStyle:{"padding-left":"40px","padding-right":"10px"}},[e._v("电话")]),i("el-select",{staticStyle:{width:"150px"},attrs:{placeholder:"",filterable:"",clearable:"",remote:""},on:{change:function(i){e.choseSelectOfficer(r,t.officerPhone)}},model:{value:t.officerPhone,callback:function(i){e.$set(t,"officerPhone",i)},expression:"officerInfo.officerPhone"}},e._l(e.officerLists,function(t){return i("el-option",{key:t.officerPhone,attrs:{label:t.officerPhone,value:t}},[i("span",{staticStyle:{float:"left"}},[e._v(e._s(t.officerName))]),i("span",{staticStyle:{float:"right",color:"#8492a6","font-size":"13px"}},[e._v(e._s(t.officerNo))])])}))],1)}),i("el-form-item",{staticStyle:{"text-align":"right","margin-bottom":"0","padding-left":"100px"}},[i("el-button",{attrs:{size:"small",type:"primary"},on:{click:e.addOfficer}},[e._v("添加民警")])],1),i("el-form-item",{staticStyle:{"text-align":"right","margin-bottom":"0","padding-left":"151px"}},[i("el-button",{attrs:{size:"small",type:"primary"},on:{click:e.submit}},[e._v("确认")]),i("el-button",{attrs:{size:"small",type:"primary",plain:""},on:{click:e.close}},[e._v("取消")]),i("el-button",{attrs:{size:"small",type:"primary",plain:""},on:{click:e.resetForm}},[e._v("重置")])],1)],2)],1)])},L=[],q={props:{},data:function(){return{showEdit:!1,loading:!1,loadingArea:!1,editForm:{communityRegion:"",communityStreet:"",communityCommittee:"",communityName:"",officerInfos:[{id:0,officerName:"",officerId:"",officerPhone:""}]},officerLists:[],communityList:[],rules:{communityRegion:[{required:!0,message:"行政区划",trigger:"blur"}],communityStreet:[{required:!0,message:"街道",trigger:"blur"}],communityName:[{required:!0,message:"街路巷/小区",trigger:"blur"}],officerId:[{required:!0,message:"请选择警号",trigger:"blur"}],officerName:[{required:!0,message:"请选择姓名",trigger:"blur"}],officerPhone:[{required:!0,message:"请选择电话",trigger:"blur"}]}}},methods:{addOfficer:function(){this.editForm.officerInfos.push({officerName:"",officerId:"",officerPhone:"",key:Date.now()})},getCommunityList:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(t){var i;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return this.loadingArea=!0,e.next=3,y.getCommunityList({communityName:t});case 3:i=e.sent,this.communityList=i.data,this.loadingArea=!1;case 6:case"end":return e.stop()}},e,this)}));return function(t){return e.apply(this,arguments)}}(),queryOfficerName:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(t){var i;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:if(""===t){e.next=9;break}return this.loading=!0,e.next=4,y.queryOfficerName({officerName:t});case 4:i=e.sent,this.officerLists=i.data,this.loading=!1,e.next=10;break;case 9:this.officerLists=[];case 10:case"end":return e.stop()}},e,this)}));return function(t){return e.apply(this,arguments)}}(),saveCommunity:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return JSON.stringify(this.editForm),e.next=3,y.saveNewCommunity(this.editForm);case 3:t=e.sent,200===t.code?this.$message({type:"success",message:"添加成功!"}):this.$message({type:"info",message:"添加失败"+t.msg}),this.showEdit=!1,this.$parent.getOfficerList();case 7:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),submit:function(){var e=this;this.$refs.editForm.validate(function(t){if(!t)return!1;e.saveCommunity()})},choseSelectOfficer:function(e,t){this.editForm.officerInfos[e].officerId=t.officerNo,this.editForm.officerInfos[e].id=t.id,this.editForm.officerInfos[e].officerName=t.officerName,this.editForm.officerInfos[e].officerPhone=t.officerPhone},close:function(){this.$refs.editForm.resetFields(),this.showEdit=!1,this.communityList=[]},show:function(){this.showEdit=!0,this.$set(this.editForm,"officerInfos",[{officerName:"",officerId:"",officerPhone:""}])},resetForm:function(){this.$refs.editForm.resetFields(),this.$set(this.editForm,"officerInfos",[{officerName:"",officerId:"",officerPhone:""}])}}},z=q,j=(i("df35"),Object(v["a"])(z,P,L,!1,null,null,null));j.options.__file="CommunityNew.vue";var E=j.exports,B={components:{MainTable:$,CommunityNew:E},data:function(){return{policeMessageForm:{officerName:"",officerNo:"",communityName:""},loadingTable:!1,page:{show:!0,total:0},currentPage:1,tableData:[],columns:[{label:"序号",type:"index"},{label:"行政区划（区、县)",prop:"communityRegion"},{label:"街道",prop:"communityStreet"},{label:"居委会",prop:"communityCommittee"},{label:"小区名称",prop:"communityName"},{label:"小区户数",prop:"communityNum"},{label:"负责警员",prop:"officerName"},{label:"操作",opration:"edit",width:350}]}},methods:{getOfficerList:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,i;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return this.loadingTable=!0,t=Object(o["a"])({},this.policeMessageForm,{currentPage:this.currentPage}),e.next=4,y.getOfficerList(t);case 4:i=e.sent,this.tableData=i.data,this.page.total=i.totalSize,this.loadingTable=!1;case 8:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),handleSearch:function(){this.$refs.table.currentChangePage(1)},policeEdit:function(){this.$refs.dialogAdd.show()},newCommunity:function(){this.$refs.communityAdd.show()},currentChange:function(e){this.currentPage=e,this.getOfficerList()}},mounted:function(){this.getOfficerList()}},M=B,A=(i("db77"),Object(v["a"])(M,r,n,!1,null,null,null));A.options.__file="index.vue";t["default"]=A.exports},"15ef":function(e,t,i){"use strict";var r=i("dede"),n=i.n(r);n.a},"23c4":function(e,t,i){},"512e":function(e,t,i){},6998:function(e,t,i){},"81b7":function(e,t,i){"use strict";var r=i("512e"),n=i.n(r);n.a},8502:function(e,t,i){},db77:function(e,t,i){"use strict";var r=i("23c4"),n=i.n(r);n.a},dede:function(e,t,i){},df35:function(e,t,i){"use strict";var r=i("8502"),n=i.n(r);n.a},fdefc:function(e,t,i){"use strict";var r=i("6998"),n=i.n(r);n.a}}]);
//# sourceMappingURL=chunk-5a14c4f6.ebb0b20f.js.map