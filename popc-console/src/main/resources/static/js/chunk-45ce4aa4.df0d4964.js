(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-45ce4aa4"],{"2be1":function(e,t,r){},"3f00":function(e,t,r){"use strict";var n=r("2be1"),o=r.n(n);o.a},ec75:function(e,t,r){"use strict";r.r(t);var n=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"power-manage"},[r("div",{staticClass:"clearfix"},[r("el-form",{staticClass:"form-inline",attrs:{inline:!0,model:e.formInline}},[r("el-form-item",{attrs:{label:"姓名"}},[r("el-input",{attrs:{size:"small",placeholder:"请输入",clearable:""},model:{value:e.formInline.officerName,callback:function(t){e.$set(e.formInline,"officerName",t)},expression:"formInline.officerName"}})],1),r("el-form-item",{attrs:{label:"警号"}},[r("el-input",{attrs:{size:"small",placeholder:"请输入",clearable:""},model:{value:e.formInline.officerNo,callback:function(t){e.$set(e.formInline,"officerNo",t)},expression:"formInline.officerNo"}})],1),r("el-form-item",{attrs:{label:"单位"}},[r("el-input",{attrs:{size:"small",placeholder:"请输入",clearable:""},model:{value:e.formInline.officerStation,callback:function(t){e.$set(e.formInline,"officerStation",t)},expression:"formInline.officerStation"}})],1),r("el-form-item",[r("el-button",{attrs:{type:"primary",size:"small"},on:{click:e.onQuery}},[e._v("查询")])],1)],1),r("el-button",{staticStyle:{float:"right"},attrs:{icon:"el-icon-plus",type:"primary",size:"small"},on:{click:function(t){e.onOpenDialog("新增")}}},[e._v("新增人员\n    ")])],1),r("div",{staticClass:"table-box"},[r("el-table",{attrs:{data:e.tableData,border:""}},[r("el-table-column",{attrs:{prop:"officerName",label:"姓名",width:"120"}}),r("el-table-column",{attrs:{prop:"officerNo",label:"警号"}}),r("el-table-column",{attrs:{prop:"officerStation",label:"所属单位"}}),r("el-table-column",{attrs:{prop:"officerPhone",label:"联系方式"}}),r("el-table-column",{attrs:{prop:"status",label:"当前状态"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n          "+e._s(0===t.row.status?"有效":"无效")+"\n        ")]}}])}),r("el-table-column",{attrs:{prop:"operate",label:"操作",width:"200"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("el-button",{attrs:{type:"text",size:"small"},on:{click:function(r){e.onOpenDialog("编辑",t.row)}}},[e._v("编辑")]),r("el-button",{attrs:{type:"text",size:"small"},on:{click:function(r){e.handlePassword(t.row)}}},[e._v("密码重置")]),r("el-button",{attrs:{type:"text",size:"small"},on:{click:function(r){e.handleStatus(t.row)}}},[e._v("\n            "+e._s(0===t.row.status?"禁用":"启用")+"\n          ")]),r("el-button",{attrs:{type:"text",size:"small"},on:{click:function(r){e.handleDelete(t.row)}}},[e._v("删除")])]}}])})],1),r("el-pagination",{staticStyle:{"text-align":"right",padding:"20px 0"},attrs:{background:"","current-page":e.currentPage,"page-size":10,layout:"total, prev, pager, next",total:e.total},on:{"current-change":e.currentChange}})],1),r("el-dialog",{attrs:{title:e.dialogTitle,visible:e.dialogVisible,width:"50%"},on:{close:e.closeDialog,"update:visible":function(t){e.dialogVisible=t}}},[r("div",[r("el-form",{ref:"ruleForm",attrs:{"label-width":"80px",model:e.formPower,rules:e.rules}},[r("el-form-item",{attrs:{label:"姓名",prop:"officerName"}},[r("el-input",{attrs:{placeholder:"请输入",clearable:""},model:{value:e.formPower.officerName,callback:function(t){e.$set(e.formPower,"officerName",t)},expression:"formPower.officerName"}})],1),r("el-form-item",{attrs:{label:"警号",prop:"officerNo"}},[r("el-input",{attrs:{placeholder:"请输入",clearable:""},model:{value:e.formPower.officerNo,callback:function(t){e.$set(e.formPower,"officerNo",t)},expression:"formPower.officerNo"}})],1),r("el-form-item",{attrs:{label:"联系方式",prop:"officerPhone"}},[r("el-input",{attrs:{placeholder:"请输入",clearable:""},model:{value:e.formPower.officerPhone,callback:function(t){e.$set(e.formPower,"officerPhone",e._n(t))},expression:"formPower.officerPhone"}})],1),r("el-form-item",{attrs:{label:"所属单位",prop:"officerStation"}},[r("el-input",{attrs:{placeholder:"请输入",clearable:""},model:{value:e.formPower.officerStation,callback:function(t){e.$set(e.formPower,"officerStation",e._n(t))},expression:"formPower.officerStation"}})],1),r("el-form-item",{attrs:{label:"权限选择",prop:"menuIds"}},[r("el-checkbox-group",{model:{value:e.formPower.menuIds,callback:function(t){e.$set(e.formPower,"menuIds",t)},expression:"formPower.menuIds"}},e._l(e.powerList,function(t,n){return r("el-checkbox",{key:n,staticStyle:{"margin-left":"20px"},attrs:{label:t.value}},[e._v("\n              "+e._s(t.label)+"\n            ")])}))],1)],1)],1),r("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{attrs:{size:"small"},on:{click:e.closeDialog}},[e._v("返回")]),r("el-button",{attrs:{size:"small",type:"primary"},on:{click:e.onSaveFun}},[e._v("保存")])],1)])],1)},o=[],a=(r("28a5"),r("be94")),i=(r("7f7f"),r("96cf"),r("1da1")),s={manageAuth:{API:{getListMenu:"user/right/listMenuResource",getPoliceInfo:"user/right/queryByCondition",dealInfo:"user/right/updateById",resetPassword:"user/right/resetPassword",saveOfficerInfo:"user/right/saveOfficerInfo"}}},l=s,c=r("7c15"),f=l.manageAuth.API,u={getPoliceInfo:function(){var e=Object(i["a"])(regeneratorRuntime.mark(function e(){var t,r,n=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=n.length>0&&void 0!==n[0]?n[0]:{},e.next=3,c["a"].get(f["getPoliceInfo"],t);case 3:return r=e.sent,e.abrupt("return",r);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),dealInfo:function(){var e=Object(i["a"])(regeneratorRuntime.mark(function e(){var t,r,n=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=n.length>0&&void 0!==n[0]?n[0]:{},e.next=3,c["a"].get(f["dealInfo"],t);case 3:return r=e.sent,e.abrupt("return",r);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),resetPassword:function(){var e=Object(i["a"])(regeneratorRuntime.mark(function e(){var t,r,n=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=n.length>0&&void 0!==n[0]?n[0]:{},e.next=3,c["a"].get(f["resetPassword"],t);case 3:return r=e.sent,e.abrupt("return",r);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),saveOfficerInfo:function(){var e=Object(i["a"])(regeneratorRuntime.mark(function e(){var t,r,n=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=n.length>0&&void 0!==n[0]?n[0]:{},e.next=3,c["a"].get(f["saveOfficerInfo"],t);case 3:return r=e.sent,e.abrupt("return",r);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),getListMenu:function(){var e=Object(i["a"])(regeneratorRuntime.mark(function e(){var t,r,n=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=n.length>0&&void 0!==n[0]?n[0]:{},e.next=3,c["a"].get(f["getListMenu"],t);case 3:return r=e.sent,e.abrupt("return",r);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}()},m={name:"ManageAuthority",data:function(){return{formInline:{officerName:"",officerNo:"",officerStation:""},options:[{value:"选项1",label:"黄金糕"},{value:"选项2",label:"双皮奶"}],value:"",tableData:[],total:0,currentPage:1,dialogVisible:!1,dialogTitle:"新增人员",formPower:{officerName:"",officerNo:"",officerPhone:"",officerStation:"",menuIds:[]},powerList:[],rules:{officerName:[{required:!0,message:"请输入名称",trigger:"blur"}],officerNo:[{required:!0,message:"请输入警号",trigger:"blur"}],officerPhone:[{required:!0,message:"请输入电话号",trigger:"blur"}],officerStation:[{required:!0,message:"请输入单位",trigger:"blur"}],menuIds:[{required:!0,message:"请选择权限",trigger:"change"}]},editId:""}},methods:{getListMenu:function(){var e=Object(i["a"])(regeneratorRuntime.mark(function e(){var t;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,u.getListMenu();case 2:t=e.sent,this.powerList=t.data.map(function(e){return{label:e.name,value:e.id+""}});case 4:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),saveOfficerInfo:function(){var e=Object(i["a"])(regeneratorRuntime.mark(function e(t){return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,u.saveOfficerInfo(t);case 2:e.sent,this.closeDialog(),this.dialogVisible=!1,this.getPoliceInfo();case 6:case"end":return e.stop()}},e,this)}));return function(t){return e.apply(this,arguments)}}(),resetPassword:function(){var e=Object(i["a"])(regeneratorRuntime.mark(function e(t){return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,u.resetPassword({id:t.id});case 2:e.sent,this.$message({type:"success",message:"密码重置成功!"});case 4:case"end":return e.stop()}},e,this)}));return function(t){return e.apply(this,arguments)}}(),getPoliceInfo:function(){var e=Object(i["a"])(regeneratorRuntime.mark(function e(){var t,r;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=Object(a["a"])({currentPage:this.currentPage},this.formInline),e.next=3,u.getPoliceInfo(t);case 3:r=e.sent,this.tableData=r.data,this.total=r.totalSize;case 6:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),dealInfo:function(){var e=Object(i["a"])(regeneratorRuntime.mark(function e(t,r){return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,u.dealInfo(t);case 2:"delete"===r?this.$message({type:"success",message:"删除成功!"}):"status"===r&&this.$message({type:"success",message:"状态修改成功!"}),this.getPoliceInfo();case 4:case"end":return e.stop()}},e,this)}));return function(t,r){return e.apply(this,arguments)}}(),onQuery:function(){this.currentPage=1,this.getPoliceInfo()},currentChange:function(e){this.currentPage=e,this.getPoliceInfo()},onOpenDialog:function(e,t){this.dialogTitle=e+"人员","编辑"===e&&(this.editId=t.id,this.formPower.officerName=t.officerName,this.formPower.officerNo=t.officerNo,this.formPower.officerPhone=t.officerPhone,this.formPower.officerStation=t.officerStation,this.formPower.menuIds=t.menuIds.split(",")),this.dialogVisible=!0},handleClick:function(){this.$message({type:"success",message:"启用成功!"})},handlePassword:function(e){var t=this;this.$confirm("此操作将重置密码, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.resetPassword(e)}).catch(function(){t.$message({type:"info",message:"已取消"})})},handleStatus:function(e){var t=this,r={id:e.id,status:0===e.status?1:0};this.$confirm("此操作将修改状态, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.dealInfo(r,"status")}).catch(function(){t.$message({type:"info",message:"已取消"})})},handleDelete:function(e){var t=this;this.$confirm("确认删除, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var r={id:e.id,deleted:1};t.dealInfo(r,"delete")}).catch(function(){t.$message({type:"info",message:"已取消删除"})})},onSaveFun:function(){var e=this;this.$refs.ruleForm.validate(function(t){if(!t)return!1;var r=Object(a["a"])({},e.formPower,{menuIds:e.formPower.menuIds.join(",")});e.editId&&(r["id"]=e.editId),e.saveOfficerInfo(r)})},closeDialog:function(){this.$refs.ruleForm.resetFields(),this.formPower={officerName:"",officerNo:"",officerPhone:"",officerStation:"",menuIds:[]},this.editId="",this.dialogVisible=!1}},mounted:function(){this.getListMenu(),this.getPoliceInfo()}},p=m,d=(r("3f00"),r("2877")),h=Object(d["a"])(p,n,o,!1,null,"7ac0cf2c",null);h.options.__file="index.vue";t["default"]=h.exports}}]);
//# sourceMappingURL=chunk-45ce4aa4.df0d4964.js.map