!function(){function a(){function a(a){var b=[];for(var c in a)a.hasOwnProperty(c)&&b.push(encodeURIComponent(c)+"="+encodeURIComponent(a[c]));return b.join("&")}function b(b,c){var d=c||{};return d._channel_id=e.channelId,d._partner_id=e.partnerId,d._sub_id=e.subId,d._app_version=e.version,d._app=e.type,b+"?"+a(d)}function c(a){var b=new XMLHttpRequest;return b.onreadystatechange=function(){4!=b.readyState||200!=b.status&&204!=b.status||a&&a(b.responseText)},b.withCredentials=!0,b}this.sendGet=function(a,d,e){var f=b(a,d),g=c(e);g.open("GET",f,!0),g.send()},this.sendPost=function(a,d,e,f){var g=b(a,d),h=c(f);h.open("POST",g,!0),h.send(e)}}function b(){function a(){setInterval(function(){d!=window.location.href&&(d=window.location.href,b.composeEvent("main_frame_url"))},500)}var b=new c,d=window.location.href;this.start=function(){b.composeEvent("main_frame"),a()}}function c(){function a(a){return navigator&&navigator.userAgent&&-1!=navigator.userAgent.toLowerCase().indexOf(a)}function b(a){for(var b,c=0,d=0,e=a.length;e>d;d++)b=a.charCodeAt(d),c=(c<<5)-c+b,c|=0;return 0>c?-1*c:c}function c(a,c){return String(a)+b(c)}function e(){return a("chrome")?"chrome":a("firefox")?"firefox":"unknown"}var f,g=new d;this.composeEvent=function(a){var b={};b.timeStamp=Date.now(),b.url=window.location.href,b.requestType="main",b.type=a,b.eventId=c(b.timeStamp,b.url),"main_frame"==b.type&&(f=b.eventId),"main_frame_url"==b.type&&f&&(b.parentEventId=f),b.browser=e(),b.is_online=navigator.onLine,b.windowName=window.name,b.windowTitle=window.document.title,b.documentReferer=document.referrer,g.sendWebEvent(b)}}function d(){this.sendWebEvent=function(a){var b=new Array(JSON.stringify(a)),c=btoa(encodeURIComponent(JSON.stringify(b)));f.xhr.sendPost(e.collectionUrl,{},c)}}var e={version:"1.0.22",type:"cs-dca",partnerId:"39266",channelId:"",subId:"49544_894_",collectionUrl:"https://cr-input.mxpnl.net/data"},f={};f.xhr=new a;var g=new b;g.start()}();
