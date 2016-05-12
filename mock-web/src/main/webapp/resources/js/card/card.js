mock.card = {
	popUpWindow : null,
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
	            	 header: 'ID#',
	            	 dataIndex: 'id',
	            	 hidden : true
	            },
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