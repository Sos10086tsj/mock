mock.homepageItem = {
	//顶部信息框
	initNorthPanel : function(){
		var north = Ext.create('Ext.Component', {
            region: 'north',
            height: 32,
            contentEl : 'js_global_north',
            autoEl: {
                tag: 'div',
                html:'<p>系统目前为测试版本，有问题请联系 407414976@qq.com.</p>'
            }
        });
		return north;
	},
	
	//左侧菜单
	initWestPanel : function(){
		var menuItems = new Array();
		//获取菜单
		$.ajax({
			url : ctx + '/menu',
			type : 'get',
			async: false,
			success : function(response){
				var menus = JSON.parse(response);
				
				$(menus).each(function(k,v){
					var subMenuBtns = new Array();
					$(v.subMenus).each(function(subK, subV){
						var btn = Ext.create('Ext.Button', {
						    text: subV.name,
						    handler: function() {
						        var comp = Ext.getCmp('js_global_tab_panel');
						        
						        var openTab = Ext.getCmp('js_tab_' + subV.code);
						        if(typeof openTab == 'undefined' || openTab.length == 0){
						        	openTab = Ext.create('Ext.tab.Tab', {
							        	id : 'js_tab_' + subV.code,
							        	title: subV.name,
							        	closable: true,
							        	loader: { 
							        		url : ctx + subV.url, 
							        		loadMask: 'loading...', 
							        		autoLoad: true, 
							        		scripts: true 
							        		},
							        	listeners: { 
							        		activate: function(tab){ 
							        			tab.loader.load(); 
							        		} 
							        	}
							        });
						        	 comp.add(openTab);
						        }
						        comp.setActiveTab(openTab);

						    }
						});
						subMenuBtns.push(btn);
					});
					
					//每个1级菜单创建一个panel
					var menuItem = Ext.create('Ext.form.Panel', {
						title : v.name,
						width: 180,
			            collapsible: true,
						items : [
						        Ext.create('Ext.menu.Menu', {
						        plain: true,
						        floating: false,  // usually you want this set to True (default)
						        items: subMenuBtns
						        }) 
						]
					});
					menuItems.push(menuItem);
				});
			},
			failure : function(error){
				Ext.MessageBox.alert('提醒', '无法获取客户菜单！');
			}
		});
		
		var west = Ext.create("Ext.form.Panel",{
			region: 'west',
            stateId: 'navigation-panel',
            id: 'west-panel',
            title: '菜单',
            split: true,
            width: 200,
            minWidth: 175,
            maxWidth: 400,
            collapsible: true,
            animCollapse: true,
            margins: '0 0 0 5',
            layout: 'accordion',
            dockedItems: {
                itemId: 'toolbar',
                xtype: 'toolbar',
                dock: 'left',
                items: menuItems
            }
        });
		return west;
	},
	
	//中间tab
	initCenterPanel : function(){
		var tabPanel = Ext.create('Ext.tab.Panel', {
			id : 'js_global_tab_panel',
		    renderTo: 'js_global_center',
		    region: 'center',
		    activeTab: 0,
		    items: [{
		        title: '首页',
		        contentEl: 'js_global_homepage_description'
		    }]
		});
		return tabPanel;
	},
	
	//底部
	initSouthPanel : function(){
		var south = Ext.create("Ext.form.Panel",{
			region: 'south',
            contentEl: 'js_global_south',
            split: true,
            height: 100,
            minSize: 100,
            maxSize: 200,
            collapsible: true,
            collapsed: true,
            title: 'South',
            margins: '0 0 0 0'
        });
		return south;
	},
	
	//右侧
	initEastPanel : function(){
		var east = Ext.create("Ext.form.Panel",{
			region: 'east',
            contentEl: 'js_global_east',
            split: true,
            height: 100,
            minSize: 100,
            maxSize: 200,
            collapsible: true,
            collapsed: true,
            title: '扩展栏',
            margins: '0 0 0 0'
        });
		return east;
	}
};