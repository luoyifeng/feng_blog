(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-3bb8005f"],{"02f4":function(e,t,n){var a=n("4588"),o=n("be13");e.exports=function(e){return function(t,n){var r,i,l=String(o(t)),s=a(n),c=l.length;return s<0||s>=c?e?"":void 0:(r=l.charCodeAt(s),r<55296||r>56319||s+1===c||(i=l.charCodeAt(s+1))<56320||i>57343?e?l.charAt(s):r:e?l.slice(s,s+2):i-56320+(r-55296<<10)+65536)}}},"05be":function(e,t,n){"use strict";var a=n("8a45"),o=n.n(a);o.a},"1d89":function(e,t,n){},"1e2d":function(e,t,n){"use strict";var a=n("920b"),o=n.n(a);o.a},"2e31":function(e,t,n){},4981:function(e,t,n){"use strict";var a=n("6c01"),o=n.n(a);o.a},"5df3":function(e,t,n){"use strict";var a=n("02f4")(!0);n("01f9")(String,"String",function(e){this._t=String(e),this._i=0},function(){var e,t=this._t,n=this._i;return n>=t.length?{value:void 0,done:!0}:(e=a(t,n),this._i+=e.length,{value:e,done:!1})})},"6c01":function(e,t,n){},"8a45":function(e,t,n){},"8e90":function(e,t,n){"use strict";var a=n("2e31"),o=n.n(a);o.a},"920b":function(e,t,n){},ac6a:function(e,t,n){for(var a=n("cadf"),o=n("0d58"),r=n("2aba"),i=n("7726"),l=n("32e9"),s=n("84f2"),c=n("2b4c"),u=c("iterator"),f=c("toStringTag"),p=s.Array,d={CSSRuleList:!0,CSSStyleDeclaration:!1,CSSValueList:!1,ClientRectList:!1,DOMRectList:!1,DOMStringList:!1,DOMTokenList:!0,DataTransferItemList:!1,FileList:!1,HTMLAllCollection:!1,HTMLCollection:!1,HTMLFormElement:!1,HTMLSelectElement:!1,MediaList:!0,MimeTypeArray:!1,NamedNodeMap:!1,NodeList:!0,PaintRequestList:!1,Plugin:!1,PluginArray:!1,SVGLengthList:!1,SVGNumberList:!1,SVGPathSegList:!1,SVGPointList:!1,SVGStringList:!1,SVGTransformList:!1,SourceBufferList:!1,StyleSheetList:!0,TextTrackCueList:!1,TextTrackList:!1,TouchList:!1},m=o(d),b=0;b<m.length;b++){var h,v=m[b],g=d[v],I=i[v],_=I&&I.prototype;if(_&&(_[u]||l(_,u,p),_[f]||l(_,f,v),s[v]=p,g))for(h in a)_[h]||r(_,h,a[h],!0)}},b6e2:function(e,t,n){"use strict";n("96cf");var a=n("1da1"),o={houseInfo:{API:{getHouseInfo:"house/info/queryByCondition",getRoomInfo:"house/info/basic",getVisitInfo:"house/info/queryAllFeedbackByProCollId",getWaterTrend:"house/info/queryWaterTrendByProCollId",getShoppingInfo:"shopping/info/getShoppingInfoByProCollId",saveBasicCommunity:"house/info/saveBasicCommunity"}}},r=o,i=n("7c15"),l=r.houseInfo.API;t["a"]={getHouseInfo:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,i["a"].get(l["getHouseInfo"],t);case 3:return n=e.sent,e.abrupt("return",n);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),getRoomInfo:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,i["a"].get(l["getRoomInfo"],t);case 3:return n=e.sent,e.abrupt("return",n);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),getVisitInfo:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,i["a"].get(l["getVisitInfo"],t);case 3:return n=e.sent,e.abrupt("return",n);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),getWaterTrend:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,i["a"].get(l["getWaterTrend"],t);case 3:return n=e.sent,e.abrupt("return",n.data);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),getShoppingInfo:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,i["a"].get(l["getShoppingInfo"],t);case 3:return n=e.sent,e.abrupt("return",n.data);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),saveBasicCommunity:function(){var e=Object(a["a"])(regeneratorRuntime.mark(function e(){var t,n,a=arguments;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t=a.length>0&&void 0!==a[0]?a[0]:{},e.next=3,i["a"].get(l["saveBasicCommunity"],t);case 3:return n=e.sent,e.abrupt("return",n.data);case 5:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}()}},ec0c:function(e,t,n){"use strict";n.r(t);var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{directives:[{name:"loading",rawName:"v-loading",value:e.houseInfoLoading,expression:"houseInfoLoading"}]},[n("div",{staticStyle:{display:"flex","justify-content":"flex-end"}},[n("el-button",{attrs:{type:"primary"},on:{click:e.prevFunc}},[e._v("返回")])],1),n("el-tabs",{on:{"tab-click":e.handleClick},model:{value:e.activeTab,callback:function(t){e.activeTab=t},expression:"activeTab"}},[n("el-tab-pane",{attrs:{label:"房屋基本信息",name:"basic"}},[n("basic-info",{attrs:{"room-info":e.roomInfo},on:{indexInit:e.init}})],1),n("el-tab-pane",{attrs:{label:"房屋生活信息",name:"living"}},[n("living-info",{attrs:{"water-trend":e.waterTrend}})],1),n("el-tab-pane",{attrs:{label:"调查走访记录",name:"visit"}},[n("visit-info",{attrs:{"visit-info":e.visitInfo}})],1),n("el-tab-pane",{attrs:{label:"社会面采集信息",name:"shopping"}},[n("shop-info",{attrs:{"shop-info":e.shopInfo}})],1)],1)],1)},o=[];function r(e){if(Array.isArray(e))return e}function i(e,t){var n=[],a=!0,o=!1,r=void 0;try{for(var i,l=e[Symbol.iterator]();!(a=(i=l.next()).done);a=!0)if(n.push(i.value),t&&n.length===t)break}catch(s){o=!0,r=s}finally{try{a||null==l["return"]||l["return"]()}finally{if(o)throw r}}return n}function l(){throw new TypeError("Invalid attempt to destructure non-iterable instance")}function s(e,t){return r(e)||i(e,t)||l()}n("ac6a"),n("5df3"),n("96cf");var c=n("1da1"),u=(n("cadf"),n("551c"),n("097d"),function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"basic-info__wrapper"},[n("el-card",{staticClass:"basic-info__card",attrs:{shadow:"never"}},[n("div",{staticClass:"basic-info__header",attrs:{slot:"header"},slot:"header"},[n("span",{staticStyle:{"font-size":"14px"}},[e._v("基本信息")])]),n("section",{staticClass:"basic-info__content"},[[n("el-table",{staticStyle:{width:"100%"},attrs:{data:e.roomInfo.basicInfo,border:""}},[n("el-table-column",{attrs:{prop:"communityDistrict",align:"center",label:"行政区划（区、县）"}}),n("el-table-column",{attrs:{prop:"streetName",align:"center",label:"街道"}}),n("el-table-column",{attrs:{prop:"neighborhoodCommittee",align:"center",label:"居委会"}}),n("el-table-column",{attrs:{prop:"communityName",align:"center",label:"街路巷/小区名称"}}),n("el-table-column",{attrs:{prop:"apartmentNum",align:"center",label:"门牌号/楼栋号"}}),n("el-table-column",{attrs:{prop:"houseUnit",align:"center",label:"单元"}}),n("el-table-column",{attrs:{prop:"roomNum",align:"center",label:"室"}}),n("el-table-column",{attrs:{prop:"landlordName",align:"center",label:"房东姓名"}}),n("el-table-column",{attrs:{prop:"landlordId",align:"center",label:"身份证号"}}),n("el-table-column",{attrs:{prop:"houseStatus",align:"center",label:"房屋状态"}}),n("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(n){e.changeRoomInfo(t.row)}}},[e._v("修改\n              ")])]}}])})],1)]],2)]),n("br"),n("el-card",{staticClass:"basic-info__card",staticStyle:{position:"relative"},attrs:{shadow:"never"}},[n("div",{staticClass:"basic-info__header",attrs:{slot:"header"},slot:"header"},[n("span",{staticStyle:{"font-size":"14px"}},[e._v("入住人员信息")]),n("ul",{staticClass:"type-list"},[n("li",{staticClass:"switch-active",style:{display:null!=e.roomInfo&&null!=e.roomInfo.personTags&&-1!=e.roomInfo.personTags.indexOf("重点人员")?"inline-block":"none"}},[e._v("\n          重点\n        ")]),n("li",{staticClass:"switch-active",style:{display:null!=e.roomInfo&&null!=e.roomInfo.personTags&&-1!=e.roomInfo.personTags.indexOf("风险人员")?"inline-block":"none"}},[e._v("\n          风险\n        ")]),n("li",{staticClass:"switch-active",style:{display:null!=e.roomInfo&&null!=e.roomInfo.personTags&&-1!=e.roomInfo.personTags.indexOf("涉案人员")?"inline-block":"none"}},[e._v("\n          涉案\n        ")])])]),n("section",{staticClass:"basic-info__content"},[n("el-table",{staticStyle:{width:"100%"},attrs:{data:e.roomInfo.residentInfo,border:""}},[n("el-table-column",{attrs:{prop:"name",align:"center",label:"姓名"}}),n("el-table-column",{attrs:{prop:"relation",align:"center",label:"关系"}}),n("el-table-column",{attrs:{prop:"sex",align:"center",label:"性别"}}),n("el-table-column",{attrs:{prop:"nation",align:"center",label:"民族"}}),n("el-table-column",{attrs:{prop:"idNumber",align:"center",label:"公民身份证号码"}}),n("el-table-column",{attrs:{prop:"permanentAddress",align:"center",label:"户籍地址"}}),n("el-table-column",{attrs:{prop:"outflow",align:"center",label:"是否流出"}}),n("el-table-column",{attrs:{prop:"outflowInfo",align:"center",label:"流出原因及详址"}}),n("el-table-column",{attrs:{prop:"caseBackGround",align:"center",label:"案底情况"}}),n("el-table-column",{attrs:{prop:"workPlace",align:"center",label:"工作单位/服务处所"}}),n("el-table-column",{attrs:{prop:"post",align:"center",label:"职务"}}),n("el-table-column",{attrs:{prop:"phone",align:"center",label:"联系方式"}}),n("el-table-column",{attrs:{prop:"visitDate",align:"center",label:"走访日期"}}),n("el-table-column",{attrs:{prop:"checkPerson",align:"center",label:"核实人员"}}),n("el-table-column",{attrs:{prop:"checkPersonPhone",align:"center",label:"核实人员联系方式"}}),n("el-table-column",{attrs:{prop:"visitPerson",align:"center",label:"走访人员"}})],1)],1)]),n("br"),n("el-card",{staticClass:"basic-info__card",attrs:{shadow:"never"}},[n("div",{staticClass:"basic-info__header",attrs:{slot:"header"},slot:"header"},[n("span",{staticStyle:{"font-size":"14px"}},[e._v("房屋潜在隐患")])]),n("section",{staticClass:"basic-info__content"},[n("table",{staticClass:"basic-table"},[n("tr",[n("td",[e._v("人员隐患")]),n("td",[e._v(e._s(e.roomInfo&&e.roomInfo.hiddenDanger&&e.roomInfo.hiddenDanger.personDanger))])]),n("tr",[n("td",[e._v("房屋隐患")]),n("td",[e._v(e._s(e.roomInfo&&e.roomInfo.hiddenDanger&&e.roomInfo.hiddenDanger.houseDanger))])])])])]),n("br"),n("el-card",{staticClass:"basic-info__card",attrs:{shadow:"never"}},[n("div",{staticClass:"basic-info__header",attrs:{slot:"header"},slot:"header"},[n("span",{staticStyle:{"font-size":"14px"}},[e._v("交易信息")])]),n("section",{staticClass:"basic-info__content"},[n("ul",{staticClass:"basic-info__list"},e._l(e.roomInfo.dealInfo,function(t,a){return n("li",{key:a,staticClass:"basic-info__item"},[n("p",[e._v(e._s(t))])])}))])]),n("el-dialog",{attrs:{title:"小区信息修改",visible:e.dialogFormVisible},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[n("el-form",{ref:"communityForm",attrs:{model:e.form,rules:e.rules}},[n("el-form-item",{attrs:{label:"小区名称","label-width":e.formLabelWidth}},[n("el-input",{attrs:{autocomplete:"off",disabled:!0},model:{value:e.form.communityName,callback:function(t){e.$set(e.form,"communityName",t)},expression:"form.communityName"}})],1),n("el-form-item",{attrs:{label:"楼栋名称","label-width":e.formLabelWidth}},[n("el-input",{attrs:{autocomplete:"off",disabled:!0},model:{value:e.form.apartmentNum,callback:function(t){e.$set(e.form,"apartmentNum",t)},expression:"form.apartmentNum"}})],1),n("el-form-item",{attrs:{label:"房号","label-width":e.formLabelWidth}},[n("el-input",{attrs:{autocomplete:"off",disabled:!0},model:{value:e.form.houseUnit,callback:function(t){e.$set(e.form,"houseUnit",t)},expression:"form.houseUnit"}})],1),n("el-form-item",{attrs:{label:"房东姓名","label-width":e.formLabelWidth,prop:"landlordName"}},[n("el-input",{attrs:{autocomplete:"off"},model:{value:e.form.landlordName,callback:function(t){e.$set(e.form,"landlordName",t)},expression:"form.landlordName"}})],1),n("el-form-item",{attrs:{label:"身份证号","label-width":e.formLabelWidth,prop:"landlordId"}},[n("el-input",{attrs:{autocomplete:"off"},model:{value:e.form.landlordId,callback:function(t){e.$set(e.form,"landlordId",t)},expression:"form.landlordId"}})],1),n("el-form-item",{attrs:{label:"房屋状态","label-width":e.formLabelWidth}},[n("el-radio-group",{model:{value:e.form.houseStatus,callback:function(t){e.$set(e.form,"houseStatus",t)},expression:"form.houseStatus"}},[n("el-radio",{attrs:{label:"自住"}}),n("el-radio",{attrs:{label:"出租"}}),n("el-radio",{attrs:{label:"寄住"}})],1)],1)],1),n("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("返 回")]),n("el-button",{attrs:{type:"primary"},on:{click:e.submitSave}},[e._v("保 存")])],1)],1)],1)}),f=[],p=n("b6e2"),d={name:"RoomBaseInfo",data:function(){return{dialogFormVisible:!1,form:{name:"",region:"",date1:"",date2:"",delivery:!1,type:[],resource:"",desc:""},formLabelWidth:"120px",switchType:"1",rules:{landlordName:[{required:!0,message:"请输入房东姓名",trigger:"blur"}],residentId:[{required:!0,message:"请输入身份证号",trigger:"blur"}]}}},props:{roomInfo:Object},watch:{roomInfo:function(){if(void 0!=this.roomInfo.basicInfo&&null==this.roomInfo.basicInfo&&""==this.roomInfo.basicInfo){for(var e=0;e<this.roomInfo.basicInfo.length;e++)this.roomInfo.basicInfo[e]=JSON.parse(this.roomInfo.basicInfo[e]);for(var t=0;t<this.roomInfo.residentInfo.length;t++)this.roomInfo.residentInfo[t]=JSON.parse(this.roomInfo.residentInfo[t])}}},methods:{changeRoomInfo:function(e){this.form=e,this.dialogFormVisible=!0},saveBasicCommunity:function(){var e=Object(c["a"])(regeneratorRuntime.mark(function e(){var t,n;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t={proCollId:this.form.proCollId,landlordName:this.form.landlordName,landlordId:this.form.landlordId,houseStatus:this.form.houseStatus,id:this.form.id},e.next=3,p["a"].saveBasicCommunity(t);case 3:n=e.sent,this.$refs.communityForm.resetFields(),this.dialogFormVisible=!1,this.$emit("indexInit",n);case 7:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),submitSave:function(){var e=this;this.$refs.communityForm.validate(function(t){if(!t)return!1;e.saveBasicCommunity()})}}},m=d,b=(n("8e90"),n("2877")),h=Object(b["a"])(m,u,f,!1,null,null,null);h.options.__file="BasicInfo.vue";var v=h.exports,g=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"living-info__wrapper"},[n("el-card",{staticClass:"living-info",attrs:{shadow:"never"}},[n("div",{staticClass:"basic-info__header",attrs:{slot:"header"},slot:"header"},[n("span",{staticStyle:{"font-size":"14px"}},[e._v("用水信息")])]),n("section",{staticClass:"living-info__content"},[n("ve-line-chart",{attrs:{data:e.waterTrend}})],1)])],1)},I=[],_={props:{waterTrend:Object}},y=_,w=(n("1e2d"),Object(b["a"])(y,g,I,!1,null,null,null));w.options.__file="LivingInfo.vue";var C=w.exports,S=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"living-info__wrapper"},[n("div",{staticStyle:{padding:"20px 0"}},[n("span",[e._v("调查走访原因：")]),n("span",[e._v(e._s(e.abnormalInfo))])]),n("el-card",{staticClass:"living-info",attrs:{shadow:"never"}},[n("div",{staticClass:"basic-info__header",attrs:{slot:"header"},slot:"header"},[n("span",{staticStyle:{"font-size":"14px"}},[e._v("入住人员信息记录")]),n("ul",{staticClass:"type-list"},[n("li",{staticClass:"switch-active",style:{display:null!=e.personTagShow&&null!=e.visitInfo[e.activeNames]&&null!=e.visitInfo[e.activeNames].personTags&&-1!=e.visitInfo[e.activeNames].personTags.indexOf("重点人员")?"inline-block":"none"}},[e._v("重点")]),n("li",{staticClass:"switch-active",style:{display:null!=e.personTagShow&&null!=e.visitInfo[e.activeNames]&&null!=e.visitInfo[e.activeNames].personTags&&-1!=e.visitInfo[e.activeNames].personTags.indexOf("风险人员")?"inline-block":"none"}},[e._v("风险")]),n("li",{staticClass:"switch-active",style:{display:null!=e.personTagShow&&null!=e.visitInfo[e.activeNames]&&null!=e.visitInfo[e.activeNames].personTags&&-1!=e.visitInfo[e.activeNames].personTags.indexOf("涉案人员")?"inline-block":"none"}},[e._v("涉案")])])]),n("section",{staticClass:"living-info__content"},[n("el-collapse",{attrs:{accordion:""},on:{change:e.handleChange},model:{value:e.activeNames,callback:function(t){e.activeNames=t},expression:"activeNames"}},e._l(e.visitInfo,function(e,t){return n("el-collapse-item",{key:t,attrs:{title:e.createTime,name:t}},[n("el-table",{staticStyle:{width:"100%"},attrs:{data:e.residentsInfo,border:""}},[n("el-table-column",{attrs:{prop:"name",align:"center",label:"姓名"}}),n("el-table-column",{attrs:{prop:"relation",align:"center",label:"关系"}}),n("el-table-column",{attrs:{prop:"sex",align:"center",label:"性别"}}),n("el-table-column",{attrs:{prop:"nation",align:"center",label:"民族"}}),n("el-table-column",{attrs:{prop:"idNumber",align:"center",label:"公民身份证号码"}}),n("el-table-column",{attrs:{prop:"permanentAddress",align:"center",label:"户籍地址"}}),n("el-table-column",{attrs:{prop:"outflow",align:"center",label:"是否流出"}}),n("el-table-column",{attrs:{prop:"outflowInfo",align:"center",label:"流出原因及详址"}}),n("el-table-column",{attrs:{prop:"caseBackGround",align:"center",label:"案底情况"}}),n("el-table-column",{attrs:{prop:"workPlace",align:"center",label:"工作单位/服务处所"}}),n("el-table-column",{attrs:{prop:"post",align:"center",label:"职务"}}),n("el-table-column",{attrs:{prop:"phone",align:"center",label:"联系方式"}}),n("el-table-column",{attrs:{prop:"checkPerson",align:"center",label:"核实人员"}}),n("el-table-column",{attrs:{prop:"checkPersonPhone",align:"center",label:"核实人员电话"}}),n("el-table-column",{attrs:{prop:"visitPerson",align:"center",label:"走访人员"}})],1)],1)}))],1)]),n("br"),n("el-card",{staticClass:"basic-info__card",attrs:{shadow:"never"}},[n("div",{staticClass:"basic-info__header",attrs:{slot:"header"},slot:"header"},[n("span",{staticStyle:{"font-size":"14px"}},[e._v("房屋潜在隐患")])]),n("section",{staticClass:"basic-info__content"},[n("table",{staticClass:"basic-table"},[n("tr",[n("td",{staticStyle:{width:"35%"}},[e._v("人员隐患")]),n("td",[e._v(e._s(e.hiddenDanger.personDanger))])]),n("tr",[n("td",{staticStyle:{width:"35%"}},[e._v("房屋隐患")]),n("td",[e._v(e._s(e.hiddenDanger.houseDanger))])])])])])],1)},x=[],T={name:"RoomVisitInfo",props:{visitInfo:Array},data:function(){return{activeNames:0,switchType:"1",abnormalInfo:"",hiddenDanger:{houseDanger:"",personDanger:""},personTagShow:!0}},created:function(){console.log("visit info created")},methods:{handleChange:function(e){null!=e&&""!==e?(this.abnormalInfo=this.visitInfo[e].visitReason,this.hiddenDanger=this.visitInfo[e].hiddenDanger,this.personTagShow=!0):this.personTagShow=!1},changeSwitchType:function(e){this.switchType=e}}},k=T,N=(n("05be"),Object(b["a"])(k,S,x,!1,null,null,null));N.options.__file="VisitInfo.vue";var L=N.exports,R=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"basic-info__wrapper"},[n("el-card",{staticClass:"basic-info__card",attrs:{shadow:"never"}},[n("div",{staticClass:"basic-info__header",attrs:{slot:"header"},slot:"header"},[n("span",{staticStyle:{"font-size":"14px"}},[e._v("社采信息-1")])]),n("section",{staticClass:"basic-info__content"},[[n("el-table",{staticStyle:{width:"100%"},attrs:{data:null==(null==e.shopInfo||e.shopInfo.shoppingSocietyInfos)?[]:e.shopInfo.shoppingSocietyInfos,border:""}},[n("el-table-column",{attrs:{prop:"orderId",align:"center",label:"订单号"}}),n("el-table-column",{attrs:{prop:"orderPhone",align:"center",label:"手机号（订）"}}),n("el-table-column",{attrs:{prop:"senderName",align:"center",label:"姓名（寄）"}}),n("el-table-column",{attrs:{prop:"recipentPhone",align:"center",label:"手机号（收）"}}),n("el-table-column",{attrs:{prop:"registTime",align:"center",label:"登记时间"}})],1)]],2)]),n("br"),n("el-card",{staticClass:"basic-info__card",attrs:{shadow:"never"}},[n("div",{staticClass:"basic-info__header",attrs:{slot:"header"},slot:"header"},[n("span",{staticStyle:{"font-size":"14px"}},[e._v("社采信息-2")])]),n("section",{staticClass:"basic-info__content"},[[n("el-table",{staticStyle:{width:"100%"},attrs:{data:null==e.shopInfo||null==e.shopInfo.logisticsSocietyInfos?[]:e.shopInfo.logisticsSocietyInfos,border:""}},[n("el-table-column",{attrs:{prop:"senderIdNum",align:"center",label:"身份证号（寄）"}}),n("el-table-column",{attrs:{prop:"senderName",align:"center",label:"姓名（寄）"}}),n("el-table-column",{attrs:{prop:"senderPhone",align:"center",label:"手机号（寄）"}}),n("el-table-column",{attrs:{prop:"recipientName",align:"center",label:"姓名（收）"}}),n("el-table-column",{attrs:{prop:"recipientPhone",align:"center",label:"手机号（收）"}}),n("el-table-column",{attrs:{prop:"registTime",align:"center",label:"登记时间"}})],1)]],2)])],1)},O=[],P={name:"ShopInfo",data:function(){return{dialogFormVisible:!1,form:{name:"",region:"",date1:"",date2:"",delivery:!1,type:[],resource:"",desc:""},formLabelWidth:"120px",switchType:"1"}},props:{shopInfo:Array},watch:{roomInfo:function(){for(var e=0;e<this.roomInfo.basicInfo.length;e++)this.roomInfo.basicInfo[e]=JSON.parse(this.roomInfo.basicInfo[e])}},methods:{}},D=P,V=(n("f573"),Object(b["a"])(D,R,O,!1,null,null,null));V.options.__file="ShopInfo.vue";var B=V.exports,j={name:"RoomInfo",components:{BasicInfo:v,LivingInfo:C,VisitInfo:L,ShopInfo:B},data:function(){return{activeTab:"basic",proCollId:"",roomInfo:{},visitInfo:[],shopInfo:[],waterTrend:{},houseInfoLoading:!1}},mounted:function(){var e=this.$route.query.proCollId;this.proCollId=e,this.init()},methods:{init:function(){var e=Object(c["a"])(regeneratorRuntime.mark(function e(){var t,n,a,o,r,i,l,c,u;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return t={proCollId:this.proCollId},n=["getRoomInfo","getVisitInfo","getWaterTrend","getShoppingInfo"],a=n.map(function(e){return p["a"][e](t)}),this.houseInfoLoading=!0,e.next=6,Promise.all(a);case 6:o=e.sent,this.houseInfoLoading=!1,r=s(o,4),i=r[0],l=r[1],c=r[2],u=r[3],this.roomInfo=i.data,this.visitInfo=l.data,this.waterTrend=c,this.shopInfo=u;case 13:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),handleClick:function(e,t){},prevFunc:function(){this.$router.go(-1)}}},A=j,F=(n("4981"),Object(b["a"])(A,a,o,!1,null,null,null));F.options.__file="index.vue";t["default"]=F.exports},f573:function(e,t,n){"use strict";var a=n("1d89"),o=n.n(a);o.a}}]);
//# sourceMappingURL=chunk-3bb8005f.d7c4b78b.js.map