(window["webpackJsonpwork-logger-client"]=window["webpackJsonpwork-logger-client"]||[]).push([[0],{22:function(e,t,n){e.exports=n(51)},45:function(e,t,n){},48:function(e,t,n){},49:function(e,t,n){},50:function(e,t,n){},51:function(e,t,n){"use strict";n.r(t);var r=n(0),a=n.n(r),s=n(4),c=n.n(s),o=n(2),u=n.n(o),i=n(3),l=n(15),g=n(16),m=n(19),p=n(17),d=n(20),k=n(18),f=n.n(k).a.create({baseURL:"https://work-logger-app.herokuapp.com"}),b=n(53),w=(n(45),function(e){var t=e.mounted?"movedown":null,n=e.success?"alert-success":"alert-danger";return a.a.createElement(b.a,{in:e.mounted,timeout:1e3,classNames:"fade"},a.a.createElement("div",{className:"alert ".concat(n," ").concat(t),role:"alert"},e.success?"Success!":"Something went wrong!"))}),L=(n(48),function(e){var t=function(){var t=Object(i.a)(u.a.mark((function t(){return u.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:if(t.prev=0,e.isInside){t.next=5;break}return t.next=4,f.post("/log",{dateString:(new Date).toString()});case 4:e.trackLogRequest(!0,!0);case 5:t.next=10;break;case 7:t.prev=7,t.t0=t.catch(0),"Network Error"===t.t0.message?e.trackLogRequest(!0,!0):e.trackLogRequest(!1,!1);case 10:case"end":return t.stop()}}),t,null,[[0,7]])})));return function(){return t.apply(this,arguments)}}();return e.isInside?a.a.createElement("div",{className:"entered-border"},a.a.createElement("button",{className:"btn btn-primary button enter-button",onClick:t},"Enter")):a.a.createElement("button",{className:"btn btn-primary button",onClick:t},"Enter")}),v=function(e){var t=function(){var t=Object(i.a)(u.a.mark((function t(){return u.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:if(t.prev=0,e.isInside){t.next=3;break}throw new Error("Can't exit without entering!");case 3:return t.next=5,f.put("/log",{dateString:(new Date).toString()});case 5:e.trackLogRequest(!0,!1),t.next=11;break;case 8:t.prev=8,t.t0=t.catch(0),"Network Error"===t.t0.message?e.trackLogRequest(!0,!1):e.trackLogRequest(!1,null);case 11:case"end":return t.stop()}}),t,null,[[0,8]])})));return function(){return t.apply(this,arguments)}}();return a.a.createElement("button",{className:"btn btn-primary button",onClick:t},"Exit")},E=function(e){var t=function(){var t=Object(i.a)(u.a.mark((function t(){return u.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,f.get("/log",{params:{dateString:(new Date).toString()}});case 3:e.isInside?e.trackLogRequest(!0,!0):e.trackLogRequest(!0,!1),t.next=9;break;case 6:t.prev=6,t.t0=t.catch(0),"Network Error"===t.t0.message?e.trackLogRequest(!0,!1):e.trackLogRequest(!1,!0);case 9:case"end":return t.stop()}}),t,null,[[0,6]])})));return function(){return t.apply(this,arguments)}}();return a.a.createElement("button",{className:"btn btn-primary button",onClick:t},"Send Log")},h=(n(49),function(e){return a.a.createElement("div",{className:"menu"},a.a.createElement("h1",{className:"heading"},a.a.createElement("img",{className:"techsee-icon",src:"".concat("","/icon.png"),alt:""})," Work Logger"),a.a.createElement(L,{trackLogRequest:e.trackLogRequest,isInside:e.isInside}),a.a.createElement(v,{trackLogRequest:e.trackLogRequest,isInside:e.isInside}),a.a.createElement(E,{trackLogRequest:e.trackLogRequest,isInside:e.isInside}))}),S=(n(50),function(e){function t(){var e,n;Object(l.a)(this,t);for(var r=arguments.length,s=new Array(r),c=0;c<r;c++)s[c]=arguments[c];return(n=Object(m.a)(this,(e=Object(p.a)(t)).call.apply(e,[this].concat(s)))).state={logStatus:!1,success:!0,enter:!1,isLoading:!0},n.componentDidMount=Object(i.a)(u.a.mark((function e(){return u.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,f.get("/log",{params:{dateString:(new Date).toString()}});case 3:e.sent.data?n.setState({isLoading:!1}):n.setState({enter:!1,isLoading:!1}),e.next=10;break;case 7:e.prev=7,e.t0=e.catch(0),n.setState({enter:!0,isLoading:!1});case 10:case"end":return e.stop()}}),e,null,[[0,7]])}))),n.trackLogRequest=function(e,t){n.setState({logStatus:!0,success:e,enter:t}),setTimeout((function(){return n.setState({logStatus:!1})}),3e3)},n.renderLoader=function(){return a.a.createElement("div",{className:"spinner-border",role:"status"},a.a.createElement("span",{className:"sr-only"},"Loading..."))},n.renderContent=function(){return a.a.createElement(a.a.Fragment,null,a.a.createElement(w,{mounted:n.state.logStatus,success:n.state.success}),a.a.createElement(h,{trackLogRequest:n.trackLogRequest,isInside:n.state.enter}))},n.renderApp=function(){return n.state.isLoading?n.renderLoader():n.renderContent()},n}return Object(d.a)(t,e),Object(g.a)(t,[{key:"render",value:function(){return this.renderApp()}}]),t}(a.a.Component));c.a.render(a.a.createElement(S,null),document.querySelector("#root"))}},[[22,1,2]]]);
//# sourceMappingURL=main.a0f174b6.chunk.js.map