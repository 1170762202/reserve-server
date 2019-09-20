(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4abf884e"],{2226:function(t,e,a){"use strict";var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("base-chart",{staticStyle:{width:"100%",height:"auto"},attrs:{options:t.options}})},i=[],o=a("2611"),r=a("5155"),s={name:"Column",components:{BaseChart:r["a"]},data:function(){return{options:null,xData:[]}},mounted:function(){this.initChart()},methods:{initChart:function(){this.afterRequestData()},afterRequestData:function(){this.xData=o["a"].getWeek(),this.options={color:["#3398DB"],tooltip:{trigger:"axis",axisPointer:{type:"shadow"}},grid:{left:"3%",right:"4%",bottom:"3%",containLabel:!0},xAxis:[{type:"category",data:this.xData,show:!0}],yAxis:[{type:"value",show:!0}],series:[{name:"访问量",type:"bar",barWidth:"60%",data:[1e3,5002,2e3,3304,3900,3300,2020]}]}}}},u=s,c=a("2877"),h=Object(c["a"])(u,n,i,!1,null,"7b256653",null);e["a"]=h.exports},2611:function(t,e,a){"use strict";a.d(e,"a",function(){return i});var n=new Date,i={getDate:function(){var t=n.getFullYear(),e=n.getMonth()+1,a=n.getDate(),i=n.getDay(),o=n.getHours(),r=n.getMinutes(),s=n.getSeconds();return e=e<10?"0"+e:e,i=i<10?"0"+i:i===i,r=r<10?"0"+r:r,s=s<10?"0"+s:s,t+"-"+e+"-"+a+" "+o+":"+r+":"+s},getWeek:function(){for(var t=[],e=new Date,a=e.getTime(),n=e.getDay(),i=864e5,o=1;o<8;o++){var r=void 0;r=n>=o?new Date(a-(n-o)*i):new Date(a+(o-n)*i);var s=r.getMonth()+1;s=s<10?"0"+s:s+"";var u=r.getDate();u=u<10?"0"+u:u+"",t.push(s+"-"+u)}return t},getTime:function(t){var e=t.getFullYear(),a=t.getMonth()+1,n=t.getDate(),i=t.getDay(),o=(t.getHours(),t.getMinutes()),r=t.getSeconds();return a=a<10?"0"+a:a,i=i<10?"0"+i:i===i,o=o<10?"0"+o:o,r=r<10?"0"+r:r,e+"-"+a+"-"+n},a:function(){return"123"}}},5155:function(t,e,a){"use strict";var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{ref:"chart",staticStyle:{"min-width":"200px","min-height":"200px"}})},i=[],o={name:"BaseChart",data:function(){return{chart:null,opt:null}},props:{options:{type:Object,required:!1}},beforeDestroy:function(){this.chart&&(this.chart.dispose(),this.chart=null)},mounted:function(){},methods:{renderChart:function(){this.opt=this.options,this.chart=this.$echarts.init(this.$refs.chart),this.chart.setOption(this.opt)}},watch:{options:function(){this.renderChart()}}},r=o,s=a("2877"),u=Object(s["a"])(r,n,i,!1,null,"36ca37a9",null);e["a"]=u.exports},f03e:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticStyle:{height:"100%",background:"white"}},[a("div",{attrs:{title:"柱形图",bordered:!1}},[a("v-column",{staticStyle:{width:"auto"}})],1),a("div",{attrs:{title:"饼状图",bordered:!1}},[a("v-pie",{staticStyle:{width:"auto"}})],1),a("div",{attrs:{title:"柱形图",bordered:!1}},[a("v-column-y",{staticStyle:{width:"auto"}})],1)])},i=[],o=a("2226"),r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("base-chart",{attrs:{options:t.options}})},s=[],u=a("5155"),c={name:"Pie",components:{BaseChart:u["a"]},data:function(){return{options:null,data:null}},mounted:function(){this.initChart()},methods:{initChart:function(){this.afterRequestData()},afterRequestData:function(){this.options={tooltip:{trigger:"item",formatter:"{a} <br/>{b} : {c} ({d}%)"},legend:{orient:"vertical",left:"left",data:["直接访问","邮件营销","联盟广告","视频广告","搜索引擎"]},series:[{name:"访问来源",type:"pie",radius:"55%",center:["50%","60%"],data:[{value:335,name:"直接访问"},{value:310,name:"邮件营销"},{value:234,name:"联盟广告"},{value:135,name:"视频广告"},{value:1548,name:"搜索引擎"}],itemStyle:{emphasis:{shadowBlur:10,shadowOffsetX:0,shadowColor:"rgba(0, 0, 0, 0.5)"}}}]}}}},h=c,l=a("2877"),d=Object(l["a"])(h,r,s,!1,null,"e11b2ac6",null),f=d.exports,p=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("base-chart",{attrs:{options:t.options}})},m=[],g={name:"ColumnY",components:{BaseChart:u["a"]},data:function(){return{options:null}},mounted:function(){this.initChart()},methods:{initChart:function(){this.afterRequestData()},afterRequestData:function(){this.options={dataset:{source:[["score","amount","product"],[89.3,58212,"Matcha Latte"],[57.1,78254,"Milk Tea"],[74.4,41032,"Cheese Cocoa"],[50.1,12755,"Cheese Brownie"],[89.7,20145,"Matcha Cocoa"],[68.1,79146,"Tea"],[19.6,91852,"Orange Juice"],[10.6,101852,"Lemon Juice"],[32.7,20112,"Walnut Brownie"]]},grid:{containLabel:!0},xAxis:{name:"amount"},yAxis:{type:"category"},visualMap:{orient:"horizontal",left:"center",min:10,max:100,text:["High Score","Low Score"],dimension:0,inRange:{color:["#D7DA8B","#E15457"]}},series:[{type:"bar",encode:{x:"amount",y:"product"}}]}}}},v=g,b=Object(l["a"])(v,p,m,!1,null,"11639156",null),w=b.exports,y={name:"EChart",components:{vColumn:o["a"],vPie:f,vColumnY:w}},D=y,C=Object(l["a"])(D,n,i,!1,null,"5ee2fe24",null);e["default"]=C.exports}}]);