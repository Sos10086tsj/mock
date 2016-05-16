mock.card = {
	popUpWindow : null,
	fenqiWindow : null,
	repaymentWindow : null,
	init : function(){
		var store = mock.cardItem.initStore();
		var grid =Ext.create('Ext.grid.Panel', {
//			width: 700,
//	        height: 500,
	        title: '卡片信息管理',
	        store: store,
	        frame: true,
	        loadMask: true,
	        renderTo: 'js_card_panel',
	        columns: [
	            {
	            	header: '账号',
	            	dataIndex: 'accno'
	            },
	            {
	            	header: '主卡卡号',
	            	dataIndex: 'mdcardno'
	            },
	            {
	            	header: '客户编号',
	            	dataIndex: 'cino'
	            },
	            {
	            	header: '帐户本金',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'lstpbal',
	            	format: '¥0,0'
	            },
	            {
	            	header: '昨日余额',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'lstbal',
	            	format: '¥0,0'
	            },
	            {
	            	header: '帐单应还款金额',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'acpayamt',
	            	format: '¥0,0'
	            },
	            {
	            	header: '昨日最优还款额',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'dtopamt',
	            	format: '¥0,0'
	            },
	            {
	            	header: '最低还款额',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'letpaamt',
	            	format: '¥0,0'
	            },
	            {
	            	header: '表内利息',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'lstiint',
	            	format: '¥0,0'
	            },
	            {
	            	header: '表外利息',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'lstoint',
	            	format: '¥0,0'
	            },
	            {
	            	header: '表外滞纳金',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'lstlfee',
	            	format: '¥0,0'
	            },
	            {
	            	header: '滞纳金连续收取次数',
	            	dataIndex: 'lfeegno'
	            },
	            {
	            	header: '最后客户交易日',
	            	dataIndex: 'lsttrand'
	            },
	            {
	            	text:"查看分期",
	                align:"center",
	                dataIndex: 'mdcardno',
	                renderer:function(value,cellmeta,record){
	                  var returnStr = '<a href="javascript:void(0);" onclick="mock.card.openFqTab(\'' + value + '\')">查看分期</a>';
	                  return returnStr;
	                }
	            }
	        ],
	        tbar : [
	            {
	            	xtype: 'combo',
		        	listConfig:{
		        		emptyText:'未找到匹配值',  
		        		loadingText: '正在查找...',
             			maxHeight:180
		        	},
		        	minChars:6,
             		queryDelay:200,
             		name:'mdcardno',
             		fieldLabel:'卡号',
             		displayField:'label',
             		valueField:'value',
             		queryMode:'remote',
             		hideTrigger: true,
             		typeAhead:true,
             		forceSelection:true,
             		store : mock.cardItem.mdcardnoStore(),
             		listeners:{
             			select:function(combo,record,opts) {
             				var mdcardno = record[0].get("value");
             				mock.card.reload(store,mdcardno);
             			}
             		}
	            },
	            '-',
	            {
	                text: '开卡',
	                iconCls: 'employee-add',
	                handler : function() {
	                	mock.card.showEditWindow('开卡','', store)
	                }
	            },
	            '-',
	            {
	            	text: '开始分期',
	            	iconCls: 'employee-add',
	                handler : function() {
	                	mock.card.showFenqiWindow();
	                }
	            },
	            '-',
	            {
	            	text: '还款',
	            	iconCls: 'employee-add',
	                handler : function() {
	                	mock.card.showPaymentWindow();
	                }
	            }
	        ],
	        bbar: Ext.create('Ext.PagingToolbar', {
	            store: store,
	            displayInfo: true,
	            displayMsg: 'Displaying topics {0} - {1} of {2}',
	            emptyMsg: "No topics to display"
	        }),
	        listeners : {
	        	itemdblclick: function(tablepanel, record, item, index, e, options){
	        		mock.card.showEditWindow('修改',record, store);
		        }
	        }
		});
		
		store.loadPage(1);
	},
	
	showPaymentWindow : function(){
		var editForm = Ext.create('Ext.form.Panel', {
		    bodyPadding: 5,
		    url: ctx + '/card/repayment',
		    layout: 'anchor',
		    defaults: {
		        anchor: '100%'
		    },
		    defaultType: 'textfield',
		    items: [
		            {
		            	fieldLabel: '卡号',
		            	name: 'cardNo',
		            	allowBlank: false,
		            	value : '622233'
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '还款金额',
		            	name: 'repayment',
		            	allowBlank: false,
		            	value : 0
		            }
		         ],
		         buttons: [{
				        text: '重置',
				        handler: function() {
				            this.up('form').getForm().reset();
				        },
				        disabled : true
				    }, {
				        text: '提交',
				        handler: function() {
				            var form = this.up('form').getForm();
				            if (form.isValid()) {
				            	form.submit({
				                    success: function(form, action) {
				                       mock.warningResult("提示","保存成功！");
				                       mock.card.repaymentWindow.close();
				                    },
				                    failure: function(form, action) {
				                        mock.warningResult("提示","保存失败！");
				                    }
				                });
				            }
				        }
				    }]
		});
		mock.card.repaymentWindow = new Ext.Window({
    		title: '卡片分期',
            items: [
                    editForm
            ]
    	});
		mock.card.repaymentWindow.show();
	},
	
	showFenqiWindow : function(){
		var editForm = Ext.create('Ext.form.Panel', {
		    bodyPadding: 5,
		    url: ctx + '/card/initFenqi',
		    layout: 'anchor',
		    defaults: {
		        anchor: '100%'
		    },
		    defaultType: 'textfield',
		    items: [
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '贷款金额(分)',
		            	allowDecimals:false,
		            	name: 'amount',
		            	allowBlank: false
		            },
		            {
		            	fieldLabel: '卡号',
		            	name: 'cardNo',
		            	id : 'js_card_fenqi_cardNo',
		            	allowBlank: false,
		            	value : '622233'
		            },
		            {
		            	fieldLabel: '分期日期',
		            	name: 'creditDate',
		            	allowBlank: false,
		            	xtype: 'datefield',
		            	format : 'Y-m-d'
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '期数',
		            	name: 'period',
		            	allowBlank: false,
		            	value : 0
		            },
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '费率',
		            	decimalPrecision: 2,
		            	name: 'ratio',
		            	allowBlank: false,
		            	value : 0.00
		            }
		         ],
		         buttons: [{
				        text: '重置',
				        handler: function() {
				            this.up('form').getForm().reset();
				        },
				        disabled : true
				    }, {
				        text: '提交',
				        handler: function() {
				            var form = this.up('form').getForm();
				            if (form.isValid()) {
				            	//检查卡号是否存在
				            	if(mock.card.cardNoExist(Ext.getCmp('js_card_fenqi_cardNo').getValue())){
				            		return false;
				            	}else{
				            		form.submit({
					                    success: function(form, action) {
					                       mock.warningResult("提示","保存成功！");
					                       mock.card.fenqiWindow.close();
					                    },
					                    failure: function(form, action) {
					                        mock.warningResult("提示","保存失败！");
					                    }
					                });
				            	}
				            }
				        }
				    }]
		});
		mock.card.fenqiWindow = new Ext.Window({
    		title: '卡片分期',
            items: [
                    editForm
            ]
    	});
		mock.card.fenqiWindow.show();
	},
	
	cardNoExist : function(cardNo){
		Ext.Ajax.request({
		    url: ctx + '/card/checkCardNo',
		    timeout: 60000,
		    async:false,
		    params: {
		    	cardNo: cardNo
		    },
		    success: function(response){
		    	var result = Ext.JSON.decode(response.responseText);
		    	if(result.errorMsg != null){
		    		mock.warningResult("提示",result.errorMsg);
		    		return true;
		    	}else{
		    		return false;
		    	}
		    },
		    failure: function(form, action) {
		    	return true;
		    }
		});
	},
	
	showEditWindow : function(title,record, store){
		mock.card.popUpWindow = new Ext.Window({
    		title: '卡片管理',
//    		width: 600,
//            minHeight: 400,
            items: [
                   mock.card.showEditForm(title,record, store)
            ]
    	});
		mock.card.popUpWindow.show();
	},
	
	showEditForm : function(title, record, store){
		var id = '' == record ? '' : record.get('id');
		var version = '' == record ? 0 : record.get('version');
		var bankId = '' == record ? 2 : record.get('bankId');
		var accno = '' == record ? '' : record.get('accno');
		var mdcardno = '' == record ? '' : record.get('mdcardno');
		var cino = '' == record ? '' : record.get('cino');
		var lstpbal = '' == record ? 0 : record.get('lstpbal');
		var lstbal = '' == record ? 0 : record.get('lstbal');
		var acpayamt = '' == record ? 0 : record.get('acpayamt');
		var dtopamt = '' == record ? 0 : record.get('dtopamt');
		var letpaamt = '' == record ? 0 : record.get('letpaamt');
		var lstiint = '' == record ? 0 : record.get('lstiint');
		var lstoint = '' == record ? 0 : record.get('lstoint');
		var lstlfee = '' == record ? 0 : record.get('lstlfee');
		var lfeegno = '' == record ? 0 : record.get('lfeegno');
		var lsttrand = '' == record ? new Date() : new Date(record.get('lsttrand'));
		
		var editForm = Ext.create('Ext.form.Panel', {
		    title: title,
		    bodyPadding: 5,
		    url: ctx + '/card/update',
		    layout: 'anchor',
		    defaults: {
		        anchor: '100%'
		    },
		    defaultType: 'textfield',
		    items: [
		            {
		            	fieldLabel: 'ID',
		            	name: 'id',
		            	hidden: true,
		            	value : id
		            },
		            {
		            	fieldLabel: 'version',
		            	name: 'version',
		            	hidden: true,
		            	value : version
		            },
		            {
		            	fieldLabel: 'BankId',
		            	name: 'bankId',
		            	hidden: true,
		            	value : bankId
		            },
		            {
		            	fieldLabel: '账号',
		            	name: 'accno',
		            	allowBlank: false,
		            	value : accno
		            },
		            {
		            	fieldLabel: '主卡卡号',
		            	name: 'mdcardno',
		            	allowBlank: false,
		            	value : mdcardno
		            },
		            {
		            	fieldLabel: '客户编号',
		            	name: 'cino',
		            	allowBlank: false,
		            	value : cino
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '帐户本金',
		            	name: 'lstpbal',
		            	allowBlank: false,
		            	value : lstpbal
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '昨日余额',
		            	name: 'lstbal',
		            	allowBlank: false,
		            	value : lstbal
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '帐单应还款金额',
		            	name: 'acpayamt',
		            	allowBlank: false,
		            	value : acpayamt
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '昨日最优还款额',
		            	name: 'dtopamt',
		            	allowBlank: false,
		            	value : dtopamt
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '最低还款额',
		            	name: 'letpaamt',
		            	allowBlank: false,
		            	value : letpaamt
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '表内利息',
		            	name: 'lstiint',
		            	allowBlank: false,
		            	value : lstiint
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '表外利息',
		            	name: 'lstoint',
		            	allowBlank: false,
		            	value : lstoint
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '表外滞纳金',
		            	name: 'lstlfee',
		            	allowBlank: false,
		            	value : lstlfee
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '滞纳金连续收取次数',
		            	name: 'lfeegno',
		            	allowBlank: false,
		            	value : lfeegno
		            },
		            {
		            	fieldLabel: '最后交易日',
		            	name: 'lsttrand',
		            	allowBlank: false,
		            	xtype: 'datefield',
		            	format : 'Y-m-d',
		            	value : lsttrand
//		            	maxValue: new Date()
		            }
		            ],
		    buttons: [{
		        text: '重置',
		        handler: function() {
		            this.up('form').getForm().reset();
		        },
		        disabled : true
		    }, {
		        text: '提交',
//		        formBind: true,
//		        disabled: true,
		        handler: function() {
		            var form = this.up('form').getForm();
		            if (form.isValid()) {
		                form.submit({
		                    success: function(form, action) {
		                       mock.warningResult("提示","保存成功！");
		                       mock.card.popUpWindow.close();
		                       store.reload();
		                    },
		                    failure: function(form, action) {
		                        mock.warningResult("提示","保存失败！");
		                    }
		                });
		            }
		        }
		    }]
		});
		return editForm;
	},
	
	reload : function(store, mdcardno){
		var url = ctx + '/card/store?mdcardno=' + mdcardno;
		store.proxy.url = url;
		store.reload();
	},
	
	openFqTab : function(mdcardno){
		var comp = Ext.getCmp('js_global_tab_panel');
		var openTab = Ext.getCmp('js_tab_' + 'TEST3');
		if(typeof openTab == 'undefined' || openTab.length == 0){
        	openTab = Ext.create('Ext.tab.Tab', {
	        	id : 'js_tab_' + 'TEST3',
	        	title: '分期管理',
	        	closable: true,
	        	loader: { 
	        		url : ctx + '/cardFq?mdcardno=' + mdcardno, 
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
        }else{
        	openTab.loader.url = ctx + '/cardFq?mdcardno=' + mdcardno;
        }
        comp.setActiveTab(openTab);
	}
};

$(function(){
	Ext.require(['Ext.grid.*',
	             'Ext.data.*',
	             'Ext.util.*',
	             'Ext.state.*',
	             'Ext.form.*',
    			 'Ext.window.MessageBox',
    			 'Ext.toolbar.Paging',
    			 'Ext.ux.PreviewPlugin',
    			 'Ext.ModelManager',
    			 'Ext.tip.QuickTipManager']);
	
	Ext.onReady(function () {
		Ext.QuickTips.init();
		mock.card.init();
	}); 
});