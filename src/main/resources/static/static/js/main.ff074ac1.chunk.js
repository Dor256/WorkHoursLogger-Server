(window["webpackJsonpwork-logger-client"]=window["webpackJsonpwork-logger-client"]||[]).push([[0],{34:function(e,t,n){e.exports=n(69)},57:function(e,t,n){},58:function(e,t,n){},59:function(e,t,n){},60:function(e,t,n){},61:function(e,t,n){},62:function(e,t,n){},68:function(e,t,n){},69:function(e,t,n){"use strict";n.r(t);var a=n(0),r=n.n(a),c=n(30),s=n.n(c),o=n(2),i=n.n(o),l=n(8),u=n(10),m=n(11),p=n(13),f=n(12),h=n(14),g=n(16),d=n(7),E=function(e){var t=e.getBasicProfile();return!!t&&("techsee.me"===t.getEmail().split("@")[1]||"workloggersd@gmail.com"===t.getEmail())},b=window.navigator.userAgent,v=-1===b.indexOf("Chrome")&&b.indexOf("Safari")>-1,w=!0,k="351123592886-r4dbiuaq9ds53a94456ambh7tjcpm46k.apps.googleusercontent.com",y=n(31),N=n.n(y).a.create({baseURL:"https://work-logger-app.herokuapp.com"}),O=(n(57),function(e){function t(){var e,n;Object(u.a)(this,t);for(var a=arguments.length,r=new Array(a),c=0;c<a;c++)r[c]=arguments[c];return(n=Object(p.a)(this,(e=Object(f.a)(t)).call.apply(e,[this].concat(r)))).state={visible:""},n.hideBanner=function(e){n.setState({visible:"visible hiding",tempBannerMessage:e}),setTimeout((function(){n.setState({tempBannerMessage:void 0,visible:""})}),1e3)},n}return Object(h.a)(t,e),Object(m.a)(t,[{key:"componentDidUpdate",value:function(e){this.props.bannerMessage!==e.bannerMessage&&(this.props.bannerMessage?this.props.bannerMessage&&this.setState({visible:"visible"}):this.hideBanner(e.bannerMessage))}},{key:"render",value:function(){var e=this.state,t=e.visible,n=e.tempBannerMessage,a=this.props.bannerMessage||n||{},c=a.message,s=void 0===c?"":c,o=a.type,i=void 0===o?"":o;return r.a.createElement("div",{className:"alert".concat(i," ").concat(t),role:"alert"},s)}}]),t}(r.a.Component)),S=(n(58),function(){return r.a.createElement("div",{className:"spinner-border",role:"status"},r.a.createElement("span",{className:"sr-only"},"Loading..."))}),x=function(e){var t=e.className,n=e.children,a=e.onClick;return r.a.createElement("button",{className:t,onClick:a},n)},B=(n(59),function(){return r.a.createElement(x,{className:"btn btn-primary button",onClick:function(){gapi.auth2.getAuthInstance().signIn()}},"Log In")}),L=function(e){var t=e.className,n=e.children;return r.a.createElement("div",{className:t},n)},M=(n(60),function(e){return r.a.createElement("h1",{className:e.className},e.children)}),j=function(e){var t=e.className,n=e.src;return r.a.createElement("img",{className:t,src:n,alt:""})},A=function(e){var t=e.className;return r.a.createElement(M,{className:"heading ".concat(t)},r.a.createElement(j,{className:"techsee-icon",src:"".concat("","/icon.png")}),"Work Logger")},C=function(e){return r.a.createElement("tr",{className:e.className},e.children)},T=function(e){var t=e.head,n=e.className,a=e.children;return t?r.a.createElement("th",{className:n},a):r.a.createElement("td",{className:n},a)},D=function(e){return r.a.createElement("thead",null,e.children)},F=function(){return r.a.createElement(D,null,r.a.createElement(C,null,r.a.createElement(T,{head:!0},"Date"),r.a.createElement(T,{head:!0},"Day"),r.a.createElement(T,{head:!0},"Start"),r.a.createElement(T,{head:!0},"Finish")))},I=function(e){var t=e.workEntry;return r.a.createElement(C,null,r.a.createElement(T,null,t.date),r.a.createElement(T,null,t.day),r.a.createElement(T,null,t.start),r.a.createElement(T,null,t.finish))},q=function(e){return r.a.createElement("tbody",null,e.children)},H=function(e){var t=e.workEntries;return r.a.createElement(q,null,t.map((function(e,t){return r.a.createElement(I,{key:t,workEntry:e})})))},P=function(e){var t=e.className,n=e.children;return r.a.createElement("table",{className:t},n)},R=(n(61),function(e){function t(){var e,n;Object(u.a)(this,t);for(var a=arguments.length,r=new Array(a),c=0;c<a;c++)r[c]=arguments[c];return(n=Object(p.a)(this,(e=Object(f.a)(t)).call.apply(e,[this].concat(r)))).state={workEntries:void 0},n}return Object(h.a)(t,e),Object(m.a)(t,[{key:"componentDidMount",value:function(){var e=Object(l.a)(i.a.mark((function e(){var t;return i.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,this.props.onShowTable();case 2:t=e.sent,this.setState({workEntries:t});case 4:case"end":return e.stop()}}),e,this)})));return function(){return e.apply(this,arguments)}}()},{key:"render",value:function(){var e=this.state.workEntries;return e?r.a.createElement(P,{className:"work-table"},r.a.createElement(F,null),r.a.createElement(H,{workEntries:e})):r.a.createElement(S,null)}}]),t}(r.a.Component)),W=(n(62),function(e){var t=r.a.createElement(x,{onClick:e.onClick,className:"btn btn-primary button".concat(e.inOffice?" enter-button":"")},"Enter");return e.inOffice?r.a.createElement(L,{className:"entered-border"},t):t}),G=function(e){var t=e.inOffice,n=e.onEmployeeLeave,a=e.onRequestLog,c=e.onEmployeeEnter;return r.a.createElement(r.a.Fragment,null,r.a.createElement(W,{onClick:c,inOffice:t}),r.a.createElement(x,{className:"btn btn-primary button",onClick:n},"Exit"),r.a.createElement(x,{className:"btn btn-primary button",onClick:a},"Send Log"),r.a.createElement(g.b,{className:"btn btn-primary button",to:"/show"},"Show Log"))},U=function(e){var t=e.userName,n=e.currentHour;return r.a.createElement(M,{className:"heading welcome-heading"},n<12&&n>0?"Good Morning, ".concat(t):n>=12&&n<18?"Good Afternoon, ".concat(t):"Good Evening, ".concat(t))},J=(n(68),3e3),Y=function(e){function t(){var e,n;Object(u.a)(this,t);for(var a=arguments.length,c=new Array(a),s=0;s<a;s++)c[s]=arguments[s];return(n=Object(p.a)(this,(e=Object(f.a)(t)).call.apply(e,[this].concat(c)))).state={isLoading:!0,userEmail:"",inOffice:!1},n.componentDidMount=function(){gapi.load("auth2:client",n.onAuthLoad)},n.onAuthLoad=Object(l.a)(i.a.mark((function e(){var t,a,r,c;return i.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,gapi.client.init({clientId:k,scope:"email"});case 3:t=gapi.auth2.getAuthInstance(),a=t.currentUser.get(),r=a.getBasicProfile(),t.isSignedIn.listen(n.onAuthAction(a)),a.getBasicProfile()||n.setState({isLoading:!1}),c=r.getEmail(),N.post("/check",{userEmail:c}).then((function(e){n.setState({inOffice:e.data,isLoading:!1,userEmail:c,user:a})})),e.next=15;break;case 12:e.prev=12,e.t0=e.catch(0),v&&alert("There is a bug with Safari, please clear your cache and try again in 5 minutes or open in private mode");case 15:case"end":return e.stop()}}),e,null,[[0,12]])}))),n.hideBanner=function(){n.setState({bannerMessage:void 0})},n.showBanner=function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:" alert-success",a=arguments.length>2&&void 0!==arguments[2]?arguments[2]:J;n.setState({bannerMessage:{message:e,type:t}}),setTimeout((function(){!n.state.bannerMessage||n.state.bannerMessage.message!==e||n.state.bannerMessage.type!==t||n.hideBanner()}),a)},n.onAuthAction=function(e){return function(t){var a=E(e);if(t&&a){var r=e.getBasicProfile().getEmail();n.setState({isLoading:!1,userEmail:r,user:e})}else a||(t?gapi.auth2.getAuthInstance().signOut():n.showBanner("You need a TechSee email to use this app"," alert-danger"))}},n.onEmployeeEnter=Object(l.a)(i.a.mark((function e(){var t,a,r;return i.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(t=n.state,a=t.inOffice,r=t.userEmail,e.prev=1,a){e.next=10;break}if(!w){e.next=6;break}return e.next=6,N.post("/log",{dateString:(new Date).toString(),userEmail:r});case 6:n.setState({inOffice:!0}),n.showBanner("Swiped in successfuly"),e.next=11;break;case 10:n.showBanner("Tried to swipe in while already swiped"," alert-danger");case 11:e.next=17;break;case 13:e.prev=13,e.t0=e.catch(1),n.showBanner("Failed to swipe in"," alert-danger"),console.error(e.t0);case 17:case"end":return e.stop()}}),e,null,[[1,13]])}))),n.onEmployeeLeave=Object(l.a)(i.a.mark((function e(){var t,a,r;return i.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(t=n.state,a=t.inOffice,r=t.userEmail,e.prev=1,!a){e.next=10;break}if(!w){e.next=6;break}return e.next=6,N.put("/log",{dateString:(new Date).toString(),userEmail:r});case 6:n.setState({inOffice:!1}),n.showBanner("Swiped out successfuly"),e.next=11;break;case 10:n.showBanner("Can't exit without entering"," alert-danger");case 11:e.next=16;break;case 13:e.prev=13,e.t0=e.catch(1),"Network Error"===e.t0.message&&(n.showBanner("Failed to swipe out"," alert-danger"),console.error(e.t0));case 16:case"end":return e.stop()}}),e,null,[[1,13]])}))),n.onRequestLog=Object(l.a)(i.a.mark((function e(){var t;return i.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(t=n.state.userEmail,e.prev=1,!w){e.next=5;break}return e.next=5,N.post("/send",{dateString:(new Date).toString(),userEmail:t});case 5:n.showBanner("Log sent successfuly"),e.next=12;break;case 8:e.prev=8,e.t0=e.catch(1),n.showBanner("Failed to send log"," alert-danger"),console.error(e.t0);case 12:case"end":return e.stop()}}),e,null,[[1,8]])}))),n.onShowTable=Object(l.a)(i.a.mark((function e(){var t,a;return i.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return t=n.state.userEmail,e.prev=1,e.next=4,N.post("/show",{dateString:(new Date).toString(),userEmail:t});case 4:return a=e.sent,e.abrupt("return",a.data);case 8:e.prev=8,e.t0=e.catch(1),n.showBanner("Failed to load table"," alert-danger"),console.log(e.t0);case 12:case"end":return e.stop()}}),e,null,[[1,8]])}))),n.renderWorkHoursTable=function(){return r.a.createElement(L,{className:"app-container"},r.a.createElement(R,{onShowTable:n.onShowTable}),r.a.createElement(g.b,{className:"btn btn-primary button",to:"/"},"Back"))},n.renderWorkLoggerMenu=function(){return n.state.user?r.a.createElement(r.a.Fragment,null,r.a.createElement(U,{userName:n.state.user.getBasicProfile().getName(),currentHour:(new Date).getHours()}),r.a.createElement(L,{className:"app-container menu"},r.a.createElement(O,{bannerMessage:n.state.bannerMessage}),r.a.createElement(A,null),r.a.createElement(G,{onEmployeeEnter:n.onEmployeeEnter,onEmployeeLeave:n.onEmployeeLeave,onRequestLog:n.onRequestLog,inOffice:n.state.inOffice}))):null},n}return Object(h.a)(t,e),Object(m.a)(t,[{key:"render",value:function(){var e=this.state;return e.isLoading?r.a.createElement(L,{className:"app-container"},r.a.createElement(S,null)):e.user&&E(e.user)?r.a.createElement(g.a,null,r.a.createElement(d.c,null,r.a.createElement(d.a,{exact:!0,path:"/",component:this.renderWorkLoggerMenu}),r.a.createElement(d.a,{exact:!0,path:"/show",component:this.renderWorkHoursTable}))):r.a.createElement(L,{className:"app-container menu auth"},r.a.createElement(O,{bannerMessage:this.state.bannerMessage}),r.a.createElement(A,null),r.a.createElement(B,null))}}]),t}(r.a.Component);s.a.render(r.a.createElement(Y,null),document.querySelector("#root"))}},[[34,1,2]]]);
//# sourceMappingURL=main.ff074ac1.chunk.js.map