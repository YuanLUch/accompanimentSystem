!function(e){"use strict";"function"==typeof define&&define.amd?define(["jquery","./grid.base"],e):e(jQuery)}(function(N){"use strict";N.jgrid.extend({setTreeNode:function(u,G){return this.each(function(){var t=this;if(t.grid&&t.p.treeGrid){var e,r,i,d,a,s=t.p.expColInd,l=t.p.treeReader.expanded_field,n=t.p.treeReader.leaf_field,p=t.p.treeReader.level_field,o=t.p.treeReader.icon_field,h=t.p.treeReader.loaded,f=N.jgrid.styleUI[t.p.styleUI||"jQueryUI"].common,c=u;for(N(t).triggerHandler("jqGridBeforeSetTreeNode",[c,G]),N.jgrid.isFunction(t.p.beforeSetTreeNode)&&t.p.beforeSetTreeNode.call(t,c,G);u<G;){var g=N.jgrid.stripPref(t.p.idPrefix,t.rows[u].id),g=t.p._index[g],g=t.p.data[g];"nested"!==t.p.treeGridModel||g[n]||(i=parseInt(g[t.p.treeReader.left_field],10),e=parseInt(g[t.p.treeReader.right_field],10),g[n]=e===i+1?"true":"false",t.rows[u].cells[t.p._treeleafpos].innerHTML=g[n]),e=parseInt(g[p],10),i=0===t.p.tree_root_level?(r=e+1,e):(r=e)-1,d="<div class='tree-wrap tree-wrap-"+t.p.direction+"' style='width:"+18*r+"px;'>",d+="<div style='"+("rtl"===t.p.direction?"right:":"left:")+18*i+"px;' class='"+f.icon_base+" ",void 0!==g[h]&&("true"===g[h]||!0===g[h]?g[h]=!0:g[h]=!1),a="true"===g[n]||!0===g[n]?(d+=(void 0!==g[o]&&""!==g[o]?g[o]:t.p.treeIcons.leaf)+" tree-leaf treeclick",g[n]=!0,"leaf"):(g[n]=!1,""),g[l]=("true"===g[l]||!0===g[l])&&(g[h]||void 0===g[h]),!1===g[l]?d+=!0===g[n]?"'":t.p.treeIcons.plus+" tree-plus treeclick'":d+=!0===g[n]?"'":t.p.treeIcons.minus+" tree-minus treeclick'",d+="></div></div>",N(t.rows[u].cells[s]).wrapInner("<span class='cell-wrapper"+a+"'></span>").prepend(d),e===parseInt(t.p.tree_root_level,10)||N(t).jqGrid("isVisibleNode",g)||N(t.rows[u]).css("display","none"),N(t.rows[u].cells[s]).find("div.treeclick").on("click",function(e){e=e.target||e.srcElement,e=N.jgrid.stripPref(t.p.idPrefix,N(e,t.rows).closest("tr.jqgrow")[0].id),e=t.p._index[e];return t.p.data[e][n]||(t.p.data[e][l]?(N(t).jqGrid("collapseRow",t.p.data[e]),N(t).jqGrid("collapseNode",t.p.data[e])):(N(t).jqGrid("expandRow",t.p.data[e]),N(t).jqGrid("expandNode",t.p.data[e]))),!1}),!0===t.p.ExpandColClick&&N(t.rows[u].cells[s]).find("span.cell-wrapper").css("cursor","pointer").on("click",function(e){var e=e.target||e.srcElement,e=N.jgrid.stripPref(t.p.idPrefix,N(e,t.rows).closest("tr.jqgrow")[0].id),r=t.p._index[e];return t.p.data[r][n]||(t.p.data[r][l]?(N(t).jqGrid("collapseRow",t.p.data[r]),N(t).jqGrid("collapseNode",t.p.data[r])):(N(t).jqGrid("expandRow",t.p.data[r]),N(t).jqGrid("expandNode",t.p.data[r]))),N(t).jqGrid("setSelection",e),!1}),u++}N(t).triggerHandler("jqGridAfterSetTreeNode",[c,G]),N.jgrid.isFunction(t.p.afterSetTreeNode)&&t.p.afterSetTreeNode.call(t,c,G)}})},setTreeGrid:function(){return this.each(function(){var e,r,t,i,d=this,a=0,s=!1,l=[],n=N.jgrid.styleUI[d.p.styleUI||"jQueryUI"].treegrid;if(d.p.treeGrid){for(t in d.p.treedatatype||N.extend(d.p,{treedatatype:d.p.datatype}),d.p.loadonce&&(d.p.treedatatype="local"),d.p.subGrid=!1,d.p.altRows=!1,d.p.treeGrid_bigData||(d.p.pgbuttons=!1,d.p.pginput=!1,d.p.rowList=[]),d.p.gridview=!0,null!==d.p.rowTotal||d.p.treeGrid_bigData||(d.p.rowNum=1e4),d.p.multiselect=!1,d.p.expColInd=0,e=n.icon_plus,"jQueryUI"===d.p.styleUI&&(e+="rtl"===d.p.direction?"w":"e"),d.p.treeIcons=N.extend({plus:e,minus:n.icon_minus,leaf:n.icon_leaf},d.p.treeIcons||{}),"nested"===d.p.treeGridModel?d.p.treeReader=N.extend({level_field:"level",left_field:"lft",right_field:"rgt",leaf_field:"isLeaf",expanded_field:"expanded",loaded:"loaded",icon_field:"icon"},d.p.treeReader):"adjacency"===d.p.treeGridModel&&(d.p.treeReader=N.extend({level_field:"level",parent_id_field:"parent",leaf_field:"isLeaf",expanded_field:"expanded",loaded:"loaded",icon_field:"icon"},d.p.treeReader)),d.p.colModel)if(d.p.colModel.hasOwnProperty(t))for(i in(r=d.p.colModel[t].name)!==d.p.ExpandColumn||s||(s=!0,d.p.expColInd=a),a++,r!==d.p.treeReader.level_field&&r!==d.p.treeReader.left_field&&r!==d.p.treeReader.right_field||(d.p.colModel[t].sorttype="integer"),d.p.treeReader)d.p.treeReader.hasOwnProperty(i)&&d.p.treeReader[i]===r&&l.push(r);N.each(d.p.treeReader,function(e,r){r&&-1===N.inArray(r,l)&&("leaf_field"===e&&(d.p._treeleafpos=a),a++,d.p.colNames.push(r),d.p.colModel.push({name:r,width:1,hidden:!0,sortable:!1,resizable:!1,hidedlg:!0,editable:!0,search:!1}))})}})},expandRow:function(s){this.each(function(){var e,r,t,i,d,a=this;a.p.treeGrid_bigData||(e=a.p.lastpage),a.grid&&a.p.treeGrid&&(r=N(a).jqGrid("getNodeChildren",s),t=a.p.treeReader.expanded_field,i=s[a.p.localReader.id],!1===(d=(d=void 0===(d=N(a).triggerHandler("jqGridBeforeExpandTreeGridRow",[i,s,r]))?!0:d)&&N.jgrid.isFunction(a.p.beforeExpandTreeGridRow)?a.p.beforeExpandTreeGridRow.call(a,i,s,r):d)||(N(r).each(function(){var e=a.p.idPrefix+N.jgrid.getAccessor(this,a.p.localReader.id);N(N(a).jqGrid("getGridRowById",e)).css("display",""),this[t]&&N(a).jqGrid("expandRow",this)}),N(a).triggerHandler("jqGridAfterExpandTreeGridRow",[i,s,r]),N.jgrid.isFunction(a.p.afterExpandTreeGridRow)&&a.p.afterExpandTreeGridRow.call(a,i,s,r),a.p.treeGrid_bigData)||(a.p.lastpage=e))})},collapseRow:function(a){this.each(function(){var e,r,t,i,d=this;d.grid&&d.p.treeGrid&&(e=N(d).jqGrid("getNodeChildren",a),r=d.p.treeReader.expanded_field,t=a[d.p.localReader.id],!1!==(i=(i=void 0===(i=N(d).triggerHandler("jqGridBeforeCollapseTreeGridRow",[t,a,e]))?!0:i)&&N.jgrid.isFunction(d.p.beforeCollapseTreeGridRow)?d.p.beforeCollapseTreeGridRow.call(d,t,a,e):i))&&(N(e).each(function(){var e=d.p.idPrefix+N.jgrid.getAccessor(this,d.p.localReader.id);N(N(d).jqGrid("getGridRowById",e)).css("display","none"),this[r]&&N(d).jqGrid("collapseRow",this)}),N(d).triggerHandler("jqGridAfterCollapseTreeGridRow",[t,a,e]),N.jgrid.isFunction(d.p.afterCollapseTreeGridRow))&&d.p.afterCollapseTreeGridRow.call(d,t,a,e)})},getRootNodes:function(){var d=[];return this.each(function(){var e,r,t=this,i=t.p.data;if(t.grid&&t.p.treeGrid)switch(t.p.treeGridModel){case"nested":e=t.p.treeReader.level_field,N(i).each(function(){parseInt(this[e],10)===parseInt(t.p.tree_root_level,10)&&d.push(this)});break;case"adjacency":r=t.p.treeReader.parent_id_field,N(i).each(function(){null!==this[r]&&"null"!==String(this[r]).toLowerCase()||d.push(this)})}}),d},getNodeDepth:function(r){var t=null;return this.each(function(){if(this.grid&&this.p.treeGrid)switch(this.p.treeGridModel){case"nested":var e=this.p.treeReader.level_field;t=parseInt(r[e],10)-parseInt(this.p.tree_root_level,10);break;case"adjacency":t=N(this).jqGrid("getNodeAncestors",r).length}}),t},getNodeParent:function(h){var f=null;return this.each(function(){var e=this;if(e.grid&&e.p.treeGrid)switch(e.p.treeGridModel){case"nested":var r=e.p.treeReader.left_field,t=e.p.treeReader.right_field,i=e.p.treeReader.level_field,d=parseInt(h[r],10),a=parseInt(h[t],10),s=parseInt(h[i],10);N(this.p.data).each(function(){if(parseInt(this[i],10)===s-1&&parseInt(this[r],10)<d&&parseInt(this[t],10)>a)return f=this,!1});break;case"adjacency":for(var l=e.p.treeReader.parent_id_field,n=e.p.localReader.id,p=h[n],o=e.p._index[p];o--;)if(String(e.p.data[o][n])===String(N.jgrid.stripPref(e.p.idPrefix,h[l]))){f=e.p.data[o];break}}}),f},getNodeChildren:function(f){var c=[];return this.each(function(){var e=this;if(e.grid&&e.p.treeGrid){var r,t=this.p.data.length;switch(e.p.treeGridModel){case"nested":for(var i=e.p.treeReader.left_field,d=e.p.treeReader.right_field,a=e.p.treeReader.level_field,s=parseInt(f[i],10),l=parseInt(f[d],10),n=parseInt(f[a],10),p=0;p<t;p++)(r=e.p.data[p])&&parseInt(r[a],10)===n+1&&parseInt(r[i],10)>s&&parseInt(r[d],10)<l&&c.push(r);break;case"adjacency":var o=e.p.treeReader.parent_id_field,h=e.p.localReader.id;for(p=0;p<t;p++)(r=e.p.data[p])&&String(r[o])===String(N.jgrid.stripPref(e.p.idPrefix,f[h]))&&c.push(r)}}}),c},getFullTreeNode:function(h,f){var c=[];return this.each(function(){var r,t,i,d=this,a=d.p.treeReader.expanded_field;if(d.grid&&d.p.treeGrid)switch(null!=f&&"boolean"==typeof f||(f=!1),d.p.treeGridModel){case"nested":var e=d.p.treeReader.left_field,s=d.p.treeReader.right_field,l=d.p.treeReader.level_field,n=parseInt(h[e],10),p=parseInt(h[s],10),o=parseInt(h[l],10);N(this.p.data).each(function(){parseInt(this[l],10)>=o&&parseInt(this[e],10)>=n&&parseInt(this[e],10)<=p&&(f&&(this[a]=!0),c.push(this))});break;case"adjacency":h&&(c.push(h),t=d.p.treeReader.parent_id_field,i=d.p.localReader.id,N(this.p.data).each(function(e){for(r=c.length,e=0;e<r;e++)if(String(N.jgrid.stripPref(d.p.idPrefix,c[e][i]))===String(this[t])){f&&(this[a]=!0),c.push(this);break}}))}}),c},getNodeAncestors:function(r,t,i){var d=[];return void 0===t&&(t=!1),this.each(function(){if(this.grid&&this.p.treeGrid){i=void 0!==i&&this.p.treeReader.expanded_field;for(var e=N(this).jqGrid("getNodeParent",r);e;){if(i)try{e[i]=!0}catch(e){}t?d.unshift(e):d.push(e),e=N(this).jqGrid("getNodeParent",e)}}}),d},isVisibleNode:function(t){var i=!0;return this.each(function(){var e,r;this.grid&&this.p.treeGrid&&(e=N(this).jqGrid("getNodeAncestors",t),r=this.p.treeReader.expanded_field,N(e).each(function(){if(!(i=i&&this[r]))return!1}))}),i},isNodeLoaded:function(i){var d;return this.each(function(){var e,r,t=this;t.grid&&t.p.treeGrid&&(e=t.p.treeReader.leaf_field,r=t.p.treeReader.loaded,d=void 0!==i&&(void 0!==i[r]?i[r]:!!(i[e]||0<N(t).jqGrid("getNodeChildren",i).length)))}),d},setLeaf:function(d,a,s){return this.each(function(){var e=N.jgrid.getAccessor(d,this.p.localReader.id),r=N("#"+e,this.grid.bDiv)[0],t=this.p.treeReader.leaf_field;try{var i=this.p._index[e];null!=i&&(this.p.data[i][t]=a)}catch(e){}!0===a?N("div.treeclick",r).removeClass(this.p.treeIcons.minus+" tree-minus "+this.p.treeIcons.plus+" tree-plus").addClass(this.p.treeIcons.leaf+" tree-leaf"):!1===a&&(e=this.p.treeIcons.minus+" tree-minus",s&&(e=this.p.treeIcons.plus+" tree-plus"),N("div.treeclick",r).removeClass(this.p.treeIcons.leaf+" tree-leaf").addClass(e))})},reloadNode:function(o,h){return this.each(function(){var e,r,t,i,d,a,s,l,n,p;this.grid&&this.p.treeGrid&&(r=this.p.localReader.id,e=this.p.selrow,N(this).jqGrid("delChildren",o[r]),(h=void 0===h?!1:h)||jQuery._data(this,"events").jqGridAfterSetTreeNode||N(this).on("jqGridAfterSetTreeNode.reloadNode",function(){var e,r,t=this.p.treeReader.leaf_field;this.p.reloadnode&&(e=this.p.reloadnode,r=N(this).jqGrid("getNodeChildren",e),e[t]&&r.length?N(this).jqGrid("setLeaf",e,!1):e[t]||0!==r.length||N(this).jqGrid("setLeaf",e,!0)),this.p.reloadnode=!1}),r=this.p.treeReader.expanded_field,t=this.p.treeReader.parent_id_field,i=this.p.treeReader.loaded,d=this.p.treeReader.level_field,a=this.p.treeReader.leaf_field,s=this.p.treeReader.left_field,l=this.p.treeReader.right_field,n=N.jgrid.getAccessor(o,this.p.localReader.id),p=N("#"+n,this.grid.bDiv)[0],o[r]=!0,o[a]||N("div.treeclick",p).removeClass(this.p.treeIcons.plus+" tree-plus").addClass(this.p.treeIcons.minus+" tree-minus"),this.p.treeANode=p.rowIndex,this.p.datatype=this.p.treedatatype,this.p.reloadnode=o,h&&(this.p.treeANode=0<p.rowIndex?p.rowIndex-1:1,N(this).jqGrid("delRowData",n)),"nested"===this.p.treeGridModel?N(this).jqGrid("setGridParam",{postData:{nodeid:n,n_left:o[s],n_right:o[l],n_level:o[d]}}):N(this).jqGrid("setGridParam",{postData:{nodeid:n,parentid:o[t],n_level:o[d]}}),N(this).trigger("reloadGrid"),o[i]=!0,"nested"===this.p.treeGridModel?N(this).jqGrid("setGridParam",{selrow:e,postData:{nodeid:"",n_left:"",n_right:"",n_level:""}}):N(this).jqGrid("setGridParam",{selrow:e,postData:{nodeid:"",parentid:"",n_level:""}}))})},expandNode:function(o){return this.each(function(){var e,r,t,i,d,a,s,l,n,p;this.grid&&this.p.treeGrid&&(e=this.p.treeReader.expanded_field,r=this.p.treeReader.parent_id_field,t=this.p.treeReader.loaded,i=this.p.treeReader.level_field,d=this.p.treeReader.left_field,a=this.p.treeReader.right_field,o[e]||(s=N.jgrid.getAccessor(o,this.p.localReader.id),l=N("#"+this.p.idPrefix+N.jgrid.jqID(s),this.grid.bDiv)[0],n=this.p._index[s],!1!==(p=(p=void 0===(p=N(this).triggerHandler("jqGridBeforeExpandTreeGridNode",[s,o]))?!0:p)&&N.jgrid.isFunction(this.p.beforeExpandTreeGridNode)?this.p.beforeExpandTreeGridNode.call(this,s,o):p)&&(N(this).jqGrid("isNodeLoaded",this.p.data[n])?(o[e]=!0,N("div.treeclick",l).removeClass(this.p.treeIcons.plus+" tree-plus").addClass(this.p.treeIcons.minus+" tree-minus")):this.grid.hDiv.loading||(o[e]=!0,N("div.treeclick",l).removeClass(this.p.treeIcons.plus+" tree-plus").addClass(this.p.treeIcons.minus+" tree-minus"),this.p.treeANode=l.rowIndex,this.p.datatype=this.p.treedatatype,"nested"===this.p.treeGridModel?N(this).jqGrid("setGridParam",{postData:{nodeid:s,n_left:o[d],n_right:o[a],n_level:o[i]}}):N(this).jqGrid("setGridParam",{postData:{nodeid:s,parentid:o[r],n_level:o[i]}}),N(this).trigger("reloadGrid"),o[t]=!0,"nested"===this.p.treeGridModel?N(this).jqGrid("setGridParam",{postData:{nodeid:"",n_left:"",n_right:"",n_level:""}}):N(this).jqGrid("setGridParam",{postData:{nodeid:"",parentid:"",n_level:""}})),N(this).triggerHandler("jqGridAfterExpandTreeGridNode",[s,o]),N.jgrid.isFunction(this.p.afterExpandTreeGridNode))&&this.p.afterExpandTreeGridNode.call(this,s,o)))})},collapseNode:function(d){return this.each(function(){var e,r,t,i;this.grid&&this.p.treeGrid&&(e=this.p.treeReader.expanded_field,d[e])&&(r=N.jgrid.getAccessor(d,this.p.localReader.id),t=N("#"+this.p.idPrefix+N.jgrid.jqID(r),this.grid.bDiv)[0],(i=void 0===(i=N(this).triggerHandler("jqGridBeforeCollapseTreeGridNode",[r,d]))?!0:i)&&N.jgrid.isFunction(this.p.beforeCollapseTreeGridNode)&&(i=this.p.beforeCollapseTreeGridNode.call(this,r,d)),(d[e]=!1)!==i)&&(N("div.treeclick",t).removeClass(this.p.treeIcons.minus+" tree-minus").addClass(this.p.treeIcons.plus+" tree-plus"),N(this).triggerHandler("jqGridAfterCollapseTreeGridNode",[r,d]),N.jgrid.isFunction(this.p.afterCollapseTreeGridNode))&&this.p.afterCollapseTreeGridNode.call(this,r,d)})},SortTree:function(o,h,f,c){return this.each(function(){if(this.grid&&this.p.treeGrid){var e,r,t,i,d,a=[],s=this,l=N(this).jqGrid("getRootNodes",s.p.search),l=N.jgrid.from.call(this,l);for(Boolean(s.p.sortTreeByNodeType)&&(d=s.p.sortTreeNodeOrder&&"desc"===s.p.sortTreeNodeOrder.toLowerCase()?"d":"a",l.orderBy(s.p.treeReader.leaf_field,d,f,c)),l.orderBy(o,h,f,c),e=0,r=(i=l.select()).length;e<r;e++)t=i[e],a.push(t),N(this).jqGrid("collectChildrenSortTree",a,t,o,h,f,c);var n=N(this).jqGrid("getDataIDs"),p=1;N.each(a,function(e){var r=N.jgrid.getAccessor(this,s.p.localReader.id);-1!==N.inArray(r,n)&&(N("#"+N.jgrid.jqID(s.p.id)+" tbody tr").eq(p).after(N("#"+N.jgrid.jqID(s.p.id)+" tbody tr#"+N.jgrid.jqID(r))),p++)}),i=l=null}})},searchTree:function(t){var i,d,a,s,l,n,p,o=t.length||0,h=[],f=[],c=[];return this.each(function(){if(this.grid&&this.p.treeGrid&&o)for(i=this.p.localReader.id,p=0;p<o;p++){var e;if(h=N(this).jqGrid("getNodeAncestors",t[p],!0,!0),Boolean(this.p.FullTreeSearchResult)?(e=N(this).jqGrid("getFullTreeNode",t[p],!0),h=h.concat(e)):h.push(t[p]),d=h[0][i],-1!==N.inArray(d,f))for(l=0,a=h.length;l<a;l++){var r=!1;for(n=0,s=c.length;n<s;n++)if(h[l][i]===c[n][i]){r=!0;break}r||c.push(h[l])}else f.push(d),c=c.concat(h)}}),c},collectChildrenSortTree:function(a,s,l,n,p,o){return this.each(function(){if(this.grid&&this.p.treeGrid){var e,r,t,i,d=N(this).jqGrid("getNodeChildren",s,this.p.search),d=N.jgrid.from.call(this,d);for(d.orderBy(l,n,p,o),e=0,r=(i=d.select()).length;e<r;e++)t=i[e],a.push(t),N(this).jqGrid("collectChildrenSortTree",a,t,l,n,p,o)}})},setTreeRow:function(e,r){var t=!1;return this.each(function(){this.grid&&this.p.treeGrid&&(t=N(this).jqGrid("setRowData",e,r))}),t},delTreeNode:function(h){return this.each(function(){var e,r,t,i=this,d=i.p.localReader.id,a=i.p.treeReader.left_field,s=i.p.treeReader.right_field;if(i.grid&&i.p.treeGrid){h=N.jgrid.stripPref(i.p.idPrefix,h);var l=i.p._index[h];if(void 0!==l){var n,p=(n=parseInt(i.p.data[l][s],10))-parseInt(i.p.data[l][a],10)+1,o=N(i).jqGrid("getFullTreeNode",i.p.data[l]);if(0<o.length)for(e=0;e<o.length;e++)N(i).jqGrid("delRowData",i.p.idPrefix+o[e][d]);if("nested"===i.p.treeGridModel){if((r=N.jgrid.from.call(i,i.p.data).greater(a,n,{stype:"integer"}).select()).length)for(t in r)r.hasOwnProperty(t)&&(r[t][a]=parseInt(r[t][a],10)-p);if((r=N.jgrid.from.call(i,i.p.data).greater(s,n,{stype:"integer"}).select()).length)for(t in r)r.hasOwnProperty(t)&&(r[t][s]=parseInt(r[t][s],10)-p)}}}})},delChildren:function(h){return this.each(function(){var e,r,t=this,i=t.p.localReader.id,d=t.p.treeReader.left_field,a=t.p.treeReader.right_field;if(t.grid&&t.p.treeGrid){h=N.jgrid.stripPref(t.p.idPrefix,h);var s=t.p._index[h];if(void 0!==s){var l,n=(l=parseInt(t.p.data[s][a],10))-parseInt(t.p.data[s][d],10)+1,p=N(t).jqGrid("getFullTreeNode",t.p.data[s]);if(0<p.length)for(var o=0;o<p.length;o++)p[o][i]!==h&&N(t).jqGrid("delRowData",t.p.idPrefix+p[o][i]);if("nested"===t.p.treeGridModel){if((e=N.jgrid.from(t.p.data).greater(d,l,{stype:"integer"}).select()).length)for(r in e)e.hasOwnProperty(r)&&(e[r][d]=parseInt(e[r][d],10)-n);if((e=N.jgrid.from(t.p.data).greater(a,l,{stype:"integer"}).select()).length)for(r in e)e.hasOwnProperty(r)&&(e[r][a]=parseInt(e[r][a],10)-n)}}}})},addChildNode:function(e,r,t,i){var d=this[0];if(t){var a,s=d.p.treeReader.expanded_field,l=d.p.treeReader.leaf_field,n=d.p.treeReader.level_field,p=d.p.treeReader.parent_id_field,o=d.p.treeReader.left_field,h=d.p.treeReader.right_field,f=d.p.treeReader.loaded,c=0,g=r;if(void 0===i&&(i=!1),null==e){if(0<=(q=d.p.data.length-1))for(;0<=q;)c=Math.max(c,parseInt(d.p.data[q][d.p.localReader.id],10)),q--;e=c+1}var u,G,j=N(d).jqGrid("getInd",r),v=!1;if(null==r||""===r)g=r=null,R="last",w=d.p.tree_root_level,q=d.p.data.length+1;else{var _,R="after",I=N.jgrid.stripPref(d.p.idPrefix,r),I=d.p._index[I],w=(r=(_=d.p.data[I])[d.p.localReader.id],parseInt(_[n],10)+1),x=N(d).jqGrid("getFullTreeNode",_),q=x.length?(g=q=x[x.length-1][d.p.localReader.id],N(d).jqGrid("getInd",d.p.idPrefix+g)):N(d).jqGrid("getInd",d.p.idPrefix+r);if(_[l]&&(_[s]=v=!0,N(d.rows[j]).find("span.cell-wrapperleaf").removeClass("cell-wrapperleaf").addClass("cell-wrapper").end().find("div.tree-leaf").removeClass(d.p.treeIcons.leaf+" tree-leaf").addClass(d.p.treeIcons.minus+" tree-minus"),d.p.data[I][l]=!1,_[f]=!0),!1===q)throw"Parent item with id: "+g+" ("+r+") can't be found";q++}if(x=q+1,void 0===t[s]&&(t[s]=!1),void 0===t[f]&&(t[f]=!1),t[n]=w,void 0===t[l]&&(t[l]=!0),"adjacency"===d.p.treeGridModel&&(t[p]=r),"nested"===d.p.treeGridModel)if(null!==r){if(a=parseInt(_[h],10),(u=N.jgrid.from.call(d,d.p.data).greaterOrEquals(h,a,{stype:"integer"}).select()).length)for(G in u)u.hasOwnProperty(G)&&(u[G][o]=u[G][o]>a?parseInt(u[G][o],10)+2:u[G][o],u[G][h]=u[G][h]>=a?parseInt(u[G][h],10)+2:u[G][h]);t[o]=a,t[h]=a+1}else{if(a=parseInt(N(d).jqGrid("getCol",h,!1,"max"),10),(u=N.jgrid.from.call(d,d.p.data).greater(o,a,{stype:"integer"}).select()).length)for(G in u)u.hasOwnProperty(G)&&(u[G][o]=parseInt(u[G][o],10)+2);if((u=N.jgrid.from.call(d,d.p.data).greater(h,a,{stype:"integer"}).select()).length)for(G in u)u.hasOwnProperty(G)&&(u[G][h]=parseInt(u[G][h],10)+2);t[o]=a+1,t[h]=a+2}(null===r||N(d).jqGrid("isNodeLoaded",_)||v)&&(N(d).jqGrid("addRowData",e,t,R,d.p.idPrefix+g),N(d).jqGrid("setTreeNode",q,x)),_&&!_[s]&&i&&N(d.rows[j]).find("div.treeclick").click()}}})});