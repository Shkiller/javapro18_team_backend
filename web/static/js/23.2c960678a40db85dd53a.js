webpackJsonp([23],{"+CHs":function(e,s){},"N9p+":function(e,s,t){"use strict";Object.defineProperty(s,"__esModule",{value:!0});var i=t("Dd8w"),n=t.n(i),r=t("NYxO"),a=t("UBpT"),d=t("XjPE"),o=t("CqtB"),f=t("vjHR"),l={name:"Friends",components:{FriendsPossible:a.a,FriendsRequest:d.a,FriendsBlock:o.a,isLoading:f.a},data:function(){return{first_name:"",isLoad:!0,offset:0,itemPerPage:10,total:0}},computed:n()({},Object(r.c)("profile/friends",["getResultById"]),{friends:function(){var e=this;return 0===this.first_name.length?this.getResultById("friends"):this.getResultById("friends").filter(function(s){return-1!==s.first_name.toLowerCase().indexOf(e.first_name.toLowerCase())})}}),methods:n()({},Object(r.b)("profile/friends",["apiFriends","apiRequest"]),Object(r.d)("profile/friends",["setResult"]),{loadFrends:function(){var e=this;this.isLoad=!0,this.apiFriends({offset:this.offset,itemPerPage:this.itemPerPage}).then(function(s){e.total=s,e.isLoad=!1,e.offset=e.offset+e.itemPerPage})}}),mounted:function(){this.setResult({id:"friends",value:[]}),this.loadFrends()},i18n:{messages:{en:{myFriends:"My friends",enterFriend:"Start typing your friend's name ..."},ru:{myFriends:"Мои друзья",enterFriend:"Начните вводить имя друга..."}}}},c={render:function(){var e=this,s=e.$createElement,t=e._self._c||s;return t("div",{staticClass:"friends inner-page"},[t("div",{staticClass:"inner-page__main"},[t("div",{staticClass:"friends__header"},[t("h2",{staticClass:"friends__title"},[e._v(e._s(e.$t("myFriends")))]),t("div",{staticClass:"friends__search"},[t("div",{staticClass:"friends__search-icon"},[t("simple-svg",{attrs:{filepath:"/static/img/search.svg"}})],1),t("input",{directives:[{name:"model",rawName:"v-model",value:e.first_name,expression:"first_name"}],staticClass:"friends__search-input",attrs:{placeholder:e.$t("enterFriend")},domProps:{value:e.first_name},on:{input:function(s){s.target.composing||(e.first_name=s.target.value)}}})])]),t("div",{staticClass:"friends__list"},[e.friends.length>0?e._l(e.friends,function(e){return t("friends-block",{key:e.id,attrs:{friend:"friend",info:e}})}):e._e()],2),e.total>e.offset?t("is-loading",{directives:[{name:"load",rawName:"v-load",value:e.loadFrends,expression:"loadFrends"}],attrs:{isLoad:e.isLoad}}):e._e()],1),t("div",{staticClass:"inner-page__aside"},[t("friends-request"),t("br"),t("friends-possible")],1)])},staticRenderFns:[]};var u=t("VU/8")(l,c,!1,function(e){t("+CHs")},null,null);s.default=u.exports}});
//# sourceMappingURL=23.2c960678a40db85dd53a.js.map