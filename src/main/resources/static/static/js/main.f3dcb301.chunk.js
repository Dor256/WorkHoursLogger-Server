(window["webpackJsonpwork-logger-client"]=window["webpackJsonpwork-logger-client"]||[]).push([[0],{22:function(e,t,n){e.exports=n(53)},45:function(e,t,n){},48:function(e,t,n){},49:function(e,t,n){},50:function(e,t,n){},51:function(e,t,n){},52:function(e,t,n){},53:function(e,t,n){"use strict";n.r(t);var a=n(0),r=n.n(a),c=n(4),s=n.n(c),i=n(1),o=n.n(i),u=n(3),l=n(5),g=n(6),p=n(8),m=n(7),f=n(9),d=n(20),h=n.n(d).a.create({baseURL:"https://work-logger-app.herokuapp.com"}),k=function(e){return!!e&&"techsee.me"===e.getBasicProfile().getEmail().split("@")[1]},b="351123592886-r4dbiuaq9ds53a94456ambh7tjcpm46k.apps.googleusercontent.com",E=n(55),S=(n(45),function(e){var t=e.mounted?"movedown":null,n=e.success?"alert-success":"alert-danger";return r.a.createElement(E.a,{in:e.mounted,timeout:1e3,classNames:"fade"},r.a.createElement("div",{className:"alert ".concat(n," ").concat(t),role:"alert"},e.success?"Success!":"Something went wrong!"))}),v=(n(48),function(e){var t=function(){var t=Object(u.a)(o.a.mark((function t(){return o.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:if(t.prev=0,e.isInside){t.next=5;break}return t.next=4,h.post("/log",{dateString:(new Date).toString()});case 4:e.trackLogRequest(!0,!0);case 5:t.next=10;break;case 7:t.prev=7,t.t0=t.catch(0),"Network Error"===t.t0.message?e.trackLogRequest(!0,!0):e.trackLogRequest(!1,!1);case 10:case"end":return t.stop()}}),t,null,[[0,7]])})));return function(){return t.apply(this,arguments)}}();return e.isInside?r.a.createElement("div",{className:"entered-border"},r.a.createElement("button",{className:"btn btn-primary button enter-button",onClick:t},"Enter")):r.a.createElement("button",{className:"btn btn-primary button",onClick:t},"Enter")}),L=function(e){var t=function(){var t=Object(u.a)(o.a.mark((function t(){return o.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:if(t.prev=0,!e.isInside){t.next=7;break}return t.next=4,h.put("/log",{dateString:(new Date).toString()});case 4:e.trackLogRequest(!0,!1),t.next=8;break;case 7:e.trackLogRequest(!1,null);case 8:t.next=13;break;case 10:t.prev=10,t.t0=t.catch(0),"Network Error"===t.t0.message&&e.trackLogRequest(!0,!1);case 13:case"end":return t.stop()}}),t,null,[[0,10]])})));return function(){return t.apply(this,arguments)}}();return r.a.createElement("button",{className:"btn btn-primary button",onClick:t},"Exit")},w=function(e){var t=function(){var t=Object(u.a)(o.a.mark((function t(){return o.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,h.post("/send",{dateString:(new Date).toString(),userEmail:gapi.auth2.getAuthInstance().currentUser.get().getBasicProfile().getEmail()});case 3:e.isInside?e.trackLogRequest(!0,!0):e.trackLogRequest(!0,!1),t.next=9;break;case 6:t.prev=6,t.t0=t.catch(0),"Network Error"===t.t0.message?e.trackLogRequest(!0,!1):e.trackLogRequest(!1,null);case 9:case"end":return t.stop()}}),t,null,[[0,6]])})));return function(){return t.apply(this,arguments)}}();return r.a.createElement("button",{className:"btn btn-primary button",onClick:t},"Send Log")},I=(n(49),n(50),function(e){function t(){var e,n;Object(l.a)(this,t);for(var a=arguments.length,r=new Array(a),c=0;c<a;c++)r[c]=arguments[c];return(n=Object(p.a)(this,(e=Object(m.a)(t)).call.apply(e,[this].concat(r)))).handleSignIn=function(){gapi.auth2.getAuthInstance().signIn()},n}return Object(f.a)(t,e),Object(g.a)(t,[{key:"render",value:function(){return r.a.createElement("div",{id:"auth-button",onClick:this.handleSignIn},r.a.createElement("img",{id:"auth-icon",src:"".concat("","/icon.png"),alt:""}),r.a.createElement("span",{id:"auth-text"},"Log In With TechSee User"))}}]),t}(r.a.Component)),q=function(e){return e.currentUser&&e.currentUser.isSignedIn()&&null!==e.isInOffice?r.a.createElement("div",{className:"menu"},r.a.createElement("h1",{className:"heading"},r.a.createElement("img",{className:"techsee-icon",src:"".concat("","/icon.png"),alt:""})," Work Logger"),r.a.createElement(v,{trackLogRequest:e.trackLogRequest,isInside:e.isInOffice}),r.a.createElement(L,{trackLogRequest:e.trackLogRequest,isInside:e.isInOffice}),r.a.createElement(w,{trackLogRequest:e.trackLogRequest,isInside:e.isInOffice})):r.a.createElement(I,null)},x=(n(51),function(){return r.a.createElement("div",{className:"spinner-border",role:"status"},r.a.createElement("span",{className:"sr-only"},"Loading..."))}),O=(n(52),function(e){function t(){var e,n;Object(l.a)(this,t);for(var a=arguments.length,c=new Array(a),s=0;s<a;s++)c[s]=arguments[s];return(n=Object(p.a)(this,(e=Object(m.a)(t)).call.apply(e,[this].concat(c)))).state={logStatus:!1,success:!0,enter:!1,isLoading:!0,currentUser:null},n.componentDidMount=function(){gapi.load("auth2:client",n.onAuthLoad)},n.onAuthLoad=Object(u.a)(o.a.mark((function e(){var t,a;return o.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,gapi.client.init({clientId:b,scope:"email"});case 2:(t=gapi.auth2.getAuthInstance()).isSignedIn.listen(n.onSignIn),(a=t.currentUser.get()).isSignedIn()?n.setState({currentUser:a,isLoading:!0}):n.setState({currentUser:a,isLoading:!1}),n.fetchAppStatus();case 7:case"end":return e.stop()}}),e)}))),n.onSignIn=function(e){e&&k(n.state.currentUser)?n.setState({isLoading:!1}):gapi.auth2.getAuthInstance().signOut()},n.fetchAppStatus=Object(u.a)(o.a.mark((function e(){return o.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(!n.state.currentUser||!n.state.currentUser.isSignedIn()){e.next=11;break}return e.prev=1,e.next=4,h.post("/check",{userEmail:n.state.currentUser.getBasicProfile().getEmail()});case 4:e.sent.data?n.setState({enter:!0,isLoading:!1}):n.setState({enter:!1,isLoading:!1}),e.next=11;break;case 8:e.prev=8,e.t0=e.catch(1),n.setState({enter:!0,isLoading:!1});case 11:case"end":return e.stop()}}),e,null,[[1,8]])}))),n.trackLogRequest=function(e,t){null!==t?n.setState({logStatus:!0,success:e,enter:t}):n.setState({logStatus:!0,success:e}),setTimeout((function(){return n.setState({logStatus:!1})}),3e3)},n.renderContent=function(){return r.a.createElement(r.a.Fragment,null,r.a.createElement(S,{mounted:n.state.logStatus,success:n.state.success}),r.a.createElement(q,{trackLogRequest:n.trackLogRequest,isInOffice:n.state.enter,currentUser:n.state.currentUser}))},n}return Object(f.a)(t,e),Object(g.a)(t,[{key:"render",value:function(){return this.state.isLoading?r.a.createElement(x,null):this.renderContent()}}]),t}(r.a.Component));s.a.render(r.a.createElement(O,null),document.querySelector("#root"))}},[[22,1,2]]]);
//# sourceMappingURL=main.f3dcb301.chunk.js.map